package com.millentec.compose.uikit.symbols

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.draw.*

/**
 * 可以继承此类以创建一个 UIKitSymbol
 * @param name 图标名称
 * @param defaultSize 默认尺寸
 * @param viewportSize 视口尺寸, 在绘制内容时使用的相对尺寸, 内容将会基于此尺寸进行绘制
 */
abstract class UIKitSymbol(
    val name: String,
    val defaultSize: DpSize,
    val viewportSize: Size,
) {
    /**
     * 图标的各个分层
     */
    abstract val layers: List<UIKitSymbolLayer>

    /**
     * 图标各层的颜色集
     */
    @Composable
    abstract fun colorSet(
        style: UIKitSymbolStyle,
        states: List<Pair<String, UIKitSymbolGroupState>>
    ): List<UIKitSymbolColor>

    private var _groupsCache: List<UIKitSymbolPathGroup>? = null

    /**
     * 图标的所有组, 会依据 zIndex 升序排序
     */
    val groups: List<UIKitSymbolPathGroup>
        get() {
            if (_groupsCache == null) {
                val groups = mutableListOf<UIKitSymbolPathGroup>()
                layers.forEach { layer ->
                    groups += layer.groups
                }

                _groupsCache = groups.sortedBy {
                    it.zIndex
                }
            }

            return _groupsCache!!
        }

    /**
     * 可以将图标转换为 ImageVector, 部分信息可能会丢失
     */
    open fun toComposeVector(color: Color): ImageVector {
        return ImageVector.Builder(
            name = name,
            defaultWidth = defaultSize.width,
            defaultHeight = defaultSize.height,
            viewportWidth = viewportSize.width,
            viewportHeight = viewportSize.height,
        ).apply {
            groups.forEach { group ->
                path(
                    fill = if (group.drawType is UIKitPathDrawType.Fill) SolidColor(color) else null,
                    stroke = if (group.drawType is UIKitPathDrawType.Stroke) SolidColor(color) else null,
                ) {
                    group.path.nodes.forEach { node ->
                        when (node) {
                            UIKitPathNode.Close -> close()
                            is UIKitPathNode.CurveTo -> curveTo(
                                x1 = node.x1,
                                y1 = node.y1,
                                x2 = node.x2,
                                y2 = node.y2,
                                x3 = node.x3,
                                y3 = node.y3
                            )
                            is UIKitPathNode.LineTo -> lineTo(node.x, node.y)
                            is UIKitPathNode.MoveTo -> moveTo(node.x, node.y)
                        }
                    }
                }
            }
        }.build()
    }

    /**
     * 图标出现的效果, 你不应该尝试调用此方法, 而应该在子类中覆写此方法以供 `UIKitSymbolEffect` 使用, 基类中提供了部分默认动画
     * @param states 提供的当前动画信息, 你可以通过这里得到某个组当前是否可见以调整动画
     * @return 用于描述动画的动画树, 支持 `Parallel` 和 `Sequential` 节点, 如果返回 `null` 则表示不支持此动画
     */
    open fun appearEffect(
        states: List<UIKitSymbolAnimState>? = null
    ): UIKitSymbolAnimTree? {
        val tree = UIKitSymbolAnimTree()
        val filterGroups = groups.filter {
            if (states == null) true else {
                val state = states.firstOrNull { state -> state.id == it.id }
                state?.visible(
                    UIKitAnimSelector.entries.filter { item ->
                        item != UIKitAnimSelector.Scale && item != UIKitAnimSelector.Alpha
                    }
                ) ?: true
            }
        }
        val remainGroups = groups.filter {
            !filterGroups.contains(it)
        }

        filterGroups.sortedByDescending { it.zIndex }.forEachIndexed { index, group ->
            tree.addParallel(UIKitSymbolAnimNode.scaleTo(
                group.id,
                targetValue = 1f,
                animateSpec = tween(
                    260 / (groups.size + 1) * 2,
                    easing = CubicBezierEasing(0f, 0.62f, 0.38f, 1f),
                    delayMillis = index * 260 / (groups.size + 1)
                ),
            )).addParallel(UIKitSymbolAnimNode.alphaTo(
                group.id,
                targetValue = 1f,
                animateSpec = tween(
                    260 / (groups.size + 1) * 2,
                    easing = CubicBezierEasing(0f, 0.62f, 0.38f, 1f),
                    delayMillis = index * 260 / (groups.size + 1)
                )
            ))
        }

        remainGroups.forEach { group ->
            tree.addParallel(UIKitSymbolAnimNode.scaleTo(
                group.id,
                targetValue = 1f,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.alphaTo(
                group.id,
                targetValue = 1f,
                animateSpec = null
            ))
        }

        return tree
    }

    /**
     * 图标消失的效果, 你不应该尝试调用此方法, 而应该在子类中覆写此方法以供 `UIKitSymbolEffect` 使用, 基类中提供了部分默认动画
     * @param states 提供的当前动画信息, 你可以通过这里得到某个组当前是否可见以调整动画
     * @return 用于描述动画的动画树, 支持 `Parallel` 和 `Sequential` 节点, 如果返回 `null` 则表示不支持此动画
     */
    open fun disappearEffect(
        states: List<UIKitSymbolAnimState>? = null
    ): UIKitSymbolAnimTree? {
        val tree = UIKitSymbolAnimTree()
        val filterGroups = groups.filter {
            if (states == null) true else {
                val state = states.firstOrNull { state -> state.id == it.id }
                state?.visible ?: true
            }
        }
        val remainGroups = groups.filter {
            !filterGroups.contains(it)
        }

        filterGroups.forEachIndexed { index, group ->
            tree.addParallel(UIKitSymbolAnimNode.scaleTo(
                group.id,
                targetValue = 0.8f,
                animateSpec = tween(
                    260 / (filterGroups.size + 1) * 2,
                    easing = CubicBezierEasing(1f, 0.62f, 0.62f, 1f),
                    delayMillis = index * 260 / (groups.size + 1)
                ),
            )).addParallel(UIKitSymbolAnimNode.alphaTo(
                group.id,
                targetValue = 0f,
                animateSpec = tween(
                    260 / (filterGroups.size + 1) * 2,
                    easing = CubicBezierEasing(1f, 0.62f, 0.62f, 1f),
                    delayMillis = index * 260 / (groups.size + 1)
                )
            ))
        }

        remainGroups.forEach { group ->
            tree.addParallel(UIKitSymbolAnimNode.scaleTo(
                group.id,
                targetValue = 0f,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.alphaTo(
                group.id,
                targetValue = 0f,
                animateSpec = null
            ))
        }

        return tree
    }

    /**
     * 图标启用的效果, 你不应该尝试调用此方法, 而应该在子类中覆写此方法以供 `UIKitSymbolEffect` 使用, 基类中提供了部分默认动画
     * @param states 提供的当前动画信息, 你可以通过这里得到某个组当前是否可见以调整动画
     * @return 用于描述动画的动画树, 支持 `Parallel` 和 `Sequential` 节点, 如果返回 `null` 则表示不支持此动画
     */
    open fun enableEffect(
        states: List<UIKitSymbolAnimState>? = null
    ): UIKitSymbolAnimTree? {
        return null
    }

    /**
     * 图标禁用的效果, 你不应该尝试调用此方法, 而应该在子类中覆写此方法以供 `UIKitSymbolEffect` 使用, 基类中提供了部分默认动画
     * @param states 提供的当前动画信息, 你可以通过这里得到某个组当前是否可见以调整动画
     * @return 用于描述动画的动画树, 支持 `Parallel` 和 `Sequential` 节点, 如果返回 `null` 则表示不支持此动画
     */
    open fun disableEffect(
        states: List<UIKitSymbolAnimState>? = null
    ): UIKitSymbolAnimTree? {
        return null
    }
}

/**
 * UIKitSymbol 所提供的一个兼容层, 如果你传入 `UIKitIcon` 的 symbol 属性为 `UIKitImageVectorSymbol`, UIKitIcon 将会以 ImageVector 的方式静态渲染它
 *
 * 当 symbol 为 UIKitImageVectorSymbol 时, 如果传入 UIKitIcon 的 symbolStyle 属性为 Monochrome, 将会使用其 Brush 中的第一个 Color 作为 tint 否则会使用 `Color.Unspecified`
 */
class UIKitImageVectorSymbol(
    val imageVector: ImageVector
): UIKitSymbol(
    name = imageVector.name,
    defaultSize = DpSize(imageVector.defaultWidth, imageVector.defaultHeight),
    viewportSize = Size(imageVector.viewportWidth, imageVector.viewportHeight)
) {
    override val layers: List<UIKitSymbolLayer>
        get() = emptyList()

    @Composable
    override fun colorSet(
        style: UIKitSymbolStyle,
        states: List<Pair<String, UIKitSymbolGroupState>>
    ): List<UIKitSymbolColor> {
        return emptyList()
    }

    override fun toComposeVector(color: Color): ImageVector {
        return imageVector
    }

    override fun appearEffect(states: List<UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
        return null
    }

    override fun disappearEffect(states: List<UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
        return null
    }

    override fun enableEffect(states: List<UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
        return null
    }

    override fun disableEffect(states: List<UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
        return null
    }
}