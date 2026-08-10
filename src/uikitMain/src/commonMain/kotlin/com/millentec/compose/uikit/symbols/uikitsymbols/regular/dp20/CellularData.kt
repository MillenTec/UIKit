package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.cellularData(
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
            moveTo(16.5f, 4f)
            curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 11f, 0f, 11f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -11f, 0f, -11f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
        }
        path(fill = secondary) {
            moveTo(7.5f, 10f)
            curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 5f, 0f, 5f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -5f, 0f, -5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
        }
        path(fill = primary) {
            moveTo(4.5f, 12f)
            curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 3f, 0f, 3f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -3f, 0f, -3f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
        }
        path(fill = tertiary) {
            moveTo(10.5f, 8f)
            curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 7f, 0f, 7f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -7f, 0f, -7f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
        }
        path(fill = fourth) {
            moveTo(13.5f, 6f)
            curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 9f, 0f, 9f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -9f, 0f, -9f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
        }
    }.build()
}

fun UIKitSymbols.cellularData(): ImageVector {
    return cellularData(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.cellularData(
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
