package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.certificate(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Certificate",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(5.5f, 15f)
            curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f)
            reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f)
            reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f)
            reflectiveCurveToRelative(-1.57f, 3.5f, -3.5f, 3.5f)
            close()
            moveTo(3f, 15.24f)
            curveToRelative(0.72f, 0.48f, 1.57f, 0.76f, 2.5f, 0.76f)
            reflectiveCurveToRelative(1.78f, -0.28f, 2.5f, -0.76f)
            verticalLineToRelative(2.76f)
            curveToRelative(0f, 0.41f, -0.47f, 0.65f, -0.8f, 0.4f)
            lineToRelative(-1.4f, -1.05f)
            curveToRelative(-0.18f, -0.13f, -0.42f, -0.13f, -0.6f, 0f)
            lineToRelative(-1.4f, 1.05f)
            curveToRelative(-0.33f, 0.25f, -0.8f, 0.01f, -0.8f, -0.4f)
            verticalLineToRelative(-2.76f)
            close()
        }
        path(fill = secondary) {
            moveTo(4f, 3f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(3.67f)
            curveToRelative(0.29f, -0.35f, 0.62f, -0.66f, 1f, -0.91f)
            verticalLineToRelative(-2.76f)
            curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
            horizontalLineToRelative(12f)
            curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
            verticalLineToRelative(8f)
            curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
            horizontalLineToRelative(-6.76f)
            curveToRelative(-0.08f, 0.11f, -0.16f, 0.22f, -0.24f, 0.33f)
            verticalLineToRelative(0.67f)
            horizontalLineToRelative(7f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            verticalLineTo(5f)
            curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
            horizontalLineTo(4f)
            close()
            moveTo(5f, 6.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(9f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
            horizontalLineTo(5.5f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            close()
            moveTo(10.5f, 10f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(4f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
            horizontalLineToRelative(-4f)
            close()
        }
    }.build()
}

fun UIKitSymbols.certificate(): ImageVector {
    return certificate(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.certificate(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return certificate(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
