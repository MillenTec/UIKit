package com.millentec.compose.uikit.foundation.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Apps
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.ChevronArrowRight
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography

@Composable
@Preview
private fun Preview() {
    UIKitCardItem.settingCard(
        onClick = {},
        title = "Card",
        icon = FluentIcons.Apps,
        description = "This is a description",
    ).Content()
}

open class UIKitCardItem: UIKitItem() {
    companion object {
        @Composable
        fun settingCard(
            modifier: Modifier = Modifier,
            title: String,
            onClick: () -> Unit,
            enabled: Boolean = true,
            icon: ImageVector? = null,
            iconColor: Color = getUIKitColors().textFillColorPrimaryBrush,
            description: String? = null,
            background: Color = getUIKitColors().contentFillColorSecondaryBrush,
            contentPadding: PaddingValues = PaddingValues(horizontal = getUIKitLayout().cardPadding, vertical = getUIKitLayout().itemSpacing),
            content: @Composable BoxScope.() -> Unit = {
                Icon(
                    modifier = Modifier
                        .size(getUIKitTypography().footnote.lineHeight.value.dp),
                    imageVector = FluentIcons.ChevronArrowRight,
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            }
        ): UIKitCardItem {
            return object: UIKitCardItem() {
                @Composable
                override fun Content() {
                    Box(
                        modifier = modifier
                            .defaultMinSize(minHeight = getUIKitLayout().interactiveHotspot),
                        propagateMinConstraints = true
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(background)
                                .uikitClickable(
                                    onClick = onClick,
                                    enabled = enabled,
                                    indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                                )
                                .padding(contentPadding),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            if (icon != null) {
                                Icon(
                                    modifier = Modifier
                                        .size(getUIKitTypography().body.lineHeight.value.dp),
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                    tint = iconColor
                                )

                                Spacer(Modifier.width(getUIKitLayout().basicSpacing))
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Text(
                                    text = title,
                                    style = getUIKitTypography().body,
                                    color = getUIKitColors().textFillColorPrimaryBrush
                                )

                                if (description != null) {
                                    Text(
                                        text = description,
                                        style = getUIKitTypography().footnote,
                                        color = getUIKitColors().textFillColorSecondaryBrush
                                    )
                                }
                            }

                            Box(
                                contentAlignment = Alignment.Center,
                                content = content
                            )
                        }
                    }
                }
            }
        }

        @Composable
        fun divider(
            color: Color = getUIKitColors().lineFillColorPrimaryBrush,
            lineWidth: Dp = 1.dp,
        ): UIKitCardItem {
            return object: UIKitCardItem() {
                @Composable
                override fun Content() {
                    HorizontalDivider(
                        color = color,
                        thickness = lineWidth,
                    )
                }
            }
        }
    }
}