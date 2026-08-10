package com.millentec.compose.uikit.symbols.uikitsymbols.animatable

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.animatable.UIKitArrowCircleAnimateState.Running
import com.millentec.compose.uikit.theme.getUIKitColors

@Composable
@Preview
private fun Preview() {
    UIKitSymbols.AnimatableIcons.Upload(
        modifier = Modifier.size(50.dp),
        progress = 0.5f,
        state = Running
    )
}

@Composable
fun UIKitSymbols.AnimatableIcons.Upload(
    modifier: Modifier = Modifier,
    progress: Float,
    state: UIKitArrowCircleAnimateState = Running,
    tint: Brush,
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
fun UIKitSymbols.AnimatableIcons.Upload(
    modifier: Modifier = Modifier,
    progress: Float,
    state: UIKitArrowCircleAnimateState = Running,
    primaryTint: Color = getUIKitColors().highlightColorPrimaryBrush,
    autoTint: Boolean = true,
    resetProgressOnError: Boolean = true,
    lineWidth: Dp = 1.dp
) = ArrowCircle(
    modifier = modifier,
    progress = progress,
    state = state,
    primaryTint = primaryTint,
    autoTint = autoTint,
    resetProgressOnError = resetProgressOnError,
    lineWidth = lineWidth,
    rotate = 180f
)