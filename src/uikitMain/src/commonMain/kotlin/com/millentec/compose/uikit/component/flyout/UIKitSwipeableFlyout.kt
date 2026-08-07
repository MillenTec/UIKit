package com.millentec.compose.uikit.component.flyout

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.helper.uikitSwipeable
import com.millentec.compose.uikit.foundation.layout.UIKitAlignment
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitTheme
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
@Preview
private fun Preview() {
    UIKitFlyouter {
        UIKitSwipeableFlyout(
            state = UIKitSwipeableFlyoutState(),
            visible = true
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(getUIKitColors().contentFillColorSecondaryBrush)
            )
        }
    }
}

class UIKitSwipeableFlyoutState {
    internal val progress = mutableStateOf(0f)
    internal val size = mutableStateOf<IntSize?>(null)
}

@Composable
fun UIKitSwipeableFlyout(
    modifier: Modifier = Modifier,
    state: UIKitSwipeableFlyoutState,
    visible: Boolean,
    onDismissRequest: (() -> Unit)? = null,
    alignment: Alignment = Alignment.BottomCenter,
    swipeDirection: UIKitAlignment = UIKitAlignment.BottomCenter,
    content: @Composable (Modifier) -> Unit
) {
    fun calculateHypotenuseLength(offset: Offset): Float {
        // 对于斜向 swipeDirections 的使用勾股数来量化, 对于二维方向 (其中一项为 0) 依然可以正常返回为 1f
        return sqrt(offset.x.pow(2) + offset.y.pow(2))
    }

    val uikitTheme by rememberUpdatedState(getUIKitTheme())
    val layoutDirection by rememberUpdatedState(LocalLayoutDirection.current)
    val stateCurrent by rememberUpdatedState(state)
    val visibleCurrent by rememberUpdatedState(visible)
    val onDismissRequestCurrent by rememberUpdatedState(onDismissRequest)
    val swipeDirectionCurrent by rememberUpdatedState(swipeDirection)

    val contentSize = remember { mutableStateOf(IntSize.Zero) }
    val offsetChangeWithAnimate = remember { mutableStateOf(false) }

    /*
     * 为 1f 时表示在此方向上最大偏移
     * 一般需要知道内容大小才能计算出正确的偏移, 这里选择存储一个比值, 在内部实时获取计算
     * DrawScope 中可以得到真实的 Size 而无需等待一次重组, 故把偏移过程放在了 drawWithContent 中
     */
    val contentOffsetRatio = remember { mutableStateOf(Offset.Zero) }
    val contentOffsetRatioAnimated = remember { Animatable(
        initialValue = contentOffsetRatio.value,
        typeConverter = Offset.VectorConverter
    ) }
    val animateEasing = remember { mutableStateOf(FastOutSlowInEasing) }

    LaunchedEffect(visible) {
        if (visible) {
            animateEasing.value = FastOutSlowInEasing
            offsetChangeWithAnimate.value = true
            contentOffsetRatio.value = Offset(abs(swipeDirection.horizontalBias), abs(swipeDirection.verticalBias))
        } else {
            if (contentOffsetRatio.value != Offset(abs(swipeDirection.horizontalBias), abs(swipeDirection.verticalBias)))
                animateEasing.value = LinearOutSlowInEasing
            offsetChangeWithAnimate.value = true
            contentOffsetRatio.value = Offset.Zero
        }
    }

    LaunchedEffect(contentOffsetRatio.value) {
        if (offsetChangeWithAnimate.value) {
            contentOffsetRatioAnimated.animateTo(
                targetValue = contentOffsetRatio.value,
                animationSpec = tween(
                    if (abs(calculateHypotenuseLength(contentOffsetRatio.value)
                                - calculateHypotenuseLength(contentOffsetRatioAnimated.value))
                        >= calculateHypotenuseLength(Offset(
                            x = swipeDirectionCurrent.horizontalBias,
                            y = swipeDirectionCurrent.verticalBias
                        )) * 0.5f) {
                        uikitTheme.animate.motionMediumDurationMillis
                    } else uikitTheme.animate.motionRegularDurationMillis,
                    easing = animateEasing.value
                )
            )
            offsetChangeWithAnimate.value = false
        } else {
            contentOffsetRatioAnimated.snapTo(contentOffsetRatio.value)
        }
    }

    LaunchedEffect(contentOffsetRatioAnimated.value) {
        state.progress.value = calculateHypotenuseLength(contentOffsetRatioAnimated.value) / calculateHypotenuseLength(Offset(
            x = swipeDirectionCurrent.horizontalBias,
            y = swipeDirectionCurrent.verticalBias
        ))
    }

    UIKitPopup(
        enabled = stateCurrent.progress.value > 0f,
        dismissOnClickOutside = visibleCurrent,
        onDismissRequest = onDismissRequestCurrent,
        alignment = alignment,
        clipToBounds = true,
        offset = { root, content ->
            contentSize.value = content
            DpOffset(0.dp, 0.dp)
        }
    ) {
        Box(
            Modifier
                .drawWithContent {
                    translate(
                        left = size.width * swipeDirectionCurrent.horizontalBias,
                        top = size.height * swipeDirectionCurrent.verticalBias
                    ) {
                        translate(
                            left = -(contentOffsetRatioAnimated.value.x * size.width) * swipeDirectionCurrent.horizontalBias,
                            top = -(contentOffsetRatioAnimated.value.y * size.height) * swipeDirectionCurrent.verticalBias
                        ) {
                            this@drawWithContent.drawContent()
                        }
                    }
                },
        ) {
            Box(modifier) {
                content(
                    Modifier
                        .uikitSwipeable(
                            onDrag = {
                                val offsetWithBias = Offset(
                                    x = it.x * swipeDirectionCurrent.horizontalBias,
                                    y = it.y * swipeDirectionCurrent.verticalBias
                                )

                                val offsetRatio = Offset(
                                    // 若尺寸为 0(可能是未加载完成) 则不做出改变
                                    x = if (contentSize.value.width == 0) 0f else offsetWithBias.x / contentSize.value.width,
                                    y = if (contentSize.value.height == 0) 0f else offsetWithBias.y / contentSize.value.height
                                )

                                contentOffsetRatio.value = Offset(
                                    x = (contentOffsetRatio.value.x - offsetRatio.x).coerceIn(0f..1f),
                                    y = (contentOffsetRatio.value.y - offsetRatio.y).coerceIn(0f..1f),
                                )
                            },
                            onDragEnd = {
                                if (calculateHypotenuseLength(contentOffsetRatio.value) <= calculateHypotenuseLength(Offset(
                                        x = swipeDirectionCurrent.horizontalBias,
                                        y = swipeDirectionCurrent.verticalBias)) * 0.5f) {
                                    onDismissRequestCurrent?.invoke()
                                } else {
                                    // 归位
                                    animateEasing.value = FastOutSlowInEasing
                                    offsetChangeWithAnimate.value = true
                                    contentOffsetRatio.value = Offset(abs(swipeDirectionCurrent.horizontalBias), abs(swipeDirectionCurrent.verticalBias))
                                }
                            },
                            onDragCancel = {
                                offsetChangeWithAnimate.value = true
                                contentOffsetRatio.value = Offset(abs(swipeDirectionCurrent.horizontalBias), abs(swipeDirectionCurrent.verticalBias))
                            },

                            /*
                             * verticalBias = -1f: *Top
                             * verticalBias = 1f: *Bottom
                             * horizontalBias = -1f: *Start
                             * horizontalBias = 1f: *End
                             */
                            onSwipeUp = {
                                if (swipeDirection.verticalBias == -1f)
                                    onDismissRequestCurrent?.invoke()
                            },
                            onSwipeDown = {
                                if (swipeDirection.verticalBias == 1f)
                                    onDismissRequestCurrent?.invoke()
                            },
                            onSwipeLeft = {
                                if (swipeDirection.horizontalBias == -1f && layoutDirection == LayoutDirection.Ltr ||
                                    swipeDirection.horizontalBias == 1f && layoutDirection == LayoutDirection.Rtl
                                )
                                    onDismissRequestCurrent?.invoke()
                            },
                            onSwipeRight = {
                                if (swipeDirectionCurrent.horizontalBias == 1f && layoutDirection == LayoutDirection.Ltr ||
                                    swipeDirectionCurrent.horizontalBias == -1f && layoutDirection == LayoutDirection.Rtl
                                )
                                    onDismissRequestCurrent?.invoke()
                            }
                        )
                )
            }
        }
    }
}