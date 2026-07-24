package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.TemperatureDegreeFahrenheit: ImageVector
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
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(4f, 6.5f)
                curveTo(4f, 5.672f, 4.672f, 5f, 5.5f, 5f)
                curveTo(6.328f, 5f, 7f, 5.672f, 7f, 6.5f)
                curveTo(7f, 7.328f, 6.328f, 8f, 5.5f, 8f)
                curveTo(4.672f, 8f, 4f, 7.328f, 4f, 6.5f)
                close()
                moveTo(5.5f, 4f)
                curveTo(4.119f, 4f, 3f, 5.119f, 3f, 6.5f)
                curveTo(3f, 7.881f, 4.119f, 9f, 5.5f, 9f)
                curveTo(6.881f, 9f, 8f, 7.881f, 8f, 6.5f)
                curveTo(8f, 5.119f, 6.881f, 4f, 5.5f, 4f)
                close()
                moveTo(10.5f, 4f)
                curveTo(10.224f, 4f, 10f, 4.224f, 10f, 4.5f)
                verticalLineTo(15.5f)
                curveTo(10f, 15.776f, 10.224f, 16f, 10.5f, 16f)
                curveTo(10.776f, 16f, 11f, 15.776f, 11f, 15.5f)
                verticalLineTo(10f)
                horizontalLineTo(16f)
                curveTo(16.276f, 10f, 16.5f, 9.776f, 16.5f, 9.5f)
                curveTo(16.5f, 9.224f, 16.276f, 9f, 16f, 9f)
                horizontalLineTo(11f)
                verticalLineTo(5f)
                horizontalLineTo(16.5f)
                curveTo(16.776f, 5f, 17f, 4.776f, 17f, 4.5f)
                curveTo(17f, 4.224f, 16.776f, 4f, 16.5f, 4f)
                horizontalLineTo(10.5f)
                close()
            }
        }.build()

        return _TemperatureDegreeFahrenheit!!
    }

@Suppress("ObjectPropertyName")
private var _TemperatureDegreeFahrenheit: ImageVector? = null
