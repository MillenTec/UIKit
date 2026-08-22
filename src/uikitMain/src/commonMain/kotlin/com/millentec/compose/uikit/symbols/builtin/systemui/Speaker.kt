package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.materials.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Speaker: UIKitSymbol
    get() {
        if (_Speaker != null)
            return _Speaker!!
        _Speaker = object: UIKitSymbol(
            name = "Speaker Wave 2",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f),
        ) {
            override val layers: List<UIKitSymbolLayer>
                get() = listOf(
                    UIKitSymbolLayer("speaker").apply {
                        group(
                            id = "speaker",
                            drawType = UIKitPathDrawType.Fill
                        ) {
                            moveTo(10.32f, 2.27f)
                            lineToRelative(-3.87f, 3.59f)
                            curveToRelative(-0.09f, 0.09f, -0.21f, 0.13f, -0.34f, 0.13f)
                            horizontalLineToRelative(-2.61f)
                            curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f)
                            verticalLineToRelative(5f)
                            curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
                            horizontalLineToRelative(2.61f)
                            curveToRelative(0.13f, 0f, 0.25f, 0.05f, 0.34f, 0.13f)
                            lineToRelative(3.87f, 3.59f)
                            curveToRelative(0.64f, 0.59f, 1.68f, 0.14f, 1.68f, -0.73f)
                            verticalLineTo(3.01f)
                            curveToRelative(0f, -0.87f, -1.04f, -1.33f, -1.68f, -0.73f)
                            close()
                            moveTo(11f, 16.99f)
                            lineToRelative(-3.87f, -3.59f)
                            curveToRelative(-0.28f, -0.26f, -0.64f, -0.4f, -1.02f, -0.4f)
                            horizontalLineToRelative(-2.61f)
                            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                            verticalLineToRelative(-5f)
                            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                            horizontalLineToRelative(2.61f)
                            curveToRelative(0.38f, 0f, 0.74f, -0.14f, 1.02f, -0.4f)
                            lineToRelative(3.87f, -3.59f)
                            verticalLineToRelative(13.99f)
                            close()
                        }
                    },
                    UIKitSymbolLayer("wave0").apply {
                        group(
                            id = "wave0",
                            drawType = UIKitPathDrawType.Fill,
                        ) {
                            moveTo(14.08f, 12.93f)
                            curveToRelative(-0.24f, -0.14f, -0.32f, -0.44f, -0.18f, -0.68f)
                            curveToRelative(0.78f, -1.35f, 0.83f, -3.06f, 0f, -4.5f)
                            curveToRelative(-0.14f, -0.24f, -0.06f, -0.54f, 0.18f, -0.68f)
                            curveToRelative(0.24f, -0.14f, 0.54f, -0.06f, 0.68f, 0.18f)
                            curveToRelative(1.02f, 1.76f, 0.95f, 3.86f, 0f, 5.5f)
                            curveToRelative(-0.14f, 0.24f, -0.44f, 0.32f, -0.68f, 0.18f)
                            close()
                        }
                    },
                    UIKitSymbolLayer("wave1").apply {
                        group(
                            id = "wave1",
                            drawType = UIKitPathDrawType.Fill,
                        ) {
                            moveTo(15.26f, 4.63f)
                            curveToRelative(0.21f, -0.18f, 0.52f, -0.17f, 0.71f, 0.04f)
                            curveToRelative(2.72f, 3.03f, 2.72f, 7.64f, 0f, 10.67f)
                            curveToRelative(-0.18f, 0.21f, -0.5f, 0.22f, -0.71f, 0.04f)
                            curveToRelative(-0.21f, -0.18f, -0.22f, -0.5f, -0.04f, -0.71f)
                            curveToRelative(2.38f, -2.65f, 2.38f, -6.68f, 0f, -9.33f)
                            curveToRelative(-0.18f, -0.21f, -0.17f, -0.52f, 0.04f, -0.71f)
                            close()
                        }
                    },
                    UIKitSymbolLayer("disable", 1).apply {
                        group(
                            id = "disable.mask",
                            drawType = UIKitPathDrawType.MaskStroke(
                                lineWidth = 1f,
                                cap = StrokeCap.Round,
                                join = StrokeJoin.Round
                            ),
                            defaultState = UIKitSymbolGroupState(
                                pathTrimEnd = 0f
                            )
                        ) {
                            moveTo(3.21f, 1.79f)
                            lineTo(18.2f, 16.8f)
                        }

                        group(
                            id = "disable",
                            drawType = UIKitPathDrawType.Stroke(
                                lineWidth = 1f,
                                cap = StrokeCap.Round,
                                join = StrokeJoin.Round
                            ),
                            defaultState = UIKitSymbolGroupState(
                                pathTrimEnd = 0f
                            )
                        ) {
                            moveTo(2.5f, 2.5f)
                            lineTo(17.5f, 17.5f)
                        }
                    }
                )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce,
                UIKitSymbolAbility.VariableColor,
                UIKitSymbolAbility.MultiState(listOf("default", "disabled"))
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when(style) {
                    is UIKitSymbolStyle.Hierarchical -> {
                        val disabled = states.firstOrNull { it.first == "disable" }?.second?.visible == true
                        listOf(
                            UIKitSymbolColor("speaker", style.brush, if (disabled) 0.6f else 1f),
                            UIKitSymbolColor("wave0", style.brush, if (disabled) 0.6f else 0.75f),
                            UIKitSymbolColor("wave1", style.brush, 0.6f),
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

            override fun stateEffect(state: String, animateStates: List<UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return when (state) {
                    "default" -> {
                        UIKitSymbolAnimTree().addParallel(
                            UIKitSymbolAnimNode.pathTrimStartTo(
                                groupSelector = "disable",
                                targetValue = 0f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        ).addParallel(
                            UIKitSymbolAnimNode.pathTrimEndTo(
                                groupSelector = "disable",
                                targetValue = 0f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        ).addParallel(
                            UIKitSymbolAnimNode.pathTrimStartTo(
                                groupSelector = "disable.mask",
                                targetValue = 0f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        ).addParallel(
                            UIKitSymbolAnimNode.pathTrimEndTo(
                                groupSelector = "disable.mask",
                                targetValue = 0f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        )
                    }
                    "disabled" -> {
                        UIKitSymbolAnimTree().addParallel(
                            UIKitSymbolAnimNode.pathTrimStartTo(
                                groupSelector = "disable",
                                targetValue = 0f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        ).addParallel(
                            UIKitSymbolAnimNode.pathTrimEndTo(
                                groupSelector = "disable",
                                targetValue = 1f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        ).addParallel(
                            UIKitSymbolAnimNode.pathTrimStartTo(
                                groupSelector = "disable.mask",
                                targetValue = 0f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        ).addParallel(
                            UIKitSymbolAnimNode.pathTrimEndTo(
                                groupSelector = "disable.mask",
                                targetValue = 1f,
                                animateSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing)
                            )
                        )
                    }
                    else -> null
                }
            }

            override fun variableColorEffect(states: List<UIKitSymbolAnimState>?): UIKitSymbolInfiniteAnimTree {
                return UIKitSymbolInfiniteAnimTree(
                    start = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave0",
                            targetValue = 0.6f,
                            animateSpec = tween(200, easing = LinearEasing),
                        ))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave1",
                            targetValue = 0.6f,
                            animateSpec = tween(200, easing = LinearEasing)
                        )),
                    body = UIKitSymbolAnimTree()
                        .addSequential(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave0",
                            targetValue = 1f,
                            animateSpec = tween(200, easing = LinearEasing, delayMillis = 200),
                        ))
                        .addSequential(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave1",
                            targetValue = 1f,
                            animateSpec = tween(200, easing = LinearEasing, delayMillis = 200),
                        ))
                        .addSequential(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave0",
                            targetValue = 0.6f,
                            animateSpec = tween(200, easing = LinearEasing, delayMillis = 200),
                        ))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave1",
                            targetValue = 0.6f,
                            animateSpec = tween(200, easing = LinearEasing, delayMillis = 200),
                        )),
                    end = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave0",
                            targetValue = 1f,
                            animateSpec = tween(200, easing = LinearEasing),
                        ))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            groupSelector = "wave1",
                            targetValue = 1f,
                            animateSpec = tween(200, easing = LinearEasing),
                        ))
                )
            }
        }

        return _Speaker!!
    }

@Suppress("ObjectPropertyName")
private var _Speaker: UIKitSymbol? = null