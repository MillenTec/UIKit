package com.millentec.compose.uikit.symbols.uikitsymbols.animatable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.animatable.UIKitArrowCircleAnimateState.*
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

enum class UIKitArrowCircleAnimateState {
    Running,
    Stopped,
    Error,
    Success,
}


@Composable
fun UIKitSymbols.AnimatableIcons.ArrowCircle(
    modifier: Modifier = Modifier,
    progress: Float = 0f,
    state: UIKitArrowCircleAnimateState = Running,
    tint: Brush,
    resetProgressOnError: Boolean = true,
    lineWidth: Dp = 1.dp,
    rotate: Float,
) {
    val uikitAnimate = getUIKitAnimate()
    val defaultSize = DpSize(20.dp, 20.dp)
    val downloadIconTranslateYAnimated = remember { Animatable(
        initialValue = if (state == Running || state == Stopped) 0.dp else 15.dp,
        typeConverter = Dp.VectorConverter,
    ) }
    val progressAnimated = remember { Animatable(
        initialValue = progress,
        typeConverter = Float.VectorConverter,
    ) }
    val successIconAnimated = remember { Animatable(
        initialValue = 0f,
        typeConverter = Float.VectorConverter,
    ) }
    val errorIconAnimated = remember { Animatable(
        initialValue = 0f,
        typeConverter = Float.VectorConverter,
    ) }

    LaunchedEffect(progress) {
        if (state != Success) {
            progressAnimated.snapTo(progress)
        }
    }

    LaunchedEffect(state) {
        when (state) {
            Running -> {
                successIconAnimated.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        uikitAnimate.motionFastDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
                errorIconAnimated.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        uikitAnimate.motionFastDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
                if (downloadIconTranslateYAnimated.value != 0.dp) {
                    downloadIconTranslateYAnimated.snapTo((-15).dp)
                }
                coroutineScope {
                    launch {
                        downloadIconTranslateYAnimated.animateTo(
                            targetValue = 0.dp,
                            animationSpec = spring(
                                dampingRatio = uikitAnimate.standardSpringDampingRatio,
                                stiffness = uikitAnimate.standardSpringStiffness
                            )
                        )
                    }
                    launch {
                        progressAnimated.animateTo(
                            targetValue = progress,
                            animationSpec = tween(
                                uikitAnimate.motionRegularDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }
                }
            }
            Success -> {
                coroutineScope {
                    launch {
                        errorIconAnimated.animateTo(
                            targetValue = 0f,
                            animationSpec = tween(
                                uikitAnimate.motionFastDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        )
                        downloadIconTranslateYAnimated.animateTo(
                            targetValue = 15.dp,
                            animationSpec = tween(
                                uikitAnimate.motionFastDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }
                    launch {
                        successIconAnimated.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(
                                uikitAnimate.motionRegularDurationMillis,
                                easing = FastOutSlowInEasing,
                                delayMillis = uikitAnimate.motionRegularDurationMillis + uikitAnimate.motionFastDurationMillis
                            )
                        )
                    }
                    launch {
                        progressAnimated.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(
                                uikitAnimate.motionRegularDurationMillis,
                                easing = FastOutSlowInEasing,
                                delayMillis = uikitAnimate.motionFastDurationMillis
                            )
                        )
                    }
                }
            }
            Stopped -> {
                successIconAnimated.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        uikitAnimate.motionFastDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
                errorIconAnimated.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        uikitAnimate.motionFastDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
                if (downloadIconTranslateYAnimated.value != 0.dp) {
                    downloadIconTranslateYAnimated.snapTo((-15).dp)
                }
                coroutineScope {
                    launch {
                        downloadIconTranslateYAnimated.animateTo(
                            targetValue = 0.dp,
                            animationSpec = spring(
                                dampingRatio = uikitAnimate.standardSpringDampingRatio,
                                stiffness = uikitAnimate.standardSpringStiffness
                            )
                        )
                    }
                    launch {
                        progressAnimated.animateTo(
                            targetValue = progress,
                            animationSpec = tween(
                                uikitAnimate.motionRegularDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }
                }
            }
            UIKitArrowCircleAnimateState.Error -> {
                successIconAnimated.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(
                        uikitAnimate.motionFastDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
                downloadIconTranslateYAnimated.animateTo(
                    targetValue = 15.dp,
                    animationSpec = tween(
                        uikitAnimate.motionFastDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
                coroutineScope {
                    launch {
                        errorIconAnimated.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(
                                uikitAnimate.motionFastDurationMillis,
                                easing = FastOutSlowInEasing,
                            )
                        )
                    }
                    launch {
                        progressAnimated.animateTo(
                            targetValue = if (resetProgressOnError) 0f else progress,
                            animationSpec = tween(
                                uikitAnimate.motionRegularDurationMillis,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }
                }
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

            // Dismiss Icon
            if (errorIconAnimated.value != 0f) {
                translate(
                    top = size.height / 2 - 20.dp.toPx() / 2,
                    left = size.width / 2 - 20.dp.toPx() / 2
                ) {
                    val pathMeasure = PathMeasure()
                    pathMeasure.setPath(
                        path = Path().apply {
                            moveTo(7.5.dp.toPx(), 12.5.dp.toPx())
                            lineTo(12.5.dp.toPx(), 7.5.dp.toPx())
                        },
                        forceClosed = false
                    )

                    val pathMeasure1 = PathMeasure()
                    pathMeasure1.setPath(
                        path = Path().apply {
                            moveTo(7.5.dp.toPx(), 7.5.dp.toPx())
                            lineTo(12.5.dp.toPx(), 12.5.dp.toPx())
                        },
                        forceClosed = false
                    )

                    val length = pathMeasure.length

                    val trimmedPath = Path()
                    val trimmedPath1 = Path()
                    pathMeasure.getSegment(0f, length * errorIconAnimated.value, trimmedPath, true)
                    pathMeasure1.getSegment(0f, length * errorIconAnimated.value, trimmedPath1, true)

                    drawPath(
                        path = trimmedPath,
                        brush = tint,
                        style = Stroke(
                            width = lineWidth.toPx(),
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        )
                    )

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

            // Success Icon
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

            // Arrow Icon
            rotate(
                degrees = rotate
            ) {
                clipPath(
                    path = Path().apply {
                        addOval(
                            oval = Rect(
                                size = Size((16.dp - lineWidth * 2).toPx(), (16.dp - lineWidth * 2).toPx()),
                                offset = Offset(
                                    x = size.height / 2 - (16.dp - lineWidth * 2).toPx() / 2,
                                    y = size.width / 2 - (16.dp - lineWidth * 2).toPx() / 2
                                )
                            )
                        )
                    }
                ) {
                    translate(
                        top = size.height / 2 - 20.dp.toPx() / 2,
                        left = size.width / 2 - 20.dp.toPx() / 2
                    ) {

                        translate(
                            top = downloadIconTranslateYAnimated.value.toPx()
                        ) {
                            drawPoints(
                                points = listOf(
                                    Offset(7.dp.toPx(), 10.5.dp.toPx()),
                                    Offset(10.dp.toPx(), 13.5.dp.toPx()),
                                    Offset(13.dp.toPx(), 10.5.dp.toPx()),
                                ),
                                pointMode = PointMode.Polygon,
                                brush = tint,
                                strokeWidth = lineWidth.toPx(),
                                cap = StrokeCap.Round,
                            )

                            drawLine(
                                brush = tint,
                                start = Offset(10.dp.toPx(), 13.5.dp.toPx()),
                                end = Offset(10.dp.toPx(), 6.5.dp.toPx()),
                                strokeWidth = lineWidth.toPx(),
                                cap = StrokeCap.Round
                            )
                        }
                    }
                }
            }

            // 进度圆环
            translate(
                top = size.height / 2 - 15.dp.toPx() / 2,
                left = size.width / 2 - 15.dp.toPx() / 2
            ) {
                drawArc(
                    brush = tint,
                    alpha = 0.3f,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    size = Size(
                        width = 15.dp.toPx(),
                        height = 15.dp.toPx()
                    ),
                    style = Stroke(
                        width = lineWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                )

                drawArc(
                    brush = tint,
                    startAngle = -90f,
                    sweepAngle = progressAnimated.value * 360f,
                    useCenter = false,
                    size = Size(
                        width = 15.dp.toPx(),
                        height = 15.dp.toPx()
                    ),
                    style = Stroke(
                        width = lineWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }
        }
    }
}

@Composable
fun UIKitSymbols.AnimatableIcons.ArrowCircle(
    modifier: Modifier = Modifier,
    progress: Float = 0f,
    state: UIKitArrowCircleAnimateState = Running,
    resetProgressOnError: Boolean = true,
    primaryTint: Color = getUIKitColors().highlightColorPrimaryBrush,
    autoTint: Boolean = true,
    lineWidth: Dp = 1.dp,
    rotate: Float
) {
    val tintAnimated by animateColorAsState(
        targetValue = if (autoTint) when(state) {
            Running -> primaryTint
            Success -> getUIKitColors().successGreenColorPrimaryBrush
            Stopped -> getUIKitColors().warningYellowColorPrimaryBrush
            Error -> getUIKitColors().errorRedColorPrimaryBrush
        } else primaryTint,
        animationSpec = tween(
            getUIKitAnimate().transformRegularDurationMillis,
            easing = LinearEasing,
            delayMillis = when(state) {
                Running -> 0
                Success -> getUIKitAnimate().motionFastDurationMillis
                Stopped -> 0
                Error -> getUIKitAnimate().motionFastDurationMillis
            }
        )
    )

    ArrowCircle(
        modifier = modifier,
        progress = progress,
        state = state,
        tint = SolidColor(tintAnimated),
        resetProgressOnError = resetProgressOnError,
        lineWidth = lineWidth,
        rotate = rotate,
    )
}