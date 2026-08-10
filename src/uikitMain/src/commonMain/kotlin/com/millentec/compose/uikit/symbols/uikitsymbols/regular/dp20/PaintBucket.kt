package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.PaintBucket: ImageVector
    get() {
        if (_PaintBucket != null) {
            return _PaintBucket!!
        }
        _PaintBucket = ImageVector.Builder(
            name = "PaintBucket",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(9f, 2.5f)
                curveTo(9f, 2.224f, 8.776f, 2f, 8.5f, 2f)
                curveTo(8.224f, 2f, 8f, 2.224f, 8f, 2.5f)
                verticalLineTo(4f)
                curveTo(7.795f, 4.072f, 7.603f, 4.19f, 7.439f, 4.354f)
                lineTo(2.354f, 9.439f)
                curveTo(1.768f, 10.025f, 1.768f, 10.975f, 2.354f, 11.561f)
                lineTo(6.689f, 15.896f)
                curveTo(7.275f, 16.482f, 8.225f, 16.482f, 8.811f, 15.896f)
                lineTo(13.896f, 10.811f)
                curveTo(14.482f, 10.225f, 14.482f, 9.275f, 13.896f, 8.689f)
                lineTo(9.561f, 4.354f)
                curveTo(9.397f, 4.19f, 9.205f, 4.072f, 9f, 4f)
                verticalLineTo(2.5f)
                close()
                moveTo(8f, 5.207f)
                verticalLineTo(6.5f)
                curveTo(8f, 6.776f, 8.224f, 7f, 8.5f, 7f)
                curveTo(8.776f, 7f, 9f, 6.776f, 9f, 6.5f)
                verticalLineTo(5.207f)
                lineTo(13.189f, 9.396f)
                curveTo(13.353f, 9.56f, 13.379f, 9.809f, 13.269f, 10f)
                horizontalLineTo(3.207f)
                lineTo(8f, 5.207f)
                close()
                moveTo(7.396f, 15.189f)
                lineTo(3.207f, 11f)
                horizontalLineTo(12.293f)
                lineTo(8.104f, 15.189f)
                curveTo(7.908f, 15.385f, 7.592f, 15.385f, 7.396f, 15.189f)
                close()
                moveTo(16.016f, 11.392f)
                curveTo(15.785f, 10.997f, 15.215f, 10.997f, 14.984f, 11.392f)
                lineTo(13.332f, 14.225f)
                curveTo(12.355f, 15.898f, 13.563f, 18f, 15.5f, 18f)
                curveTo(17.437f, 18f, 18.645f, 15.898f, 17.668f, 14.225f)
                lineTo(16.016f, 11.392f)
                close()
                moveTo(14.195f, 14.729f)
                lineTo(15.5f, 12.492f)
                lineTo(16.805f, 14.729f)
                curveTo(17.392f, 15.736f, 16.666f, 17f, 15.5f, 17f)
                curveTo(14.334f, 17f, 13.608f, 15.736f, 14.195f, 14.729f)
                close()
            }
        }.build()

        return _PaintBucket!!
    }

@Suppress("ObjectPropertyName")
private var _PaintBucket: ImageVector? = null
