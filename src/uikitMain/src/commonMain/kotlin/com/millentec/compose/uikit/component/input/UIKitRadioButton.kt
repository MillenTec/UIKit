package com.millentec.compose.uikit.component.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.uikitClickable
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitTheme(
        UIKitTheme(
            colors = UIKitColors.getLight()
        )
    ) {
        Column(
            Modifier.background(getUIKitColors().contentFillColorPrimaryBrush)
        ) {
            UIKitRadioButton(
                selected = false,
                onClick = {}
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitRadioButton(
                selected = true,
                onClick = {}
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitRadioButton(
                selected = true,
                enabled = false,
                onClick = {}
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitRadioButton(
                selected = false,
                enabled = false,
                onClick = {}
            )
        }
    }
}

data class UIKitRadioButtonColors(
    val selected: Color,
    val unselected: Color,
    val selectedDisabled: Color,
    val unselectedDisable: Color
) {
    companion object {
        @Composable
        fun default(
            selected: Color = getUIKitColors().highlightColorPrimaryBrush,
            unselected: Color = getUIKitColors().contentFillColorTertiaryBrush,
            selectedDisabled: Color = getUIKitColors().lineFillColorDisabled,
            unselectedDisable: Color = getUIKitColors().lineFillColorDisabled
        ) = UIKitRadioButtonColors(
            selected = selected,
            unselected = unselected,
            selectedDisabled = selectedDisabled,
            unselectedDisable = unselectedDisable
        )
    }
}

@Composable
fun UIKitRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit,
    colors: UIKitRadioButtonColors = UIKitRadioButtonColors.default(),
    size: DpSize = DpSize(18.dp, 18.dp)
) {
    Box(
        modifier = modifier
    ) {
       val colorAnimated by animateColorAsState(
           targetValue = if (!enabled) {
               if (selected) colors.selectedDisabled else colors.unselectedDisable
           } else {
               if (selected) colors.selected else colors.unselected
           },
           animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
       )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().circular))
                .size(size)
                .border(
                    width = 1.dp,
                    color = colorAnimated,
                    shape = RoundedCornerShape(getUIKitShapes().circular)
                )
                .uikitClickable(
                    enabled = enabled,
                    onClick = onClick,
                    indicationEnabled = isDesktopOS(),
                    indication = null
                )
        ) {
            AnimatedVisibility(
                visible = selected,
                enter = scaleIn(
                    initialScale = 0f,
                    animationSpec = tween(getUIKitAnimate().transformFastDurationMillis, easing = FastOutSlowInEasing)
                ),
                exit = scaleOut(
                    targetScale = 0f,
                    animationSpec = tween(getUIKitAnimate().transformFastDurationMillis, easing = FastOutSlowInEasing)
                )
            ) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (enabled) colors.selected else colors.selectedDisabled,
                    animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
                )

                Box(
                    modifier = Modifier
                        .padding(getUIKitLayout().smallSpacing)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(getUIKitShapes().circular))
                        .background(colorAnimated)
                )
            }
        }
    }
}