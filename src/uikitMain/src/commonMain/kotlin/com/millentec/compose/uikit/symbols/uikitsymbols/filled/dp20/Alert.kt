package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Alert: ImageVector
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
                moveTo(12.45f, 16.002f)
                curveTo(12.217f, 17.142f, 11.209f, 18f, 10f, 18f)
                curveTo(8.791f, 18f, 7.783f, 17.142f, 7.55f, 16.002f)
                horizontalLineTo(12.45f)
                close()
                moveTo(9.998f, 2f)
                curveTo(13.146f, 2f, 15.741f, 4.335f, 15.982f, 7.355f)
                lineTo(15.995f, 7.578f)
                lineTo(16f, 7.802f)
                lineTo(15.999f, 11.408f)
                lineTo(16.953f, 13.995f)
                lineTo(16.978f, 14.08f)
                lineTo(16.994f, 14.166f)
                lineTo(16.999f, 14.255f)
                curveTo(16.999f, 14.57f, 16.803f, 14.845f, 16.477f, 14.962f)
                lineTo(16.364f, 14.995f)
                lineTo(16.249f, 15.005f)
                horizontalLineTo(3.751f)
                curveTo(3.663f, 15.005f, 3.575f, 14.989f, 3.492f, 14.958f)
                curveTo(3.205f, 14.853f, 3.016f, 14.587f, 3.01f, 14.242f)
                lineTo(3.014f, 14.125f)
                lineTo(3.048f, 13.995f)
                lineTo(3.999f, 11.411f)
                lineTo(4f, 7.793f)
                lineTo(4.004f, 7.568f)
                curveTo(4.127f, 4.451f, 6.771f, 2f, 9.998f, 2f)
                close()
            }
        }.build()

        return _Alert!!
    }

@Suppress("ObjectPropertyName")
private var _Alert: ImageVector? = null
