package com.millentec.compose.uikit.component.layout

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.UIKitButton
import com.millentec.compose.uikit.component.input.UIKitButtonColors
import com.millentec.compose.uikit.foundation.uikitSwipeable
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Checkmark
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Dismiss
import com.millentec.compose.uikit.theme.*
import com.skydoves.cloudy.cloudy
import kotlinx.coroutines.coroutineScope
import kotlin.math.abs

@Composable
@Preview
private fun Preview() {
    UIKitBottomSheet(
        modifier = Modifier
            .fillMaxSize(),
        state = UIKitBottomSheetState(
            true, {}
        ),
        leftButton = FluentIcons.Dismiss,
        rightButton = FluentIcons.Checkmark,
        title = "Sheet"
    ) {
        Spacer(Modifier.height(500.dp))
    }
}

class UIKitBottomSheetState(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit = {}
) {
    val offset = mutableStateOf<Dp?>(null)
    val size = mutableStateOf<IntSize?>(null)
    val expanded = mutableStateOf(expanded)
    val onExpandedChange = mutableStateOf<(Boolean) -> Unit>({
        this.expanded.value = it
        onExpandedChange(it)
    })
}

@Composable
fun Modifier.uikitBottomSheetCollaborativeAnimation(
    state: UIKitBottomSheetState,
    blurEffectEnabled: Boolean = true,
    onClick: () -> Unit,
): Modifier {
    val height = ((state.size.value ?: return this).height / LocalDensity.current.density).dp
    val offset = state.offset.value ?: return this
    val enabledCurrent by rememberUpdatedState(offset < height)

    return this
        .cloudy(
            enabled = blurEffectEnabled,
            radius = ((height - offset) / height * (10 * LocalDensity.current.density)).toInt().coerceAtLeast(0),
        )
        .then(if (enabledCurrent) {
            this.pointerInput(Unit) {
                coroutineScope {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent(PointerEventPass.Initial)
                            if (event.type == PointerEventType.Press) {
                                onClick()
                            }
                            event.changes.forEach { it.consume() }
                        }
                    }
                }
            }
        } else this)
        .drawWithContent {
            drawContent()
            drawRect(
                color = Color.Black.copy(
                    alpha = ((height - offset) / height * 0.3f).coerceIn(0f..1f)
                ),
                size = size
            )
        }
        .graphicsLayer(
            scaleX = (1f - ((height - offset) / height * 0.1f)).coerceIn(0f..1f),
            scaleY = 1f - ((height - offset) / height * 0.1f).coerceIn(0f..1f),
        )
}

@Composable
fun UIKitBottomSheet(
    modifier: Modifier = Modifier,
    state: UIKitBottomSheetState,
    background: Color = getUIKitColors().contentFillColorPrimaryBrush,
    cornerRadius: Dp = getUIKitShapes().largeRounded,
    maxWidth: Dp = (-1).dp,
    maxHeight: Dp = 640.dp,
    minHeight: Dp = 512.dp,
    leftButton: ImageVector? = null,
    rightButton: ImageVector? = null,
    leftButtonColors: UIKitButtonColors = UIKitButtonColors.default(
        background = getUIKitColors().contentFillColorSecondaryBrush,
        content = getUIKitColors().textFillColorSecondaryBrush
    ),
    rightButtonColors: UIKitButtonColors = UIKitButtonColors.default(
        background = getUIKitColors().contentFillColorSecondaryBrush,
        content = getUIKitColors().textFillColorSecondaryBrush
    ),
    leftButtonEnabled: Boolean = true,
    rightButtonEnabled: Boolean = true,
    onLeftButtonClick: () -> Unit = {},
    onRightButtonClick: () -> Unit = {},
    stripColor: Color = getUIKitColors().contentFillColorTertiaryBrush,
    stripVisible: Boolean = true,
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    BoxWithConstraints {
        val density = LocalDensity.current
        val densityDpi = density.density
        val uiKitAnimate = getUIKitAnimate()
        val isRender = remember(content) { mutableStateOf(true) }
        val isOffsetChangeWithAnimate = remember { mutableStateOf(false) }
        val containerSize = remember { mutableStateOf(IntSize.Zero) }
        val containerOffset = remember(content) { mutableStateOf(if (state.expanded.value) 0.dp else this@BoxWithConstraints.maxHeight) }
        val containerOffsetAnimated = remember {
            Animatable(
                initialValue = containerOffset.value,
                typeConverter = Dp.VectorConverter
            )
        }

        LaunchedEffect(containerSize.value) {
            state.size.value = containerSize.value
        }

        LaunchedEffect(state.expanded.value, containerSize.value.height) {
            if (state.expanded.value) {
                isOffsetChangeWithAnimate.value = true
                containerOffset.value = 0.dp
            } else {
                isOffsetChangeWithAnimate.value = true
                containerOffset.value = (containerSize.value.height / densityDpi).dp
            }
        }

        LaunchedEffect(containerOffsetAnimated.value) {
            state.offset.value = containerOffsetAnimated.value
            isRender.value = containerOffsetAnimated.value < (containerSize.value.height / densityDpi).dp
        }

        LaunchedEffect(containerOffset.value) {
            if (isOffsetChangeWithAnimate.value) {
                containerOffsetAnimated.animateTo(
                    targetValue = containerOffset.value,
                    animationSpec = tween(
                        if (abs(containerOffset.value.value - containerOffsetAnimated.value.value) >= containerSize.value.height / densityDpi) {
                            uiKitAnimate.motionMediumDurationMillis
                        } else uiKitAnimate.motionFastDurationMillis,
                        easing = if (state.expanded.value || containerOffsetAnimated.value == 0.dp) FastOutSlowInEasing else LinearOutSlowInEasing
                    )
                )
                isOffsetChangeWithAnimate.value = false
            } else {
                containerOffsetAnimated.snapTo(containerOffset.value)
            }
        }

        if (isRender.value) {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier
                        .offset(
                            y = containerOffsetAnimated.value
                        )
                        .clip(
                            RoundedCornerShape(
                                topStart = cornerRadius,
                                topEnd = cornerRadius
                            )
                        )
                        .heightIn(max = maxHeight, min = minHeight)
                        .then(
                            if (maxWidth == (-1).dp) {
                                Modifier.fillMaxWidth()
                            } else {
                                Modifier.width(minOf(maxWidth, this@BoxWithConstraints.maxWidth))
                            }
                        )
                        .background(background)
                        .onSizeChanged {
                            if (it.height != 0)
                                containerSize.value = it
                        }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = cornerRadius)
                            .uikitSwipeable(
                                onDrag = {
                                    val newOffset = (containerOffset.value + (it.y / densityDpi).dp).coerceAtLeast(0.dp)
                                    isOffsetChangeWithAnimate.value = false
                                    containerOffset.value = newOffset
                                },
                                onDragEnd = {
                                    if (containerOffset.value > (containerSize.value.height / densityDpi).dp / 2) {
                                        state.onExpandedChange.value(false)
                                    } else {
                                        isOffsetChangeWithAnimate.value = true
                                        containerOffset.value = 0.dp
                                    }
                                },
                                onDragCancel = {
                                    isOffsetChangeWithAnimate.value = true
                                    containerOffset.value = 0.dp
                                },
                                onSwipeDown = {
                                    isOffsetChangeWithAnimate.value = true
                                    state.onExpandedChange.value(false)
                                }
                            ),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(getUIKitLayout().basicSpacing),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (stripVisible) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(getUIKitShapes().circular))
                                        .height(4.dp)
                                        .fillMaxWidth(0.3f)
                                        .background(stripColor)
                                )
                            }

                            if (title != null) {
                                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                                Text(
                                    text = title,
                                    style = getUIKitTypography().body,
                                    color = getUIKitColors().textFillColorSecondaryBrush
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            if (leftButton != null) {
                                UIKitButton(
                                    modifier = Modifier
                                        .padding(getUIKitLayout().mediumSpacing)
                                        .size((cornerRadius - getUIKitLayout().mediumSpacing) * 2),
                                    icon = leftButton,
                                    colors = leftButtonColors,
                                    enabled = leftButtonEnabled,
                                    onClick = onLeftButtonClick,
                                )
                            }

                            if (rightButton != null) {
                                UIKitButton(
                                    modifier = Modifier
                                        .padding(getUIKitLayout().mediumSpacing)
                                        .size((cornerRadius - getUIKitLayout().mediumSpacing) * 2),
                                    icon = rightButton,
                                    colors = rightButtonColors,
                                    enabled = rightButtonEnabled,
                                    onClick = onRightButtonClick,
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        content = content
                    )
                }
            }
        }
    }
}