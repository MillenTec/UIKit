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
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Bluetooth: UIKitSymbol
    get() {
        if (_Bluetooth != null)
            return _Bluetooth!!
        _Bluetooth = object : UIKitSymbol(
            name = "Bluetooth",
            uid = "ic.sys.bluetooth",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("bluetooth_back") {
                    addGroup(
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
                }

                addLayer("bluetooth", 1) {
                    addGroup(
                        id = "bluetooth",
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
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce,
                UIKitSymbolAbility.VariableColor,
                UIKitSymbolAbility.MultiState(listOf("default", "disabled"))
            )

            override val tags: List<String> = listOf(
                "Bluetooth", "Link", "Connect"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(this, "bluetooth", null), 1f),
                        Pair(UIKitSymbolSelector(this, "bluetooth_back", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(this, "bluetooth", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(this, "bluetooth_back", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f)
                        )
                    )
                )
            }

            override fun appearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(
                        UIKitSymbolAnimNode.alphaAdditionTo(
                            selector = UIKitSymbolSelector(this, null, null),
                            targetValue = 1f,
                            animateSpec = null
                        )
                    )
                    .addParallel(
                        UIKitSymbolAnimNode.pathTrimStartTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 0f,
                            animateSpec = null
                        )
                    )
                    .addParallel(
                        UIKitSymbolAnimNode.pathTrimEndTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 0f,
                            animateSpec = null
                        )
                    )
                    .addSequential(
                        UIKitSymbolAnimNode.alphaAdditionTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = tween(200, easing = LinearOutSlowInEasing)
                        )
                    )
                    .addParallel(
                        UIKitSymbolAnimNode.scaleTo(
                            selector = UIKitSymbolSelector(this, null, null),
                            targetValue = 1f,
                            animateSpec = tween(200, easing = LinearOutSlowInEasing)
                        )
                    )
            }

            override fun disappearEffect(states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?): UIKitSymbolAnimTree? {
                return UIKitSymbolAnimTree()
                    .addParallel(
                        UIKitSymbolAnimNode.pathTrimStartTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 0f,
                            animateSpec = null
                        )
                    )
                    .addParallel(
                        UIKitSymbolAnimNode.pathTrimEndTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = null
                        )
                    )
                    .addSequential(
                        UIKitSymbolAnimNode.pathTrimStartTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = tween(800, easing = FastOutSlowInEasing)
                        )
                    )
            }

            override fun variableColorEffect(
                states: Map<UIKitSymbolSelector, UIKitSymbolAnimState>?,
                initialValue: Float,
                targetValue: Float
            ): UIKitSymbolInfiniteAnimTree {
                return UIKitSymbolInfiniteAnimTree(
                    start = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            selector = UIKitSymbolSelector(this, "bluetooth_back", "bluetooth_back"),
                            targetValue = initialValue,
                            animateSpec = tween(200)))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = targetValue,
                            animateSpec = tween(200)))
                        .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = tween(800, easing = FastOutSlowInEasing)))
                        .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = tween(800, easing = FastOutSlowInEasing))),
                    body = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 0f,
                            animateSpec = null))
                        .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 0f,
                            animateSpec = null))
                        .addSequential(UIKitSymbolAnimNode.pathTrimEndTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = tween(800, easing = FastOutSlowInEasing, delayMillis = 200)))
                        .addSequential(UIKitSymbolAnimNode.pathTrimStartTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = tween(800, easing = FastOutSlowInEasing, delayMillis = 200))),
                    end = UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.pathTrimEndTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = tween(800, easing = FastOutSlowInEasing)))
                        .addParallel(UIKitSymbolAnimNode.pathTrimStartTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 0f,
                            animateSpec = tween(800, easing = FastOutSlowInEasing)))
                        .addSequential(UIKitSymbolAnimNode.alphaTo(
                            selector = UIKitSymbolSelector(this, "bluetooth_back", "bluetooth_back"),
                            targetValue = 0f,
                            animateSpec = null))
                        .addParallel(UIKitSymbolAnimNode.alphaTo(
                            selector = UIKitSymbolSelector(this, "bluetooth", "bluetooth"),
                            targetValue = 1f,
                            animateSpec = null))
                )
            }
        }

        return _Bluetooth!!
    }

@Suppress("ObjectPropertyName")
private var _Bluetooth: UIKitSymbol? = null