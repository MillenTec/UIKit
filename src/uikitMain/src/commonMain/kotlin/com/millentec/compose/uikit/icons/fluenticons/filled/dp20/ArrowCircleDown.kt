package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.arrowCircleDown(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "ArrowCircleDown",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(13.35f, 10.85f)
            curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f)
            curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f)
            lineToRelative(-2.15f, 2.15f)
            verticalLineToRelative(-5.79f)
            curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
            reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f)
            verticalLineToRelative(5.79f)
            lineToRelative(-2.15f, -2.15f)
            curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f)
            curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f)
            lineToRelative(3f, 3f)
            curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f)
            lineToRelative(3f, -3f)
            close()
        }
        path(fill = secondary) {
            moveTo(10f, 2f)
            curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
            reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
            reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
            reflectiveCurveTo(14.42f, 2f, 10f, 2f)
            close()
            moveTo(13.35f, 10.85f)
            lineToRelative(-3f, 3f)
            curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
            lineToRelative(-3f, -3f)
            curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
            curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
            lineToRelative(2.15f, 2.15f)
            verticalLineToRelative(-5.79f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(5.79f)
            lineToRelative(2.15f, -2.15f)
            curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
            reflectiveCurveToRelative(0.2f, 0.51f, 0f, 0.71f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.arrowCircleDown(): ImageVector {
    return arrowCircleDown(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.Filled.arrowCircleDown(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return arrowCircleDown(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}