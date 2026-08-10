package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.share(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "Share",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(9.5f, 3f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
            horizontalLineToRelative(-3.5f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(8f)
            curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
            horizontalLineToRelative(8f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            verticalLineToRelative(-1.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(1.5f)
            curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f)
            horizontalLineToRelative(-8f)
            curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f)
            verticalLineToRelative(-8f)
            curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f)
            horizontalLineToRelative(3.5f)
            close()
        }
        path(fill = primary) {
            moveTo(18.83f, 6.63f)
            lineToRelative(-5f, -4.5f)
            curveToRelative(-0.15f, -0.13f, -0.36f, -0.17f, -0.54f, -0.08f)
            curveToRelative(-0.16f, 0.07f, -0.27f, 0.22f, -0.29f, 0.38f)
            verticalLineToRelative(0.07f)
            reflectiveCurveToRelative(0f, 2.01f, 0f, 2.01f)
            curveToRelative(-2.63f, 0.13f, -4.39f, 1.3f, -5.48f, 2.96f)
            curveToRelative(-1.14f, 1.74f, -1.52f, 3.98f, -1.52f, 6.02f)
            curveToRelative(0f, 0.23f, 0.16f, 0.43f, 0.38f, 0.49f)
            curveToRelative(0.23f, 0.05f, 0.46f, -0.06f, 0.56f, -0.26f)
            lineToRelative(0.16f, -0.29f)
            curveToRelative(0.42f, -0.72f, 1.18f, -1.67f, 2.19f, -2.48f)
            curveToRelative(1.03f, -0.83f, 2.3f, -1.48f, 3.7f, -1.61f)
            verticalLineToRelative(2.16f)
            curveToRelative(0f, 0.2f, 0.12f, 0.38f, 0.3f, 0.46f)
            curveToRelative(0.18f, 0.08f, 0.39f, 0.05f, 0.54f, -0.09f)
            lineToRelative(5f, -4.5f)
            curveToRelative(0.11f, -0.09f, 0.16f, -0.23f, 0.16f, -0.37f)
            reflectiveCurveToRelative(-0.06f, -0.28f, -0.16f, -0.37f)
            close()
            moveTo(14f, 10.38f)
            verticalLineToRelative(-1.56f)
            curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
            curveToRelative(-1.9f, 0f, -3.56f, 0.84f, -4.83f, 1.85f)
            curveToRelative(-0.61f, 0.48f, -1.13f, 1.02f, -1.56f, 1.54f)
            curveToRelative(0.17f, -1.34f, 0.56f, -2.64f, 1.25f, -3.68f)
            curveToRelative(0.97f, -1.48f, 2.56f, -2.52f, 5.14f, -2.52f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            verticalLineToRelative(-1.38f)
            lineToRelative(3.75f, 3.38f)
            lineToRelative(-3.75f, 3.38f)
            close()
        }
    }.build()
}

fun UIKitSymbols.share(): ImageVector {
    return share(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.share(
    color: Color,
    layered: Boolean
): ImageVector {
    return share(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}