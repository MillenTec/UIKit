package com.millentec.compose.uikit.symbols.builtin.media

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitMediaSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolDisable
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitMediaSymbols.Volume: UIKitSymbol
    get() {
        if (_Volume != null)
            return _Volume!!
        _Volume = object : UIKitSymbol(
            name = "Volume",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("speaker").apply {
                    group(
                        id = "speaker",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(8.5f, 15.99f)
                        curveToRelative(-0.25f, 0f, -0.48f, -0.09f, -0.68f, -0.27f)
                        lineToRelative(-2.17f, -2.64f)
                        reflectiveCurveToRelative(-0.17f, -0.08f, -0.29f, -0.08f)
                        horizontalLineToRelative(-1.85f)
                        curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
                        verticalLineToRelative(-3f)
                        curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f)
                        horizontalLineToRelative(1.85f)
                        curveToRelative(0.13f, 0f, 0.25f, -0.05f, 0.34f, -0.13f)
                        lineToRelative(2.08f, -2.55f)
                        curveToRelative(0.34f, -0.32f, 0.75f, -0.4f, 1.13f, -0.23f)
                        curveToRelative(0.37f, 0.16f, 0.6f, 0.51f, 0.6f, 0.92f)
                        verticalLineToRelative(9.99f)
                        curveToRelative(0f, 0.4f, -0.23f, 0.75f, -0.6f, 0.92f)
                        curveToRelative(-0.13f, 0.06f, -0.27f, 0.08f, -0.4f, 0.08f)
                        close()
                        moveTo(3.5f, 8f)
                        curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                        verticalLineToRelative(3f)
                        curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                        horizontalLineToRelative(1.85f)
                        curveToRelative(0.38f, 0f, 0.74f, 0.14f, 1.02f, 0.4f)
                        lineToRelative(2.17f, 2.64f)
                        lineToRelative(-0.05f, -10.04f)
                        lineToRelative(-2.08f, 2.55f)
                        curveToRelative(-0.32f, 0.31f, -0.69f, 0.45f, -1.07f, 0.45f)
                        horizontalLineToRelative(-1.85f)
                        close()
                    }
                },
                UIKitSymbolLayer("wave0").apply {
                    group(
                        id = "wave0",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10.96f, 13.2f)
                        curveToRelative(-0.11f, 0f, -0.23f, -0.04f, -0.32f, -0.12f)
                        curveToRelative(-0.21f, -0.18f, -0.24f, -0.49f, -0.06f, -0.71f)
                        curveToRelative(0.26f, -0.31f, 0.87f, -1.17f, 0.87f, -2.38f)
                        curveToRelative(0f, -1.22f, -0.61f, -2.07f, -0.87f, -2.37f)
                        curveToRelative(-0.18f, -0.21f, -0.15f, -0.53f, 0.06f, -0.7f)
                        curveToRelative(0.21f, -0.18f, 0.53f, -0.15f, 0.7f, 0.06f)
                        curveToRelative(0.33f, 0.39f, 1.1f, 1.47f, 1.11f, 3.02f)
                        curveToRelative(0f, 1.54f, -0.77f, 2.63f, -1.1f, 3.03f)
                        curveToRelative(-0.1f, 0.12f, -0.24f, 0.18f, -0.38f, 0.18f)
                        close()
                    }
                },
                UIKitSymbolLayer("wave1").apply {
                    group(
                        id = "wave1",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(13.16f, 15.21f)
                        curveToRelative(-0.11f, 0f, -0.23f, -0.04f, -0.32f, -0.12f)
                        curveToRelative(-0.21f, -0.18f, -0.24f, -0.49f, -0.06f, -0.7f)
                        curveToRelative(0.48f, -0.57f, 1.6f, -2.14f, 1.6f, -4.39f)
                        curveToRelative(0f, -2.24f, -1.12f, -3.82f, -1.6f, -4.39f)
                        curveToRelative(-0.18f, -0.21f, -0.15f, -0.53f, 0.06f, -0.7f)
                        curveToRelative(0.21f, -0.18f, 0.53f, -0.15f, 0.7f, 0.06f)
                        curveToRelative(0.55f, 0.66f, 1.84f, 2.46f, 1.84f, 5.03f)
                        curveToRelative(0f, 2.58f, -1.29f, 4.38f, -1.84f, 5.03f)
                        curveToRelative(-0.1f, 0.12f, -0.24f, 0.18f, -0.38f, 0.18f)
                        close()
                    }
                },
                UIKitSymbolLayer("wave2").apply {
                    group(
                        id = "wave2",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(15.37f, 17.22f)
                        curveToRelative(-0.11f, 0f, -0.23f, -0.04f, -0.32f, -0.12f)
                        curveToRelative(-0.21f, -0.18f, -0.24f, -0.49f, -0.06f, -0.7f)
                        curveToRelative(0.7f, -0.83f, 2.34f, -3.13f, 2.34f, -6.4f)
                        reflectiveCurveToRelative(-1.63f, -5.57f, -2.34f, -6.4f)
                        curveToRelative(-0.18f, -0.21f, -0.15f, -0.53f, 0.06f, -0.7f)
                        curveToRelative(0.21f, -0.18f, 0.53f, -0.15f, 0.7f, 0.06f)
                        curveToRelative(0.77f, 0.92f, 2.57f, 3.44f, 2.57f, 7.04f)
                        reflectiveCurveToRelative(-1.8f, 6.13f, -2.57f, 7.04f)
                        curveToRelative(-0.1f, 0.12f, -0.24f, 0.18f, -0.38f, 0.18f)
                        close()
                    }
                },
                UIKitSymbolLayer("mute").apply {
                    group(
                        id = "mute",
                        drawType = UIKitPathDrawType.Fill,
                        defaultState = UIKitSymbolGroupState(alpha = 0f)
                    ) {
                        moveTo(17.69f, 12.35f)
                        curveToRelative(0.2f, 0.19f, 0.2f, 0.51f, 0f, 0.7f)
                        curveToRelative(-0.09f, 0.1f, -0.22f, 0.15f, -0.35f, 0.15f)
                        reflectiveCurveToRelative(-0.26f, -0.05f, -0.35f, -0.15f)
                        lineToRelative(-2.35f, -2.35f)
                        lineToRelative(-2.35f, 2.35f)
                        curveToRelative(-0.09f, 0.1f, -0.22f, 0.15f, -0.35f, 0.15f)
                        reflectiveCurveToRelative(-0.26f, -0.05f, -0.35f, -0.15f)
                        curveToRelative(-0.2f, -0.19f, -0.2f, -0.51f, 0f, -0.7f)
                        lineToRelative(2.35f, -2.35f)
                        lineToRelative(-2.35f, -2.35f)
                        curveToRelative(-0.2f, -0.19f, -0.2f, -0.51f, 0f, -0.7f)
                        curveToRelative(0.19f, -0.2f, 0.51f, -0.2f, 0.7f, 0f)
                        lineToRelative(2.35f, 2.35f)
                        lineToRelative(2.35f, -2.35f)
                        curveToRelative(0.19f, -0.2f, 0.51f, -0.2f, 0.7f, 0f)
                        curveToRelative(0.2f, 0.19f, 0.2f, 0.51f, 0f, 0.7f)
                        lineToRelative(-2.35f, 2.35f)
                        lineToRelative(2.35f, 2.35f)
                        close()
                    }
                },
                UIKitSymbolDisable()
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce,
                UIKitSymbolAbility.VariableColor,
                UIKitSymbolAbility.Progressable,
                UIKitSymbolAbility.MultiState(listOf("default", "disabled"))
            )

            override val tags: List<String> = listOf()

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when (style) {
                    is UIKitSymbolStyle.Hierarchical -> {
                        val disabled = states.firstOrNull { it.first == "disable" }?.second?.visible == true
                        listOf(
                            UIKitSymbolColor("speaker", style.brush, if (disabled) 0.6f else 1f),
                            UIKitSymbolColor("wave0", style.brush, if (disabled) 0.6f else 0.75f),
                            UIKitSymbolColor("wave1", style.brush, if (disabled) 0.6f else 0.6f),
                            UIKitSymbolColor("wave2", style.brush, if (disabled) 0.6f else 0.45f),
                            UIKitSymbolColor("mute", style.brush, 0.6f),
                            UIKitSymbolColor("disable", style.brush, 1f)
                        )
                    }
                    is UIKitSymbolStyle.Monochrome -> layers.map { layer ->
                        UIKitSymbolColor(
                            layer.id,
                            style.brush,
                            1f
                        )
                    }
                    UIKitSymbolStyle.MultiColor -> layers.map { layer ->
                        UIKitSymbolColor(
                            layer.id,
                            UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush),
                            1f
                        )
                    }
                    is UIKitSymbolStyle.Palette -> style.brushes.mapIndexed { index, brush ->
                        UIKitSymbolColor(
                            layers.getOrNull(index)?.id ?: "unknown",
                            brush,
                            1f
                        )
                    }
                }
            }

            override fun variableColorEffect(
                states: List<UIKitSymbolAnimState>?,
                initialValue: Float,
                targetValue: Float
            ): UIKitSymbolInfiniteAnimTree {
                return UIKitSymbolInfiniteAnimTree(
                    start = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "mute", targetValue = 0f, animateSpec = tween(200, easing = LinearEasing)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave0", targetValue = initialValue, animateSpec = tween(200, easing = LinearEasing)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave1", targetValue = initialValue, animateSpec = tween(200, easing = LinearEasing)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave2", targetValue = initialValue, animateSpec = tween(200, easing = LinearEasing))),
                    body = UIKitSymbolAnimTree()
                        .addSequential(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave0", targetValue = targetValue, animateSpec = tween(200, easing = LinearEasing, delayMillis = 200)))
                        .addSequential(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave1", targetValue = targetValue, animateSpec = tween(200, easing = LinearEasing, delayMillis = 200)))
                        .addSequential(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave2", targetValue = targetValue, animateSpec = tween(200, easing = LinearEasing, delayMillis = 200)))
                        .addSequential(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave0", targetValue = initialValue, animateSpec = tween(200, easing = LinearEasing, delayMillis = 200)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave1", targetValue = initialValue, animateSpec = tween(200, easing = LinearEasing, delayMillis = 200)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave2", targetValue = initialValue, animateSpec = tween(200, easing = LinearEasing, delayMillis = 200))),
                    end = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave0", targetValue = targetValue, animateSpec = tween(200, easing = LinearEasing)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave1", targetValue = targetValue, animateSpec = tween(200, easing = LinearEasing)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "wave2", targetValue = targetValue, animateSpec = tween(200, easing = LinearEasing)))
                )
            }

            override fun progressibleEffect(
                progress: Float,
                states: List<UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addSequential(UIKitSymbolAnimNode.alphaTo(
                        groupSelector = "mute",
                        targetValue = if (progress <= 0f) 1f else 0f,
                        animateSpec = null
                    ))
                    .addParallel(UIKitSymbolAnimNode.alphaTo(
                        groupSelector = "wave0",
                        targetValue = if (progress > 0f) 1f else 0f,
                        animateSpec = null
                    ))
                    .addParallel(UIKitSymbolAnimNode.alphaTo(
                        groupSelector = "wave1",
                        targetValue = if (progress > 0.3f) 1f else if (progress == 0f) 0f else 0.3f,
                        animateSpec = null
                    ))
                    .addParallel(UIKitSymbolAnimNode.alphaTo(
                        groupSelector = "wave2",
                        targetValue = if (progress > 0.6f) 1f else if (progress == 0f) 0f else 0.3f,
                        animateSpec = null
                    ))
            }
        }

        return _Volume!!
    }

@Suppress("ObjectPropertyName")
private var _Volume: UIKitSymbol? = null