package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Mail: ImageVector
    get() {
        if (_Mail != null) {
            return _Mail!!
        }
        _Mail = ImageVector.Builder(
            name = "Mail",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(15.5f, 4f)
                curveTo(16.881f, 4f, 18f, 5.119f, 18f, 6.5f)
                verticalLineTo(14.5f)
                curveTo(18f, 15.881f, 16.881f, 17f, 15.5f, 17f)
                horizontalLineTo(4.5f)
                curveTo(3.119f, 17f, 2f, 15.881f, 2f, 14.5f)
                verticalLineTo(6.5f)
                curveTo(2f, 5.119f, 3.119f, 4f, 4.5f, 4f)
                horizontalLineTo(15.5f)
                close()
                moveTo(17f, 7.961f)
                lineTo(10.253f, 11.931f)
                curveTo(10.123f, 12.008f, 9.967f, 12.021f, 9.828f, 11.969f)
                lineTo(9.746f, 11.931f)
                lineTo(3f, 7.963f)
                verticalLineTo(14.5f)
                curveTo(3f, 15.328f, 3.672f, 16f, 4.5f, 16f)
                horizontalLineTo(15.5f)
                curveTo(16.328f, 16f, 17f, 15.328f, 17f, 14.5f)
                verticalLineTo(7.961f)
                close()
                moveTo(15.5f, 5f)
                horizontalLineTo(4.5f)
                curveTo(3.672f, 5f, 3f, 5.672f, 3f, 6.5f)
                verticalLineTo(6.802f)
                lineTo(10f, 10.92f)
                lineTo(17f, 6.801f)
                verticalLineTo(6.5f)
                curveTo(17f, 5.672f, 16.328f, 5f, 15.5f, 5f)
                close()
            }
        }.build()

        return _Mail!!
    }

@Suppress("ObjectPropertyName")
private var _Mail: ImageVector? = null
