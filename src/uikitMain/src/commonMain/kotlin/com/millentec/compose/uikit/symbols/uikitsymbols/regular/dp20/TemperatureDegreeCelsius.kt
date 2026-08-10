package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.TemperatureDegreeCelsius: ImageVector
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
                moveTo(3f, 6.5f)
                curveTo(3f, 5.672f, 3.672f, 5f, 4.5f, 5f)
                curveTo(5.328f, 5f, 6f, 5.672f, 6f, 6.5f)
                curveTo(6f, 7.328f, 5.328f, 8f, 4.5f, 8f)
                curveTo(3.672f, 8f, 3f, 7.328f, 3f, 6.5f)
                close()
                moveTo(4.5f, 4f)
                curveTo(3.119f, 4f, 2f, 5.119f, 2f, 6.5f)
                curveTo(2f, 7.881f, 3.119f, 9f, 4.5f, 9f)
                curveTo(5.881f, 9f, 7f, 7.881f, 7f, 6.5f)
                curveTo(7f, 5.119f, 5.881f, 4f, 4.5f, 4f)
                close()
                moveTo(10.01f, 6.276f)
                curveTo(9.249f, 7.106f, 8.75f, 8.353f, 8.75f, 10f)
                curveTo(8.75f, 11.647f, 9.249f, 12.894f, 10.01f, 13.724f)
                curveTo(10.769f, 14.552f, 11.82f, 15f, 13f, 15f)
                curveTo(14.18f, 15f, 15.231f, 14.552f, 15.99f, 13.724f)
                curveTo(16.232f, 13.46f, 16.447f, 13.154f, 16.628f, 12.807f)
                curveTo(16.724f, 12.624f, 16.909f, 12.5f, 17.115f, 12.5f)
                curveTo(17.473f, 12.5f, 17.723f, 12.855f, 17.563f, 13.175f)
                curveTo(17.335f, 13.634f, 17.054f, 14.043f, 16.727f, 14.4f)
                curveTo(15.768f, 15.447f, 14.443f, 16f, 13f, 16f)
                curveTo(11.557f, 16f, 10.233f, 15.447f, 9.273f, 14.4f)
                curveTo(8.314f, 13.354f, 7.75f, 11.851f, 7.75f, 10f)
                curveTo(7.75f, 8.149f, 8.314f, 6.646f, 9.273f, 5.6f)
                curveTo(10.233f, 4.553f, 11.557f, 4f, 13f, 4f)
                curveTo(14.443f, 4f, 15.768f, 4.553f, 16.727f, 5.6f)
                curveTo(17.054f, 5.957f, 17.335f, 6.366f, 17.563f, 6.825f)
                curveTo(17.723f, 7.145f, 17.473f, 7.5f, 17.115f, 7.5f)
                curveTo(16.909f, 7.5f, 16.724f, 7.376f, 16.628f, 7.193f)
                curveTo(16.447f, 6.846f, 16.232f, 6.54f, 15.99f, 6.276f)
                curveTo(15.231f, 5.448f, 14.18f, 5f, 13f, 5f)
                curveTo(11.82f, 5f, 10.769f, 5.448f, 10.01f, 6.276f)
                close()
            }
        }.build()

        return _TemperatureDegreeCelsius!!
    }

@Suppress("ObjectPropertyName")
private var _TemperatureDegreeCelsius: ImageVector? = null
