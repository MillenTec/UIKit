package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.WeatherRainSnow: ImageVector
    get() {
        if (_RainSnow != null) {
            return _RainSnow!!
        }
        _RainSnow = ImageVector.Builder(
            name = "WeatherRainSnow",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(10f, 4f)
                curveTo(12.465f, 4f, 13.863f, 5.574f, 14.066f, 7.474f)
                lineTo(14.128f, 7.474f)
                curveTo(15.714f, 7.474f, 17f, 8.711f, 17f, 10.237f)
                curveTo(17f, 11.763f, 15.714f, 13f, 14.128f, 13f)
                lineTo(12.626f, 12.999f)
                curveTo(12.643f, 13.049f, 12.652f, 13.103f, 12.652f, 13.158f)
                curveTo(12.652f, 13.434f, 12.428f, 13.658f, 12.152f, 13.658f)
                curveTo(11.876f, 13.658f, 11.652f, 13.434f, 11.652f, 13.158f)
                curveTo(11.652f, 13.103f, 11.661f, 13.049f, 11.678f, 12.999f)
                lineTo(7.441f, 12.999f)
                lineTo(5.945f, 15.745f)
                curveTo(5.813f, 15.988f, 5.509f, 16.077f, 5.267f, 15.945f)
                curveTo(5.051f, 15.828f, 4.957f, 15.575f, 5.031f, 15.35f)
                lineTo(5.067f, 15.267f)
                lineTo(6.302f, 12.999f)
                lineTo(5.872f, 13f)
                curveTo(4.286f, 13f, 3f, 11.763f, 3f, 10.237f)
                curveTo(3f, 8.711f, 4.286f, 7.474f, 5.872f, 7.474f)
                lineTo(5.934f, 7.474f)
                curveTo(6.139f, 5.561f, 7.535f, 4f, 10f, 4f)
                close()
                moveTo(11.5f, 15f)
                curveTo(11.776f, 15f, 12f, 15.224f, 12f, 15.5f)
                curveTo(12f, 15.776f, 11.776f, 16f, 11.5f, 16f)
                curveTo(11.224f, 16f, 11f, 15.776f, 11f, 15.5f)
                curveTo(11f, 15.224f, 11.224f, 15f, 11.5f, 15f)
                close()
                moveTo(9.302f, 14.06f)
                curveTo(9.517f, 14.176f, 9.612f, 14.425f, 9.537f, 14.647f)
                lineTo(9.501f, 14.729f)
                lineTo(8.939f, 15.743f)
                curveTo(8.807f, 15.982f, 8.503f, 16.07f, 8.261f, 15.94f)
                curveTo(8.045f, 15.824f, 7.951f, 15.575f, 8.025f, 15.353f)
                lineTo(8.061f, 15.271f)
                lineTo(8.623f, 14.257f)
                curveTo(8.756f, 14.018f, 9.059f, 13.93f, 9.302f, 14.06f)
                close()
                moveTo(13.5f, 14f)
                curveTo(13.776f, 14f, 14f, 14.224f, 14f, 14.5f)
                curveTo(14f, 14.776f, 13.776f, 15f, 13.5f, 15f)
                curveTo(13.224f, 15f, 13f, 14.776f, 13f, 14.5f)
                curveTo(13f, 14.224f, 13.224f, 14f, 13.5f, 14f)
                close()
                moveTo(10f, 5f)
                curveTo(8.351f, 5f, 6.913f, 6.27f, 6.913f, 8.025f)
                curveTo(6.913f, 8.303f, 6.659f, 8.521f, 6.368f, 8.521f)
                lineTo(5.818f, 8.521f)
                curveTo(4.814f, 8.521f, 4f, 9.3f, 4f, 10.261f)
                curveTo(4f, 11.221f, 4.814f, 12f, 5.818f, 12f)
                horizontalLineTo(14.182f)
                curveTo(15.186f, 12f, 16f, 11.221f, 16f, 10.261f)
                curveTo(16f, 9.3f, 15.186f, 8.521f, 14.182f, 8.521f)
                lineTo(13.632f, 8.521f)
                curveTo(13.341f, 8.521f, 13.087f, 8.303f, 13.087f, 8.025f)
                curveTo(13.087f, 6.248f, 11.649f, 5f, 10f, 5f)
                close()
            }
        }.build()

        return _RainSnow!!
    }

@Suppress("ObjectPropertyName")
private var _RainSnow: ImageVector? = null
