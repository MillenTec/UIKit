package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.AddCircle: ImageVector
    get() {
        if (_AddCircle != null) {
            return _AddCircle!!
        }
        _AddCircle = ImageVector.Builder(
            name = "AddCircle",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(18f, 10f)
                curveTo(18f, 14.418f, 14.418f, 18f, 10f, 18f)
                curveTo(5.582f, 18f, 2f, 14.418f, 2f, 10f)
                curveTo(2f, 5.582f, 5.582f, 2f, 10f, 2f)
                curveTo(14.418f, 2f, 18f, 5.582f, 18f, 10f)
                close()
                moveTo(6f, 10f)
                curveTo(6f, 10.276f, 6.224f, 10.5f, 6.5f, 10.5f)
                horizontalLineTo(9.5f)
                verticalLineTo(13.5f)
                curveTo(9.5f, 13.776f, 9.724f, 14f, 10f, 14f)
                curveTo(10.276f, 14f, 10.5f, 13.776f, 10.5f, 13.5f)
                verticalLineTo(10.5f)
                horizontalLineTo(13.5f)
                curveTo(13.776f, 10.5f, 14f, 10.276f, 14f, 10f)
                curveTo(14f, 9.724f, 13.776f, 9.5f, 13.5f, 9.5f)
                horizontalLineTo(10.5f)
                verticalLineTo(6.5f)
                curveTo(10.5f, 6.224f, 10.276f, 6f, 10f, 6f)
                curveTo(9.724f, 6f, 9.5f, 6.224f, 9.5f, 6.5f)
                verticalLineTo(9.5f)
                horizontalLineTo(6.5f)
                curveTo(6.224f, 9.5f, 6f, 9.724f, 6f, 10f)
                close()
            }
        }.build()

        return _AddCircle!!
    }

@Suppress("ObjectPropertyName")
private var _AddCircle: ImageVector? = null
