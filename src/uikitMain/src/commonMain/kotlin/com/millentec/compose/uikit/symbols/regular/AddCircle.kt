package com.millentec.compose.uikit.symbols.regular

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.materials.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitRegularSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitRegularSymbols.AddCircle: UIKitSymbol
    get() {
        if (_AddCircle != null)
            return _AddCircle!!
        _AddCircle = object: UIKitSymbol(
            name = "AddCircle",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f),
        ) {
            override val layers: List<UIKitSymbolLayer>
                get() = listOf(
                    UIKitSymbolLayer("add_symbol").apply {
                        group(
                            id = "add_symbol",
                            drawType = UIKitPathDrawType.Fill,
                            zIndex = 1
                        ) {
                            moveTo(6f, 10f)
                            curveToRelative(0f, -0.3f, 0.2f, -0.5f, 0.5f, -0.5f)
                            horizontalLineToRelative(3f)
                            verticalLineToRelative(-3f)
                            curveToRelative(0f, -0.3f, 0.2f, -0.5f, 0.5f, -0.5f)
                            reflectiveCurveToRelative(0.5f, 0.2f, 0.5f, 0.5f)
                            verticalLineToRelative(3f)
                            horizontalLineToRelative(3f)
                            curveToRelative(0.3f, 0f, 0.5f, 0.2f, 0.5f, 0.5f)
                            reflectiveCurveToRelative(-0.2f, 0.5f, -0.5f, 0.5f)
                            horizontalLineToRelative(-3f)
                            verticalLineToRelative(3f)
                            curveToRelative(0f, 0.3f, -0.2f, 0.5f, -0.5f, 0.5f)
                            reflectiveCurveToRelative(-0.5f, -0.2f, -0.5f, -0.5f)
                            verticalLineToRelative(-3f)
                            horizontalLineToRelative(-3f)
                            curveToRelative(-0.3f, 0f, -0.5f, -0.2f, -0.5f, -0.5f)
                            close()
                        }
                    },
                    UIKitSymbolLayer("circle").apply {
                        group(
                            id = "circle",
                            drawType = UIKitPathDrawType.Fill,
                            zIndex = 0
                        ) {
                            moveTo(10f, 2f)
                            curveTo(5.6f, 2f, 2f, 5.6f, 2f, 10f)
                            reflectiveCurveToRelative(3.6f, 8f, 8f, 8f)
                            reflectiveCurveToRelative(8f, -3.6f, 8f, -8f)
                            reflectiveCurveTo(14.4f, 2f, 10f, 2f)
                            close()
                            moveTo(10f, 17f)
                            curveToRelative(-3.9f, 0f, -7f, -3.1f, -7f, -7f)
                            reflectiveCurveToRelative(3.1f, -7f, 7f, -7f)
                            reflectiveCurveToRelative(7f, 3.1f, 7f, 7f)
                            reflectiveCurveToRelative(-3.1f, 7f, -7f, 7f)
                            close()
                        }
                    }
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when(style) {
                    is UIKitSymbolStyle.Monochrome -> listOf(
                        UIKitSymbolColor("add_symbol", style.brush, 1f),
                        UIKitSymbolColor("circle", style.brush, 1f)
                    )
                    UIKitSymbolStyle.MultiColor -> listOf(
                        UIKitSymbolColor("add_symbol", UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f),
                        UIKitSymbolColor("circle", UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 0.6f),
                    )
                    is UIKitSymbolStyle.Hierarchical -> listOf(
                        UIKitSymbolColor("add_symbol", style.brush, 1f),
                        UIKitSymbolColor("circle", style.brush, 0.6f),
                    )
                    is UIKitSymbolStyle.Palette -> style.brushes.mapIndexed { index, brush ->
                        UIKitSymbolColor(layers.getOrNull(index)?.id ?: "unknown", brush, 1f)
                    }
                }
            }
        }

        return _AddCircle!!
    }

@Suppress("ObjectPropertyName")
private var _AddCircle: UIKitSymbol? = null