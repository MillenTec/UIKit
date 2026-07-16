package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.ZoomOut: ImageVector
    get() {
        if (_ZoomOut != null) {
            return _ZoomOut!!
        }
        _ZoomOut = ImageVector.Builder(
            name = "ZoomOut",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(8.5f, 2f)
                curveTo(12.09f, 2f, 15f, 4.91f, 15f, 8.5f)
                curveTo(15f, 10.115f, 14.411f, 11.593f, 13.436f, 12.729f)
                lineTo(16.854f, 16.146f)
                curveTo(17.049f, 16.342f, 17.049f, 16.658f, 16.854f, 16.854f)
                curveTo(16.68f, 17.027f, 16.411f, 17.046f, 16.216f, 16.911f)
                lineTo(16.146f, 16.854f)
                lineTo(12.729f, 13.436f)
                curveTo(11.593f, 14.411f, 10.115f, 15f, 8.5f, 15f)
                curveTo(4.91f, 15f, 2f, 12.09f, 2f, 8.5f)
                curveTo(2f, 4.91f, 4.91f, 2f, 8.5f, 2f)
                close()
                moveTo(6f, 8f)
                curveTo(5.724f, 8f, 5.5f, 8.224f, 5.5f, 8.5f)
                curveTo(5.5f, 8.776f, 5.724f, 9f, 6f, 9f)
                horizontalLineTo(11f)
                curveTo(11.276f, 9f, 11.5f, 8.776f, 11.5f, 8.5f)
                curveTo(11.5f, 8.224f, 11.276f, 8f, 11f, 8f)
                horizontalLineTo(6f)
                close()
            }
        }.build()

        return _ZoomOut!!
    }

@Suppress("ObjectPropertyName")
private var _ZoomOut: ImageVector? = null

