package com.millentec.compose.uikit.foundation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.material3.ripple
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import com.millentec.compose.uikit.component.input.toHsv
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors

@Composable
fun InteractionSource.collectIsPressedAsState(): State<Boolean> {
    val isPressed = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> isPressed.value = true
                is PressInteraction.Cancel -> isPressed.value = false
                is PressInteraction.Release -> isPressed.value = false
            }
        }
    }
    return isPressed
}

@Composable
fun InteractionSource.collectIsHoveredAsState(): State<Boolean> {
    val isHovered = remember { mutableStateOf(false) }
    LaunchedEffect(this) {
        interactions.collect { interaction ->
            when (interaction) {
                is HoverInteraction.Enter -> isHovered.value = true
                is HoverInteraction.Exit -> isHovered.value = false
            }
        }
    }
    return isHovered
}

@Composable
fun Modifier.uikitClickable(
    enabled: Boolean = true,
    onClick: () -> Unit,
    indicationEnabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = ripple(),
    shape: Shape = RectangleShape,
): Modifier {
    if (indicationEnabled) {
        if (indication != null) {
            return this
                .clip(shape)
                .clickable(
                    enabled = enabled,
                    onClick = onClick,
                    interactionSource = interactionSource,
                    indication = indication,
                )
        }

        val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
        val isHovered by interactionSource.collectIsHoveredAsState()
        val isPressed by interactionSource.collectIsPressedAsState()

        val targetColor = when {
            isPressed -> getUIKitColors().pointerTapInteractionColor
            isHovered -> getUIKitColors().pointerHoverInteractionColor
            else -> getUIKitColors().pointerHoverInteractionColor.copy(0f)
        }

        val animatedColor by animateColorAsState(
            targetValue = targetColor,
            animationSpec = tween(
                durationMillis = if (isHovered && !isPressed)
                    getUIKitAnimate().transformRegularDurationMillis
                else getUIKitAnimate().transformMomentaryDurationMillis
            )
        )

        return this
            .clip(shape)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
            )
            .drawWithContent {
                drawContent()
                drawRect(
                    color = animatedColor,
                    blendMode = if (animatedColor.toHsv().value >= 0.5f)
                        BlendMode.Lighten
                    else
                        BlendMode.Darken
                )
            }
    } else {
        return this
            .clip(shape)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
            )
    }
}