package com.millentec.compose.uikit.icons.fluenticons.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.alertOff(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "AlertOff",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(17.85f, 17.85f)
            curveToRelative(-0.19f, 0.2f, -0.51f, 0.2f, -0.7f, 0f)
            lineToRelative(-1.5f, -1.49f)
            lineToRelative(-1.36f, -1.36f)
            lineTo(4.58f, 5.29f)
            lineToRelative(-1.01f, -1.02f)
            lineToRelative(-1.42f, -1.42f)
            curveToRelative(-0.2f, -0.19f, -0.2f, -0.51f, 0f, -0.7f)
            curveToRelative(0.19f, -0.2f, 0.51f, -0.2f, 0.7f, 0f)
            lineToRelative(15f, 15f)
            curveToRelative(0.2f, 0.19f, 0.2f, 0.51f, 0f, 0.7f)
            close()
        }
        path(fill = secondary) {
            moveTo(14.29f, 15f)
            horizontalLineTo(3.75f)
            curveToRelative(-0.09f, 0f, -0.17f, -0.01f, -0.26f, -0.04f)
            curveToRelative(-0.28f, -0.11f, -0.47f, -0.37f, -0.48f, -0.72f)
            verticalLineToRelative(-0.12f)
            lineToRelative(0.04f, -0.12f)
            lineToRelative(0.95f, -2.59f)
            verticalLineToRelative(-3.84f)
            curveToRelative(0.04f, -0.82f, 0.24f, -1.59f, 0.58f, -2.28f)
            lineToRelative(9.71f, 9.71f)
            close()
            moveTo(16.99f, 14.17f)
            lineToRelative(-0.02f, -0.09f)
            lineToRelative(-0.03f, -0.08f)
            lineToRelative(-0.95f, -2.59f)
            verticalLineToRelative(-3.61f)
            reflectiveCurveToRelative(0f, -0.22f, 0f, -0.22f)
            verticalLineToRelative(-0.22f)
            curveToRelative(-0.25f, -3.02f, -2.85f, -5.36f, -6f, -5.36f)
            curveToRelative(-1.64f, 0f, -3.13f, 0.63f, -4.21f, 1.66f)
            lineToRelative(11.05f, 11.05f)
            curveToRelative(0.11f, -0.13f, 0.16f, -0.29f, 0.16f, -0.46f)
            verticalLineToRelative(-0.09f)
            close()
            moveTo(7.55f, 16f)
            curveToRelative(0.23f, 1.14f, 1.24f, 2f, 2.45f, 2f)
            reflectiveCurveToRelative(2.22f, -0.86f, 2.45f, -2f)
            horizontalLineToRelative(-4.9f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.alertOff(): ImageVector {
    return alertOff(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.Filled.alertOff(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return alertOff(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
