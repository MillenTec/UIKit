package com.millentec.compose.uikit.views.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.views.pages.StateSelectorItem

@Composable
fun StateSelector(
    states: List<StateSelectorItem>,
    state: MutableState<Int>,
    itemWidth: Dp = 148.dp
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        states.forEachIndexed { index, item ->
            val borderColor by animateColorAsState(
                targetValue = if (index == state.value) getUIKitColors().highlightColorPrimaryBrush else Color.Transparent,
                animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
            )

            Column(
                modifier = Modifier
                    .padding(
                        top = getUIKitLayout().basicSpacing,
                        bottom = getUIKitLayout().basicSpacing,
                        end = if (index == states.size - 1) 0.dp else getUIKitLayout().basicSpacing,
                    )
                    .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                    .width(itemWidth)
                    .background(getUIKitColors().contentFillColorSecondaryBrush)
                    .border(
                        width = 1.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(getUIKitShapes().regularRounded),
                    )
                    .uikitClickable(
                        onClick = {
                            state.value = index
                        },
                        indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                    )
                    .padding(getUIKitLayout().mediumSpacing),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center,
                    content = item.statePreview
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                Text(
                    text = item.state,
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorPrimaryBrush,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}