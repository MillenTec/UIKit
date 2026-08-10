package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.ChevronArrowRight: ImageVector
    get() {
        if (_ChevronArrowRight != null) {
            return _ChevronArrowRight!!
        }
        _ChevronArrowRight = ImageVector.Builder(
            name = "ChevronArrowRight",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(7.646f, 4.147f)
                curveTo(7.841f, 3.951f, 8.157f, 3.951f, 8.353f, 4.146f)
                lineTo(13.837f, 9.611f)
                curveTo(14.053f, 9.826f, 14.053f, 10.175f, 13.837f, 10.39f)
                lineTo(8.353f, 15.855f)
                curveTo(8.157f, 16.05f, 7.841f, 16.049f, 7.646f, 15.854f)
                curveTo(7.451f, 15.658f, 7.451f, 15.342f, 7.647f, 15.147f)
                lineTo(12.812f, 10f)
                lineTo(7.647f, 4.854f)
                curveTo(7.451f, 4.659f, 7.451f, 4.343f, 7.646f, 4.147f)
                close()
            }
        }.build()

        return _ChevronArrowRight!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronArrowRight: ImageVector? = null
