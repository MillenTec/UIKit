package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.hardDrive(
    primary: Brush,
    secondary: Brush
): ImageVector {
    return ImageVector.Builder(
        name = "HardDrive",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(4f, 10f)
            curveToRelative(-0.59f, 0f, -1.14f, 0.17f, -1.6f, 0.46f)
            lineToRelative(2.25f, -5.25f)
            curveToRelative(0.32f, -0.74f, 1.04f, -1.21f, 1.84f, -1.21f)
            horizontalLineToRelative(7.1f)
            curveToRelative(0.74f, 0f, 1.43f, 0.41f, 1.76f, 1.09f)
            curveToRelative(0.54f, 1.11f, 1.53f, 3.21f, 2.33f, 5.43f)
            curveToRelative(-0.48f, -0.33f, -1.06f, -0.52f, -1.69f, -0.52f)
            horizontalLineTo(4f)
            close()
            moveTo(16f, 11f)
            horizontalLineTo(4f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(1f)
            curveToRelative(0f, 1.1f, 0.89f, 1.99f, 1.99f, 2f)
            horizontalLineToRelative(12.01f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            verticalLineToRelative(-1f)
            curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
            close()
            moveTo(15.5f, 14.25f)
            curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
            reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f)
            reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f)
            reflectiveCurveToRelative(-0.34f, 0.75f, -0.75f, 0.75f)
            close()
        }
        path(fill = secondary) {
            moveTo(15.5f, 13.5f)
            moveToRelative(-0.75f, 0f)
            arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, 1.5f, 0f)
            arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.5f, 0f)
        }
    }.build()
}

fun UIKitSymbols.Filled.hardDrive(): ImageVector {
    return hardDrive(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0x001D1D1F))
    )
}

fun UIKitSymbols.Filled.hardDrive(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return hardDrive(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color.copy(0f)),
    )
}
