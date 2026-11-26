package cn.longzhengyi.windowsdecoration.windowhelper.utils

import com.sun.jna.Pointer
import com.sun.jna.platform.win32.WinDef.HWND
import java.util.concurrent.ConcurrentHashMap

/**
 * 窗口过程（WndProc）子类化归属登记表。
 *
 * 本库存在多个会调用 `SetWindowLongPtrW(GWL_WNDPROC, ...)` 的实现
 * （[cn.longzhengyi.windowsdecoration.windowhelper.BorderlessWindowHelper]、
 * [cn.longzhengyi.windowsdecoration.windowdrag.WindowDragHelper]）。
 * 对同一个 HWND 安装两套子类化会导致：
 * - 后装者把先装者的过程指针当作“原始过程”保存，形成隐式链；
 * - 任一方卸载时把 WndProc 还原到错误的指针，链断裂，窗口消息行为异常甚至崩溃。
 *
 * 因此在安装前必须先登记归属，重复安装直接 fail-fast 给出明确错误，
 * 而不是留到运行期表现为难以定位的怪异行为。
 */
private val ownedWindows = ConcurrentHashMap<Long, String>()

/**
 * 登记 [hWnd] 的窗口过程归属。
 *
 * @param owner 占用者名称，仅用于错误信息
 * @throws IllegalStateException 该窗口已被其他实现子类化
 */
internal fun acquireWndProcOwnership(hWnd: HWND, owner: String) {
    val key = Pointer.nativeValue(hWnd.pointer)
    val existing = ownedWindows.putIfAbsent(key, owner)
    check(existing == null) {
        "该窗口的过程已被 '$existing' 子类化，无法再安装 '$owner'。" +
                "同一窗口只能使用一种窗口过程子类化实现，请勿混用。 " +
                "Window procedure is already subclassed by '$existing', cannot install '$owner'."
    }
}

/**
 * 释放 [hWnd] 的窗口过程归属。卸载时调用，允许后续重新安装。
 */
internal fun releaseWndProcOwnership(hWnd: HWND) {
    ownedWindows.remove(Pointer.nativeValue(hWnd.pointer))
}
