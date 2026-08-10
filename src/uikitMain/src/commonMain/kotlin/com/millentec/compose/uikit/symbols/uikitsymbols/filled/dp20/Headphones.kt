package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Headphones: ImageVector
    get() {
        if (_Headphones != null) {
            return _Headphones!!
        }
        _Headphones = ImageVector.Builder(
            name = "Headphones",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(3f, 10f)
                curveTo(3f, 6.134f, 6.134f, 3f, 10f, 3f)
                curveTo(13.866f, 3f, 17f, 6.134f, 17f, 10f)
                verticalLineTo(11f)
                horizontalLineTo(13.5f)
                curveTo(13.224f, 11f, 13f, 11.224f, 13f, 11.5f)
                verticalLineTo(17.5f)
                curveTo(13f, 17.776f, 13.224f, 18f, 13.5f, 18f)
                horizontalLineTo(16f)
                curveTo(17.105f, 18f, 18f, 17.105f, 18f, 16f)
                verticalLineTo(10f)
                curveTo(18f, 5.582f, 14.418f, 2f, 10f, 2f)
                curveTo(5.582f, 2f, 2f, 5.582f, 2f, 10f)
                verticalLineTo(16f)
                curveTo(2f, 17.105f, 2.895f, 18f, 4f, 18f)
                horizontalLineTo(6.5f)
                curveTo(6.776f, 18f, 7f, 17.776f, 7f, 17.5f)
                verticalLineTo(11.5f)
                curveTo(7f, 11.224f, 6.776f, 11f, 6.5f, 11f)
                horizontalLineTo(3f)
                verticalLineTo(10f)
                close()
            }
        }.build()

        return _Headphones!!
    }

@Suppress("ObjectPropertyName")
private var _Headphones: ImageVector? = null
