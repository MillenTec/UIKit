package cn.longzhengyi.windowsdecoration.windowhelper.skialayer

import cn.longzhengyi.windowsdecoration.windowhelper.win32.*
import com.sun.jna.Callback
import com.sun.jna.CallbackReference
import com.sun.jna.Native
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.WinDef
import org.jetbrains.skiko.SkiaLayer

/**
 * SkiaLayer Canvas 窗口过程子类化，使 Compose 按钮在非客户区正常响应。
 *
 * 由 [cn.longzhengyi.windowsdecoration.windowhelper.BorderlessWindowHelper] 内部自动安装，外部无需直接使用。
 */
// ─── 实现原理 ───
// 当鼠标悬停在标题栏按钮区域（HTMAXBUTTON / HTMINBUTTON / HTCLOSE）时，
// 操作系统将这些区域视为非客户区，Compose 无法收到普通鼠标事件。
// 此过程将 WM_NCMOUSEMOVE / WM_NCLBUTTONDOWN / WM_NCLBUTTONUP 转发为
// WM_MOUSEMOVE / WM_LBUTTONDOWN / WM_LBUTTONUP，使 Compose 按钮正常工作。
//
// WM_NCHITTEST 处理：对按钮和客户区返回对应 HT 值，
// 对其他区域（标题栏、调整大小边框）返回 HTTRANSPARENT，使消息穿透到父窗口。
class SkiaLayerWindowProcedure(
    skiaLayer: SkiaLayer,
    private val hitTest: (x: Float, y: Float) -> Int,
) {
    private val user32 = User32Ex.INSTANCE

    private val windowHandle = WinDef.HWND(Pointer(skiaLayer.windowHandle))
    internal val contentHandle = WinDef.HWND(Native.getComponentPointer(skiaLayer.canvas))

    private var originalWndProc: Pointer? = null

    @Suppress("unused")
    private var callbackRef: WndProcCallback? = null

    fun install() {
        val callback = object : WndProcCallback {
            override fun callback(hWnd: WinDef.HWND, msg: Int, wParam: WinDef.WPARAM, lParam: WinDef.LPARAM): WinDef.LRESULT {
                return handleMessage(hWnd, msg, wParam, lParam)
            }
        }
        callbackRef = callback
        val ptr = CallbackReference.getFunctionPointer(callback as Callback)
        originalWndProc = user32.SetWindowLongPtrW(contentHandle, GWL_WNDPROC, ptr)
    }

    /**
     * 还原 Canvas 的原始窗口过程。重复调用安全。
     *
     * 仅当本过程仍是 Canvas 当前的窗口过程时才应调用，
     * 若之后又有其他实现子类化了同一 Canvas，还原会破坏其链路。
     */
    fun uninstall() {
        val original = originalWndProc ?: return
        user32.SetWindowLongPtrW(contentHandle, GWL_WNDPROC, original)
        originalWndProc = null
        callbackRef = null
    }

    private fun handleMessage(hWnd: WinDef.HWND, msg: Int, wParam: WinDef.WPARAM, lParam: WinDef.LPARAM): WinDef.LRESULT {
        when (msg) {
            WM_NCHITTEST -> {
                val hitResult = lParamToClientHitTest(lParam)
                return when (hitResult) {
                    HTCLIENT, HTMAXBUTTON, HTMINBUTTON, HTCLOSE -> WinDef.LRESULT(hitResult.toLong())
                    else -> WinDef.LRESULT(HTTRANSPARENT.toLong())
                }
            }

            WM_NCMOUSEMOVE -> {
                user32.SendMessageW(contentHandle, WM_MOUSEMOVE, wParam, lParam)
                return WinDef.LRESULT(0)
            }

            WM_NCLBUTTONDOWN -> {
                user32.SendMessageW(contentHandle, WM_LBUTTONDOWN, wParam, lParam)
                return WinDef.LRESULT(0)
            }

            WM_NCLBUTTONUP -> {
                user32.SendMessageW(contentHandle, WM_LBUTTONUP, wParam, lParam)
                return WinDef.LRESULT(0)
            }
        }

        return user32.CallWindowProcW(originalWndProc!!, hWnd, msg, wParam, lParam)
    }

    private fun lParamToClientHitTest(lParam: WinDef.LPARAM): Int {
        val lp = lParam.toInt()
        val screenX = (lp and 0xFFFF).toShort().toInt()
        val screenY = ((lp shr 16) and 0xFFFF).toShort().toInt()
        val point = WinDef.POINT(screenX, screenY)
        user32.ScreenToClient(windowHandle, point)
        point.read()
        return hitTest(point.x.toFloat(), point.y.toFloat())
    }
}
