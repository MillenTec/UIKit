package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.BranchRequestClosed: ImageVector
    get() {
        if (_BranchRequestClosed != null) {
            return _BranchRequestClosed!!
        }
        _BranchRequestClosed = ImageVector.Builder(
            name = "BranchRequestClosed",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(5.5f, 7.959f)
                curveTo(6.919f, 7.72f, 8f, 6.486f, 8f, 5f)
                curveTo(8f, 3.343f, 6.657f, 2f, 5f, 2f)
                curveTo(3.343f, 2f, 2f, 3.343f, 2f, 5f)
                curveTo(2f, 6.486f, 3.081f, 7.72f, 4.5f, 7.959f)
                verticalLineTo(12.042f)
                curveTo(3.081f, 12.28f, 2f, 13.514f, 2f, 15f)
                curveTo(2f, 16.657f, 3.343f, 18f, 5f, 18f)
                curveTo(6.657f, 18f, 8f, 16.657f, 8f, 15f)
                curveTo(8f, 13.514f, 6.919f, 12.28f, 5.5f, 12.042f)
                verticalLineTo(7.959f)
                close()
                moveTo(18f, 15f)
                curveTo(18f, 16.657f, 16.657f, 18f, 15f, 18f)
                curveTo(13.343f, 18f, 12f, 16.657f, 12f, 15f)
                curveTo(12f, 13.514f, 13.081f, 12.28f, 14.5f, 12.042f)
                verticalLineTo(8.5f)
                curveTo(14.5f, 8.224f, 14.724f, 8f, 15f, 8f)
                curveTo(15.276f, 8f, 15.5f, 8.224f, 15.5f, 8.5f)
                verticalLineTo(12.042f)
                curveTo(16.919f, 12.28f, 18f, 13.514f, 18f, 15f)
                close()
                moveTo(13.354f, 2.646f)
                curveTo(13.158f, 2.451f, 12.842f, 2.451f, 12.646f, 2.646f)
                curveTo(12.451f, 2.842f, 12.451f, 3.158f, 12.646f, 3.354f)
                lineTo(14.293f, 5f)
                lineTo(12.646f, 6.646f)
                curveTo(12.451f, 6.842f, 12.451f, 7.158f, 12.646f, 7.354f)
                curveTo(12.842f, 7.549f, 13.158f, 7.549f, 13.354f, 7.354f)
                lineTo(15f, 5.707f)
                lineTo(16.646f, 7.354f)
                curveTo(16.842f, 7.549f, 17.158f, 7.549f, 17.354f, 7.354f)
                curveTo(17.549f, 7.158f, 17.549f, 6.842f, 17.354f, 6.646f)
                lineTo(15.707f, 5f)
                lineTo(17.354f, 3.354f)
                curveTo(17.549f, 3.158f, 17.549f, 2.842f, 17.354f, 2.646f)
                curveTo(17.158f, 2.451f, 16.842f, 2.451f, 16.646f, 2.646f)
                lineTo(15f, 4.293f)
                lineTo(13.354f, 2.646f)
                close()
            }
        }.build()

        return _BranchRequestClosed!!
    }

@Suppress("ObjectPropertyName")
private var _BranchRequestClosed: ImageVector? = null
