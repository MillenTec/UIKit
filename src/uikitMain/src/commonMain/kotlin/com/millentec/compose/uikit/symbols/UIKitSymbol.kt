package com.millentec.compose.uikit.symbols

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.draw.*

sealed class UIKitSymbolAbility {
    object Appear: UIKitSymbolAbility()
    object Disappear: UIKitSymbolAbility()
    object Bounce: UIKitSymbolAbility()
    data class MultiState(val states: List<String>): UIKitSymbolAbility()
    object VariableColor: UIKitSymbolAbility()
    object Progressable: UIKitSymbolAbility()
    object Pulse: UIKitSymbolAbility()
}

/**
 * 可以继承此类以创建一个 UIKitSymbol
 * @param name 图标名称
 * @param defaultSize 默认尺寸
 * @param viewportSize 视口尺寸, 在绘制内容时使用的相对尺寸, 内容将会基于此尺寸进行绘制
 */
abstract class UIKitSymbol(
    val name: String,
    val uid: String,
    val defaultSize: DpSize,
    val viewportSize: Size,
) {
    /**
     * 图标的各个分层
     */
    abstract fun UIKitSymbolDrawer.onDraw()

    /**
     * 图标声明所具备的动画效果能力, 可用于动画调用参考
     */
    abstract val abilityStatement: List<UIKitSymbolAbility>?

    open val tags: List<String> = listOf()

    /**
     * 图标各层的颜色集
     */
    @Composable
    abstract fun colorSet(
        style: UIKitSymbolStyle,
        states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
    ): Map<UIKitSymbolSelector, UIKitSymbolColor>

    private var _groupsCache: Map<UIKitSymbolSelector, UIKitSymbolPathGroup>? = null
    val groups: Map<UIKitSymbolSelector, UIKitSymbolPathGroup>
        get() {
            if (_groupsCache != null)
                return _groupsCache!!
            val drawScope = UIKitSymbolDrawerImpl(this).apply { onDraw() }
            _groupsCache = drawScope.groups

            return _groupsCache!!
        }

    private var _groupsOrdered: List<Pair<UIKitSymbolSelector, UIKitSymbolPathGroup>>? = null
    val groupsOrdered: List<Pair<UIKitSymbolSelector, UIKitSymbolPathGroup>>
        get() {
            if (_groupsOrdered != null)
                return _groupsOrdered!!
            val list = groups.entries.sortedWith(
                compareBy<Map.Entry<UIKitSymbolSelector, UIKitSymbolPathGroup>> {
                    it.value.zIndex.first
                }.thenBy { it.value.zIndex.second }
            ).map { Pair(it.key, it.value) }
            _groupsOrdered = list

            return _groupsOrdered!!
        }

    private var _builtPaths: Map<UIKitSymbolSelector, Path>?  = null
    val builtPaths: Map<UIKitSymbolSelector, Path>
        get() {
            if (_builtPaths != null)
                return _builtPaths!!
            _builtPaths = groupsOrdered.associate { group ->
                Pair(group.first, Path().apply {
                    group.second.path.nodes.forEach { node ->
                        when (node) {
                            UIKitPathNode.Close -> close()
                            is UIKitPathNode.CurveTo -> cubicTo(
                                node.x1,
                                node.y1,
                                node.x2,
                                node.y2,
                                node.x3,
                                node.y3,
                            )

                            is UIKitPathNode.LineTo -> lineTo(node.x, node.y)
                            is UIKitPathNode.MoveTo -> moveTo(node.x, node.y)
                        }
                    }
                })
            }

            return _builtPaths!!
        }

    fun findAllGroups(selector: UIKitSymbolSelector): Map<UIKitSymbolSelector, UIKitSymbolPathGroup> {
        return groups.filter {
            (it.key.symbol == selector.symbol || selector.symbol == null)
                    && (it.key.layer == selector.layer || selector.layer == null)
                    && (it.key.group == selector.group || selector.group == null)
        }
    }

    fun getGroup(selector: UIKitSymbolSelector): UIKitSymbolPathGroup? {
        return groups[selector]
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
            groupsOrdered.forEach { group ->
                path(
                    fill = if (group.second.drawType is UIKitPathDrawType.Fill) SolidColor(color) else null,
                    stroke = if (group.second.drawType is UIKitPathDrawType.Stroke) SolidColor(color) else null,
                ) {
                    group.second.path.nodes.forEach { node ->
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
        states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>? = null
    ): UIKitSymbolAnimTree? {
        val tree = UIKitSymbolAnimTree()

        // 仅对可见的组做动画化处理以节省性能, 并在最后对不可见组直接 snap
        val visibleGroups = groupsOrdered.filter {
            states?.get(it.first)?.visible(
                UIKitAnimSelector.entries.filter { item ->
                    item != UIKitAnimSelector.ScaleAddition && item != UIKitAnimSelector.AlphaAddition }
            ) ?: true
        }

        val layerGroups = visibleGroups.groupBy { it.first.layer }.values.toList()
        layerGroups.reversed().forEachIndexed { indexLayer, groups ->
            groups.forEach {
                tree.addParallel(UIKitSymbolAnimNode.scaleAdditionCenterXTo(
                    it.first,
                    targetValue = viewportSize.width / 2,
                    animateSpec = null
                )).addParallel(UIKitSymbolAnimNode.scaleAdditionCenterYTo(
                    it.first,
                    targetValue = viewportSize.height / 2,
                    animateSpec = null
                )).addParallel(UIKitSymbolAnimNode.scaleAdditionTo(
                    it.first,
                    targetValue = 1f,
                    animateSpec = tween(
                        280 / (layerGroups.size + 1) * 2,
                        easing = CubicBezierEasing(0f, 0f,0.382f, 1f),
                        delayMillis = indexLayer * 280 / (layerGroups.size + 1)
                    ),
                )).addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                    it.first,
                    targetValue = 1f,
                    animateSpec = tween(
                        280 / (layerGroups.size + 1) * 2,
                        easing = CubicBezierEasing(0f, 0f,0.382f, 1f),
                        delayMillis = indexLayer * 280 / (layerGroups.size + 1)
                    )
                ))
            }
        }

        val remains = groupsOrdered.filter { group -> visibleGroups.all { it.first != group.first } }
        remains.forEach {
            tree.addParallel(UIKitSymbolAnimNode.scaleAdditionCenterXTo(
                it.first,
                targetValue = viewportSize.width / 2,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.scaleAdditionCenterYTo(
                it.first,
                targetValue = viewportSize.height / 2,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.scaleAdditionTo(
                it.first,
                targetValue = 1f,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                it.first,
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
        states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>? = null
    ): UIKitSymbolAnimTree? {
        val tree = UIKitSymbolAnimTree()

        val visibleGroups = groupsOrdered.filter {
            states?.get(it.first)?.visible(
                UIKitAnimSelector.entries.filter { item ->
                    item != UIKitAnimSelector.ScaleAddition && item != UIKitAnimSelector.AlphaAddition }
            ) ?: true
        }

        val layerGroups = visibleGroups.groupBy { it.first.layer }.values.toList()
        layerGroups.forEachIndexed { indexLayer, groups ->
            groups.forEach {
                tree.addParallel(UIKitSymbolAnimNode.scaleAdditionCenterXTo(
                    it.first,
                    targetValue = viewportSize.width / 2,
                    animateSpec = null
                )).addParallel(UIKitSymbolAnimNode.scaleAdditionCenterYTo(
                    it.first,
                    targetValue = viewportSize.height / 2,
                    animateSpec = null
                )).addParallel(UIKitSymbolAnimNode.scaleAdditionTo(
                    it.first,
                    targetValue = 0.8f,
                    animateSpec = tween(
                        280 / (layerGroups.size + 1) * 2,
                        easing = FastOutLinearInEasing,
                        delayMillis = indexLayer * 280 / (layerGroups.size + 1)
                    ),
                )).addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                    it.first,
                    targetValue = 0f,
                    animateSpec = tween(
                        280 / (layerGroups.size + 1) * 2,
                        easing = FastOutLinearInEasing,
                        delayMillis = indexLayer * 280 / (layerGroups.size + 1)
                    )
                ))
            }
        }

        val remains = groupsOrdered.filter { group -> visibleGroups.all { it.first != group.first } }
        remains.forEach {
            tree.addParallel(UIKitSymbolAnimNode.scaleAdditionCenterXTo(
                it.first,
                targetValue = viewportSize.width / 2,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.scaleAdditionCenterYTo(
                it.first,
                targetValue = viewportSize.height / 2,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.scaleAdditionTo(
                it.first,
                targetValue = 0.8f,
                animateSpec = null
            )).addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                it.first,
                targetValue = 0f,
                animateSpec = null
            ))
        }

        return tree
    }

    open fun bounceEffect(
        states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>? = null,
        coefficient: Float,
    ): UIKitSymbolAnimTree? {
        val tree = UIKitSymbolAnimTree()

        val visibleGroups = groupsOrdered.filter {
            states?.get(it.first)?.visible ?: true
        }

        val layerGroups = visibleGroups.groupBy { it.first.layer }.values.toList()
        layerGroups.reversed().forEachIndexed { indexLayer, groups ->
            groups.forEach {
                tree.addParallel(UIKitSymbolAnimNode.scaleCenterXTo(
                    it.first,
                    targetValue = viewportSize.width / 2,
                    animateSpec = null
                )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                    it.first,
                    targetValue = viewportSize.height / 2,
                    animateSpec = null
                )).addParallel(UIKitSymbolAnimNode.scaleTo(
                    it.first,
                    targetValue = 1f,
                    animateSpec = keyframes {
                        durationMillis = 575
                        delayMillis = indexLayer * 80

                        1f + 0.1f * coefficient at 200 using CubicBezierEasing(0f, 0f,0.382f, 1f)
                        1f - 0.05f * coefficient at 400 using CubicBezierEasing(0.382f, 1f, 0f, 0f)
                        1f at 500 using CubicBezierEasing(0f, 0f,0.382f, 1f)
                    }
                ))
            }
        }

        return tree
    }

    open fun variableColorEffect(
        states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>? = null,
        initialValue: Float,
        targetValue: Float
    ): UIKitSymbolInfiniteAnimTree? = null

    open fun pulseEffect(
        states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>? = null,
        initialValue: Float,
        targetValue: Float
    ): UIKitSymbolInfiniteAnimTree? = null

    open fun progressibleEffect(
        progress: Float,
        states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>? = null,
    ): UIKitSymbolAnimTree? = null
}

/**
 * UIKitSymbol 所提供的一个兼容层, 如果你传入 `UIKitIcon` 的 symbol 属性为 `UIKitImageVectorSymbol`, UIKitIcon 将会以 ImageVector 的方式静态渲染它
 * 当 symbol 为 UIKitImageVectorSymbol 时, 如果传入 UIKitIcon 的 symbolStyle 属性为 Monochrome, 将会使用其 Brush 中的第一个 Color 作为 tint 否则会使用 `Color.Unspecified`
 */
class UIKitImageVectorSymbol(
    val imageVector: ImageVector
): UIKitSymbol(
    name = imageVector.name,
    uid = imageVector.name,
    defaultSize = DpSize(imageVector.defaultWidth, imageVector.defaultHeight),
    viewportSize = Size(imageVector.viewportWidth, imageVector.viewportHeight)
) {
    override fun UIKitSymbolDrawer.onDraw() {}

    override val abilityStatement: List<UIKitSymbolAbility>? = null

    @Composable
    override fun colorSet(
        style: UIKitSymbolStyle,
        states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
    ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
        return emptyMap()
    }

    override fun toComposeVector(color: Color): ImageVector {
        return imageVector
    }

    override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? = null
    override fun disappearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? = null
    override fun bounceEffect(
        states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?,
        coefficient: Float
    ): UIKitSymbolAnimTree? = null
}