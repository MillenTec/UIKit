package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.component.layout.UIKitSurface
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
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
            UIKitButton(
                enabled = true,
                onClick = {

                },
                icon = FluentIcons.designIdeas(getUIKitColors().textFillColorPrimaryBrush, layered = true),
                iconSize = DpSize(32.dp, 32.dp),
                text = "Designs"
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitButton(
                enabled = false,
                onClick = {

                },
                icon = FluentIcons.designIdeas(getUIKitColors().textFillColorPrimaryBrush, layered = true),
                iconSize = DpSize(32.dp, 32.dp),
                text = "Designs"
            )
        }
    }
}

data class UIKitButtonColors(
    val background: Color,
    val backgroundDisabled: Color,
    val content: Color,
    val contentDisabled: Color,
    val border: Color,
    val borderDisabled: Color,
) {
    companion object {
        @Composable
        fun default(
            background: Color = getUIKitColors().contentFillColorTertiaryBrush,
            backgroundDisabled: Color = getUIKitColors().contentFillColorBrushDisabled,
            content: Color = getUIKitColors().textFillColorPrimaryBrush,
            contentDisabled: Color = getUIKitColors().textFillColorDisabled,
            border: Color = getUIKitColors().lineFillColorPrimaryBrush,
            borderDisabled: Color = getUIKitColors().lineFillColorPrimaryBrush
        ): UIKitButtonColors {
            return UIKitButtonColors(
                background = background,
                backgroundDisabled = backgroundDisabled,
                content = content,
                contentDisabled = contentDisabled,
                border = border,
                borderDisabled = borderDisabled
            )
        }
    }
}

@Composable
fun UIKitButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = if (isDesktopOS()) null else ripple(),
    interaction: (@Composable Modifier.(State<Boolean>, State<Boolean>, State<Shape>) -> Modifier)? = null,
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
                Modifier.border(
                    width = borderWidth,
                    color = borderColorAnimated.value,
                    shape = shape)
            else Modifier),
        shape = shape,
        color = backgroundColorAnimated.value,
        enabled = enabled,
        onClick = onClick,
        interactionSource = interactionSource,
        indication = indication,
        interaction = interaction
    ) {
        Box(
            modifier = Modifier
                .padding(contentPadding),
            contentAlignment = Alignment.Center,
            content = content,
        )
    }
}

@Composable
fun UIKitButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    textStyle: TextStyle = getUIKitTypography().body,
) = UIKitButton(
    modifier = modifier,
    shape = shape,
    colors = colors,
    hasBorder = hasBorder,
    borderWidth = borderWidth,
    contentPadding = contentPadding,
    enabled = enabled,
    onClick = onClick
) {
    val contentColorAnimated by animateColorAsState(
        targetValue = if (enabled) colors.content else colors.contentDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    Text(
        text = text,
        style = textStyle,
        color = contentColorAnimated
    )
}

@Composable
fun UIKitButton(
    icon: ImageVector,
    iconSize: DpSize = DpSize(icon.defaultWidth, icon.defaultHeight),
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
) = UIKitButton(
    modifier = modifier,
    shape = shape,
    colors = colors,
    hasBorder = hasBorder,
    borderWidth = borderWidth,
    contentPadding = contentPadding,
    enabled = enabled,
    onClick = onClick
) {
    val contentColorAnimated by animateColorAsState(
        targetValue = if (enabled) colors.content else colors.contentDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    Icon(
        modifier = Modifier
            .size(iconSize),
        imageVector = icon,
        contentDescription = null,
        tint = contentColorAnimated,
    )
}

@Composable
fun UIKitButton(
    icon: ImageVector,
    iconSize: DpSize = DpSize(icon.defaultWidth, icon.defaultHeight),
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    iconColor: Color = colors.content,
    textStyle: TextStyle = getUIKitTypography().body
) = UIKitButton(
    modifier = modifier,
    shape = shape,
    colors = colors,
    hasBorder = hasBorder,
    borderWidth = borderWidth,
    contentPadding = contentPadding,
    enabled = enabled,
    onClick = onClick
) {
    val contentColorAnimated by animateColorAsState(
        targetValue = if (enabled) colors.content else colors.contentDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val iconColorAnimated by animateColorAsState(
        targetValue = if (enabled) iconColor else colors.contentDisabled,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .size(iconSize),
            imageVector = icon,
            contentDescription = null,
            tint = iconColorAnimated,
        )

        Spacer(Modifier.width(getUIKitLayout().smallSpacing))

        Text(
            text = text,
            style = textStyle,
            color = contentColorAnimated
        )
    }
}