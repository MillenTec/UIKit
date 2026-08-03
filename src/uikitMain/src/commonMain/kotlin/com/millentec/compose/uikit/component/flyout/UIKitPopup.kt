package com.millentec.compose.uikit.component.flyout

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
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
            id.value = flyoutManager.add(object : UIKitFlyoutHost() {
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