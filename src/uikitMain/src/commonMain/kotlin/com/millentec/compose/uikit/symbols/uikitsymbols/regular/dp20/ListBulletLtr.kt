package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.listBulletLtr(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "ListBulletLtr",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = secondary) {
            moveTo(6f, 4.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(11f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
            horizontalLineTo(6.5f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            close()
            moveTo(6f, 9.5f)
            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
            horizontalLineToRelative(11f)
            curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
            reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
            horizontalLineTo(6.5f)
            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
            close()
            moveTo(6.5f, 14f)
            curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
            reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
            horizontalLineToRelative(11f)
            curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
            reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
            horizontalLineTo(6.5f)
            close()
        }
        path(fill = primary) {
            moveTo(3f, 5.5f)
            curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
            reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
            reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
            reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
            close()
            moveTo(4f, 14.5f)
            curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
            reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f)
            reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
            reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
            close()
            moveTo(3f, 10.5f)
            curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f)
            reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f)
            reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f)
            reflectiveCurveToRelative(0.45f, 1f, 1f, 1f)
            close()
        }
    }.build()
}

fun UIKitSymbols.listBulletLtr(): ImageVector {
    return listBulletLtr(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F)),
    )
}

fun UIKitSymbols.listBulletLtr(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return listBulletLtr(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}