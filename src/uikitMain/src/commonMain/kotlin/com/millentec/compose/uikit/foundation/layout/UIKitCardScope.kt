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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.media.UIKitIcon
import com.millentec.compose.uikit.component.media.UIKitIconOptions
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.ChevronArrowRight
import com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography

class UIKitCardScope {
    @Deprecated("使用适用于 UIKitSymbols 的重载替换")
    @Composable
    fun SettingCard(
        modifier: Modifier = Modifier,
        title: String,
        onClick: () -> Unit,
        enabled: Boolean = true,
        icon: ImageVector? = null,
        iconColor: Color = getUIKitColors().textFillColorPrimaryBrush,
        description: String? = null,
        background: Color = getUIKitColors().contentFillColorSecondaryBrush,
        contentPadding: PaddingValues = PaddingValues(getUIKitLayout().cardPadding),
        content: @Composable BoxScope.() -> Unit = {
            Icon(
                modifier = Modifier
                    .size(getUIKitTypography().footnote.lineHeight.value.dp),
                imageVector = FluentIcons.ChevronArrowRight,
                contentDescription = null,
                tint = getUIKitColors().textFillColorPrimaryBrush
            )
        }
    ) = SettingCard(
        modifier = modifier,
        title = title,
        clickable = true,
        onClick = onClick,
        enabled = enabled,
        symbol = icon?.let { UIKitImageVectorSymbol(it) },
        symbolOptions = UIKitIconOptions.default(symbolStyle = UIKitSymbolStyle.Monochrome(iconColor)),
        description = description,
        background = background,
        contentPadding = contentPadding,
        actionSymbol = null,
        content = content
    )

    @Composable
    fun SettingCard(
        modifier: Modifier = Modifier,
        title: String,
        clickable: Boolean = true,
        onClick: (() -> Unit)? = null,
        enabled: Boolean = true,
        symbol: UIKitSymbol? = null,
        symbolOptions: UIKitIconOptions = UIKitIconOptions.default(),
        description: String? = null,
        background: Color = getUIKitColors().contentFillColorSecondaryBrush,
        contentPadding: PaddingValues = PaddingValues(getUIKitLayout().cardPadding),
        actionSymbol: UIKitSymbol? = null,
        actionSymbolOptions: UIKitIconOptions? = UIKitIconOptions.default(),
        actionDescription: String? = null,
        content: (@Composable BoxScope.() -> Unit)? = null
    ) {
        Box(
            modifier = modifier
                .defaultMinSize(minHeight = getUIKitLayout().interactiveHotspot),
            propagateMinConstraints = true
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(background)
                    .then(if (clickable && onClick != null) {
                        Modifier.uikitClickable(
                            onClick = onClick,
                            enabled = enabled && clickable,
                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                        )
                    } else Modifier)
                    .padding(contentPadding),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (symbol != null) {
                    UIKitIcon(
                        modifier = Modifier
                            .size(
                                if (description == null) getUIKitTypography().body.lineHeight.value.dp
                                else getUIKitTypography().title.lineHeight.value.dp
                            ),
                        symbol = symbol,
                        options = symbolOptions,
                        contentDescription = title
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

                Spacer(Modifier.width(getUIKitLayout().itemSpacing))

                content?.let {
                    Box(
                        contentAlignment = Alignment.Center,
                        content = it
                    )
                }

                Spacer(Modifier.width(getUIKitLayout().itemSpacing))

                if (actionSymbol != null && actionSymbolOptions != null) {
                    UIKitIcon(
                        modifier = Modifier
                            .size(getUIKitTypography().body.lineHeight.value.dp),
                        symbol = actionSymbol,
                        contentDescription = actionDescription,
                        options = actionSymbolOptions
                    )
                }
            }
        }
    }

    @Composable
    fun Divider(
        color: Color = getUIKitColors().lineFillColorPrimaryBrush,
        lineWidth: Dp = 1.dp,
    ) {
        HorizontalDivider(
            color = color,
            thickness = lineWidth,
        )
    }

    @Composable
    fun Item(
        content: @Composable () -> Unit
    ) {
        content()
    }
}