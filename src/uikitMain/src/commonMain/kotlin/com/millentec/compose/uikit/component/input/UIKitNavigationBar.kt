package com.millentec.compose.uikit.component.input

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.coerceAtMost
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.layout.UIKitAdaptiveCornerContainer
import com.millentec.compose.uikit.component.layout.UIKitAdaptiveCornerContainerState
import com.millentec.compose.uikit.component.layout.rememberUIKitAdaptiveCornerContainerState
import com.millentec.compose.uikit.foundation.graphics.AcrylicMaterialState
import com.millentec.compose.uikit.foundation.layout.UIKitAlignment
import com.millentec.compose.uikit.foundation.layout.UIKitNavigationBarScope
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Accessibility
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Alert
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Settings
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Text
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitShapes
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.sqrt

@Preview
@Composable
private fun Preview(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        UIKitNavigationBar(
            checkedIndex = 1,
            onChecked = { },
        ) {
            TextWithIcon("Text", FluentIcons.Text)
            TextWithIcon("Accessibility", FluentIcons.Accessibility)
            TextWithIcon("Settings", FluentIcons.Settings)
            TextWithIcon("Alert", FluentIcons.Alert)
        }
    }
}

@Composable
fun UIKitNavigationBar(
    modifier: Modifier = Modifier,
    minHeight: Dp = 56.dp,
    minMargin: Dp = getUIKitLayout().mediumSpacing,
    checkedIndex: Int,
    onChecked: (Int) -> Unit,
    position: UIKitAlignment = UIKitAlignment.BottomCenter,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    indicatorBackground: Color = getUIKitColors().textFillColorPrimaryBrush.copy(0.3f),
    acrylicEffectEnabled: Boolean = true,
    acrylicState: AcrylicMaterialState? = null,
    shadowEnable: Boolean = true,
    maxWidth: Dp = (-1).dp,
    content: @Composable UIKitNavigationBarScope.() -> Unit,
) {
    val state: UIKitAdaptiveCornerContainerState = rememberUIKitAdaptiveCornerContainerState(
        expectHeight = minHeight,
        expectWidth = minHeight,
        minMargin = minMargin,
        fallbackCornerRadius = getUIKitShapes().circular,
        position = position,
        fillHeight = false,
        fillWidth = true
    )

    UIKitNavigationBar(
        modifier = modifier,
        checkedIndex = checkedIndex,
        onChecked = onChecked,
        background = background,
        indicatorBackground = indicatorBackground,
        state = state,
        acrylicEffectEnabled = acrylicEffectEnabled,
        acrylicState = acrylicState,
        shadowEnable = shadowEnable,
        maxWidth = maxWidth,
        content = content
    )
}

@Composable
fun UIKitNavigationBar(
    modifier: Modifier = Modifier,
    checkedIndex: Int,
    onChecked: (Int) -> Unit,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    indicatorBackground: Color = getUIKitColors().textFillColorPrimaryBrush.copy(0.3f),
    state: UIKitAdaptiveCornerContainerState,
    acrylicEffectEnabled: Boolean = true,
    acrylicState: AcrylicMaterialState? = null,
    shadowEnable: Boolean = true,
    maxWidth: Dp = (-1).dp,
    content: @Composable UIKitNavigationBarScope.() -> Unit
) {
    val scope = UIKitNavigationBarScope()
    scope.content()

    val items by rememberUpdatedState(scope.items)

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .then(
                    if (maxWidth == (-1).dp)
                        Modifier.fillMaxWidth()
                    else Modifier.width(maxWidth)
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            UIKitAdaptiveCornerContainer(
                state = state,
                background = background,
                acrylicEffectEnabled = acrylicEffectEnabled,
                acrylicState = acrylicState,
                shadowEnable = shadowEnable
            ) {
                BoxWithConstraints {
                    val itemWidth = (this.maxWidth - getUIKitLayout().smallSpacing * 2) / items.size
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

                    val uiKitAnimate = getUIKitAnimate()
                    LaunchedEffect(checkedIndex) {
                        if (isDragging.value) {
                            offsetAnimated.snapTo(currentOffset)
                            return@LaunchedEffect
                        }
                        offsetAnimated.animateTo(
                            currentOffset,
                            animationSpec = spring(
                                dampingRatio = uiKitAnimate.standardSpringDampingRatio,
                                stiffness = uiKitAnimate.standardSpringStiffness
                            )
                        )
                    }

                    LaunchedEffect(draggingOffset.value) {
                        if (draggingOffset.value == 0.dp && !isDragging.value) {
                            offsetAnimated.animateTo(
                                currentOffset,
                                animationSpec = spring(
                                    dampingRatio = uiKitAnimate.standardSpringDampingRatio,
                                    stiffness = uiKitAnimate.standardSpringStiffness
                                )
                            )
                            return@LaunchedEffect
                        }
                        offsetAnimated.snapTo(currentOffset)
                    }

                    LaunchedEffect(this.maxWidth) {
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
                            .clip(RoundedCornerShape(state.cornerRadius - getUIKitLayout().smallSpacing))
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
                                            val scaleDiff =
                                                (1f - maxOverDragScale) * sqrt(abs(offset.value) / maxOverDragOffset.value)
                                            val resultScale = 1f - scaleDiff
                                            targetIndicatorScale.value = resultScale
                                        } else if (currentCheckedIndex == itemCount - 1 && newOffset > 0.dp) {
                                            overDragOffset.value = currentOverDragOffset.value + newOffset
                                            val offset = overDragOffset.value.coerceAtMost(maxOverDragOffset)
                                            val scaleDiff =
                                                (1f - maxOverDragScale) * sqrt(abs(offset.value) / maxOverDragOffset.value)
                                            val resultScale = 1f - scaleDiff
                                            targetIndicatorScale.value = resultScale
                                        } else {
                                            if (currentOverDragOffset.value != 0.dp) {
                                                // 这两者本身不可能出现(除非 overDrag 计算有 Bug), 但仍需防御性编程
                                                if (newOffset < 0.dp && currentOverDragOffset.value < 0.dp) overDragOffset.value =
                                                    0.dp
                                                else if (newOffset > 0.dp && currentOverDragOffset.value > 0.dp) overDragOffset.value =
                                                    0.dp
                                                else {
                                                    overDragOffset.value = currentOverDragOffset.value + newOffset
                                                    val offset = if (overDragOffset.value > 0.dp)
                                                        overDragOffset.value.coerceAtMost(maxOverDragOffset)
                                                    else
                                                        overDragOffset.value.coerceAtLeast(-maxOverDragOffset)
                                                    val scaleDiff =
                                                        (1f - maxOverDragScale) * sqrt(abs(offset.value) / maxOverDragOffset.value)
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
                                            indicatorScaleAnimated.animateTo(
                                                1f, animationSpec = spring(
                                                    dampingRatio = uiKitAnimate.standardSpringDampingRatio,
                                                    stiffness = uiKitAnimate.standardSpringStiffness
                                                )
                                            )
                                        }
                                    },
                                    onDragCancel = {
                                        draggingOffset.value = 0.dp
                                        overDragOffset.value = 0.dp
                                        isDragging.value = false
                                        scope.launch {
                                            indicatorScaleAnimated.animateTo(
                                                1f, animationSpec = spring(
                                                    dampingRatio = uiKitAnimate.standardSpringDampingRatio,
                                                    stiffness = uiKitAnimate.standardSpringStiffness
                                                )
                                            )
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
                                animationSpec = tween(
                                    getUIKitAnimate().transformRegularDurationMillis,
                                    easing = FastOutSlowInEasing
                                )
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .background(Color.Transparent)
                                    .then(
                                        if (checked) Modifier else
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
                                item.Content(checked)
                            }
                        }
                    }
                }
            }
        }
    }
}