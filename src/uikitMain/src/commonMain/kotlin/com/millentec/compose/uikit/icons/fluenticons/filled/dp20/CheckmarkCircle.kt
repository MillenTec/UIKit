package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.checkmarkCircle(
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
            moveTo(13.42f, 8.28f)
            lineToRelative(-0.06f, 0.07f)
            lineToRelative(-4f, 4f)
            lineToRelative(-0.07f, 0.06f)
            curveToRelative(-0.17f, 0.12f, -0.4f, 0.12f, -0.57f, 0f)
            lineToRelative(-0.07f, -0.06f)
            lineToRelative(-2f, -2f)
            lineToRelative(-0.06f, -0.07f)
            curveToRelative(-0.13f, -0.19f, -0.12f, -0.46f, 0.06f, -0.64f)
            curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
            lineToRelative(0.07f, 0.06f)
            lineToRelative(1.65f, 1.65f)
            lineToRelative(3.65f, -3.65f)
            lineToRelative(0.07f, -0.06f)
            curveToRelative(0.19f, -0.13f, 0.46f, -0.12f, 0.64f, 0.06f)
            reflectiveCurveToRelative(0.19f, 0.44f, 0.06f, 0.64f)
            close()
        }
        path(fill = primary) {
            moveTo(13.36f, 7.65f)
            curveToRelative(-0.17f, -0.17f, -0.44f, -0.19f, -0.64f, -0.06f)
            lineToRelative(-0.07f, 0.06f)
            lineToRelative(-3.65f, 3.65f)
            lineToRelative(-1.65f, -1.65f)
            lineToRelative(-0.07f, -0.06f)
            curveToRelative(-0.19f, -0.14f, -0.46f, -0.12f, -0.64f, 0.06f)
            curveToRelative(-0.17f, 0.17f, -0.19f, 0.44f, -0.06f, 0.64f)
            lineToRelative(0.06f, 0.07f)
            lineToRelative(2f, 2f)
            lineToRelative(0.07f, 0.06f)
            curveToRelative(0.17f, 0.12f, 0.4f, 0.12f, 0.57f, 0f)
            lineToRelative(0.07f, -0.06f)
            lineToRelative(4f, -4f)
            lineToRelative(0.06f, -0.07f)
            curveToRelative(0.14f, -0.19f, 0.12f, -0.46f, -0.06f, -0.64f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.checkmarkCircle(): ImageVector {
    return checkmarkCircle(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.Filled.checkmarkCircle(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return checkmarkCircle(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}