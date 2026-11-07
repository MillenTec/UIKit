package com.millentec.compose.uikit.symbols.builtin.media

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

val UIKitMediaSymbols.Play: UIKitSymbol
    get() {
        if (_Play != null)
            return _Play!!
        _Play = object : UIKitSymbol(
            name = "Play",
            uid = "ic.media.play",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("play") {
                    addGroup(
                        id = "play",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(5.5f, 4.5f)
                        verticalLineToRelative(11f)
                        curveToRelative(0f, 0.76f, 0.82f, 1.24f, 1.48f, 0.88f)
                        lineToRelative(10f, -5.5f)
                        curveToRelative(0.69f, -0.38f, 0.69f, -1.37f, 0f, -1.75f)
                        lineTo(6.98f, 3.63f)
                        curveToRelative(-0.67f, -0.37f, -1.48f, 0.12f, -1.48f, 0.88f)
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
                    "Play", "Media", "Video", "Music", "Audio", "Triangle", "Return"
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