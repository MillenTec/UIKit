package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Tag: ImageVector
    get() {
        if (_Tag != null) {
            return _Tag!!
        }
        _Tag = ImageVector.Builder(
            name = "Tag",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(18.007f, 4.033f)
                curveTo(18.005f, 2.935f, 17.118f, 2.043f, 16.02f, 2.036f)
                lineTo(11.129f, 2.004f)
                curveTo(10.595f, 2f, 10.082f, 2.211f, 9.704f, 2.588f)
                lineTo(3.022f, 9.252f)
                curveTo(2.239f, 10.033f, 2.239f, 11.301f, 3.02f, 12.083f)
                lineTo(7.969f, 17.031f)
                curveTo(8.75f, 17.812f, 10.016f, 17.812f, 10.797f, 17.031f)
                lineTo(17.428f, 10.4f)
                curveTo(17.804f, 10.024f, 18.015f, 9.515f, 18.014f, 8.983f)
                lineTo(18.007f, 4.033f)
                close()
                moveTo(14f, 7f)
                curveTo(13.448f, 7f, 13f, 6.552f, 13f, 6f)
                curveTo(13f, 5.448f, 13.448f, 5f, 14f, 5f)
                curveTo(14.552f, 5f, 15f, 5.448f, 15f, 6f)
                curveTo(15f, 6.552f, 14.552f, 7f, 14f, 7f)
                close()
            }
        }.build()

        return _Tag!!
    }

@Suppress("ObjectPropertyName")
private var _Tag: ImageVector? = null
