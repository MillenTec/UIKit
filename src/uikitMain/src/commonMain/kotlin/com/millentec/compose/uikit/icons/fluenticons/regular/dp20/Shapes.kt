package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.shapes(
    primary: Brush,
    secondary: Brush
): ImageVector {
    val imageVector: ImageVector = ImageVector.Builder(
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
            moveTo(9f, 10.5f)
            curveTo(9f, 9.672f, 9.672f, 9f, 10.5f, 9f)
            horizontalLineTo(15.5f)
            curveTo(16.328f, 9f, 17f, 9.672f, 17f, 10.5f)
            verticalLineTo(15.5f)
            curveTo(17f, 16.328f, 16.328f, 17f, 15.5f, 17f)
            horizontalLineTo(10.5f)
            curveTo(9.672f, 17f, 9f, 16.328f, 9f, 15.5f)
            verticalLineTo(10.5f)
            close()
        }
        path(fill = secondary) {
            moveTo(7.5f, 3f)
            curveTo(5.015f, 3f, 3f, 5.015f, 3f, 7.5f)
            curveTo(3f, 9.816f, 4.75f, 11.724f, 7f, 11.972f)
            verticalLineTo(12.978f)
            curveTo(4.197f, 12.725f, 2f, 10.369f, 2f, 7.5f)
            curveTo(2f, 4.462f, 4.462f, 2f, 7.5f, 2f)
            curveTo(10.369f, 2f, 12.725f, 4.197f, 12.978f, 7f)
            horizontalLineTo(11.972f)
            curveTo(11.724f, 4.75f, 9.816f, 3f, 7.5f, 3f)
            close()
        }
    }.build()

    return imageVector
}

fun FluentIcons.shapes(): ImageVector {
    return shapes(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.shapes(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return shapes(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}