package com.millentec.compose.uikit.component.flyout

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.visible
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
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
        // 对于斜向 swipeDirections 的使用勾股数来量化, 对于二维方向依然可以正常返回为 1f
        return sqrt(offset.x.pow(2) + offset.y.pow(2))
    }

    val densityDpi by rememberUpdatedState(LocalDensity.current.density)
    val uikitTheme by rememberUpdatedState(getUIKitTheme())
    val layoutDirection by rememberUpdatedState(LocalLayoutDirection.current)

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

    LaunchedEffect(visible) {
        if (visible) {
            offsetChangeWithAnimate.value = true
            contentOffsetRatio.value = Offset(1f, 1f)
        }
    }

    LaunchedEffect(contentOffsetRatio.value) {
        if (offsetChangeWithAnimate.value) {
            contentOffsetRatioAnimated.animateTo(
                targetValue = contentOffsetRatio.value,
                animationSpec = tween(
                    if (abs(calculateHypotenuseLength(contentOffsetRatio.value)
                                - calculateHypotenuseLength(contentOffsetRatioAnimated.value))
                        // 单方向的偏移比例最大值为 1f, 那么斜方向上最大值实际就是 √2
                        >= sqrt(2f) * 0.5f) {
                        uikitTheme.animate.motionMediumDurationMillis
                    } else uikitTheme.animate.motionRegularDurationMillis
                )
            )
            offsetChangeWithAnimate.value = false
        } else {
            contentOffsetRatioAnimated.snapTo(contentOffsetRatio.value)
        }
    }

    LaunchedEffect(contentOffsetRatioAnimated.value) {
        state.progress.value = calculateHypotenuseLength(contentOffsetRatioAnimated.value) / sqrt(2f)
    }

    UIKitPopup(
        enabled = state.progress.value > 0f,
        dismissOnClickOutside = state.progress.value > 0f,
        onDismissRequest = onDismissRequest,
        alignment = alignment,
        clipToBounds = true,
        offset = { root, content ->
            contentSize.value = content
            DpOffset(0.dp, 0.dp)
        }
    ) {
        Box(
            Modifier
                .visible(contentSize.value != IntSize.Zero)
                .drawWithContent {
                    translate(
                        left = (size.width / densityDpi).dp.toPx() * swipeDirection.horizontalBias,
                        top = (size.height / densityDpi).dp.toPx() * swipeDirection.verticalBias
                    ) {
                        translate(
                            left = -(contentOffsetRatioAnimated.value.x * size.width) * swipeDirection.horizontalBias,
                            top = -(contentOffsetRatioAnimated.value.y * size.height) * swipeDirection.verticalBias
                        ) {
                            this@drawWithContent.drawContent()
                        }
                    }
                }
        ) {
            Box(modifier) {
                content(
                    Modifier
                        .uikitSwipeable(
                            onDrag = {
                                val offsetWithBias = Offset(
                                    x = if (it.x * swipeDirection.horizontalBias > 0f) it.x * swipeDirection.horizontalBias else 0f,
                                    y = if (it.y * swipeDirection.verticalBias > 0f) it.y * swipeDirection.verticalBias else 0f
                                )

                                val offsetRatio = Offset(
                                    x = offsetWithBias.x / contentSize.value.width,
                                    y = offsetWithBias.y / contentSize.value.height
                                )

                                contentOffsetRatio.value -= offsetRatio
                            },
                            onDragEnd = {
                                if (calculateHypotenuseLength(contentOffsetRatio.value) <= sqrt(2f) * 0.5f) {
                                    onDismissRequest?.invoke()
                                } else {
                                    // 归位
                                    offsetChangeWithAnimate.value = true
                                    contentOffsetRatio.value = Offset(1f, 1f)
                                }
                            },
                            onDragCancel = {
                                offsetChangeWithAnimate.value = true
                                contentOffsetRatio.value = Offset(1f, 1f)
                            },

                            /*
                             * verticalBias = -1f: *Top
                             * verticalBias = 1f: *Bottom
                             * horizontalBias = -1f: *Start
                             * horizontalBias = 1f: *End
                             */
                            onSwipeUp = {
                                if (swipeDirection.verticalBias == -1f)
                                    onDismissRequest?.invoke()
                            },
                            onSwipeDown = {
                                if (swipeDirection.verticalBias == 1f)
                                    onDismissRequest?.invoke()
                            },
                            onSwipeLeft = {
                                if (swipeDirection.horizontalBias == -1f && layoutDirection == LayoutDirection.Ltr ||
                                    swipeDirection.horizontalBias == 1f && layoutDirection == LayoutDirection.Rtl
                                )
                                    onDismissRequest?.invoke()
                            },
                            onSwipeRight = {
                                if (swipeDirection.horizontalBias == 1f && layoutDirection == LayoutDirection.Ltr ||
                                    swipeDirection.horizontalBias == -1f && layoutDirection == LayoutDirection.Rtl
                                )
                                    onDismissRequest?.invoke()
                            }
                        )
                )
            }
        }
    }
}