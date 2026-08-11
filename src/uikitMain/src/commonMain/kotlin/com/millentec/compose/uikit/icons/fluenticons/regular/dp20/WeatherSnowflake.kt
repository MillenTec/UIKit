package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.WeatherSnowflake: ImageVector
    get() {
        if (_Snowflake != null) {
            return _Snowflake!!
        }
        _Snowflake = ImageVector.Builder(
            name = "WeatherSnowflake",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(10f, 2f)
                curveTo(10.276f, 2f, 10.5f, 2.224f, 10.5f, 2.5f)
                verticalLineTo(5.543f)
                lineTo(12.396f, 3.646f)
                curveTo(12.592f, 3.451f, 12.908f, 3.451f, 13.104f, 3.646f)
                curveTo(13.299f, 3.842f, 13.299f, 4.158f, 13.104f, 4.354f)
                lineTo(10.5f, 6.957f)
                verticalLineTo(9.5f)
                horizontalLineTo(13.043f)
                lineTo(15.646f, 6.896f)
                curveTo(15.842f, 6.701f, 16.158f, 6.701f, 16.354f, 6.896f)
                curveTo(16.549f, 7.092f, 16.549f, 7.408f, 16.354f, 7.604f)
                lineTo(14.457f, 9.5f)
                horizontalLineTo(17.5f)
                curveTo(17.776f, 9.5f, 18f, 9.724f, 18f, 10f)
                curveTo(18f, 10.276f, 17.776f, 10.5f, 17.5f, 10.5f)
                horizontalLineTo(14.457f)
                lineTo(16.354f, 12.396f)
                curveTo(16.549f, 12.592f, 16.549f, 12.908f, 16.354f, 13.104f)
                curveTo(16.158f, 13.299f, 15.842f, 13.299f, 15.646f, 13.104f)
                lineTo(13.043f, 10.5f)
                horizontalLineTo(10.5f)
                verticalLineTo(13.043f)
                lineTo(13.104f, 15.646f)
                curveTo(13.299f, 15.842f, 13.299f, 16.158f, 13.104f, 16.354f)
                curveTo(12.908f, 16.549f, 12.592f, 16.549f, 12.396f, 16.354f)
                lineTo(10.5f, 14.457f)
                verticalLineTo(17.5f)
                curveTo(10.5f, 17.776f, 10.276f, 18f, 10f, 18f)
                curveTo(9.724f, 18f, 9.5f, 17.776f, 9.5f, 17.5f)
                verticalLineTo(14.457f)
                lineTo(7.604f, 16.354f)
                curveTo(7.408f, 16.549f, 7.092f, 16.549f, 6.896f, 16.354f)
                curveTo(6.701f, 16.158f, 6.701f, 15.842f, 6.896f, 15.646f)
                lineTo(9.5f, 13.043f)
                verticalLineTo(10.5f)
                horizontalLineTo(6.957f)
                lineTo(4.354f, 13.104f)
                curveTo(4.158f, 13.299f, 3.842f, 13.299f, 3.646f, 13.104f)
                curveTo(3.451f, 12.908f, 3.451f, 12.592f, 3.646f, 12.396f)
                lineTo(5.543f, 10.5f)
                horizontalLineTo(2.5f)
                curveTo(2.224f, 10.5f, 2f, 10.276f, 2f, 10f)
                curveTo(2f, 9.724f, 2.224f, 9.5f, 2.5f, 9.5f)
                horizontalLineTo(5.543f)
                lineTo(3.646f, 7.604f)
                curveTo(3.451f, 7.408f, 3.451f, 7.092f, 3.646f, 6.896f)
                curveTo(3.842f, 6.701f, 4.158f, 6.701f, 4.354f, 6.896f)
                lineTo(6.957f, 9.5f)
                horizontalLineTo(9.5f)
                verticalLineTo(6.957f)
                lineTo(6.896f, 4.354f)
                curveTo(6.701f, 4.158f, 6.701f, 3.842f, 6.896f, 3.646f)
                curveTo(7.092f, 3.451f, 7.408f, 3.451f, 7.604f, 3.646f)
                lineTo(9.5f, 5.543f)
                verticalLineTo(2.5f)
                curveTo(9.5f, 2.224f, 9.724f, 2f, 10f, 2f)
                close()
            }
        }.build()

        return _Snowflake!!
    }

@Suppress("ObjectPropertyName")
private var _Snowflake: ImageVector? = null
