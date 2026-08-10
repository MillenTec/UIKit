package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.info(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "Info",
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
            moveTo(10.5f, 13.5f)
            verticalLineToRelative(0.09f)
            curveToRelative(-0.05f, 0.23f, -0.25f, 0.41f, -0.5f, 0.41f)
            reflectiveCurveToRelative(-0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
            verticalLineToRelative(-0.09f)
            curveToRelative(0.05f, -0.23f, 0.25f, -0.41f, 0.5f, -0.41f)
            reflectiveCurveToRelative(0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
            close()
            moveTo(10f, 7.5f)
            curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
            reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f)
            reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f)
            reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f)
            close()
        }
        path(fill = primary) {
            moveTo(9.51f, 8.91f)
            curveToRelative(0.04f, -0.23f, 0.25f, -0.41f, 0.49f, -0.41f)
            reflectiveCurveToRelative(0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
            verticalLineToRelative(0.09f)
            curveToRelative(-0.05f, 0.23f, -0.25f, 0.41f, -0.5f, 0.41f)
            reflectiveCurveToRelative(-0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
            verticalLineToRelative(-0.09f)
            close()
            moveTo(9.25f, 6.75f)
            curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
            reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f)
            reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f)
            reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.info(): ImageVector {
    return info(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.info(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return info(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}