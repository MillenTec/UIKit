package com.millentec.compose.uikit.symbols.regular

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.materials.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitRegularSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitRegularSymbols.AddCircle: UIKitSymbol
    get() {
        if (_AddCircle != null)
            return _AddCircle!!
        _AddCircle = object: UIKitSymbol(
            name = "AddCircle",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f),
        ) {
            override val layers: List<UIKitSymbolLayer>
                get() = listOf(
                    UIKitSymbolLayer("circle").apply {
                        group(
                            id = "circle",
                            drawType = UIKitPathDrawType.Fill,
                        ) {
                            moveTo(10f, 2f)
                            curveTo(5.6f, 2f, 2f, 5.6f, 2f, 10f)
                            reflectiveCurveToRelative(3.6f, 8f, 8f, 8f)
                            reflectiveCurveToRelative(8f, -3.6f, 8f, -8f)
                            reflectiveCurveTo(14.4f, 2f, 10f, 2f)
                            close()
                            moveTo(10f, 17f)
                            curveToRelative(-3.9f, 0f, -7f, -3.1f, -7f, -7f)
                            reflectiveCurveToRelative(3.1f, -7f, 7f, -7f)
                            reflectiveCurveToRelative(7f, 3.1f, 7f, 7f)
                            reflectiveCurveToRelative(-3.1f, 7f, -7f, 7f)
                            close()
                        }
                    },
                    UIKitSymbolLayer("add_symbol", 1).apply {
                        group(
                            id = "add_symbol.horizontal",
                            drawType = UIKitPathDrawType.Stroke(
                                lineWidth = 1f
                            ),
                        ) {
                            moveTo(6.5f, 10f)
                            horizontalLineTo(13.5f)
                        }

                        group(
                            id = "add_symbol.vertical",
                            drawType = UIKitPathDrawType.Stroke(
                                lineWidth = 1f
                            ),
                        ) {
                            moveTo(10f, 6.5f)
                            verticalLineTo(13.5f)
                        }
                    },
                    UIKitSymbolLayer("checkmark_symbol", 1).apply {
                        group(
                            id = "checkmark_symbol",
                            drawType = UIKitPathDrawType.Stroke(
                                lineWidth = 1f
                            ),
                            defaultState = UIKitSymbolGroupState(
                                pathTrimEnd = 0f
                            )
                        ) {
                            moveTo(7f, 10f)
                            lineTo(9f, 12f)
                            lineTo(13f, 8f)
                        }
                    }
                )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce,
                UIKitSymbolAbility.MultiState(listOf("add", "checkmark"))
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when(style) {
                    is UIKitSymbolStyle.Monochrome -> layers.map {
                        UIKitSymbolColor(it.id, style.brush, 1f)
                    }
                    UIKitSymbolStyle.MultiColor -> listOf(
                        UIKitSymbolColor("add_symbol", UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f),
                        UIKitSymbolColor("checkmark_symbol", UIKitBrush.solid(getUIKitColors().successGreenColorPrimaryBrush), 1f),
                        UIKitSymbolColor(
                            "circle",
                            if (states.firstOrNull { it.first == "checkmark_symbol" }?.second?.visible ?: false)
                                UIKitBrush.solid(getUIKitColors().successGreenColorPrimaryBrush)
                            else
                                UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush),
                            0.6f)
                    )
                    is UIKitSymbolStyle.Hierarchical -> listOf(
                        UIKitSymbolColor("add_symbol", style.brush, 1f),
                        UIKitSymbolColor("checkmark_symbol", style.brush, 1f),
                        UIKitSymbolColor("circle", style.brush, 0.6f)
                    )
                    is UIKitSymbolStyle.Palette -> style.brushes.mapIndexed { index, brush ->
                        UIKitSymbolColor(layers.getOrNull(index)?.id ?: "unknown", brush, 1f)
                    }
                }
            }

            override fun stateEffect(
                state: String,
                animateStates: List<UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree? {
                return when (state) {
                    "add" -> {
                        UIKitSymbolAnimTree().addParallel(
                            if (animateStates?.firstOrNull { it.id == "checkmark_symbol" }?.visible ?: false) {
                                UIKitSymbolAnimNode.pathTrimEndTo(
                                    groupSelector = "checkmark_symbol",
                                    targetValue = 0f,
                                    animateSpec = tween(
                                        240,
                                        easing = FastOutLinearInEasing
                                    )
                                )
                            } else null
                        ).addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                            groupSelector = "add_symbol.horizontal",
                            targetValue = 0f,
                            animateSpec = tween(
                                240,
                                easing = LinearOutSlowInEasing
                            )
                        )).addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                            groupSelector = "add_symbol.horizontal",
                            targetValue = 1f,
                            animateSpec = tween(
                                240,
                                easing = LinearOutSlowInEasing
                            )
                        )).addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                            groupSelector = "add_symbol.vertical",
                            targetValue = 0f,
                            animateSpec = tween(
                                240,
                                easing = LinearOutSlowInEasing
                            )
                        )).addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                            groupSelector = "add_symbol.vertical",
                            targetValue = 1f,
                            animateSpec = tween(
                                240,
                                easing = LinearOutSlowInEasing
                            )
                        ))
                    }
                    "checkmark" -> {
                        UIKitSymbolAnimTree().addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                            groupSelector = "add_symbol.horizontal",
                            targetValue = 0.5f,
                            animateSpec = tween(
                                120,
                                easing = FastOutLinearInEasing
                            )
                        )).addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                            groupSelector = "add_symbol.horizontal",
                            targetValue = 0.5f,
                            animateSpec = tween(
                                120,
                                easing = FastOutLinearInEasing
                            )
                        )).addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                            groupSelector = "add_symbol.vertical",
                            targetValue = 0.5f,
                            animateSpec = tween(
                                120,
                                easing = FastOutLinearInEasing
                            )
                        )).addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                            groupSelector = "add_symbol.vertical",
                            targetValue = 0.5f,
                            animateSpec = tween(
                                120,
                                easing = FastOutLinearInEasing
                            )
                        )).addSequential(UIKitSymbolAnimNode.pathTrimEndTo(
                            groupSelector = "checkmark_symbol",
                            targetValue = 1f,
                            animateSpec = tween(
                                420,
                                easing = LinearOutSlowInEasing
                            )
                        ))
                    }
                    else -> null
                }
            }
        }

        return _AddCircle!!
    }

@Suppress("ObjectPropertyName")
private var _AddCircle: UIKitSymbol? = null