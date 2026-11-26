package cn.longzhengyi.windowsdecoration.windowdrag

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.window.FrameWindowScope

/**
 * 窗口拖动脚手架。纯拖动模块中对标
 * [cn.longzhengyi.windowsdecoration.BorderlessTitleBarScaffold] 的入口。
 *
 * 自动安装 [WindowDragHelper]（退出 composition 时自动卸载），不预设任何布局。
 * 调用方在 [content] 中自由组织 UI，并通过 [WindowDragScope] 直接使用无参的
 * `Modifier.dragWindowArea()` / `Modifier.excludeFromWindowDrag()`，无需传递 helper。
 *
 * **注意**：[content] 中必须手动标记 [WindowDragScope.dragWindowArea]，否则窗口不可拖动。
 *
 * ```kotlin
 * Window(undecorated = true, transparent = true, ...) {
 *     WindowDragScaffold {
 *         Row(
 *             Modifier.fillMaxWidth()
 *                 .height(40.dp)
 *                 .dragWindowArea(),              // 标记拖动区
 *         ) {
 *             Text("My App", Modifier.weight(1f))
 *             IconButton(
 *                 onClick = onClose,
 *                 modifier = Modifier.excludeFromWindowDrag(),   // 排除交互组件
 *             ) { Icon(...) }
 *         }
 *     }
 * }
 * ```
 *
 * ### 与 BorderlessTitleBarScaffold 的取舍
 *
 * 二者互斥，同一窗口只能用其一（重复安装会抛 [IllegalStateException]）。
 *
 * - 只想要**比 Compose 官方 `WindowDraggableArea` 更可靠的拖动**，
 *   窗口装饰交给 Compose 默认行为 → 用本函数。
 * - 需要完整的原生窗口体验（阴影、Win11 圆角、Aero Snap、Snap Layout、
 *   边缘缩放、系统按钮、最大化状态追踪）→ 用
 *   [cn.longzhengyi.windowsdecoration.BorderlessTitleBarScaffold]。
 *
 * 本脚手架不提供 `minimize()` / `maximize()` / `isMaximized` 等能力，
 * 纯拖动模块不管理窗口状态。
 *
 * @param doubleClickToMaximize 是否保留系统在拖动区双击最大化/还原的默认行为。
 *   本模块不管理窗口状态，若你的 UI 没有还原入口，应传 `false`。
 * @param content 内容，拥有 [WindowDragScope] 接收者
 *
 * @see WindowDragScope
 * @see rememberWindowDragHelper
 */
@Composable
fun FrameWindowScope.WindowDragScaffold(
    doubleClickToMaximize: Boolean = true,
    content: @Composable WindowDragScope.() -> Unit,
) {
    val helper = rememberWindowDragHelper(doubleClickToMaximize)
    val scope = remember { WindowDragScope() }

    LaunchedEffect(helper) { scope.helper = helper }

    scope.content()
}
