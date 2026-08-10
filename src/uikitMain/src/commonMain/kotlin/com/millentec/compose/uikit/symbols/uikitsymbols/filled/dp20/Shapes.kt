package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.shapes(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Shapes",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(10.5f, 8f)
            curveTo(9.119f, 8f, 8f, 9.119f, 8f, 10.5f)
            verticalLineTo(15.5f)
            curveTo(8f, 16.881f, 9.119f, 18f, 10.5f, 18f)
            horizontalLineTo(15.5f)
            curveTo(16.881f, 18f, 18f, 16.881f, 18f, 15.5f)
            verticalLineTo(10.5f)
            curveTo(18f, 9.119f, 16.881f, 8f, 15.5f, 8f)
            horizontalLineTo(10.5f)
            close()
        }
        path(fill = secondary) {
            moveTo(2f, 7.5f)
            curveTo(2f, 4.462f, 4.462f, 2f, 7.5f, 2f)
            curveTo(10.369f, 2f, 12.725f, 4.197f, 12.978f, 7f)
            horizontalLineTo(10.5f)
            curveTo(8.567f, 7f, 7f, 8.567f, 7f, 10.5f)
            verticalLineTo(12.978f)
            curveTo(4.197f, 12.725f, 2f, 10.369f, 2f, 7.5f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.shapes(): ImageVector {
    return shapes(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.shapes(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return shapes(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}