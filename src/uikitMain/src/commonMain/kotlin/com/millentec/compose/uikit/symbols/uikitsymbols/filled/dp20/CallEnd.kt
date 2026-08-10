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

fun UIKitFilledSymbols.callEnd(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "CallEnd",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "CallEnd",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.959f, 10.94f)
                    lineTo(17.802f, 11.769f)
                    curveTo(17.653f, 12.546f, 16.927f, 13.068f, 16.104f, 12.988f)
                    lineTo(14.467f, 12.83f)
                    curveTo(13.753f, 12.761f, 13.224f, 12.24f, 13f, 11.5f)
                    curveTo(12.696f, 10.495f, 12.5f, 9.75f, 12.5f, 9.75f)
                    curveTo(11.752f, 9.444f, 11.014f, 9.25f, 10f, 9.25f)
                    curveTo(8.986f, 9.25f, 8.262f, 9.465f, 7.5f, 9.75f)
                    curveTo(7.5f, 9.75f, 7.296f, 10.496f, 7f, 11.5f)
                    curveTo(6.802f, 12.171f, 6.496f, 12.757f, 5.797f, 12.827f)
                    lineTo(4.169f, 12.991f)
                    curveTo(3.357f, 13.072f, 2.578f, 12.555f, 2.347f, 11.782f)
                    lineTo(2.099f, 10.953f)
                    curveTo(1.853f, 10.127f, 2.073f, 9.259f, 2.676f, 8.672f)
                    curveTo(4.101f, 7.288f, 6.666f, 6.508f, 9.992f, 6.504f)
                    curveTo(13.324f, 6.5f, 15.586f, 7.276f, 17.154f, 8.66f)
                    curveTo(17.814f, 9.242f, 18.116f, 10.118f, 17.959f, 10.94f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.callEnd(
    color: Color
) = callEnd(
    SolidColor(color)
)