package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.TransportationCableCar: ImageVector
    get() {
        if (_TransportationCableCar != null) {
            return _TransportationCableCar!!
        }
        _TransportationCableCar = ImageVector.Builder(
            name = "TransportationCableCar",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(17.434f, 3.004f)
                curveTo(17.708f, 2.968f, 17.959f, 3.16f, 17.996f, 3.434f)
                curveTo(18.032f, 3.708f, 17.84f, 3.959f, 17.566f, 3.996f)
                lineTo(12f, 4.738f)
                verticalLineTo(6f)
                curveTo(12f, 6.768f, 11.711f, 7.469f, 11.236f, 8f)
                horizontalLineTo(13f)
                curveTo(14.657f, 8f, 16f, 9.343f, 16f, 11f)
                verticalLineTo(15f)
                curveTo(16f, 16.105f, 15.105f, 17f, 14f, 17f)
                horizontalLineTo(6f)
                curveTo(4.895f, 17f, 4f, 16.105f, 4f, 15f)
                verticalLineTo(11f)
                curveTo(4f, 9.343f, 5.343f, 8f, 7f, 8f)
                horizontalLineTo(9f)
                curveTo(10.105f, 8f, 11f, 7.105f, 11f, 6f)
                verticalLineTo(4.871f)
                lineTo(2.566f, 5.996f)
                curveTo(2.292f, 6.032f, 2.041f, 5.84f, 2.004f, 5.566f)
                curveTo(1.968f, 5.292f, 2.16f, 5.041f, 2.434f, 5.004f)
                lineTo(11f, 3.862f)
                verticalLineTo(3.5f)
                curveTo(11f, 3.224f, 11.224f, 3f, 11.5f, 3f)
                curveTo(11.776f, 3f, 12f, 3.224f, 12f, 3.5f)
                verticalLineTo(3.729f)
                lineTo(17.434f, 3.004f)
                close()
                moveTo(15f, 11f)
                curveTo(15f, 9.895f, 14.105f, 9f, 13f, 9f)
                horizontalLineTo(7f)
                curveTo(5.895f, 9f, 5f, 9.895f, 5f, 11f)
                verticalLineTo(13f)
                horizontalLineTo(15f)
                verticalLineTo(11f)
                close()
                moveTo(5f, 14f)
                verticalLineTo(15f)
                curveTo(5f, 15.552f, 5.448f, 16f, 6f, 16f)
                horizontalLineTo(14f)
                curveTo(14.552f, 16f, 15f, 15.552f, 15f, 15f)
                verticalLineTo(14f)
                horizontalLineTo(5f)
                close()
            }
        }.build()

        return _TransportationCableCar!!
    }

@Suppress("ObjectPropertyName")
private var _TransportationCableCar: ImageVector? = null
