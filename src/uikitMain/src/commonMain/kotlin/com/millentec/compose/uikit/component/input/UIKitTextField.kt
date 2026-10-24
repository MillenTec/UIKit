package com.millentec.compose.uikit.component.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.component.media.UIKitIcon
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.foundation.helper.onClickOutside
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.dismissCircle
import com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.builtin.systemui.Bluetooth
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitTextField(
        value = "",
        watermark = AnnotatedString("Enter Text..."),
        onValueChange = {},
        mask = UIKitTextFieldMask.None,
        symbol = UIKitSymbols.systemUI.Bluetooth,
        options = UIKitTextFieldOptions(clear = true),
        shape = RoundedCornerShape(12.dp)
    )
}

data class UIKitTextFieldColors(
    val background: Color,
    val backgroundDisabled: Color,
    val backgroundActive: Color,
    val border: Color,
    val borderDisabled: Color,
    val borderActive: Color,
    val watermark: Color,
    val watermarkDisabled: Color,
    val watermarkActive: Color,
    val content: Color,
    val contentDisabled: Color,
    val contentActive: Color,
    val textSelectionColors: TextSelectionColors
) {
    companion object {
        @Composable
        fun default(
            background: Color = getUIKitColors().contentFillColorTertiaryBrush,
            backgroundDisabled: Color = getUIKitColors().contentFillColorBrushDisabled,
            backgroundActive: Color = getUIKitColors().contentFillColorSecondaryBrush,
            border: Color = getUIKitColors().lineFillColorPrimaryBrush,
            borderActive: Color = getUIKitColors().highlightColorPrimaryBrush,
            borderDisabled: Color = getUIKitColors().lineFillColorDisabled,
            watermark: Color = getUIKitColors().textFillColorSecondaryBrush,
            watermarkActive: Color = getUIKitColors().textFillColorSecondaryBrush,
            watermarkDisabled: Color = getUIKitColors().textFillColorDisabled,
            content: Color = getUIKitColors().textFillColorPrimaryBrush,
            contentActive: Color = getUIKitColors().textFillColorPrimaryBrush,
            contentDisabled: Color = getUIKitColors().textFillColorDisabled,
            textSelectionColors: TextSelectionColors = TextSelectionColors(
                handleColor = getUIKitColors().highlightColorPrimaryBrush,
                backgroundColor = getUIKitColors().highlightColorPrimaryBrush.copy(0.3f)
            )
        ): UIKitTextFieldColors = UIKitTextFieldColors(
            background,
            backgroundDisabled,
            backgroundActive,
            border,
            borderDisabled,
            borderActive,
            watermark,
            watermarkDisabled,
            watermarkActive,
            content,
            contentDisabled,
            contentActive,
            textSelectionColors
        )
    }
}

data class UIKitTextFieldOptions(
    val clear: Boolean = false,
    val dismissOnGoBack: Boolean = true,
    val dismissOnClickOutside: Boolean = true
) {
    companion object {
        val Default: UIKitTextFieldOptions = UIKitTextFieldOptions()
    }
}

data class UIKitTextFieldActions(
    val onClear: (() -> Unit)? = null,
) {
    companion object {
        val Default: UIKitTextFieldActions = UIKitTextFieldActions()
    }
}

sealed class UIKitTextFieldMask {
    data class Char(val char: kotlin.Char): UIKitTextFieldMask()
    object Ellipsis: UIKitTextFieldMask()
    object None: UIKitTextFieldMask()
}

@Composable
fun UIKitTextField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: String,
    onValueChange: (String) -> Unit,
    onDismissRequest: (() -> Unit)? = null,
    watermark: String? = null,
    symbol: UIKitSymbol? = null,
    onSymbolClick: ((String) -> Unit)? = null,
    mask: UIKitTextFieldMask = UIKitTextFieldMask.None,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    border: Dp? = 1.dp,
    colors: UIKitTextFieldColors = UIKitTextFieldColors.default(),
    textStyle: TextStyle = getUIKitTypography().body,
    maxLines: Int = 1,
    minLines: Int = 1,
    isFocus: Boolean = false,
    onFocusChange: ((Boolean) -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    options: UIKitTextFieldOptions = UIKitTextFieldOptions.Default,
    actions: UIKitTextFieldActions = UIKitTextFieldActions.Default
) = UIKitTextField(
    modifier = modifier,
    enabled = enabled,
    value = value,
    onValueChange = onValueChange,
    onDismissRequest = onDismissRequest,
    watermark = watermark?.let { AnnotatedString(it) },
    symbol = symbol,
    onSymbolClick = onSymbolClick,
    mask = mask,
    shape = shape,
    border = border,
    colors = colors,
    textStyle = textStyle,
    maxLines = maxLines,
    minLines = minLines,
    isFocus = isFocus,
    onFocusChange = onFocusChange,
    keyboardOptions = keyboardOptions,
    keyboardActions = keyboardActions,
    options = options,
    actions = actions
)

@Composable
fun UIKitTextField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: String,
    onValueChange: (String) -> Unit,
    onDismissRequest: (() -> Unit)? = null,
    watermark: AnnotatedString?,
    symbol: UIKitSymbol? = null,
    onSymbolClick: ((String) -> Unit)? = null,
    mask: UIKitTextFieldMask = UIKitTextFieldMask.None,
    shape: Shape = RoundedCornerShape(getUIKitShapes().circular),
    border: Dp? = 1.dp,
    colors: UIKitTextFieldColors = UIKitTextFieldColors.default(),
    textStyle: TextStyle = getUIKitTypography().body,
    maxLines: Int = 1,
    minLines: Int = 1,
    isFocus: Boolean = false,
    onFocusChange: ((Boolean) -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    options: UIKitTextFieldOptions = UIKitTextFieldOptions.Default,
    actions: UIKitTextFieldActions = UIKitTextFieldActions.Default
) {
    val isFocused = remember { mutableStateOf(false) }

    val backgroundAnimated by animateColorAsState(
        targetValue = if (!enabled) colors.backgroundDisabled
        else if (isFocused.value) colors.backgroundActive
        else colors.background,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val borderAnimated by animateColorAsState(
        targetValue = if (!enabled) colors.borderDisabled
        else if (isFocused.value) colors.borderActive
        else colors.border,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val contentAnimated by animateColorAsState(
        targetValue = if (!enabled) colors.contentDisabled
        else if (isFocused.value) colors.contentActive
        else colors.content,
        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
    )

    val densityDpi = LocalDensity.current.density
    val rootSize = remember { mutableStateOf(DpSize.Zero) }
    val rootPosition = remember { mutableStateOf(Offset.Zero) }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(isFocus) {
        if (isFocus) {
            focusRequester.requestFocus()
            keyboardController?.show()
        } else {
            focusManager.clearFocus()
            keyboardController?.hide()
        }
    }

    CompositionLocalProvider(LocalTextSelectionColors provides colors.textSelectionColors) {
        Box(
            modifier = Modifier
                .background(backgroundAnimated, shape)
                .then(
                    if (border != null) Modifier.border(
                        width = border,
                        color = borderAnimated,
                        shape = shape
                    ) else Modifier
                )
                .onGloballyPositioned { layoutCoordinates ->
                    rootSize.value = DpSize(
                        (layoutCoordinates.size.width / densityDpi).dp,
                        (layoutCoordinates.size.height / densityDpi).dp
                    )
                    rootPosition.value = layoutCoordinates.positionInRoot()
                }
                .onClickOutside(
                    enabled = enabled && isFocused.value
                ) {
                    onDismissRequest?.invoke()
                }
        ) {
            Row(
                modifier = modifier
                    .defaultMinSize(minHeight = getUIKitLayout().interactiveHotspot)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (symbol == null) {
                    Spacer(
                        Modifier.width(
                            ((rootSize.value.height - textStyle.lineHeight.value.dp) / 2).coerceIn(
                                getUIKitLayout().basicSpacing..getUIKitLayout().mediumSpacing
                            )
                        )
                    )
                } else {
                    UIKitIcon(
                        modifier = Modifier
                            .then(
                                if (onSymbolClick != null) {
                                    Modifier.uikitClickable(
                                        onClick = {
                                            onSymbolClick(value)
                                        },
                                        indicationEnabled = false
                                    )
                                } else Modifier
                            )
                            .padding(run {
                                val padding = ((rootSize.value.height - textStyle.lineHeight.value.dp) / 2).coerceIn(
                                    getUIKitLayout().basicSpacing..getUIKitLayout().mediumSpacing
                                )

                                PaddingValues(
                                    start = padding,
                                    top = padding,
                                    bottom = padding,
                                    end = getUIKitLayout().smallSpacing,
                                )
                            })
                            .size(textStyle.lineHeight.value.dp),
                        symbol = symbol,
                        contentDescription = null
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    if (mask == UIKitTextFieldMask.Ellipsis) {
                        Canvas(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            repeat(value.length) {
                                drawCircle(
                                    color = contentAnimated,
                                    radius = 5.dp.toPx(),
                                    center = Offset(
                                        5.dp.toPx() + (it * 15.dp.toPx()),
                                        0f
                                    )
                                )
                            }
                        }
                    }

                    BackHandler(enabled = isFocused.value && options.dismissOnGoBack) {
                        onDismissRequest?.invoke()
                    }

                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester)
                            .onFocusChanged {
                                isFocused.value = it.isFocused
                                onFocusChange?.invoke(it.isFocused)
                            },
                        enabled = enabled,
                        value = value,
                        onValueChange = onValueChange,
                        textStyle = textStyle.merge(color = contentAnimated),
                        keyboardOptions = keyboardOptions,
                        keyboardActions = keyboardActions,
                        singleLine = maxLines == 1,
                        maxLines = maxLines,
                        minLines = minLines,
                        cursorBrush = SolidColor(colors.textSelectionColors.handleColor),
                        visualTransformation = when (mask) {
                            UIKitTextFieldMask.None -> VisualTransformation.None
                            is UIKitTextFieldMask.Char -> VisualTransformation { string ->
                                TransformedText(
                                    AnnotatedString(text = CharArray(string.length) { mask.char }.concatToString()),
                                    offsetMapping = OffsetMapping.Identity
                                )
                            }

                            UIKitTextFieldMask.Ellipsis -> VisualTransformation { string ->
                                TransformedText(
                                    AnnotatedString(text = CharArray(string.length) { '\u200d' }.concatToString()),
                                    offsetMapping = OffsetMapping.Identity
                                )
                            }
                        }
                    )

                    watermark?.let {
                        if (value.isEmpty() || value.isBlank()) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = it,
                                style = textStyle.merge(color = colors.watermark)
                            )
                        }
                    }
                }

                if (options == UIKitTextFieldOptions.Default) {
                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))
                } else {
                    if (options.clear) {
                        val interactionSource = remember { MutableInteractionSource() }
                        val isHovered by interactionSource.collectIsHoveredAsState()
                        val isPressed by interactionSource.collectIsPressedAsState()
                        val alphaAnimated by animateFloatAsState(
                            targetValue = if (isPressed) 0.15f else if (isHovered) 0.3f else 0.15f,
                            tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
                        )

                        UIKitIcon(
                            modifier = Modifier
                                .uikitClickable(
                                    onClick = {
                                        if (actions.onClear == null) {
                                            onValueChange("")
                                        } else {
                                            actions.onClear()
                                        }
                                    },
                                    indicationEnabled = false
                                )
                                .hoverable(
                                    interactionSource = interactionSource,
                                )
                                .padding(run {
                                    val padding = ((rootSize.value.height - textStyle.lineHeight.value.dp) / 2).coerceIn(
                                        getUIKitLayout().basicSpacing..getUIKitLayout().mediumSpacing
                                    )

                                    PaddingValues(
                                        start = getUIKitLayout().smallSpacing,
                                        top = padding,
                                        bottom = padding,
                                        end = padding,
                                    )
                                })
                                .size(textStyle.lineHeight.value.dp),
                            symbol = UIKitImageVectorSymbol(FluentIcons.dismissCircle()),
                            symbolStyle = UIKitSymbolStyle.Palette(
                                UIKitBrush.solid(getUIKitColors().textFillColorSecondaryBrush),
                                UIKitBrush.solid(getUIKitColors().textFillColorSecondaryBrush.copy(alphaAnimated))
                            ),
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        }
    }
}