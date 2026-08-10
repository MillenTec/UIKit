package com.millentec.compose.uikit.symbols.uikitsymbols.animatable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
@Preview
private fun Preview() {
    UIKitSymbols.AnimatableIcons.AddCircleFilled(
        modifier = Modifier.size(50.dp),
        state = UIKitAddCircleAnimateState.Success
    )
}

enum class UIKitAddCircleAnimateState {
    Add,
    Error,
    Success,
}

@Composable
fun UIKitSymbols.AnimatableIcons.AddCircleFilled(
    modifier: Modifier = Modifier,
    state: UIKitAddCircleAnimateState = UIKitAddCircleAnimateState.Add,
    tint: Brush,
    lineWidth: Dp = 1.dp
) {
    val defaultSize = DpSize(20.dp, 20.dp)
    val uikitAnimate = getUIKitAnimate()

    val successIconAnimated = remember { Animatable(
        if (state == UIKitAddCircleAnimateState.Success) 1f else 0f,
        typeConverter = Float.VectorConverter,
    ) }

    val addIconStartAnimated = remember { Animatable(
        if (state != UIKitAddCircleAnimateState.Success) 0f else 0.5f,
        typeConverter = Float.VectorConverter,
    ) }

    val addIconEndAnimated = remember { Animatable(
        if (state != UIKitAddCircleAnimateState.Success) 1f else 0.5f,
        typeConverter = Float.VectorConverter,
    )}

    val addIconRotateAnimated = remember { Animatable(
        if (state == UIKitAddCircleAnimateState.Add) 0f else 45f,
        typeConverter = Float.VectorConverter,
    )}

    LaunchedEffect(state) {
        when (state) {
            UIKitAddCircleAnimateState.Add -> {
                if (successIconAnimated.value != 0f) {
                    successIconAnimated.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                    )
                }
                coroutineScope {
                    launch {
                        addIconRotateAnimated.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                        )
                    }
                    launch {
                        addIconStartAnimated.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                        )
                    }
                    launch {
                        addIconEndAnimated.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                        )
                    }
                }
            }

            UIKitAddCircleAnimateState.Error -> {
                if (successIconAnimated.value != 0f) {
                    successIconAnimated.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                    )
                }
                coroutineScope {
                    launch {
                        addIconRotateAnimated.animateTo(
                            targetValue = 45f,
                            animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                        )
                    }
                    launch {
                        addIconStartAnimated.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                        )
                    }
                    launch {
                        addIconEndAnimated.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                        )
                    }
                }
            }

            UIKitAddCircleAnimateState.Success -> {
                coroutineScope {
                    launch {
                        addIconStartAnimated.animateTo(
                            targetValue = 0.5f,
                            animationSpec = tween((uikitAnimate.motionFastDurationMillis / 1.5f).toInt(), easing = FastOutLinearInEasing)
                        )
                    }
                    launch {
                        addIconEndAnimated.animateTo(
                            targetValue = 0.5f,
                            animationSpec = tween((uikitAnimate.motionFastDurationMillis / 1.5f).toInt(), easing = FastOutLinearInEasing)
                        )
                    }
                }
                successIconAnimated.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(uikitAnimate.motionRegularDurationMillis, easing = LinearOutSlowInEasing)
                )
            }
        }
    }

    Canvas(
        modifier = modifier
    ) {
        scale(
            scaleX = size.width / defaultSize.width.toPx(),
            scaleY = size.height / defaultSize.height.toPx()
        ) {
            drawCircle(
                brush = tint,
                alpha = 0.3f,
                radius = 8.dp.toPx(),
                center = Offset(size.width / 2, size.height / 2),
            )

            if (successIconAnimated.value != 0f) {
                translate(
                    top = size.height / 2 - 20.dp.toPx() / 2,
                    left = size.width / 2 - 20.dp.toPx() / 2
                ) {
                    val pathMeasure = PathMeasure()
                    pathMeasure.setPath(
                        path = Path().apply {
                            moveTo(7.dp.toPx(), 10.dp.toPx())
                            relativeLineTo(2.dp.toPx(), 2.dp.toPx())
                            relativeLineTo(4.dp.toPx(), -4.dp.toPx())
                        },
                        forceClosed = false
                    )

                    val length = pathMeasure.length

                    val trimmedPath = Path()
                    pathMeasure.getSegment(0f, length * successIconAnimated.value, trimmedPath, true)

                    drawPath(
                        path = trimmedPath,
                        brush = tint,
                        style = Stroke(
                            width = lineWidth.toPx(),
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        )
                    )
                }
            }

            // Add/Dismiss Icon
            if (addIconStartAnimated.value != 0.5f && addIconEndAnimated.value != 0.5f) {
                rotate(
                    degrees = addIconRotateAnimated.value
                ) {
                    translate(
                        top = size.height / 2 - 20.dp.toPx() / 2,
                        left = size.width / 2 - 20.dp.toPx() / 2
                    ) {
                        val pathMeasure = PathMeasure()
                        pathMeasure.setPath(
                            path = Path().apply {
                                moveTo(6.5.dp.toPx(), 10.dp.toPx())
                                lineTo(13.5.dp.toPx(), 10.dp.toPx())
                            },
                            forceClosed = false
                        )

                        val length = pathMeasure.length

                        val trimmedPath = Path()
                        pathMeasure.getSegment(length * addIconStartAnimated.value, length * addIconEndAnimated.value, trimmedPath, true)

                        drawPath(
                            path = trimmedPath,
                            brush = tint,
                            style = Stroke(
                                width = lineWidth.toPx(),
                                cap = StrokeCap.Round,
                                join = StrokeJoin.Round
                            )
                        )

                        val pathMeasure1 = PathMeasure()
                        pathMeasure1.setPath(
                            path = Path().apply {
                                moveTo(10.dp.toPx(), 6.5.dp.toPx())
                                lineTo(10.dp.toPx(), 13.5.dp.toPx())
                            },
                            forceClosed = false
                        )

                        val length1 = pathMeasure1.length

                        val trimmedPath1 = Path()
                        pathMeasure1.getSegment(length1 * addIconStartAnimated.value, length1 * addIconEndAnimated.value, trimmedPath1, true)

                        drawPath(
                            path = trimmedPath1,
                            brush = tint,
                            style = Stroke(
                                width = lineWidth.toPx(),
                                cap = StrokeCap.Round,
                                join = StrokeJoin.Round
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UIKitSymbols.AnimatableIcons.AddCircleFilled(
    modifier: Modifier = Modifier,
    state: UIKitAddCircleAnimateState = UIKitAddCircleAnimateState.Add,
    primaryTint: Color = getUIKitColors().highlightColorPrimaryBrush,
    autoTint: Boolean = true,
    lineWidth: Dp = 1.dp
) {
    val tintAnimated by animateColorAsState(
        targetValue = if (autoTint) when(state) {
            UIKitAddCircleAnimateState.Add -> primaryTint
            UIKitAddCircleAnimateState.Error -> getUIKitColors().errorRedColorPrimaryBrush
            UIKitAddCircleAnimateState.Success -> getUIKitColors().successGreenColorPrimaryBrush
        } else primaryTint,
        animationSpec = tween(
            getUIKitAnimate().transformRegularDurationMillis,
            easing = LinearEasing,
            delayMillis = if (state == UIKitAddCircleAnimateState.Success) (getUIKitAnimate().motionFastDurationMillis / 1.5f).toInt() else 0
        )
    )

    AddCircleFilled(
        modifier = modifier,
        state = state,
        tint = SolidColor(tintAnimated),
        lineWidth = lineWidth
    )
}