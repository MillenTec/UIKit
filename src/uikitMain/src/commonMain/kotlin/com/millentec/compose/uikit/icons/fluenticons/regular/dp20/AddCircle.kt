package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.addCircle(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    val imageVector: ImageVector = ImageVector.Builder(
        name = "AddCircle",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(6f, 10f)
            curveToRelative(0f, -0.3f, 0.2f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(3f)
            verticalLineToRelative(-3f)
            curveToRelative(0f, -0.3f, 0.2f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.2f, 0.5f, 0.5f)
            verticalLineToRelative(3f)
            horizontalLineToRelative(3f)
            curveToRelative(0.3f, 0f, 0.5f, 0.2f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.2f, 0.5f, -0.5f, 0.5f)
            horizontalLineToRelative(-3f)
            verticalLineToRelative(3f)
            curveToRelative(0f, 0.3f, -0.2f, 0.5f, -0.5f, 0.5f)
            reflectiveCurveToRelative(-0.5f, -0.2f, -0.5f, -0.5f)
            verticalLineToRelative(-3f)
            horizontalLineToRelative(-3f)
            curveToRelative(-0.3f, 0f, -0.5f, -0.2f, -0.5f, -0.5f)
            close()
        }
        path(fill = secondary) {
            moveTo(10f, 2f)
            curveTo(5.6f, 2f, 2f, 5.6f, 2f, 10f)
            reflectiveCurveToRelative(3.6f, 8f, 8f, 8f)
            reflectiveCurveToRelative(8f, -3.6f, 8f, -8f)
            reflectiveCurveTo(14.4f, 2f, 10f, 2f)
            close()
            moveTo(10f, 17f)
            curveToRelative(-3.9f, 0f, -7f, -3.1f, -7f, -7f)
            reflectiveCurveToRelative(3.1f, -7f, 7f, -7f)
            reflectiveCurveToRelative(7f, 3.1f, 7f, 7f)
            reflectiveCurveToRelative(-3.1f, 7f, -7f, 7f)
            close()
        }
    }.build()

    return imageVector
}

fun FluentIcons.addCircle(): ImageVector {
    return addCircle(SolidColor(Color(0xFF1D1D1F)), SolidColor(Color(0xFF212122)))
}

fun FluentIcons.addCircle(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return addCircle(SolidColor(color), if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color))
}