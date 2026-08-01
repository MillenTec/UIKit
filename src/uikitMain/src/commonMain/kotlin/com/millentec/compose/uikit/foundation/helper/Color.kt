package com.millentec.compose.uikit.foundation.helper

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.millentec.compose.uikit.foundation.UIKitHSVColor
import kotlin.math.max
import kotlin.math.min

fun Color.toHsv(): UIKitHSVColor {
    val argb = this.toArgb()

    val r = ((argb shr 16) and 0xFF) / 255f
    val g = ((argb shr 8) and 0xFF) / 255f
    val b = (argb and 0xFF) / 255f

    val max = max(r, max(g, b))
    val min = min(r, min(g, b))
    val delta = max - min

    val s = if (max == 0f) 0f else delta / max

    val h = when {
        delta == 0f -> 0f
        max == r -> 60f * (((g - b) / delta) % 6)
        max == g -> 60f * (((b - r) / delta) + 2)
        else -> 60f * (((r - g) / delta) + 4)
    }

    val finalH = if (h < 0) h + 360f else h

    return UIKitHSVColor(finalH, s, max, this.alpha)
}