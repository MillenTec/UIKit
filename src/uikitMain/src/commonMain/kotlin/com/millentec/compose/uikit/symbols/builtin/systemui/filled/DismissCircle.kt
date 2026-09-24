package com.millentec.compose.uikit.symbols.builtin.systemui.filled

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols.UIKitSystemUIFilledSymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUIFilledSymbols.DismissCircle: UIKitSymbol
    get() {
        if (_DismissCircle != null)
            return _DismissCircle!!
        _DismissCircle = object : UIKitSymbol(
            name = "DismissCircleFilled",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("dismiss_symbol", 1).apply {
                    group(
                        id = "dismiss_symbol_line0",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(7.5f, 7.5f)
                        lineTo(12.5f, 12.5f)
                    }
                    group(
                        id = "dismiss_symbol_line1",
                        drawType = UIKitPathDrawType.Stroke(lineWidth = 1f)
                    ) {
                        moveTo(12.5f, 7.5f)
                        lineTo(7.5f, 12.5f)
                    }
                },
                UIKitSymbolLayer("circle", 0).apply {
                    group(
                        id = "circle",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10f, 2f)
                        curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
                        reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
                        reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
                        reflectiveCurveTo(14.42f, 2f, 10f, 2f)
                        close()
                        moveTo(12.83f, 12.12f)
                        curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
                        lineToRelative(-0.06f, 0.07f)
                        curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
                        lineToRelative(-0.07f, -0.06f)
                        lineToRelative(-2.12f, -2.12f)
                        lineToRelative(-2.12f, 2.12f)
                        curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
                        lineToRelative(-0.07f, -0.06f)
                        curveToRelative(-0.17f, -0.17f, -0.19f, -0.44f, -0.06f, -0.64f)
                        lineToRelative(0.06f, -0.07f)
                        lineToRelative(2.12f, -2.12f)
                        lineToRelative(-2.12f, -2.12f)
                        curveToRelative(-0.17f, -0.17f, -0.19f, -0.44f, -0.06f, -0.64f)
                        lineToRelative(0.06f, -0.07f)
                        curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
                        lineToRelative(0.07f, 0.06f)
                        lineToRelative(2.12f, 2.12f)
                        lineToRelative(2.12f, -2.12f)
                        curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
                        lineToRelative(0.07f, 0.06f)
                        curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
                        lineToRelative(-0.06f, 0.07f)
                        lineToRelative(-2.12f, 2.12f)
                        lineToRelative(2.12f, 2.12f)
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
                "Dismiss", "Error", "Forbidden", "Prohibit", "Disabled", "Crashed"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return if (style is UIKitSymbolStyle.Monochrome) {
                    listOf(
                        UIKitSymbolColor("dismiss_symbol", style.brush, 0f),
                        UIKitSymbolColor("circle", style.brush, 1f),
                    )
                } else UIKitSymbolColorSet(
                    style = style,
                    layers = layers,
                    layerInfo = listOf(
                        Pair("dismiss_symbol", 1f),
                        Pair("circle", 0.3f),
                    ),
                    multiColor = listOf(
                        UIKitSymbolColor("dismiss_symbol", UIKitBrush.solid(getUIKitColors().errorRedColorPrimaryBrush), 1f),
                        UIKitSymbolColor("circle", UIKitBrush.solid(getUIKitColors().errorRedColorFourthBrush), 1f)
                    )
                )
            }
        }

        return _DismissCircle!!
    }

@Suppress("ObjectPropertyName")
private var _DismissCircle: UIKitSymbol? = null