package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.options(
    primary: Brush,
    secondary: Brush
): ImageVector {
    val imageVector: ImageVector = ImageVector.Builder(
        name = "Options",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(10f, 5.5f)
            curveToRelative(0f, 0.17f, 0.02f, 0.34f, 0.05f, 0.5f)
            horizontalLineTo(2.5f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(7.55f)
            curveToRelative(-0.03f, 0.16f, -0.05f, 0.33f, -0.05f, 0.5f)
            close()
            moveTo(17.5f, 5f)
            horizontalLineToRelative(-2.55f)
            curveToRelative(0.03f, 0.16f, 0.05f, 0.33f, 0.05f, 0.5f)
            reflectiveCurveToRelative(-0.02f, 0.34f, -0.05f, 0.5f)
            horizontalLineToRelative(2.55f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
            close()
            moveTo(10f, 14.5f)
            curveToRelative(0f, 0.17f, -0.02f, 0.34f, -0.05f, 0.5f)
            horizontalLineToRelative(7.55f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
            horizontalLineToRelative(-7.55f)
            curveToRelative(0.03f, 0.16f, 0.05f, 0.33f, 0.05f, 0.5f)
            close()
            moveTo(2f, 14.5f)
            curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(2.55f)
            curveToRelative(-0.03f, -0.16f, -0.05f, -0.33f, -0.05f, -0.5f)
            reflectiveCurveToRelative(0.02f, -0.34f, 0.05f, -0.5f)
            horizontalLineToRelative(-2.55f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            close()
        }
        path(fill = primary) {
            moveTo(14.95f, 5f)
            curveToRelative(-0.23f, -1.14f, -1.24f, -2f, -2.45f, -2f)
            reflectiveCurveToRelative(-2.22f, 0.86f, -2.45f, 2f)
            curveToRelative(-0.03f, 0.16f, -0.05f, 0.33f, -0.05f, 0.5f)
            reflectiveCurveToRelative(0.02f, 0.34f, 0.05f, 0.5f)
            curveToRelative(0.23f, 1.14f, 1.24f, 2f, 2.45f, 2f)
            reflectiveCurveToRelative(2.22f, -0.86f, 2.45f, -2f)
            curveToRelative(0.03f, -0.16f, 0.05f, -0.33f, 0.05f, -0.5f)
            reflectiveCurveToRelative(-0.02f, -0.34f, -0.05f, -0.5f)
            close()
            moveTo(12.5f, 7f)
            curveToRelative(-0.65f, 0f, -1.21f, -0.42f, -1.41f, -1f)
            curveToRelative(-0.06f, -0.16f, -0.09f, -0.32f, -0.09f, -0.5f)
            reflectiveCurveToRelative(0.03f, -0.34f, 0.09f, -0.5f)
            curveToRelative(0.2f, -0.58f, 0.76f, -1f, 1.41f, -1f)
            reflectiveCurveToRelative(1.21f, 0.42f, 1.41f, 1f)
            curveToRelative(0.06f, 0.16f, 0.09f, 0.32f, 0.09f, 0.5f)
            reflectiveCurveToRelative(-0.03f, 0.34f, -0.09f, 0.5f)
            curveToRelative(-0.2f, 0.58f, -0.76f, 1f, -1.41f, 1f)
            close()
            moveTo(5f, 14.5f)
            curveToRelative(0f, 0.17f, 0.02f, 0.34f, 0.05f, 0.5f)
            curveToRelative(0.23f, 1.14f, 1.24f, 2f, 2.45f, 2f)
            reflectiveCurveToRelative(2.22f, -0.86f, 2.45f, -2f)
            curveToRelative(0.03f, -0.16f, 0.05f, -0.33f, 0.05f, -0.5f)
            curveToRelative(0f, -0.17f, -0.02f, -0.34f, -0.05f, -0.5f)
            curveToRelative(-0.23f, -1.14f, -1.24f, -2f, -2.45f, -2f)
            reflectiveCurveToRelative(-2.22f, 0.86f, -2.45f, 2f)
            curveToRelative(-0.03f, 0.16f, -0.05f, 0.33f, -0.05f, 0.5f)
            close()
            moveTo(6.09f, 15f)
            curveToRelative(-0.06f, -0.16f, -0.09f, -0.32f, -0.09f, -0.5f)
            curveToRelative(0f, -0.18f, 0.03f, -0.34f, 0.09f, -0.5f)
            curveToRelative(0.2f, -0.58f, 0.76f, -1f, 1.41f, -1f)
            reflectiveCurveToRelative(1.21f, 0.42f, 1.41f, 1f)
            curveToRelative(0.06f, 0.16f, 0.09f, 0.32f, 0.09f, 0.5f)
            curveToRelative(0f, 0.18f, -0.03f, 0.34f, -0.09f, 0.5f)
            curveToRelative(-0.2f, 0.58f, -0.76f, 1f, -1.41f, 1f)
            reflectiveCurveToRelative(-1.21f, -0.42f, -1.41f, -1f)
            close()
        }
    }.build()

    return imageVector
}

fun FluentIcons.options(): ImageVector {
    return options(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.options(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return options(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}