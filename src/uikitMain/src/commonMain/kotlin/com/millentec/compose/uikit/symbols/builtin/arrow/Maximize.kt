package com.millentec.compose.uikit.symbols.builtin.arrow

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitArrowSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitArrowSymbols.Maximize: UIKitSymbol
    get() {
        if (_Maximize != null)
            return _Maximize!!
        _Maximize = object : UIKitSymbol(
            name = "Maximize",
            uid = "ic.arrow.maximize",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("maximize") {
                    addGroup(
                        id = "line",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(4.5f, 15.5f)
                        lineTo(15.5f, 4.5f)
                    }
                    addGroup(
                        id = "arrow.down",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(4.5f, 9.5f)
                        lineToRelative(0f, 6f)
                        lineToRelative(6f, 0f)
                    }
                    addGroup(
                        id = "arrow.up",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(9.5f, 4.5f)
                        lineToRelative(6f, 0f)
                        lineToRelative(0f, 6f)
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
                    "Arrow", "Maximize", "Full", "Zoom In"
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