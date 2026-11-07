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

val UIKitGraphicSymbols.UIKitGraphicFilledSymbols.Flash: UIKitSymbol
    get() {
        if (_Flash != null)
            return _Flash!!
        _Flash = object : UIKitSymbol(
            name = "Flash",
            uid = "ic.graphic.flash.filled",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("flash") {
                    addGroup(
                        id = "flash",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(7.212f, 2f)
                        curveTo(6.738f, 2f, 6.321f, 2.314f, 6.191f, 2.771f)
                        lineTo(3.941f, 10.644f)
                        curveTo(3.747f, 11.323f, 4.257f, 11.998f, 4.963f, 11.998f)
                        horizontalLineTo(6.23f)
                        lineTo(5.06f, 16.677f)
                        curveTo(4.796f, 17.733f, 6.101f, 18.455f, 6.856f, 17.673f)
                        lineTo(15.532f, 8.815f)
                        lineTo(15.536f, 8.811f)
                        curveTo(16.176f, 8.144f, 15.715f, 7f, 14.769f, 7f)
                        horizontalLineTo(12.205f)
                        lineTo(13.467f, 3.406f)
                        lineTo(13.469f, 3.398f)
                        curveTo(13.699f, 2.71f, 13.186f, 2f, 12.461f, 2f)
                        horizontalLineTo(7.212f)
                        close()
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() = listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Bounce
                )

            override val tags: List<String>
                get() = listOf(
                    "Flash", "Motion", "Lightning", "Electricity",  "Fast", "Quick", "Swift", "Filled"
                )
            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "flash", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "flash", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().yellowThemedBrush), 1f)
                        )
                    ),
                )
            }
        }

        return _Flash!!
    }

@Suppress("ObjectPropertyName")
private var _Flash: UIKitSymbol? = null