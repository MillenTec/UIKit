package com.millentec.compose.uikit.icons.fluenticons.filled.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Filled.Snowflake: ImageVector
    get() {
        if (_Snowflake != null) {
            return _Snowflake!!
        }
        _Snowflake = ImageVector.Builder(
            name = "Snowflake",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(10f, 2f)
                curveTo(10.414f, 2f, 10.75f, 2.336f, 10.75f, 2.75f)
                verticalLineTo(4.939f)
                lineTo(12.22f, 3.47f)
                curveTo(12.513f, 3.177f, 12.987f, 3.177f, 13.28f, 3.47f)
                curveTo(13.573f, 3.763f, 13.573f, 4.237f, 13.28f, 4.53f)
                lineTo(10.75f, 7.061f)
                verticalLineTo(9.25f)
                horizontalLineTo(12.939f)
                lineTo(15.47f, 6.72f)
                curveTo(15.763f, 6.427f, 16.237f, 6.427f, 16.53f, 6.72f)
                curveTo(16.823f, 7.013f, 16.823f, 7.487f, 16.53f, 7.78f)
                lineTo(15.061f, 9.25f)
                horizontalLineTo(17.25f)
                curveTo(17.664f, 9.25f, 18f, 9.586f, 18f, 10f)
                curveTo(18f, 10.414f, 17.664f, 10.75f, 17.25f, 10.75f)
                horizontalLineTo(15.061f)
                lineTo(16.53f, 12.22f)
                curveTo(16.823f, 12.513f, 16.823f, 12.987f, 16.53f, 13.28f)
                curveTo(16.237f, 13.573f, 15.763f, 13.573f, 15.47f, 13.28f)
                lineTo(12.939f, 10.75f)
                horizontalLineTo(10.75f)
                verticalLineTo(12.939f)
                lineTo(13.28f, 15.47f)
                curveTo(13.573f, 15.763f, 13.573f, 16.237f, 13.28f, 16.53f)
                curveTo(12.987f, 16.823f, 12.513f, 16.823f, 12.22f, 16.53f)
                lineTo(10.75f, 15.061f)
                verticalLineTo(17.25f)
                curveTo(10.75f, 17.664f, 10.414f, 18f, 10f, 18f)
                curveTo(9.586f, 18f, 9.25f, 17.664f, 9.25f, 17.25f)
                verticalLineTo(15.061f)
                lineTo(7.78f, 16.53f)
                curveTo(7.487f, 16.823f, 7.013f, 16.823f, 6.72f, 16.53f)
                curveTo(6.427f, 16.237f, 6.427f, 15.763f, 6.72f, 15.47f)
                lineTo(9.25f, 12.939f)
                verticalLineTo(10.75f)
                horizontalLineTo(7.061f)
                lineTo(4.53f, 13.28f)
                curveTo(4.237f, 13.573f, 3.763f, 13.573f, 3.47f, 13.28f)
                curveTo(3.177f, 12.987f, 3.177f, 12.513f, 3.47f, 12.22f)
                lineTo(4.939f, 10.75f)
                horizontalLineTo(2.75f)
                curveTo(2.336f, 10.75f, 2f, 10.414f, 2f, 10f)
                curveTo(2f, 9.586f, 2.336f, 9.25f, 2.75f, 9.25f)
                horizontalLineTo(4.939f)
                lineTo(3.47f, 7.78f)
                curveTo(3.177f, 7.487f, 3.177f, 7.013f, 3.47f, 6.72f)
                curveTo(3.763f, 6.427f, 4.237f, 6.427f, 4.53f, 6.72f)
                lineTo(7.061f, 9.25f)
                horizontalLineTo(9.25f)
                verticalLineTo(7.061f)
                lineTo(6.72f, 4.53f)
                curveTo(6.427f, 4.237f, 6.427f, 3.763f, 6.72f, 3.47f)
                curveTo(7.013f, 3.177f, 7.487f, 3.177f, 7.78f, 3.47f)
                lineTo(9.25f, 4.939f)
                verticalLineTo(2.75f)
                curveTo(9.25f, 2.336f, 9.586f, 2f, 10f, 2f)
                close()
            }
        }.build()

        return _Snowflake!!
    }

@Suppress("ObjectPropertyName")
private var _Snowflake: ImageVector? = null
