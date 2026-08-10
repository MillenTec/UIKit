package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Cart: ImageVector
    get() {
        if (_Cart != null) {
            return _Cart!!
        }
        _Cart = ImageVector.Builder(
            name = "Cart",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(2.997f, 3.496f)
                curveTo(2.997f, 3.22f, 3.221f, 2.996f, 3.497f, 2.996f)
                horizontalLineTo(3.935f)
                curveTo(4.662f, 2.996f, 5.08f, 3.469f, 5.322f, 3.941f)
                curveTo(5.487f, 4.264f, 5.607f, 4.658f, 5.705f, 5f)
                horizontalLineTo(16f)
                curveTo(16.663f, 5f, 17.143f, 5.634f, 16.962f, 6.272f)
                lineTo(15.466f, 11.547f)
                curveTo(15.222f, 12.407f, 14.437f, 13.001f, 13.542f, 13.001f)
                horizontalLineTo(8.463f)
                curveTo(7.561f, 13.001f, 6.771f, 12.398f, 6.534f, 11.528f)
                lineTo(5.891f, 9.173f)
                curveTo(5.887f, 9.163f, 5.884f, 9.152f, 5.88f, 9.141f)
                lineTo(4.851f, 5.643f)
                curveTo(4.816f, 5.527f, 4.783f, 5.414f, 4.752f, 5.306f)
                curveTo(4.652f, 4.96f, 4.563f, 4.654f, 4.432f, 4.397f)
                curveTo(4.272f, 4.086f, 4.126f, 3.996f, 3.935f, 3.996f)
                horizontalLineTo(3.497f)
                curveTo(3.221f, 3.996f, 2.997f, 3.772f, 2.997f, 3.496f)
                close()
                moveTo(8.5f, 17f)
                curveTo(9.328f, 17f, 10f, 16.328f, 10f, 15.5f)
                curveTo(10f, 14.671f, 9.328f, 14f, 8.5f, 14f)
                curveTo(7.672f, 14f, 7f, 14.671f, 7f, 15.5f)
                curveTo(7f, 16.328f, 7.672f, 17f, 8.5f, 17f)
                close()
                moveTo(13.5f, 17f)
                curveTo(14.328f, 17f, 15f, 16.328f, 15f, 15.5f)
                curveTo(15f, 14.671f, 14.328f, 14f, 13.5f, 14f)
                curveTo(12.672f, 14f, 12f, 14.671f, 12f, 15.5f)
                curveTo(12f, 16.328f, 12.672f, 17f, 13.5f, 17f)
                close()
            }
        }.build()

        return _Cart!!
    }

@Suppress("ObjectPropertyName")
private var _Cart: ImageVector? = null
