package com.millentec.compose.uikit.foundation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.colorspace.Rgb

data class UIKitHSVColor(
    val hue: Float,
    val saturation: Float,
    val value: Float,
    val alpha: Float = 1f,
) {
    fun getColor(colorSpace: Rgb = ColorSpaces.Srgb): Color {
        return Color.hsv(hue, saturation, value, alpha, colorSpace)
    }
}