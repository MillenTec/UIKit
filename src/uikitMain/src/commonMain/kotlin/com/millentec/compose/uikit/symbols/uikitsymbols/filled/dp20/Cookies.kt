package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.cookies(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Cookies",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(17.87f, 8.56f)
            curveToRelative(-0.03f, -0.19f, -0.17f, -0.34f, -0.36f, -0.39f)
            curveToRelative(-0.18f, -0.05f, -0.38f, 0f, -0.51f, 0.15f)
            curveToRelative(-0.37f, 0.42f, -0.9f, 0.68f, -1.5f, 0.68f)
            curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f)
            curveToRelative(0f, -0.26f, -0.18f, -0.49f, -0.44f, -0.55f)
            curveToRelative(-0.89f, -0.2f, -1.56f, -1f, -1.56f, -1.95f)
            curveToRelative(0f, -0.56f, 0.23f, -1.07f, 0.61f, -1.43f)
            curveToRelative(0.13f, -0.13f, 0.18f, -0.32f, 0.13f, -0.49f)
            curveToRelative(-0.05f, -0.18f, -0.19f, -0.31f, -0.37f, -0.35f)
            curveToRelative(-0.6f, -0.14f, -1.23f, -0.22f, -1.87f, -0.22f)
            curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
            reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
            reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
            curveToRelative(0f, -0.49f, -0.04f, -0.97f, -0.13f, -1.44f)
            close()
            moveTo(5f, 8f)
            curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
            reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
            reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
            reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f)
            close()
            moveTo(7f, 14f)
            curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
            reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
            reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
            reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
            close()
            moveTo(10f, 11f)
            curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
            reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
            reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
            reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
            close()
            moveTo(12f, 15f)
            curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
            reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
            reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
            reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
            close()
        }
        path(fill = primary) {
            moveTo(7f, 8f)
            curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f)
            reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
            reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
            reflectiveCurveToRelative(1f, -0.45f, 1f, -1f)
            close()
            moveTo(10f, 11f)
            curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
            reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
            reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
            reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
            close()
            moveTo(13f, 14f)
            curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f)
            reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
            reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
            reflectiveCurveToRelative(1f, -0.45f, 1f, -1f)
            close()
            moveTo(7f, 14f)
            curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
            reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
            reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
            reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.cookies(): ImageVector {
    return cookies(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.cookies(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return cookies(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}
