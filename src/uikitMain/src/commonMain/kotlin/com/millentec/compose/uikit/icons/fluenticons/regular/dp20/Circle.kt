package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Circle: ImageVector
    get() {
        if (_Circle != null) {
            return _Circle!!
        }
        _Circle = ImageVector.Builder(
            name = "Circle",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(10f, 3f)
                curveTo(6.134f, 3f, 3f, 6.134f, 3f, 10f)
                curveTo(3f, 13.866f, 6.134f, 17f, 10f, 17f)
                curveTo(13.866f, 17f, 17f, 13.866f, 17f, 10f)
                curveTo(17f, 6.134f, 13.866f, 3f, 10f, 3f)
                close()
                moveTo(2f, 10f)
                curveTo(2f, 5.582f, 5.582f, 2f, 10f, 2f)
                curveTo(14.418f, 2f, 18f, 5.582f, 18f, 10f)
                curveTo(18f, 14.418f, 14.418f, 18f, 10f, 18f)
                curveTo(5.582f, 18f, 2f, 14.418f, 2f, 10f)
                close()
            }
        }.build()

        return _Circle!!
    }

@Suppress("ObjectPropertyName")
private var _Circle: ImageVector? = null
