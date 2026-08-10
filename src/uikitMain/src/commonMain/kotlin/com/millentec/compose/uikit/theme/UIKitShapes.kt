package com.millentec.compose.uikit.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class UIKitShapes(
    val rightAngle: Dp = 0.dp,
    val smallRounded: Dp = 5.dp,
    val basicRounded: Dp = 8.dp,
    val regularRounded: Dp = 12.dp,
    val mediumRounded: Dp = 20.dp,
    val largeRounded: Dp = 32.dp,

    val circular: Dp = Int.MAX_VALUE.dp
)
