package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Add: ImageVector
    get() {
        if (_Add != null) {
            return _Add!!
        }
        _Add = ImageVector.Builder(
            name = "Add",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(10f, 2.5f)
                curveTo(10.276f, 2.5f, 10.5f, 2.724f, 10.5f, 3f)
                verticalLineTo(9.5f)
                horizontalLineTo(17f)
                curveTo(17.276f, 9.5f, 17.5f, 9.724f, 17.5f, 10f)
                curveTo(17.5f, 10.276f, 17.276f, 10.5f, 17f, 10.5f)
                horizontalLineTo(10.5f)
                verticalLineTo(17f)
                curveTo(10.5f, 17.276f, 10.276f, 17.5f, 10f, 17.5f)
                curveTo(9.724f, 17.5f, 9.5f, 17.276f, 9.5f, 17f)
                verticalLineTo(10.5f)
                horizontalLineTo(3f)
                curveTo(2.724f, 10.5f, 2.5f, 10.276f, 2.5f, 10f)
                curveTo(2.5f, 9.724f, 2.724f, 9.5f, 3f, 9.5f)
                horizontalLineTo(9.5f)
                verticalLineTo(3f)
                curveTo(9.5f, 2.724f, 9.724f, 2.5f, 10f, 2.5f)
                close()
            }
        }.build()

        return _Add!!
    }

@Suppress("ObjectPropertyName")
private var _Add: ImageVector? = null
