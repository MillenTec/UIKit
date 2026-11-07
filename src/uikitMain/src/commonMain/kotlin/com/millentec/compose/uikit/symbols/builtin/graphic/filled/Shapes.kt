package com.millentec.compose.uikit.symbols.builtin.graphic.filled

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitGraphicSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitGraphicSymbols.UIKitGraphicFilledSymbols.Shapes: UIKitSymbol
    get() {
        if (_Shapes != null)
            return _Shapes!!
        _Shapes = object : UIKitSymbol(
            name = "Shapes",
            uid = "ic.graphic.shapes.filled",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("shapes_circle") {
                    addGroup(
                        id = "circle",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(2f, 7.5f)
                        curveTo(2f, 4.462f, 4.462f, 2f, 7.5f, 2f)
                        curveTo(10.369f, 2f, 12.725f, 4.197f, 12.978f, 7f)
                        horizontalLineTo(10.5f)
                        curveTo(8.567f, 7f, 7f, 8.567f, 7f, 10.5f)
                        verticalLineTo(12.978f)
                        curveTo(4.197f, 12.725f, 2f, 10.369f, 2f, 7.5f)
                        close()
                    }
                }

                addLayer(
                    id = "shapes_rect",
                    zIndex = 1,
                ) {
                    addGroup(
                        id = "rect",
                        zIndex = 1,
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10.5f, 8f)
                        curveTo(9.119f, 8f, 8f, 9.119f, 8f, 10.5f)
                        verticalLineTo(15.5f)
                        curveTo(8f, 16.881f, 9.119f, 18f, 10.5f, 18f)
                        horizontalLineTo(15.5f)
                        curveTo(16.881f, 18f, 18f, 16.881f, 18f, 15.5f)
                        verticalLineTo(10.5f)
                        curveTo(18f, 9.119f, 16.881f, 8f, 15.5f, 8f)
                        horizontalLineTo(10.5f)
                        close()
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() = listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Bounce,
                    UIKitSymbolAbility.VariableWeight
                )

            override val tags: List<String>
                get() = listOf(
                    "Shapes", "Graphic", "Geometry", "Circle", "Rectangle", "Filled"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "shapes_circle", null), 0.6f),
                        Pair(UIKitSymbolSelector(null, "shapes_rect", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "shapes_circle", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "shapes_rect", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    ),
                )
            }
        }

        return _Shapes!!
    }

@Suppress("ObjectPropertyName")
private var _Shapes: UIKitSymbol? = null