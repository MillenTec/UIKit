package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Wrench: ImageVector
    get() {
        if (_Wrench != null) {
            return _Wrench!!
        }
        _Wrench = ImageVector.Builder(
            name = "Wrench",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(9f, 6.5f)
                curveTo(9f, 4.015f, 11.014f, 2f, 13.5f, 2f)
                curveTo(14.159f, 2f, 14.786f, 2.142f, 15.352f, 2.398f)
                curveTo(15.502f, 2.466f, 15.608f, 2.602f, 15.638f, 2.764f)
                curveTo(15.667f, 2.925f, 15.616f, 3.091f, 15.5f, 3.207f)
                lineTo(13.207f, 5.5f)
                lineTo(14.5f, 6.793f)
                lineTo(16.792f, 4.5f)
                curveTo(16.909f, 4.384f, 17.074f, 4.332f, 17.236f, 4.362f)
                curveTo(17.397f, 4.391f, 17.534f, 4.498f, 17.602f, 4.648f)
                curveTo(17.857f, 5.213f, 18f, 5.841f, 18f, 6.5f)
                curveTo(18f, 8.985f, 15.985f, 11f, 13.5f, 11f)
                curveTo(13.119f, 11f, 12.749f, 10.953f, 12.395f, 10.863f)
                lineTo(6.03f, 17.311f)
                curveTo(5.183f, 18.17f, 3.824f, 18.25f, 2.881f, 17.497f)
                curveTo(1.796f, 16.63f, 1.692f, 15.018f, 2.656f, 14.018f)
                lineTo(9.082f, 7.359f)
                curveTo(9.028f, 7.081f, 9f, 6.793f, 9f, 6.5f)
                close()
                moveTo(13.5f, 3f)
                curveTo(11.566f, 3f, 10f, 4.567f, 10f, 6.5f)
                curveTo(10f, 6.807f, 10.039f, 7.104f, 10.113f, 7.386f)
                curveTo(10.156f, 7.555f, 10.109f, 7.734f, 9.988f, 7.859f)
                lineTo(3.376f, 14.713f)
                curveTo(2.82f, 15.288f, 2.881f, 16.217f, 3.505f, 16.716f)
                curveTo(4.048f, 17.149f, 4.831f, 17.103f, 5.318f, 16.609f)
                lineTo(11.892f, 9.949f)
                curveTo(12.026f, 9.814f, 12.224f, 9.766f, 12.404f, 9.825f)
                curveTo(12.748f, 9.939f, 13.116f, 10f, 13.5f, 10f)
                curveTo(15.432f, 10f, 17f, 8.433f, 17f, 6.5f)
                curveTo(17f, 6.253f, 16.974f, 6.013f, 16.926f, 5.781f)
                lineTo(14.853f, 7.854f)
                curveTo(14.658f, 8.049f, 14.341f, 8.049f, 14.146f, 7.854f)
                lineTo(12.146f, 5.854f)
                curveTo(12.052f, 5.76f, 12f, 5.633f, 12f, 5.5f)
                curveTo(12f, 5.367f, 12.052f, 5.24f, 12.146f, 5.146f)
                lineTo(14.219f, 3.074f)
                curveTo(13.987f, 3.025f, 13.746f, 3f, 13.5f, 3f)
                close()
            }
        }.build()

        return _Wrench!!
    }

@Suppress("ObjectPropertyName")
private var _Wrench: ImageVector? = null
