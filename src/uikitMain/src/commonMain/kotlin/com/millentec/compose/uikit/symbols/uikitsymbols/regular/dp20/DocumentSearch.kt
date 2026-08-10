package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.documentSearch(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "DocumentSearch",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(5.5f, 17f)
            curveTo(6.286f, 17f, 7.012f, 16.741f, 7.596f, 16.303f)
            lineTo(10.146f, 18.854f)
            curveTo(10.342f, 19.049f, 10.658f, 19.049f, 10.854f, 18.854f)
            curveTo(11.049f, 18.658f, 11.049f, 18.342f, 10.854f, 18.146f)
            lineTo(8.303f, 15.596f)
            curveTo(8.741f, 15.012f, 9f, 14.286f, 9f, 13.5f)
            curveTo(9f, 11.567f, 7.433f, 10f, 5.5f, 10f)
            curveTo(3.567f, 10f, 2f, 11.567f, 2f, 13.5f)
            curveTo(2f, 15.433f, 3.567f, 17f, 5.5f, 17f)
            close()
            moveTo(5.5f, 16f)
            curveTo(4.119f, 16f, 3f, 14.881f, 3f, 13.5f)
            curveTo(3f, 12.119f, 4.119f, 11f, 5.5f, 11f)
            curveTo(6.881f, 11f, 8f, 12.119f, 8f, 13.5f)
            curveTo(8f, 14.881f, 6.881f, 16f, 5.5f, 16f)
            close()
        }
        path(fill = secondary) {
            moveTo(4f, 4f)
            curveTo(4f, 2.895f, 4.895f, 2f, 6f, 2f)
            horizontalLineTo(10.586f)
            curveTo(10.984f, 2f, 11.365f, 2.158f, 11.646f, 2.439f)
            lineTo(15.561f, 6.354f)
            curveTo(15.842f, 6.635f, 16f, 7.016f, 16f, 7.414f)
            verticalLineTo(16f)
            curveTo(16f, 17.105f, 15.105f, 18f, 14f, 18f)
            horizontalLineTo(11.915f)
            curveTo(11.842f, 17.795f, 11.724f, 17.603f, 11.561f, 17.439f)
            lineTo(11.121f, 17f)
            horizontalLineTo(14f)
            curveTo(14.552f, 17f, 15f, 16.552f, 15f, 16f)
            verticalLineTo(8f)
            horizontalLineTo(11.5f)
            curveTo(10.672f, 8f, 10f, 7.328f, 10f, 6.5f)
            verticalLineTo(3f)
            horizontalLineTo(6f)
            curveTo(5.448f, 3f, 5f, 3.448f, 5f, 4f)
            verticalLineTo(9.027f)
            curveTo(4.653f, 9.066f, 4.318f, 9.144f, 4f, 9.256f)
            verticalLineTo(4f)
            close()
            moveTo(11.5f, 7f)
            horizontalLineTo(14.793f)
            lineTo(11f, 3.207f)
            verticalLineTo(6.5f)
            curveTo(11f, 6.776f, 11.224f, 7f, 11.5f, 7f)
            close()
        }
    }.build()
}

fun UIKitSymbols.documentSearch(): ImageVector {
    return documentSearch(SolidColor(Color(0xFF1D1D1F)), SolidColor(Color(0xFF212122)))
}

fun UIKitSymbols.documentSearch(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return documentSearch(SolidColor(color), if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color))
}