package com.millentec.compose.uikit.component.flyout

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.materials.acrylicMaterial
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
import com.millentec.compose.uikit.theme.UIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout

@Composable
@Preview
private fun Preview() {
    UIKitFlyouter {
        val acrylicMaterialsState = rememberAcrylicMaterialsState()

        Box(
            Modifier
                .fillMaxSize()
                .background(UIKitColors.Blue)
                .acrylicMaterialSource(acrylicMaterialsState)
        ) {
            UIKitPopup(
                alignment = Alignment.TopStart,
                visible = true
            ) {
                Box(
                    modifier = Modifier
                        .acrylicMaterial(acrylicMaterialsState)
                        .padding(getUIKitLayout().mediumSpacing)
                ) {
                    Text("Hello World!")
                }
            }
        }
    }
}

/**
 * 浮层基础组件, 用于创建一个浮层, 需上层被 UIKitFlyouter 包裹, 浮层会生成于它的子级, 于内容同级
 * @param enabled 浮层是否启用, 为 false 则从 UIKitFlyouter 中移除浮层
 * @param alignment 浮层相对于屏幕 (UIKitFlyouter) 的对齐位置
 * @param offset 浮层偏移, 在对齐的基础上的偏移
 * @param onDismissRequest 当浮层被尝试关闭时触发
 * @param dismissOnClickOutside 当点击空白区域时是否触发 onDismissRequest
 * @param content 浮层内容
 */
@Composable
fun UIKitPopup(
    enabled: Boolean = true,
    alignment: Alignment = Alignment.Center,
    offset: (IntSize, IntSize) -> DpOffset = { rootSize, contentSize -> DpOffset.Zero },
    onDismissRequest: (() -> Unit)? = null,
    dismissOnClickOutside: Boolean = true,
    content: @Composable () -> Unit
) {
    val id = remember { mutableStateOf(0) }
    val flyoutManager = LocalFlyouts.current

    val alignmentCurrent by rememberUpdatedState(alignment)
    val offsetCurrent by rememberUpdatedState(offset)
    val onDismissRequestCurrent by rememberUpdatedState(onDismissRequest)
    val dismissOnClickOutsideCurrent by rememberUpdatedState(dismissOnClickOutside)
    val contentCurrent by rememberUpdatedState(content)

    val rootSize = remember { mutableStateOf(IntSize.Zero) }
    val contentSize = remember { mutableStateOf(IntSize.Zero) }

    LaunchedEffect(enabled) {
        if (enabled) {
            id.value = flyoutManager.add(object : UIKitFlyoutSlot() {
                @Composable
                override fun Content() {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .onSizeChanged {
                                rootSize.value = it
                            }
                            .then(if (dismissOnClickOutsideCurrent) {
                                Modifier.pointerInput(Unit) {
                                    awaitEachGesture {
                                        val event = awaitFirstDown(pass = PointerEventPass.Main)
                                        event.consume()
                                        if (dismissOnClickOutsideCurrent)
                                            onDismissRequestCurrent?.invoke()
                                    }
                                }
                            } else Modifier),
                        contentAlignment = alignmentCurrent
                    ) {
                        Box(
                            modifier = Modifier
                                .offset(
                                    x = offsetCurrent(rootSize.value, contentSize.value).x,
                                    y = offsetCurrent(rootSize.value, contentSize.value).y
                                )
                                .onGloballyPositioned {
                                    contentSize.value = it.size
                                }
                                .pointerInput(Unit) {
                                    awaitEachGesture {
                                        awaitFirstDown().consume()
                                    }
                                }
                        ) {
                            contentCurrent()
                        }
                    }
                }
            })
        } else {
            flyoutManager.remove(id.value)
        }
    }

    DisposableEffect(enabled) {
        onDispose {
            flyoutManager.remove(id.value)
        }
    }
}

@Composable
fun UIKitPopup(
    modifier: Modifier = Modifier,
    visible: Boolean,
    enter: EnterTransition = fadeIn(),
    exit: ExitTransition = fadeOut(),
    animateAlignment: Alignment = Alignment.Center,
    alignment: Alignment = Alignment.Center,
    offset: (IntSize, IntSize) -> DpOffset = { rootSize, contentSize -> DpOffset.Zero },
    onDismissRequest: (() -> Unit)? = null,
    dismissOnClickOutside: Boolean = true,
    content: @Composable () -> Unit
) {
    val id = remember { mutableStateOf(0) }
    val added = remember { mutableStateOf(false) }
    val flyoutManager = LocalFlyouts.current
    /*
     * 先前无进入动画的 Bug 是由于 Popup 被创建时 Transition 才被创建, 此时的 state 被认为为初始值故不播放动画
     * 现在将 TranslationState 放在外部储存, 确保不被重复创建
     */
    val transitionState = remember { MutableTransitionState(initialState = false) }

    // 内容 Composition 位于 Lambda 内, 仅在 enabled 改变时才整体更新, 故其无法接收形参, 需封装为 State
    val alignmentCurrent by rememberUpdatedState(alignment)
    val offsetCurrent by rememberUpdatedState(offset)
    val onDismissRequestCurrent by rememberUpdatedState(onDismissRequest)
    val dismissOnClickOutsideCurrent by rememberUpdatedState(dismissOnClickOutside)
    val contentCurrent by rememberUpdatedState(content)
    val visibleCurrent by rememberUpdatedState(visible)
    val enterCurrent by rememberUpdatedState(enter)
    val exitCurrent by rememberUpdatedState(exit)
    val animateAlignmentCurrent by rememberUpdatedState(animateAlignment)
    val modifierCurrent by rememberUpdatedState(modifier)

    val rootSize = remember { mutableStateOf(IntSize.Zero) }
    val contentSize = remember { mutableStateOf(IntSize.Zero) }

    LaunchedEffect(visibleCurrent) {
        // 需防止重复添加
        if (visibleCurrent && !added.value) {
            added.value = true
            id.value = flyoutManager.add(object : UIKitFlyoutSlot() {
                @Composable
                override fun Content() {
                    transitionState.targetState = visibleCurrent

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .onSizeChanged { rootSize.value = it }
                            .then(if (dismissOnClickOutsideCurrent) {
                                Modifier.pointerInput(Unit) {
                                    awaitEachGesture {
                                        val event = awaitFirstDown(pass = PointerEventPass.Main)
                                        event.consume()
                                        if (dismissOnClickOutsideCurrent)
                                            onDismissRequestCurrent?.invoke()
                                    }
                                }
                            } else Modifier),
                        contentAlignment = alignmentCurrent
                    ) {
                        /*
                         * 对于 expandIn/shrinkOut 等会改变整体元素尺寸的动画, 由于尺寸同时改变, 故动画的视觉起始/结束点是 Popup 的固定定位点方向 (即 alignment)
                         * 此处添加一个尺寸固定的 Box, 并设置其内容对齐与动画的期望位置一致, 以使 AnimatedVisibility 定位到正确的位置
                         */
                        Box(
                            modifier = Modifier
                                .then(if (contentSize.value != IntSize.Zero) {
                                    Modifier.size(
                                        width = (contentSize.value.width / LocalDensity.current.density).dp,
                                        height = (contentSize.value.height / LocalDensity.current.density).dp
                                    )
                                } else Modifier)
                                .offset(
                                    x = offsetCurrent(rootSize.value, contentSize.value).x,
                                    y = offsetCurrent(rootSize.value, contentSize.value).y
                                ),
                            contentAlignment = animateAlignmentCurrent
                        ) {
                            AnimatedVisibility(
                                visibleState = transitionState,
                                modifier = modifierCurrent,
                                enter = enterCurrent,
                                exit = exitCurrent,
                            ) {
                                Box(
                                    modifier = Modifier
                                        .pointerInput(Unit) { awaitEachGesture { awaitFirstDown().consume() } }
                                        .onGloballyPositioned { contentSize.value = it.size }
                                ) {
                                    contentCurrent()
                                }
                            }
                        }
                    }
                }
            })
        }
    }

    // 在 Transaction 中 currentState 在动画后变化
    LaunchedEffect(transitionState.currentState) {
        if (!visibleCurrent && !transitionState.currentState && added.value) {
            flyoutManager.remove(id.value)
            id.value = 0
            added.value = false
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            if (added.value) flyoutManager.remove(id.value)
        }
    }
}