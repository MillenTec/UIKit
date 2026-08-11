package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Mail: ImageVector
    get() {
        if (_Mail != null) {
            return _Mail!!
        }
        _Mail = ImageVector.Builder(
            name = "Mail",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(18f, 7.373f)
                verticalLineTo(14.5f)
                curveTo(18f, 15.881f, 16.881f, 17f, 15.5f, 17f)
                horizontalLineTo(4.5f)
                curveTo(3.119f, 17f, 2f, 15.881f, 2f, 14.5f)
                verticalLineTo(7.373f)
                lineTo(9.746f, 11.931f)
                curveTo(9.903f, 12.023f, 10.097f, 12.023f, 10.253f, 11.931f)
                lineTo(18f, 7.373f)
                close()
                moveTo(15.5f, 4f)
                curveTo(16.787f, 4f, 17.847f, 4.973f, 17.985f, 6.223f)
                lineTo(10f, 10.92f)
                lineTo(2.015f, 6.223f)
                curveTo(2.153f, 4.973f, 3.213f, 4f, 4.5f, 4f)
                horizontalLineTo(15.5f)
                close()
            }
        }.build()

        return _Mail!!
    }

@Suppress("ObjectPropertyName")
private var _Mail: ImageVector? = null
