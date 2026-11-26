package cn.longzhengyi.windowsdecoration.windowdrag

import androidx.compose.ui.geometry.Rect
import cn.longzhengyi.windowsdecoration.windowhelper.BorderlessWindowHelper
import cn.longzhengyi.windowsdecoration.windowhelper.skialayer.SkiaLayerWindowProcedure
import cn.longzhengyi.windowsdecoration.windowhelper.utils.acquireWndProcOwnership
import cn.longzhengyi.windowsdecoration.windowhelper.utils.releaseWndProcOwnership
import cn.longzhengyi.windowsdecoration.windowhelper.win32.*
import cn.longzhengyi.windowsdecoration.windowhelper.win32.RECT
import com.sun.jna.Callback
import com.sun.jna.CallbackReference
import com.sun.jna.Native
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.WinDef.*
import org.jetbrains.skiko.SkiaLayer
import java.util.concurrent.ConcurrentHashMap
import java.util.logging.Logger
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

/**
 * 纯窗口拖动助手。把指定区域交给 Windows 当作标题栏，从而获得**系统原生**的窗口拖动。
 *
 * 与 Compose 官方 `WindowDraggableArea` 的区别：官方实现在 `awaitFirstDown()` 之后
 * 切换到 AWT 的 `Window.addMouseMotionListener` + `MouseInfo.getPointerInfo()`，
 * 由 Java 侧逐帧 `window.setLocation()` 追赶光标。一旦光标被快速甩出窗口矩形，
 * AWT 不再派发 `mouseDragged`（`mouseReleased` 也可能丢失，导致监听器残留、拖拽状态卡死），
 * 窗口便停止跟手。
 *
 * 本实现不搬运任何鼠标事件：命中拖动区时向 `WM_NCHITTEST` 返回 [HTCAPTION]，
 * 之后整个拖动过程由系统 `DefWindowProc` 在 native 层接管，鼠标由系统捕获，
 * 不依赖 Java 事件派发，因此不存在"甩出窗口就丢事件"的问题。
 *
 * ### 职责边界
 *
 * 本类**只负责拖动**：
 * - 不修改任何窗口样式（不碰 `WS_CAPTION` / `WS_THICKFRAME` / `WS_SYSMENU`）
 * - 不处理 `WM_NCCALCSIZE` / `WM_GETMINMAXINFO`，不干预窗口尺寸与最大化几何
 * - 不提供阴影、圆角、边缘缩放
 * - **不保证 Aero Snap**（拖到屏幕边缘吸附半屏）。Aero Snap 由系统按窗口样式自行判定，
 *   本类不为此做任何样式调整。如需完整的原生窗口行为，请使用
 *   [cn.longzhengyi.windowsdecoration.BorderlessTitleBarScaffold]。
 *
 * ### 与 Compose 内置缩放器的关系
 *
 * 窗口缩放无需本类介入：Compose 在 `undecorated = true` 且 `resizable = true`（默认）时
 * 会启用内置的 `UndecoratedWindowResizer`，在窗口四边铺设厚度为
 * `WindowDecorationDefaults.ResizerThickness`（默认 8.dp）的不可见 resizer 自行处理缩放。
 *
 * 但两者在空间上重叠时，**本类优先**：Win32 命中测试发生在事件到达 Compose 之前，
 * 拖动区返回 [HTCAPTION] 后系统直接进入拖拽循环，鼠标事件根本不会派发给 Compose，
 * 该处的 resizer 因此失效。所以若拖动区贴着窗口边缘（例如顶部整条标题栏），
 * **那一侧的边缘缩放会不可用**。如需两者共存，请为拖动区留出边缘内边距。
 *
 * ### 用法
 *
 * 推荐通过 [rememberWindowDragHelper] 安装，再用 Modifier 标记区域：
 *
 * ```kotlin
 * Window(undecorated = true, transparent = true, ...) {
 *     val dragHelper = rememberWindowDragHelper()
 *
 *     Row(Modifier.fillMaxWidth().height(40.dp).dragWindowArea(dragHelper)) {
 *         Text("My App", Modifier.weight(1f))
 *         // 拖动区内的交互组件必须排除，否则点击会被窗口拖动吞掉
 *         IconButton(onClick = ..., modifier = Modifier.excludeFromWindowDrag(dragHelper)) { ... }
 *     }
 * }
 * ```
 *
 * ### 互斥约束
 *
 * 同一窗口只能安装一种窗口过程子类化实现。与 [BorderlessWindowHelper]
 * 同时安装会在 [install] 时抛出 [IllegalStateException]（由
 * [acquireWndProcOwnership] 检查）。
 *
 * @param jFrame 目标窗口
 * @param doubleClickToMaximize 是否保留系统在标题栏双击最大化/还原的默认行为。
 *   本类不管理最大化状态，若你的自绘 UI 没有还原入口，应传 `false` 禁用。
 *
 * @see rememberWindowDragHelper
 * @see dragWindowArea
 * @see excludeFromWindowDrag
 */
// ─── 实现原理 ───
// 拖动需要两层窗口过程协作，缺一不可：
// 1. JFrame 层：拦截 WM_NCHITTEST，命中拖动区返回 HTCAPTION，
//    系统据此在 WM_NCLBUTTONDOWN 时进入 DefWindowProc 的 SC_MOVE 模态拖拽循环。
// 2. SkiaLayer Canvas 层：Compose 内容绘制在 SkiaLayer 的 Canvas 子窗口上，
//    鼠标消息先落到它身上，父 JFrame 根本收不到 WM_NCHITTEST。
//    故需子类化 Canvas，对非客户区结果返回 HTTRANSPARENT 让消息穿透到父窗口。
//    该逻辑与无边框标题栏完全一致，直接复用 SkiaLayerWindowProcedure。
class WindowDragHelper(
    private val jFrame: JFrame,
    private val doubleClickToMaximize: Boolean = true,
) {
    private val user32 = User32Ex.INSTANCE

    private var hwnd: HWND? = null
    private var originalWndProc: Pointer? = null

    // JNA 回调对象必须被强引用持有，否则 JVM GC 回收后 native 回调指针悬空，引发进程崩溃
    @Suppress("unused")
    private var wndProcCallbackRef: WndProcCallback? = null

    private var installed = false
    private var skiaLayerProc: SkiaLayerWindowProcedure? = null
    private var skiaLayerTimer: Timer? = null

    // ─── 命中测试区域（由 Modifier 或区域注册 API 上报，窗口内像素坐标） ───
    private val dragAreas = ConcurrentHashMap<String, Rect>()
    private val excludeAreas = ConcurrentHashMap<String, Rect>()

    // ═══════════════════════════════════════════════════
    // 区域注册 API
    // ═══════════════════════════════════════════════════

    /**
     * 添加一个可拖动区域。支持多个，通过 [id] 区分。
     *
     * @param id 唯一标识符，用于后续更新或移除
     * @param rect 区域坐标（窗口内像素坐标）
     */
    fun addDragArea(id: String, rect: Rect) { dragAreas[id] = rect }

    /** 移除指定的可拖动区域。 */
    fun removeDragArea(id: String) { dragAreas.remove(id) }

    /** 清除所有可拖动区域。 */
    fun clearDragAreas() { dragAreas.clear() }

    /**
     * 添加一个排除区域（优先级高于拖动区域）。
     *
     * 落在拖动区内的交互组件（按钮、输入框、下拉菜单等）必须注册为排除区域，
     * 否则该处的鼠标事件会被系统的拖拽循环吞掉，Compose 收不到点击。
     *
     * @param id 唯一标识符，用于后续更新或移除
     * @param rect 区域坐标（窗口内像素坐标）
     */
    fun addExcludeArea(id: String, rect: Rect) { excludeAreas[id] = rect }

    /** 移除指定的排除区域。 */
    fun removeExcludeArea(id: String) { excludeAreas.remove(id) }

    /** 清除所有排除区域。 */
    fun clearExcludeAreas() { excludeAreas.clear() }

    // ═══════════════════════════════════════════════════
    // 安装 / 卸载
    // ═══════════════════════════════════════════════════

    /**
     * 安装拖动支持。必须在 EDT 线程上调用，且窗口已 displayable。
     *
     * 推荐使用 [rememberWindowDragHelper] 自动安装与卸载，无需手动调用。
     *
     * @throws IllegalStateException 重复安装，或该窗口已被其他实现子类化
     */
    fun install() {
        require(SwingUtilities.isEventDispatchThread()) { "Must be called on EDT" }
        require(jFrame.isDisplayable) { "JFrame must be displayable" }
        check(!installed) { "WindowDragHelper is already installed on this window" }
        installed = true

        val hWnd = HWND(Native.getComponentPointer(jFrame))
        hwnd = hWnd

        acquireWndProcOwnership(hWnd, "WindowDragHelper")

        val callback = object : WndProcCallback {
            override fun callback(hWnd: HWND, msg: Int, wParam: WPARAM, lParam: LPARAM): LRESULT {
                return handleMessage(hWnd, msg, wParam, lParam)
            }
        }
        wndProcCallbackRef = callback
        val callbackPointer = CallbackReference.getFunctionPointer(callback as Callback)
        originalWndProc = user32.SetWindowLongPtrW(hWnd, GWL_WNDPROC, callbackPointer)

        tryInstallSkiaLayerProcedure()
    }

    /**
     * 卸载拖动支持，还原两层窗口过程并清空已注册区域。重复调用安全。
     *
     * 必须在 EDT 线程上调用。
     */
    fun uninstall() {
        require(SwingUtilities.isEventDispatchThread()) { "Must be called on EDT" }
        if (!installed) return
        installed = false

        skiaLayerTimer?.stop()
        skiaLayerTimer = null

        skiaLayerProc?.uninstall()
        skiaLayerProc = null

        val hWnd = hwnd
        val original = originalWndProc
        if (hWnd != null && original != null) {
            user32.SetWindowLongPtrW(hWnd, GWL_WNDPROC, original)
            releaseWndProcOwnership(hWnd)
        }
        originalWndProc = null
        wndProcCallbackRef = null
        hwnd = null

        dragAreas.clear()
        excludeAreas.clear()
    }

    // ═══════════════════════════════════════════════════
    // SkiaLayer 子类化
    // ═══════════════════════════════════════════════════

    // Compose 首次渲染可能尚未完成，SkiaLayer 此时还不存在，因此轮询等待。
    // 相比只重试一次的做法更稳健：冷启动慢或窗口内容复杂时不会静默失败。
    private fun tryInstallSkiaLayerProcedure() {
        findSkiaLayer()?.let {
            installSkiaLayerProcedure(it)
            return
        }

        var attemptsLeft = SKIA_LAYER_LOOKUP_ATTEMPTS
        skiaLayerTimer = Timer(SKIA_LAYER_LOOKUP_INTERVAL_MS) { event ->
            if (!installed) {
                (event.source as Timer).stop()
                return@Timer
            }
            val layer = findSkiaLayer()
            if (layer != null) {
                (event.source as Timer).stop()
                skiaLayerTimer = null
                installSkiaLayerProcedure(layer)
            } else if (--attemptsLeft <= 0) {
                (event.source as Timer).stop()
                skiaLayerTimer = null
                // 未找到 SkiaLayer：拖动将不可用（Canvas 会吃掉鼠标消息，父窗口收不到 WM_NCHITTEST）。
                // 不抛异常：此处运行在 EDT 定时器回调中，抛出只会被 EDT 异常处理器吞掉。
                logger.severe(
                    "WindowDragHelper: 未能在窗口组件树中找到 SkiaLayer，窗口拖动不可用。 " +
                            "Failed to locate SkiaLayer, window dragging is unavailable."
                )
            }
        }.apply { isRepeats = true; start() }
    }

    // 复用 BorderlessWindowHelper 的组件树递归查找，避免重复实现
    private fun findSkiaLayer(): SkiaLayer? =
        BorderlessWindowHelper.findComponent(jFrame, SkiaLayer::class.java)

    private fun installSkiaLayerProcedure(skiaLayer: SkiaLayer) {
        // hitTest 只会返回 HTCLIENT 或 HTCAPTION：
        // HTCLIENT 命中 SkiaLayerWindowProcedure 的首个分支，由 Compose 正常处理；
        // HTCAPTION 落入 else 返回 HTTRANSPARENT，穿透到父 JFrame 触发原生拖拽。
        val proc = SkiaLayerWindowProcedure(
            skiaLayer = skiaLayer,
            hitTest = { x, y -> computeHitTest(x, y) },
        )
        proc.install()
        skiaLayerProc = proc
    }

    // ═══════════════════════════════════════════════════
    // 命中测试
    // ═══════════════════════════════════════════════════

    /** 命中测试优先级：排除区域 > 拖动区域 > 客户区 */
    private fun computeHitTest(x: Float, y: Float): Int = when {
        excludeAreas.values.any { it.contains(x, y) } -> HTCLIENT
        dragAreas.values.any { it.contains(x, y) } -> HTCAPTION
        else -> HTCLIENT
    }

    private fun Rect.contains(x: Float, y: Float): Boolean =
        x >= left && x < right && y >= top && y < bottom

    // 屏幕坐标 -> 窗口相对坐标 -> 命中测试
    private fun computeHitTestFromScreen(screenX: Int, screenY: Int): Int {
        val hWnd = hwnd ?: return HTCLIENT
        val windowRect = RECT()
        if (!user32.GetWindowRect(hWnd, windowRect)) return HTCLIENT

        return computeHitTest(
            (screenX - windowRect.left).toFloat(),
            (screenY - windowRect.top).toFloat(),
        )
    }

    // ═══════════════════════════════════════════════════
    // Win32 消息处理
    // ═══════════════════════════════════════════════════

    private fun handleMessage(hWnd: HWND, msg: Int, wParam: WPARAM, lParam: LPARAM): LRESULT {
        when (msg) {
            WM_NCHITTEST -> {
                val lp = lParam.toInt()
                val screenX = (lp and 0xFFFF).toShort().toInt()
                val screenY = ((lp shr 16) and 0xFFFF).toShort().toInt()
                return LRESULT(computeHitTestFromScreen(screenX, screenY).toLong())
            }

            WM_NCMOUSEMOVE -> {
                // 拖动区被系统视为非客户区，Compose 收不到 hover。
                // 转发给 Canvas（由 SkiaLayerWindowProcedure 转换为 WM_MOUSEMOVE），
                // 使拖动条自身的悬停效果仍然可用。
                skiaLayerProc?.let { user32.PostMessageW(it.contentHandle, msg, wParam, lParam) }
                return callOriginal(hWnd, msg, wParam, lParam)
            }

            WM_NCLBUTTONDBLCLK -> {
                // wParam 为命中测试结果。吞掉拖动区上的双击，阻止系统最大化/还原。
                if (!doubleClickToMaximize && wParam.toInt() == HTCAPTION) return LRESULT(0)
            }
        }

        return callOriginal(hWnd, msg, wParam, lParam)
    }

    private fun callOriginal(hWnd: HWND, msg: Int, wParam: WPARAM, lParam: LPARAM): LRESULT {
        val original = originalWndProc ?: return LRESULT(0)
        return user32.CallWindowProcW(original, hWnd, msg, wParam, lParam)
    }

    private companion object {
        val logger: Logger = Logger.getLogger("WindowDragHelper")

        const val SKIA_LAYER_LOOKUP_INTERVAL_MS = 100
        const val SKIA_LAYER_LOOKUP_ATTEMPTS = 50
    }
}
