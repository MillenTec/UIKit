package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.layout.UIKitCardScope
import com.millentec.compose.uikit.theme.UIKitShadowMaterial
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitShapes

@Composable
@Preview
private fun Preview() {
    LazyColumn {
        item {
            UIKitGroupedCard {
                SettingCard(
                    title = "Title",
                    onClick = {}
                )

                Divider()

                SettingCard(
                    title = "Title",
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun UIKitGroupedCard(
    modifier: Modifier = Modifier,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    shadowEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable UIKitCardScope.() -> Unit
) {
    val scope = UIKitCardScope()
    scope.content()

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
        scope.items.forEach { item ->
            item.Content()
        }
    }
}