package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.ArrowTrending: ImageVector
    get() {
        if (_ArrowTrending != null) {
            return _ArrowTrending!!
        }
        _ArrowTrending = ImageVector.Builder(
            name = "ArrowTrending",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(17.943f, 5.463f)
                curveTo(17.907f, 5.375f, 17.853f, 5.293f, 17.782f, 5.221f)
                lineTo(17.78f, 5.22f)
                lineTo(17.779f, 5.218f)
                curveTo(17.643f, 5.083f, 17.456f, 5f, 17.25f, 5f)
                horizontalLineTo(11.75f)
                curveTo(11.336f, 5f, 11f, 5.336f, 11f, 5.75f)
                curveTo(11f, 6.164f, 11.336f, 6.5f, 11.75f, 6.5f)
                horizontalLineTo(15.439f)
                lineTo(10.5f, 11.439f)
                lineTo(8.53f, 9.47f)
                curveTo(8.237f, 9.177f, 7.763f, 9.177f, 7.47f, 9.47f)
                lineTo(2.22f, 14.72f)
                curveTo(1.927f, 15.013f, 1.927f, 15.487f, 2.22f, 15.78f)
                curveTo(2.513f, 16.073f, 2.987f, 16.073f, 3.28f, 15.78f)
                lineTo(8f, 11.061f)
                lineTo(9.97f, 13.03f)
                curveTo(10.263f, 13.323f, 10.737f, 13.323f, 11.03f, 13.03f)
                lineTo(16.5f, 7.561f)
                verticalLineTo(11.25f)
                curveTo(16.5f, 11.664f, 16.836f, 12f, 17.25f, 12f)
                curveTo(17.664f, 12f, 18f, 11.664f, 18f, 11.25f)
                verticalLineTo(5.75f)
                curveTo(18f, 5.648f, 17.98f, 5.551f, 17.943f, 5.463f)
                close()
            }
        }.build()

        return _ArrowTrending!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowTrending: ImageVector? = null
