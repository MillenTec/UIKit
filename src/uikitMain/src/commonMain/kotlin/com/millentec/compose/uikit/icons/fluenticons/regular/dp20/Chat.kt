package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.Chat: ImageVector
    get() {
        if (_Chat != null) {
            return _Chat!!
        }
        _Chat = ImageVector.Builder(
            name = "Chat",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(10f, 2f)
                curveTo(14.418f, 2f, 18f, 5.582f, 18f, 10f)
                curveTo(18f, 14.418f, 14.418f, 18f, 10f, 18f)
                curveTo(8.727f, 18f, 7.496f, 17.702f, 6.387f, 17.139f)
                lineTo(6.266f, 17.075f)
                lineTo(2.621f, 17.985f)
                curveTo(2.311f, 18.063f, 2.026f, 17.837f, 2.001f, 17.544f)
                lineTo(2.001f, 17.462f)
                lineTo(2.015f, 17.379f)
                lineTo(2.925f, 13.735f)
                lineTo(2.862f, 13.615f)
                curveTo(2.407f, 12.719f, 2.124f, 11.742f, 2.033f, 10.728f)
                lineTo(2.007f, 10.346f)
                lineTo(2f, 10f)
                curveTo(2f, 5.582f, 5.582f, 2f, 10f, 2f)
                close()
                moveTo(10f, 3f)
                curveTo(6.134f, 3f, 3f, 6.134f, 3f, 10f)
                curveTo(3f, 11.217f, 3.311f, 12.388f, 3.894f, 13.425f)
                curveTo(3.94f, 13.508f, 3.962f, 13.603f, 3.957f, 13.697f)
                lineTo(3.943f, 13.791f)
                lineTo(3.187f, 16.812f)
                lineTo(6.211f, 16.058f)
                curveTo(6.273f, 16.043f, 6.337f, 16.04f, 6.399f, 16.048f)
                lineTo(6.49f, 16.069f)
                lineTo(6.577f, 16.108f)
                curveTo(7.614f, 16.69f, 8.784f, 17f, 10f, 17f)
                curveTo(13.866f, 17f, 17f, 13.866f, 17f, 10f)
                curveTo(17f, 6.134f, 13.866f, 3f, 10f, 3f)
                close()
                moveTo(10.5f, 11f)
                curveTo(10.776f, 11f, 11f, 11.224f, 11f, 11.5f)
                curveTo(11f, 11.745f, 10.823f, 11.95f, 10.59f, 11.992f)
                lineTo(10.5f, 12f)
                horizontalLineTo(7.5f)
                curveTo(7.224f, 12f, 7f, 11.776f, 7f, 11.5f)
                curveTo(7f, 11.255f, 7.177f, 11.05f, 7.41f, 11.008f)
                lineTo(7.5f, 11f)
                horizontalLineTo(10.5f)
                close()
                moveTo(12.5f, 8f)
                curveTo(12.776f, 8f, 13f, 8.224f, 13f, 8.5f)
                curveTo(13f, 8.745f, 12.823f, 8.95f, 12.59f, 8.992f)
                lineTo(12.5f, 9f)
                horizontalLineTo(7.5f)
                curveTo(7.224f, 9f, 7f, 8.776f, 7f, 8.5f)
                curveTo(7f, 8.255f, 7.177f, 8.05f, 7.41f, 8.008f)
                lineTo(7.5f, 8f)
                horizontalLineTo(12.5f)
                close()
            }
        }.build()

        return _Chat!!
    }

@Suppress("ObjectPropertyName")
private var _Chat: ImageVector? = null

