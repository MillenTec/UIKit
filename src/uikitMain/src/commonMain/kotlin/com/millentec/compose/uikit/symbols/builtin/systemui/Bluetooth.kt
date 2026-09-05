package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
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
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolDisable
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Bluetooth: UIKitSymbol
    get() {
        if (_Bluetooth != null)
            return _Bluetooth!!
        _Bluetooth = object : UIKitSymbol(
            name = "Bluetooth",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("bluetooth_back").apply {
                    group(
                        id = "bluetooth_back",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        ),
                        defaultState = UIKitSymbolGroupState(alpha = 0f)
                    ) {
                        moveTo(5.5f, 13.5f)
                        lineToRelative(7.96f, -6.96f)
                        reflectiveCurveToRelative(0.02f, -0.05f, 0f, -0.07f)
                        lineToRelative(-3.88f, -3.88f)
                        reflectiveCurveToRelative(-0.09f, 0f, -0.09f, 0.04f)
                        verticalLineToRelative(14.76f)
                        reflectiveCurveToRelative(0.05f, 0.07f, 0.09f, 0.04f)
                        lineToRelative(3.88f, -3.88f)
                        reflectiveCurveToRelative(0.02f, -0.05f, 0f, -0.07f)
                        lineToRelative(-7.96f, -6.96f)
                    }
                },
                UIKitSymbolLayer("bluetooth").apply {
                    group(
                        id = "bluetooth",
                        drawType = UIKitPathDrawType.Stroke(
                            lineWidth = 1f
                        )
                    ) {
                        moveTo(5.5f, 13.5f)
                        lineToRelative(7.96f, -6.96f)
                        reflectiveCurveToRelative(0.02f, -0.05f, 0f, -0.07f)
                        lineToRelative(-3.88f, -3.88f)
                        reflectiveCurveToRelative(-0.09f, 0f, -0.09f, 0.04f)
                        verticalLineToRelative(14.76f)
                        reflectiveCurveToRelative(0.05f, 0.07f, 0.09f, 0.04f)
                        lineToRelative(3.88f, -3.88f)
                        reflectiveCurveToRelative(0.02f, -0.05f, 0f, -0.07f)
                        lineToRelative(-7.96f, -6.96f)
                    }
                },
                UIKitSymbolDisable()
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce,
                UIKitSymbolAbility.MultiState(listOf("default", "disabled"))
            )

            override val tags: List<String> = listOf(
                "Bluetooth", "Link", "Connect"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when (style) {
                    is UIKitSymbolStyle.Hierarchical -> {
                        val disabled = states.firstOrNull { it.first == "disable" }?.second?.visible == true
                        listOf(
                            UIKitSymbolColor("bluetooth", style.brush, if (disabled) 0.6f else 1f),
                            UIKitSymbolColor("bluetooth_back", style.brush, if (disabled) 0.6f else 1f),
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

            override fun appearEffect(states: List<UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                if (states?.firstOrNull { it.id == "disable" }?.visible(listOf(UIKitAnimSelector.PathTrimEnd)) == true)
                    return super.appearEffect(states)?.addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                        groupSelector = "bluetooth",
                        targetValue = 1f,
                        animateSpec = null
                    ))?.addParallel(UIKitSymbolAnimNode.alphaAdditionTo(
                        groupSelector = "bluetooth_back",
                        targetValue = 1f,
                        animateSpec = null
                    ))

                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.alphaAdditionTo(groupSelector = "bluetooth_back", targetValue = 1f, animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(groupSelector = "bluetooth", targetValue = 0f, animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(groupSelector = "bluetooth", targetValue = 0f, animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.alphaAdditionTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(200, easing = LinearOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.scaleTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(200, easing = LinearOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.alphaAdditionTo(groupSelector = "disable", targetValue = 1f, animateSpec = tween(200, easing = LinearOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.scaleTo(groupSelector = "disable", targetValue = 1f, animateSpec = tween(200, easing = LinearOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.alphaAdditionTo(groupSelector = "disable.mask", targetValue = 1f, animateSpec = tween(200, easing = LinearOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.scaleTo(groupSelector = "disable.mask", targetValue = 1f, animateSpec = tween(200, easing = LinearOutSlowInEasing)))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(800, easing = FastOutSlowInEasing)))
            }

            override fun disappearEffect(states: List<UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                if (states?.firstOrNull { it.id == "disable" }?.visible(listOf(UIKitAnimSelector.PathTrimEnd)) == true)
                    return super.disappearEffect(states)

                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(groupSelector = "bluetooth", targetValue = 0f, animateSpec = null))
                    .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = null))
                    .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(800, easing = FastOutSlowInEasing)))
            }

            override fun variableColorEffect(
                states: List<UIKitSymbolAnimState>?,
                initialValue: Float,
                targetValue: Float
            ): UIKitSymbolInfiniteAnimTree {
                return UIKitSymbolInfiniteAnimTree(
                    start = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "bluetooth_back", targetValue = initialValue, animateSpec = tween(200)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "bluetooth", targetValue = targetValue, animateSpec = tween(200)))
                        .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(800, easing = FastOutSlowInEasing)))
                        .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(800, easing = FastOutSlowInEasing))),
                    body = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(groupSelector = "bluetooth", targetValue = 0f, animateSpec = null))
                        .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(groupSelector = "bluetooth", targetValue = 0f, animateSpec = null))
                        .addSequential(UIKitSymbolAnimNode.pathTrimEndTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(800, easing = FastOutSlowInEasing, delayMillis = 200)))
                        .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(800, easing = FastOutSlowInEasing, delayMillis = 200))),
                    end = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = tween(800, easing = FastOutSlowInEasing)))
                        .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(groupSelector = "bluetooth", targetValue = 0f, animateSpec = tween(800, easing = FastOutSlowInEasing)))
                        .addSequential(UIKitSymbolAnimNode.alphaTo(groupSelector = "bluetooth_back", targetValue = 0f, animateSpec = null))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(groupSelector = "bluetooth", targetValue = 1f, animateSpec = null))
                )
            }
        }

        return _Bluetooth!!
    }

@Suppress("ObjectPropertyName")
private var _Bluetooth: UIKitSymbol? = null