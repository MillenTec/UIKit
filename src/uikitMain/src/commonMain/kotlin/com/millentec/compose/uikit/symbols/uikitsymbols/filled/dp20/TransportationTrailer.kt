package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.TransportationTrailer: ImageVector
    get() {
        if (_TransportationTrailer != null) {
            return _TransportationTrailer!!
        }
        _TransportationTrailer = ImageVector.Builder(
            name = "TransportationTrailer",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(13.154f, 3.004f)
                curveTo(14.739f, 3.084f, 16f, 4.395f, 16f, 6f)
                verticalLineTo(14f)
                horizontalLineTo(18f)
                verticalLineTo(12.5f)
                curveTo(18f, 12.224f, 18.224f, 12f, 18.5f, 12f)
                curveTo(18.776f, 12f, 19f, 12.224f, 19f, 12.5f)
                verticalLineTo(16.5f)
                curveTo(19f, 16.776f, 18.776f, 17f, 18.5f, 17f)
                curveTo(18.224f, 17f, 18f, 16.776f, 18f, 16.5f)
                verticalLineTo(15f)
                horizontalLineTo(8.95f)
                curveTo(8.719f, 16.141f, 7.709f, 17f, 6.5f, 17f)
                curveTo(5.291f, 17f, 4.281f, 16.141f, 4.05f, 15f)
                horizontalLineTo(4f)
                curveTo(2.343f, 15f, 1f, 13.657f, 1f, 12f)
                curveTo(1f, 7.029f, 5.029f, 3f, 10f, 3f)
                horizontalLineTo(13f)
                lineTo(13.154f, 3.004f)
                close()
                moveTo(6.5f, 13f)
                curveTo(5.672f, 13f, 5f, 13.672f, 5f, 14.5f)
                curveTo(5f, 15.328f, 5.672f, 16f, 6.5f, 16f)
                curveTo(7.328f, 16f, 8f, 15.328f, 8f, 14.5f)
                curveTo(8f, 13.672f, 7.328f, 13f, 6.5f, 13f)
                close()
                moveTo(10f, 6f)
                curveTo(9.448f, 6f, 9f, 6.448f, 9f, 7f)
                verticalLineTo(9f)
                lineTo(9.005f, 9.103f)
                curveTo(9.056f, 9.607f, 9.482f, 10f, 10f, 10f)
                horizontalLineTo(12f)
                curveTo(12.552f, 10f, 13f, 9.552f, 13f, 9f)
                verticalLineTo(7f)
                curveTo(13f, 6.482f, 12.607f, 6.056f, 12.102f, 6.005f)
                lineTo(12f, 6f)
                horizontalLineTo(10f)
                close()
            }
        }.build()

        return _TransportationTrailer!!
    }

@Suppress("ObjectPropertyName")
private var _TransportationTrailer: ImageVector? = null
