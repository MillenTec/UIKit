package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.warningCircle(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "WarningCircle",
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
            moveTo(10f, 12.5f)
            curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f)
            reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f)
            reflectiveCurveToRelative(-0.75f, -0.34f, -0.75f, -0.75f)
            reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f)
            close()
            moveTo(10f, 6f)
            curveToRelative(0.25f, 0f, 0.45f, 0.18f, 0.49f, 0.41f)
            verticalLineToRelative(0.09f)
            reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            curveToRelative(-0.25f, 0f, -0.45f, -0.18f, -0.49f, -0.41f)
            verticalLineToRelative(-0.09f)
            reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
        }
    }.build()
}

fun FluentIcons.warningCircle(): ImageVector {
    return warningCircle(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.warningCircle(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return warningCircle(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}