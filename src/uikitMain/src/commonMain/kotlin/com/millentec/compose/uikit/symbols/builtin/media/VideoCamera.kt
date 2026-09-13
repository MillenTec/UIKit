package com.millentec.compose.uikit.symbols.builtin.media

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitMediaSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolDisable
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitMediaSymbols.VideoCamera: UIKitSymbol
    get() {
        if (_VideoCamera != null)
            return _VideoCamera!!
        _VideoCamera = object : UIKitSymbol(
            name = "VideoCamera",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("camera").apply {
                    group(
                        id = "camera",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(5f, 4f)
                        curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f)
                        verticalLineToRelative(6f)
                        curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f)
                        horizontalLineToRelative(5f)
                        curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f)
                        verticalLineToRelative(-0.32f)
                        lineToRelative(3.04f, 2.1f)
                        curveToRelative(0.83f, 0.57f, 1.96f, -0.02f, 1.96f, -1.03f)
                        verticalLineToRelative(-7.5f)
                        curveToRelative(0f, -1.01f, -1.13f, -1.6f, -1.96f, -1.03f)
                        lineToRelative(-3.04f, 2.1f)
                        verticalLineToRelative(-0.32f)
                        curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f)
                        horizontalLineToRelative(-5f)
                        close()
                        moveTo(13f, 8.54f)
                        lineToRelative(3.61f, -2.49f)
                        curveToRelative(0.17f, -0.11f, 0.39f, 0f, 0.39f, 0.21f)
                        verticalLineToRelative(7.5f)
                        curveToRelative(0f, 0.2f, -0.23f, 0.32f, -0.39f, 0.21f)
                        lineToRelative(-3.61f, -2.49f)
                        verticalLineToRelative(-2.93f)
                        close()
                        moveTo(3f, 7f)
                        curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                        horizontalLineToRelative(5f)
                        curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
                        verticalLineToRelative(6f)
                        curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f)
                        horizontalLineToRelative(-5f)
                        curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f)
                        verticalLineToRelative(-6f)
                        close()
                    }
                },
                UIKitSymbolLayer("mask", 1).apply {
                    group(
                        id = "mask",
                        drawType = UIKitPathDrawType.MaskFilled,
                        defaultState = UIKitSymbolGroupState(scaleCenter = Offset(2.75f, 17.25f), scale = 0.6f, alpha = 0f)
                    ) {
                        moveTo(11f, 14.5f)
                        curveToRelative(0f, 1.52f, -0.62f, 2.89f, -1.61f, 3.89f)
                        reflectiveCurveToRelative(-2.37f, 1.61f, -3.89f, 1.61f)
                        reflectiveCurveToRelative(-2.89f, -0.62f, -3.89f, -1.61f)
                        reflectiveCurveToRelative(-1.61f, -2.37f, -1.61f, -3.89f)
                        reflectiveCurveToRelative(0.62f, -2.89f, 1.61f, -3.89f)
                        reflectiveCurveToRelative(2.37f, -1.61f, 3.89f, -1.61f)
                        reflectiveCurveToRelative(2.89f, 0.62f, 3.89f, 1.61f)
                        reflectiveCurveToRelative(1.61f, 2.37f, 1.61f, 3.89f)
                        close()
                    }
                },
                UIKitSymbolLayer("add_symbol", 1).apply {
                    group(
                        id = "add_symbol",
                        drawType = UIKitPathDrawType.Fill,
                        defaultState = UIKitSymbolGroupState(scaleCenter = Offset(2.75f, 17.25f), scale = 0.6f, alpha = 0f)
                    ) {
                        moveTo(5.5f, 10f)
                        curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
                        reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
                        reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
                        reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
                        close()
                        moveTo(7.5f, 15f)
                        horizontalLineToRelative(-1.5f)
                        verticalLineToRelative(1.5f)
                        curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                        reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                        verticalLineToRelative(-1.5f)
                        horizontalLineToRelative(-1.5f)
                        curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                        reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                        horizontalLineToRelative(1.5f)
                        verticalLineToRelative(-1.5f)
                        curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                        reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                        verticalLineToRelative(1.5f)
                        horizontalLineToRelative(1.5f)
                        curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                        reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
                        close()
                    }
                },
                UIKitSymbolLayer("error_symbol", 1).apply {
                    group(
                        id = "error_symbol",
                        drawType = UIKitPathDrawType.Fill,
                        defaultState = UIKitSymbolGroupState(scaleCenter = Offset(2.75f, 17.25f), scale = 0.6f, alpha = 0f)
                    ) {
                        moveTo(5.5f, 10f)
                        curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
                        reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
                        reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
                        reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
                        close()
                        moveTo(2f, 14.5f)
                        curveToRelative(0f, -1.93f, 1.57f, -3.5f, 3.5f, -3.5f)
                        curveToRelative(0.79f, 0f, 1.51f, 0.26f, 2.1f, 0.7f)
                        lineToRelative(-4.9f, 4.9f)
                        curveToRelative(-0.44f, -0.58f, -0.7f, -1.31f, -0.7f, -2.1f)
                        close()
                        moveTo(5.5f, 18f)
                        curveToRelative(-0.79f, 0f, -1.51f, -0.26f, -2.1f, -0.7f)
                        lineToRelative(4.9f, -4.9f)
                        curveToRelative(0.44f, 0.58f, 0.7f, 1.31f, 0.7f, 2.1f)
                        curveToRelative(0f, 1.93f, -1.57f, 3.5f, -3.5f, 3.5f)
                        close()
                    }
                },
                UIKitSymbolLayer("settings_symbol", 1).apply {
                    group(
                        id = "settings_symbol",
                        drawType = UIKitPathDrawType.Fill,
                        defaultState = UIKitSymbolGroupState(scaleCenter = Offset(2.75f, 17.25f), scale = 0.6f, alpha = 0f)
                    ) {
                        moveTo(9.82f, 13.95f)
                        lineToRelative(-0.35f, -0.08f)
                        curveToRelative(-1.12f, -0.26f, -1.79f, -1.42f, -1.46f, -2.52f)
                        lineToRelative(0.13f, -0.42f)
                        curveToRelative(-0.26f, -0.2f, -0.54f, -0.38f, -0.83f, -0.52f)
                        lineToRelative(-0.32f, 0.34f)
                        curveToRelative(-0.79f, 0.84f, -2.12f, 0.84f, -2.91f, 0f)
                        lineToRelative(-0.34f, -0.36f)
                        curveToRelative(-0.29f, 0.13f, -0.57f, 0.3f, -0.82f, 0.5f)
                        lineToRelative(0.16f, 0.56f)
                        curveToRelative(0.3f, 1.08f, -0.34f, 2.2f, -1.43f, 2.48f)
                        lineToRelative(-0.46f, 0.12f)
                        curveToRelative(-0.01f, 0.15f, -0.02f, 0.31f, -0.02f, 0.46f)
                        curveToRelative(0f, 0.19f, 0.01f, 0.37f, 0.03f, 0.55f)
                        lineToRelative(0.35f, 0.08f)
                        curveToRelative(1.12f, 0.26f, 1.79f, 1.42f, 1.46f, 2.52f)
                        lineToRelative(-0.13f, 0.42f)
                        curveToRelative(0.26f, 0.2f, 0.54f, 0.38f, 0.83f, 0.52f)
                        lineToRelative(0.32f, -0.34f)
                        curveToRelative(0.79f, -0.84f, 2.12f, -0.84f, 2.91f, 0f)
                        lineToRelative(0.34f, 0.36f)
                        curveToRelative(0.29f, -0.13f, 0.57f, -0.3f, 0.82f, -0.5f)
                        lineToRelative(-0.16f, -0.56f)
                        curveToRelative(-0.3f, -1.08f, 0.34f, -2.2f, 1.43f, -2.48f)
                        lineToRelative(0.46f, -0.12f)
                        curveToRelative(0.02f, -0.15f, 0.02f, -0.31f, 0.02f, -0.46f)
                        curveToRelative(0f, -0.19f, -0.01f, -0.37f, -0.03f, -0.55f)
                        close()
                        moveTo(5.5f, 15.5f)
                        curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                        reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
                        reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
                        reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
                        close()
                    }
                },
                UIKitSymbolDisable(2)
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce,
                UIKitSymbolAbility.MultiState(listOf(
                    "default", "disabled", "add", "error", "settings",
                    "add-disabled", "error-disabled", "settings-disabled"
                ))
            )

            override val tags: List<String> = listOf(
                "Camera", "Video", "Movie", "Record", "Media"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                val disabled = states.firstOrNull { it.first == "disable" }?.second?.visible == true
                val isSecondary = states.filter { "symbol" in it.first || it.first == "disable" }.any { it.second.visible }
                return UIKitSymbolColorSet(
                    style,
                    layers = layers,
                    layerInfo = listOf(
                        Pair("camera", if (isSecondary) 0.6f else 1f),
                        Pair("disable", 1f),
                        Pair("add_symbol", if (disabled) 0.6f else 1f),
                        Pair("error_symbol", if (disabled) 0.6f else 1f),
                        Pair("settings_symbol", if (disabled) 0.6f else 1f)
                    ),
                    multiColor = listOf(
                        UIKitSymbolColor("camera", UIKitBrush.solid(if (disabled) getUIKitColors().lineFillColorDisabled else getUIKitColors().textFillColorPrimaryBrush), 1f),
                        UIKitSymbolColor("disable", UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush), 1f),
                        UIKitSymbolColor("add_symbol", UIKitBrush.solid(if (disabled) getUIKitColors().lineFillColorDisabled else getUIKitColors().successGreenColorPrimaryBrush), 1f),
                        UIKitSymbolColor("error_symbol", UIKitBrush.solid(if (disabled) getUIKitColors().lineFillColorDisabled else getUIKitColors().errorRedColorPrimaryBrush), 1f),
                        UIKitSymbolColor("settings_symbol", UIKitBrush.solid(if (disabled) getUIKitColors().lineFillColorDisabled else getUIKitColors().highlightColorPrimaryBrush), 1f)
                    ),
                )
            }

            private fun UIKitSymbolAnimTree.enable(): UIKitSymbolAnimTree {
                return addParallel(
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

            private fun UIKitSymbolAnimTree.disable(): UIKitSymbolAnimTree {
                return addParallel(
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

            private fun UIKitSymbolAnimTree.switchToSubsymbol(id: String, animateStates: List<UIKitSymbolAnimState>?, disabled: Boolean = false): UIKitSymbolAnimTree {
                if (!disabled && animateStates?.firstOrNull { it.id == "disable" }?.visible == true) enable().addSequential(null)
                else if (disabled && animateStates?.firstOrNull { it.id == "disable" }?.visible != true) disable().addSequential(null)

                val subsymbols = groups.filter { group ->
                    ("symbol" in group.id || group.id == "mask") && animateStates?.firstOrNull { it.id == group.id }
                        ?.visible(listOf(UIKitAnimSelector.Alpha)) == true
                }

                if (subsymbols.isNotEmpty()) {
                    subsymbols.forEach { subsymbol ->
                        addParallel(UIKitSymbolAnimNode.scaleCenterXTo(
                            subsymbol.id,
                            5.5f,
                            animateSpec = null
                        )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                            subsymbol.id,
                            14.5f,
                            animateSpec = null
                        ))
                    }
                    addSequential(null)
                    subsymbols.forEach { subsymbol ->
                        addParallel(UIKitSymbolAnimNode.scaleTo(
                            subsymbol.id,
                            0.8f,
                            animateSpec = tween(130, easing = FastOutLinearInEasing)
                        ))
                    }
                    addSequential(null)
                    subsymbols.forEach { subsymbol ->
                        if (subsymbol.id != "mask")
                            addParallel(UIKitSymbolAnimNode.alphaTo(
                                subsymbol.id,
                                0f,
                                animateSpec = null
                            ))
                    }

                    addSequential(UIKitSymbolAnimNode.scaleCenterXTo(
                        id,
                        5.5f,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                        id,
                        14.5f,
                        animateSpec = null
                    )).addSequential(UIKitSymbolAnimNode.scaleTo(
                        id,
                        0.8f,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.alphaTo(
                        id,
                        1f,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleTo(
                        id,
                        1f,
                        animateSpec = tween(130, easing = LinearOutSlowInEasing)
                    )).addParallel(UIKitSymbolAnimNode.alphaTo(
                        "mask",
                        1f,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleTo(
                        "mask",
                        1f,
                        animateSpec = tween(130, easing = LinearOutSlowInEasing)
                    ))
                } else {
                    addParallel(UIKitSymbolAnimNode.scaleCenterXTo(
                        id,
                        2.75f,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                        id,
                        17.25f,
                        animateSpec = null
                    )).addSequential(UIKitSymbolAnimNode.alphaTo(
                        id,
                        1f,
                        animateSpec = spring(dampingRatio = 0.7f, stiffness = 320f)
                    )).addParallel(UIKitSymbolAnimNode.scaleTo(
                        id,
                        1f,
                        animateSpec = spring(dampingRatio = 0.7f, stiffness = 240f)
                    )).addParallel(UIKitSymbolAnimNode.alphaTo(
                        "mask",
                        1f,
                        animateSpec = null
                    )).addParallel(UIKitSymbolAnimNode.scaleTo(
                        "mask",
                        1f,
                        animateSpec = spring(dampingRatio = 0.7f, stiffness = 240f)
                    ))
                }

                return this
            }

            override fun stateEffect(
                state: String,
                animateStates: List<UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree? {
                return when (state) {
                    "default" -> {
                        UIKitSymbolAnimTree().apply {
                            groups.filter { group ->
                                ("symbol" in group.id || group.id == "mask") && animateStates?.firstOrNull { it.id == group.id }
                                    ?.visible(listOf(UIKitAnimSelector.Alpha)) == true
                            }.let {
                                it.forEach { group ->
                                    addSequential(UIKitSymbolAnimNode.scaleCenterXTo(
                                        group.id,
                                        2.75f,
                                        animateSpec = null
                                    )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                                        group.id,
                                        17.25f,
                                        animateSpec = null
                                    ))
                                }
                                addSequential(null)
                                it.forEach { group ->
                                    addParallel(UIKitSymbolAnimNode.scaleTo(
                                        group.id,
                                        if (group.id == "mask") 0.2f else 0.6f,
                                        animateSpec = tween(260, easing = FastOutSlowInEasing)
                                    )).addParallel(UIKitSymbolAnimNode.alphaTo(
                                        group.id,
                                        0f,
                                        animateSpec = tween(260, easing = FastOutSlowInEasing)
                                    ))
                                }
                            }
                        }.enable()
                    }
                    "disabled" -> {
                        UIKitSymbolAnimTree().apply {
                            groups.filter { group ->
                                ("symbol" in group.id || group.id == "mask") && animateStates?.firstOrNull { it.id == group.id }
                                    ?.visible(listOf(UIKitAnimSelector.Alpha)) == true
                            }.let {
                                it.forEach { group ->
                                    addSequential(UIKitSymbolAnimNode.scaleCenterXTo(
                                        group.id,
                                        2.75f,
                                        animateSpec = null
                                    )).addParallel(UIKitSymbolAnimNode.scaleCenterYTo(
                                        group.id,
                                        17.25f,
                                        animateSpec = null
                                    ))
                                }
                                addSequential(null)
                                it.forEach { group ->
                                    addParallel(UIKitSymbolAnimNode.scaleTo(
                                        group.id,
                                        if (group.id == "mask") 0.2f else 0.6f,
                                        animateSpec = tween(260, easing = FastOutSlowInEasing)
                                    )).addParallel(UIKitSymbolAnimNode.alphaTo(
                                        group.id,
                                        0f,
                                        animateSpec = tween(260, easing = FastOutSlowInEasing)
                                    ))
                                }
                            }
                        }.disable()
                    }
                    "add" -> UIKitSymbolAnimTree().switchToSubsymbol("add_symbol", animateStates, false)
                    "error" -> UIKitSymbolAnimTree().switchToSubsymbol("error_symbol", animateStates, false)
                    "settings" -> UIKitSymbolAnimTree().switchToSubsymbol("settings_symbol", animateStates, false)
                    "add-disabled" -> UIKitSymbolAnimTree().switchToSubsymbol("add_symbol", animateStates, true)
                    "error-disabled" -> UIKitSymbolAnimTree().switchToSubsymbol("error_symbol", animateStates, true)
                    "settings-disabled" -> UIKitSymbolAnimTree().switchToSubsymbol("settings_symbol", animateStates, true)
                    else -> null
                }
            }
        }

        return _VideoCamera!!
    }

@Suppress("ObjectPropertyName")
private var _VideoCamera: UIKitSymbol? = null