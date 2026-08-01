package com.millentec.compose.uikit.component.layout

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Accessibility
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Settings
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Text
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    VerticalItemLayout(
        onClick = {},
        items = listOf<Pair<String, ImageVector?>>(
            Pair("Item 1", FluentIcons.Accessibility),
            Pair("Item 2", FluentIcons.Text),
            Pair("Item 3", FluentIcons.Settings),
        )
    )
}

@Composable
fun VerticalItemLayout(
    modifier: Modifier = Modifier,
    maxLength: Dp = (-1).dp,
    minWidth: Dp = 200.dp,
    items: List<@Composable BoxScope.() -> Unit>,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().smallSpacing),
    itemSpacing: Dp = getUIKitLayout().smallSpacing,
    hasDividers: Boolean = true,
    dividerColor: Color = getUIKitColors().lineFillColorPrimaryBrush,
    onClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(background)
            .defaultMinSize(minWidth = minWidth)
            .width(IntrinsicSize.Max)
            .then(if (maxLength != (-1).dp) {
                Modifier.heightIn(max = maxLength)
            } else Modifier)
            .verticalScroll(rememberScrollState())
            .padding(contentPadding)
            .animateContentSize(
                animationSpec = tween(getUIKitAnimate().motionRegularDurationMillis, easing = FastOutSlowInEasing)
            ),
    ) {
        items.forEachIndexed { index, item ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(maxOf(contentPadding.calculateTopPadding(), getUIKitShapes().basicRounded)))
                    .fillMaxWidth()
                    .uikitClickable(
                        onClick = { onClick(index) },
                        indication = if (isDesktopOS()) null else UIKitInteraction.ripple(),
                    )
                    .padding(contentPadding),
                content = item
            )

            if (index != items.size - 1) {
                Box(
                    modifier = Modifier
                        .height(itemSpacing),
                    contentAlignment = Alignment.Center
                ) {
                    if (hasDividers) {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = dividerColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VerticalItemLayout(
    modifier: Modifier = Modifier,
    maxLength: Dp = (-1).dp,
    minWidth: Dp = 200.dp,
    items: List<Pair<String, ImageVector?>>,
    iconTint: Color = getUIKitColors().textFillColorPrimaryBrush,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().smallSpacing),
    itemSpacing: Dp = getUIKitLayout().smallSpacing,
    hasDividers: Boolean = true,
    dividerColor: Color = getUIKitColors().lineFillColorPrimaryBrush,
    onClick: (Int) -> Unit
) {
    val itemList = remember { mutableStateListOf<@Composable BoxScope.() -> Unit>() }

    LaunchedEffect(items) {
        itemList.clear()
        items.forEach {
            itemList.add @Composable {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    it.second?.let { icon ->
                        Icon(
                            modifier = Modifier
                                .size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = icon,
                            contentDescription = null,
                            tint = iconTint,
                        )

                        Spacer(Modifier.width(getUIKitLayout().basicSpacing))
                    }

                    Text(
                        text = it.first,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush,
                    )
                }
            }
        }
    }

    VerticalItemLayout(
        modifier = modifier,
        maxLength = maxLength,
        minWidth = minWidth,
        items = itemList,
        background = background,
        cornerRadius = cornerRadius,
        contentPadding = contentPadding,
        itemSpacing = itemSpacing,
        hasDividers = hasDividers,
        dividerColor = dividerColor,
        onClick = onClick
    )
}