package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.MathPi: ImageVector
    get() {
        if (_MathPi != null) {
            return _MathPi!!
        }
        _MathPi = ImageVector.Builder(
            name = "MathPi",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(3.179f, 4.668f)
                curveTo(2.978f, 5.056f, 2.97f, 5.556f, 3.039f, 5.902f)
                curveTo(3.093f, 6.173f, 2.917f, 6.436f, 2.646f, 6.49f)
                curveTo(2.376f, 6.544f, 2.112f, 6.369f, 2.058f, 6.098f)
                curveTo(1.961f, 5.611f, 1.953f, 4.861f, 2.292f, 4.207f)
                curveTo(2.655f, 3.505f, 3.377f, 3f, 4.542f, 3f)
                horizontalLineTo(16.5f)
                curveTo(16.776f, 3f, 17f, 3.224f, 17f, 3.5f)
                curveTo(17f, 3.776f, 16.776f, 4f, 16.5f, 4f)
                horizontalLineTo(14f)
                verticalLineTo(13.665f)
                curveTo(14f, 15.208f, 14.469f, 15.723f, 14.837f, 15.896f)
                curveTo(15.26f, 16.094f, 15.835f, 15.986f, 16.273f, 15.763f)
                curveTo(16.519f, 15.638f, 16.82f, 15.736f, 16.946f, 15.982f)
                curveTo(17.071f, 16.228f, 16.973f, 16.529f, 16.727f, 16.654f)
                curveTo(16.165f, 16.94f, 15.24f, 17.188f, 14.413f, 16.802f)
                curveTo(13.531f, 16.389f, 13f, 15.378f, 13f, 13.665f)
                verticalLineTo(4f)
                horizontalLineTo(8f)
                curveTo(8f, 4.009f, 8f, 4.018f, 7.999f, 4.028f)
                curveTo(7.915f, 5.538f, 7.714f, 8.076f, 7.383f, 10.542f)
                curveTo(7.217f, 11.774f, 7.018f, 12.995f, 6.784f, 14.064f)
                curveTo(6.551f, 15.123f, 6.276f, 16.066f, 5.947f, 16.724f)
                curveTo(5.824f, 16.971f, 5.523f, 17.071f, 5.276f, 16.947f)
                curveTo(5.029f, 16.824f, 4.929f, 16.523f, 5.053f, 16.276f)
                curveTo(5.324f, 15.734f, 5.578f, 14.89f, 5.807f, 13.849f)
                curveTo(6.034f, 12.817f, 6.228f, 11.626f, 6.392f, 10.408f)
                curveTo(6.717f, 7.989f, 6.915f, 5.493f, 6.999f, 4f)
                horizontalLineTo(4.542f)
                curveTo(3.714f, 4f, 3.355f, 4.328f, 3.179f, 4.668f)
                close()
            }
        }.build()

        return _MathPi!!
    }

@Suppress("ObjectPropertyName")
private var _MathPi: ImageVector? = null
