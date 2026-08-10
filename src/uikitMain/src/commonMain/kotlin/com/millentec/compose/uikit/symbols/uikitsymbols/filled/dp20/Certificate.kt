package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.certificate(
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
        path(fill = secondary) {
            moveTo(16f, 3f)
            horizontalLineTo(4f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(3.67f)
            curveToRelative(0.82f, -1.02f, 2.09f, -1.67f, 3.5f, -1.67f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(9f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
            horizontalLineTo(5.5f)
            curveToRelative(2.49f, 0f, 4.5f, 2.01f, 4.5f, 4.5f)
            curveToRelative(0f, 1.07f, -0.37f, 2.06f, -1f, 2.83f)
            verticalLineToRelative(0.67f)
            horizontalLineToRelative(7f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            verticalLineTo(5f)
            curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
            close()
            moveTo(14.5f, 11f)
            horizontalLineToRelative(-3f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(3f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
            close()
        }
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
    }.build()
}

fun UIKitSymbols.Filled.certificate(): ImageVector {
    return certificate(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.certificate(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return certificate(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
