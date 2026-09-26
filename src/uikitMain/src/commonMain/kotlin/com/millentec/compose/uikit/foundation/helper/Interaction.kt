package com.millentec.compose.uikit.foundation.helper

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.ripple
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import com.millentec.compose.uikit.theme.getUIKitAnimate
import com.millentec.compose.uikit.theme.getUIKitColors

@Composable
fun Modifier.uikitClickable(
    enabled: Boolean = true,
    onClick: () -> Unit,
    indicationEnabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = UIKitInteraction.ripple(),
    shape: Shape = RectangleShape,
    interaction: (@Composable Modifier.(State<Boolean>, State<Boolean>, State<Shape>) -> Modifier)? = null
): Modifier {
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()
    val isPressed = interactionSource.collectIsPressedAsState()
    val shapeState = remember { mutableStateOf(shape) }

    LaunchedEffect(shapeState) {
        shapeState.value = shape
    }

    if (indicationEnabled) {
        if (interaction == null) {
            return clip(shape)
                .uikitClickable(
                    enabled = enabled,
                    onClick = onClick,
                    indicationEnabled = indicationEnabled,
                    interactionSource = interactionSource,
                    indication = indication,
                    shape = shape
                )
        }

        return interaction(
                isHovered,
                isPressed,
                shapeState
            )
            .clickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
            )
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

@Composable
fun Modifier.uikitClickable(
    enabled: Boolean = true,
    onClick: () -> Unit,
    indicationEnabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    indication: Indication? = UIKitInteraction.ripple(),
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
        val layoutDirection = LocalLayoutDirection.current
        val density = LocalDensity.current

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
            .clickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
            )
            .drawWithCache {
                val outline = shape.createOutline(
                    size = size,
                    layoutDirection = layoutDirection,
                    density = density
                )

                onDrawWithContent {
                    drawContent()
                    drawOutline(
                        outline = outline,
                        color = animatedColor,
                        blendMode = if (animatedColor.toHsv().value >= 0.5f)
                            BlendMode.Lighten
                        else
                            BlendMode.Darken
                    )
                }
            }
    } else {
        return this
            .clickable(
                enabled = enabled,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null,
            )
    }
}

class UIKitInteraction {
    companion object {
        val DarkenWithScale: @Composable Modifier.(State<Boolean>, State<Boolean>, State<Shape>) -> Modifier = @Composable { isHover, isPress, shape ->
            val degreeAnimated by animateFloatAsState(
                targetValue = if (isHover.value) 0.05f else 0f,
                animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
            )

            val scaleAnimated by animateFloatAsState(
                targetValue = if (isPress.value) 0.9f else 1f,
                animationSpec = spring(
                    dampingRatio = getUIKitAnimate().standardSpringDampingRatio,
                    stiffness = getUIKitAnimate().standardSpringStiffness
                )
            )

            this
                .graphicsLayer {
                    scaleX = scaleAnimated
                    scaleY = scaleAnimated
                }
                .then(if (getUIKitColors().contentFillColorPrimaryBrush.toHsv().value <= 0.5f) {
                    Modifier.lighten(
                        degreeAnimated,
                        shape.value
                    )
                } else {
                    Modifier.darken(
                        degreeAnimated,
                        shape.value
                    )
                })
        }

        @Composable
        fun ripple() = ripple(
            color = getUIKitColors().pointerInteractionBrush
        )
    }
}