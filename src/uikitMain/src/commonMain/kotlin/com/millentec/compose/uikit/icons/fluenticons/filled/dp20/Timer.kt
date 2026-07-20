package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Timer: ImageVector
    get() {
        if (_Timer != null) {
            return _Timer!!
        }
        _Timer = ImageVector.Builder(
            name = "Timer",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(7f, 2.5f)
                curveTo(7f, 2.224f, 7.224f, 2f, 7.5f, 2f)
                horizontalLineTo(11.5f)
                curveTo(11.776f, 2f, 12f, 2.224f, 12f, 2.5f)
                curveTo(12f, 2.776f, 11.776f, 3f, 11.5f, 3f)
                horizontalLineTo(7.5f)
                curveTo(7.224f, 3f, 7f, 2.776f, 7f, 2.5f)
                close()
                moveTo(14.449f, 3.929f)
                curveTo(14.644f, 3.734f, 14.961f, 3.734f, 15.156f, 3.929f)
                lineTo(16.57f, 5.343f)
                curveTo(16.766f, 5.538f, 16.766f, 5.855f, 16.57f, 6.05f)
                curveTo(16.375f, 6.246f, 16.059f, 6.246f, 15.863f, 6.05f)
                lineTo(14.449f, 4.636f)
                curveTo(14.254f, 4.441f, 14.254f, 4.124f, 14.449f, 3.929f)
                close()
                moveTo(16.5f, 11f)
                curveTo(16.5f, 14.866f, 13.366f, 18f, 9.5f, 18f)
                curveTo(5.634f, 18f, 2.5f, 14.866f, 2.5f, 11f)
                curveTo(2.5f, 7.134f, 5.634f, 4f, 9.5f, 4f)
                curveTo(13.366f, 4f, 16.5f, 7.134f, 16.5f, 11f)
                close()
                moveTo(9f, 6.5f)
                verticalLineTo(11.5f)
                curveTo(9f, 11.776f, 9.224f, 12f, 9.5f, 12f)
                curveTo(9.776f, 12f, 10f, 11.776f, 10f, 11.5f)
                verticalLineTo(6.5f)
                curveTo(10f, 6.224f, 9.776f, 6f, 9.5f, 6f)
                curveTo(9.224f, 6f, 9f, 6.224f, 9f, 6.5f)
                close()
            }
        }.build()

        return _Timer!!
    }

@Suppress("ObjectPropertyName")
private var _Timer: ImageVector? = null
