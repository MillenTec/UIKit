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

val UIKitArrowSymbols.Minimize: UIKitSymbol
    get() {
        if (_Minimize != null)
            return _Minimize!!
        _Minimize = object : UIKitSymbol(
            name = "Minimize",
            uid = "ic.arrow.minimize",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("minimize") {
                    addGroup(
                        id = "arrow.down",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(8.5f, 16.5f)
                        lineToRelative(0f, -5f)
                        lineToRelative(-5f, 0f)
                        moveTo(2.5f, 17.5f)
                        lineTo(8.5f, 11.5f)
                    }
                    addGroup(
                        id = "arrow.up",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(11.5f, 3.5f)
                        lineToRelative(0f, 5f)
                        lineToRelative(5f, 0f)
                        moveTo(17.5f, 2.5f)
                        lineTo(11.5f, 8.5f)
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
                    "Arrow", "Minimize", "Close", "Zoom Out"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "minimize", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "minimize", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Minimize!!
    }

@Suppress("ObjectPropertyName")
private var _Minimize: UIKitSymbol? = null