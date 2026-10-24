@file:Suppress("FunctionName", "ComposableNaming")

package com.millentec.compose.uikit.symbols.builtin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolSelector
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

//internal fun UIKitSymbolDisable(zIndex: Int = 1): UIKitSymbolLayer {
//    return UIKitSymbolLayer("disable", zIndex).apply {
//        group(
//            id = "disable.mask",
//            drawType = UIKitPathDrawType.MaskStroke(
//                lineWidth = 3f,
//                cap = StrokeCap.Round,
//                join = StrokeJoin.Round
//            ),
//            defaultState = UIKitSymbolGroupState(
//                pathTrimEnd = 0f
//            )
//        ) {
//            moveTo(2.5f, 2.5f)
//            lineTo(17.5f, 17.5f)
//        }
//
//        group(
//            id = "disable",
//            drawType = UIKitPathDrawType.Stroke(
//                lineWidth = 1f,
//                cap = StrokeCap.Round,
//                join = StrokeJoin.Round
//            ),
//            defaultState = UIKitSymbolGroupState(
//                pathTrimEnd = 0f
//            )
//        ) {
//            moveTo(2.5f, 2.5f)
//            lineTo(17.5f, 17.5f)
//        }
//    }
//}

@Composable
internal fun UIKitSymbol.UIKitSymbolColorSet(
    style: UIKitSymbolStyle,
    layerInfo: Map<UIKitSymbolSelector, Float>,
    multiColor: Map<UIKitSymbolSelector, UIKitSymbolColor>
): Map<UIKitSymbolSelector, UIKitSymbolColor> {
    val uikitColors = getUIKitColors()
    val colors = remember(style, this.groups, layerInfo, multiColor) {
        when (style) {
            is UIKitSymbolStyle.Hierarchical -> (layerInfo.map {
                Pair(it.key, UIKitSymbolColor(style.brush, it.value))
            } + this.groups.filter { group -> layerInfo.all { it.key != group.key } }.map {
                Pair(it.key, UIKitSymbolColor(style.brush, 1f))
            }).toMap()

            is UIKitSymbolStyle.Monochrome -> groups.map {
                Pair(it.key, UIKitSymbolColor(
                    brush = style.brush,
                    1f
                ))
            }.toMap()

            UIKitSymbolStyle.MultiColor -> multiColor

            is UIKitSymbolStyle.Palette -> {
                var preColor: UIKitBrush? = null
                groupsOrdered.filter {
                    it.second.drawType != UIKitPathDrawType.MaskFilled && it.second.drawType !is UIKitPathDrawType.MaskStroke
                }.reversed().mapIndexed { index, group ->
                    val color = style.brushes.getOrElse(index) {
                        preColor ?: UIKitBrush.solid(uikitColors.textFillColorPrimaryBrush)
                    }
                    preColor = color

                    Pair(group.first, UIKitSymbolColor(
                        brush = color,
                        alpha = 1f
                    ))
                }.toMap()
            }

            is UIKitSymbolStyle.PaletteWithId -> style.brushes.map {
                Pair(it.first, UIKitSymbolColor(it.second, 1f))
            }.toMap()
        }
    }

    return colors
}