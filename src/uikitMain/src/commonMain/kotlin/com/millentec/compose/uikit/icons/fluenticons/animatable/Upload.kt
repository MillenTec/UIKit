package com.millentec.compose.uikit.icons.fluenticons.animatable

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.animatable.UIKitArrowCircleAnimateState.Running
import com.millentec.compose.uikit.theme.getUIKitColors

@Composable
@Preview
private fun Preview() {
    FluentIcons.AnimatableIcons.Upload(
        modifier = Modifier.size(50.dp),
        progress = 0.5f,
        state = Running
    )
}

@Composable
fun FluentIcons.AnimatableIcons.Upload(
    modifier: Modifier = Modifier.size(20.dp),
    progress: Float,
    state: UIKitArrowCircleAnimateState = Running,
    tint: Color = getUIKitColors().textFillColorPrimaryBrush,
    resetProgressOnError: Boolean = true,
    lineWidth: Dp = 1.dp
) = ArrowCircle(
    modifier = modifier,
    progress = progress,
    state = state,
    tint = tint,
    resetProgressOnError = resetProgressOnError,
    lineWidth = lineWidth,
    rotate = 180f
)
@Composable
fun FluentIcons.AnimatableIcons.Upload(
    modifier: Modifier = Modifier.size(20.dp),
    progress: Float,
    state: UIKitArrowCircleAnimateState = Running,
    resetProgressOnError: Boolean = true,
    lineWidth: Dp = 1.dp
) = ArrowCircle(
    modifier = modifier,
    progress = progress,
    state = state,
    resetProgressOnError = resetProgressOnError,
    lineWidth = lineWidth,
    rotate = 180f
)