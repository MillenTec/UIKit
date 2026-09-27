package com.millentec.compose.uikit.foundation.layout

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.UIKitTextField
import com.millentec.compose.uikit.component.input.UIKitTextFieldColors
import com.millentec.compose.uikit.component.input.UIKitTextFieldOptions
import com.millentec.compose.uikit.component.layout.UIKitIcon
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.state.UIKitInputControlState
import com.millentec.compose.uikit.foundation.state.rememberUIKitInputControlState
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.builtin.systemui.Search
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors

class UIKitHActionButtonsScope {
    internal val rootSize = mutableStateOf(DpSize.Zero)
    val rootWidth get() = rootSize.value.width
    val rootHeight get() = rootSize.value.height

    @Composable
    fun Button(
        symbol: UIKitSymbol,
        contentDescription: String?,
        onClick: () -> Unit,
    ) {
        Box(
            Modifier
                .size(rootHeight)
                .uikitClickable(
                    onClick = onClick,
                    indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                ),
            contentAlignment = Alignment.Center
        ) {
            UIKitIcon(
                modifier = Modifier
                    .fillMaxSize(0.6f),
                symbol = symbol,
                contentDescription = contentDescription
            )
        }
    }

    @Composable
    fun SearchBar(
        value: String,
        onValueChange: (String) -> Unit,
        onSearch: ((String) -> Unit)? = null,
        onButtonClick: () -> Unit,
        onDismissRequest: (() -> Unit)? = null,
        focus: Boolean,
        onFocusChange: (Boolean) -> Unit,
        textFieldOptions: UIKitTextFieldOptions = UIKitTextFieldOptions(clear = true),
        maxWidth: Dp = (-1).dp,
        colors: UIKitTextFieldColors = UIKitTextFieldColors.default(
            background = getUIKitColors().contentFillColorSecondaryBrush.copy(0f),
            backgroundDisabled = getUIKitColors().contentFillColorBrushDisabled.copy(0.3f),
            backgroundActive = getUIKitColors().contentFillColorSecondaryBrush.copy(0.15f),
            border = Color.Transparent,
            borderActive = Color.Transparent,
            borderDisabled = Color.Transparent
        ),
        watermark: String? = null,
    ) {
        val uikitAnimate by rememberUpdatedState(getUIKitAnimate())

        AnimatedContent(
            targetState = focus,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(uikitAnimate.transformRegularDurationMillis),
                    initialAlpha = 0f
                ).togetherWith(fadeOut(
                    animationSpec = tween(uikitAnimate.transformRegularDurationMillis),
                    targetAlpha = 1f
                ))
            }
        ) { focused ->
            if (!focused) {
                Box(
                    Modifier
                        .size(rootHeight)
                        .uikitClickable(
                            onClick = onButtonClick,
                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    UIKitIcon(
                        modifier = Modifier
                            .fillMaxSize(0.6f),
                        symbol = UIKitSymbols.systemUI.Search,
                        contentDescription = "Search"
                    )
                }
            } else {
                UIKitTextField(
                    Modifier
                        .then(if (maxWidth == (-1).dp) {
                            Modifier.fillMaxWidth()
                        } else Modifier.width(maxWidth)),
                    isFocus = focus,
                    onFocusChange = onFocusChange,
                    onDismissRequest = onDismissRequest,
                    value = value,
                    watermark = watermark,
                    onValueChange = onValueChange,
                    symbol = UIKitSymbols.systemUI.Search,
                    options = textFieldOptions,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = if (isDesktopOS()) KeyboardActions(
                        onAny = { onSearch?.invoke(value) }
                    ) else KeyboardActions(
                        onSearch = {
                            onSearch?.invoke(value)
                        }
                    ),
                    colors = colors
                )
            }
        }
    }



    @Composable
    fun SearchBar(
        state: UIKitInputControlState = rememberUIKitInputControlState(),
        watermark: String? = null,
        maxWidth: Dp = (-1).dp,
        onSearch: (String) -> Unit,
    ) {
        SearchBar(
            watermark = watermark,
            maxWidth = maxWidth,
            value = state.value.value,
            onValueChange = {
                state.value.value = it
            },
            onSearch = onSearch,
            focus = state.focused.value,
            onFocusChange = {
                state.focused.value = it
            },
            onButtonClick = {
                state.focused.value = true
            },
            onDismissRequest = {
                state.focused.value = false
            }
        )
    }
}