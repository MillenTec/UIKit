package com.millentec.compose.uikit.component.info

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.UIKitTheme
import com.millentec.compose.uikit.component.info.UIKitInfoCardType.*
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.filled.dp20.checkmarkCircle
import com.millentec.compose.uikit.icons.fluenticons.filled.dp20.dismissCircle
import com.millentec.compose.uikit.icons.fluenticons.filled.dp20.info
import com.millentec.compose.uikit.icons.fluenticons.filled.dp20.warning
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Dismiss
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.info
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitTheme(UIKitTheme(
        colors = UIKitColors.getLight()
    )) {
        Column(
            modifier = Modifier
                .background(getUIKitColors().contentFillColorPrimaryBrush)
                .padding(getUIKitLayout().mediumSpacing)
        ) {
            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                type = Info,
                title = "Info",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                type = HighlightInfo,
                title = "Highlight Info",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                type = Success,
                title = "Success",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                type = Warning,
                title = "Warning",
                body = "This the body."
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            UIKitInfoCard(
                modifier = Modifier.fillMaxWidth(),
                type = Error,
                title = "Error",
                body = "This the body."
            )
        }
    }
}

enum class UIKitInfoCardType {
    Info,
    HighlightInfo,
    Warning,
    Success,
    Error
}

@Composable
fun UIKitInfoCard(
    modifier: Modifier = Modifier,
    type: UIKitInfoCardType = Info,
    background: Color = when(type) {
        Info -> getUIKitColors().contentFillColorSecondaryBrush
        HighlightInfo -> getUIKitColors().highlightColorFourthBrush
        Warning -> getUIKitColors().warningYellowColorFourthBrush
        Success -> getUIKitColors().successGreenColorFourthBrush
        Error -> getUIKitColors().errorRedColorFourthBrush
    },
    contentColor: Color = when(type) {
        Info -> getUIKitColors().textFillColorPrimaryBrush
        HighlightInfo -> getUIKitColors().highlightColorPrimaryBrush
        Warning -> getUIKitColors().warningYellowColorPrimaryBrush
        Success -> getUIKitColors().successGreenColorPrimaryBrush
        Error -> getUIKitColors().errorRedColorPrimaryBrush
    },
    icon: ImageVector? = when(type) {
        Info -> FluentIcons.info(getUIKitColors().highlightColorPrimaryBrush, true)
        HighlightInfo -> FluentIcons.Filled.info(getUIKitColors().highlightColorPrimaryBrush, true)
        Warning -> FluentIcons.Filled.warning(getUIKitColors().warningYellowColorPrimaryBrush, true)
        Success -> FluentIcons.Filled.checkmarkCircle(getUIKitColors().successGreenColorPrimaryBrush, true)
        Error -> FluentIcons.Filled.dismissCircle(getUIKitColors().errorRedColorPrimaryBrush, true)
    },
    iconColor: Color = when(type) {
        Info -> getUIKitColors().highlightColorPrimaryBrush
        HighlightInfo -> getUIKitColors().highlightColorPrimaryBrush
        Warning -> getUIKitColors().warningYellowColorPrimaryBrush
        Success -> getUIKitColors().successGreenColorPrimaryBrush
        Error -> getUIKitColors().errorRedColorPrimaryBrush
    },
    shadowEnabled: Boolean = false,
    title: String,
    clickable: Boolean = false,
    onClick: () -> Unit = {},
    visible: Boolean = true,
    closeable: Boolean = true,
    onClose: () -> Unit = {},
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().mediumSpacing),
    body: (@Composable BoxScope.() -> Unit)? = null,
) {
    AnimatedVisibility(
        visible = visible,
    ) {
        Box {
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(cornerRadius))
                    .then(
                        if (shadowEnabled) {
                            Modifier.dropShadow(
                                shadow = UIKitShadowMaterial.getPrimary(),
                                shape = RoundedCornerShape(cornerRadius)
                            )
                        } else Modifier
                    )
                    .background(background)
                    .uikitClickable(
                        enabled = clickable,
                        onClick = onClick,
                        indication = if (isDesktopOS()) null else ripple()
                    )
                    .padding(contentPadding)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (icon != null) {
                        Icon(
                            modifier = Modifier
                                .size(22.dp),
                            imageVector = icon,
                            contentDescription = type.name,
                            tint = iconColor
                        )
                    }

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Text(
                        text = title,
                        style = getUIKitTypography().body,
                        color = contentColor
                    )
                }

                if (body != null) {
                    Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                    Row {
                        Spacer(Modifier.width(22.dp + getUIKitLayout().basicSpacing))
                        Box(
                            content = body
                        )
                    }
                }
            }

            if (closeable) {
                Row {
                    Spacer(Modifier.weight(1f))

                    Box(
                        modifier = Modifier
                            .padding(getUIKitLayout().basicSpacing)
                            .clip(
                                RoundedCornerShape(
                                    maxOf(cornerRadius - getUIKitLayout().basicSpacing, getUIKitShapes().basicRounded)
                                )
                            )
                            .size(
                                (contentPadding.calculateTopPadding() - getUIKitLayout().basicSpacing) * 2 + 22.dp
                            )
                            .uikitClickable(
                                onClick = onClose,
                                indication = if (isDesktopOS()) null else ripple()
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp),
                            imageVector = FluentIcons.Dismiss,
                            contentDescription = "Close Info Bar",
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UIKitInfoCard(
    modifier: Modifier = Modifier,
    type: UIKitInfoCardType = Info,
    background: Color = when(type) {
        Info -> getUIKitColors().contentFillColorSecondaryBrush
        HighlightInfo -> getUIKitColors().highlightColorFourthBrush
        Warning -> getUIKitColors().warningYellowColorFourthBrush
        Success -> getUIKitColors().successGreenColorFourthBrush
        Error -> getUIKitColors().errorRedColorFourthBrush
    },
    titleColor: Color = when(type) {
        Info -> getUIKitColors().textFillColorPrimaryBrush
        HighlightInfo -> getUIKitColors().highlightColorPrimaryBrush
        Warning -> getUIKitColors().warningYellowColorPrimaryBrush
        Success -> getUIKitColors().successGreenColorPrimaryBrush
        Error -> getUIKitColors().errorRedColorPrimaryBrush
    },
    icon: ImageVector? = when(type) {
        Info -> FluentIcons.info(getUIKitColors().highlightColorPrimaryBrush, true)
        HighlightInfo -> FluentIcons.Filled.info(getUIKitColors().highlightColorPrimaryBrush, true)
        Warning -> FluentIcons.Filled.warning(getUIKitColors().warningYellowColorPrimaryBrush, true)
        Success -> FluentIcons.Filled.checkmarkCircle(getUIKitColors().successGreenColorPrimaryBrush, true)
        Error -> FluentIcons.Filled.dismissCircle(getUIKitColors().errorRedColorPrimaryBrush, true)
    },
    iconColor: Color = when(type) {
        Info -> getUIKitColors().highlightColorPrimaryBrush
        HighlightInfo -> getUIKitColors().highlightColorPrimaryBrush
        Warning -> getUIKitColors().warningYellowColorPrimaryBrush
        Success -> getUIKitColors().successGreenColorPrimaryBrush
        Error -> getUIKitColors().errorRedColorPrimaryBrush
    },
    shadowEnabled: Boolean = false,
    title: String,
    clickable: Boolean = false,
    onClick: () -> Unit = {},
    visible: Boolean = true,
    closeable: Boolean = true,
    onClose: () -> Unit = {},
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().mediumSpacing),
    body: String,
    bodyColor: Color = getUIKitColors().textFillColorPrimaryBrush
) = UIKitInfoCard(
    modifier = modifier,
    type = type,
    background = background,
    contentColor = titleColor,
    icon = icon,
    iconColor = iconColor,
    shadowEnabled = shadowEnabled,
    title = title,
    clickable = clickable,
    onClick = onClick,
    visible = visible,
    closeable = closeable,
    onClose = onClose,
    cornerRadius = cornerRadius,
    contentPadding = contentPadding,
) {
    Text(
        text = body,
        style = getUIKitTypography().footnote,
        color = bodyColor,
    )
}