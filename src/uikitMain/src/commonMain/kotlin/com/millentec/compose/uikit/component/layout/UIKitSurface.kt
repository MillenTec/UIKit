package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.theme.getUIKitColors

@Composable
@Preview
private fun Preview() {
    UIKitSurface(
        onClick = {}
    ) {

    }
}

@Composable
fun UIKitSurface(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    color: Color = getUIKitColors().contentFillColorTertiaryBrush,
    shadow: Shadow? = null,
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = UIKitInteraction.ripple(),
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable () -> Unit
) {
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .clip(shape)
            .background(color)
            .uikitClickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = indication
            ),
        propagateMinConstraints = true
    ) {
        Box(
            modifier = Modifier
                .clip(shape)
                .then(
                    if (shadow != null)
                        Modifier.dropShadow(shape, shadow)
                    else Modifier
                )
                .then(
                    if (border != null)
                        Modifier.border(border)
                    else Modifier
                ),
            contentAlignment = contentAlignment,
        ) {
            content()
        }
    }
}

@Composable
fun UIKitSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = getUIKitColors().contentFillColorTertiaryBrush,
    shadow: Shadow? = null,
    border: BorderStroke? = null,
    content: @Composable () -> Unit
) = UIKitSurface(
    onClick = {},
    modifier = modifier,
    enabled = false,
    shape = shape,
    color = color,
    shadow = shadow,
    border = border,
    interactionSource = null,
    indication = null,
    content = content
)

@Composable
fun UIKitSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = getUIKitColors().contentFillColorTertiaryBrush,
    shadow: Shadow? = null,
    border: BorderStroke? = null
) = UIKitSurface(
    modifier = modifier,
    shape = shape,
    color = color,
    shadow = shadow,
    border = border,
    content = {}
)
