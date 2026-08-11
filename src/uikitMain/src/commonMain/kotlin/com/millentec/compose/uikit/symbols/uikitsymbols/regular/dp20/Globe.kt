package com.millentec.compose.uikit.symbols.uikitsymbols.regular.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitRegularSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitStaticSymbol
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitRegularSymbols.globe(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Globe",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush),
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            )
        )
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Globe",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 18f)
                    curveTo(14.418f, 18f, 18f, 14.418f, 18f, 10f)
                    curveTo(18f, 5.582f, 14.418f, 2f, 10f, 2f)
                    curveTo(5.582f, 2f, 2f, 5.582f, 2f, 10f)
                    curveTo(2f, 14.418f, 5.582f, 18f, 10f, 18f)
                    close()
                    moveTo(10f, 3f)
                    curveTo(10.657f, 3f, 11.407f, 3.59f, 12.022f, 4.908f)
                    curveTo(12.239f, 5.374f, 12.428f, 5.91f, 12.581f, 6.5f)
                    horizontalLineTo(7.419f)
                    curveTo(7.572f, 5.91f, 7.761f, 5.374f, 7.978f, 4.908f)
                    curveTo(8.593f, 3.59f, 9.343f, 3f, 10f, 3f)
                    close()
                    moveTo(7.072f, 4.485f)
                    curveTo(6.796f, 5.078f, 6.565f, 5.757f, 6.389f, 6.5f)
                    horizontalLineTo(3.936f)
                    curveTo(4.773f, 5.054f, 6.112f, 3.935f, 7.714f, 3.382f)
                    curveTo(7.473f, 3.712f, 7.258f, 4.086f, 7.072f, 4.485f)
                    close()
                    moveTo(6.193f, 7.5f)
                    curveTo(6.067f, 8.288f, 6f, 9.129f, 6f, 10f)
                    curveTo(6f, 10.871f, 6.067f, 11.712f, 6.193f, 12.5f)
                    horizontalLineTo(3.46f)
                    curveTo(3.163f, 11.724f, 3f, 10.881f, 3f, 10f)
                    curveTo(3f, 9.119f, 3.163f, 8.276f, 3.46f, 7.5f)
                    horizontalLineTo(6.193f)
                    close()
                    moveTo(6.389f, 13.5f)
                    curveTo(6.565f, 14.243f, 6.796f, 14.922f, 7.072f, 15.515f)
                    curveTo(7.258f, 15.914f, 7.473f, 16.288f, 7.714f, 16.618f)
                    curveTo(6.112f, 16.065f, 4.773f, 14.946f, 3.936f, 13.5f)
                    horizontalLineTo(6.389f)
                    close()
                    moveTo(7.419f, 13.5f)
                    horizontalLineTo(12.581f)
                    curveTo(12.428f, 14.09f, 12.239f, 14.626f, 12.022f, 15.092f)
                    curveTo(11.407f, 16.41f, 10.657f, 17f, 10f, 17f)
                    curveTo(9.343f, 17f, 8.593f, 16.41f, 7.978f, 15.092f)
                    curveTo(7.761f, 14.626f, 7.572f, 14.09f, 7.419f, 13.5f)
                    close()
                    moveTo(12.794f, 12.5f)
                    horizontalLineTo(7.206f)
                    curveTo(7.073f, 11.725f, 7f, 10.883f, 7f, 10f)
                    curveTo(7f, 9.117f, 7.073f, 8.275f, 7.206f, 7.5f)
                    horizontalLineTo(12.794f)
                    curveTo(12.927f, 8.275f, 13f, 9.117f, 13f, 10f)
                    curveTo(13f, 10.883f, 12.927f, 11.725f, 12.794f, 12.5f)
                    close()
                    moveTo(13.611f, 13.5f)
                    horizontalLineTo(16.063f)
                    curveTo(15.227f, 14.946f, 13.888f, 16.065f, 12.286f, 16.618f)
                    curveTo(12.527f, 16.288f, 12.742f, 15.914f, 12.928f, 15.515f)
                    curveTo(13.204f, 14.922f, 13.435f, 14.243f, 13.611f, 13.5f)
                    close()
                    moveTo(16.54f, 12.5f)
                    horizontalLineTo(13.807f)
                    curveTo(13.933f, 11.712f, 14f, 10.871f, 14f, 10f)
                    curveTo(14f, 9.129f, 13.933f, 8.288f, 13.807f, 7.5f)
                    horizontalLineTo(16.54f)
                    curveTo(16.837f, 8.276f, 17f, 9.119f, 17f, 10f)
                    curveTo(17f, 10.881f, 16.837f, 11.724f, 16.54f, 12.5f)
                    close()
                    moveTo(12.286f, 3.382f)
                    curveTo(13.888f, 3.935f, 15.227f, 5.054f, 16.063f, 6.5f)
                    horizontalLineTo(13.611f)
                    curveTo(13.435f, 5.757f, 13.204f, 5.078f, 12.928f, 4.485f)
                    curveTo(12.742f, 4.086f, 12.527f, 3.712f, 12.286f, 3.382f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.globe(
    color: Color
) = globe(
    SolidColor(color)
)