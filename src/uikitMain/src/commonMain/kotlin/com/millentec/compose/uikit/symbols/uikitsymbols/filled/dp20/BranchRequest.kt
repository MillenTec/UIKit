package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.BranchRequest: ImageVector
    get() {
        if (_BranchRequest != null) {
            return _BranchRequest!!
        }
        _BranchRequest = ImageVector.Builder(
            name = "BranchRequest",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(8f, 5f)
                curveTo(8f, 6.486f, 6.919f, 7.72f, 5.5f, 7.959f)
                lineTo(5.5f, 12.042f)
                curveTo(6.919f, 12.28f, 8f, 13.514f, 8f, 15f)
                curveTo(8f, 16.657f, 6.657f, 18f, 5f, 18f)
                curveTo(3.343f, 18f, 2f, 16.657f, 2f, 15f)
                curveTo(2f, 13.514f, 3.081f, 12.28f, 4.5f, 12.042f)
                lineTo(4.5f, 7.959f)
                curveTo(3.081f, 7.72f, 2f, 6.486f, 2f, 5f)
                curveTo(2f, 3.343f, 3.343f, 2f, 5f, 2f)
                curveTo(6.657f, 2f, 8f, 3.343f, 8f, 5f)
                close()
                moveTo(11.854f, 6.854f)
                curveTo(11.658f, 7.049f, 11.342f, 7.049f, 11.146f, 6.854f)
                lineTo(9.146f, 4.854f)
                curveTo(8.951f, 4.658f, 8.951f, 4.342f, 9.146f, 4.146f)
                lineTo(11.146f, 2.146f)
                curveTo(11.342f, 1.951f, 11.658f, 1.951f, 11.854f, 2.146f)
                curveTo(12.049f, 2.342f, 12.049f, 2.658f, 11.854f, 2.854f)
                lineTo(10.707f, 4f)
                horizontalLineTo(12.5f)
                curveTo(14.433f, 4f, 16f, 5.567f, 16f, 7.5f)
                verticalLineTo(12.171f)
                curveTo(17.165f, 12.583f, 18f, 13.694f, 18f, 15f)
                curveTo(18f, 16.657f, 16.657f, 18f, 15f, 18f)
                curveTo(13.343f, 18f, 12f, 16.657f, 12f, 15f)
                curveTo(12f, 13.343f, 13.343f, 12f, 15f, 12f)
                verticalLineTo(7.5f)
                curveTo(15f, 6.119f, 13.881f, 5f, 12.5f, 5f)
                horizontalLineTo(10.707f)
                lineTo(11.854f, 6.146f)
                curveTo(12.049f, 6.342f, 12.049f, 6.658f, 11.854f, 6.854f)
                close()
            }
        }.build()

        return _BranchRequest!!
    }

@Suppress("ObjectPropertyName")
private var _BranchRequest: ImageVector? = null
