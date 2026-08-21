package com.millentec.compose.uikit.foundation.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes
import com.millentec.compose.uikit.theme.getUIKitTypography

class UIKitMenuScope: UIKitItemScope<UIKitItem>() {
    @Composable
    fun Text(
        text: String,
        onClick: () -> Unit,
        minHeight: Dp = if (isDesktopOS()) 24.dp else 32.dp,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
        background: Color = Color.Transparent,
        cornerRadius: Dp = maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded),
    ) {
        add(object : UIKitItem() {
            @Composable
            override fun Content() {
                Column(
                    modifier = Modifier
                        .defaultMinSize(minHeight = minHeight)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(cornerRadius))
                        .background(background)
                        .uikitClickable(
                            onClick = onClick,
                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                        )
                        .padding(contentPadding),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = text,
                        style = getUIKitTypography().body,
                        color = color,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        })
    }

    @Composable
    fun Icon(
        icon: ImageVector,
        onClick: () -> Unit,
        minHeight: Dp = if (isDesktopOS()) 24.dp else 32.dp,
        contentDescription: String?,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
        background: Color = Color.Transparent,
        cornerRadius: Dp = maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded),
    ) {
        add(object : UIKitItem() {
            @Composable
            override fun Content() {
                Column(
                    modifier = Modifier
                        .defaultMinSize(minHeight = minHeight)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(cornerRadius))
                        .background(background)
                        .uikitClickable(
                            onClick = onClick,
                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                            shape = RoundedCornerShape(cornerRadius)
                        )
                        .padding(contentPadding),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(getUIKitTypography().body.lineHeight.value.dp),
                        imageVector = icon,
                        contentDescription = contentDescription,
                        tint = color
                    )
                }
            }
        })
    }

    @Composable
    fun TextWithIcon(
        icon: ImageVector,
        text: String,
        contentDescription: String? = text,
        onClick: () -> Unit,
        minHeight: Dp = if (isDesktopOS()) 24.dp else 32.dp,
        textColor: Color = getUIKitColors().textFillColorPrimaryBrush,
        iconColor: Color = getUIKitColors().textFillColorPrimaryBrush,
        contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
        background: Color = Color.Transparent,
        cornerRadius: Dp = maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded),
    ) {
        add(object : UIKitItem() {
            @Composable
            override fun Content() {
                Row(
                    modifier = Modifier
                        .defaultMinSize(minHeight = minHeight)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(cornerRadius))
                        .background(background)
                        .uikitClickable(
                            onClick = onClick,
                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                            shape = RoundedCornerShape(cornerRadius)
                        )
                        .padding(contentPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(getUIKitTypography().body.lineHeight.value.dp),
                        imageVector = icon,
                        contentDescription = contentDescription,
                        tint = iconColor
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Text(
                        text = text,
                        style = getUIKitTypography().body,
                        color = textColor,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        })
    }

    @Composable
    fun Divider(
        color: Color = getUIKitColors().lineFillColorPrimaryBrush,
        width: Dp = 1.dp,
        spacing: Dp = 0.dp,
    ) {
        add(object : UIKitItem() {
            @Composable
            override fun Content() {
                Row(
                    modifier = Modifier
                        .height(spacing)
                        .padding(horizontal = getUIKitLayout().basicSpacing),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        color = color,
                        thickness = width,
                    )
                }
            }
        })
    }

    @Suppress("FunctionName")
    fun Item(
        content: @Composable UIKitItem.() -> Unit,
    ) {
        add(object : UIKitItem() {
            @Composable
            override fun Content() {
                this.content()
            }
        })
    }
}