package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.delete(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Delete",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(17.5f, 4f)
            horizontalLineToRelative(-5f)
            curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f)
            reflectiveCurveToRelative(-2.5f, 1.12f, -2.5f, 2.5f)
            horizontalLineTo(2.5f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(1.05f)
            lineToRelative(1.19f, 10.34f)
            curveToRelative(0.17f, 1.51f, 1.46f, 2.66f, 2.98f, 2.66f)
            horizontalLineToRelative(4.54f)
            curveToRelative(1.52f, 0f, 2.81f, -1.14f, 2.98f, -2.66f)
            lineToRelative(1.19f, -10.34f)
            horizontalLineToRelative(1.05f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
            close()
            moveTo(10f, 2.5f)
            curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f)
            horizontalLineToRelative(-3f)
            curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f)
            close()
            moveTo(9f, 14f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
            verticalLineToRelative(-6f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(6f)
            close()
            moveTo(12f, 14f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
            verticalLineToRelative(-6f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(6f)
            close()
        }
        path(fill = primary) {
            moveTo(9f, 8f)
            curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
            reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f)
            verticalLineToRelative(6f)
            curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
            reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
            verticalLineToRelative(-6f)
            close()
            moveTo(11.5f, 7.5f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            verticalLineToRelative(6f)
            curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
            reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
            verticalLineToRelative(-6f)
            curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.delete(): ImageVector {
    return delete(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.delete(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return delete(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}
