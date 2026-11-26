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

val UIKitSystemUISymbols.Maximize: UIKitSymbol
    get() {
        if (_Maximize != null)
            return _Maximize!!
        _Maximize = object : UIKitSymbol(
            name = "Maximize",
            uid = "ic.sys.maximize",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("maximize") {
                    addGroup(
                        id = "maximize",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(15f, 16.5f)
                        horizontalLineTo(5f)
                        curveToRelative(-0.41f, 0f, -0.79f, -0.17f, -1.06f, -0.44f)
                        reflectiveCurveToRelative(-0.44f, -0.65f, -0.44f, -1.06f)
                        verticalLineTo(5f)
                        curveToRelative(0f, -0.41f, 0.17f, -0.79f, 0.44f, -1.06f)
                        reflectiveCurveToRelative(0.65f, -0.44f, 1.06f, -0.44f)
                        horizontalLineToRelative(10f)
                        curveToRelative(0.41f, 0f, 0.79f, 0.17f, 1.06f, 0.44f)
                        reflectiveCurveToRelative(0.44f, 0.65f, 0.44f, 1.06f)
                        verticalLineToRelative(10f)
                        curveToRelative(0f, 0.41f, -0.17f, 0.79f, -0.44f, 1.06f)
                        reflectiveCurveToRelative(-0.65f, 0.44f, -1.06f, 0.44f)
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
                    "Maximize", "Square", "Rectangle"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "maximize", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "maximize", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Maximize!!
    }

@Suppress("ObjectPropertyName")
private var _Maximize: UIKitSymbol? = null