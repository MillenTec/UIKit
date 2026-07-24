package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Delete: ImageVector
    get() {
        if (_Delete != null) {
            return _Delete!!
        }
        _Delete = ImageVector.Builder(
            name = "Delete",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(8.5f, 4f)
                horizontalLineTo(11.5f)
                curveTo(11.5f, 3.172f, 10.828f, 2.5f, 10f, 2.5f)
                curveTo(9.172f, 2.5f, 8.5f, 3.172f, 8.5f, 4f)
                close()
                moveTo(7.5f, 4f)
                curveTo(7.5f, 2.619f, 8.619f, 1.5f, 10f, 1.5f)
                curveTo(11.381f, 1.5f, 12.5f, 2.619f, 12.5f, 4f)
                horizontalLineTo(17.5f)
                curveTo(17.776f, 4f, 18f, 4.224f, 18f, 4.5f)
                curveTo(18f, 4.776f, 17.776f, 5f, 17.5f, 5f)
                horizontalLineTo(16.446f)
                lineTo(15.252f, 15.344f)
                curveTo(15.077f, 16.858f, 13.796f, 18f, 12.272f, 18f)
                horizontalLineTo(7.728f)
                curveTo(6.204f, 18f, 4.923f, 16.858f, 4.748f, 15.344f)
                lineTo(3.554f, 5f)
                horizontalLineTo(2.5f)
                curveTo(2.224f, 5f, 2f, 4.776f, 2f, 4.5f)
                curveTo(2f, 4.224f, 2.224f, 4f, 2.5f, 4f)
                horizontalLineTo(7.5f)
                close()
                moveTo(9f, 8f)
                curveTo(9f, 7.724f, 8.776f, 7.5f, 8.5f, 7.5f)
                curveTo(8.224f, 7.5f, 8f, 7.724f, 8f, 8f)
                verticalLineTo(14f)
                curveTo(8f, 14.276f, 8.224f, 14.5f, 8.5f, 14.5f)
                curveTo(8.776f, 14.5f, 9f, 14.276f, 9f, 14f)
                verticalLineTo(8f)
                close()
                moveTo(11.5f, 7.5f)
                curveTo(11.224f, 7.5f, 11f, 7.724f, 11f, 8f)
                verticalLineTo(14f)
                curveTo(11f, 14.276f, 11.224f, 14.5f, 11.5f, 14.5f)
                curveTo(11.776f, 14.5f, 12f, 14.276f, 12f, 14f)
                verticalLineTo(8f)
                curveTo(12f, 7.724f, 11.776f, 7.5f, 11.5f, 7.5f)
                close()
            }
        }.build()

        return _Delete!!
    }

@Suppress("ObjectPropertyName")
private var _Delete: ImageVector? = null
