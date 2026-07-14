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
import androidx.compose.ui.unit.times
import com.millentec.compose.uikit.component.input.UIKitSliderChangeType.*
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.*
import kotlin.math.abs
import kotlin.math.floor

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
            maxValue = 100f,
            tickStep = 20f
        )
        UIKitSlider(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            value = 1f,
            onValueChange = {},
            maxValue = 100f,
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

enum class UIKitSliderChangeType{
    TrackTap,
    ThumbDrag,
    DragAdsorption,
    Jump,
}

/**
 * 基础滑块控件, 仅提供逻辑实现, 所有外观装饰需置于 decoration 内, 且通过其提供的 Modifier 形参添加交互逻辑
 * @param offset 滑块的偏移量, 从 0.dp 开始算起, 计算到 maxWidth
 * @param maxWidth 设定的最大偏移量
 * @param onOffsetChange 当 offset 改变时触发回调, 参数一为偏移数值, 类型为 Dp, 参数二为改变的方式 (点击 Track, 拖动Thumb, 或者是吸附)
 * @param onThumbPressed 当 Thumb 被按下时触发回调
 * @param onThumbReleased 当 Thumb 被释放时触发回调
 * @param onDragStart 当拖动 Thumb 操作开始时触发回调
 * @param onDragEnd 当拖动 Thumb 操作结束时触发回调
 * @param adsorptionEnable 是否启用吸附
 * @param adsorptionPoints 可用于吸附的点集合, 单位为 Dp
 * @param decoration 控件装饰, 通过给装饰中的元素添加提供的 Modifier 实现交互, 参数一为 Track 点击逻辑的 Modifier, 参数二为 Thumb 拖动逻辑的 Modifier
 */
@Composable
fun UIKitBasicSlider(
    offset: Dp,
    maxWidth: Dp,
    onOffsetChange: (Dp, UIKitSliderChangeType) -> Unit,
    onThumbPressed: () -> Unit,
    onThumbReleased: () -> Unit,
    onDragStart: () -> Unit,
    onDragEnd: () -> Unit,
    adsorptionEnable: Boolean = false,
    adsorptionPoints: List<Dp>? = null,
    isAnimating: Boolean = false,
    decoration: @Composable (
        Modifier,  // Track 点击处理
        Modifier  // Thumb 拖动处理
    ) -> Unit,
) {
    val density = LocalDensity.current
    val thumbPressed = remember { mutableStateOf(false) }
    val isDragging = remember { mutableStateOf(false) }
    val adsorptionPointIndex = remember { mutableStateOf<Int?>(null) }
    val adsorptionPointsSorted = remember { mutableStateOf(
        adsorptionPoints?.sorted()
    ) }

    val offsetCurrent by rememberUpdatedState(offset)

    val offsetIncludedDrag = remember { mutableStateOf(offset) }

    LaunchedEffect(adsorptionPoints) {
        adsorptionPointsSorted.value = adsorptionPoints?.sorted()
    }

    // 在非动画的时机将偏移强制对其到吸附点
    LaunchedEffect(offset, adsorptionPointsSorted.value, isAnimating) {
        if (adsorptionEnable && adsorptionPointsSorted.value != null && !isAnimating) {
            val closestPoint = adsorptionPointsSorted.value?.withIndex()?.minByOrNull { (index, num) ->
                abs(offset.value - num.value)
            }
            adsorptionPointIndex.value = closestPoint?.index
            if (closestPoint?.value == offset) return@LaunchedEffect
            onOffsetChange(
                closestPoint?.value ?: throw UnsupportedOperationException("Adsorption points (shorted) is null or can't find a point close '$offset'."),
                Jump,
            )
        }
    }

    LaunchedEffect(adsorptionPoints) {
        adsorptionPointsSorted.value = adsorptionPoints?.sorted()
    }

    LaunchedEffect(offset, isDragging) {
        if (!isDragging.value) {
            offsetIncludedDrag.value = offset
        }
    }

    LaunchedEffect(thumbPressed.value) {
        if (thumbPressed.value) {
            onThumbPressed()
        } else {
            onThumbReleased()
        }
    }

    LaunchedEffect(isDragging.value) {
        if (isDragging.value) {
            onDragStart()
        } else {
            onDragEnd()
        }
    }

    val offsetDiff = remember { mutableStateOf(0f) }

    decoration(
        Modifier.pointerInput(Unit) {
            detectTapGestures(
                onTap = { offset ->
                    var newOffset = with(density) { offset.x }.toDp()
                    if (adsorptionEnable && adsorptionPoints != null) {
                        val closestPoint = adsorptionPoints.minByOrNull {
                            abs(newOffset.value - it.value)
                        }
                        newOffset = closestPoint ?: throw NullPointerException("Can't find adsorption point for '$newOffset'.")
                    }
                    onOffsetChange(
                        newOffset,
                        TrackTap
                    )
                }
            )
        },
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
                    },
                    onDrag = { change, offset ->
                        offsetDiff.value += offset.x
                        if (adsorptionEnable && adsorptionPointsSorted.value != null) {
                            offsetIncludedDrag.value += with(density) { offset.x }.toDp()
                            val arr = adsorptionPointsSorted.value ?: throw NullPointerException("Adsorption points (shorted) is null.")

                            // 差值大于 0, 则向左拖拽
                            if (offsetIncludedDrag.value - offsetCurrent > 0.dp) {
                                val nextIndex = (adsorptionPointIndex.value ?: throw NullPointerException("Adsorption point index is null.")) + 1
                                if (adsorptionPointIndex.value!! < arr.size - 1) {
                                    val nextPoint = arr[nextIndex]
                                    if (offsetIncludedDrag.value > nextPoint) {
                                        onOffsetChange(
                                            nextPoint,
                                            DragAdsorption
                                        )
                                    }
                                }
                            } else if (offsetIncludedDrag.value - offsetCurrent < 0.dp) {
                                val nextIndex = (adsorptionPointIndex.value ?: throw NullPointerException("Adsorption point index is null.")) - 1
                                if (adsorptionPointIndex.value!! > 0) {
                                    val nextPoint = arr[nextIndex]
                                    if (offsetIncludedDrag.value < nextPoint) {
                                        onOffsetChange(
                                            nextPoint,
                                            DragAdsorption
                                        )
                                    }
                                }
                            }
                        } else {
                            val newOffset = offsetCurrent + with(density) { offset.x }.toDp()
                            val coercedOffset = newOffset.coerceIn(0.dp..maxWidth)
                            onOffsetChange(coercedOffset, ThumbDrag)
                        }
                    },
                    onDragEnd = {
                        thumbPressed.value = false
                        isDragging.value = false
                        offsetDiff.value = 0f
                    },
                    onDragCancel = {
                        thumbPressed.value = false
                        isDragging.value = false
                    }
                )
            }
    )
}

@Composable
fun UIKitSlider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: Float,
    onValueChange: (Float) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 5.dp else 8.dp,
    thumbSize: DpSize = if (isDesktopOS()) DpSize(18.dp, 18.dp) else DpSize(32.dp, 24.dp),
    maxValue: Float = 1f,
    hasTick: Boolean = true,
    tickStep: Float = 0.1f,
    adsorbedOntoTick: Boolean = hasTick,
    colors: UIKitSliderColors = UIKitSliderColors.default()
) {
    BoxWithConstraints(
        modifier = modifier
            .padding(end = thumbSize.width),
        contentAlignment = Alignment.CenterStart,
    ) {
        fun toOffset(value: Float): Dp {
            return value / maxValue * maxWidth
        }

        fun toValue(offset: Dp): Float {
            return offset / maxWidth * maxValue
        }

        val density = LocalDensity.current
        val uikitAnimate = getUIKitAnimate()
        val valueChangeType = remember { mutableStateOf<UIKitSliderChangeType?>(null) }
        val currentTickStep = rememberUpdatedState(tickStep)

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

        val thumbPressed = remember { mutableStateOf(false) }
        val thumbScaleAnimated by animateFloatAsState(
            targetValue = if (thumbPressed.value) 1.2f else 1f,
            animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = FastOutSlowInEasing)
        )

        val thumbOffsetAnimated = remember {
            Animatable(
                initialValue = 0.dp,
                typeConverter = Dp.VectorConverter,
            )
        }

        val currentOffset = remember(value) { mutableStateOf(
            toOffset(value)
        ) }

        val adsorptionPoints = remember { mutableStateListOf<Dp>() }
        LaunchedEffect(maxWidth, currentTickStep, maxValue) {
            adsorptionPoints.clear()
            val times = floor(maxValue / tickStep).toInt()
            repeat(times) {
                adsorptionPoints.add(toOffset(it * tickStep))
            }
            if (adsorptionPoints[adsorptionPoints.size -1] != maxWidth) {
                adsorptionPoints.add(maxWidth)
            }
        }

        LaunchedEffect(value) {
            when(valueChangeType.value) {
                TrackTap -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionFastDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                    valueChangeType.value = null
                }
                ThumbDrag -> {
                    thumbOffsetAnimated.snapTo(toOffset(value))
                    valueChangeType.value = null
                }
                DragAdsorption -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionMomentaryDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                    valueChangeType.value = null
                }
                Jump -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionFastDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                    valueChangeType.value = null
                }
                null -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionFastDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                }
            }
        }

        UIKitBasicSlider(
            offset = currentOffset.value,
            maxWidth = maxWidth,
            onOffsetChange = { offset: Dp, type: UIKitSliderChangeType ->
                valueChangeType.value = type
                onValueChange(toValue(offset))
            },
            onThumbPressed = {
                thumbPressed.value = true
            },
            onThumbReleased = {
                thumbPressed.value = false
            },
            onDragStart = {},
            onDragEnd = {},
            adsorptionEnable = adsorbedOntoTick,
            adsorptionPoints = adsorptionPoints,
            isAnimating = thumbOffsetAnimated.isRunning
        ) { trackInteraction: Modifier, thumbInteraction: Modifier ->
            if (hasTick) {
                Canvas(
                    modifier = Modifier
                        .offset(x = thumbSize.width / 2)
                        .height(thumbSize.height)
                ) {
                    repeat(floor(maxValue / tickStep).toInt() + 1) {
                        val tickValue = it * tickStep
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
                        trackInteraction
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

            Box(
                modifier = Modifier
                    .offset(x = thumbOffsetAnimated.value)
                    .size(thumbSize)
                    .then(if (enabled) {
                        thumbInteraction
                    } else Modifier)
                    .graphicsLayer(
                        scaleX = thumbScaleAnimated,
                        scaleY = thumbScaleAnimated,
                    )
                    .dropShadow(
                        shadow = UIKitShadowMaterial.getShadow(),
                        shape = RoundedCornerShape(getUIKitShapes().circular)
                    )
                    .clip(RoundedCornerShape(getUIKitShapes().circular))
                    .background(thumbColorAnimated)
            )
        }
    }
}