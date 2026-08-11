package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Attach: ImageVector
    get() {
        if (_Attach != null) {
            return _Attach!!
        }
        _Attach = ImageVector.Builder(
            name = "Attach",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(4.828f, 10.485f)
                lineTo(10.485f, 4.828f)
                curveTo(11.657f, 3.656f, 13.556f, 3.656f, 14.728f, 4.828f)
                curveTo(15.899f, 5.999f, 15.899f, 7.899f, 14.728f, 9.071f)
                lineTo(8.01f, 15.788f)
                curveTo(7.424f, 16.374f, 6.475f, 16.374f, 5.889f, 15.788f)
                curveTo(5.303f, 15.202f, 5.303f, 14.252f, 5.889f, 13.667f)
                lineTo(11.899f, 7.656f)
                curveTo(12.094f, 7.461f, 12.094f, 7.144f, 11.899f, 6.949f)
                curveTo(11.704f, 6.754f, 11.387f, 6.754f, 11.192f, 6.949f)
                lineTo(5.182f, 12.96f)
                curveTo(4.205f, 13.936f, 4.205f, 15.519f, 5.182f, 16.495f)
                curveTo(6.158f, 17.472f, 7.741f, 17.472f, 8.717f, 16.495f)
                lineTo(15.435f, 9.778f)
                curveTo(16.997f, 8.216f, 16.997f, 5.683f, 15.435f, 4.121f)
                curveTo(13.873f, 2.559f, 11.34f, 2.559f, 9.778f, 4.121f)
                lineTo(4.121f, 9.778f)
                curveTo(3.926f, 9.973f, 3.926f, 10.29f, 4.121f, 10.485f)
                curveTo(4.316f, 10.68f, 4.633f, 10.68f, 4.828f, 10.485f)
                close()
            }
        }.build()

        return _Attach!!
    }

@Suppress("ObjectPropertyName")
private var _Attach: ImageVector? = null
