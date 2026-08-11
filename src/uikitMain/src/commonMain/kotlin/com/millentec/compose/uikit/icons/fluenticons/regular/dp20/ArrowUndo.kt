package com.millentec.compose.uikit.icons.fluenticons.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons

val FluentIcons.ArrowUndo: ImageVector
    get() {
        if (_ArrowUndo != null) {
            return _ArrowUndo!!
        }
        _ArrowUndo = ImageVector.Builder(
            name = "ArrowUndo",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF1D1D1F))) {
                moveTo(5f, 2.5f)
                curveTo(5f, 2.224f, 4.776f, 2f, 4.5f, 2f)
                curveTo(4.224f, 2f, 4f, 2.224f, 4f, 2.5f)
                verticalLineTo(7.4f)
                curveTo(4f, 7.731f, 4.269f, 8f, 4.6f, 8f)
                horizontalLineTo(9.5f)
                curveTo(9.776f, 8f, 10f, 7.776f, 10f, 7.5f)
                curveTo(10f, 7.224f, 9.776f, 7f, 9.5f, 7f)
                horizontalLineTo(5.906f)
                lineTo(9.379f, 3.981f)
                curveTo(11.046f, 2.532f, 13.573f, 2.709f, 15.022f, 4.376f)
                curveTo(16.471f, 6.043f, 16.295f, 8.57f, 14.627f, 10.019f)
                lineTo(6.455f, 17.123f)
                curveTo(6.247f, 17.304f, 6.225f, 17.62f, 6.406f, 17.828f)
                curveTo(6.587f, 18.036f, 6.903f, 18.059f, 7.111f, 17.877f)
                lineTo(15.283f, 10.774f)
                curveTo(17.367f, 8.962f, 17.588f, 5.804f, 15.776f, 3.72f)
                curveTo(13.965f, 1.636f, 10.807f, 1.415f, 8.723f, 3.227f)
                lineTo(5f, 6.463f)
                verticalLineTo(2.5f)
                close()
            }
        }.build()

        return _ArrowUndo!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowUndo: ImageVector? = null
