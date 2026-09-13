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
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolDisable
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.EyeView: UIKitSymbol
    get() {
        if (_EyeView != null)
            return _EyeView!!
        _EyeView = object : UIKitSymbol(
            name = "EyeView",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("eye").apply {
                    group(
                        id = "eye",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10f, 8f)
                        curveTo(8.067f, 8f, 6.5f, 9.567f, 6.5f, 11.5f)
                        curveTo(6.5f, 13.433f, 8.067f, 15f, 10f, 15f)
                        curveTo(11.933f, 15f, 13.5f, 13.433f, 13.5f, 11.5f)
                        curveTo(13.5f, 9.567f, 11.933f, 8f, 10f, 8f)
                        close()
                        moveTo(7.5f, 11.5f)
                        curveTo(7.5f, 10.119f, 8.619f, 9f, 10f, 9f)
                        curveTo(11.381f, 9f, 12.5f, 10.119f, 12.5f, 11.5f)
                        curveTo(12.5f, 12.881f, 11.381f, 14f, 10f, 14f)
                        curveTo(8.619f, 14f, 7.5f, 12.881f, 7.5f, 11.5f)
                        close()
                    }
                    group(
                        id = "eyebrow",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(3.259f, 11.602f)
                        curveTo(3.943f, 8.327f, 6.794f, 6f, 10f, 6f)
                        curveTo(13.206f, 6f, 16.057f, 8.327f, 16.741f, 11.602f)
                        curveTo(16.797f, 11.873f, 17.062f, 12.046f, 17.333f, 11.99f)
                        curveTo(17.603f, 11.933f, 17.776f, 11.668f, 17.72f, 11.398f)
                        curveTo(16.942f, 7.673f, 13.693f, 5f, 10f, 5f)
                        curveTo(6.307f, 5f, 3.057f, 7.673f, 2.28f, 11.398f)
                        curveTo(2.224f, 11.668f, 2.397f, 11.933f, 2.668f, 11.99f)
                        curveTo(2.938f, 12.046f, 3.203f, 11.873f, 3.259f, 11.602f)
                        close()
                    }
                },
                UIKitSymbolDisable()
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.MultiState(listOf("default", "disabled"))
            )

            override val tags: List<String> = listOf(
                "Eye", "View", "Visible", "See", "Visual"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                val disabled = states.firstOrNull { it.first == "disable" }?.second?.visible == true
                return UIKitSymbolColorSet(
                    style = style,
                    layers = layers,
                    layerInfo = listOf(
                        Pair("eye", if (disabled) 0.6f else 1f),
                        Pair("eyebrow", if (disabled) 0.6f else 1f),
                        Pair("disable", 1f),
                    ),
                    multiColor = listOf(
                        UIKitSymbolColor("eye", UIKitBrush.solid(if (disabled) getUIKitColors().lineFillColorDisabled else getUIKitColors().textFillColorPrimaryBrush), 1f),
                        UIKitSymbolColor("eyebrow", UIKitBrush.solid(if (disabled) getUIKitColors().lineFillColorDisabled else getUIKitColors().textFillColorPrimaryBrush), 1f),
                        UIKitSymbolColor("disable", UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f)
                    )
                )
            }
        }

        return _EyeView!!
    }

@Suppress("ObjectPropertyName")
private var _EyeView: UIKitSymbol? = null