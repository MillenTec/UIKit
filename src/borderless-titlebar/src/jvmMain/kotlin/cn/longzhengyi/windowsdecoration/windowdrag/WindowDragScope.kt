package cn.longzhengyi.windowsdecoration.windowdrag

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/**
 * 窗口拖动作用域，在 [WindowDragScaffold] 的 content 内可用。
 *
 * 作用域的意义在于免去到处传递 [helper]：区域标记 Modifier 在此作用域内
 * 有无参重载，可直接写 `Modifier.dragWindowArea()`。
 *
 * ```kotlin
 * WindowDragScaffold {
 *     Row(Modifier.fillMaxWidth().height(40.dp).dragWindowArea()) {
 *         Text("My App", Modifier.weight(1f))
 *         IconButton(onClick = ..., modifier = Modifier.excludeFromWindowDrag()) { ... }
 *     }
 * }
 * ```
 *
 * 作用域内的 Modifier 无法传递到子 composable 中使用。
 * 需要跨层级时，把 [helper] 传下去并使用同名的顶层 Modifier 扩展
 * （[cn.longzhengyi.windowsdecoration.windowdrag.dragWindowArea] 等）。
 *
 * 本作用域**不提供**最小化/最大化/还原等窗口操作，也不追踪窗口状态 ——
 * 这些不属于纯拖动模块的职责，需要时请使用
 * [cn.longzhengyi.windowsdecoration.BorderlessTitleBarScaffold]。
 *
 * @see WindowDragScaffold
 */
@Stable
class WindowDragScope internal constructor() {
    /**
     * 底层拖动助手。初始为 `null`，安装完成后自动变为非空。
     *
     * 需要在子 composable 中标记区域时，把它传给顶层 Modifier 扩展。
     */
    var helper: WindowDragHelper? by mutableStateOf(null)
        internal set

    /**
     * 标记此组件区域为可拖动区域。作用域内的便捷重载，等价于
     * `Modifier.dragWindowArea(helper, id)`。
     *
     * @param id 唯一标识符，默认为 `null`（自动分配）
     * @see cn.longzhengyi.windowsdecoration.windowdrag.dragWindowArea
     */
    fun Modifier.dragWindowArea(id: String? = null): Modifier =
        dragWindowArea(helper, id)

    /**
     * 标记此组件区域排除于窗口拖动之外。作用域内的便捷重载，等价于
     * `Modifier.excludeFromWindowDrag(helper, id)`。
     *
     * @param id 唯一标识符，默认为 `null`（自动分配）
     * @see cn.longzhengyi.windowsdecoration.windowdrag.excludeFromWindowDrag
     */
    fun Modifier.excludeFromWindowDrag(id: String? = null): Modifier =
        excludeFromWindowDrag(helper, id)
}
