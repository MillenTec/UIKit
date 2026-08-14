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
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.draw.*

abstract class UIKitSymbol(
    val name: String,
    val defaultSize: DpSize,
    val viewportSize: Size,
) {
    abstract val layers: List<UIKitSymbolLayer>

    @Composable
    abstract fun colorSet(style: UIKitSymbolStyle): List<UIKitSymbolColor>

    private var _groupsCache: List<UIKitSymbolPathGroup>? = null
    val groups: List<UIKitSymbolPathGroup>
        get() {
            if (_groupsCache == null) {
                val groups = mutableListOf<UIKitSymbolPathGroup>()
                layers.forEach { layer ->
                    groups += layer.groups
                }

                _groupsCache = groups
            }

            return _groupsCache!!
        }

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

    open fun appearEffect(): UIKitSymbolAnimTree? {
        val tree = UIKitSymbolAnimTree()
        groups.forEachIndexed { index, group ->
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

        return tree
    }

    open fun disappearEffect(): UIKitSymbolAnimTree? {
        val tree = UIKitSymbolAnimTree()
        groups.forEachIndexed { index, group ->
            tree.addParallel(UIKitSymbolAnimNode.scaleTo(
                group.id,
                targetValue = 0.8f,
                animateSpec = tween(
                    260 / (groups.size + 1) * 2,
                    easing = CubicBezierEasing(1f, 0.62f, 0.62f, 1f),
                    delayMillis = index * 260 / (groups.size + 1)
                ),
            )).addParallel(UIKitSymbolAnimNode.alphaTo(
                group.id,
                targetValue = 0f,
                animateSpec = tween(
                    260 / (groups.size + 1) * 2,
                    easing = CubicBezierEasing(1f, 0.62f, 0.62f, 1f),
                    delayMillis = index * 260 / (groups.size + 1)
                )
            ))
        }

        return tree
    }

    open fun enableEffect(): UIKitSymbolAnimTree? {
        return null
    }

    open fun disableEffect(): UIKitSymbolAnimTree? {
        return null
    }
}