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

open class UIKitDropdownMenuItem: UIKitItem() {
    companion object {
        fun text(
            text: String,
            onClick: () -> Unit,
            minHeight: Dp = if (isDesktopOS()) 24.dp else 32.dp,
            color: Color? = null,
            contentPadding: PaddingValues? = null,
            background: Color? = null,
            cornerRadius: Dp? = null,
        ): UIKitDropdownMenuItem {
            return object : UIKitDropdownMenuItem() {
                @Composable
                override fun Content() {
                    Column(
                        modifier = Modifier
                            .defaultMinSize(minHeight = minHeight)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(cornerRadius ?: maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded)))
                            .background(background ?: Color.Transparent)
                            .uikitClickable(
                                onClick = onClick,
                                indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                            )
                            .padding(contentPadding ?: PaddingValues(getUIKitLayout().basicSpacing)),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = text,
                            style = getUIKitTypography().body,
                            color = color ?: getUIKitColors().textFillColorPrimaryBrush,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }

        fun icon(
            icon: ImageVector,
            onClick: () -> Unit,
            minHeight: Dp = if (isDesktopOS()) 24.dp else 32.dp,
            description: String? = null,
            color: Color? = null,
            contentPadding: PaddingValues? = null,
            background: Color? = null,
            cornerRadius: Dp? = null,
        ): UIKitDropdownMenuItem {
            return object : UIKitDropdownMenuItem() {
                @Composable
                override fun Content() {
                    Column(
                        modifier = Modifier
                            .defaultMinSize(minHeight = minHeight)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(cornerRadius ?: maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded)))
                            .background(background ?: Color.Transparent)
                            .uikitClickable(
                                onClick = onClick,
                                indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                                shape = RoundedCornerShape(cornerRadius ?: maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded))
                            )
                            .padding(contentPadding ?: PaddingValues(getUIKitLayout().basicSpacing)),
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = icon,
                            contentDescription = description,
                            tint = color ?: getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                }
            }
        }

        fun textWithIcon(
            icon: ImageVector,
            text: String,
            onClick: () -> Unit,
            minHeight: Dp = if (isDesktopOS()) 24.dp else 32.dp,
            textColor: Color? = null,
            iconColor: Color? = null,
            contentPadding: PaddingValues? = null,
            background: Color? = null,
            cornerRadius: Dp? = null,
        ): UIKitDropdownMenuItem {
            return object : UIKitDropdownMenuItem() {
                @Composable
                override fun Content() {
                    Row(
                        modifier = Modifier
                            .defaultMinSize(minHeight = minHeight)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(cornerRadius ?: maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded)))
                            .background(background ?: Color.Transparent)
                            .uikitClickable(
                                onClick = onClick,
                                indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                                shape = RoundedCornerShape(cornerRadius ?: maxOf(getUIKitShapes().regularRounded - getUIKitLayout().smallSpacing, getUIKitShapes().smallRounded))
                            )
                            .padding(contentPadding ?: PaddingValues(getUIKitLayout().basicSpacing)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = icon,
                            contentDescription = text,
                            tint = iconColor ?: getUIKitColors().textFillColorPrimaryBrush
                        )

                        Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                        Text(
                            text = text,
                            style = getUIKitTypography().body,
                            color = textColor ?: getUIKitColors().textFillColorPrimaryBrush,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }

        fun divider(
            color: Color? = null,
            width: Dp = 1.dp,
            spacing: Dp? = null,
        ): UIKitDropdownMenuItem {
            return object : UIKitDropdownMenuItem() {
                @Composable
                override fun Content() {
                    Row(
                        modifier = Modifier
                            .height(spacing ?: 0.dp)
                            .padding(horizontal = getUIKitLayout().basicSpacing),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(
                            color = color ?: getUIKitColors().lineFillColorPrimaryBrush,
                            thickness = width,
                        )
                    }
                }
            }
        }
    }
}