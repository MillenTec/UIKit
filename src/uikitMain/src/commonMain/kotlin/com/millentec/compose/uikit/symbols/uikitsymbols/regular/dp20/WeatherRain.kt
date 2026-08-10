package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.WeatherRain: ImageVector
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
                moveTo(10f, 4f)
                curveTo(12.465f, 4f, 13.863f, 5.574f, 14.066f, 7.474f)
                lineTo(14.128f, 7.474f)
                curveTo(15.714f, 7.474f, 17f, 8.711f, 17f, 10.237f)
                curveTo(17f, 11.763f, 15.714f, 13f, 14.128f, 13f)
                lineTo(13.425f, 12.999f)
                lineTo(13.412f, 13.033f)
                lineTo(11.929f, 15.737f)
                curveTo(11.797f, 15.979f, 11.493f, 16.069f, 11.251f, 15.936f)
                curveTo(11.035f, 15.819f, 10.941f, 15.566f, 11.015f, 15.341f)
                lineTo(11.051f, 15.258f)
                lineTo(12.29f, 12.999f)
                horizontalLineTo(10.437f)
                lineTo(10.423f, 13.033f)
                lineTo(8.94f, 15.737f)
                curveTo(8.808f, 15.979f, 8.505f, 16.069f, 8.262f, 15.936f)
                curveTo(8.047f, 15.819f, 7.952f, 15.566f, 8.026f, 15.341f)
                lineTo(8.062f, 15.258f)
                lineTo(9.301f, 12.999f)
                horizontalLineTo(7.432f)
                lineTo(5.94f, 15.737f)
                curveTo(5.823f, 15.952f, 5.57f, 16.047f, 5.345f, 15.972f)
                lineTo(5.262f, 15.936f)
                curveTo(5.046f, 15.819f, 4.952f, 15.566f, 5.026f, 15.341f)
                lineTo(5.062f, 15.258f)
                lineTo(6.293f, 12.999f)
                lineTo(5.872f, 13f)
                curveTo(4.286f, 13f, 3f, 11.763f, 3f, 10.237f)
                curveTo(3f, 8.768f, 4.192f, 7.566f, 5.697f, 7.479f)
                lineTo(5.934f, 7.474f)
                curveTo(6.139f, 5.561f, 7.535f, 4f, 10f, 4f)
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

        return _Rain!!
    }

@Suppress("ObjectPropertyName")
private var _Rain: ImageVector? = null
