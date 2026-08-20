package com.millentec.compose.uikit.views.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.UIKitSlider
import com.millentec.compose.uikit.component.input.UIKitSliderChangeType
import com.millentec.compose.uikit.theme.*

@Composable
fun CommonSlider(
    state: MutableState<Float>,
    iconStart: @Composable BoxScope.() -> Unit = {},
    iconEnd: @Composable BoxScope.() -> Unit = {},
    maxValue: Float = 1f,
) {
    val uikitTheme = getUIKitTheme()
    val isAnimatedChange = remember { mutableStateOf(false) }
    val value = remember { mutableStateOf(state.value) }
    val valueAnimated = remember { Animatable(
        initialValue = value.value,
        typeConverter = Float.VectorConverter,
    ) }

    LaunchedEffect(value.value) {
        if (isAnimatedChange.value) {
            valueAnimated.animateTo(
                targetValue = value.value,
                animationSpec = tween(
                    uikitTheme.animate.motionRegularDurationMillis,
                    easing = FastOutSlowInEasing
                )
            )
        } else {
            valueAnimated.snapTo(value.value)
        }
    }

    LaunchedEffect(valueAnimated.value) {
        state.value = valueAnimated.value
    }

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
            .fillMaxWidth()
            .height(getUIKitLayout().interactiveHotspot)
            .background(getUIKitColors().contentFillColorSecondaryBrush)
            .padding(horizontal = getUIKitLayout().cardPadding, vertical = getUIKitLayout().basicSpacing),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(getUIKitTypography().body.lineHeight.value.dp),
            contentAlignment = Alignment.Center,
            content = iconStart
        )

        Spacer(Modifier.width(getUIKitLayout().smallSpacing))

        UIKitSlider(
            modifier = Modifier
                .weight(1f),
            value = value.value,
            maxValue = maxValue,
            onValueChange = { v, type ->
                isAnimatedChange.value = type != UIKitSliderChangeType.ThumbDrag
                value.value = v
            },
        )

        Spacer(Modifier.width(getUIKitLayout().smallSpacing))

        Box(
            modifier = Modifier
                .size(getUIKitTypography().body.lineHeight.value.dp),
            contentAlignment = Alignment.Center,
            content = iconEnd
        )
    }
}