package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.WeatherRain: ImageVector
    get() {
        if (_Rain != null) {
            return _Rain!!
        }
        _Rain = ImageVector.Builder(
            name = "WeatherRain",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(10.015f, 4.018f)
                curveTo(12.48f, 4.018f, 13.878f, 5.591f, 14.081f, 7.492f)
                lineTo(14.143f, 7.492f)
                curveTo(15.729f, 7.492f, 17.015f, 8.729f, 17.015f, 10.255f)
                curveTo(17.015f, 11.781f, 15.729f, 13.018f, 14.143f, 13.018f)
                lineTo(13.427f, 13.017f)
                lineTo(13.417f, 13.042f)
                lineTo(11.934f, 15.746f)
                curveTo(11.802f, 15.988f, 11.498f, 16.077f, 11.255f, 15.945f)
                curveTo(11.04f, 15.828f, 10.945f, 15.575f, 11.02f, 15.35f)
                lineTo(11.056f, 15.267f)
                lineTo(12.291f, 13.017f)
                horizontalLineTo(10.438f)
                lineTo(10.428f, 13.042f)
                lineTo(8.945f, 15.746f)
                curveTo(8.813f, 15.988f, 8.509f, 16.077f, 8.266f, 15.945f)
                curveTo(8.051f, 15.828f, 7.956f, 15.575f, 8.031f, 15.35f)
                lineTo(8.067f, 15.267f)
                lineTo(9.302f, 13.017f)
                horizontalLineTo(7.431f)
                lineTo(5.945f, 15.746f)
                curveTo(5.828f, 15.961f, 5.575f, 16.056f, 5.349f, 15.981f)
                lineTo(5.267f, 15.945f)
                curveTo(5.051f, 15.828f, 4.957f, 15.575f, 5.031f, 15.35f)
                lineTo(5.067f, 15.267f)
                lineTo(6.292f, 13.017f)
                lineTo(5.887f, 13.018f)
                curveTo(4.301f, 13.018f, 3.015f, 11.781f, 3.015f, 10.255f)
                curveTo(3.015f, 8.785f, 4.207f, 7.584f, 5.712f, 7.497f)
                lineTo(5.949f, 7.492f)
                curveTo(6.154f, 5.579f, 7.551f, 4.018f, 10.015f, 4.018f)
                close()
            }
        }.build()

        return _Rain!!
    }

@Suppress("ObjectPropertyName")
private var _Rain: ImageVector? = null
