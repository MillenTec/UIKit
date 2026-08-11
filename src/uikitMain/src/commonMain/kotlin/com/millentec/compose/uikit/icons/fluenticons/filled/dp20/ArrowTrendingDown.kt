package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.ArrowTrendingDown: ImageVector
    get() {
        if (_ArrowTrendingDown != null) {
            return _ArrowTrendingDown!!
        }
        _ArrowTrendingDown = ImageVector.Builder(
            name = "ArrowTrendingDown",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(17.943f, 14.537f)
                curveTo(17.907f, 14.625f, 17.853f, 14.707f, 17.782f, 14.779f)
                lineTo(17.78f, 14.78f)
                lineTo(17.779f, 14.782f)
                curveTo(17.643f, 14.917f, 17.456f, 15f, 17.25f, 15f)
                horizontalLineTo(11.75f)
                curveTo(11.336f, 15f, 11f, 14.664f, 11f, 14.25f)
                curveTo(11f, 13.836f, 11.336f, 13.5f, 11.75f, 13.5f)
                horizontalLineTo(15.439f)
                lineTo(10.5f, 8.561f)
                lineTo(8.53f, 10.53f)
                curveTo(8.237f, 10.823f, 7.763f, 10.823f, 7.47f, 10.53f)
                lineTo(2.22f, 5.28f)
                curveTo(1.927f, 4.987f, 1.927f, 4.513f, 2.22f, 4.22f)
                curveTo(2.513f, 3.927f, 2.987f, 3.927f, 3.28f, 4.22f)
                lineTo(8f, 8.939f)
                lineTo(9.97f, 6.97f)
                curveTo(10.263f, 6.677f, 10.737f, 6.677f, 11.03f, 6.97f)
                lineTo(16.5f, 12.439f)
                verticalLineTo(8.75f)
                curveTo(16.5f, 8.336f, 16.836f, 8f, 17.25f, 8f)
                curveTo(17.664f, 8f, 18f, 8.336f, 18f, 8.75f)
                verticalLineTo(14.25f)
                curveTo(18f, 14.352f, 17.98f, 14.449f, 17.943f, 14.537f)
                close()
            }
        }.build()

        return _ArrowTrendingDown!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowTrendingDown: ImageVector? = null
