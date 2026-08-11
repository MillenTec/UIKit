package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.millentec.compose.uikit.foundation.UIKitHSVColor
import com.millentec.compose.uikit.foundation.helper.toHsv
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    Column {
        UIKitHSVColorPicker(
            color = Color.White.toHsv(),
            onColorChange = {},
        )
    }
}

data class UIKitColorSV(
    val saturation: Float,
    val value: Float,
)

@Composable
fun UIKitHueSlider(
    modifier: Modifier = Modifier,
    value: Float,
    enabled: Boolean = true,
    onValueChange: (Float) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 12.dp else 15.dp,
    thumbSize: DpSize = if (isDesktopOS()) DpSize(24.dp, 24.dp) else DpSize(32.dp, 32.dp),
) {
    BoxWithConstraints(
        modifier = modifier
            .padding(end = thumbSize.width),
        contentAlignment = Alignment.CenterStart,
    ) {
        val density = LocalDensity.current
        val uikitAnimate = getUIKitAnimate()
        val value = value.coerceIn(0f..360f)
        val valueChangeType = remember { mutableStateOf<UIKitSliderChangeType?>(null) }

        val maxWidthCurrent by rememberUpdatedState(maxWidth)

        fun toOffset(value: Float): Dp {
            return value / 360f * maxWidthCurrent
        }

        fun toValue(offset: Dp): Float {
            return offset / maxWidthCurrent * 360f
        }

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

        val valueAnimated by animateFloatAsState(
            targetValue = if (enabled) 1f else 0.8f,
            animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
        )

        val saturationAnimated by animateFloatAsState(
            targetValue = if (enabled) 1f else 0f,
            animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
        )

        LaunchedEffect(value) {
            when(valueChangeType.value) {
                UIKitSliderChangeType.TrackTap -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionFastDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                    valueChangeType.value = null
                }
                UIKitSliderChangeType.ThumbDrag -> {
                    thumbOffsetAnimated.snapTo(toOffset(value))
                    valueChangeType.value = null
                }
                UIKitSliderChangeType.DragAdsorption -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionMomentaryDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                    valueChangeType.value = null
                }
                UIKitSliderChangeType.Jump -> {
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

        LaunchedEffect(maxWidthCurrent) {
            thumbOffsetAnimated.snapTo(toOffset(value))
        }

        UIKitBasicSlider(
            offset = toOffset(value),
            maxWidth = maxWidthCurrent,
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
        ) { trackInteraction: Modifier, thumbInteraction: Modifier ->
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
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.hsv(0f, saturationAnimated, valueAnimated),
                            Color.hsv(60f, saturationAnimated, valueAnimated),
                            Color.hsv(120f, saturationAnimated, valueAnimated),
                            Color.hsv(180f, saturationAnimated, valueAnimated),
                            Color.hsv(240f, saturationAnimated, valueAnimated),
                            Color.hsv(300f, saturationAnimated, valueAnimated),
                            Color.hsv(360f, saturationAnimated, valueAnimated)
                        )
                    ),
                    strokeWidth = (lineWidth * density.density).value,
                    cap = StrokeCap.Round,
                    start = Offset(
                        x = 0f,
                        y = size.height / 2
                    ),
                    end = Offset(
                        x = (maxWidthCurrent * density.density).value,
                        y = size.height / 2
                    )
                )
            }

            Box(
                modifier = Modifier
                    .offset(x = thumbOffsetAnimated.value)
                    .size(thumbSize)
                    .graphicsLayer(
                        scaleX = thumbScaleAnimated,
                        scaleY = thumbScaleAnimated,
                    )
                    .dropShadow(
                        shadow = UIKitShadowMaterial.getMarginal(),
                        shape = RoundedCornerShape(getUIKitShapes().circular)
                    )
                    .clip(RoundedCornerShape(getUIKitShapes().circular))
                    .background(Color.hsv(
                        hue = toValue(thumbOffsetAnimated.value).coerceIn(0f..360f),
                        saturation = saturationAnimated,
                        value = valueAnimated
                    ))
                    .then(if (enabled) {
                        thumbInteraction
                    } else Modifier)
            )
        }
    }
}

@Composable
fun UIKitAlphaSlider(
    modifier: Modifier = Modifier,
    value: Float,
    color: Color,
    enabled: Boolean = true,
    onValueChange: (Float) -> Unit,
    lineWidth: Dp = if (isDesktopOS()) 12.dp else 15.dp,
    thumbSize: DpSize = if (isDesktopOS()) DpSize(24.dp, 24.dp) else DpSize(32.dp, 32.dp),
) {
    BoxWithConstraints(
        modifier = modifier
            .padding(end = thumbSize.width),
        contentAlignment = Alignment.CenterStart,
    ) {
        val density = LocalDensity.current
        val uikitAnimate = getUIKitAnimate()
        val value = value.coerceIn(0f..1f)
        val valueChangeType = remember { mutableStateOf<UIKitSliderChangeType?>(null) }

        val maxWidthCurrent by rememberUpdatedState(maxWidth)

        fun toOffset(value: Float): Dp {
            return value / 1f * maxWidthCurrent
        }

        fun toValue(offset: Dp): Float {
            return offset / maxWidthCurrent * 1f
        }

        val colorAnimated by animateColorAsState(
            targetValue = if (enabled) color else getUIKitColors().lineFillColorDisabled,
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

        LaunchedEffect(value) {
            when(valueChangeType.value) {
                UIKitSliderChangeType.TrackTap -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionFastDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                    valueChangeType.value = null
                }
                UIKitSliderChangeType.ThumbDrag -> {
                    thumbOffsetAnimated.snapTo(toOffset(value))
                    valueChangeType.value = null
                }
                UIKitSliderChangeType.DragAdsorption -> {
                    thumbOffsetAnimated.animateTo(
                        targetValue = toOffset(value),
                        animationSpec = tween(
                            uikitAnimate.motionMomentaryDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    )
                    valueChangeType.value = null
                }
                UIKitSliderChangeType.Jump -> {
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

        LaunchedEffect(maxWidthCurrent) {
            thumbOffsetAnimated.snapTo(toOffset(value))
        }

        UIKitBasicSlider(
            offset = toOffset(value),
            maxWidth = maxWidthCurrent,
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
        ) { trackInteraction: Modifier, thumbInteraction: Modifier ->
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
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            colorAnimated.copy(0f),
                            colorAnimated.copy(1f),
                        )
                    ),
                    strokeWidth = (lineWidth * density.density).value,
                    cap = StrokeCap.Round,
                    start = Offset(
                        x = 0f,
                        y = size.height / 2
                    ),
                    end = Offset(
                        x = (maxWidthCurrent * density.density).value,
                        y = size.height / 2
                    )
                )
            }

            Box(
                modifier = Modifier
                    .offset(x = thumbOffsetAnimated.value)
                    .size(thumbSize)
                    .graphicsLayer(
                        scaleX = thumbScaleAnimated,
                        scaleY = thumbScaleAnimated,
                    )
                    .dropShadow(
                        shadow = UIKitShadowMaterial.getMarginal(),
                        shape = RoundedCornerShape(getUIKitShapes().circular)
                    )
                    .clip(RoundedCornerShape(getUIKitShapes().circular))
                    .background(UIKitColors.getLight().contentFillColorPrimaryBrush)
                    .then(if (enabled) {
                        thumbInteraction
                    } else Modifier)
            )
        }
    }
}

@Composable
fun UIKitSVPlane(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    hue: Float = 0f,
    saturation: Float = 0f,
    value: Float = 1f,
    onValueChange: (UIKitColorSV) -> Unit,
    thumbSize: Dp = 12.dp,
    cornerRadius: Dp = getUIKitShapes().rightAngle,
    shadowEnabled: Boolean = false,
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .padding(
                bottom = thumbSize,
                end = thumbSize
            ),
        contentAlignment = Alignment.Center
    ) {
        val uikitAnimate = getUIKitAnimate()
        val density = LocalDensity.current
        val hue = hue.coerceIn(0f..360f)
        val saturation = saturation.coerceIn(0f..1f)
        val value = value.coerceIn(0f..1f)
        
        val saturationCurrent by rememberUpdatedState(saturation)
        val valueCurrent by rememberUpdatedState(value)

        fun toOffset(s: Float, v: Float): DpOffset {
            val offsetX = (s / 1f) * maxWidth
            val offsetY = ((1f - v) / 1f) * maxHeight
            return DpOffset(
                x = offsetX,
                y = offsetY
            )
        }

        fun toValue(offset: DpOffset): UIKitColorSV {
            val s = (offset.x / maxWidth) * 1f
            val v = 1f - ((offset.y / maxHeight) * 1f)
            return UIKitColorSV(
                saturation = s,
                value = v,
            )
        }

        val animatedTransitionEnable = remember { mutableStateOf(false) }

        val offsetAnimated = remember { Animatable(
            initialValue = toOffset(saturation, value),
            typeConverter = DpOffset.VectorConverter
        ) }

        LaunchedEffect(value, saturation) {
            if (animatedTransitionEnable.value) {
                offsetAnimated.animateTo(
                    targetValue = toOffset(saturation, value),
                    animationSpec = tween(uikitAnimate.motionFastDurationMillis, easing = FastOutSlowInEasing)
                )
                animatedTransitionEnable.value = false
            } else {
                offsetAnimated.snapTo(toOffset(saturation, value))
            }
        }

        val currentSV = remember(offsetAnimated.value) { mutableStateOf(toValue(offsetAnimated.value)) }

        val panelEndSaturationAnimated by animateFloatAsState(
            targetValue = if (enabled) 1f else 0f,
            animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
        )

        Canvas(
            modifier = Modifier
                .offset(
                    x = thumbSize / 2,
                    y = thumbSize / 2
                )
                .then(if (enabled)
                    Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                    val dpOffset = DpOffset(
                                        x = with(density) { it.x }.toDp(),
                                        y = with(density) { it.y }.toDp()
                                    )
                                    animatedTransitionEnable.value = true
                                    onValueChange(toValue(dpOffset))
                                }
                            )
                        }
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDrag = { change, offset ->
                                    val dpOffset = DpOffset(
                                        x = with(density) { offset.x }.toDp(),
                                        y = with(density) { offset.y }.toDp()
                                    )
                                    val newValue = toValue(
                                        toOffset(saturationCurrent, valueCurrent) + dpOffset
                                    )
                                    val newV = newValue.value.coerceIn(0f..1f)
                                    val newS = newValue.saturation.coerceIn(0f..1f)
                                    onValueChange(
                                        UIKitColorSV(
                                            saturation = newS,
                                            value = newV,
                                        )
                                    )
                                }
                            )
                        } else Modifier)
                .dropShadow(
                    shadow = UIKitShadowMaterial.getMarginal(),
                    shape = RoundedCornerShape(cornerRadius)
                )
                .clip(RoundedCornerShape(cornerRadius))
                .fillMaxSize()
                .aspectRatio(1f)
        ) {
            val width = size.width
            val height = size.height
            for (y in 0 until height.toInt()) {
                val brightness = 1f - y / height
                val startColor = Color.hsv(hue, 0f, brightness)
                val endColor = Color.hsv(hue, panelEndSaturationAnimated, brightness)

                drawRect(
                    brush = Brush.linearGradient(
                        0f to startColor,
                        1f to endColor,
                        start = Offset(0f, y.toFloat()),
                        end = Offset(width, y.toFloat())
                    ),
                    topLeft = Offset(0f, y.toFloat()),
                    size = Size(width, 1f)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        ) {
            val thumbSaturationAnimated = remember {
                Animatable(
                    initialValue = saturation,
                    typeConverter = Float.VectorConverter
                )
            }

            LaunchedEffect(enabled) {
                if (enabled) {
                    thumbSaturationAnimated.animateTo(
                        targetValue = saturationCurrent,
                        animationSpec = tween(uikitAnimate.transformRegularDurationMillis, easing = LinearEasing)
                    )
                } else {
                    thumbSaturationAnimated.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(uikitAnimate.transformRegularDurationMillis, easing = LinearEasing)
                    )
                }
            }

            LaunchedEffect(saturationCurrent) {
                thumbSaturationAnimated.snapTo(saturationCurrent)
            }

            Box(
                modifier = Modifier
                    .offset(
                        x = offsetAnimated.value.x,
                        y = offsetAnimated.value.y
                    )
                    .then(if (shadowEnabled) {
                        Modifier.dropShadow(
                            shadow = UIKitShadowMaterial.getMarginal(),
                            shape = RoundedCornerShape(getUIKitShapes().circular)
                        )
                    } else Modifier)
                    .clip(RoundedCornerShape(getUIKitShapes().circular))
                    .size(thumbSize)
                    .background(
                        Color.hsv(
                            hue = hue,
                            saturation = thumbSaturationAnimated.value,
                            value = currentSV.value.value
                        )
                    )
                    .border(
                        width = 0.5.dp,
                        color = getUIKitColors().lineFillColorPrimaryBrush,
                        shape = RoundedCornerShape(getUIKitShapes().circular)
                    )
            )
        }
    }
}

@Composable
fun UIKitHSVColorPicker(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: UIKitHSVColor = Color.White.toHsv(),
    onColorChange: (UIKitHSVColor) -> Unit,
    hasColorPreviewBox: Boolean = true,
    hasAlphaSlider: Boolean = true,
    colorPreviewBoxBackground: Color = getUIKitColors().contentFillColorPrimaryBrush
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val uiKitAnimate = getUIKitAnimate()
        val hue = remember { mutableStateOf(color.hue) }
        val svPlaneThumbSize = 12.dp
        val colorSv = remember { mutableStateOf(UIKitColorSV(
            color.saturation,
            color.value,
        )) }
        val alpha = remember { mutableStateOf(1f) }

        LaunchedEffect(color) {
            hue.value = color.hue
            colorSv.value = UIKitColorSV(
                color.saturation,
                color.value,
            )
            alpha.value = color.alpha
        }

        LaunchedEffect(hue.value, colorSv.value, alpha.value) {
            onColorChange(
                UIKitHSVColor(
                    hue = hue.value,
                    saturation = colorSv.value.saturation,
                    value = colorSv.value.value,
                    alpha = alpha.value
                )
            )
        }

        val svPlaneSize = remember { mutableStateOf(IntSize.Zero) }
        Row {
            UIKitSVPlane(
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
                    .onSizeChanged {
                        svPlaneSize.value = it
                    },
                hue = hue.value,
                enabled = enabled,
                saturation = colorSv.value.saturation,
                value = colorSv.value.value,
                onValueChange = {
                    colorSv.value = it
                },
                thumbSize = svPlaneThumbSize,
                cornerRadius = getUIKitShapes().smallRounded,
                shadowEnabled = true
            )

            if (hasColorPreviewBox) {
                Spacer(Modifier.width(getUIKitLayout().mediumSpacing))

                val colorPreviewSaturationAnimated = remember {
                    Animatable(
                        initialValue = colorSv.value.saturation,
                        typeConverter = Float.VectorConverter,
                    )
                }

                LaunchedEffect(enabled) {
                    colorPreviewSaturationAnimated.animateTo(
                        targetValue = if (enabled) colorSv.value.saturation else 0f,
                        animationSpec = tween(uiKitAnimate.transformRegularDurationMillis, easing = LinearEasing)
                    )
                }

                LaunchedEffect(colorSv.value.saturation) {
                    colorPreviewSaturationAnimated.snapTo(colorSv.value.saturation)
                }

                Box(
                    modifier = Modifier
                        .padding(
                            end = svPlaneThumbSize / 2,
                            top = svPlaneThumbSize / 2
                        )
                        .dropShadow(
                            shadow = UIKitShadowMaterial.getMarginal(),
                            shape = RoundedCornerShape(getUIKitShapes().regularRounded)
                        )
                        .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                        .height(
                            svPlaneSize.value.height.dp / LocalDensity.current.density - svPlaneThumbSize,
                        )
                        .width(48.dp)
                        .background(colorPreviewBoxBackground)
                        .background(
                            Color.hsv(
                                hue = hue.value,
                                saturation = colorPreviewSaturationAnimated.value,
                                value = colorSv.value.value,
                                alpha = alpha.value
                            )
                        )
                )
            }
        }

        Spacer(modifier = Modifier.height(getUIKitLayout().mediumSpacing))

        UIKitHueSlider(
            value = hue.value,
            enabled = enabled,
            onValueChange = {
                hue.value = it
            }
        )

        if (hasAlphaSlider) {
            Spacer(modifier = Modifier.height(getUIKitLayout().mediumSpacing))

            UIKitAlphaSlider(
                enabled = enabled,
                value = alpha.value,
                color = Color.hsv(
                    hue = hue.value,
                    saturation = colorSv.value.saturation,
                    value = colorSv.value.value
                ),
                onValueChange = {
                    alpha.value = it
                }
            )
        }
    }
}