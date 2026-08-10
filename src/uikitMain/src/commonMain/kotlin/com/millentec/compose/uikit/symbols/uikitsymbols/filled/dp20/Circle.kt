package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Circle: ImageVector
    get() {
        if (_Circle != null) {
            return _Circle!!
        }
        _Circle = ImageVector.Builder(
            name = "Circle",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(10f, 2f)
                curveTo(5.582f, 2f, 2f, 5.582f, 2f, 10f)
                curveTo(2f, 14.418f, 5.582f, 18f, 10f, 18f)
                curveTo(14.418f, 18f, 18f, 14.418f, 18f, 10f)
                curveTo(18f, 5.582f, 14.418f, 2f, 10f, 2f)
                close()
            }
        }.build()

        return _Circle!!
    }

@Suppress("ObjectPropertyName")
private var _Circle: ImageVector? = null
