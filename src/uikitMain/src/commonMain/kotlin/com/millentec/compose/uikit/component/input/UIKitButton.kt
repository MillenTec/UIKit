package com.millentec.compose.uikit.component.input

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import androidx.compose.ui.unit.sp
import com.millentec.compose.uikit.component.layout.UIKitSurface
import com.millentec.compose.uikit.component.media.UIKitIcon
import com.millentec.compose.uikit.component.media.UIKitSymbolOptions
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitThemeHost(
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
            content: Color = UIKitColors.contentColor(background),
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

data class UIKitButtonStyle(
    val colors: UIKitButtonColors,
    val shape: Shape,
    val border: Dp?,
    val textStyle: TextStyle,
    val contentPadding: PaddingValues,
    val animateEnabled: Boolean = true,
    val interactionSource: MutableInteractionSource?,
    val indication: Indication?,
    val interaction: UIKitInteraction?,
) {
    companion object {
        @Composable
        fun default(
            colors: UIKitButtonColors = UIKitButtonColors.default(),
            shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
            border: Dp? = null,
            textStyle: TextStyle = getUIKitTypography().body,
            contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
            animateEnabled: Boolean = true,
            interactionSource: MutableInteractionSource? = null,
            indication: Indication? = if (isDesktopOS()) null else UIKitInteraction.ripple(),
            interaction: UIKitInteraction? = null,
        ): UIKitButtonStyle {
            return UIKitButtonStyle(
                colors = colors,
                shape = shape,
                border = border,
                textStyle = textStyle,
                contentPadding = contentPadding,
                animateEnabled = animateEnabled,
                interactionSource = interactionSource,
                indication = indication,
                interaction = interaction
            )
        }

        val Primary: UIKitButtonStyle
            @Composable
            get() = UIKitButtonStyle.default()

        val Accent: UIKitButtonStyle
            @Composable
            get() = UIKitButtonStyle.default(
                colors = UIKitButtonColors.default(
                    background = getUIKitColors().highlightColorPrimaryBrush,
                    content = UIKitColors.White
                )
            )

        val Ghost: UIKitButtonStyle
            @Composable
            get() = UIKitButtonStyle.default(
                colors = UIKitButtonColors.default(
                    background = Color.Transparent
                )
            )
    }
}

@Composable
fun UIKitButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: UIKitButtonStyle = UIKitButtonStyle.Primary,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val uiKitAnimate by rememberUpdatedState(getUIKitAnimate())

    val backgroundColorAnimated = remember { Animatable(
        initialValue = if (enabled) style.colors.background else style.colors.backgroundDisabled,
    ) }

    val borderColorAnimated = remember { Animatable(
        initialValue = if (enabled) style.colors.border else style.colors.borderDisabled
    ) }

    LaunchedEffect(enabled, style.colors) {
        if (style.animateEnabled) {
            backgroundColorAnimated.animateTo(
                targetValue = if (enabled) style.colors.background else style.colors.backgroundDisabled,
                animationSpec = tween(uiKitAnimate.transformRegularDurationMillis, easing = LinearEasing)
            )
            borderColorAnimated.animateTo(
                targetValue = if (enabled) style.colors.border else style.colors.borderDisabled,
                animationSpec = tween(uiKitAnimate.transformRegularDurationMillis, easing = LinearEasing)
            )
        } else {
            backgroundColorAnimated.snapTo(
                targetValue = if (enabled) style.colors.background else style.colors.backgroundDisabled
            )
            borderColorAnimated.snapTo(
                targetValue = if (enabled) style.colors.border else style.colors.borderDisabled
            )
        }
    }

    UIKitSurface(
        modifier = modifier
            .defaultMinSize(
                minWidth = 120.dp,
                minHeight = getUIKitLayout().interactiveHotspot
            )
            .then(if (style.border != null)
                Modifier.border(
                    width = style.border,
                    color = borderColorAnimated.value,
                    shape = style.shape)
            else Modifier),
        shape = style.shape,
        color = backgroundColorAnimated.value,
        enabled = enabled,
        onClick = onClick,
        interactionSource = style.interactionSource,
        indication = style.indication,
        interaction = style.interaction
    ) {
        Box(
            modifier = Modifier
                .padding(style.contentPadding),
            contentAlignment = Alignment.Center,
            content = content,
        )
    }
}

@Composable
fun UIKitButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: UIKitButtonStyle = UIKitButtonStyle.Primary,
    onClick: () -> Unit
) = UIKitButton(
    modifier = modifier,
    enabled = enabled,
    style = style,
    onClick = onClick,
) {
    val uiKitAnimate by rememberUpdatedState(getUIKitAnimate())

    val contentColorAnimated = remember { Animatable(
        initialValue = if (enabled) style.colors.content else style.colors.contentDisabled
    ) }

    LaunchedEffect(enabled, style.colors) {
        if (style.animateEnabled) {
            contentColorAnimated.animateTo(
                targetValue = if (enabled) style.colors.content else style.colors.contentDisabled,
                animationSpec = tween(uiKitAnimate.transformRegularDurationMillis, easing = LinearEasing)
            )
        } else {
            contentColorAnimated.snapTo(
                targetValue = if (enabled) style.colors.content else style.colors.contentDisabled
            )
        }
    }

    Text(
        text = text,
        style = style.textStyle,
        color = contentColorAnimated.value
    )
}

@Composable
@Suppress("ModifierParameter")
fun UIKitButton(
    symbol: UIKitSymbol,
    contentDescription: String?,
    symbolOption: UIKitSymbolOptions = UIKitSymbolOptions.default(),
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: UIKitButtonStyle = UIKitButtonStyle.Primary,
    onClick: () -> Unit
) = UIKitButton(
    modifier = modifier,
    enabled = enabled,
    style = style,
    onClick = onClick
) {
    UIKitIcon(
        modifier = Modifier
            .size(style.textStyle.lineHeight.value.dp),
        symbol = symbol,
        contentDescription = contentDescription,
        options = symbolOption
    )
}

@Composable
@Suppress("ModifierParameter")
fun UIKitButton(
    symbol: UIKitSymbol,
    text: String,
    contentDescription: String? = text,
    symbolOption: UIKitSymbolOptions = UIKitSymbolOptions.default(),
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: UIKitButtonStyle = UIKitButtonStyle.Primary,
    onClick: () -> Unit
) = UIKitButton(
    modifier = modifier,
    enabled = enabled,
    style = style,
    onClick = onClick
) {
    val uiKitAnimate by rememberUpdatedState(getUIKitAnimate())

    val contentColorAnimated = remember { Animatable(
        initialValue = if (enabled) style.colors.content else style.colors.contentDisabled
    ) }

    LaunchedEffect(enabled, style.colors) {
        if (style.animateEnabled) {
            contentColorAnimated.animateTo(
                targetValue = if (enabled) style.colors.content else style.colors.contentDisabled,
                animationSpec = tween(uiKitAnimate.transformRegularDurationMillis, easing = LinearEasing)
            )
        } else {
            contentColorAnimated.snapTo(
                targetValue = if (enabled) style.colors.content else style.colors.contentDisabled
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        UIKitIcon(
            modifier = Modifier
                .size(style.textStyle.lineHeight.value.dp),
            symbol = symbol,
            contentDescription = contentDescription,
            options = symbolOption
        )

        Spacer(Modifier.width(getUIKitLayout().smallSpacing))

        Text(
            text = text,
            style = style.textStyle,
            color = contentColorAnimated.value
        )
    }
}

@Deprecated("替换为使用 UIKitButtonStyle 的重载", ReplaceWith(
    "UIKitButton( modifier = modifier, enabled = enabled, style = UIKitButtonStyle( colors = colors, shape = shape, border = border, contentPadding = contentPadding, textStyle = getUIKitTypography().body, interactionSource = interactionSource, indication = indication, interaction = interaction, ), onClick = onClick, content = content )",
    "com.millentec.compose.uikit.theme.getUIKitTypography"
))
@Composable
fun UIKitButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    border: Dp? = null,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = if (isDesktopOS()) null else UIKitInteraction.ripple(),
    interaction: UIKitInteraction? = null,
    content: @Composable BoxScope.() -> Unit
) = UIKitButton(
    modifier = modifier,
    enabled = enabled,
    style = UIKitButtonStyle(
        colors = colors,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        textStyle = getUIKitTypography().body,
        interactionSource = interactionSource,
        indication = indication,
        interaction = interaction,
    ),
    onClick = onClick,
    content = content
)

@Deprecated("替换为使用 UIKitButtonStyle 的重载",
    ReplaceWith("UIKitButton( text = text, modifier = modifier, enabled = enabled, style = UIKitButtonStyle( colors = colors, shape = shape, border = border, contentPadding = contentPadding, textStyle = textStyle, interactionSource = interactionSource, indication = indication, interaction = interaction, ), onClick = onClick )")
)
@Composable
fun UIKitButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    border: Dp? = null,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = if (isDesktopOS()) null else UIKitInteraction.ripple(),
    interaction: UIKitInteraction? = null,
    textStyle: TextStyle = getUIKitTypography().body,
) = UIKitButton(
    text = text,
    modifier = modifier,
    enabled = enabled,
    style = UIKitButtonStyle(
        colors = colors,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        textStyle = textStyle,
        interactionSource = interactionSource,
        indication = indication,
        interaction = interaction,
    ),
    onClick = onClick
)

@Deprecated("替换为使用全新 UIKitSymbol 和 UIKitButtonStyle 的重载", ReplaceWith(
    "UIKitButton( symbol = UIKitImageVectorSymbol(icon), contentDescription = contentDescription, modifier = modifier, enabled = enabled, style = UIKitButtonStyle( colors = colors, shape = shape, border = border, contentPadding = contentPadding, textStyle = getUIKitTypography().body.copy(lineHeight = maxOf(iconSize.height, iconSize.width).value.sp), interactionSource = interactionSource, indication = indication, interaction = interaction, ), onClick = onClick )",
    "com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol",
    "com.millentec.compose.uikit.theme.getUIKitTypography",
    "androidx.compose.ui.unit.sp"
))
@Composable
fun UIKitButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconSize: DpSize = DpSize(icon.defaultWidth, icon.defaultHeight),
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    border: Dp? = null,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = if (isDesktopOS()) null else UIKitInteraction.ripple(),
    interaction: UIKitInteraction? = null,
    contentDescription: String? = null,
) = UIKitButton(
    symbol = UIKitImageVectorSymbol(icon),
    contentDescription = contentDescription,
    modifier = modifier,
    enabled = enabled,
    style = UIKitButtonStyle(
        colors = colors,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        textStyle = getUIKitTypography().body.copy(lineHeight = maxOf(iconSize.height, iconSize.width).value.sp),
        interactionSource = interactionSource,
        indication = indication,
        interaction = interaction,
    ),
    onClick = onClick
)

@Deprecated("替换为使用全新 UIKitSymbol 和 UIKitButtonStyle 的重载", ReplaceWith(
    "UIKitButton( modifier = modifier, enabled = enabled, symbol = UIKitImageVectorSymbol(icon), text = text, style = UIKitButtonStyle( colors = colors, shape = shape, border = border, contentPadding = contentPadding, textStyle = textStyle, interactionSource = interactionSource, indication = indication, interaction = interaction, ), onClick = onClick )",
    "com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol"
))
@Composable
fun UIKitButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconSize: DpSize = DpSize(icon.defaultWidth, icon.defaultHeight),
    text: String,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    colors: UIKitButtonColors = UIKitButtonColors.default(),
    border: Dp? = null,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    enabled: Boolean = true,
    onClick: () -> Unit,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = if (isDesktopOS()) null else UIKitInteraction.ripple(),
    interaction: UIKitInteraction? = null,
    textStyle: TextStyle = getUIKitTypography().body
) = UIKitButton(
    modifier = modifier,
    enabled = enabled,
    symbol = UIKitImageVectorSymbol(icon),
    text = text,
    style = UIKitButtonStyle(
        colors = colors,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        textStyle = textStyle,
        interactionSource = interactionSource,
        indication = indication,
        interaction = interaction,
    ),
    onClick = onClick
)