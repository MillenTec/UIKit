package com.millentec.compose.uikit.icons.fluenticons.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

fun FluentIcons.Filled.sunny(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "Sunny",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(10f, 10f)
            moveToRelative(-4f, 0f)
            arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, 8f, 0f)
            arcToRelative(4f, 4f, 0f, isMoreThanHalf = true, isPositiveArc = true, -8f, 0f)
        }
        path(fill = secondary) {
            moveTo(10f, 2f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(1f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
            verticalLineToRelative(-1f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
            moveTo(17.5f, 10.5f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
            horizontalLineToRelative(-1f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(1f)
            close()
            moveTo(10f, 16f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(1f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
            verticalLineToRelative(-1f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            close()
            moveTo(3.5f, 10.5f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
            horizontalLineToRelative(-1.04f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(1.04f)
            close()
            moveTo(4.15f, 4.15f)
            curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
            lineToRelative(1f, 1f)
            curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
            curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
            lineToRelative(-1f, -1f)
            curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
            close()
            moveTo(4.85f, 15.85f)
            curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
            curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
            lineToRelative(1f, -1f)
            curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
            curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
            lineToRelative(-1f, 1f)
            close()
            moveTo(15.85f, 4.15f)
            curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f)
            lineToRelative(-1f, 1f)
            curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f)
            curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f)
            lineToRelative(1f, -1f)
            curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f)
            close()
            moveTo(15.15f, 15.85f)
            curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f)
            curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f)
            lineToRelative(-1f, -1f)
            curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f)
            curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f)
            lineToRelative(1f, 1f)
            close()
        }
    }.build()
}

fun FluentIcons.Filled.sunny(): ImageVector {
    return sunny(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun FluentIcons.Filled.sunny(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return sunny(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}
