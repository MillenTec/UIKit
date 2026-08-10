package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbols

val UIKitSymbols.Scales: ImageVector
    get() {
        if (_Scales != null) {
            return _Scales!!
        }
        _Scales = ImageVector.Builder(
            name = "Scales",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color(0xFF212121))) {
                moveTo(3.5f, 3f)
                curveTo(3.224f, 3f, 3f, 3.224f, 3f, 3.5f)
                curveTo(3f, 3.776f, 3.224f, 4f, 3.5f, 4f)
                horizontalLineTo(4.25f)
                lineTo(2.077f, 9.215f)
                curveTo(2.028f, 9.334f, 1.997f, 9.472f, 2.002f, 9.62f)
                curveTo(2.065f, 11.221f, 3.383f, 12.5f, 5f, 12.5f)
                curveTo(6.617f, 12.5f, 7.935f, 11.221f, 7.998f, 9.62f)
                curveTo(8.004f, 9.472f, 7.973f, 9.334f, 7.923f, 9.215f)
                lineTo(5.75f, 4f)
                horizontalLineTo(9.5f)
                verticalLineTo(14f)
                horizontalLineTo(6f)
                curveTo(4.895f, 14f, 4f, 14.895f, 4f, 16f)
                curveTo(4f, 17.105f, 4.895f, 18f, 6f, 18f)
                horizontalLineTo(14f)
                curveTo(15.105f, 18f, 16f, 17.105f, 16f, 16f)
                curveTo(16f, 14.895f, 15.105f, 14f, 14f, 14f)
                horizontalLineTo(10.5f)
                verticalLineTo(4f)
                horizontalLineTo(14.25f)
                lineTo(12.077f, 9.215f)
                curveTo(12.028f, 9.334f, 11.997f, 9.472f, 12.002f, 9.62f)
                curveTo(12.066f, 11.221f, 13.383f, 12.5f, 15f, 12.5f)
                curveTo(16.617f, 12.5f, 17.935f, 11.221f, 17.998f, 9.62f)
                curveTo(18.003f, 9.472f, 17.972f, 9.334f, 17.923f, 9.215f)
                lineTo(15.75f, 4f)
                horizontalLineTo(16.5f)
                curveTo(16.776f, 4f, 17f, 3.776f, 17f, 3.5f)
                curveTo(17f, 3.224f, 16.776f, 3f, 16.5f, 3f)
                horizontalLineTo(3.5f)
                close()
                moveTo(5f, 11.5f)
                curveTo(4.068f, 11.5f, 3.285f, 10.863f, 3.063f, 10f)
                horizontalLineTo(6.937f)
                curveTo(6.715f, 10.863f, 5.932f, 11.5f, 5f, 11.5f)
                close()
                moveTo(5f, 4.8f)
                lineTo(6.75f, 9f)
                horizontalLineTo(3.25f)
                lineTo(5f, 4.8f)
                close()
                moveTo(6f, 15f)
                horizontalLineTo(14f)
                curveTo(14.552f, 15f, 15f, 15.448f, 15f, 16f)
                curveTo(15f, 16.552f, 14.552f, 17f, 14f, 17f)
                horizontalLineTo(6f)
                curveTo(5.448f, 17f, 5f, 16.552f, 5f, 16f)
                curveTo(5f, 15.448f, 5.448f, 15f, 6f, 15f)
                close()
                moveTo(16.75f, 9f)
                horizontalLineTo(13.25f)
                lineTo(15f, 4.8f)
                lineTo(16.75f, 9f)
                close()
                moveTo(13.063f, 10f)
                horizontalLineTo(16.937f)
                curveTo(16.715f, 10.863f, 15.932f, 11.5f, 15f, 11.5f)
                curveTo(14.068f, 11.5f, 13.285f, 10.863f, 13.063f, 10f)
                close()
            }
        }.build()

        return _Scales!!
    }

@Suppress("ObjectPropertyName")
private var _Scales: ImageVector? = null
