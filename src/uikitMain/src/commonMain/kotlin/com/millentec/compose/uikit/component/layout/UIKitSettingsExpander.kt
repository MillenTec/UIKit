package com.millentec.compose.uikit.component.layout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.ChevronArrowDown
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Wheelchair
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitSettingsExpander(
        expanded = true,
        onClick = {

        },
        title = "Expander",
        description = "This is a description.",
        icon = FluentIcons.Wheelchair
    ) {
        Text("Hello, World!")
    }
}

@Composable
fun UIKitSettingsExpander(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onClick: () -> Unit,
    icon: ImageVector? = null,
    iconColor: Color = getUIKitColors().textFillColorPrimaryBrush,
    title: String,
    description: String? = null,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    shadowEnabled: Boolean = false,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = getUIKitLayout().interactiveHotspot),
        propagateMinConstraints = true
    ) {
        Column(
            modifier = Modifier
                .then(if (shadowEnabled) {
                    Modifier.dropShadow(
                        shape = RoundedCornerShape(cornerRadius),
                        shadow = UIKitShadowMaterial.getPrimary()
                    )
                } else Modifier)
                .clip(RoundedCornerShape(cornerRadius))
                .background(background)
                .animateContentSize(
                    animationSpec = tween(getUIKitAnimate().motionRegularDurationMillis, easing = FastOutSlowInEasing)
                )
        ) {
            val iconRotateAnimated by animateFloatAsState(
                targetValue = if (expanded) 180f else 0f,
                animationSpec = tween(getUIKitAnimate().motionRegularDurationMillis, easing = FastOutSlowInEasing)
            )

            UIKitSettingCard(
                onClick = onClick,
                icon = icon,
                iconColor = iconColor,
                title = title,
                description = description,
                cornerRadius = cornerRadius,
                background = background,
                contentPadding = contentPadding,
                shadowEnabled = false
            ) {
                Icon(
                    modifier = Modifier
                        .size(22.dp)
                        .rotate(iconRotateAnimated),
                    imageVector = FluentIcons.ChevronArrowDown,
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            }

            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(
                    animationSpec = tween(0)
                ),
                exit = fadeOut(
                    animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = LinearEasing)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(contentPadding),
                    content = content
                )
            }
        }
    }
}