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

fun UIKitFilledSymbols.gameController(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "GameController",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "GameController",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(8.334f, 4.711f)
                    curveTo(7.901f, 4.493f, 7.422f, 4.458f, 6.983f, 4.542f)
                    lineTo(6.089f, 4.711f)
                    curveTo(5.374f, 4.847f, 4.757f, 5.306f, 4.424f, 5.956f)
                    curveTo(3.314f, 8.121f, 2.48f, 9.888f, 2.153f, 11.393f)
                    curveTo(1.818f, 12.938f, 2.007f, 14.254f, 2.974f, 15.454f)
                    curveTo(3.628f, 16.267f, 4.774f, 16.105f, 5.373f, 15.429f)
                    curveTo(5.84f, 14.901f, 6.37f, 14.292f, 6.885f, 13.696f)
                    curveTo(7.268f, 13.255f, 7.822f, 13f, 8.404f, 13f)
                    horizontalLineTo(11.591f)
                    curveTo(12.173f, 13f, 12.727f, 13.255f, 13.11f, 13.696f)
                    curveTo(13.625f, 14.292f, 14.155f, 14.901f, 14.623f, 15.429f)
                    curveTo(15.221f, 16.105f, 16.367f, 16.267f, 17.021f, 15.454f)
                    curveTo(17.988f, 14.254f, 18.177f, 12.938f, 17.842f, 11.393f)
                    curveTo(17.515f, 9.888f, 16.681f, 8.121f, 15.571f, 5.956f)
                    curveTo(15.238f, 5.306f, 14.622f, 4.847f, 13.906f, 4.711f)
                    lineTo(13.012f, 4.542f)
                    curveTo(12.573f, 4.458f, 12.094f, 4.493f, 11.66f, 4.711f)
                    lineTo(11.603f, 4.74f)
                    curveTo(11.276f, 4.907f, 10.931f, 5f, 10.589f, 5f)
                    horizontalLineTo(9.406f)
                    curveTo(9.065f, 5f, 8.719f, 4.907f, 8.392f, 4.74f)
                    lineTo(8.334f, 4.711f)
                    close()
                    moveTo(10f, 8.5f)
                    curveTo(9.586f, 8.5f, 9.25f, 8.164f, 9.25f, 7.75f)
                    curveTo(9.25f, 7.336f, 9.586f, 7f, 10f, 7f)
                    curveTo(10.414f, 7f, 10.75f, 7.336f, 10.75f, 7.75f)
                    curveTo(10.75f, 8.164f, 10.414f, 8.5f, 10f, 8.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.gameController(
    color: Color
) = gameController(
    SolidColor(color)
)