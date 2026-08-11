package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Square: ImageVector
    get() {
        if (_Square != null) {
            return _Square!!
        }
        _Square = ImageVector.Builder(
            name = "Square",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(3f, 6f)
                curveTo(3f, 4.343f, 4.343f, 3f, 6f, 3f)
                horizontalLineTo(14f)
                curveTo(15.657f, 3f, 17f, 4.343f, 17f, 6f)
                verticalLineTo(14f)
                curveTo(17f, 15.657f, 15.657f, 17f, 14f, 17f)
                horizontalLineTo(6f)
                curveTo(4.343f, 17f, 3f, 15.657f, 3f, 14f)
                verticalLineTo(6f)
                close()
            }
        }.build()

        return _Square!!
    }

@Suppress("ObjectPropertyName")
private var _Square: ImageVector? = null
