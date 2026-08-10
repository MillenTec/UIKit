package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Folder: ImageVector
    get() {
        if (_Folder != null) {
            return _Folder!!
        }
        _Folder = ImageVector.Builder(
            name = "Folder",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(4.5f, 3f)
                curveTo(3.119f, 3f, 2f, 4.119f, 2f, 5.5f)
                verticalLineTo(14.5f)
                curveTo(2f, 15.881f, 3.119f, 17f, 4.5f, 17f)
                horizontalLineTo(15.5f)
                curveTo(16.881f, 17f, 18f, 15.881f, 18f, 14.5f)
                verticalLineTo(7.5f)
                curveTo(18f, 6.119f, 16.881f, 5f, 15.5f, 5f)
                horizontalLineTo(9.707f)
                lineTo(8.22f, 3.513f)
                curveTo(7.891f, 3.184f, 7.446f, 3f, 6.982f, 3f)
                horizontalLineTo(4.5f)
                close()
                moveTo(3f, 5.5f)
                curveTo(3f, 4.672f, 3.672f, 4f, 4.5f, 4f)
                horizontalLineTo(6.982f)
                curveTo(7.181f, 4f, 7.372f, 4.079f, 7.513f, 4.22f)
                lineTo(8.793f, 5.5f)
                lineTo(7.439f, 6.854f)
                curveTo(7.346f, 6.947f, 7.218f, 7f, 7.086f, 7f)
                horizontalLineTo(3f)
                verticalLineTo(5.5f)
                close()
                moveTo(3f, 8f)
                horizontalLineTo(7.086f)
                curveTo(7.484f, 8f, 7.865f, 7.842f, 8.146f, 7.561f)
                lineTo(9.707f, 6f)
                horizontalLineTo(15.5f)
                curveTo(16.328f, 6f, 17f, 6.672f, 17f, 7.5f)
                verticalLineTo(14.5f)
                curveTo(17f, 15.328f, 16.328f, 16f, 15.5f, 16f)
                horizontalLineTo(4.5f)
                curveTo(3.672f, 16f, 3f, 15.328f, 3f, 14.5f)
                verticalLineTo(8f)
                close()
            }
        }.build()

        return _Folder!!
    }

@Suppress("ObjectPropertyName")
private var _Folder: ImageVector? = null
