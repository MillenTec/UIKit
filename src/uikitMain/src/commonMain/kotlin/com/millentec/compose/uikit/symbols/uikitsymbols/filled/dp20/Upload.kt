package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

fun UIKitSymbols.Filled.upload(
    primary: Brush,
    secondary: Brush,
): ImageVector {
    return ImageVector.Builder(
        name = "Upload",
        defaultWidth = 20.dp,
        defaultHeight = 20.dp,
        viewportWidth = 20f,
        viewportHeight = 20f
    ).apply {
        path(fill = primary) {
            moveTo(10.287f, 2.057f)
            curveTo(10.199f, 2.02f, 10.102f, 2f, 10f, 2f)
            curveTo(9.898f, 2f, 9.801f, 2.02f, 9.713f, 2.057f)
            curveTo(9.624f, 2.094f, 9.542f, 2.148f, 9.47f, 2.22f)
            lineTo(5.22f, 6.47f)
            curveTo(4.927f, 6.763f, 4.927f, 7.237f, 5.22f, 7.53f)
            curveTo(5.513f, 7.823f, 5.987f, 7.823f, 6.28f, 7.53f)
            lineTo(9.25f, 4.561f)
            verticalLineTo(12.25f)
            curveTo(9.25f, 12.664f, 9.586f, 13f, 10f, 13f)
            curveTo(10.414f, 13f, 10.75f, 12.664f, 10.75f, 12.25f)
            verticalLineTo(4.561f)
            lineTo(13.72f, 7.53f)
            curveTo(14.013f, 7.823f, 14.487f, 7.823f, 14.78f, 7.53f)
            curveTo(15.073f, 7.237f, 15.073f, 6.763f, 14.78f, 6.47f)
            lineTo(10.53f, 2.22f)
            curveTo(10.458f, 2.148f, 10.375f, 2.094f, 10.287f, 2.057f)
            close()
        }
        path(fill = secondary) {
            moveTo(3.75f, 9f)
            curveTo(4.164f, 9f, 4.5f, 9.336f, 4.5f, 9.75f)
            verticalLineTo(13.75f)
            curveTo(4.5f, 14.717f, 5.284f, 15.5f, 6.25f, 15.5f)
            horizontalLineTo(13.75f)
            curveTo(14.717f, 15.5f, 15.5f, 14.717f, 15.5f, 13.75f)
            verticalLineTo(9.75f)
            curveTo(15.5f, 9.336f, 15.836f, 9f, 16.25f, 9f)
            curveTo(16.664f, 9f, 17f, 9.336f, 17f, 9.75f)
            verticalLineTo(13.75f)
            curveTo(17f, 15.545f, 15.545f, 17f, 13.75f, 17f)
            horizontalLineTo(6.25f)
            curveTo(4.455f, 17f, 3f, 15.545f, 3f, 13.75f)
            verticalLineTo(9.75f)
            curveTo(3f, 9.336f, 3.336f, 9f, 3.75f, 9f)
            close()
        }
    }.build()
}

fun UIKitSymbols.Filled.upload(): ImageVector {
    return upload(
        SolidColor(Color(0xFF1D1D1F)),
        SolidColor(Color(0xFF1D1D1F))
    )
}

fun UIKitSymbols.Filled.upload(
    color: Color,
    layered: Boolean = false
): ImageVector {
    return upload(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
    )
}