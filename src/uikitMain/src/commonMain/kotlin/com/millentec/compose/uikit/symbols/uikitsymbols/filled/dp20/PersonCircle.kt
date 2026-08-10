package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.personCircle(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "PersonCircle",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(8f, 7f)
            curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
            reflectiveCurveToRelative(2f, 0.9f, 2f, 2f)
            reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f)
            reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f)
            close()
            moveTo(7.5f, 10f)
            horizontalLineToRelative(5f)
            curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
            curveToRelative(0f, 1.12f, -0.46f, 2.01f, -1.21f, 2.61f)
            curveToRelative(-0.74f, 0.59f, -1.73f, 0.89f, -2.79f, 0.89f)
            reflectiveCurveToRelative(-2.05f, -0.29f, -2.79f, -0.89f)
            curveToRelative(-0.75f, -0.6f, -1.21f, -1.5f, -1.21f, -2.61f)
            curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f)
            close()
        }
        path(fill = secondary) {
            moveTo(10f, 2f)
            curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
            reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
            reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
            reflectiveCurveTo(14.42f, 2f, 10f, 2f)
            close()
            moveTo(10f, 5f)
            curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
            reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f)
            reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f)
            reflectiveCurveToRelative(0.9f, -2f, 2f, -2f)
            close()
            moveTo(12.79f, 14.11f)
            curveToRelative(-0.74f, 0.59f, -1.73f, 0.89f, -2.79f, 0.89f)
            reflectiveCurveToRelative(-2.05f, -0.29f, -2.79f, -0.89f)
            curveToRelative(-0.75f, -0.6f, -1.21f, -1.5f, -1.21f, -2.61f)
            curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f)
            horizontalLineToRelative(5f)
            curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
            curveToRelative(0f, 1.12f, -0.46f, 2.01f, -1.21f, 2.61f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.personCircle(): ImageVector {
    return personCircle(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.personCircle(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return personCircle(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}