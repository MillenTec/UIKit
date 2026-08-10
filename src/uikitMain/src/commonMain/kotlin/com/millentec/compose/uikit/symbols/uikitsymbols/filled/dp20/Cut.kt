package com.millentec.compose.uikit.symbols.uikitsymbols.filled.dp20

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitFilledSymbols
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitStaticSymbol

fun UIKitFilledSymbols.cut(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Cut",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Cut",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14.879f, 3.159f)
                    lineTo(11.78f, 7.926f)
                    lineTo(10.887f, 6.547f)
                    lineTo(13.621f, 2.341f)
                    curveTo(13.847f, 1.994f, 14.311f, 1.896f, 14.659f, 2.121f)
                    curveTo(15.006f, 2.347f, 15.105f, 2.812f, 14.879f, 3.159f)
                    close()
                    moveTo(12.495f, 11.751f)
                    curveTo(12.881f, 11.589f, 13.305f, 11.5f, 13.75f, 11.5f)
                    curveTo(15.545f, 11.5f, 17f, 12.955f, 17f, 14.75f)
                    curveTo(17f, 16.545f, 15.545f, 18f, 13.75f, 18f)
                    curveTo(11.955f, 18f, 10.5f, 16.545f, 10.5f, 14.75f)
                    curveTo(10.5f, 13.943f, 10.794f, 13.204f, 11.281f, 12.636f)
                    lineTo(10f, 10.665f)
                    lineTo(8.719f, 12.636f)
                    curveTo(9.206f, 13.204f, 9.5f, 13.943f, 9.5f, 14.75f)
                    curveTo(9.5f, 16.545f, 8.045f, 18f, 6.25f, 18f)
                    curveTo(4.455f, 18f, 3f, 16.545f, 3f, 14.75f)
                    curveTo(3f, 12.955f, 4.455f, 11.5f, 6.25f, 11.5f)
                    curveTo(6.695f, 11.5f, 7.119f, 11.589f, 7.505f, 11.751f)
                    lineTo(9.106f, 9.289f)
                    lineTo(5.121f, 3.159f)
                    curveTo(4.895f, 2.812f, 4.994f, 2.347f, 5.341f, 2.121f)
                    curveTo(5.689f, 1.896f, 6.153f, 1.994f, 6.379f, 2.341f)
                    lineTo(12.495f, 11.751f)
                    close()
                    moveTo(12.691f, 13.357f)
                    curveTo(12.271f, 13.676f, 12f, 14.182f, 12f, 14.75f)
                    curveTo(12f, 15.717f, 12.783f, 16.5f, 13.75f, 16.5f)
                    curveTo(14.717f, 16.5f, 15.5f, 15.717f, 15.5f, 14.75f)
                    curveTo(15.5f, 13.784f, 14.717f, 13f, 13.75f, 13f)
                    curveTo(13.361f, 13f, 13.001f, 13.127f, 12.71f, 13.342f)
                    curveTo(12.704f, 13.347f, 12.698f, 13.352f, 12.691f, 13.357f)
                    close()
                    moveTo(6.25f, 13f)
                    curveTo(5.284f, 13f, 4.5f, 13.784f, 4.5f, 14.75f)
                    curveTo(4.5f, 15.717f, 5.284f, 16.5f, 6.25f, 16.5f)
                    curveTo(7.216f, 16.5f, 8f, 15.717f, 8f, 14.75f)
                    curveTo(8f, 14.181f, 7.729f, 13.676f, 7.308f, 13.356f)
                    curveTo(7.302f, 13.352f, 7.296f, 13.347f, 7.291f, 13.343f)
                    curveTo(7f, 13.127f, 6.64f, 13f, 6.25f, 13f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.cut(
    color: Color
) = cut(
    SolidColor(color)
)