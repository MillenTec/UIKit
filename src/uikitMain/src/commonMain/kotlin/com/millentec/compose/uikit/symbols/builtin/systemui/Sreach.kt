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
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Search: UIKitSymbol
    get() {
        if (_Search != null)
            return _Search!!
        _Search = object : UIKitSymbol(
            name = "Search",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("search").apply {
                    group(
                        id = "search",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(13.729f, 14.436f)
                        curveTo(12.592f, 15.411f, 11.115f, 16f, 9.5f, 16f)
                        curveTo(5.91f, 16f, 3f, 13.09f, 3f, 9.5f)
                        curveTo(3f, 5.91f, 5.91f, 3f, 9.5f, 3f)
                        curveTo(13.09f, 3f, 16f, 5.91f, 16f, 9.5f)
                        curveTo(16f, 11.115f, 15.411f, 12.592f, 14.436f, 13.729f)
                        lineTo(17.854f, 17.146f)
                        curveTo(18.049f, 17.342f, 18.049f, 17.658f, 17.854f, 17.854f)
                        curveTo(17.68f, 18.027f, 17.41f, 18.046f, 17.216f, 17.911f)
                        lineTo(17.146f, 17.854f)
                        lineTo(13.729f, 14.436f)
                        close()
                        moveTo(13.02f, 13.727f)
                        curveTo(13.276f, 13.513f, 13.513f, 13.276f, 13.726f, 13.02f)
                        curveTo(14.522f, 12.066f, 15f, 10.839f, 15f, 9.5f)
                        curveTo(15f, 6.462f, 12.538f, 4f, 9.5f, 4f)
                        curveTo(6.462f, 4f, 4f, 6.462f, 4f, 9.5f)
                        curveTo(4f, 12.538f, 6.462f, 15f, 9.5f, 15f)
                        curveTo(10.839f, 15f, 12.066f, 14.522f, 13.02f, 13.727f)
                        close()
                    }
                }
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce
            )

            override val tags: List<String> = listOf(
                "Search", "Magnifying Glass", "Discover", "Inquire"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layers = layers,
                    layerInfo = listOf(
                        Pair("search", 1f)
                    ),
                    multiColor = listOf(
                        UIKitSymbolColor("search", UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                    ),
                )
            }
        }

        return _Search!!
    }

@Suppress("ObjectPropertyName")
private var _Search: UIKitSymbol? = null