package com.millentec.compose.uikit.icons.fluenticons.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.documentAdd(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "DocumentAdd",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(10f, 2f)
            verticalLineToRelative(4.5f)
            curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
            horizontalLineToRelative(4.5f)
            verticalLineToRelative(8.5f)
            curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f)
            horizontalLineToRelative(-4.76f)
            curveToRelative(0.79f, -0.95f, 1.26f, -2.17f, 1.26f, -3.5f)
            curveToRelative(0f, -3.04f, -2.46f, -5.5f, -5.5f, -5.5f)
            curveToRelative(-0.52f, 0f, -1.02f, 0.07f, -1.5f, 0.21f)
            verticalLineTo(3.5f)
            curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f)
            horizontalLineToRelative(4.5f)
            close()
            moveTo(11f, 2.25f)
            verticalLineToRelative(4.25f)
            curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(4.25f)
            lineToRelative(-4.75f, -4.75f)
            close()
        }
        path(fill = primary) {
            moveTo(5.5f, 10f)
            curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
            reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
            reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
            reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
            close()
            moveTo(7.5f, 15f)
            horizontalLineToRelative(-1.5f)
            verticalLineToRelative(1.5f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
            verticalLineToRelative(-1.5f)
            horizontalLineToRelative(-1.5f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(1.5f)
            verticalLineToRelative(-1.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(1.5f)
            horizontalLineToRelative(1.5f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.documentAdd(): ImageVector {
    return documentAdd(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.Filled.documentAdd(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return documentAdd(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
