package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.ZoomOut: ImageVector
    get() {
        if (_ZoomOut != null) {
            return _ZoomOut!!
        }
        _ZoomOut = ImageVector.Builder(
            name = "ZoomOut",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(11f, 8f)
                curveTo(11.276f, 8f, 11.5f, 8.224f, 11.5f, 8.5f)
                curveTo(11.5f, 8.776f, 11.276f, 9f, 11f, 9f)
                horizontalLineTo(6f)
                curveTo(5.724f, 9f, 5.5f, 8.776f, 5.5f, 8.5f)
                curveTo(5.5f, 8.224f, 5.724f, 8f, 6f, 8f)
                horizontalLineTo(11f)
                close()
                moveTo(8.5f, 2f)
                curveTo(12.09f, 2f, 15f, 4.91f, 15f, 8.5f)
                curveTo(15f, 10.115f, 14.411f, 11.593f, 13.436f, 12.729f)
                lineTo(16.854f, 16.146f)
                curveTo(17.049f, 16.342f, 17.049f, 16.658f, 16.854f, 16.854f)
                curveTo(16.68f, 17.027f, 16.411f, 17.046f, 16.216f, 16.911f)
                lineTo(16.146f, 16.854f)
                lineTo(12.729f, 13.436f)
                curveTo(11.593f, 14.411f, 10.115f, 15f, 8.5f, 15f)
                curveTo(4.91f, 15f, 2f, 12.09f, 2f, 8.5f)
                curveTo(2f, 4.91f, 4.91f, 2f, 8.5f, 2f)
                close()
                moveTo(8.5f, 3f)
                curveTo(5.462f, 3f, 3f, 5.462f, 3f, 8.5f)
                curveTo(3f, 11.538f, 5.462f, 14f, 8.5f, 14f)
                curveTo(9.839f, 14f, 11.066f, 13.522f, 12.019f, 12.727f)
                curveTo(12.276f, 12.513f, 12.513f, 12.276f, 12.727f, 12.019f)
                curveTo(13.522f, 11.066f, 14f, 9.839f, 14f, 8.5f)
                curveTo(14f, 5.462f, 11.538f, 3f, 8.5f, 3f)
                close()
            }
        }.build()

        return _ZoomOut!!
    }

@Suppress("ObjectPropertyName")
private var _ZoomOut: ImageVector? = null
