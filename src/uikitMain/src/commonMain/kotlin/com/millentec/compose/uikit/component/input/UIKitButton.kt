package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.layout.UIKitSurface
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes

@Composable
@Preview
private fun Preview() {
    UIKitButton(
        enabled = false,
        onClick = {

        }
    ) {
        Text("Hello")
    }
}

data class UIKitButtonColors(
    val background: Color,
    val backgroundDisabled: Color,
    val border: Color,
    val borderDisabled: Color,
) {
    companion object {
        @Composable
        fun default(): UIKitButtonColors {
            return UIKitButtonColors(
                background = getUIKitColors().contentFillColorTertiaryBrush,
                backgroundDisabled = getUIKitColors().contentFillColorBrushDisabled,
                border = getUIKitColors().lineFillColorPrimaryBrush,
                borderDisabled = getUIKitColors().lineFillColorPrimaryBrush
            )
        }
    }
}

@Composable
fun UIKitButton(
    modifier: Modifier = Modifier.padding(getUIKitLayout().basicSpacing),
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val backgroundColorAnimated = animateColorAsState(
        targetValue = if (enabled) colors.background else colors.backgroundDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val borderColorAnimated = animateColorAsState(
        targetValue = if (enabled) colors.border else colors.borderDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    UIKitSurface(
        modifier = modifier
            .defaultMinSize(
                minWidth = 120.dp,
                minHeight = getUIKitLayout().interactiveHotspot
            )
            .then(if (hasBorder)
                Modifier.border(borderWidth, borderColorAnimated.value)
            else Modifier),
        shape = shape,
        color = backgroundColorAnimated.value,
        enabled = enabled,
        onClick = onClick,
        indication = if (isDesktopOS()) null else ripple()
    ) {
        Box(
            modifier = Modifier
                .padding(contentPadding),
            contentAlignment = Alignment.Center,
            content = content,
        )
    }
}