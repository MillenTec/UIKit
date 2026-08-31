package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimNode
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimState
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolAnimTree
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.ToggleMultiple: UIKitSymbol
    get() {
        if (_ToggleMultiple != null)
            return _ToggleMultiple!!
        _ToggleMultiple = object : UIKitSymbol(
            name = "ToggleMultiple",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("thumb0").apply {
                    group(
                        id = "thumb0",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(3.5f, 2f)
                        curveToRelative(0.41f, 0f, 0.79f, 0.17f, 1.06f, 0.44f)
                        reflectiveCurveToRelative(0.44f, 0.65f, 0.44f, 1.06f)
                        reflectiveCurveToRelative(-0.17f, 0.79f, -0.44f, 1.06f)
                        reflectiveCurveToRelative(-0.65f, 0.44f, -1.06f, 0.44f)
                        reflectiveCurveToRelative(-0.79f, -0.17f, -1.06f, -0.44f)
                        reflectiveCurveToRelative(-0.44f, -0.65f, -0.44f, -1.06f)
                        reflectiveCurveToRelative(0.17f, -0.79f, 0.44f, -1.06f)
                        reflectiveCurveToRelative(0.65f, -0.44f, 1.06f, -0.44f)
                        close()
                    }
                },
                UIKitSymbolLayer("container0").apply {
                    group(
                        id = "container0",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10.5f, 0f)
                        horizontalLineTo(3.5f)
                        curveTo(1.6f, 0f, 0f, 1.6f, 0f, 3.5f)
                        reflectiveCurveToRelative(1.6f, 3.5f, 3.5f, 3.5f)
                        horizontalLineToRelative(7f)
                        curveToRelative(1.9f, 0f, 3.5f, -1.6f, 3.5f, -3.5f)
                        reflectiveCurveToRelative(-1.6f, -3.5f, -3.5f, -3.5f)
                        close()
                        moveTo(10.5f, 6f)
                        horizontalLineTo(3.5f)
                        curveToRelative(-1.4f, 0f, -2.5f, -1.1f, -2.5f, -2.5f)
                        reflectiveCurveTo(2.1f, 1f, 3.5f, 1f)
                        horizontalLineToRelative(7f)
                        curveToRelative(1.4f, 0f, 2.5f, 1.1f, 2.5f, 2.5f)
                        reflectiveCurveToRelative(-1.1f, 2.5f, -2.5f, 2.5f)
                        close()
                    }
                },
                UIKitSymbolLayer("thumb1").apply {
                    group(
                        id = "thumb1",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10.5f, 11f)
                        curveToRelative(0.41f, 0f, 0.79f, 0.17f, 1.06f, 0.44f)
                        reflectiveCurveToRelative(0.44f, 0.65f, 0.44f, 1.06f)
                        reflectiveCurveToRelative(-0.17f, 0.79f, -0.44f, 1.06f)
                        reflectiveCurveToRelative(-0.65f, 0.44f, -1.06f, 0.44f)
                        reflectiveCurveToRelative(-0.79f, -0.17f, -1.06f, -0.44f)
                        reflectiveCurveToRelative(-0.44f, -0.65f, -0.44f, -1.06f)
                        reflectiveCurveToRelative(0.17f, -0.79f, 0.44f, -1.06f)
                        reflectiveCurveToRelative(0.65f, -0.44f, 1.06f, -0.44f)
                        close()
                    }
                },
                UIKitSymbolLayer("container1").apply {
                    group(
                        id = "container1",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10.5f, 9f)
                        horizontalLineTo(3.5f)
                        curveToRelative(-1.9f, 0f, -3.5f, 1.6f, -3.5f, 3.5f)
                        reflectiveCurveToRelative(1.6f, 3.5f, 3.5f, 3.5f)
                        horizontalLineToRelative(7f)
                        curveToRelative(1.9f, 0f, 3.5f, -1.6f, 3.5f, -3.5f)
                        reflectiveCurveToRelative(-1.6f, -3.5f, -3.5f, -3.5f)
                        close()
                        moveTo(10.5f, 15f)
                        horizontalLineTo(3.5f)
                        curveToRelative(-1.4f, 0f, -2.5f, -1.1f, -2.5f, -2.5f)
                        reflectiveCurveToRelative(1.1f, -2.5f, 2.5f, -2.5f)
                        horizontalLineToRelative(7f)
                        curveToRelative(1.4f, 0f, 2.5f, 1.1f, 2.5f, 2.5f)
                        reflectiveCurveToRelative(-1.1f, 2.5f, -2.5f, 2.5f)
                        close()
                    }
                }
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce,
                UIKitSymbolAbility.MultiState(listOf("default", "on", "off", "on-off"))
            )

            override val tags: List<String> = listOf(
                "Toggle", "Multiple", "Setting", "Option"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when (style) {
                    is UIKitSymbolStyle.Hierarchical -> {
                        listOf(
                            UIKitSymbolColor("thumb0", style.brush, 1f),
                            UIKitSymbolColor("thumb1", style.brush, 1f),
                            UIKitSymbolColor("container0", style.brush, 0.6f),
                            UIKitSymbolColor("container1", style.brush, 0.6f)
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

            override fun stateEffect(
                state: String,
                animateStates: List<UIKitSymbolAnimState>?
            ): UIKitSymbolAnimTree? {
                return when (state) {
                    "default" -> UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb0",
                            targetValue = 0f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb1",
                            targetValue = 0f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                    "on" -> UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb0",
                            targetValue = 7f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb1",
                            targetValue = 0f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                    "off" -> UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb0",
                            targetValue = 0f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb1",
                            targetValue = -7f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                    "on-off" -> UIKitSymbolAnimTree()
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb0",
                            targetValue = 7f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                        .addParallel(UIKitSymbolAnimNode.translateXTo(
                            groupSelector = "thumb1",
                            targetValue = -7f,
                            animateSpec = spring(
                                dampingRatio = 0.7f,
                                stiffness = 240f
                            )
                        ))
                    else -> null
                }
            }

            override fun bounceEffect(
                states: List<UIKitSymbolAnimState>?,
                coefficient: Float
            ): UIKitSymbolAnimTree {
                return UIKitSymbolAnimTree()
                    .addParallel(UIKitSymbolAnimNode.translateXTo(
                        groupSelector = "thumb0",
                        targetValue = 7f,
                        animateSpec = spring(
                            dampingRatio = 0.7f,
                            stiffness = 240f
                        )
                    ))
                    .addParallel(UIKitSymbolAnimNode.translateXTo(
                        groupSelector = "thumb1",
                        targetValue = -7f,
                        animateSpec = spring(
                            dampingRatio = 0.7f,
                            stiffness = 240f
                        )
                    ))
                    .addSequential(UIKitSymbolAnimNode.translateXTo(
                        groupSelector = "thumb0",
                        targetValue = 0f,
                        animateSpec = spring(
                            dampingRatio = 0.7f,
                            stiffness = 240f
                        )
                    ))
                    .addParallel(UIKitSymbolAnimNode.translateXTo(
                        groupSelector = "thumb1",
                        targetValue = 0f,
                        animateSpec = spring(
                            dampingRatio = 0.7f,
                            stiffness = 240f
                        )
                    ))
            }
        }

        return _ToggleMultiple!!
    }

@Suppress("ObjectPropertyName")
private var _ToggleMultiple: UIKitSymbol? = null