package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Filled.LayoutDynamic: ImageVector
    get() {
        if (_LayoutDynamic != null) {
            return _LayoutDynamic!!
        }
        _LayoutDynamic = ImageVector.Builder(
            name = "LayoutDynamic",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(7f, 17f)
                horizontalLineTo(6f)
                curveTo(4.343f, 17f, 3f, 15.657f, 3f, 14f)
                verticalLineTo(13f)
                horizontalLineTo(7f)
                verticalLineTo(17f)
                close()
                moveTo(17f, 14f)
                curveTo(17f, 15.657f, 15.657f, 17f, 14f, 17f)
                horizontalLineTo(8f)
                verticalLineTo(13f)
                horizontalLineTo(17f)
                verticalLineTo(14f)
                close()
                moveTo(7f, 12f)
                horizontalLineTo(3f)
                verticalLineTo(6f)
                curveTo(3f, 4.343f, 4.343f, 3f, 6f, 3f)
                horizontalLineTo(7f)
                verticalLineTo(12f)
                close()
                moveTo(14f, 3f)
                curveTo(15.657f, 3f, 17f, 4.343f, 17f, 6f)
                verticalLineTo(12f)
                horizontalLineTo(8f)
                verticalLineTo(3f)
                horizontalLineTo(14f)
                close()
            }
        }.build()

        return _LayoutDynamic!!
    }

@Suppress("ObjectPropertyName")
private var _LayoutDynamic: ImageVector? = null
