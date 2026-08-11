package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.upload(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "Upload",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(10.354f, 2.146f)
            curveTo(10.158f, 1.951f, 9.842f, 1.951f, 9.646f, 2.146f)
            lineTo(5.146f, 6.646f)
            curveTo(4.951f, 6.842f, 4.951f, 7.158f, 5.146f, 7.354f)
            curveTo(5.342f, 7.549f, 5.658f, 7.549f, 5.854f, 7.354f)
            lineTo(9.5f, 3.707f)
            verticalLineTo(12.5f)
            curveTo(9.5f, 12.776f, 9.724f, 13f, 10f, 13f)
            curveTo(10.276f, 13f, 10.5f, 12.776f, 10.5f, 12.5f)
            verticalLineTo(3.707f)
            lineTo(14.146f, 7.354f)
            curveTo(14.342f, 7.549f, 14.658f, 7.549f, 14.854f, 7.354f)
            curveTo(15.049f, 7.158f, 15.049f, 6.842f, 14.854f, 6.646f)
            lineTo(10.354f, 2.146f)
            close()
        }
        path(fill = secondary) {
            moveTo(4f, 9.5f)
            curveTo(4f, 9.224f, 3.776f, 9f, 3.5f, 9f)
            curveTo(3.224f, 9f, 3f, 9.224f, 3f, 9.5f)
            verticalLineTo(14f)
            curveTo(3f, 15.657f, 4.343f, 17f, 6f, 17f)
            horizontalLineTo(14f)
            curveTo(15.657f, 17f, 17f, 15.657f, 17f, 14f)
            verticalLineTo(9.5f)
            curveTo(17f, 9.224f, 16.776f, 9f, 16.5f, 9f)
            curveTo(16.224f, 9f, 16f, 9.224f, 16f, 9.5f)
            verticalLineTo(14f)
            curveTo(16f, 15.105f, 15.105f, 16f, 14f, 16f)
            horizontalLineTo(6f)
            curveTo(4.895f, 16f, 4f, 15.105f, 4f, 14f)
            verticalLineTo(9.5f)
            close()
        }
    }.build()
}

fun FluentIcons.upload(): ImageVector {
    return upload(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.upload(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return upload(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}