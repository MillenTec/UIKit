package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Moon: ImageVector
    get() {
        if (_Moon != null) {
            return _Moon!!
        }
        _Moon = ImageVector.Builder(
            name = "Moon",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(15.493f, 13.497f)
                curveTo(13.565f, 16.836f, 9.296f, 17.98f, 5.957f, 16.052f)
                curveTo(5.2f, 15.615f, 4.545f, 15.052f, 4.01f, 14.389f)
                curveTo(6.841f, 13.302f, 8.568f, 11.968f, 9.603f, 9.992f)
                curveTo(10.651f, 7.993f, 10.939f, 5.832f, 10.363f, 3.083f)
                curveTo(11.26f, 3.201f, 12.133f, 3.495f, 12.938f, 3.96f)
                curveTo(16.277f, 5.888f, 17.421f, 10.158f, 15.493f, 13.497f)
                close()
                moveTo(5.457f, 16.918f)
                curveTo(9.274f, 19.122f, 14.155f, 17.814f, 16.359f, 13.997f)
                curveTo(18.563f, 10.179f, 17.255f, 5.298f, 13.438f, 3.094f)
                curveTo(12.337f, 2.459f, 11.123f, 2.102f, 9.881f, 2.035f)
                curveTo(9.48f, 2.014f, 9.172f, 2.385f, 9.267f, 2.775f)
                curveTo(9.955f, 5.594f, 9.701f, 7.651f, 8.718f, 9.528f)
                curveTo(7.783f, 11.312f, 6.173f, 12.559f, 3.167f, 13.635f)
                curveTo(2.797f, 13.767f, 2.653f, 14.214f, 2.875f, 14.538f)
                curveTo(3.542f, 15.506f, 4.417f, 16.318f, 5.457f, 16.918f)
                close()
            }
        }.build()

        return _Moon!!
    }

@Suppress("ObjectPropertyName")
private var _Moon: ImageVector? = null
