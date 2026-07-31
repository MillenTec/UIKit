package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
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
            UIKitToggleButton(
                enabled = true,
                checked = false,
                onCheckedChange = {

                },
                icon = FluentIcons.designIdeas(getUIKitColors().textFillColorPrimaryBrush, layered = true),
                iconSize = DpSize(32.dp, 32.dp),
                text = "Designs"
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitToggleButton(
                enabled = true,
                checked = true,
                onCheckedChange = {

                },
                icon = FluentIcons.designIdeas(UIKitColors.getDark().textFillColorPrimaryBrush, layered = true),
                iconSize = DpSize(32.dp, 32.dp),
                text = "Designs"
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitToggleButton(
                enabled = false,
                checked = true,
                onCheckedChange = {

                },
                icon = FluentIcons.designIdeas(getUIKitColors().textFillColorPrimaryBrush, layered = true),
                iconSize = DpSize(32.dp, 32.dp),
                text = "Designs"
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitToggleButton(
                enabled = false,
                checked = false,
                onCheckedChange = {

                },
                icon = FluentIcons.designIdeas(getUIKitColors().textFillColorPrimaryBrush, layered = true),
                iconSize = DpSize(32.dp, 32.dp),
                text = "Designs"
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }
    }
}

data class UIKitToggleButtonColors(
    val background: Color,
    val backgroundDisabled: Color,
    val backgroundChecked: Color,
    val content: Color,
    val contentDisabled: Color,
    val contentChecked: Color,
    val border: Color,
    val borderDisabled: Color,
    val borderChecked: Color,
) {
    companion object {
        @Composable
        fun default(
            background: Color = getUIKitColors().contentFillColorTertiaryBrush,
            backgroundDisabled: Color = getUIKitColors().contentFillColorBrushDisabled,
            backgroundChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
            content: Color = getUIKitColors().textFillColorPrimaryBrush,
            contentDisabled: Color = getUIKitColors().textFillColorDisabled,
            contentChecked: Color = UIKitColors.getDark().textFillColorPrimaryBrush,
            border: Color = getUIKitColors().lineFillColorPrimaryBrush,
            borderDisabled: Color = getUIKitColors().lineFillColorPrimaryBrush,
            borderChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
        ): UIKitToggleButtonColors = UIKitToggleButtonColors(
            background = background,
            backgroundDisabled = backgroundDisabled,
            backgroundChecked = backgroundChecked,
            content = content,
            contentDisabled = contentDisabled,
            contentChecked = contentChecked,
            border = border,
            borderDisabled = borderDisabled,
            borderChecked = borderChecked
        )
    }
}

@Composable
fun UIKitToggleButton(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitToggleButtonColors = UIKitToggleButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    content: @Composable BoxScope.() -> Unit
) {
    val backgroundColorAnimated = animateColorAsState(
        targetValue = if (!enabled) colors.backgroundDisabled else if (checked) colors.backgroundChecked else colors.background,
        animationSpec = tween(if (enabled) getUIKitAnimate().transformMomentaryDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val borderColorAnimated = animateColorAsState(
        targetValue = if (!enabled) colors.borderDisabled else if (checked) colors.borderChecked else colors.border,
        animationSpec = tween(if (enabled) getUIKitAnimate().transformMomentaryDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
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
        onClick = { onCheckedChange(!checked) },
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

@Composable
fun UIKitToggleButton(
    text: String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitToggleButtonColors = UIKitToggleButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
    textStyle: TextStyle = getUIKitTypography().body,
) = UIKitToggleButton(
    modifier = modifier,
    checked = checked,
    shape = shape,
    colors = colors,
    hasBorder = hasBorder,
    borderWidth = borderWidth,
    contentPadding = contentPadding,
    enabled = enabled,
    onCheckedChange = onCheckedChange
) {
    val contentColorAnimated by animateColorAsState(
        targetValue = if (!enabled) colors.contentDisabled else if (checked) colors.contentChecked else colors.content,
        animationSpec = tween(if (enabled) getUIKitAnimate().transformMomentaryDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    Text(
        text = text,
        style = textStyle,
        color = contentColorAnimated
    )
}

@Composable
fun UIKitToggleButton(
    icon: ImageVector,
    checked: Boolean,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitToggleButtonColors = UIKitToggleButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
    iconSize: DpSize = DpSize(icon.defaultWidth, icon.defaultHeight),
) = UIKitToggleButton(
    modifier = modifier,
    checked = checked,
    shape = shape,
    colors = colors,
    hasBorder = hasBorder,
    borderWidth = borderWidth,
    contentPadding = contentPadding,
    enabled = enabled,
    onCheckedChange = onCheckedChange
) {
    val contentColorAnimated by animateColorAsState(
        targetValue = if (!enabled) colors.contentDisabled else if (checked) colors.contentChecked else colors.content,
        animationSpec = tween(if (enabled) getUIKitAnimate().transformMomentaryDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    Icon(
        modifier = Modifier
            .size(iconSize),
        imageVector = icon,
        contentDescription = null,
        tint = contentColorAnimated
    )
}

@Composable
fun UIKitToggleButton(
    icon: ImageVector,
    text: String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitToggleButtonColors = UIKitToggleButtonColors.default(),
    hasBorder: Boolean = false,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
    iconSize: DpSize = DpSize(icon.defaultWidth, icon.defaultHeight),
    iconColor: Color = colors.contentChecked,
    iconColorChecked: Color = colors.content,
    textStyle: TextStyle = getUIKitTypography().body
) = UIKitToggleButton(
    modifier = modifier,
    checked = checked,
    shape = shape,
    colors = colors,
    hasBorder = hasBorder,
    borderWidth = borderWidth,
    contentPadding = contentPadding,
    enabled = enabled,
    onCheckedChange = onCheckedChange
) {
    val contentColorAnimated by animateColorAsState(
        targetValue = if (!enabled) colors.contentDisabled else if (checked) colors.contentChecked else colors.content,
        animationSpec = tween(if (enabled) getUIKitAnimate().transformMomentaryDurationMillis else getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val iconColorAnimated by animateColorAsState(
        targetValue = if (!enabled) colors.contentDisabled else if (checked) iconColorChecked else iconColor,
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