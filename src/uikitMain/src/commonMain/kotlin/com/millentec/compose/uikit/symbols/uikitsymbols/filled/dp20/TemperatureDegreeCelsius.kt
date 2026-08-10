package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.TemperatureDegreeCelsius: ImageVector
    get() {
        if (_TemperatureDegreeCelsius != null) {
            return _TemperatureDegreeCelsius!!
        }
        _TemperatureDegreeCelsius = ImageVector.Builder(
            name = "TemperatureDegreeCelsius",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(3f, 7f)
                curveTo(3f, 6.172f, 3.672f, 5.5f, 4.5f, 5.5f)
                curveTo(5.328f, 5.5f, 6f, 6.172f, 6f, 7f)
                curveTo(6f, 7.828f, 5.328f, 8.5f, 4.5f, 8.5f)
                curveTo(3.672f, 8.5f, 3f, 7.828f, 3f, 7f)
                close()
                moveTo(4.5f, 4f)
                curveTo(2.843f, 4f, 1.5f, 5.343f, 1.5f, 7f)
                curveTo(1.5f, 8.657f, 2.843f, 10f, 4.5f, 10f)
                curveTo(6.157f, 10f, 7.5f, 8.657f, 7.5f, 7f)
                curveTo(7.5f, 5.343f, 6.157f, 4f, 4.5f, 4f)
                close()
                moveTo(10.682f, 6.642f)
                curveTo(9.977f, 7.377f, 9.5f, 8.493f, 9.5f, 10f)
                curveTo(9.5f, 11.507f, 9.977f, 12.623f, 10.682f, 13.358f)
                curveTo(11.388f, 14.093f, 12.375f, 14.5f, 13.5f, 14.5f)
                curveTo(14.625f, 14.5f, 15.612f, 14.093f, 16.318f, 13.358f)
                curveTo(16.448f, 13.222f, 16.57f, 13.073f, 16.684f, 12.912f)
                curveTo(16.854f, 12.668f, 17.121f, 12.5f, 17.418f, 12.5f)
                curveTo(17.979f, 12.5f, 18.365f, 13.062f, 18.067f, 13.538f)
                curveTo(17.872f, 13.85f, 17.649f, 14.137f, 17.4f, 14.397f)
                curveTo(16.387f, 15.451f, 14.998f, 16f, 13.5f, 16f)
                curveTo(12.002f, 16f, 10.613f, 15.451f, 9.6f, 14.397f)
                curveTo(8.587f, 13.341f, 8f, 11.832f, 8f, 10f)
                curveTo(8f, 8.168f, 8.587f, 6.659f, 9.6f, 5.603f)
                curveTo(10.613f, 4.549f, 12.002f, 4f, 13.5f, 4f)
                curveTo(14.998f, 4f, 16.387f, 4.549f, 17.4f, 5.603f)
                curveTo(17.649f, 5.863f, 17.872f, 6.15f, 18.067f, 6.462f)
                curveTo(18.365f, 6.938f, 17.979f, 7.5f, 17.418f, 7.5f)
                curveTo(17.121f, 7.5f, 16.854f, 7.332f, 16.684f, 7.088f)
                curveTo(16.57f, 6.927f, 16.448f, 6.778f, 16.318f, 6.642f)
                curveTo(15.612f, 5.907f, 14.625f, 5.5f, 13.5f, 5.5f)
                curveTo(12.375f, 5.5f, 11.388f, 5.907f, 10.682f, 6.642f)
                close()
            }
        }.build()

        return _TemperatureDegreeCelsius!!
    }

@Suppress("ObjectPropertyName")
private var _TemperatureDegreeCelsius: ImageVector? = null
