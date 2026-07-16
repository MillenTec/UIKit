package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Warning: ImageVector
    get() {
        if (_Warning != null) {
            return _Warning!!
        }
        _Warning = ImageVector.Builder(
            name = "Warning",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(7.37f, 3.556f)
                curveTo(8.509f, 1.482f, 11.49f, 1.482f, 12.629f, 3.556f)
                lineTo(18.125f, 13.561f)
                curveTo(19.222f, 15.56f, 17.776f, 18.004f, 15.495f, 18.005f)
                horizontalLineTo(4.504f)
                curveTo(2.223f, 18.005f, 0.777f, 15.56f, 1.875f, 13.561f)
                lineTo(7.37f, 3.556f)
                close()
                moveTo(9.999f, 12.75f)
                curveTo(9.585f, 12.75f, 9.249f, 13.086f, 9.249f, 13.5f)
                curveTo(9.249f, 13.914f, 9.585f, 14.25f, 9.999f, 14.25f)
                curveTo(10.413f, 14.25f, 10.749f, 13.914f, 10.749f, 13.5f)
                curveTo(10.749f, 13.086f, 10.413f, 12.75f, 9.999f, 12.75f)
                close()
                moveTo(9.999f, 6.5f)
                curveTo(9.723f, 6.5f, 9.499f, 6.724f, 9.499f, 7f)
                verticalLineTo(11f)
                curveTo(9.499f, 11.276f, 9.723f, 11.5f, 9.999f, 11.5f)
                curveTo(10.275f, 11.5f, 10.499f, 11.276f, 10.499f, 11f)
                verticalLineTo(7f)
                curveTo(10.499f, 6.724f, 10.275f, 6.5f, 9.999f, 6.5f)
                close()
            }
        }.build()

        return _Warning!!
    }

@Suppress("ObjectPropertyName")
private var _Warning: ImageVector? = null
