package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Person: ImageVector
    get() {
        if (_Person != null) {
            return _Person!!
        }
        _Person = ImageVector.Builder(
            name = "Person",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(10f, 2f)
                curveTo(7.791f, 2f, 6f, 3.791f, 6f, 6f)
                curveTo(6f, 8.209f, 7.791f, 10f, 10f, 10f)
                curveTo(12.209f, 10f, 14f, 8.209f, 14f, 6f)
                curveTo(14f, 3.791f, 12.209f, 2f, 10f, 2f)
                close()
                moveTo(5.009f, 11f)
                curveTo(3.903f, 11f, 3f, 11.887f, 3f, 13f)
                curveTo(3f, 14.691f, 3.833f, 15.966f, 5.135f, 16.797f)
                curveTo(6.417f, 17.614f, 8.145f, 18f, 10f, 18f)
                curveTo(11.855f, 18f, 13.583f, 17.614f, 14.865f, 16.797f)
                curveTo(16.167f, 15.966f, 17f, 14.691f, 17f, 13f)
                curveTo(17f, 11.896f, 16.104f, 11f, 15f, 11f)
                lineTo(5.009f, 11f)
                close()
            }
        }.build()

        return _Person!!
    }

@Suppress("ObjectPropertyName")
private var _Person: ImageVector? = null
