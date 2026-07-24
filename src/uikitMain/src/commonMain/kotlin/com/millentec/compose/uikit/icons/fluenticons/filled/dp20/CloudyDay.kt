package com.millentec.compose.uikit.icons.fluenticons.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.cloudyDay(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "CloudyDay",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(11f, 7f)
            curveToRelative(2.46f, 0f, 3.86f, 1.57f, 4.07f, 3.47f)
            horizontalLineToRelative(0.06f)
            curveToRelative(1.59f, 0f, 2.87f, 1.24f, 2.87f, 2.76f)
            reflectiveCurveToRelative(-1.29f, 2.76f, -2.87f, 2.76f)
            horizontalLineTo(6.87f)
            curveToRelative(-1.59f, 0f, -2.87f, -1.24f, -2.87f, -2.76f)
            reflectiveCurveToRelative(1.29f, -2.76f, 2.87f, -2.76f)
            horizontalLineToRelative(0.06f)
            curveToRelative(0.2f, -1.91f, 1.6f, -3.47f, 4.07f, -3.47f)
            close()
        }
        path(fill = secondary) {
            moveTo(3.8f, 9.7f)
            curveToRelative(0.08f, 0.23f, -0.02f, 0.48f, -0.23f, 0.6f)
            lineToRelative(-0.08f, 0.04f)
            lineToRelative(-0.8f, 0.28f)
            curveToRelative(-0.26f, 0.09f, -0.55f, -0.05f, -0.64f, -0.31f)
            curveToRelative(-0.08f, -0.23f, 0.02f, -0.48f, 0.23f, -0.6f)
            lineToRelative(0.08f, -0.04f)
            lineToRelative(0.8f, -0.28f)
            curveToRelative(0.26f, -0.09f, 0.55f, 0.05f, 0.64f, 0.31f)
            close()
            moveTo(8.92f, 5.5f)
            curveToRelative(0.33f, 0.16f, 0.62f, 0.37f, 0.87f, 0.62f)
            curveToRelative(-1.76f, 0.36f, -3.03f, 1.53f, -3.54f, 3.16f)
            lineToRelative(-0.07f, 0.22f)
            lineToRelative(-0.05f, 0.19f)
            lineToRelative(-0.17f, 0.03f)
            curveToRelative(-0.45f, 0.09f, -0.87f, 0.27f, -1.25f, 0.5f)
            curveToRelative(-0.6f, -0.93f, -0.71f, -2.14f, -0.19f, -3.21f)
            curveToRelative(0.79f, -1.63f, 2.76f, -2.3f, 4.39f, -1.51f)
            close()
            moveTo(2.92f, 5.67f)
            lineToRelative(0.08f, 0.03f)
            lineToRelative(0.76f, 0.37f)
            curveToRelative(0.25f, 0.12f, 0.35f, 0.42f, 0.23f, 0.67f)
            curveToRelative(-0.11f, 0.22f, -0.36f, 0.33f, -0.58f, 0.26f)
            lineToRelative(-0.08f, -0.03f)
            lineToRelative(-0.76f, -0.37f)
            curveToRelative(-0.25f, -0.12f, -0.35f, -0.42f, -0.23f, -0.67f)
            curveToRelative(0.11f, -0.22f, 0.36f, -0.33f, 0.58f, -0.26f)
            close()
            moveTo(9.99f, 3.3f)
            curveToRelative(0.22f, 0.11f, 0.33f, 0.36f, 0.26f, 0.58f)
            lineToRelative(-0.03f, 0.08f)
            lineToRelative(-0.37f, 0.76f)
            curveToRelative(-0.12f, 0.25f, -0.42f, 0.35f, -0.67f, 0.23f)
            curveToRelative(-0.22f, -0.11f, -0.33f, -0.36f, -0.26f, -0.58f)
            lineToRelative(0.03f, -0.08f)
            lineToRelative(0.37f, -0.76f)
            curveToRelative(0.12f, -0.25f, 0.42f, -0.35f, 0.67f, -0.23f)
            close()
            moveTo(6.2f, 3.26f)
            lineToRelative(0.04f, 0.08f)
            lineToRelative(0.28f, 0.8f)
            curveToRelative(0.09f, 0.26f, -0.05f, 0.55f, -0.31f, 0.64f)
            curveToRelative(-0.23f, 0.08f, -0.48f, -0.02f, -0.6f, -0.23f)
            lineToRelative(-0.04f, -0.08f)
            lineToRelative(-0.28f, -0.8f)
            curveToRelative(-0.09f, -0.26f, 0.05f, -0.55f, 0.31f, -0.64f)
            curveToRelative(0.23f, -0.08f, 0.48f, 0.02f, 0.6f, 0.23f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.cloudyDay(): ImageVector {
    return cloudyDay(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.Filled.cloudyDay(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return cloudyDay(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
