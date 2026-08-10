package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.MathPi: ImageVector
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
                moveTo(3.401f, 4.783f)
                curveTo(3.235f, 5.104f, 3.222f, 5.542f, 3.284f, 5.853f)
                curveTo(3.365f, 6.26f, 3.101f, 6.655f, 2.695f, 6.736f)
                curveTo(2.289f, 6.817f, 1.894f, 6.553f, 1.813f, 6.147f)
                curveTo(1.709f, 5.625f, 1.696f, 4.813f, 2.07f, 4.092f)
                curveTo(2.48f, 3.3f, 3.292f, 2.75f, 4.542f, 2.75f)
                horizontalLineTo(16.5f)
                curveTo(16.914f, 2.75f, 17.25f, 3.086f, 17.25f, 3.5f)
                curveTo(17.25f, 3.914f, 16.914f, 4.25f, 16.5f, 4.25f)
                horizontalLineTo(14.25f)
                verticalLineTo(13.665f)
                curveTo(14.25f, 15.166f, 14.703f, 15.557f, 14.943f, 15.669f)
                curveTo(15.265f, 15.82f, 15.752f, 15.748f, 16.16f, 15.54f)
                curveTo(16.529f, 15.352f, 16.981f, 15.5f, 17.168f, 15.869f)
                curveTo(17.356f, 16.238f, 17.209f, 16.689f, 16.84f, 16.877f)
                curveTo(16.248f, 17.178f, 15.235f, 17.462f, 14.307f, 17.028f)
                curveTo(13.297f, 16.555f, 12.75f, 15.42f, 12.75f, 13.665f)
                verticalLineTo(4.25f)
                horizontalLineTo(8.237f)
                curveTo(8.146f, 5.783f, 7.948f, 8.211f, 7.631f, 10.575f)
                curveTo(7.465f, 11.811f, 7.264f, 13.04f, 7.028f, 14.117f)
                curveTo(6.794f, 15.181f, 6.514f, 16.149f, 6.171f, 16.835f)
                curveTo(5.985f, 17.206f, 5.535f, 17.356f, 5.164f, 17.171f)
                curveTo(4.794f, 16.986f, 4.644f, 16.535f, 4.829f, 16.165f)
                curveTo(5.086f, 15.651f, 5.335f, 14.832f, 5.563f, 13.795f)
                curveTo(5.787f, 12.773f, 5.981f, 11.589f, 6.144f, 10.375f)
                curveTo(6.45f, 8.101f, 6.643f, 5.758f, 6.734f, 4.25f)
                horizontalLineTo(4.542f)
                curveTo(3.798f, 4.25f, 3.53f, 4.534f, 3.401f, 4.783f)
                close()
            }
        }.build()

        return _MathPi!!
    }

@Suppress("ObjectPropertyName")
private var _MathPi: ImageVector? = null
