package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.Add: ImageVector
    get() {
        if (_Add != null) {
            return _Add!!
        }
        _Add = ImageVector.Builder(
            name = "Add",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(10f, 2.25f)
                curveTo(10.414f, 2.25f, 10.75f, 2.586f, 10.75f, 3f)
                verticalLineTo(9.25f)
                horizontalLineTo(17f)
                curveTo(17.414f, 9.25f, 17.75f, 9.586f, 17.75f, 10f)
                curveTo(17.75f, 10.414f, 17.414f, 10.75f, 17f, 10.75f)
                horizontalLineTo(10.75f)
                verticalLineTo(17f)
                curveTo(10.75f, 17.414f, 10.414f, 17.75f, 10f, 17.75f)
                curveTo(9.586f, 17.75f, 9.25f, 17.414f, 9.25f, 17f)
                verticalLineTo(10.75f)
                horizontalLineTo(3f)
                curveTo(2.586f, 10.75f, 2.25f, 10.414f, 2.25f, 10f)
                curveTo(2.25f, 9.586f, 2.586f, 9.25f, 3f, 9.25f)
                horizontalLineTo(9.25f)
                verticalLineTo(3f)
                curveTo(9.25f, 2.586f, 9.586f, 2.25f, 10f, 2.25f)
                close()
            }
        }.build()

        return _Add!!
    }

@Suppress("ObjectPropertyName")
private var _Add: ImageVector? = null
