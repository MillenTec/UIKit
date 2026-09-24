/*
 * AIGC: 使用了人工智能优化并修复分段式滑块, 适配 Ltr 布局以及竖向滑块功能
 * - Time: 2026-09-06 16:24
 * - Model: GLM 5.3 Flash
 * - Type: Agent (ZCode)
 * - State: Reviewed
 */

package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.millentec.compose.uikit.component.input.UIKitSliderChangeType.*
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.UIKitShadowMaterial
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitShapes
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
            valueRange = 0f..100f,
            hasTick = true,
            tickStep = 20f,
            adsorbedOntoTick = true
        )
        UIKitSlider(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            value = -10f,
            onValueChange = {},
            valueRange = -50f..50f,
            hasTick = true,
            tickStep = 25f
        )
        UIKitSlider(
            modifier = Modifier
                .height(150.dp)
                .width(40.dp),
            value = 0.7f,
            onValueChange = {},
            isVertical = true,
            hasTick = true,
            tickStep = 0.25f,
            adsorbedOntoTick = true
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
            thumb: Color = Color.White,
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
 * @param adsorptionEnable 是否启用吸附; 启用后点击轨道将吸附到最近吸附点, 拖动仅在越过相邻吸附点时步进 (快速拖动可一次跨过多格), 且静止时若偏移不在吸附点上会以 [UIKitSliderChangeType.Jump] 强制对齐到最近吸附点
 * @param adsorptionPoints 可用于吸附的点集合, 单位为 Dp, 可乱序; 为空时视为未启用吸附
 * @param isVertical 是否垂直方向; 垂直时行程自下而上 (最小值位于底部), offset 与 maxWidth 语义不变, maxWidth 表示最大行程, 即手势节点在行程轴方向上的尺寸; RTL 布局下水平行程的输入会自动镜像 (最小值位于右侧), 装饰层的绘制需依据 LocalLayoutDirection 做同样的镜像以保持一致
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
    isVertical: Boolean = false,
    decoration: @Composable (
        trackHandler: Modifier,
        thumbHandler: Modifier
    ) -> Unit,
) {
    val thumbPressed = remember { mutableStateOf(false) }
    val isDragging = remember { mutableStateOf(false) }

    val offsetCurrent by rememberUpdatedState(offset)
    val maxWidthCurrent by rememberUpdatedState(maxWidth)
    val onOffsetChangeCurrent by rememberUpdatedState(onOffsetChange)
    val onThumbPressedCurrent by rememberUpdatedState(onThumbPressed)
    val onThumbReleasedCurrent by rememberUpdatedState(onThumbReleased)
    val onDragStartCurrent by rememberUpdatedState(onDragStart)
    val onDragEndCurrent by rememberUpdatedState(onDragEnd)
    val adsorptionEnableCurrent by rememberUpdatedState(adsorptionEnable)
    val isVerticalCurrent by rememberUpdatedState(isVertical)
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val isRtlCurrent by rememberUpdatedState(isRtl)
    val adsorptionPointsSorted = remember(adsorptionPoints) { adsorptionPoints?.sorted() }
    val adsorptionPointsSortedCurrent by rememberUpdatedState(adsorptionPointsSorted)

    fun nearestAdsorptionPoint(points: List<Dp>, target: Dp): Dp? {
        return points.minByOrNull { abs((it - target).value) }
    }

    fun setThumbPressed(pressed: Boolean) {
        if (thumbPressed.value != pressed) {
            thumbPressed.value = pressed
            if (pressed) onThumbPressedCurrent() else onThumbReleasedCurrent()
        }
    }

    fun setDragging(dragging: Boolean) {
        if (isDragging.value != dragging) {
            isDragging.value = dragging
            if (dragging) onDragStartCurrent() else onDragEndCurrent()
        }
    }

    // 在静止 (非拖动) 时机将不在吸附点上的偏移强制对齐到最近吸附点
    LaunchedEffect(offset, adsorptionEnable, adsorptionPointsSorted) {
        if (adsorptionEnable && !adsorptionPointsSorted.isNullOrEmpty() && !isDragging.value) {
            val closestPoint = nearestAdsorptionPoint(adsorptionPointsSorted, offset)
            if (closestPoint != null && closestPoint != offset) {
                onOffsetChange(closestPoint, Jump)
            }
        }
    }

    decoration(
        Modifier.pointerInput(Unit) {
            detectTapGestures(
                onTap = { tapOffset ->
                    // 垂直时行程自下而上, RTL 时行程自右向左, 输入坐标需反向映射到行程
                    var newOffset = when {
                        isVerticalCurrent -> maxWidthCurrent - tapOffset.y.toDp()
                        isRtlCurrent -> maxWidthCurrent - tapOffset.x.toDp()
                        else -> tapOffset.x.toDp()
                    }.coerceIn(0.dp..maxWidthCurrent)
                    val points = adsorptionPointsSortedCurrent
                    if (adsorptionEnableCurrent && !points.isNullOrEmpty()) {
                        newOffset = nearestAdsorptionPoint(points, newOffset) ?: newOffset
                    }
                    onOffsetChangeCurrent(newOffset, TrackTap)
                }
            )
        },
        Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        setThumbPressed(true)
                        tryAwaitRelease()
                        if (!isDragging.value) {
                            setThumbPressed(false)
                        }
                    }
                )
            }
            .pointerInput(Unit) {
                // 手势内本地累积拖动位置, 不依赖父级即时回传, 避免丢增量
                var dragStartOffset = 0.dp
                var dragAccumulated = 0.dp

                detectDragGestures(
                    onDragStart = {
                        setDragging(true)
                        setThumbPressed(true)
                        dragStartOffset = offsetCurrent
                        dragAccumulated = 0.dp
                    },
                    onDrag = { _, dragAmount ->
                        // 垂直向上 / RTL 向左 的拖拽增量为行程正方向
                        dragAccumulated += when {
                            isVerticalCurrent -> -dragAmount.y.toDp()
                            isRtlCurrent -> -dragAmount.x.toDp()
                            else -> dragAmount.x.toDp()
                        }
                        // 拖动位置不可钳制到 0..maxWidth: 端点吸附点只有在位置越过它之后才会被发射, 钳制会导致拖拽永远到不了首末刻度
                        val dragPosition = dragStartOffset + dragAccumulated

                        val points = adsorptionPointsSortedCurrent
                        if (adsorptionEnableCurrent && !points.isNullOrEmpty()) {
                            // 参考索引: 当前偏移对应的吸附点, 精确匹配失败时取最近点
                            var referenceIndex = points.indexOf(offsetCurrent)
                            if (referenceIndex < 0) {
                                var nearestDistance = Float.MAX_VALUE
                                for (index in points.indices) {
                                    val distance = abs((points[index] - offsetCurrent).value)
                                    if (distance < nearestDistance) {
                                        nearestDistance = distance
                                        referenceIndex = index
                                    }
                                }
                            }

                            // 仅在越过相邻吸附点时步进, 并沿拖动方向发射最远已越过的吸附点, 重复发射为无害空操作
                            if (dragPosition > points[referenceIndex]) {
                                var targetIndex = -1
                                var index = referenceIndex + 1
                                while (index < points.size && points[index] < dragPosition) {
                                    targetIndex = index
                                    index++
                                }
                                if (targetIndex >= 0) {
                                    onOffsetChangeCurrent(points[targetIndex], DragAdsorption)
                                }
                            } else if (dragPosition < points[referenceIndex]) {
                                var targetIndex = -1
                                var index = referenceIndex - 1
                                while (index >= 0 && points[index] > dragPosition) {
                                    targetIndex = index
                                    index--
                                }
                                if (targetIndex >= 0) {
                                    onOffsetChangeCurrent(points[targetIndex], DragAdsorption)
                                }
                            }
                        } else {
                            onOffsetChangeCurrent(dragPosition.coerceIn(0.dp..maxWidthCurrent), ThumbDrag)
                        }
                    },
                    onDragEnd = {
                        setThumbPressed(false)
                        setDragging(false)
                    },
                    onDragCancel = {
                        setThumbPressed(false)
                        setDragging(false)
                    }
                )
            }
    )
}

/**
 * 滑块控件, 在 [UIKitBasicSlider] 之上提供值域映射、刻度与吸附点生成
 * @param isVertical 是否垂直方向; 垂直时行程自下而上 (最小值位于底部), 需由调用方通过 modifier 给定确定的高度 (在 LazyColumn 等高度无限的容器内必须显式指定, 否则行程将按 0 处理); 水平模式下 RTL 布局自动镜像 (最小值位于右侧)
 * @param value 当前值, 会被约束在 [valueRange] 内
 * @param onValueChange 值改变时触发回调, 参数一为新值, 参数二为改变的方式; 吸附步进时回调值恒为刻度值, 无浮点误差
 * @param valueRange 值域, 支持任意区间 (如 -50f..50f), 区间端点顺序无关
 * @param lineWidth 滑块轨道的大小
 * @param hasTick 是否绘制刻度
 * @param tickStep 刻度间隔, 决定刻度与吸附点的生成; 若 (区间长度) 不是其整数倍, 末段会补上端点刻度; 传入非正数时退化为仅区间端点两个刻度
 * @param adsorbedOntoTick 是否吸附到刻度, 默认与 [hasTick] 一致; 开启后值永远只会是刻度值
 */
@Composable
fun UIKitSlider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isVertical: Boolean = false,
    value: Float,
    onValueChange: (value: Float, changeType: UIKitSliderChangeType) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 5.dp else 8.dp,
    thumbSize: DpSize = if (isDesktopOS())
        DpSize(18.dp, 18.dp)
    else {
        if (!isVertical)
            DpSize(32.dp, 24.dp)
        else
            DpSize(24.dp, 32.dp)
    },
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    hasTick: Boolean = false,
    tickStep: Float = 0.1f,
    adsorbedOntoTick: Boolean = hasTick,
    colors: UIKitSliderColors = UIKitSliderColors.default()
) {
    BoxWithConstraints(
        modifier = if (isVertical) {
            modifier.padding(bottom = thumbSize.height)
        } else {
            modifier.padding(end = thumbSize.width)
        },
        contentAlignment = if (isVertical) Alignment.TopCenter else Alignment.CenterStart,
    ) {
        val onValueChangeCurrent by rememberUpdatedState(onValueChange)
        val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl

        // 行程轴最大长度: 水平为宽度, 垂直为高度
        val maxTravel = if (isVertical) maxHeight else maxWidth

        val rangeStart = minOf(valueRange.start, valueRange.endInclusive)
        val rangeEnd = maxOf(valueRange.start, valueRange.endInclusive)

        fun toOffset(value: Float): Dp {
            val fraction = if (rangeEnd == rangeStart) {
                0f
            } else {
                (value - rangeStart) / (rangeEnd - rangeStart)
            }
            // NaN 输入按最小值处理; 行程无限 (如垂直模式在 LazyColumn 等无限高度容器中未约束高度) 时收在 0:
            // 有限的 fraction 乘 Infinity 行程会得到 Infinity/NaN, 进入 Animatable 将直接崩溃
            val safeFraction = if (fraction.isNaN()) 0f else fraction
            return if (maxTravel.value.isFinite()) {
                safeFraction.coerceIn(0f, 1f) * maxTravel
            } else {
                0.dp
            }
        }

        fun toValue(offset: Dp): Float {
            if (rangeEnd == rangeStart) return rangeStart
            val fraction = (offset / maxTravel).coerceIn(0f, 1f)
            return rangeStart + (if (fraction.isNaN()) 0f else fraction) * (rangeEnd - rangeStart)
        }

        val density = LocalDensity.current
        val uikitAnimate = getUIKitAnimate()
        val valueChangeType = remember { mutableStateOf<UIKitSliderChangeType?>(null) }

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
        val dragging = remember { mutableStateOf(false) }
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

        // 刻度值单一来源: 刻度绘制与吸附共用同一列表, 保证两者永不失步
        val tickValues = remember(rangeStart, rangeEnd, tickStep) {
            buildList {
                val span = rangeEnd - rangeStart
                if (span > 0f && tickStep.isFinite() && tickStep > 0f) {
                    // 步数上限保护, 避免过小的 tickStep 造成冻结
                    val stepCount = floor(span / tickStep + 1e-4f).toInt().coerceAtMost(10000)
                    repeat(stepCount + 1) { add(rangeStart + it * tickStep) }
                    // 末点容差修正: 浮点误差使其足够接近 rangeEnd 时直接取 rangeEnd, 否则补上尾段端点刻度
                    val last = this[stepCount]
                    if (abs(last - rangeEnd) <= tickStep * 1e-4f) {
                        this[stepCount] = rangeEnd
                    } else {
                        add(rangeEnd)
                    }
                } else {
                    add(rangeStart)
                    add(rangeEnd)
                }
            }
        }
        val tickOffsets = tickValues.map { toOffset(it) }

        val currentOffset = toOffset(value)

        LaunchedEffect(value) {
            val targetOffset = toOffset(value)
            if (dragging.value) {
                if (valueChangeType.value == DragAdsorption) {
                    thumbOffsetAnimated.animateTo(
                        targetValue = targetOffset,
                        animationSpec = tween(
                            uikitAnimate.motionMomentaryDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                } else {
                    thumbOffsetAnimated.snapTo(targetOffset)
                }
            } else {
                thumbOffsetAnimated.animateTo(
                    targetValue = targetOffset,
                    animationSpec = tween(
                        uikitAnimate.motionFastDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
            }
            valueChangeType.value = null
        }

        LaunchedEffect(maxTravel, rangeStart, rangeEnd) {
            thumbOffsetAnimated.snapTo(toOffset(value))
        }

        UIKitBasicSlider(
            offset = currentOffset,
            maxWidth = maxTravel,
            onOffsetChange = { offset: Dp, type: UIKitSliderChangeType ->
                valueChangeType.value = type
                // 吸附发射的偏移即为刻度位置, 直接取同源的刻度值, 避免浮点往返误差
                val tickIndex = tickOffsets.indexOf(offset)
                onValueChangeCurrent(
                    if (tickIndex >= 0) tickValues[tickIndex] else toValue(offset),
                    type
                )
            },
            onThumbPressed = {
                thumbPressed.value = true
            },
            onThumbReleased = {
                thumbPressed.value = false
            },
            onDragStart = {
                dragging.value = true
            },
            onDragEnd = {
                dragging.value = false
            },
            adsorptionEnable = adsorbedOntoTick,
            adsorptionPoints = tickOffsets,
            isVertical = isVertical,
        ) { trackHandler: Modifier, thumbHandler: Modifier ->
            if (isVertical) {
                if (hasTick) {
                    Canvas(
                        modifier = Modifier
                            .offset { IntOffset(0, (thumbSize.height / 2).roundToPx()) }
                            .width(thumbSize.width)
                            .fillMaxHeight()
                    ) {
                        tickOffsets.forEach { tickOffset ->
                            val tickY = size.height - tickOffset.toPx()
                            drawLine(
                                start = Offset(
                                    x = 2.dp.toPx(),
                                    y = tickY
                                ),
                                end = Offset(
                                    x = size.width - 2.dp.toPx(),
                                    y = tickY
                                ),
                                color = tickColorAnimated,
                                strokeWidth = 1.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        }
                    }
                }

                Canvas(
                    modifier = Modifier
                        .offset { IntOffset(0, (thumbSize.height / 2).roundToPx()) }
                        .width(thumbSize.width)
                        .fillMaxHeight()
                        .then(if (enabled) {
                            trackHandler
                        } else Modifier)
                ) {
                    val centerX = size.width / 2
                    val thumbY = size.height - thumbOffsetAnimated.value.toPx()
                    drawLine(
                        color = activeTrackColorAnimated,
                        strokeWidth = (lineWidth * density.density).value,
                        cap = StrokeCap.Round,
                        start = Offset(
                            x = centerX,
                            y = size.height
                        ),
                        end = Offset(
                            x = centerX,
                            y = thumbY
                        )
                    )

                    drawLine(
                        color = inactiveTrackColorAnimated,
                        strokeWidth = (lineWidth * density.density).value,
                        cap = StrokeCap.Round,
                        start = Offset(
                            x = centerX,
                            y = thumbY
                        ),
                        end = Offset(
                            x = centerX,
                            y = 0f
                        )
                    )
                }
            } else {
                if (hasTick) {
                    Canvas(
                        modifier = Modifier
                            .offset { IntOffset((thumbSize.width / 2).roundToPx(), 0) }
                            .fillMaxWidth()
                            .height(thumbSize.height)
                    ) {
                        tickOffsets.forEach { tickOffset ->
                            // offset 为方向感知修饰符, RTL 下节点位置已自动镜像, 绘制时仅需在节点坐标系内镜像行程
                            val tickX = if (isRtl) size.width - tickOffset.toPx() else tickOffset.toPx()
                            drawLine(
                                start = Offset(
                                    x = tickX,
                                    y = 2.dp.toPx()
                                ),
                                end = Offset(
                                    x = tickX,
                                    y = size.height - 2.dp.toPx()
                                ),
                                color = tickColorAnimated,
                                strokeWidth = 1.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        }
                    }
                }

                Canvas(
                    modifier = Modifier
                        .offset { IntOffset((thumbSize.width / 2).roundToPx(), 0) }
                        .fillMaxWidth()
                        .height(thumbSize.height)
                        .then(if (enabled) {
                            trackHandler
                        } else Modifier)
                ) {
                    val centerY = size.height / 2
                    val thumbX = if (isRtl) {
                        size.width - thumbOffsetAnimated.value.toPx()
                    } else {
                        thumbOffsetAnimated.value.toPx()
                    }
                    drawLine(
                        color = activeTrackColorAnimated,
                        strokeWidth = (lineWidth * density.density).value,
                        cap = StrokeCap.Round,
                        start = Offset(
                            x = if (isRtl) size.width else 0f,
                            y = centerY
                        ),
                        end = Offset(
                            x = thumbX,
                            y = centerY
                        )
                    )

                    drawLine(
                        color = inactiveTrackColorAnimated,
                        strokeWidth = (lineWidth * density.density).value,
                        cap = StrokeCap.Round,
                        start = Offset(
                            x = thumbX,
                            y = centerY
                        ),
                        end = Offset(
                            x = if (isRtl) 0f else size.width,
                            y = centerY
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .offset {
                        if (isVertical) {
                            // 垂直: 行程自下而上, 最小值位于底部; 行程无限时按 0 处理
                            val thumbY = maxTravel - thumbOffsetAnimated.value
                            IntOffset(0, if (thumbY.value.isFinite()) thumbY.roundToPx() else 0)
                        } else {
                            // offset 为方向感知修饰符: RTL 下 x 轴自动镜像, 配合 CenterStart 对齐恰好得到正确的拇指位置
                            IntOffset(thumbOffsetAnimated.value.roundToPx(), 0)
                        }
                    }
                    .size(thumbSize)
                    .then(if (enabled) {
                        thumbHandler
                    } else Modifier)
                    .graphicsLayer {
                        scaleX = thumbScaleAnimated
                        scaleY = thumbScaleAnimated
                    }
                    .dropShadow(
                        shadow = UIKitShadowMaterial.getMarginal(),
                        shape = RoundedCornerShape(getUIKitShapes().circular)
                    )
                    .clip(RoundedCornerShape(getUIKitShapes().circular))
                    .drawBehind {
                        drawRect(thumbColorAnimated)
                    }
            )
        }
    }
}

/**
 * 滑块控件, 在 [UIKitBasicSlider] 之上提供值域映射、刻度与吸附点生成
 * @param isVertical 是否垂直方向; 垂直时行程自下而上 (最小值位于底部), 需由调用方通过 modifier 给定确定的高度 (在 LazyColumn 等高度无限的容器内必须显式指定, 否则行程将按 0 处理); 水平模式下 RTL 布局自动镜像 (最小值位于右侧)
 * @param value 当前值, 会被约束在 [valueRange] 内
 * @param onValueChange 值改变时触发回调, 参数为新值; 吸附步进时回调值恒为刻度值, 无浮点误差
 * @param valueRange 值域, 支持任意区间 (如 -50f..50f), 区间端点顺序无关
 * @param lineWidth 滑块轨道的大小
 * @param hasTick 是否绘制刻度
 * @param tickStep 刻度间隔, 决定刻度与吸附点的生成; 若 (区间长度) 不是其整数倍, 末段会补上端点刻度; 传入非正数时退化为仅区间端点两个刻度
 * @param adsorbedOntoTick 是否吸附到刻度, 默认与 [hasTick] 一致; 开启后值永远只会是刻度值
 */
@Composable
fun UIKitSlider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: Float,
    isVertical: Boolean = false,
    onValueChange: (value: Float) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 5.dp else 8.dp,
    thumbSize: DpSize = if (isDesktopOS())
        DpSize(18.dp, 18.dp)
    else {
        if (!isVertical)
            DpSize(32.dp, 24.dp)
        else
            DpSize(24.dp, 32.dp)
    },
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    adsorbedOntoTick: Boolean = false,
    hasTick: Boolean = adsorbedOntoTick,
    tickStep: Float = 0.1f,
    colors: UIKitSliderColors = UIKitSliderColors.default()
) = UIKitSlider(
    modifier = modifier,
    enabled = enabled,
    value = value,
    onValueChange = { changedValue, _ ->
        onValueChange(changedValue)
    },
    lineWidth = lineWidth,
    thumbSize = thumbSize,
    valueRange = valueRange,
    hasTick = hasTick,
    tickStep = tickStep,
    adsorbedOntoTick = adsorbedOntoTick,
    isVertical = isVertical,
    colors = colors
)

@Deprecated(
    message = "maxValue 已由 valueRange 参数替代, 请改用带 valueRange 参数的重载",
    level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith("UIKitSlider( modifier = modifier, enabled = enabled, value = value, onValueChange = onValueChange, lineWidth = lineWidth, thumbSize = thumbSize, valueRange = 0f..maxValue, hasTick = hasTick, tickStep = tickStep, adsorbedOntoTick = adsorbedOntoTick, colors = colors )")
)
@Composable
fun UIKitSlider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: Float,
    onValueChange: (Float, UIKitSliderChangeType) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 5.dp else 8.dp,
    thumbSize: DpSize = if (isDesktopOS()) DpSize(18.dp, 18.dp) else DpSize(32.dp, 24.dp),
    maxValue: Float,
    hasTick: Boolean = false,
    tickStep: Float = 0.1f,
    adsorbedOntoTick: Boolean = hasTick,
    colors: UIKitSliderColors = UIKitSliderColors.default()
) = UIKitSlider(
    modifier = modifier,
    enabled = enabled,
    value = value,
    onValueChange = onValueChange,
    lineWidth = lineWidth,
    thumbSize = thumbSize,
    valueRange = 0f..maxValue,
    hasTick = hasTick,
    tickStep = tickStep,
    adsorbedOntoTick = adsorbedOntoTick,
    colors = colors
)

@Deprecated(
    message = "maxValue 已由 valueRange 参数替代, 请改用带 valueRange 参数的重载",
    level = DeprecationLevel.WARNING
)
@Composable
fun UIKitSlider(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: Float,
    onValueChange: (Float) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 5.dp else 8.dp,
    thumbSize: DpSize = if (isDesktopOS()) DpSize(18.dp, 18.dp) else DpSize(32.dp, 24.dp),
    maxValue: Float,
    adsorbedOntoTick: Boolean = false,
    hasTick: Boolean = adsorbedOntoTick,
    tickStep: Float = 0.1f,
    colors: UIKitSliderColors = UIKitSliderColors.default()
) = UIKitSlider(
    modifier = modifier,
    enabled = enabled,
    value = value,
    onValueChange = { changedValue, _ ->
        onValueChange(changedValue)
    },
    lineWidth = lineWidth,
    thumbSize = thumbSize,
    valueRange = 0f..maxValue,
    hasTick = hasTick,
    tickStep = tickStep,
    adsorbedOntoTick = adsorbedOntoTick,
    colors = colors
)
