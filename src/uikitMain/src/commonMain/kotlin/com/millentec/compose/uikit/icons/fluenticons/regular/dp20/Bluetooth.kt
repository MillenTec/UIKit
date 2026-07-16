package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Bluetooth: ImageVector
    get() {
        if (_Bluetooth != null) {
            return _Bluetooth!!
        }
        _Bluetooth = ImageVector.Builder(
            name = "Bluetooth",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(9.309f, 2.038f)
                curveTo(9.495f, 1.961f, 9.711f, 2.003f, 9.854f, 2.146f)
                lineTo(13.854f, 6.146f)
                curveTo(13.951f, 6.244f, 14.004f, 6.378f, 14f, 6.517f)
                curveTo(13.995f, 6.655f, 13.933f, 6.785f, 13.829f, 6.876f)
                lineTo(10.259f, 10f)
                lineTo(13.829f, 13.124f)
                curveTo(13.933f, 13.215f, 13.995f, 13.345f, 14f, 13.483f)
                curveTo(14.004f, 13.622f, 13.951f, 13.756f, 13.854f, 13.854f)
                lineTo(9.854f, 17.854f)
                curveTo(9.711f, 17.997f, 9.495f, 18.039f, 9.309f, 17.962f)
                curveTo(9.122f, 17.885f, 9f, 17.702f, 9f, 17.5f)
                verticalLineTo(11.102f)
                lineTo(5.829f, 13.876f)
                curveTo(5.621f, 14.058f, 5.306f, 14.037f, 5.124f, 13.829f)
                curveTo(4.942f, 13.621f, 4.963f, 13.306f, 5.171f, 13.124f)
                lineTo(8.741f, 10f)
                lineTo(5.171f, 6.876f)
                curveTo(4.963f, 6.694f, 4.942f, 6.379f, 5.124f, 6.171f)
                curveTo(5.306f, 5.963f, 5.621f, 5.942f, 5.829f, 6.124f)
                lineTo(9f, 8.898f)
                verticalLineTo(2.5f)
                curveTo(9f, 2.298f, 9.122f, 2.115f, 9.309f, 2.038f)
                close()
                moveTo(10f, 11.102f)
                verticalLineTo(16.293f)
                lineTo(12.769f, 13.524f)
                lineTo(10f, 11.102f)
                close()
                moveTo(10f, 8.898f)
                lineTo(12.769f, 6.476f)
                lineTo(10f, 3.707f)
                verticalLineTo(8.898f)
                close()
            }
        }.build()

        return _Bluetooth!!
    }

@Suppress("ObjectPropertyName")
private var _Bluetooth: ImageVector? = null
