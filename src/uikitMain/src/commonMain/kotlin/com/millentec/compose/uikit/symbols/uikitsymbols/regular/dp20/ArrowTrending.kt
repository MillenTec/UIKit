package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.ArrowTrending: ImageVector
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
                moveTo(17.962f, 5.309f)
                curveTo(17.938f, 5.25f, 17.902f, 5.194f, 17.854f, 5.146f)
                curveTo(17.806f, 5.099f, 17.75f, 5.062f, 17.691f, 5.038f)
                curveTo(17.632f, 5.013f, 17.568f, 5f, 17.5f, 5f)
                horizontalLineTo(11.5f)
                curveTo(11.224f, 5f, 11f, 5.224f, 11f, 5.5f)
                curveTo(11f, 5.776f, 11.224f, 6f, 11.5f, 6f)
                horizontalLineTo(16.293f)
                lineTo(10.5f, 11.793f)
                lineTo(8.354f, 9.646f)
                curveTo(8.158f, 9.451f, 7.842f, 9.451f, 7.646f, 9.646f)
                lineTo(2.146f, 15.146f)
                curveTo(1.951f, 15.342f, 1.951f, 15.658f, 2.146f, 15.854f)
                curveTo(2.342f, 16.049f, 2.658f, 16.049f, 2.854f, 15.854f)
                lineTo(8f, 10.707f)
                lineTo(10.146f, 12.854f)
                curveTo(10.342f, 13.049f, 10.658f, 13.049f, 10.854f, 12.854f)
                lineTo(17f, 6.707f)
                verticalLineTo(11.5f)
                curveTo(17f, 11.776f, 17.224f, 12f, 17.5f, 12f)
                curveTo(17.776f, 12f, 18f, 11.776f, 18f, 11.5f)
                verticalLineTo(5.5f)
                curveTo(18f, 5.432f, 17.986f, 5.368f, 17.962f, 5.309f)
                close()
            }
        }.build()

        return _ArrowTrending!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowTrending: ImageVector? = null
