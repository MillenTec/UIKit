package com.millentec.compose.uikit.icons.fluenticons.animatable

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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.animatable.UIKitDownloadState.*
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
@Preview
private fun Preview() {
    FluentIcons.Animatable.Download(
        modifier = Modifier.size(50.dp),
        progress = 0.5f,
        state = UIKitDownloadState.Downloading
    )
}

enum class UIKitDownloadState {
    Downloading,
    Success,
    Stopped,
    Error
}

@Composable
fun FluentIcons.Animatable.Download(
    modifier: Modifier = Modifier.size(20.dp),
    progress: Float,
    state: UIKitDownloadState = Downloading,
    tint: Color = getUIKitColors().textFillColorPrimaryBrush,
    resetProgressOnError: Boolean = true
) {
    val uikitAnimate = getUIKitAnimate()
    val defaultSize = DpSize(20.dp, 20.dp)
    val downloadIconTranslateYAnimated = remember { Animatable(
        initialValue = if (state == Downloading || state == Stopped) 0.dp else 15.dp,
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
            Downloading -> {
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
            Error -> {
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
                        color = tint,
                        style = Stroke(
                            width = 1.dp.toPx(),
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        )
                    )

                    drawPath(
                        path = trimmedPath1,
                        color = tint,
                        style = Stroke(
                            width = 1.dp.toPx(),
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
                        color = tint,
                        style = Stroke(
                            width = 1.dp.toPx(),
                            cap = StrokeCap.Round,
                            join = StrokeJoin.Round
                        )
                    )
                }
            }

            // Download Icon
            clipPath(
                path = Path().apply {
                    addOval(
                        oval = Rect(
                            size = Size(14.dp.toPx(), 14.dp.toPx()),
                            offset = Offset(
                                x = size.height / 2 - 14.dp.toPx() / 2,
                                y = size.width / 2 - 14.dp.toPx() / 2
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
                            color = tint,
                            strokeWidth = 1.dp.toPx(),
                            cap = StrokeCap.Round,
                        )

                        drawLine(
                            color = tint,
                            start = Offset(10.dp.toPx(), 13.5.dp.toPx()),
                            end = Offset(10.dp.toPx(), 6.5.dp.toPx()),
                            strokeWidth = 1.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }
            }

            // 进度圆环
            translate(
                top = size.height / 2 - 15.dp.toPx() / 2,
                left = size.width / 2 - 15.dp.toPx() / 2
            ) {
                drawArc(
                    color = tint.copy(0.3f),
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    size = Size(
                        width = 15.dp.toPx(),
                        height = 15.dp.toPx()
                    ),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                )

                drawArc(
                    color = tint,
                    startAngle = -90f,
                    sweepAngle = progressAnimated.value * 360f,
                    useCenter = false,
                    size = Size(
                        width = 15.dp.toPx(),
                        height = 15.dp.toPx()
                    ),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }
        }
    }
}

@Composable
fun FluentIcons.Animatable.Download(
    modifier: Modifier = Modifier.size(20.dp),
    progress: Float,
    state: UIKitDownloadState = Downloading,
    resetProgressOnError: Boolean = true,
) {
    val tintAnimated by animateColorAsState(
        targetValue = when(state) {
            Downloading -> getUIKitColors().highlightColorPrimaryBrush
            Success -> getUIKitColors().successGreenColorPrimaryBrush
            Stopped -> getUIKitColors().warningYellowColorPrimaryBrush
            Error -> getUIKitColors().errorRedColorPrimaryBrush
        },
        animationSpec = tween(
            getUIKitAnimate().transformRegularDurationMillis,
            easing = LinearEasing,
            delayMillis = when(state) {
                Downloading -> 0
                Success -> getUIKitAnimate().motionFastDurationMillis
                Stopped -> 0
                Error -> getUIKitAnimate().motionFastDurationMillis
            }
        )
    )

    Download(
        modifier = modifier,
        progress = progress,
        state = state,
        tint = tintAnimated,
        resetProgressOnError = resetProgressOnError,
    )
}