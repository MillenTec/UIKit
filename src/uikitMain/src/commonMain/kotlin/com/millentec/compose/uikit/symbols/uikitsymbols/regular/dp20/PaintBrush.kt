package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.PaintBrush: ImageVector
    get() {
        if (_PaintBrush != null) {
            return _PaintBrush!!
        }
        _PaintBrush = ImageVector.Builder(
            name = "PaintBrush",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(5.5f, 1.999f)
                curveTo(5.224f, 1.999f, 5f, 2.223f, 5f, 2.499f)
                lineTo(5f, 11.003f)
                curveTo(5f, 12.108f, 5.895f, 13.003f, 7f, 13.003f)
                horizontalLineTo(8.004f)
                verticalLineTo(16.001f)
                curveTo(8.004f, 17.105f, 8.9f, 18.001f, 10.004f, 18.001f)
                curveTo(11.109f, 18.001f, 12.004f, 17.105f, 12.004f, 16.001f)
                verticalLineTo(13.003f)
                horizontalLineTo(13f)
                curveTo(14.105f, 13.003f, 15f, 12.108f, 15f, 11.003f)
                verticalLineTo(9.503f)
                lineTo(15f, 9.499f)
                verticalLineTo(2.499f)
                curveTo(15f, 2.223f, 14.776f, 1.999f, 14.5f, 1.999f)
                horizontalLineTo(5.5f)
                close()
                moveTo(6f, 10.003f)
                horizontalLineTo(14f)
                verticalLineTo(11.003f)
                curveTo(14f, 11.556f, 13.552f, 12.003f, 13f, 12.003f)
                horizontalLineTo(11.504f)
                curveTo(11.228f, 12.003f, 11.004f, 12.227f, 11.004f, 12.503f)
                verticalLineTo(16.001f)
                curveTo(11.004f, 16.553f, 10.556f, 17.001f, 10.004f, 17.001f)
                curveTo(9.452f, 17.001f, 9.004f, 16.553f, 9.004f, 16.001f)
                verticalLineTo(12.503f)
                curveTo(9.004f, 12.227f, 8.78f, 12.003f, 8.504f, 12.003f)
                horizontalLineTo(7f)
                curveTo(6.448f, 12.003f, 6f, 11.556f, 6f, 11.003f)
                verticalLineTo(10.003f)
                close()
                moveTo(14f, 9.003f)
                horizontalLineTo(6f)
                verticalLineTo(2.999f)
                horizontalLineTo(10f)
                verticalLineTo(4.499f)
                curveTo(10f, 4.775f, 10.224f, 4.999f, 10.5f, 4.999f)
                curveTo(10.776f, 4.999f, 11f, 4.775f, 11f, 4.499f)
                verticalLineTo(2.999f)
                horizontalLineTo(12f)
                verticalLineTo(5.501f)
                curveTo(12f, 5.777f, 12.224f, 6.001f, 12.5f, 6.001f)
                curveTo(12.776f, 6.001f, 13f, 5.777f, 13f, 5.501f)
                verticalLineTo(2.999f)
                horizontalLineTo(14f)
                verticalLineTo(9.003f)
                close()
            }
        }.build()

        return _PaintBrush!!
    }

@Suppress("ObjectPropertyName")
private var _PaintBrush: ImageVector? = null
