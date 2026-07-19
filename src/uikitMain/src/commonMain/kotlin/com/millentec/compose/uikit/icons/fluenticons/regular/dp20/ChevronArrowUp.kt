package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.ChevronArrowUp: ImageVector
    get() {
        if (_ChevronArrowUp != null) {
            return _ChevronArrowUp!!
        }
        _ChevronArrowUp = ImageVector.Builder(
            name = "ChevronArrowUp",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(4.147f, 12.353f)
                curveTo(3.951f, 12.158f, 3.951f, 11.842f, 4.146f, 11.646f)
                lineTo(9.611f, 6.162f)
                curveTo(9.826f, 5.946f, 10.175f, 5.946f, 10.39f, 6.162f)
                lineTo(15.855f, 11.646f)
                curveTo(16.05f, 11.842f, 16.049f, 12.158f, 15.854f, 12.353f)
                curveTo(15.658f, 12.548f, 15.342f, 12.548f, 15.147f, 12.352f)
                lineTo(10f, 7.188f)
                lineTo(4.854f, 12.352f)
                curveTo(4.659f, 12.548f, 4.343f, 12.548f, 4.147f, 12.353f)
                close()
            }
        }.build()

        return _ChevronArrowUp!!
    }

@Suppress("ObjectPropertyName")
private var _ChevronArrowUp: ImageVector? = null
