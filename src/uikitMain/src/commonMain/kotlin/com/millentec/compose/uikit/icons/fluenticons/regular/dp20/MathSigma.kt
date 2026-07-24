package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.MathSigma: ImageVector
    get() {
        if (_MathSigma != null) {
            return _MathSigma!!
        }
        _MathSigma = ImageVector.Builder(
            name = "MathSigma",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(4.04f, 3.804f)
                curveTo(4.118f, 3.62f, 4.3f, 3.5f, 4.5f, 3.5f)
                horizontalLineTo(15.5f)
                curveTo(15.776f, 3.5f, 16f, 3.724f, 16f, 4f)
                curveTo(16f, 4.276f, 15.776f, 4.5f, 15.5f, 4.5f)
                horizontalLineTo(5.675f)
                lineTo(10.228f, 9.232f)
                curveTo(10.405f, 9.415f, 10.415f, 9.703f, 10.251f, 9.899f)
                lineTo(5.57f, 15.5f)
                horizontalLineTo(15.5f)
                curveTo(15.776f, 15.5f, 16f, 15.724f, 16f, 16f)
                curveTo(16f, 16.276f, 15.776f, 16.5f, 15.5f, 16.5f)
                horizontalLineTo(4.5f)
                curveTo(4.306f, 16.5f, 4.129f, 16.388f, 4.047f, 16.212f)
                curveTo(3.965f, 16.036f, 3.992f, 15.828f, 4.116f, 15.679f)
                lineTo(9.196f, 9.602f)
                lineTo(4.14f, 4.347f)
                curveTo(4.001f, 4.202f, 3.961f, 3.989f, 4.04f, 3.804f)
                close()
            }
        }.build()

        return _MathSigma!!
    }

@Suppress("ObjectPropertyName")
private var _MathSigma: ImageVector? = null
