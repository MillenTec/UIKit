package com.millentec.compose.uikit.foundation.graphics

import androidx.compose.ui.graphics.Color
import kotlin.math.pow

private fun linearize(c: Float): Double = when {
    c <= 0.03928 -> c / 12.92
    else -> ((c + 0.055) / 1.055).pow(2.4)
}

fun Color.relativeLuminance(): Double {
    return 0.2126 * linearize(red) +
            0.7152 * linearize(green) +
            0.0722 * linearize(blue)
}

fun Color.Companion.contrast(color1: Color, color2: Color): Double {
    val l1 = color1.relativeLuminance()
    val l2 = color2.relativeLuminance()
    val lighter = maxOf(l1, l2)
    val darker = minOf(l1, l2)
    return (lighter + 0.05) / (darker + 0.05)
}

fun Color.contrast(color: Color): Double {
    return Color.contrast(this, color)
}

