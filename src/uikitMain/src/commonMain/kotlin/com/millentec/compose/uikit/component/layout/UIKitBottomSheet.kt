package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.flyout.UIKitFlyouter
import com.millentec.compose.uikit.component.flyout.UIKitSwipeableFlyout
import com.millentec.compose.uikit.component.flyout.UIKitSwipeableFlyoutState
import com.millentec.compose.uikit.foundation.layout.UIKitAlignment
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.skydoves.cloudy.cloudy

@Composable
@Preview
private fun Preview() {
    UIKitFlyouter {
        UIKitBottomSheet(
            modifier = Modifier.fillMaxSize(),
            expanded = true,
            state = UIKitSwipeableFlyoutState(),
            title = "Sheet",
            onDismissRequest = {}
        ) {
            Spacer(Modifier.height(500.dp))
        }
    }
}

@Composable
fun Modifier.uikitBottomSheetCollaborativeAnimation(
    state: UIKitSwipeableFlyoutState,
    blurEffectEnabled: Boolean = true,
): Modifier {
    val progress = state.progress.value
    val enabledCurrent by rememberUpdatedState(progress != 0f)

    return if (enabledCurrent) {
        this
            .cloudy(
                enabled = blurEffectEnabled,
                radius = (progress * (10 * LocalDensity.current.density)).toInt().coerceAtLeast(0),
            )
            .drawWithContent {
                drawContent()
                drawRect(
                    color = Color.Black.copy(
                        alpha = (progress * 0.3f).coerceIn(0f..1f)
                    ),
                    size = size
                )
            }
            .graphicsLayer(
                scaleX = (1f - (progress * 0.1f)).coerceIn(0f..1f),
                scaleY = 1f - (progress * 0.1f).coerceIn(0f..1f),
            )
    } else this
}

@Composable
fun UIKitBottomSheet(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    state: UIKitSwipeableFlyoutState,
    background: Color = getUIKitColors().contentFillColorPrimaryBrush,
    cornerRadius: Dp = getUIKitShapes().largeRounded,
    maxWidth: Dp = (-1).dp,
    maxHeight: Dp = 640.dp,
    minHeight: Dp = 512.dp,
    header: @Composable (BoxScope.() -> Unit)? = null,
    stripColor: Color = getUIKitColors().contentFillColorTertiaryBrush,
    stripVisible: Boolean = true,
    title: String? = null,
    titleMaxWidth: Dp = (-1).dp,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    val modifierCurrent by rememberUpdatedState(modifier)
    val backgroundCurrent by rememberUpdatedState(background)
    val cornerRadiusCurrent by rememberUpdatedState(cornerRadius)
    val maxWidthCurrent by rememberUpdatedState(maxWidth)
    val maxHeightCurrent by rememberUpdatedState(maxHeight)
    val minHeightCurrent by rememberUpdatedState(minHeight)
    val headerCurrent by rememberUpdatedState(header)
    val stripColorCurrent by rememberUpdatedState(stripColor)
    val stripVisibleCurrent by rememberUpdatedState(stripVisible)
    val titleCurrent by rememberUpdatedState(title)
    val titleMaxWidthCurrent by rememberUpdatedState(titleMaxWidth)
    val contentCurrent by rememberUpdatedState(content)

    UIKitSwipeableFlyout(
        state = state,
        visible = expanded,
        onDismissRequest = onDismissRequest,
        alignment = Alignment.BottomCenter,
        swipeDirection = UIKitAlignment.BottomCenter
    ) {
        BoxWithConstraints(
            modifier = modifierCurrent,
            contentAlignment = Alignment.BottomCenter,
        ) {
            Column (
                modifier = Modifier
                    .then(if (maxWidthCurrent != (-1).dp) {
                        Modifier.width(minOf(maxWidthCurrent, this@BoxWithConstraints.maxWidth))
                    } else Modifier.fillMaxWidth())
                    .heightIn(min = minHeightCurrent, max = maxHeightCurrent)
                    .clip(RoundedCornerShape(
                        topStart = cornerRadiusCurrent,
                        topEnd = cornerRadiusCurrent,
                    ))
                    .background(backgroundCurrent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = cornerRadiusCurrent)
                        .then(it),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        if (stripVisibleCurrent) {
                            Box(
                                modifier = Modifier
                                    .padding(
                                        top = getUIKitLayout().mediumSpacing
                                    )
                                    .fillMaxWidth(0.3f)
                                    .height(3.dp)
                                    .clip(RoundedCornerShape(getUIKitShapes().circular))
                                    .background(stripColorCurrent)
                            )
                        }

                        if (titleCurrent != null) {
                            if (stripVisibleCurrent) {
                                Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                            }

                            Text(
                                modifier = Modifier
                                    .then(if (titleMaxWidthCurrent != (-1).dp) {
                                        Modifier.widthIn(max = titleMaxWidthCurrent)
                                    } else Modifier),
                                text = titleCurrent ?: "",
                                style = getUIKitTypography().body,
                                color = getUIKitColors().textFillColorSecondaryBrush,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    }

                    if (headerCurrent != null) {
                        Box(content = headerCurrent ?: {})
                    }
                }

                Column(
                    content = contentCurrent,
                )
            }
        }
    }
}