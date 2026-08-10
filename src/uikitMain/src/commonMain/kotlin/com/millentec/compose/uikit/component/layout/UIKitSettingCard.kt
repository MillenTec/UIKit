package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20.Apps
import com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20.ChevronArrowRight
import com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20.Tools
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    Column {
        UIKitSettingCard(
            onClick = {},
            title = "Hello",
            description = "This is a description",
            icon = UIKitSymbols.Apps
        )

        Spacer(modifier = Modifier.size(getUIKitLayout().basicSpacing))

        UIKitSettingCard(
            title = "Title",
            icon = UIKitSymbols.Tools
        ) {
            Text(
                text = "This is a content.",
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }
    }
}

@Composable
fun UIKitSettingCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    iconColor: Color = getUIKitColors().textFillColorPrimaryBrush,
    title: String,
    description: String? = null,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    shadowEnabled: Boolean = false,
    content: @Composable BoxScope.() -> Unit = {
        Icon(
            modifier = Modifier
                .size(getUIKitTypography().body.lineHeight.value.dp),
            imageVector = UIKitSymbols.ChevronArrowRight,
            contentDescription = null,
            tint = getUIKitColors().textFillColorPrimaryBrush
        )
    }
) {
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = getUIKitLayout().interactiveHotspot),
        propagateMinConstraints = true
    ) {
        Row(
            modifier = Modifier
                .then(if (shadowEnabled) {
                    Modifier.dropShadow(
                        shape = RoundedCornerShape(cornerRadius),
                        shadow = UIKitShadowMaterial.getPrimary()
                    )
                } else Modifier)
                .clip(RoundedCornerShape(cornerRadius))
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

@Composable
fun UIKitSettingCard(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    iconColor: Color = getUIKitColors().textFillColorPrimaryBrush,
    title: String,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    shadowEnabled: Boolean = false,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier,
        propagateMinConstraints = true
    ) {
        Column(
            modifier = Modifier
                .then(if (shadowEnabled) {
                    Modifier.dropShadow(
                        shape = RoundedCornerShape(cornerRadius),
                        shadow = UIKitShadowMaterial.getPrimary()
                    )
                } else Modifier)
                .clip(RoundedCornerShape(cornerRadius))
                .fillMaxWidth()
                .background(background)
                .padding(contentPadding)
        ) {
            Row(
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

                Text(
                    text = title,
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            Column(
                content = content
            )
        }
    }
}