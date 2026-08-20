package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.layout.UIKitCardItem
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Apps
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Color
import com.millentec.compose.uikit.theme.UIKitShadowMaterial
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitShapes

@Composable
@Preview
private fun Preview() {
    LazyColumn(

    ) {
        item {
            UIKitGroupedCard(
                items = listOf(
                    UIKitCardItem.settingCard(
                        title = "Title",
                        icon = FluentIcons.Color,
                        onClick = {}
                    ),
                    UIKitCardItem.divider(),
                    UIKitCardItem.settingCard(
                        title = "Title",
                        icon = FluentIcons.Apps,
                        description = "This is a description.",
                        onClick = {}
                    ),
                    UIKitCardItem.divider(),
                    UIKitCardItem.settingCard(
                        title = "Title",
                        onClick = {}
                    )
                )
            )
        }
    }
}

@Composable
fun UIKitGroupedCard(
    modifier: Modifier = Modifier,
    items: List<UIKitCardItem>,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    shadowEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    insertDivider: Boolean = false,
) {
    val contentItems = remember { mutableStateListOf<UIKitCardItem>() }
    val divider = UIKitCardItem.divider()

    LaunchedEffect(items) {
        contentItems.clear()
        if (!insertDivider) {
            contentItems.addAll(items)
            return@LaunchedEffect
        }

        items.forEachIndexed { index, item ->
            contentItems.add(item)
            if (index != items.size - 1 && insertDivider) {
                contentItems.add(divider)
            }
        }
    }

    Column(
        modifier = modifier
            .then(if (shadowEnabled) {
                Modifier.dropShadow(
                    shape = RoundedCornerShape(cornerRadius),
                    shadow = UIKitShadowMaterial.getPrimary()
                )
            } else Modifier)
            .clip(RoundedCornerShape(cornerRadius))
            .background(background)
            .padding(contentPadding),
    ) {
        contentItems.forEach { item ->
            item.Content()
        }
    }
}