package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.coerceAtMost
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.layout.ScreenSideAdaptiveContainer
import com.millentec.compose.uikit.component.layout.ScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.component.layout.rememberScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes
import com.millentec.compose.uikit.theme.getUIKitTypography
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.sqrt

@Preview
@Composable
private fun Preview(){
    UIKitNavigationDock(
        modifier = Modifier
            .fillMaxSize(),
        checkedIndex = 2,
        onChecked = { },
        independentButtonPosition = LayoutPosition.Right,
        items = listOf(
            UIKitNavigationItem(
                "Option 0"
            ),
            UIKitNavigationItem(
                "Option 1"
            ),
            UIKitNavigationItem(
                "Option 2"
            ),
            UIKitNavigationItem(
                "Option 3"
            )
        ),
        hasIndependentButton = true,
        independentButtonContent = {
            Text("Button")
        }
    )
}

data class UIKitNavigationItem(
    val title: String? = null,
    val icon: ImageVector? = null
)

@Composable
fun UIKitNavigationDock(
    modifier: Modifier = Modifier,
    minHeight: Dp = 56.dp,
    minMargin: Dp = getUIKitLayout().mediumSpacing,
    checkedIndex: Int,
    onChecked: (Int) -> Unit,
    items: List<UIKitNavigationItem>,
    hasIndependentButton: Boolean = false,
    independentButtonPosition: LayoutPosition = LayoutPosition.Right,
    independentButtonContent: @Composable BoxScope.() -> Unit = {},
    onIndependentButtonClick: () -> Unit = {},
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    indicatorBackground: Color = getUIKitColors().contentFillColorPrimaryBrush,
    contentColor: Color = getUIKitColors().textFillColorPrimaryBrush,
    contentColorChecked: Color = getUIKitColors().highlightColorBrush
) {
    val mainIslandState: ScreenSideAdaptiveContainerState = rememberScreenSideAdaptiveContainerState(
        expectHeight = minHeight,
        expectWidth = minHeight,
        minMargin = minMargin,
        fallbackCornerRadius = getUIKitShapes().circular,
        position = if (hasIndependentButton) {
            when (independentButtonPosition) {
                LayoutPosition.Right -> LayoutPosition.BottomLeft
                LayoutPosition.Left -> LayoutPosition.BottomRight
                else -> throw UnsupportedOperationException("NavigationDock: Can only keep the independent button from being on the left or right side.")
            }
        } else LayoutPosition.Bottom,
        fillHeight = false,
        fillWidth = true
    )

    val independentIslandState = rememberScreenSideAdaptiveContainerState(
        expectHeight = minHeight,
        expectWidth = minHeight,
        minMargin = minMargin,
        fallbackCornerRadius = getUIKitShapes().circular,
        position = when (independentButtonPosition) {
            LayoutPosition.Right -> LayoutPosition.BottomRight
            LayoutPosition.Left -> LayoutPosition.BottomLeft
            else -> throw UnsupportedOperationException("NavigationDock: Can only keep the independent button from being on the left or right side.")
        },
        fillWidth = false,
        fillHeight = false
    )

    UIKitNavigationDock(
        modifier = modifier,
        islandMargin = minMargin,
        checkedIndex = checkedIndex,
        onChecked = onChecked,
        items = items,
        hasIndependentButton = hasIndependentButton,
        independentButtonContent = independentButtonContent,
        independentButtonPosition = independentButtonPosition,
        onIndependentButtonClick = onIndependentButtonClick,
        background = background,
        indicatorBackground = indicatorBackground,
        contentColor = contentColor,
        contentColorChecked = contentColorChecked,
        mainIslandState = mainIslandState,
        independentIslandState = independentIslandState
    )
}

@Composable
fun UIKitNavigationDock(
    modifier: Modifier = Modifier,
    islandMargin: Dp = getUIKitLayout().mediumSpacing,
    checkedIndex: Int,
    onChecked: (Int) -> Unit,
    items: List<UIKitNavigationItem>,
    hasIndependentButton: Boolean = false,
    independentButtonContent: @Composable BoxScope.() -> Unit = {},
    independentButtonPosition: LayoutPosition = LayoutPosition.Right,
    onIndependentButtonClick: () -> Unit = {},
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    indicatorBackground: Color = getUIKitColors().contentFillColorPrimaryBrush,
    contentColor: Color = getUIKitColors().textFillColorPrimaryBrush,
    contentColorChecked: Color = getUIKitColors().highlightColorBrush,
    mainIslandState: ScreenSideAdaptiveContainerState,
    independentIslandState: ScreenSideAdaptiveContainerState,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val independentIsland = @Composable {
                if (hasIndependentButton) {
                    val pressed = remember { mutableStateOf(false) }
                    val scaleAnimated by animateFloatAsState(
                        targetValue = if (pressed.value) 0.90f else 1f,
                        animationSpec = tween(200, easing = FastOutSlowInEasing)
                    )

                    ScreenSideAdaptiveContainer(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .graphicsLayer(
                                scaleX = scaleAnimated,
                                scaleY = scaleAnimated
                            )
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = {
                                        pressed.value = true
                                        tryAwaitRelease()
                                        pressed.value = false
                                    },
                                    onTap = {
                                        onIndependentButtonClick()
                                    }
                                )
                            },
                        state = independentIslandState,
                        background = background
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(getUIKitLayout().smallSpacing)
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center,
                            content = independentButtonContent
                        )
                    }
                }
            }

            if (independentButtonPosition == LayoutPosition.Left && hasIndependentButton) {
                independentIsland()
                Spacer(Modifier.width(islandMargin))
            }

            ScreenSideAdaptiveContainer(
                modifier = Modifier
                    .weight(1f),
                state = mainIslandState,
                background = background
            ) {
                BoxWithConstraints {
                    val itemWidth = (maxWidth - getUIKitLayout().smallSpacing * 2) / items.size
                    val targetOffset = itemWidth * checkedIndex
                    val draggingOffset = remember { mutableStateOf(0.dp) }
                    val isDragging = remember { mutableStateOf(false) }
                    val currentOffset = targetOffset + draggingOffset.value
                    val densityDpi = LocalDensity.current.density
                    val targetIndicatorScale = remember { mutableStateOf(1f) }
                    val scope = rememberCoroutineScope()
                    val overDragOffset = remember { mutableStateOf(0.dp) }

                    val currentCheckedIndex by rememberUpdatedState(checkedIndex)
                    val itemCount by rememberUpdatedState(items.size)
                    val currentItemWidth by rememberUpdatedState(itemWidth)
                    val currentOverDragOffset by rememberUpdatedState(overDragOffset)

                    val offsetAnimated = remember { Animatable(currentOffset, Dp.VectorConverter) }
                    val indicatorScaleAnimated = remember { Animatable(1f, Float.VectorConverter) }

                    LaunchedEffect(targetIndicatorScale.value) {
                        indicatorScaleAnimated.snapTo(targetIndicatorScale.value)
                    }

                    LaunchedEffect(checkedIndex) {
                        if (isDragging.value) {
                            offsetAnimated.snapTo(currentOffset)
                            return@LaunchedEffect
                        }
                        offsetAnimated.animateTo(currentOffset, animationSpec = spring(dampingRatio = 0.70f, stiffness = 240f))
                    }

                    LaunchedEffect(draggingOffset.value) {
                        if (draggingOffset.value == 0.dp && !isDragging.value) {
                            offsetAnimated.animateTo(currentOffset, animationSpec = spring(dampingRatio = 0.70f))
                            return@LaunchedEffect
                        }
                        offsetAnimated.snapTo(currentOffset)
                    }

                    LaunchedEffect(maxWidth) {
                        offsetAnimated.snapTo(currentOffset)
                    }

                    Box(
                        modifier = Modifier
                            .offset(offsetAnimated.value)
                            .padding(getUIKitLayout().smallSpacing)
                            .graphicsLayer(
                                scaleX = indicatorScaleAnimated.value,
                                translationX = if (checkedIndex == itemCount - 1) ((itemWidth * (1f - indicatorScaleAnimated.value)).value * densityDpi) / 2
                                else -(((itemWidth * (1f - indicatorScaleAnimated.value)).value * densityDpi) / 2)
                            )
                            .clip(RoundedCornerShape(mainIslandState.cornerRadius - getUIKitLayout().smallSpacing))
                            .fillMaxHeight()
                            .width(itemWidth)
                            .background(indicatorBackground)
                            .pointerInput(Unit) {
                                detectDragGestures(
                                    onDragStart = {
                                        isDragging.value = true
                                    },
                                    onDrag = { change, offset ->
                                        val newOffset = draggingOffset.value + (offset.x / densityDpi).dp
                                        val maxOverDragScale = 0.8f
                                        val maxOverDragOffset = 100.dp

                                        if (currentCheckedIndex == 0 && newOffset < 0.dp) {
                                            overDragOffset.value = currentOverDragOffset.value + newOffset
                                            val offset = overDragOffset.value.coerceAtLeast(-maxOverDragOffset)
                                            val scaleDiff = (1f - maxOverDragScale) * sqrt(abs(offset.value) / maxOverDragOffset.value)
                                            val resultScale = 1f - scaleDiff
                                            targetIndicatorScale.value = resultScale
                                        } else if (currentCheckedIndex == itemCount - 1 && newOffset > 0.dp) {
                                            overDragOffset.value = currentOverDragOffset.value + newOffset
                                            val offset = overDragOffset.value.coerceAtMost(maxOverDragOffset)
                                            val scaleDiff = (1f - maxOverDragScale) * sqrt(abs(offset.value) / maxOverDragOffset.value)
                                            val resultScale = 1f - scaleDiff
                                            targetIndicatorScale.value = resultScale
                                        } else {
                                            if (currentOverDragOffset.value != 0.dp) {
                                                // 这两者本身不可能出现(除非 overDrag 计算有 Bug), 但仍需防御性编程
                                                if (newOffset < 0.dp && currentOverDragOffset.value < 0.dp) overDragOffset.value = 0.dp
                                                else if (newOffset > 0.dp && currentOverDragOffset.value > 0.dp) overDragOffset.value = 0.dp
                                                else {
                                                    overDragOffset.value = currentOverDragOffset.value + newOffset
                                                    val offset = if (overDragOffset.value > 0.dp)
                                                        overDragOffset.value.coerceAtMost(maxOverDragOffset)
                                                    else
                                                        overDragOffset.value.coerceAtLeast(-maxOverDragOffset)
                                                    val scaleDiff = (1f - maxOverDragScale) * sqrt(abs(offset.value) / maxOverDragOffset.value)
                                                    val resultScale = 1f - scaleDiff
                                                    targetIndicatorScale.value = resultScale
                                                }
                                            } else {
                                                draggingOffset.value = newOffset
                                                if (indicatorScaleAnimated.value != 1f) {
                                                    scope.launch {
                                                        indicatorScaleAnimated.snapTo(1f)
                                                    }
                                                }
                                            }
                                        }

                                        if (draggingOffset.value > currentItemWidth / 2) {
                                            if (currentCheckedIndex < itemCount - 1) {
                                                onChecked(currentCheckedIndex + 1)
                                                draggingOffset.value -= currentItemWidth
                                            } else {
                                                draggingOffset.value = currentItemWidth / 2
                                            }
                                        } else if (draggingOffset.value < -(currentItemWidth / 2)) {
                                            if (currentCheckedIndex > 0) {
                                                onChecked(currentCheckedIndex - 1)
                                                draggingOffset.value += currentItemWidth
                                            } else {
                                                draggingOffset.value = -(currentItemWidth / 2)
                                            }
                                        }
                                    },
                                    onDragEnd = {
                                        draggingOffset.value = 0.dp
                                        overDragOffset.value = 0.dp
                                        isDragging.value = false
                                        scope.launch {
                                            indicatorScaleAnimated.animateTo(1f, animationSpec = spring(dampingRatio = 0.70f, stiffness = 240f))
                                        }
                                    },
                                    onDragCancel = {
                                        draggingOffset.value = 0.dp
                                        overDragOffset.value = 0.dp
                                        isDragging.value = false
                                        scope.launch {
                                            indicatorScaleAnimated.animateTo(1f, animationSpec = spring(dampingRatio = 0.70f, stiffness = 240f))
                                        }
                                    }
                                )
                            }
                    )


                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(getUIKitLayout().smallSpacing)
                    ) {
                        items.forEachIndexed { index, item ->
                            val checked = index == checkedIndex
                            val pressed = remember { mutableStateOf(false) }
                            val scaleAnimated by animateFloatAsState(
                                targetValue = if (pressed.value) 0.9f else 1f,
                                animationSpec = tween(200, easing = FastOutSlowInEasing)
                            )
                            val contentColorAnimated by animateColorAsState(
                                targetValue = if (checked) contentColorChecked else contentColor,
                                animationSpec = tween(200, easing = LinearEasing)
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .background(Color.Transparent)
                                    .then(if (checked) Modifier else
                                        Modifier.pointerInput(Unit) {
                                            detectTapGestures(
                                                onPress = {
                                                    pressed.value = true
                                                    tryAwaitRelease()
                                                    pressed.value = false
                                                },
                                                onTap = {
                                                    onChecked(index)
                                                }
                                            )
                                        })  // 将 padding 置于 pointerInput 之后可以最大化可交互面积
                                    .padding(getUIKitLayout().smallSpacing)
                                    .graphicsLayer(
                                        scaleX = scaleAnimated,
                                        scaleY = scaleAnimated
                                    ),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                if (item.icon != null) {
                                    Icon(
                                        modifier = Modifier
                                            .weight(1f)
                                            .aspectRatio(item.icon.viewportWidth/item.icon.viewportHeight),
                                        imageVector = item.icon,
                                        contentDescription = item.title,
                                        tint = contentColorAnimated,
                                    )
                                }
                                if (item.title != null) {
                                    Text(
                                        item.title,
                                        style = getUIKitTypography().footnote,
                                        color = contentColorAnimated,
                                    )
                                }
                            }
                        }
                    }
                }
            }

            if (independentButtonPosition == LayoutPosition.Right && hasIndependentButton) {
                Spacer(Modifier.width(islandMargin))
                independentIsland()
            }
        }
    }
}