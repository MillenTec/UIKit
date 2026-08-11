package com.millentec.compose.uikit.icons.fluenticons.resizeable

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.ResizableIcons.shapes(
    primary: Brush,
    secondary: Brush,
    lineWidth: Float
): ImageVector {
    return ImageVector.Builder(
        name = "Shapes",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(
            stroke = secondary,
            strokeLineWidth = lineWidth
        ) {
            moveTo(7f, 12.48f)
            curveToRelative(-2.53f, -0.25f, -4.5f, -2.38f, -4.5f, -4.98f)
            curveToRelative(0f, -2.76f, 2.24f, -5f, 5f, -5f)
            curveToRelative(2.59f, 0f, 4.72f, 1.97f, 4.98f, 4.5f)
        }
        path(
            stroke = primary,
            strokeLineWidth = lineWidth
        ) {
            moveTo(10.5f, 8.5f)
            lineTo(15.5f, 8.5f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 17.5f, 10.5f)
            lineTo(17.5f, 15.5f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 15.5f, 17.5f)
            lineTo(10.5f, 17.5f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.5f, 15.5f)
            lineTo(8.5f, 10.5f)
            arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 10.5f, 8.5f)
            close()
        }
    }.build()
}

fun FluentIcons.ResizableIcons.shapes(
    lineWidth: Float = 1f
): ImageVector {
    return shapes(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
        lineWidth
    )
}

fun FluentIcons.ResizableIcons.shapes(
    color: Color,
    layered: Boolean = false,
    lineWidth: Float = 1f
): ImageVector {
    return shapes(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
        lineWidth
    )
}