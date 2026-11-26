package com.millentec.compose.uikit.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowState
import cn.longzhengyi.windowsdecoration.BorderlessTitleBarScaffold
import cn.longzhengyi.windowsdecoration.TitleBarScope
import cn.longzhengyi.windowsdecoration.windowhelper.windowCloseButton
import cn.longzhengyi.windowsdecoration.windowhelper.windowDragArea
import cn.longzhengyi.windowsdecoration.windowhelper.windowMaximizeButton
import cn.longzhengyi.windowsdecoration.windowhelper.windowMinimizeButton
import com.millentec.compose.uikit.component.input.UIKitButton
import com.millentec.compose.uikit.component.input.UIKitButtonColors
import com.millentec.compose.uikit.component.input.UIKitButtonStyle
import com.millentec.compose.uikit.component.media.UIKitSymbolOptions
import com.millentec.compose.uikit.foundation.helper.UIKitClientAreaHelper
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.darken
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.builtin.graphic.HorizontalLine
import com.millentec.compose.uikit.symbols.builtin.systemui.Dismiss
import com.millentec.compose.uikit.symbols.builtin.systemui.Maximize
import com.millentec.compose.uikit.symbols.builtin.systemui.Windowize
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.*

@Composable
fun FrameWindowScope.UIKitTitleBar(
    windowState: WindowState,
    areaHelper: UIKitClientAreaHelper,
    content: @Composable TitleBarScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .onGloballyPositioned {
                areaHelper.titleBarOffset = Offset(0f, it.size.height.toFloat())
            }
    ) {
        BorderlessTitleBarScaffold(windowState, content)
    }
}

@Composable
fun FrameWindowScope.UIKitTitleBar(
    title: String?,
    icon: ImageBitmap? = null,
    windowState: WindowState,
    areaHelper: UIKitClientAreaHelper,
    onCloseRequest: () -> Unit,
    height: Dp = getUIKitLayout().interactiveHotspot,
    content: (@Composable RowScope.() -> Unit)? = null,
) = UIKitTitleBar(windowState, areaHelper = areaHelper) {
    Row(
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
            .windowDragArea(helper),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        /* Title Scope */
        if (title != null || icon != null) {
            Row(
                modifier = Modifier
                    .padding(getUIKitLayout().basicSpacing)
            ) {
                icon?.let {
                    Image(
                        modifier = Modifier
                            .height(getUIKitTypography().body.lineHeight.value.dp),
                        bitmap = it,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )

                    Spacer(Modifier.width(getUIKitLayout().itemSpacing))
                }

                title?.let {
                    Text(
                        text = it,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            }
        }


        /* Content Scope */
        content?.let {
            Row(modifier = Modifier.weight(1f), content = it)
        }

        if (content == null) {
            Spacer(Modifier.weight(1f))
        }

        /* Button Scope */
        Row {
            Box(Modifier.windowMinimizeButton(helper)) {
                UIKitButton(
                    modifier = Modifier
                        .size(maxOf(height, getUIKitLayout().interactiveHotspot), height),
                    symbol = UIKitSymbols.graphic.HorizontalLine,
                    contentDescription = "Minimize",
                    style = UIKitButtonStyle.Ghost.copy(
                        shape = RectangleShape
                    ),
                    onClick = ::minimize
                )
            }

            Box(Modifier.windowMaximizeButton(helper)) {
                UIKitButton(
                    modifier = Modifier
                        .size(maxOf(height, getUIKitLayout().interactiveHotspot), height),
                    symbol = if (isMaximized)
                        UIKitSymbols.systemUI.Windowize
                    else
                        UIKitSymbols.systemUI.Maximize,
                    contentDescription = if (isMaximized)
                        "Maximize"
                    else
                        "To Window",
                    style = UIKitButtonStyle.Ghost.copy(
                        shape = RectangleShape
                    ),
                    onClick = ::toggleMaximize
                )
            }

            var isCloseHover by remember { mutableStateOf(false) }
            var isClosePressed by remember { mutableStateOf(false) }
            val buttonContentColor by animateColorAsState(
                targetValue = if (isClosePressed || isCloseHover) UIKitColors.White
                else getUIKitColors().textFillColorPrimaryBrush,
                animationSpec = tween(getUIKitAnimate().transformFastDurationMillis, easing = LinearEasing)
            )
            val buttonBackground by animateColorAsState(
                targetValue = if (isClosePressed)
                    getUIKitColors().errorRedColorPrimaryBrush.darken(0.15f)
                else if (isCloseHover)
                    getUIKitColors().errorRedColorPrimaryBrush
                else getUIKitColors().errorRedColorPrimaryBrush.copy(0f),
                animationSpec = tween(
                    if (isClosePressed) getUIKitAnimate().transformFastDurationMillis
                    else getUIKitAnimate().transformRegularDurationMillis,
                    easing = LinearEasing
                )
            )

            Box(Modifier.windowCloseButton(helper)) {
                UIKitButton(
                    modifier = Modifier
                        .size(maxOf(height, getUIKitLayout().interactiveHotspot), height),
                    symbol = UIKitSymbols.systemUI.Dismiss,
                    symbolOption = UIKitSymbolOptions.default(
                        symbolStyle = UIKitSymbolStyle.Monochrome(buttonContentColor)
                    ),
                    contentDescription = "Minimize",
                    style = UIKitButtonStyle.Ghost.copy(
                        colors = UIKitButtonColors.default(
                            background = buttonBackground,
                            content = buttonContentColor
                        ),
                        animateEnabled = false,
                        shape = RectangleShape,
                        indication = null,
                        interaction = UIKitInteraction { isHover, isPress, _ ->
                            isClosePressed = isPress.value
                            isCloseHover = isHover.value
                            this
                        }
                    ),
                    onClick = onCloseRequest
                )
            }
        }
    }
}