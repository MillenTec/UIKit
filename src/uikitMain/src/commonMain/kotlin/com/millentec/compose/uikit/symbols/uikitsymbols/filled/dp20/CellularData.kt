package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.cellularData(
    primary: Brush,
    secondary: Brush,
    tertiary: Brush,
    fourth: Brush,
    fifth: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "CellularData",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = fifth) {
            moveTo(16.75f, 4f)
            curveToRelative(0.37f, 0f, 0.68f, 0.27f, 0.74f, 0.63f)
            verticalLineToRelative(0.11f)
            reflectiveCurveToRelative(0f, 10.52f, 0f, 10.52f)
            curveToRelative(0f, 0.41f, -0.33f, 0.75f, -0.74f, 0.75f)
            curveToRelative(-0.37f, 0f, -0.68f, -0.27f, -0.74f, -0.63f)
            verticalLineToRelative(-0.11f)
            reflectiveCurveToRelative(0f, -10.52f, 0f, -10.52f)
            curveToRelative(0f, -0.41f, 0.33f, -0.75f, 0.74f, -0.75f)
            close()
        }
        path(fill = secondary) {
            moveTo(7.75f, 10f)
            curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
            verticalLineToRelative(0.11f)
            reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
            curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
            curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
            verticalLineToRelative(-0.11f)
            reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
            curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
            close()
        }
        path(fill = primary) {
            moveTo(4.75f, 12f)
            curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
            verticalLineToRelative(0.11f)
            reflectiveCurveToRelative(0f, 2.5f, 0f, 2.5f)
            curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
            curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
            verticalLineToRelative(-0.11f)
            reflectiveCurveToRelative(0f, -2.5f, 0f, -2.5f)
            curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
            close()
        }
        path(fill = tertiary) {
            moveTo(10.75f, 8f)
            curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
            verticalLineToRelative(0.11f)
            reflectiveCurveToRelative(0f, 6.5f, 0f, 6.5f)
            curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
            curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
            verticalLineToRelative(-0.11f)
            reflectiveCurveToRelative(0f, -6.5f, 0f, -6.5f)
            curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
            close()
        }
        path(fill = fourth) {
            moveTo(13.75f, 6f)
            curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
            verticalLineToRelative(0.11f)
            reflectiveCurveToRelative(0f, 8.5f, 0f, 8.5f)
            curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
            curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
            verticalLineToRelative(-0.11f)
            reflectiveCurveToRelative(0f, -8.5f, 0f, -8.5f)
            curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.cellularData(): ImageVector {
    return cellularData(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.cellularData(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return cellularData(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.45f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color),
    )
}
