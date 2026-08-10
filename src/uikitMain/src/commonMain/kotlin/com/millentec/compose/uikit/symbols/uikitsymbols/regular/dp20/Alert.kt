package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Alert: ImageVector
    get() {
        if (_Alert != null) {
            return _Alert!!
        }
        _Alert = ImageVector.Builder(
            name = "Alert",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(9.998f, 2f)
                curveTo(13.147f, 2f, 15.742f, 4.335f, 15.982f, 7.355f)
                lineTo(15.995f, 7.578f)
                lineTo(16f, 7.802f)
                lineTo(15.999f, 11.398f)
                lineTo(16.924f, 13.62f)
                curveTo(16.947f, 13.674f, 16.965f, 13.73f, 16.977f, 13.787f)
                lineTo(16.993f, 13.873f)
                lineTo(17.001f, 14.005f)
                curveTo(17.001f, 14.453f, 16.705f, 14.839f, 16.252f, 14.968f)
                lineTo(16.136f, 14.995f)
                lineTo(16.001f, 15.005f)
                lineTo(12.5f, 15.004f)
                lineTo(12.495f, 15.165f)
                curveTo(12.41f, 16.469f, 11.325f, 17.5f, 10f, 17.5f)
                curveTo(8.675f, 17.5f, 7.59f, 16.469f, 7.505f, 15.164f)
                lineTo(7.5f, 15.004f)
                lineTo(3.999f, 15.005f)
                curveTo(3.911f, 15.005f, 3.824f, 14.993f, 3.739f, 14.97f)
                lineTo(3.615f, 14.928f)
                curveTo(3.204f, 14.757f, 2.962f, 14.339f, 3.012f, 13.876f)
                lineTo(3.033f, 13.748f)
                lineTo(3.076f, 13.62f)
                lineTo(3.999f, 11.401f)
                lineTo(4f, 7.793f)
                lineTo(4.004f, 7.568f)
                curveTo(4.127f, 4.451f, 6.771f, 2f, 9.998f, 2f)
                close()
                moveTo(11.5f, 15.004f)
                horizontalLineTo(8.5f)
                lineTo(8.507f, 15.145f)
                curveTo(8.576f, 15.858f, 9.143f, 16.425f, 9.856f, 16.493f)
                lineTo(10f, 16.5f)
                curveTo(10.78f, 16.5f, 11.42f, 15.905f, 11.493f, 15.144f)
                lineTo(11.5f, 15.004f)
                close()
                moveTo(9.998f, 3f)
                curveTo(7.375f, 3f, 5.227f, 4.924f, 5.017f, 7.385f)
                lineTo(5.004f, 7.597f)
                lineTo(5f, 7.802f)
                verticalLineTo(11.5f)
                lineTo(4.962f, 11.692f)
                lineTo(3.999f, 14.005f)
                lineTo(15.957f, 14.007f)
                lineTo(16.002f, 14.005f)
                lineTo(15.038f, 11.692f)
                lineTo(15f, 11.5f)
                lineTo(15f, 7.812f)
                lineTo(14.996f, 7.608f)
                curveTo(14.891f, 5.035f, 12.695f, 3f, 9.998f, 3f)
                close()
            }
        }.build()

        return _Alert!!
    }

@Suppress("ObjectPropertyName")
private var _Alert: ImageVector? = null
