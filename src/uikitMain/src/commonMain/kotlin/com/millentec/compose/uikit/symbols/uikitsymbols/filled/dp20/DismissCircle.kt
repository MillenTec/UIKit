package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.dismissCircle(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "DismissCircle",
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
            moveTo(12.83f, 12.12f)
            curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
            lineToRelative(-0.06f, 0.07f)
            curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
            lineToRelative(-0.07f, -0.06f)
            lineToRelative(-2.12f, -2.12f)
            lineToRelative(-2.12f, 2.12f)
            curveToRelative(-0.17f, 0.17f, -0.44f, 0.19f, -0.64f, 0.06f)
            lineToRelative(-0.07f, -0.06f)
            curveToRelative(-0.17f, -0.17f, -0.19f, -0.44f, -0.06f, -0.64f)
            lineToRelative(0.06f, -0.07f)
            lineToRelative(2.12f, -2.12f)
            lineToRelative(-2.12f, -2.12f)
            curveToRelative(-0.17f, -0.17f, -0.19f, -0.44f, -0.06f, -0.64f)
            lineToRelative(0.06f, -0.07f)
            curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
            lineToRelative(0.07f, 0.06f)
            lineToRelative(2.12f, 2.12f)
            lineToRelative(2.12f, -2.12f)
            curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
            lineToRelative(0.07f, 0.06f)
            curveToRelative(0.17f, 0.17f, 0.19f, 0.44f, 0.06f, 0.64f)
            lineToRelative(-0.06f, 0.07f)
            lineToRelative(-2.12f, 2.12f)
            lineToRelative(2.12f, 2.12f)
            close()
        }
        path(fill = primary) {
            moveTo(7.81f, 7.11f)
            curveToRelative(-0.19f, -0.13f, -0.46f, -0.12f, -0.64f, 0.06f)
            lineToRelative(-0.06f, 0.07f)
            curveToRelative(-0.13f, 0.19f, -0.12f, 0.46f, 0.06f, 0.64f)
            lineToRelative(2.12f, 2.12f)
            lineToRelative(-2.12f, 2.12f)
            lineToRelative(-0.06f, 0.07f)
            curveToRelative(-0.13f, 0.19f, -0.12f, 0.46f, 0.06f, 0.64f)
            lineToRelative(0.07f, 0.06f)
            curveToRelative(0.19f, 0.14f, 0.46f, 0.12f, 0.64f, -0.06f)
            lineToRelative(2.12f, -2.12f)
            lineToRelative(2.12f, 2.12f)
            lineToRelative(0.07f, 0.06f)
            curveToRelative(0.19f, 0.14f, 0.46f, 0.12f, 0.64f, -0.06f)
            lineToRelative(0.06f, -0.07f)
            curveToRelative(0.14f, -0.19f, 0.12f, -0.46f, -0.06f, -0.64f)
            lineToRelative(-2.12f, -2.12f)
            lineToRelative(2.12f, -2.12f)
            lineToRelative(0.06f, -0.07f)
            curveToRelative(0.14f, -0.19f, 0.12f, -0.46f, -0.06f, -0.64f)
            lineToRelative(-0.07f, -0.06f)
            curveToRelative(-0.19f, -0.13f, -0.46f, -0.12f, -0.64f, 0.06f)
            lineToRelative(-2.12f, 2.12f)
            lineToRelative(-2.12f, -2.12f)
            lineToRelative(-0.07f, -0.06f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.dismissCircle(): ImageVector {
    return dismissCircle(
        SolidColor(Color(0x001D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.dismissCircle(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return dismissCircle(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
}