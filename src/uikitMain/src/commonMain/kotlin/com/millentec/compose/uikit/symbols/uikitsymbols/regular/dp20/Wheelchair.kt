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

fun UIKitRegularSymbols.wheelchair(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Wheelchair",
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
                name = "Wheelchair",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.5f, 2f)
                    curveTo(14.881f, 2f, 16f, 3.119f, 16f, 4.5f)
                    curveTo(16f, 5.881f, 14.881f, 7f, 13.5f, 7f)
                    curveTo(13.45f, 7f, 13.4f, 6.995f, 13.351f, 6.992f)
                    curveTo(13.357f, 7.021f, 13.366f, 7.05f, 13.371f, 7.08f)
                    curveTo(13.457f, 7.585f, 13.317f, 8.103f, 12.988f, 8.496f)
                    lineTo(11.731f, 10f)
                    horizontalLineTo(15.251f)
                    curveTo(15.781f, 10f, 16.284f, 10.241f, 16.616f, 10.655f)
                    curveTo(16.948f, 11.069f, 17.074f, 11.611f, 16.959f, 12.129f)
                    lineTo(15.959f, 16.633f)
                    curveTo(15.75f, 17.576f, 14.815f, 18.171f, 13.872f, 17.962f)
                    curveTo(12.929f, 17.752f, 12.333f, 16.817f, 12.543f, 15.874f)
                    lineTo(13.07f, 13.5f)
                    horizontalLineTo(11.994f)
                    curveTo(11.998f, 13.583f, 12f, 13.666f, 12f, 13.75f)
                    curveTo(12f, 16.373f, 9.873f, 18.5f, 7.25f, 18.5f)
                    curveTo(4.627f, 18.5f, 2.5f, 16.373f, 2.5f, 13.75f)
                    curveTo(2.5f, 11.359f, 4.267f, 9.38f, 6.566f, 9.049f)
                    lineTo(8.078f, 7.281f)
                    lineTo(7.523f, 6.95f)
                    lineTo(6.987f, 7.487f)
                    curveTo(6.304f, 8.17f, 5.196f, 8.17f, 4.513f, 7.487f)
                    curveTo(3.83f, 6.804f, 3.829f, 5.696f, 4.513f, 5.013f)
                    lineTo(6.014f, 3.513f)
                    lineTo(6.123f, 3.411f)
                    curveTo(6.689f, 2.934f, 7.503f, 2.862f, 8.147f, 3.247f)
                    lineTo(11.046f, 4.978f)
                    curveTo(11.016f, 4.823f, 11f, 4.663f, 11f, 4.5f)
                    curveTo(11f, 3.119f, 12.119f, 2f, 13.5f, 2f)
                    close()
                    moveTo(7.25f, 10f)
                    curveTo(5.179f, 10f, 3.5f, 11.679f, 3.5f, 13.75f)
                    curveTo(3.5f, 15.821f, 5.179f, 17.5f, 7.25f, 17.5f)
                    curveTo(9.321f, 17.5f, 11f, 15.821f, 11f, 13.75f)
                    curveTo(11f, 11.679f, 9.321f, 10f, 7.25f, 10f)
                    close()
                    moveTo(11.122f, 11f)
                    curveTo(11.441f, 11.449f, 11.685f, 11.955f, 11.833f, 12.5f)
                    horizontalLineTo(14.316f)
                    lineTo(13.519f, 16.091f)
                    curveTo(13.429f, 16.495f, 13.684f, 16.896f, 14.089f, 16.985f)
                    curveTo(14.493f, 17.075f, 14.894f, 16.82f, 14.983f, 16.416f)
                    lineTo(15.983f, 11.912f)
                    curveTo(16.032f, 11.69f, 15.978f, 11.458f, 15.836f, 11.28f)
                    curveTo(15.694f, 11.103f, 15.478f, 11f, 15.251f, 11f)
                    horizontalLineTo(11.122f)
                    close()
                    moveTo(7.635f, 4.106f)
                    curveTo(7.377f, 3.953f, 7.056f, 3.969f, 6.817f, 4.138f)
                    lineTo(6.721f, 4.22f)
                    lineTo(5.22f, 5.72f)
                    curveTo(4.927f, 6.013f, 4.927f, 6.487f, 5.22f, 6.78f)
                    curveTo(5.513f, 7.073f, 5.987f, 7.073f, 6.28f, 6.78f)
                    lineTo(7.367f, 5.692f)
                    lineTo(9.608f, 7.03f)
                    lineTo(7.887f, 9.043f)
                    curveTo(8.738f, 9.157f, 9.518f, 9.497f, 10.164f, 10f)
                    horizontalLineTo(10.427f)
                    lineTo(12.222f, 7.854f)
                    curveTo(12.362f, 7.686f, 12.422f, 7.464f, 12.386f, 7.248f)
                    curveTo(12.349f, 7.032f, 12.219f, 6.842f, 12.03f, 6.729f)
                    lineTo(7.635f, 4.106f)
                    close()
                    moveTo(13.5f, 3f)
                    curveTo(12.672f, 3f, 12f, 3.672f, 12f, 4.5f)
                    curveTo(12f, 5.328f, 12.672f, 6f, 13.5f, 6f)
                    curveTo(14.328f, 6f, 15f, 5.328f, 15f, 4.5f)
                    curveTo(15f, 3.672f, 14.328f, 3f, 13.5f, 3f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.wheelchair(
    color: Color
) = wheelchair(
    SolidColor(color)
)