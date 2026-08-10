package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.warningCircle(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "WarningCircle",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(10f, 2f)
            curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
            reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
            reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
            reflectiveCurveTo(14.42f, 2f, 10f, 2f)
            close()
            moveTo(9.5f, 6.5f)
            verticalLineToRelative(-0.09f)
            curveToRelative(0.05f, -0.23f, 0.25f, -0.41f, 0.5f, -0.41f)
            reflectiveCurveToRelative(0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
            verticalLineToRelative(0.09f)
            curveToRelative(-0.05f, 0.23f, -0.25f, 0.41f, -0.5f, 0.41f)
            reflectiveCurveToRelative(-0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
            close()
            moveTo(10f, 14f)
            curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
            reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f)
            reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f)
            reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f)
            close()
        }
        path(fill = primary) {
            moveTo(10f, 12.5f)
            curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
            reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
            reflectiveCurveToRelative(0.75f, -0.34f, 0.75f, -0.75f)
            reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f)
            close()
            moveTo(10f, 6f)
            curveToRelative(-0.25f, 0f, -0.45f, 0.18f, -0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
            verticalLineToRelative(0.09f)
            curveToRelative(0.05f, 0.23f, 0.25f, 0.41f, 0.5f, 0.41f)
            reflectiveCurveToRelative(0.45f, -0.18f, 0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
            verticalLineToRelative(-0.09f)
            curveToRelative(-0.05f, -0.23f, -0.25f, -0.41f, -0.5f, -0.41f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.warningCircle(): ImageVector {
    return warningCircle(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.warningCircle(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return warningCircle(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}