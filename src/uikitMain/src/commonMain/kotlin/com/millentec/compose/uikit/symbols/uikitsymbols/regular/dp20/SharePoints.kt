package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.SharePoints: ImageVector
    get() {
        if (_SharePoints != null) {
            return _SharePoints!!
        }
        _SharePoints = ImageVector.Builder(
            name = "SharePoints",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(12f, 5.502f)
                curveTo(12f, 4.12f, 13.12f, 3f, 14.502f, 3f)
                curveTo(15.883f, 3f, 17.003f, 4.12f, 17.003f, 5.502f)
                curveTo(17.003f, 6.883f, 15.883f, 8.003f, 14.502f, 8.003f)
                curveTo(13.701f, 8.003f, 12.989f, 7.627f, 12.531f, 7.043f)
                lineTo(7.915f, 9.351f)
                curveTo(7.97f, 9.558f, 8f, 9.776f, 8f, 10f)
                curveTo(8f, 10.224f, 7.97f, 10.442f, 7.915f, 10.649f)
                lineTo(12.533f, 12.957f)
                curveTo(12.99f, 12.374f, 13.701f, 12f, 14.5f, 12f)
                curveTo(15.881f, 12f, 17f, 13.119f, 17f, 14.5f)
                curveTo(17f, 15.881f, 15.881f, 17f, 14.5f, 17f)
                curveTo(13.119f, 17f, 12f, 15.881f, 12f, 14.5f)
                curveTo(12f, 14.276f, 12.03f, 14.058f, 12.085f, 13.851f)
                lineTo(7.467f, 11.543f)
                curveTo(7.01f, 12.126f, 6.299f, 12.5f, 5.5f, 12.5f)
                curveTo(4.119f, 12.5f, 3f, 11.381f, 3f, 10f)
                curveTo(3f, 8.619f, 4.119f, 7.5f, 5.5f, 7.5f)
                curveTo(6.298f, 7.5f, 7.01f, 7.874f, 7.467f, 8.457f)
                lineTo(12.085f, 6.148f)
                curveTo(12.029f, 5.942f, 12f, 5.725f, 12f, 5.502f)
                close()
                moveTo(14.502f, 4f)
                curveTo(13.672f, 4f, 13f, 4.672f, 13f, 5.502f)
                curveTo(13f, 6.331f, 13.672f, 7.003f, 14.502f, 7.003f)
                curveTo(15.331f, 7.003f, 16.003f, 6.331f, 16.003f, 5.502f)
                curveTo(16.003f, 4.672f, 15.331f, 4f, 14.502f, 4f)
                close()
                moveTo(14.5f, 13f)
                curveTo(13.672f, 13f, 13f, 13.672f, 13f, 14.5f)
                curveTo(13f, 15.328f, 13.672f, 16f, 14.5f, 16f)
                curveTo(15.328f, 16f, 16f, 15.328f, 16f, 14.5f)
                curveTo(16f, 13.672f, 15.328f, 13f, 14.5f, 13f)
                close()
                moveTo(4f, 10f)
                curveTo(4f, 10.828f, 4.672f, 11.5f, 5.5f, 11.5f)
                curveTo(6.328f, 11.5f, 7f, 10.828f, 7f, 10f)
                curveTo(7f, 9.172f, 6.328f, 8.5f, 5.5f, 8.5f)
                curveTo(4.672f, 8.5f, 4f, 9.172f, 4f, 10f)
                close()
            }
        }.build()

        return _SharePoints!!
    }

@Suppress("ObjectPropertyName")
private var _SharePoints: ImageVector? = null
