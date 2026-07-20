package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.documentSearch(
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
            moveTo(10f, 6.5f)
            verticalLineTo(2f)
            horizontalLineTo(5.5f)
            curveTo(4.672f, 2f, 4f, 2.672f, 4f, 3.5f)
            verticalLineTo(9.256f)
            curveTo(4.469f, 9.09f, 4.974f, 9f, 5.5f, 9f)
            curveTo(7.985f, 9f, 10f, 11.015f, 10f, 13.5f)
            curveTo(10f, 14.195f, 9.843f, 14.853f, 9.561f, 15.44f)
            lineTo(11.561f, 17.439f)
            curveTo(11.724f, 17.603f, 11.842f, 17.795f, 11.915f, 18f)
            horizontalLineTo(14.5f)
            curveTo(15.328f, 18f, 16f, 17.328f, 16f, 16.5f)
            verticalLineTo(8f)
            horizontalLineTo(11.5f)
            curveTo(10.672f, 8f, 10f, 7.328f, 10f, 6.5f)
            close()
            moveTo(11f, 6.5f)
            verticalLineTo(2.25f)
            lineTo(15.75f, 7f)
            horizontalLineTo(11.5f)
            curveTo(11.224f, 7f, 11f, 6.776f, 11f, 6.5f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.documentSearch(): ImageVector {
    return documentSearch(SolidColor(Color(0xFF1D1D1F)), SolidColor(Color(0xFF212122)))
}

fun FluentIcons.Filled.documentSearch(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return documentSearch(SolidColor(color), if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color))
}