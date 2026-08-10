package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.MathSymbols: ImageVector
    get() {
        if (_MathSymbols != null) {
            return _MathSymbols!!
        }
        _MathSymbols = ImageVector.Builder(
            name = "MathSymbols",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(4.75f, 5.25f)
                verticalLineTo(7.25f)
                curveTo(4.75f, 7.664f, 5.086f, 8f, 5.5f, 8f)
                curveTo(5.914f, 8f, 6.25f, 7.664f, 6.25f, 7.25f)
                verticalLineTo(5.25f)
                horizontalLineTo(8.25f)
                curveTo(8.664f, 5.25f, 9f, 4.914f, 9f, 4.5f)
                curveTo(9f, 4.086f, 8.664f, 3.75f, 8.25f, 3.75f)
                horizontalLineTo(6.25f)
                verticalLineTo(1.75f)
                curveTo(6.25f, 1.336f, 5.914f, 1f, 5.5f, 1f)
                curveTo(5.086f, 1f, 4.75f, 1.336f, 4.75f, 1.75f)
                verticalLineTo(3.75f)
                horizontalLineTo(2.75f)
                curveTo(2.336f, 3.75f, 2f, 4.086f, 2f, 4.5f)
                curveTo(2f, 4.914f, 2.336f, 5.25f, 2.75f, 5.25f)
                horizontalLineTo(4.75f)
                close()
                moveTo(11f, 4.5f)
                curveTo(11f, 4.086f, 11.336f, 3.75f, 11.75f, 3.75f)
                horizontalLineTo(17.25f)
                curveTo(17.664f, 3.75f, 18f, 4.086f, 18f, 4.5f)
                curveTo(18f, 4.914f, 17.664f, 5.25f, 17.25f, 5.25f)
                horizontalLineTo(11.75f)
                curveTo(11.336f, 5.25f, 11f, 4.914f, 11f, 4.5f)
                close()
                moveTo(2.22f, 11.28f)
                lineTo(4.439f, 13.5f)
                lineTo(2.22f, 15.72f)
                curveTo(1.927f, 16.013f, 1.927f, 16.487f, 2.22f, 16.78f)
                curveTo(2.513f, 17.073f, 2.987f, 17.073f, 3.28f, 16.78f)
                lineTo(5.5f, 14.561f)
                lineTo(7.72f, 16.78f)
                curveTo(8.013f, 17.073f, 8.487f, 17.073f, 8.78f, 16.78f)
                curveTo(9.073f, 16.487f, 9.073f, 16.013f, 8.78f, 15.72f)
                lineTo(6.561f, 13.5f)
                lineTo(8.78f, 11.28f)
                curveTo(9.073f, 10.987f, 9.073f, 10.513f, 8.78f, 10.22f)
                curveTo(8.487f, 9.927f, 8.013f, 9.927f, 7.72f, 10.22f)
                lineTo(5.5f, 12.439f)
                lineTo(3.28f, 10.22f)
                curveTo(2.987f, 9.927f, 2.513f, 9.927f, 2.22f, 10.22f)
                curveTo(1.927f, 10.513f, 1.927f, 10.987f, 2.22f, 11.28f)
                close()
                moveTo(11.75f, 12.75f)
                curveTo(11.336f, 12.75f, 11f, 13.086f, 11f, 13.5f)
                curveTo(11f, 13.914f, 11.336f, 14.25f, 11.75f, 14.25f)
                horizontalLineTo(17.25f)
                curveTo(17.664f, 14.25f, 18f, 13.914f, 18f, 13.5f)
                curveTo(18f, 13.086f, 17.664f, 12.75f, 17.25f, 12.75f)
                horizontalLineTo(11.75f)
                close()
                moveTo(15.5f, 11f)
                curveTo(15.5f, 11.552f, 15.052f, 12f, 14.5f, 12f)
                curveTo(13.948f, 12f, 13.5f, 11.552f, 13.5f, 11f)
                curveTo(13.5f, 10.448f, 13.948f, 10f, 14.5f, 10f)
                curveTo(15.052f, 10f, 15.5f, 10.448f, 15.5f, 11f)
                close()
                moveTo(14.5f, 17f)
                curveTo(15.052f, 17f, 15.5f, 16.552f, 15.5f, 16f)
                curveTo(15.5f, 15.448f, 15.052f, 15f, 14.5f, 15f)
                curveTo(13.948f, 15f, 13.5f, 15.448f, 13.5f, 16f)
                curveTo(13.5f, 16.552f, 13.948f, 17f, 14.5f, 17f)
                close()
            }
        }.build()

        return _MathSymbols!!
    }

@Suppress("ObjectPropertyName")
private var _MathSymbols: ImageVector? = null
