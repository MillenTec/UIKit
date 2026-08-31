package com.millentec.compose.uikit.foundation.layout

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import com.millentec.compose.uikit.component.layout.UIKitIcon
import com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolEffect
import com.millentec.compose.uikit.symbols.animate.bounceEffect
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitTypography

class UIKitNavigationBarScope : UIKitItemScope<UIKitCheckableItem>() {
    @Composable
    fun Text(
        text: String,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (isChecked)
                        colorChecked
                    else
                        color,
                    animationSpec = tween(
                        getUIKitAnimate().transformRegularDurationMillis,
                        easing = LinearEasing
                    )
                )

                Text(
                    text = text,
                    style = getUIKitTypography().body,
                    color = colorAnimated,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        })
    }

    @Composable
    fun Icon(
        symbol: UIKitSymbol,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
        contentDescription: String?,
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (isChecked)
                        colorChecked
                    else
                        color,
                    animationSpec = tween(
                        getUIKitAnimate().transformRegularDurationMillis,
                        easing = LinearEasing
                    )
                )

                val trigger = remember { mutableStateOf(false) }
                LaunchedEffect(isChecked) {
                    if (isChecked) {
                        trigger.value = !trigger.value
                    }
                }

                UIKitIcon(
                    modifier = Modifier
                        .fillMaxSize(),
                    symbol = symbol,
                    contentDescription = contentDescription,
                    symbolStyle = UIKitSymbolStyle.Monochrome(colorAnimated),
                    symbolEffect = UIKitSymbolEffect()
                        .bounceEffect(trigger.value, -2f)
                )
            }
        })
    }

    @Deprecated(
        message = "Use UIKitSymbol overload instead.",
        replaceWith = ReplaceWith(
        "Icon( symbol = UIKitImageVectorSymbol(icon), contentDescription = contentDescription, color = color, colorChecked = colorChecked, )",
        "com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol"
        )
    )
    @Composable
    fun Icon(
        icon: ImageVector,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
        contentDescription: String?,
    ) {
        Icon(
            symbol = UIKitImageVectorSymbol(icon),
            contentDescription = contentDescription,
            color = color,
            colorChecked = colorChecked,
        )
    }

    @Composable
    fun TextWithIcon(
        text: String,
        symbol: UIKitSymbol,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
        contentDescription: String? = text,
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                val colorAnimated by animateColorAsState(
                    targetValue = if (isChecked)
                        colorChecked
                    else
                        color,
                    animationSpec = tween(
                        getUIKitAnimate().transformRegularDurationMillis,
                        easing = LinearEasing
                    )
                )

                val trigger = remember { mutableStateOf(false) }
                LaunchedEffect(isChecked) {
                    if (isChecked) {
                        trigger.value = !trigger.value
                    }
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    UIKitIcon(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(symbol.defaultSize.width / symbol.defaultSize.height),
                        symbol = symbol,
                        contentDescription = contentDescription,
                        symbolStyle = UIKitSymbolStyle.Monochrome(colorAnimated),
                        symbolEffect = UIKitSymbolEffect()
                            .bounceEffect(trigger.value, -2f)
                    )

                    Text(
                        text = text,
                        style = getUIKitTypography().footnote,
                        color = colorAnimated,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        })
    }

    @Deprecated(
        message = "Use UIKitSymbol overload instead.",
        replaceWith = ReplaceWith(
            "TextWithIcon( text = text, symbol = UIKitImageVectorSymbol(icon), color = color, colorChecked = colorChecked, contentDescription = contentDescription, )",
            "com.millentec.compose.uikit.symbols.UIKitImageVectorSymbol"
        )
    )
    @Composable
    fun TextWithIcon(
        text: String,
        icon: ImageVector,
        color: Color = getUIKitColors().textFillColorPrimaryBrush,
        colorChecked: Color = getUIKitColors().highlightColorPrimaryBrush,
        contentDescription: String? = text,
    ) {
        TextWithIcon(
            text = text,
            symbol = UIKitImageVectorSymbol(icon),
            color = color,
            colorChecked = colorChecked,
            contentDescription = contentDescription,
        )
    }

    @Suppress("FunctionName")
    fun Item(
        content: @Composable UIKitCheckableItem.() -> Unit,
    ) {
        add(object : UIKitCheckableItem() {
            @Composable
            override fun Content(isChecked: Boolean) {
                this.content()
            }
        })
    }
}