package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolDisable
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Computer: UIKitSymbol
    get() {
        if (_Computer != null)
            return _Computer!!
        _Computer = object : UIKitSymbol(
            name = "Computer",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("screen").apply {
                    group(
                        id = "screen",
                        drawType = UIKitPathDrawType.Fill,
                        defaultState = UIKitSymbolGroupState(alpha = 0f)
                    ) {
                        moveTo(2f, 6f)
                        curveTo(2f, 4.895f, 2.895f, 4f, 4f, 4f)
                        horizontalLineTo(16f)
                        curveTo(17.105f, 4f, 18f, 4.895f, 18f, 6f)
                        verticalLineTo(13f)
                        curveTo(18f, 14.105f, 17.105f, 15f, 16f, 15f)
                        horizontalLineTo(4f)
                        curveTo(2.895f, 15f, 2f, 14.105f, 2f, 13f)
                        verticalLineTo(6f)
                        close()
                    }
                },
                UIKitSymbolLayer("screen_border").apply {
                    group(
                        id = "screen_border",
                        drawType = UIKitPathDrawType.Fill,
                    ) {
                        moveTo(2f, 6f)
                        curveTo(2f, 4.895f, 2.895f, 4f, 4f, 4f)
                        horizontalLineTo(16f)
                        curveTo(17.105f, 4f, 18f, 4.895f, 18f, 6f)
                        verticalLineTo(13f)
                        curveTo(18f, 14.105f, 17.105f, 15f, 16f, 15f)
                        horizontalLineTo(4f)
                        curveTo(2.895f, 15f, 2f, 14.105f, 2f, 13f)
                        verticalLineTo(6f)
                        close()
                        moveTo(4f, 5f)
                        curveTo(3.448f, 5f, 3f, 5.448f, 3f, 6f)
                        verticalLineTo(13f)
                        curveTo(3f, 13.552f, 3.448f, 14f, 4f, 14f)
                        horizontalLineTo(16f)
                        curveTo(16.552f, 14f, 17f, 13.552f, 17f, 13f)
                        verticalLineTo(6f)
                        curveTo(17f, 5.448f, 16.552f, 5f, 16f, 5f)
                        horizontalLineTo(4f)
                        close()
                    }
                },
                UIKitSymbolLayer("base").apply {
                    group(
                        id = "base",
                        drawType = UIKitPathDrawType.Fill,
                    ) {
                        moveTo(5f, 16.5f)
                        curveTo(5f, 16.224f, 5.224f, 16f, 5.5f, 16f)
                        horizontalLineTo(14.5f)
                        curveTo(14.776f, 16f, 15f, 16.224f, 15f, 16.5f)
                        curveTo(15f, 16.776f, 14.776f, 17f, 14.5f, 17f)
                        horizontalLineTo(5.5f)
                        curveTo(5.224f, 17f, 5f, 16.776f, 5f, 16.5f)
                        close()
                    }
                },
                UIKitSymbolDisable()
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.MultiState(listOf("default", "disabled")),
                UIKitSymbolAbility.Pulse
            )

            override val tags: List<String> = listOf(
                "Computer", "PC", "Screen", "TV", "Display", "System"
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
                        Pair("screen", if (disabled) 0.6f else 1f),
                        Pair("screen_border", if (disabled) 0.6f else 1f),
                        Pair("base", 0.6f),
                        Pair("disable", 1f)
                    ),
                    multiColor = listOf(
                        UIKitSymbolColor("screen", if (disabled) UIKitBrush.solid(getUIKitColors().textFillColorSecondaryBrush) else UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f),
                        UIKitSymbolColor("screen_border", UIKitBrush.solid(getUIKitColors().contentFillColorFourthBrush), 1f),
                        UIKitSymbolColor("base", UIKitBrush.solid(getUIKitColors().contentFillColorFourthBrush), 1f),
                        UIKitSymbolColor("disable", UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f)
                    )
                )
            }

            override fun pulseEffect(
                states: List<UIKitSymbolAnimState>?,
                initialValue: Float,
                targetValue: Float
            ): UIKitSymbolInfiniteAnimTree {
                return UIKitSymbolInfiniteAnimTree(
                    start = UIKitSymbolAnimTree()
                        .addSequential(UIKitSymbolAnimNode.alphaTo("screen", 0.6f, tween(500, easing = LinearEasing))),
                    body = UIKitSymbolAnimTree()
                        .addSequential(UIKitSymbolAnimNode.alphaTo("screen", 0.3f, tween(500, easing = LinearEasing, delayMillis = 200)))
                        .addSequential(UIKitSymbolAnimNode.alphaTo("screen", 0.6f, tween(500, easing = LinearEasing, delayMillis = 200))),
                    end = UIKitSymbolAnimTree()
                        .addSequential(UIKitSymbolAnimNode.alphaTo("screen", 0f, tween(500, easing = LinearEasing)))
                )
            }
        }

        return _Computer!!
    }

@Suppress("ObjectPropertyName")
private var _Computer: UIKitSymbol? = null