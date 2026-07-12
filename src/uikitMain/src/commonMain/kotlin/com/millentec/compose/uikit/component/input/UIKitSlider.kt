package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.*
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.round

@Composable
@Preview
private fun Preview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UIKitSlider(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            value = 60f,
            onValueChange = {},
            valueRange = 20f..100f,
            tickStep = 20f
        )
        UIKitSlider(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            value = 1f,
            onValueChange = {},
            valueRange = 0f..100f,
            tickStep = 20f
        )
    }
}

data class UIKitSliderColors(
    val thumb: Color,
    val thumbDisabled: Color,
    val activeTrack: Color,
    val inactiveTrack: Color,
    val activeTrackDisabled: Color,
    val inactiveTrackDisabled: Color,
    val tick: Color,
    val tickDisabled: Color,
) {
    companion object {
        @Composable
        fun default(
            thumb: Color = UIKitColors.getLight().contentFillColorPrimaryBrush,
            thumbDisabled: Color = getUIKitColors().contentFillColorBrushDisabled,
            activeTrack: Color = getUIKitColors().highlightColorPrimaryBrush,
            inactiveTrack: Color = getUIKitColors().contentFillColorTertiaryBrush,
            activeTrackDisabled: Color = getUIKitColors().lineFillColorDisabled,
            inactiveTrackDisabled: Color = getUIKitColors().lineFillColorPrimaryBrush,
            tick: Color = getUIKitColors().lineFillColorPrimaryBrush,
            tickDisabled: Color = getUIKitColors().lineFillColorDisabled
        ) = UIKitSliderColors(
            thumb = thumb,
            thumbDisabled = thumbDisabled,
            activeTrack = activeTrack,
            inactiveTrack = inactiveTrack,
            activeTrackDisabled = activeTrackDisabled,
            inactiveTrackDisabled = inactiveTrackDisabled,
            tick = tick,
            tickDisabled = tickDisabled
        )
    }
}

@Composable
fun UIKitSlider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: Float,
    onValueChange: (Float) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 5.dp else 8.dp,
    thumbSize: DpSize = if (isDesktopOS()) DpSize(18.dp, 18.dp) else DpSize(32.dp, 24.dp),
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    hasTick: Boolean = true,
    tickStep: Float = 0.1f,
    adsorbedOntoTick: Boolean = hasTick,
    colors: UIKitSliderColors = UIKitSliderColors.default()
) {
    val thumbColorAnimated by animateColorAsState(
        targetValue = if (enabled) colors.thumb else colors.thumbDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val activeTrackColorAnimated by animateColorAsState(
        targetValue = if (enabled) colors.activeTrack else colors.activeTrackDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val inactiveTrackColorAnimated by animateColorAsState(
        targetValue = if (enabled) colors.inactiveTrack else colors.inactiveTrackDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val tickColorAnimated by animateColorAsState(
        targetValue = if (enabled) colors.tick else colors.tickDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )


    BoxWithConstraints(
        modifier = modifier
            .padding(end = thumbSize.width),
        contentAlignment = Alignment.CenterStart,
    ) {

        fun toOffset(value: Float): Dp {
            val start = valueRange.start
            val end = valueRange.endInclusive
            if (end == start) return 0.dp
            return ((value - start) / (end - start) * maxWidth.value).dp
        }

        fun toValue(offset: Dp): Float {
            val start = valueRange.start
            val end = valueRange.endInclusive
            if (maxWidth.value == 0f) return start
            return (offset.value / maxWidth.value) * (end - start) + start
        }

        val density = LocalDensity.current
        val maxWidth = maxWidth
        val thumbOffsetAnimated = remember {
            Animatable(
                initialValue = 0.dp,
                typeConverter = Dp.VectorConverter,
            )
        }

        val valueCurrent by rememberUpdatedState(value)
        val isTapChange = remember { mutableStateOf(false) }

        val uikitAnimate = getUIKitAnimate()
        LaunchedEffect(value) {
            if (isTapChange.value) {
                isTapChange.value = false
                thumbOffsetAnimated.animateTo(
                    targetValue = toOffset(value),
                    animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                )
            } else if (adsorbedOntoTick){
                thumbOffsetAnimated.animateTo(
                    targetValue = toOffset(value),
                    animationSpec = tween(uikitAnimate.motionMomentaryDurationMillis, easing = FastOutSlowInEasing)
                )
            } else {
                thumbOffsetAnimated.snapTo(toOffset(value))
            }
        }

        if (hasTick) {
            Canvas(
                modifier = Modifier
                    .offset(x = thumbSize.width / 2)
                    .height(thumbSize.height)
            ) {
                repeat(floor((valueRange.endInclusive - valueRange.start) / tickStep).toInt() + 1) {
                    val tickValue = valueRange.start + it * tickStep
                    val tickOffset = with(density) { toOffset(tickValue) }.toPx()
                    drawLine(
                        start = Offset(
                            x = tickOffset,
                            y = with(density) { 2.dp }.toPx()
                        ),
                        end = Offset(
                            x = tickOffset,
                            y = size.height - with(density) { 2.dp }.toPx()
                        ),
                        color = tickColorAnimated,
                        strokeWidth = with(density) { 1.dp }.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }
        }

        Canvas(
            modifier = Modifier
                .offset(x = thumbSize.width/2)
                .fillMaxWidth()
                .height(thumbSize.height)
                .then(if (enabled) {
                    Modifier.pointerInput(Unit) {
                        detectTapGestures(
                            onTap = { offset ->
                                var newOffset = (offset.x / density.density).dp
                                if (adsorbedOntoTick) {
                                    val newValue = toValue(newOffset)
                                    val tickIndex = round((newValue - valueRange.start) / tickStep).toInt()
                                    val value = (valueRange.start + tickIndex * tickStep).coerceIn(valueRange)
                                    newOffset = toOffset(value)
                                }
                                isTapChange.value = true
                                onValueChange(
                                    toValue(newOffset)
                                )
                            }
                        )
                    }
                } else Modifier)
        ) {
            drawLine(
                color = activeTrackColorAnimated,
                strokeWidth = (lineWidth * density.density).value,
                cap = StrokeCap.Round,
                start = Offset(
                    x = 0f,
                    y = size.height / 2
                ),
                end = Offset(
                    x = (thumbOffsetAnimated.value * density.density).value,
                    y = size.height / 2
                )
            )

            drawLine(
                color = inactiveTrackColorAnimated,
                strokeWidth = (lineWidth * density.density).value,
                cap = StrokeCap.Round,
                start = Offset(
                    x = (thumbOffsetAnimated.value * density.density).value,
                    y = size.height / 2
                ),
                end = Offset(
                    x = (maxWidth * density.density).value,
                    y = size.height / 2
                )
            )
        }

        val isDragging = remember { mutableStateOf(false) }
        val thumbPressed = remember { mutableStateOf(false) }
        val thumbScaleAnimated by animateFloatAsState(
            targetValue = if (thumbPressed.value) 1.2f else 1f,
            animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = FastOutSlowInEasing)
        )

        val totalDragOffset = remember { mutableStateOf(0.dp) }
        val totalDragOffsetCurrent = rememberUpdatedState(totalDragOffset.value)
        Box(
            modifier = Modifier
                .offset(x = thumbOffsetAnimated.value)
                .graphicsLayer(
                    scaleX = thumbScaleAnimated,
                    scaleY = thumbScaleAnimated
                )
                .dropShadow(
                    shadow = UIKitShadowMaterial.getShadow(),
                    shape = RoundedCornerShape(getUIKitShapes().circular)
                )
                .clip(RoundedCornerShape(getUIKitShapes().circular))
                .size(thumbSize)
                .background(thumbColorAnimated)
                .then(if (enabled) {
                    Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onPress = {
                                    thumbPressed.value = true
                                    tryAwaitRelease()
                                    if (!isDragging.value) {
                                        thumbPressed.value = false
                                    }
                                }
                            )
                        }
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDragStart = {
                                    isDragging.value = true
                                    thumbPressed.value = true
                                    println(thumbPressed.value)
                                },
                                onDrag = { change, offset ->
                                    if (!adsorbedOntoTick) {
                                        val newValue = toValue(toOffset(valueCurrent) + with(density) { offset.x }.toDp())
                                        val coercedValue = newValue.coerceIn(valueRange)
                                        onValueChange(coercedValue)
                                    } else {
                                        var newOffset = totalDragOffsetCurrent.value + with(density) { offset.x }.toDp()
                                        val tickStepOffset = toOffset(tickStep + valueRange.start)
                                        if (abs(newOffset.value) > tickStepOffset.value) {
                                            val tickIndex = round((newOffset + toOffset(valueCurrent)) / tickStepOffset)
                                            val value = (tickIndex * tickStep + valueRange.start).coerceIn(valueRange)
                                            onValueChange(value)
                                            if (newOffset > 0.dp)
                                                newOffset -= tickStepOffset
                                            else
                                                newOffset += tickStepOffset
                                        }
                                        totalDragOffset.value = newOffset
                                    }
                                },
                                onDragEnd = {
                                    totalDragOffset.value = 0.dp
                                    thumbPressed.value = false
                                    isDragging.value = false
                                },
                                onDragCancel = {
                                    totalDragOffset.value = 0.dp
                                    thumbPressed.value = false
                                    isDragging.value = false
                                }
                            )
                        }
                } else Modifier)
        )
    }
}