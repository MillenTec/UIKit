package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.ChevronArrowDown: ImageVector
    get() {
        if (_ChevronArrowDown != null) {
            return _ChevronArrowDown!!
        }
        _ChevronArrowDown = ImageVector.Builder(
            name = "ChevronArrowDown",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(15.794f, 7.733f)
                curveTo(16.08f, 8.033f, 16.068f, 8.507f, 15.768f, 8.793f)
                lineTo(10.518f, 13.794f)
                curveTo(10.228f, 14.07f, 9.773f, 14.07f, 9.483f, 13.794f)
                lineTo(4.233f, 8.793f)
                curveTo(3.933f, 8.507f, 3.921f, 8.033f, 4.207f, 7.733f)
                curveTo(4.493f, 7.433f, 4.967f, 7.421f, 5.267f, 7.707f)
                lineTo(10f, 12.215f)
                lineTo(14.734f, 7.707f)
                curveTo(15.034f, 7.421f, 15.508f, 7.433f, 15.794f, 7.733f)
                close()
            }
        }.build()

        return _ChevronArrowDown!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronArrowDown: ImageVector? = null
