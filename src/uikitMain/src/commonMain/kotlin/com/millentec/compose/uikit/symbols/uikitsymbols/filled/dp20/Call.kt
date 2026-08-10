package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Call: ImageVector
    get() {
        if (_Call != null) {
            return _Call!!
        }
        _Call = ImageVector.Builder(
            name = "Call",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(6.987f, 2.066f)
                curveTo(7.895f, 1.792f, 8.863f, 2.195f, 9.314f, 3.012f)
                lineTo(9.388f, 3.161f)
                lineTo(10.05f, 4.632f)
                curveTo(10.462f, 5.55f, 10.282f, 6.619f, 9.608f, 7.35f)
                lineTo(9.475f, 7.482f)
                lineTo(8.432f, 8.455f)
                curveTo(8.244f, 8.633f, 8.385f, 9.322f, 9.065f, 10.5f)
                curveTo(9.677f, 11.56f, 10.175f, 12.055f, 10.42f, 12.082f)
                lineTo(10.463f, 12.082f)
                lineTo(10.516f, 12.072f)
                lineTo(12.566f, 11.445f)
                curveTo(13.133f, 11.271f, 13.744f, 11.449f, 14.13f, 11.887f)
                lineTo(14.222f, 12.001f)
                lineTo(15.578f, 13.882f)
                curveTo(16.13f, 14.646f, 16.069f, 15.684f, 15.453f, 16.378f)
                lineTo(15.331f, 16.504f)
                lineTo(14.789f, 17.018f)
                curveTo(13.795f, 17.959f, 12.344f, 18.235f, 11.074f, 17.723f)
                curveTo(9.139f, 16.943f, 7.381f, 15.161f, 5.784f, 12.394f)
                curveTo(4.183f, 9.622f, 3.519f, 7.204f, 3.816f, 5.136f)
                curveTo(4f, 3.855f, 4.873f, 2.787f, 6.077f, 2.346f)
                lineTo(6.27f, 2.282f)
                lineTo(6.987f, 2.066f)
                close()
            }
        }.build()

        return _Call!!
    }

@Suppress("ObjectPropertyName")
private var _Call: ImageVector? = null
