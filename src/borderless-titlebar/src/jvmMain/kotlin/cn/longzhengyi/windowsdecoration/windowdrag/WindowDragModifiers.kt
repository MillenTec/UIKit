package cn.longzhengyi.windowsdecoration.windowdrag

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.window.FrameWindowScope
import cn.longzhengyi.windowsdecoration.windowhelper.utils.generateAutoId
import java.util.logging.Logger
import javax.swing.SwingUtilities

private val logger = Logger.getLogger("WindowDragHelper")
private val osName: String = System.getProperty("os.name").lowercase()

/**
 * 在 Compose Window 作用域内创建并安装 [WindowDragHelper]，提供系统原生的窗口拖动。
 *
 * 返回值初始为 `null`（安装在 EDT 线程异步完成），完成后自动触发重组。
 * [dragWindowArea] 与 [excludeFromWindowDrag] 均安全接受 `null`，无需额外判空。
 * 组件退出 composition 时自动卸载（还原窗口过程）。
 *
 * 非 Windows 平台返回 `null`，所有 Modifier 退化为无操作。
 *
 * ```kotlin
 * Window(undecorated = true, transparent = true, ...) {
 *     val dragHelper = rememberWindowDragHelper()
 *
 *     Row(Modifier.fillMaxWidth().height(40.dp).dragWindowArea(dragHelper)) {
 *         Text("My App", Modifier.weight(1f))
 *         IconButton(onClick = ..., modifier = Modifier.excludeFromWindowDrag(dragHelper)) { ... }
 *     }
 * }
 * ```
 *
 * **不要**与 [cn.longzhengyi.windowsdecoration.BorderlessTitleBarScaffold] 或
 * [cn.longzhengyi.windowsdecoration.windowhelper.rememberBorderlessWindowHelper]
 * 用于同一窗口：同一窗口只能安装一种窗口过程子类化实现，否则安装时抛出
 * [IllegalStateException]。需要完整原生窗口行为（阴影、圆角、缩放）请改用后者。
 *
 * @param doubleClickToMaximize 是否保留系统在拖动区双击最大化/还原的默认行为。
 *   本模块不管理窗口状态，若你的 UI 没有还原入口，应传 `false`。
 *
 * @see WindowDragHelper
 */
@Composable
fun FrameWindowScope.rememberWindowDragHelper(
    doubleClickToMaximize: Boolean = true,
): WindowDragHelper? {
    if ("windows" !in osName) {
        LaunchedEffect(Unit) {
            logger.warning(
                "rememberWindowDragHelper: 暂不支持 '$osName' 平台，窗口拖动不可用。 " +
                        "platform '$osName' is not supported, window dragging is unavailable."
            )
        }
        return null
    }

    val helperState = remember { mutableStateOf<WindowDragHelper?>(null) }

    DisposableEffect(doubleClickToMaximize) {
        val jFrame = window
        val helper = WindowDragHelper(jFrame, doubleClickToMaximize)
        SwingUtilities.invokeLater {
            helper.install()
            helperState.value = helper
        }
        onDispose {
            helperState.value = null
            SwingUtilities.invokeLater { helper.uninstall() }
        }
    }

    return helperState.value
}

/**
 * 标记此组件区域为可拖动区域。支持多个，通过 [id] 区分。
 *
 * 命中该区域时窗口进入系统原生拖拽循环。区域内的交互组件必须用
 * [excludeFromWindowDrag] 排除，否则其鼠标事件会被拖拽循环吞掉。
 * 组件退出 composition 时自动注销对应区域。
 *
 * **注意**：[id] 在所有使用本 Modifier 的组件间必须唯一，
 * 重复的 id 会导致区域互相覆盖，其中一个组件移除时会连带注销另一个的区域。
 *
 * @param helper 由 [rememberWindowDragHelper] 提供，为 `null` 时本 Modifier 无操作
 * @param id 唯一标识符，默认为 `null`（自动分配）
 */
fun Modifier.dragWindowArea(
    helper: WindowDragHelper?,
    id: String? = null,
): Modifier =
    if (helper != null) composed {
        val resolvedId = id ?: remember { generateAutoId("drag") }
        DisposableEffect(helper, resolvedId) { onDispose { helper.removeDragArea(resolvedId) } }
        onGloballyPositioned { helper.addDragArea(resolvedId, it.boundsInWindow()) }
    } else this

/**
 * 标记此组件区域排除于窗口拖动之外（优先级高于 [dragWindowArea]）。
 *
 * 落在拖动区内的按钮、输入框、下拉菜单等交互组件必须使用本 Modifier，
 * 否则点击会触发窗口拖动而非组件交互。
 * 组件退出 composition 时自动注销对应区域。
 *
 * **注意**：[id] 在所有使用本 Modifier 的组件间必须唯一，
 * 重复的 id 会导致区域互相覆盖，其中一个组件移除时会连带注销另一个的区域。
 *
 * @param helper 由 [rememberWindowDragHelper] 提供，为 `null` 时本 Modifier 无操作
 * @param id 唯一标识符，默认为 `null`（自动分配）
 */
fun Modifier.excludeFromWindowDrag(
    helper: WindowDragHelper?,
    id: String? = null,
): Modifier =
    if (helper != null) composed {
        val resolvedId = id ?: remember { generateAutoId("drag-exclude") }
        DisposableEffect(helper, resolvedId) { onDispose { helper.removeExcludeArea(resolvedId) } }
        onGloballyPositioned { helper.addExcludeArea(resolvedId, it.boundsInWindow()) }
    } else this
