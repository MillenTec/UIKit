package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Archive: ImageVector
    get() {
        if (_Archive != null) {
            return _Archive!!
        }
        _Archive = ImageVector.Builder(
            name = "Archive",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(8.5f, 10f)
                curveTo(8.224f, 10f, 8f, 10.224f, 8f, 10.5f)
                curveTo(8f, 10.776f, 8.224f, 11f, 8.5f, 11f)
                horizontalLineTo(11.5f)
                curveTo(11.776f, 11f, 12f, 10.776f, 12f, 10.5f)
                curveTo(12f, 10.224f, 11.776f, 10f, 11.5f, 10f)
                horizontalLineTo(8.5f)
                close()
                moveTo(2f, 4.75f)
                curveTo(2f, 3.783f, 2.783f, 3f, 3.75f, 3f)
                horizontalLineTo(16.25f)
                curveTo(17.216f, 3f, 18f, 3.783f, 18f, 4.75f)
                verticalLineTo(6.25f)
                curveTo(18f, 6.948f, 17.591f, 7.551f, 17f, 7.832f)
                verticalLineTo(14f)
                curveTo(17f, 15.657f, 15.657f, 17f, 14f, 17f)
                horizontalLineTo(6f)
                curveTo(4.343f, 17f, 3f, 15.657f, 3f, 14f)
                verticalLineTo(7.832f)
                curveTo(2.409f, 7.551f, 2f, 6.948f, 2f, 6.25f)
                verticalLineTo(4.75f)
                close()
                moveTo(3.75f, 4f)
                curveTo(3.336f, 4f, 3f, 4.336f, 3f, 4.75f)
                verticalLineTo(6.25f)
                curveTo(3f, 6.664f, 3.336f, 7f, 3.75f, 7f)
                horizontalLineTo(16.25f)
                curveTo(16.664f, 7f, 17f, 6.664f, 17f, 6.25f)
                verticalLineTo(4.75f)
                curveTo(17f, 4.336f, 16.664f, 4f, 16.25f, 4f)
                horizontalLineTo(3.75f)
                close()
                moveTo(4f, 8f)
                verticalLineTo(14f)
                curveTo(4f, 15.105f, 4.895f, 16f, 6f, 16f)
                horizontalLineTo(14f)
                curveTo(15.105f, 16f, 16f, 15.105f, 16f, 14f)
                verticalLineTo(8f)
                horizontalLineTo(4f)
                close()
            }
        }.build()

        return _Archive!!
    }

@Suppress("ObjectPropertyName")
private var _Archive: ImageVector? = null
