package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Send: ImageVector
    get() {
        if (_Send != null) {
            return _Send!!
        }
        _Send = ImageVector.Builder(
            name = "Send",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(2.724f, 2.053f)
                curveTo(2.548f, 1.965f, 2.337f, 1.988f, 2.184f, 2.112f)
                curveTo(2.032f, 2.237f, 1.966f, 2.439f, 2.017f, 2.629f)
                lineTo(3.515f, 8.247f)
                curveTo(3.566f, 8.436f, 3.722f, 8.579f, 3.916f, 8.611f)
                lineTo(10.77f, 9.753f)
                curveTo(11.049f, 9.8f, 11.049f, 10.2f, 10.77f, 10.247f)
                lineTo(3.916f, 11.389f)
                curveTo(3.722f, 11.421f, 3.566f, 11.564f, 3.515f, 11.753f)
                lineTo(2.017f, 17.371f)
                curveTo(1.966f, 17.561f, 2.032f, 17.763f, 2.184f, 17.888f)
                curveTo(2.337f, 18.012f, 2.548f, 18.035f, 2.724f, 17.947f)
                lineTo(17.724f, 10.447f)
                curveTo(17.893f, 10.363f, 18f, 10.189f, 18f, 10f)
                curveTo(18f, 9.811f, 17.893f, 9.637f, 17.724f, 9.553f)
                lineTo(2.724f, 2.053f)
                close()
            }
        }.build()

        return _Send!!
    }

@Suppress("ObjectPropertyName")
private var _Send: ImageVector? = null
