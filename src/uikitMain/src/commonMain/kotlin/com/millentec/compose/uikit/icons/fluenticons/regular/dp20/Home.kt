package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Home: ImageVector
    get() {
        if (_Home != null) {
            return _Home!!
        }
        _Home = ImageVector.Builder(
            name = "Home",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(8.998f, 2.388f)
                curveTo(9.568f, 1.876f, 10.432f, 1.876f, 11.002f, 2.388f)
                lineTo(16.503f, 7.33f)
                curveTo(16.819f, 7.614f, 17f, 8.02f, 17f, 8.445f)
                verticalLineTo(15.5f)
                curveTo(17f, 16.328f, 16.328f, 17f, 15.5f, 17f)
                horizontalLineTo(13f)
                curveTo(12.172f, 17f, 11.5f, 16.328f, 11.5f, 15.5f)
                verticalLineTo(12f)
                curveTo(11.5f, 11.723f, 11.276f, 11.5f, 11f, 11.5f)
                horizontalLineTo(9f)
                curveTo(8.724f, 11.5f, 8.5f, 11.723f, 8.5f, 12f)
                verticalLineTo(15.5f)
                curveTo(8.5f, 16.328f, 7.828f, 17f, 7f, 17f)
                horizontalLineTo(4.5f)
                curveTo(3.672f, 17f, 3f, 16.328f, 3f, 15.5f)
                verticalLineTo(8.445f)
                curveTo(3f, 8.02f, 3.181f, 7.614f, 3.497f, 7.33f)
                lineTo(8.998f, 2.388f)
                close()
                moveTo(10.334f, 3.132f)
                curveTo(10.144f, 2.961f, 9.856f, 2.961f, 9.666f, 3.132f)
                lineTo(4.166f, 8.074f)
                curveTo(4.06f, 8.168f, 4f, 8.304f, 4f, 8.445f)
                verticalLineTo(15.5f)
                curveTo(4f, 15.776f, 4.224f, 16f, 4.5f, 16f)
                horizontalLineTo(7f)
                curveTo(7.276f, 16f, 7.5f, 15.776f, 7.5f, 15.5f)
                verticalLineTo(12f)
                curveTo(7.5f, 11.171f, 8.172f, 10.5f, 9f, 10.5f)
                horizontalLineTo(11f)
                curveTo(11.828f, 10.5f, 12.5f, 11.171f, 12.5f, 12f)
                verticalLineTo(15.5f)
                curveTo(12.5f, 15.776f, 12.724f, 16f, 13f, 16f)
                horizontalLineTo(15.5f)
                curveTo(15.776f, 16f, 16f, 15.776f, 16f, 15.5f)
                verticalLineTo(8.445f)
                curveTo(16f, 8.304f, 15.94f, 8.168f, 15.834f, 8.074f)
                lineTo(10.334f, 3.132f)
                close()
            }
        }.build()

        return _Home!!
    }

@Suppress("ObjectPropertyName")
private var _Home: ImageVector? = null
