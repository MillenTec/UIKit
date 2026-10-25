package com.millentec.compose.uikit.symbols.builtin.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitLayoutSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitLayoutSymbols.Grid: UIKitSymbol
    get() {
        if (_Grid != null)
            return _Grid!!
        _Grid = object : UIKitSymbol(
            name = "Grid",
            uid = "ic.graphic.grid",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("e0", 0) {
                    addGroup(
                        id = "e0",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(7.5f, 8.5f)
                        horizontalLineTo(3.5f)
                        curveToRelative(-0.28f, 0f, -0.53f, -0.11f, -0.71f, -0.29f)
                        reflectiveCurveToRelative(-0.29f, -0.43f, -0.29f, -0.71f)
                        verticalLineTo(3.5f)
                        curveToRelative(0f, -0.28f, 0.11f, -0.53f, 0.29f, -0.71f)
                        reflectiveCurveToRelative(0.43f, -0.29f, 0.71f, -0.29f)
                        horizontalLineToRelative(4f)
                        curveToRelative(0.28f, 0f, 0.53f, 0.11f, 0.71f, 0.29f)
                        reflectiveCurveToRelative(0.29f, 0.43f, 0.29f, 0.71f)
                        verticalLineToRelative(4f)
                        curveToRelative(0f, 0.28f, -0.11f, 0.53f, -0.29f, 0.71f)
                        reflectiveCurveToRelative(-0.43f, 0.29f, -0.71f, 0.29f)
                        close()
                    }
                }
                addLayer("e1", 1) {
                    addGroup(
                        id = "e1",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(16.5f, 8.5f)
                        horizontalLineToRelative(-4f)
                        curveToRelative(-0.28f, 0f, -0.53f, -0.11f, -0.71f, -0.29f)
                        reflectiveCurveToRelative(-0.29f, -0.43f, -0.29f, -0.71f)
                        verticalLineTo(3.5f)
                        curveToRelative(0f, -0.28f, 0.11f, -0.53f, 0.29f, -0.71f)
                        reflectiveCurveToRelative(0.43f, -0.29f, 0.71f, -0.29f)
                        horizontalLineToRelative(4f)
                        curveToRelative(0.28f, 0f, 0.53f, 0.11f, 0.71f, 0.29f)
                        reflectiveCurveToRelative(0.29f, 0.43f, 0.29f, 0.71f)
                        verticalLineToRelative(4f)
                        curveToRelative(0f, 0.28f, -0.11f, 0.53f, -0.29f, 0.71f)
                        reflectiveCurveToRelative(-0.43f, 0.29f, -0.71f, 0.29f)
                        close()
                    }
                }
                addLayer("e2", 2) {
                    addGroup(
                        id = "e2",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(7.5f, 17.5f)
                        horizontalLineTo(3.5f)
                        curveToRelative(-0.28f, 0f, -0.53f, -0.11f, -0.71f, -0.29f)
                        reflectiveCurveToRelative(-0.29f, -0.43f, -0.29f, -0.71f)
                        verticalLineToRelative(-4f)
                        curveToRelative(0f, -0.28f, 0.11f, -0.53f, 0.29f, -0.71f)
                        reflectiveCurveToRelative(0.43f, -0.29f, 0.71f, -0.29f)
                        horizontalLineToRelative(4f)
                        curveToRelative(0.28f, 0f, 0.53f, 0.11f, 0.71f, 0.29f)
                        reflectiveCurveToRelative(0.29f, 0.43f, 0.29f, 0.71f)
                        verticalLineToRelative(4f)
                        curveToRelative(0f, 0.28f, -0.11f, 0.53f, -0.29f, 0.71f)
                        reflectiveCurveToRelative(-0.43f, 0.29f, -0.71f, 0.29f)
                        close()
                    }
                }
                addLayer("e3", 3) {
                    addGroup(
                        id = "e3",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(16.5f, 17.5f)
                        horizontalLineToRelative(-4f)
                        curveToRelative(-0.28f, 0f, -0.53f, -0.11f, -0.71f, -0.29f)
                        reflectiveCurveToRelative(-0.29f, -0.43f, -0.29f, -0.71f)
                        verticalLineToRelative(-4f)
                        curveToRelative(0f, -0.28f, 0.11f, -0.53f, 0.29f, -0.71f)
                        reflectiveCurveToRelative(0.43f, -0.29f, 0.71f, -0.29f)
                        horizontalLineToRelative(4f)
                        curveToRelative(0.28f, 0f, 0.53f, 0.11f, 0.71f, 0.29f)
                        reflectiveCurveToRelative(0.29f, 0.43f, 0.29f, 0.71f)
                        verticalLineToRelative(4f)
                        curveToRelative(0f, 0.28f, -0.11f, 0.53f, -0.29f, 0.71f)
                        reflectiveCurveToRelative(-0.43f, 0.29f, -0.71f, 0.29f)
                        close()
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() =  listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Bounce,
                    UIKitSymbolAbility.VariableWeight
                )

            override val tags: List<String>
                get() = listOf(
                    "Grid", "View", "List", "All", "Layout"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "e0", null), 1f),
                        Pair(UIKitSymbolSelector(null, "e1", null), 1f),
                        Pair(UIKitSymbolSelector(null, "e2", null), 1f),
                        Pair(UIKitSymbolSelector(null, "e3", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "e0", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "e1", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "e2", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "e3", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Grid!!
    }

@Suppress("ObjectPropertyName")
private var _Grid: UIKitSymbol? = null