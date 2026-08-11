package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.checkmarkCircle(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "CheckmarkCircle",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(10f, 2f)
            curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
            reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
            reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
            reflectiveCurveTo(14.42f, 2f, 10f, 2f)
            close()
            moveTo(10f, 17f)
            curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f)
            reflectiveCurveToRelative(3.13f, -7f, 7f, -7f)
            reflectiveCurveToRelative(7f, 3.13f, 7f, 7f)
            reflectiveCurveToRelative(-3.13f, 7f, -7f, 7f)
            close()
        }
        path(fill = primary) {
            moveTo(13.36f, 7.65f)
            curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
            lineToRelative(-0.06f, 0.07f)
            lineToRelative(-4f, 4f)
            curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
            lineToRelative(-0.07f, -0.06f)
            lineToRelative(-2f, -2f)
            curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
            curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
            lineToRelative(0.07f, 0.06f)
            lineToRelative(1.65f, 1.65f)
            lineToRelative(3.65f, -3.65f)
            curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
            close()
        }
    }.build()
}

fun FluentIcons.checkmarkCircle(): ImageVector {
    return checkmarkCircle(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.checkmarkCircle(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return checkmarkCircle(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}