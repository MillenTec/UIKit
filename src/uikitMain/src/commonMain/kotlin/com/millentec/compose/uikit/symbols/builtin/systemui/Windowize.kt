@file:Suppress("SpellCheckingInspection")

package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Windowize: UIKitSymbol
    get() {
        if (_Windowize != null)
            return _Windowize!!
        _Windowize = object : UIKitSymbol(
            name = "Windowize",
            uid = "ic.sys.windowize",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("window0", 1) {
                    addGroup(
                        id = "window",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(12f, 16.5f)
                        horizontalLineToRelative(-6f)
                        curveToRelative(-0.69f, 0f, -1.32f, -0.28f, -1.77f, -0.73f)
                        reflectiveCurveToRelative(-0.73f, -1.08f, -0.73f, -1.77f)
                        verticalLineToRelative(-6f)
                        curveToRelative(0f, -0.69f, 0.28f, -1.32f, 0.73f, -1.77f)
                        reflectiveCurveToRelative(1.08f, -0.73f, 1.77f, -0.73f)
                        horizontalLineToRelative(6f)
                        curveToRelative(0.69f, 0f, 1.32f, 0.28f, 1.77f, 0.73f)
                        reflectiveCurveToRelative(0.73f, 1.08f, 0.73f, 1.77f)
                        verticalLineToRelative(6f)
                        curveToRelative(0f, 0.69f, -0.28f, 1.32f, -0.73f, 1.77f)
                        reflectiveCurveToRelative(-1.08f, 0.73f, -1.77f, 0.73f)
                        close()
                    }
                }
                addLayer("window1", 0) {
                    addGroup(
                        id = "window",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(6.77f, 3.5f)
                        horizontalLineToRelative(6.23f)
                        curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f)
                        verticalLineToRelative(6.5f)
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
                    "Window", "Multiple", "Rectangle"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "window0", null), 1f),
                        Pair(UIKitSymbolSelector(null, "window1", null), 0.6f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "window0", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "window1", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Windowize!!
    }

@Suppress("ObjectPropertyName")
private var _Windowize: UIKitSymbol? = null