package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Dismiss: ImageVector
    get() {
        if (_Dismiss != null) {
            return _Dismiss!!
        }
        _Dismiss = ImageVector.Builder(
            name = "Dismiss",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(3.897f, 4.054f)
                lineTo(3.97f, 3.97f)
                curveTo(4.236f, 3.703f, 4.653f, 3.679f, 4.946f, 3.897f)
                lineTo(5.03f, 3.97f)
                lineTo(10f, 8.939f)
                lineTo(14.97f, 3.97f)
                curveTo(15.236f, 3.703f, 15.653f, 3.679f, 15.946f, 3.897f)
                lineTo(16.03f, 3.97f)
                curveTo(16.297f, 4.236f, 16.321f, 4.653f, 16.103f, 4.946f)
                lineTo(16.03f, 5.03f)
                lineTo(11.061f, 10f)
                lineTo(16.03f, 14.97f)
                curveTo(16.297f, 15.236f, 16.321f, 15.653f, 16.103f, 15.946f)
                lineTo(16.03f, 16.03f)
                curveTo(15.764f, 16.297f, 15.347f, 16.321f, 15.054f, 16.103f)
                lineTo(14.97f, 16.03f)
                lineTo(10f, 11.061f)
                lineTo(5.03f, 16.03f)
                curveTo(4.764f, 16.297f, 4.347f, 16.321f, 4.054f, 16.103f)
                lineTo(3.97f, 16.03f)
                curveTo(3.703f, 15.764f, 3.679f, 15.347f, 3.897f, 15.054f)
                lineTo(3.97f, 14.97f)
                lineTo(8.939f, 10f)
                lineTo(3.97f, 5.03f)
                curveTo(3.703f, 4.764f, 3.679f, 4.347f, 3.897f, 4.054f)
                lineTo(3.97f, 3.97f)
                lineTo(3.897f, 4.054f)
                close()
            }
        }.build()

        return _Dismiss!!
    }

@Suppress("ObjectPropertyName")
private var _Dismiss: ImageVector? = null
