package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Cloud: ImageVector
    get() {
        if (_Cloud != null) {
            return _Cloud!!
        }
        _Cloud = ImageVector.Builder(
            name = "Cloud",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(10f, 4f)
                curveTo(12.817f, 4f, 14.415f, 5.923f, 14.647f, 8.246f)
                lineTo(14.718f, 8.246f)
                curveTo(16.531f, 8.246f, 18f, 9.758f, 18f, 11.623f)
                curveTo(18f, 13.488f, 16.531f, 15f, 14.718f, 15f)
                horizontalLineTo(5.282f)
                curveTo(3.469f, 15f, 2f, 13.488f, 2f, 11.623f)
                curveTo(2f, 9.758f, 3.469f, 8.246f, 5.282f, 8.246f)
                lineTo(5.353f, 8.246f)
                curveTo(5.587f, 5.908f, 7.183f, 4f, 10f, 4f)
                close()
            }
        }.build()

        return _Cloud!!
    }

@Suppress("ObjectPropertyName")
private var _Cloud: ImageVector? = null
