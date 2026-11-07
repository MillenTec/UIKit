package com.millentec.compose.uikit.symbols.builtin.media.filled

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitMediaSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitMediaSymbols.UIKitMediaFilledSymbols.Play: UIKitSymbol
    get() {
        if (_Play != null)
            return _Play!!
        _Play = object : UIKitSymbol(
            name = "Play",
            uid = "ic.media.play.filled",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("play") {
                    addGroup(
                        id = "play",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(17.222f, 8.685f)
                        curveTo(18.259f, 9.254f, 18.259f, 10.744f, 17.222f, 11.314f)
                        lineTo(7.223f, 16.81f)
                        curveTo(6.223f, 17.36f, 5f, 16.637f, 5f, 15.496f)
                        lineTo(5f, 4.502f)
                        curveTo(5f, 3.361f, 6.223f, 2.638f, 7.223f, 3.188f)
                        lineTo(17.222f, 8.685f)
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
                    "Play", "Media", "Video", "Music", "Audio", "Triangle", "Return", "Filled"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "play", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "play", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    ),
                )
            }
        }

        return _Play!!
    }

@Suppress("ObjectPropertyName")
private var _Play: UIKitSymbol? = null