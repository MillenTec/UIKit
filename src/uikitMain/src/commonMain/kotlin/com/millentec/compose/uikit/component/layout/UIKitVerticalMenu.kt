package com.millentec.compose.uikit.component.layout

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.layout.UIKitMenuItem
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20.Accessibility
import com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20.Text
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes

@Composable
@Preview
private fun Preview() {
    UIKitVerticalMenu(
        items = listOf(
            UIKitMenuItem.textWithIcon(UIKitSymbols.Accessibility, "Option 1", onClick = {}),
            UIKitMenuItem.text("Option 2", onClick = {}, background = getUIKitColors().successGreenColorFourthBrush),
            UIKitMenuItem.icon(UIKitSymbols.Text, onClick = {}),
        )
    )
}

@Composable
fun UIKitVerticalMenu(
    modifier: Modifier = Modifier,
    maxLength: Dp = (-1).dp,
    minWidth: Dp = 200.dp,
    items: List<UIKitMenuItem>,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().smallSpacing),
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
            item.Content()

            if (index != items.size - 1) {
                Spacer(Modifier.height(contentPadding.calculateTopPadding()))
            }
        }
    }
}