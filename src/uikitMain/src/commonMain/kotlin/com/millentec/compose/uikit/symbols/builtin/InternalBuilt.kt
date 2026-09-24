@file:Suppress("FunctionName", "ComposableNaming")

package com.millentec.compose.uikit.symbols.builtin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

internal fun UIKitSymbolDisable(zIndex: Int = 1): UIKitSymbolLayer {
    return UIKitSymbolLayer("disable", zIndex).apply {
        group(
            id = "disable.mask",
            drawType = UIKitPathDrawType.MaskStroke(
                lineWidth = 3f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            ),
            defaultState = UIKitSymbolGroupState(
                pathTrimEnd = 0f
            )
        ) {
            moveTo(2.5f, 2.5f)
            lineTo(17.5f, 17.5f)
        }

        group(
            id = "disable",
            drawType = UIKitPathDrawType.Stroke(
                lineWidth = 1f,
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            ),
            defaultState = UIKitSymbolGroupState(
                pathTrimEnd = 0f
            )
        ) {
            moveTo(2.5f, 2.5f)
            lineTo(17.5f, 17.5f)
        }
    }
}

@Composable
internal fun UIKitSymbolColorSet(
    style: UIKitSymbolStyle,
    layers: List<UIKitSymbolLayer>,
    layerInfo: List<Pair<String, Float>>,
    multiColor: List<UIKitSymbolColor>
): List<UIKitSymbolColor> {
    val uikitColors = getUIKitColors()
    val colors = remember(style, layers, layerInfo, multiColor) {
        when (style) {
            is UIKitSymbolStyle.Hierarchical -> layers.map { layer ->
                UIKitSymbolColor(
                    selector = layer.id,
                    brush = style.brush,
                    alpha = layerInfo.firstOrNull { it.first == layer.id }?.second ?: 1f
                )
            }
            is UIKitSymbolStyle.Monochrome -> layers.map { layer ->
                UIKitSymbolColor(
                    layer.id,
                    brush = style.brush,
                    1f
                )
            }
            UIKitSymbolStyle.MultiColor -> multiColor
            is UIKitSymbolStyle.Palette -> {
                var preColor: UIKitBrush? = null

                layers.filter { it.groups.any { group ->
                    group.drawType != UIKitPathDrawType.MaskFilled || group.drawType !is UIKitPathDrawType.MaskStroke }
                }.sortedByDescending { it.zIndex }.mapIndexed { index, layer ->
                    val color = style.brushes.getOrElse(index) {
                        preColor ?: UIKitBrush.solid(uikitColors.textFillColorPrimaryBrush)
                    }
                    preColor = color

                    UIKitSymbolColor(
                        selector = layer.id,
                        brush = color,
                        alpha = 1f
                    )
                }
            }
            is UIKitSymbolStyle.PaletteWithId -> layers.map { layer ->
                UIKitSymbolColor(
                    selector = layer.id,
                    brush = style.brushes.firstOrNull { it.first == layer.id }?.second ?: UIKitBrush.solid(uikitColors.textFillColorPrimaryBrush),
                    alpha = 1f
                )
            }
        }
    }

    return colors
}