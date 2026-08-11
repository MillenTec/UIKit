package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Toolbox: ImageVector
    get() {
        if (_Toolbox != null) {
            return _Toolbox!!
        }
        _Toolbox = ImageVector.Builder(
            name = "Toolbox",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(6f, 4.5f)
                verticalLineTo(6f)
                horizontalLineTo(4f)
                curveTo(2.895f, 6f, 2f, 6.895f, 2f, 8f)
                verticalLineTo(15f)
                curveTo(2f, 16.105f, 2.895f, 17f, 4f, 17f)
                horizontalLineTo(16.003f)
                curveTo(17.107f, 17f, 18.003f, 16.105f, 18.003f, 15f)
                verticalLineTo(8f)
                curveTo(18.003f, 6.895f, 17.107f, 6f, 16.003f, 6f)
                horizontalLineTo(14f)
                verticalLineTo(4.5f)
                curveTo(14f, 3.672f, 13.328f, 3f, 12.5f, 3f)
                horizontalLineTo(7.5f)
                curveTo(6.672f, 3f, 6f, 3.672f, 6f, 4.5f)
                close()
                moveTo(7.5f, 4f)
                horizontalLineTo(12.5f)
                curveTo(12.776f, 4f, 13f, 4.224f, 13f, 4.5f)
                verticalLineTo(6f)
                horizontalLineTo(7f)
                verticalLineTo(4.5f)
                curveTo(7f, 4.224f, 7.224f, 4f, 7.5f, 4f)
                close()
                moveTo(4f, 7f)
                horizontalLineTo(16.003f)
                curveTo(16.555f, 7f, 17.003f, 7.448f, 17.003f, 8f)
                verticalLineTo(10f)
                horizontalLineTo(14f)
                lineTo(14f, 9.501f)
                curveTo(14f, 9.225f, 13.776f, 9.001f, 13.5f, 9.001f)
                curveTo(13.224f, 9.001f, 13f, 9.225f, 13f, 9.501f)
                lineTo(13f, 10f)
                horizontalLineTo(7f)
                verticalLineTo(9.501f)
                curveTo(7f, 9.225f, 6.776f, 9.001f, 6.5f, 9.001f)
                curveTo(6.224f, 9.001f, 6f, 9.225f, 6f, 9.501f)
                verticalLineTo(10f)
                horizontalLineTo(3f)
                verticalLineTo(8f)
                curveTo(3f, 7.448f, 3.448f, 7f, 4f, 7f)
                close()
                moveTo(13f, 11f)
                lineTo(13f, 11.5f)
                curveTo(13f, 11.776f, 13.224f, 12f, 13.5f, 12f)
                curveTo(13.776f, 12f, 14f, 11.776f, 14f, 11.5f)
                lineTo(14f, 11f)
                horizontalLineTo(17.003f)
                verticalLineTo(15f)
                curveTo(17.003f, 15.552f, 16.555f, 16f, 16.003f, 16f)
                horizontalLineTo(4f)
                curveTo(3.448f, 16f, 3f, 15.552f, 3f, 15f)
                verticalLineTo(11f)
                horizontalLineTo(6f)
                verticalLineTo(11.5f)
                curveTo(6f, 11.776f, 6.224f, 12f, 6.5f, 12f)
                curveTo(6.776f, 12f, 7f, 11.776f, 7f, 11.5f)
                verticalLineTo(11f)
                horizontalLineTo(13f)
                close()
            }
        }.build()

        return _Toolbox!!
    }

@Suppress("ObjectPropertyName")
private var _Toolbox: ImageVector? = null
