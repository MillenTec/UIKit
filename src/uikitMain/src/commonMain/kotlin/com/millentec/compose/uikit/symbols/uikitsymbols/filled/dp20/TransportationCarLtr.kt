package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.TransportationCarLtr: ImageVector
    get() {
        if (_TransportationCarLtr != null) {
            return _TransportationCarLtr!!
        }
        _TransportationCarLtr = ImageVector.Builder(
            name = "TransportationCarLtr",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(16.977f, 13.842f)
                curveTo(17.58f, 13.566f, 18f, 12.957f, 18f, 12.25f)
                verticalLineTo(11.037f)
                curveTo(18f, 9.904f, 17.239f, 8.913f, 16.144f, 8.621f)
                lineTo(14.051f, 8.063f)
                lineTo(12.509f, 5.286f)
                curveTo(12.068f, 4.492f, 11.231f, 4f, 10.323f, 4f)
                horizontalLineTo(6.942f)
                curveTo(5.865f, 4f, 4.91f, 4.689f, 4.57f, 5.709f)
                lineTo(3.747f, 8.178f)
                curveTo(2.713f, 8.504f, 2f, 9.465f, 2f, 10.562f)
                verticalLineTo(12.25f)
                curveTo(2f, 12.957f, 2.42f, 13.566f, 3.023f, 13.842f)
                curveTo(3.19f, 15.061f, 4.235f, 16f, 5.5f, 16f)
                curveTo(6.709f, 16f, 7.718f, 15.141f, 7.95f, 14f)
                horizontalLineTo(12.05f)
                curveTo(12.282f, 15.141f, 13.29f, 16f, 14.5f, 16f)
                curveTo(15.764f, 16f, 16.81f, 15.061f, 16.977f, 13.842f)
                close()
                moveTo(6.942f, 5f)
                horizontalLineTo(8f)
                verticalLineTo(8f)
                horizontalLineTo(4.86f)
                lineTo(5.518f, 6.026f)
                curveTo(5.723f, 5.413f, 6.296f, 5f, 6.942f, 5f)
                close()
                moveTo(11.634f, 5.772f)
                lineTo(12.873f, 8f)
                horizontalLineTo(9f)
                verticalLineTo(5f)
                horizontalLineTo(10.323f)
                curveTo(10.868f, 5f, 11.37f, 5.295f, 11.634f, 5.772f)
                close()
                moveTo(4f, 13.5f)
                curveTo(4f, 12.672f, 4.672f, 12f, 5.5f, 12f)
                curveTo(6.328f, 12f, 7f, 12.672f, 7f, 13.5f)
                curveTo(7f, 14.328f, 6.328f, 15f, 5.5f, 15f)
                curveTo(4.672f, 15f, 4f, 14.328f, 4f, 13.5f)
                close()
                moveTo(13f, 13.5f)
                curveTo(13f, 12.672f, 13.672f, 12f, 14.5f, 12f)
                curveTo(15.328f, 12f, 16f, 12.672f, 16f, 13.5f)
                curveTo(16f, 14.328f, 15.328f, 15f, 14.5f, 15f)
                curveTo(13.672f, 15f, 13f, 14.328f, 13f, 13.5f)
                close()
            }
        }.build()

        return _TransportationCarLtr!!
    }

@Suppress("ObjectPropertyName")
private var _TransportationCarLtr: ImageVector? = null
