package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Document: ImageVector
    get() {
        if (_Document != null) {
            return _Document!!
        }
        _Document = ImageVector.Builder(
            name = "Document",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(6f, 2f)
                curveTo(4.895f, 2f, 4f, 2.895f, 4f, 4f)
                verticalLineTo(16f)
                curveTo(4f, 17.105f, 4.895f, 18f, 6f, 18f)
                horizontalLineTo(14f)
                curveTo(15.105f, 18f, 16f, 17.105f, 16f, 16f)
                verticalLineTo(7.414f)
                curveTo(16f, 7.016f, 15.842f, 6.635f, 15.561f, 6.354f)
                lineTo(11.646f, 2.439f)
                curveTo(11.365f, 2.158f, 10.984f, 2f, 10.586f, 2f)
                horizontalLineTo(6f)
                close()
                moveTo(5f, 4f)
                curveTo(5f, 3.448f, 5.448f, 3f, 6f, 3f)
                horizontalLineTo(10f)
                verticalLineTo(6.5f)
                curveTo(10f, 7.328f, 10.672f, 8f, 11.5f, 8f)
                horizontalLineTo(15f)
                verticalLineTo(16f)
                curveTo(15f, 16.552f, 14.552f, 17f, 14f, 17f)
                horizontalLineTo(6f)
                curveTo(5.448f, 17f, 5f, 16.552f, 5f, 16f)
                verticalLineTo(4f)
                close()
                moveTo(14.793f, 7f)
                horizontalLineTo(11.5f)
                curveTo(11.224f, 7f, 11f, 6.776f, 11f, 6.5f)
                verticalLineTo(3.207f)
                lineTo(14.793f, 7f)
                close()
            }
        }.build()

        return _Document!!
    }

@Suppress("ObjectPropertyName")
private var _Document: ImageVector? = null