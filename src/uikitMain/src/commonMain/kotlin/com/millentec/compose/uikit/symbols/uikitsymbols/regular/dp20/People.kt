package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.people(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "People",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(6.75f, 3.5f)
            curveToRelative(-1.79f, 0f, -3.25f, 1.46f, -3.25f, 3.25f)
            reflectiveCurveToRelative(1.46f, 3.25f, 3.25f, 3.25f)
            reflectiveCurveToRelative(3.25f, -1.46f, 3.25f, -3.25f)
            reflectiveCurveToRelative(-1.46f, -3.25f, -3.25f, -3.25f)
            close()
            moveTo(6.75f, 9f)
            curveToRelative(-1.24f, 0f, -2.25f, -1.01f, -2.25f, -2.25f)
            reflectiveCurveToRelative(1.01f, -2.25f, 2.25f, -2.25f)
            reflectiveCurveToRelative(2.25f, 1.01f, 2.25f, 2.25f)
            reflectiveCurveToRelative(-1.01f, 2.25f, -2.25f, 2.25f)
            close()
            moveTo(10f, 11f)
            horizontalLineTo(3.5f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(0.06f)
            horizontalLineToRelative(0f)
            reflectiveCurveToRelative(0f, 0f, 0f, 0f)
            horizontalLineToRelative(0f)
            reflectiveCurveToRelative(0f, 0.04f, 0f, 0.05f)
            curveToRelative(0f, 0.03f, 0f, 0.08f, 0.01f, 0.14f)
            curveToRelative(0.01f, 0.11f, 0.03f, 0.27f, 0.08f, 0.45f)
            curveToRelative(0.08f, 0.37f, 0.25f, 0.86f, 0.6f, 1.35f)
            curveToRelative(0.7f, 1.01f, 2.05f, 1.93f, 4.57f, 1.93f)
            reflectiveCurveToRelative(3.87f, -0.92f, 4.57f, -1.93f)
            curveToRelative(0.34f, -0.49f, 0.51f, -0.99f, 0.6f, -1.35f)
            curveToRelative(0.04f, -0.18f, 0.06f, -0.34f, 0.08f, -0.45f)
            curveToRelative(0f, -0.06f, 0f, -0.1f, 0.01f, -0.14f)
            curveToRelative(0f, -0.02f, 0f, -0.03f, 0f, -0.04f)
            horizontalLineToRelative(0f)
            verticalLineToRelative(-0.02f)
            horizontalLineToRelative(0f)
            verticalLineToRelative(-0.07f)
            curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
            close()
            moveTo(11f, 13.06f)
            horizontalLineToRelative(0f)
            reflectiveCurveToRelative(0f, 0.02f, 0f, 0.02f)
            curveToRelative(0f, 0.02f, 0f, 0.05f, 0f, 0.08f)
            curveToRelative(0f, 0.08f, -0.02f, 0.19f, -0.05f, 0.33f)
            curveToRelative(-0.06f, 0.28f, -0.19f, 0.64f, -0.44f, 1.01f)
            curveToRelative(-0.49f, 0.7f, -1.51f, 1.5f, -3.74f, 1.5f)
            reflectiveCurveToRelative(-3.26f, -0.8f, -3.74f, -1.5f)
            curveToRelative(-0.25f, -0.37f, -0.38f, -0.73f, -0.44f, -1.01f)
            curveToRelative(-0.03f, -0.14f, -0.05f, -0.25f, -0.05f, -0.33f)
            curveToRelative(0f, -0.04f, 0f, -0.07f, 0f, -0.08f)
            verticalLineToRelative(-0.02f)
            reflectiveCurveToRelative(0f, 0f, 0f, 0f)
            verticalLineToRelative(-0.06f)
            curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
            horizontalLineToRelative(6.5f)
            curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
            verticalLineToRelative(0.06f)
            close()
        }
        path(fill = secondary) {
            moveTo(12.44f, 15.15f)
            curveToRelative(0.54f, 0.22f, 1.22f, 0.35f, 2.06f, 0.35f)
            curveToRelative(1.88f, 0f, 2.92f, -0.67f, 3.47f, -1.43f)
            curveToRelative(0.26f, -0.37f, 0.4f, -0.74f, 0.46f, -1.02f)
            curveToRelative(0.03f, -0.14f, 0.05f, -0.26f, 0.06f, -0.34f)
            curveToRelative(0f, -0.04f, 0f, -0.08f, 0f, -0.1f)
            curveToRelative(0f, -0.01f, 0f, -0.02f, 0f, -0.03f)
            horizontalLineToRelative(0f)
            verticalLineToRelative(-0.02f)
            horizontalLineToRelative(0f)
            verticalLineToRelative(-0.05f)
            curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f)
            horizontalLineToRelative(-4.63f)
            curveToRelative(0.24f, 0.29f, 0.42f, 0.63f, 0.53f, 1f)
            horizontalLineToRelative(4.1f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            verticalLineToRelative(0.05f)
            horizontalLineToRelative(0f)
            reflectiveCurveToRelative(0f, 0.03f, 0f, 0.06f)
            curveToRelative(0f, 0.05f, -0.02f, 0.12f, -0.04f, 0.21f)
            curveToRelative(-0.04f, 0.18f, -0.13f, 0.43f, -0.3f, 0.67f)
            curveToRelative(-0.33f, 0.46f, -1.04f, 1.02f, -2.66f, 1.02f)
            curveToRelative(-0.73f, 0f, -1.28f, -0.11f, -1.69f, -0.28f)
            curveToRelative(-0.08f, 0.28f, -0.2f, 0.6f, -0.38f, 0.93f)
            close()
            moveTo(14.5f, 5f)
            curveToRelative(-1.38f, 0f, -2.5f, 1.12f, -2.5f, 2.5f)
            reflectiveCurveToRelative(1.12f, 2.5f, 2.5f, 2.5f)
            reflectiveCurveToRelative(2.5f, -1.12f, 2.5f, -2.5f)
            reflectiveCurveToRelative(-1.12f, -2.5f, -2.5f, -2.5f)
            close()
            moveTo(14.5f, 9f)
            curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f)
            reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f)
            reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f)
            reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f)
            close()
        }
    }.build()
}

fun UIKitSymbols.people(): ImageVector {
    return people(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.people(
    color: Color,
    layered: Boolean
): ImageVector {
    return people(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
}