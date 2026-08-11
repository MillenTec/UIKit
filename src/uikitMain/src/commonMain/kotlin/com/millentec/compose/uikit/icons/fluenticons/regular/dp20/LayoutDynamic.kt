package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.LayoutDynamic: ImageVector
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
                moveTo(14f, 3f)
                curveTo(15.657f, 3f, 17f, 4.343f, 17f, 6f)
                verticalLineTo(14f)
                curveTo(17f, 15.657f, 15.657f, 17f, 14f, 17f)
                horizontalLineTo(6f)
                curveTo(4.343f, 17f, 3f, 15.657f, 3f, 14f)
                verticalLineTo(6f)
                curveTo(3f, 4.343f, 4.343f, 3f, 6f, 3f)
                horizontalLineTo(14f)
                close()
                moveTo(4f, 14f)
                curveTo(4f, 15.105f, 4.895f, 16f, 6f, 16f)
                horizontalLineTo(7f)
                verticalLineTo(13f)
                horizontalLineTo(4f)
                verticalLineTo(14f)
                close()
                moveTo(8f, 16f)
                horizontalLineTo(14f)
                curveTo(15.105f, 16f, 16f, 15.105f, 16f, 14f)
                verticalLineTo(13f)
                horizontalLineTo(8f)
                verticalLineTo(16f)
                close()
                moveTo(6f, 4f)
                curveTo(4.895f, 4f, 4f, 4.895f, 4f, 6f)
                verticalLineTo(12f)
                horizontalLineTo(7f)
                verticalLineTo(4f)
                horizontalLineTo(6f)
                close()
                moveTo(8f, 12f)
                horizontalLineTo(16f)
                verticalLineTo(6f)
                curveTo(16f, 4.895f, 15.105f, 4f, 14f, 4f)
                horizontalLineTo(8f)
                verticalLineTo(12f)
                close()
            }
        }.build()

        return _LayoutDynamic!!
    }

@Suppress("ObjectPropertyName")
private var _LayoutDynamic: ImageVector? = null
