package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.TemperatureDegreeFahrenheit: ImageVector
    get() {
        if (_TemperatureDegreeFahrenheit != null) {
            return _TemperatureDegreeFahrenheit!!
        }
        _TemperatureDegreeFahrenheit = ImageVector.Builder(
            name = "TemperatureDegreeFahrenheit",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(3.5f, 7f)
                curveTo(3.5f, 6.172f, 4.172f, 5.5f, 5f, 5.5f)
                curveTo(5.828f, 5.5f, 6.5f, 6.172f, 6.5f, 7f)
                curveTo(6.5f, 7.828f, 5.828f, 8.5f, 5f, 8.5f)
                curveTo(4.172f, 8.5f, 3.5f, 7.828f, 3.5f, 7f)
                close()
                moveTo(5f, 4f)
                curveTo(3.343f, 4f, 2f, 5.343f, 2f, 7f)
                curveTo(2f, 8.657f, 3.343f, 10f, 5f, 10f)
                curveTo(6.657f, 10f, 8f, 8.657f, 8f, 7f)
                curveTo(8f, 5.343f, 6.657f, 4f, 5f, 4f)
                close()
                moveTo(10.75f, 4f)
                curveTo(10.336f, 4f, 10f, 4.336f, 10f, 4.75f)
                verticalLineTo(15.25f)
                curveTo(10f, 15.664f, 10.336f, 16f, 10.75f, 16f)
                curveTo(11.164f, 16f, 11.5f, 15.664f, 11.5f, 15.25f)
                verticalLineTo(10.5f)
                horizontalLineTo(16.25f)
                curveTo(16.664f, 10.5f, 17f, 10.164f, 17f, 9.75f)
                curveTo(17f, 9.336f, 16.664f, 9f, 16.25f, 9f)
                horizontalLineTo(11.5f)
                verticalLineTo(5.5f)
                horizontalLineTo(16.75f)
                curveTo(17.164f, 5.5f, 17.5f, 5.164f, 17.5f, 4.75f)
                curveTo(17.5f, 4.336f, 17.164f, 4f, 16.75f, 4f)
                horizontalLineTo(10.75f)
                close()
            }
        }.build()

        return _TemperatureDegreeFahrenheit!!
    }

@Suppress("ObjectPropertyName")
private var _TemperatureDegreeFahrenheit: ImageVector? = null
