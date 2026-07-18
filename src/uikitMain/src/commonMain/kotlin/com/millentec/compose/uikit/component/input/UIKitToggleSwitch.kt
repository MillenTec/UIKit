package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.uikitClickable
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitTheme(UIKitTheme(
        colors = UIKitColors.getLight()
    )) {
        Column {
            UIKitToggleSwitch(
                checked = false,
                onCheckedChange = {},
            )
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
            UIKitToggleSwitch(
                checked = true,
                onCheckedChange = {},
            )
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
            UIKitToggleSwitch(
                checked = false,
                enabled = false,
                onCheckedChange = {},
            )
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
            UIKitToggleSwitch(
                checked = true,
                enabled = false,
                onCheckedChange = {},
            )
        }
    }
}

data class UIKitToggleSwitchColors(
    val background: Color,
    val backgroundDisabled: Color,
    val backgroundChecked: Color,
    val border: Color,
    val borderDisabled: Color,
    val borderChecked: Color,
    val thumb: Color,
    val thumbDisabled: Color,
    val thumbChecked: Color,
) {
    companion object {
        @Composable
        fun default(
            background: Color = getUIKitColors().contentFillColorSecondaryBrush,
            backgroundDisabled: Color = getUIKitColors().contentFillColorBrushDisabled,
            backgroundChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
            border: Color = getUIKitColors().lineFillColorPrimaryBrush,
            borderDisabled: Color = getUIKitColors().lineFillColorDisabled,
            borderChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
            thumb: Color = getUIKitColors().contentFillColorFourthBrush,
            thumbDisabled: Color = getUIKitColors().lineFillColorDisabled,
            thumbChecked: Color = UIKitColors.getDark().textFillColorPrimaryBrush
        ) = UIKitToggleSwitchColors(
            background = background,
            backgroundDisabled = backgroundDisabled,
            backgroundChecked = backgroundChecked,
            border = border,
            borderDisabled = borderDisabled,
            borderChecked = borderChecked,
            thumb = thumb,
            thumbDisabled = thumbDisabled,
            thumbChecked = thumbChecked
        )
    }
}

@Composable
fun UIKitToggleSwitch(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(48.dp, 24.dp),
    enabled: Boolean = true,
    checked: Boolean,
    colors: UIKitToggleSwitchColors = UIKitToggleSwitchColors.default(),
    onCheckedChange: ((Boolean) -> Unit),
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        val density = LocalDensity.current

        val backgroundColorAnimated by animateColorAsState(
            targetValue = if (!enabled) colors.backgroundDisabled else if (checked) colors.backgroundChecked else colors.background,
            animationSpec = tween(if (enabled) getUIKitAnimate().transformMomentaryDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
        )

        val thumbColorAnimated by animateColorAsState(
            targetValue = if (!enabled) colors.thumbDisabled else if (checked) colors.thumbChecked else colors.thumb,
            animationSpec = tween(if (enabled) getUIKitAnimate().transformFastDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
        )

        val borderColorAnimated by animateColorAsState(
            targetValue = if (!enabled) colors.borderDisabled else if (checked) colors.borderChecked else colors.border,
            animationSpec = tween(if (enabled) getUIKitAnimate().transformMomentaryDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
        )

        val thumbSizeAnimated by animateDpAsState(
            targetValue = if (checked) size.height - getUIKitLayout().smallSpacing else size.height - getUIKitLayout().basicSpacing,
            animationSpec = tween(getUIKitAnimate().motionFastDurationMillis, easing = FastOutSlowInEasing)
        )

        val thumbOffsetUnchecked = getUIKitLayout().basicSpacing / 2
        val thumbOffsetChecked = size.width - getUIKitLayout().smallSpacing / 2 - (size.height - getUIKitLayout().smallSpacing)

        val thumbOffsetAnimated = remember { Animatable(
            initialValue = thumbOffsetUnchecked,
            typeConverter = Dp.VectorConverter
        ) }

        val uikitAnimate = getUIKitAnimate()
        LaunchedEffect(checked) {
            thumbOffsetAnimated.animateTo(
                if (checked) thumbOffsetChecked else thumbOffsetUnchecked,
                animationSpec = spring(dampingRatio = uikitAnimate.standardSpringDampingRatio, stiffness = uikitAnimate.standardSpringStiffness)
            )
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().circular))
                .size(size)
                .background(backgroundColorAnimated)
                .border(
                    width = 1.dp,
                    color = borderColorAnimated,
                    shape = RoundedCornerShape(getUIKitShapes().circular)
                )
                .uikitClickable(
                    enabled = enabled,
                    onClick = { onCheckedChange(!checked) },
                    indicationEnabled = isDesktopOS(),
                    indication = null
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .offset(x = thumbOffsetAnimated.value)
                    .clip(RoundedCornerShape(getUIKitShapes().circular))
                    .size(thumbSizeAnimated)
                    .background(thumbColorAnimated)
            )
        }
    }
}