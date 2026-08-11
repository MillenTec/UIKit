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

fun UIKitRegularSymbols.camera(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Camera",
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
                name = "Camera",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 6f)
                    curveTo(7.791f, 6f, 6f, 7.791f, 6f, 10f)
                    curveTo(6f, 12.209f, 7.791f, 14f, 10f, 14f)
                    curveTo(12.209f, 14f, 14f, 12.209f, 14f, 10f)
                    curveTo(14f, 7.791f, 12.209f, 6f, 10f, 6f)
                    close()
                    moveTo(7f, 10f)
                    curveTo(7f, 8.343f, 8.343f, 7f, 10f, 7f)
                    curveTo(11.657f, 7f, 13f, 8.343f, 13f, 10f)
                    curveTo(13f, 11.657f, 11.657f, 13f, 10f, 13f)
                    curveTo(8.343f, 13f, 7f, 11.657f, 7f, 10f)
                    close()
                    moveTo(8.124f, 2f)
                    curveTo(7.557f, 2f, 7.038f, 2.32f, 6.784f, 2.826f)
                    lineTo(6.194f, 3.999f)
                    horizontalLineTo(4.505f)
                    curveTo(3.124f, 3.999f, 2.005f, 5.119f, 2.005f, 6.499f)
                    verticalLineTo(14.5f)
                    curveTo(2.005f, 15.881f, 3.124f, 17f, 4.505f, 17f)
                    horizontalLineTo(15.505f)
                    curveTo(16.886f, 17f, 18.005f, 15.881f, 18.005f, 14.5f)
                    verticalLineTo(6.499f)
                    curveTo(18.005f, 5.119f, 16.886f, 3.999f, 15.505f, 3.999f)
                    horizontalLineTo(13.815f)
                    lineTo(13.23f, 2.829f)
                    curveTo(12.976f, 2.321f, 12.457f, 2f, 11.888f, 2f)
                    horizontalLineTo(8.124f)
                    close()
                    moveTo(7.677f, 3.275f)
                    curveTo(7.762f, 3.107f, 7.935f, 3f, 8.124f, 3f)
                    horizontalLineTo(11.888f)
                    curveTo(12.078f, 3f, 12.251f, 3.107f, 12.336f, 3.276f)
                    lineTo(13.059f, 4.723f)
                    curveTo(13.143f, 4.892f, 13.316f, 4.999f, 13.506f, 4.999f)
                    horizontalLineTo(15.505f)
                    curveTo(16.333f, 4.999f, 17.005f, 5.671f, 17.005f, 6.499f)
                    verticalLineTo(14.5f)
                    curveTo(17.005f, 15.328f, 16.333f, 16f, 15.505f, 16f)
                    horizontalLineTo(4.505f)
                    curveTo(3.676f, 16f, 3.005f, 15.328f, 3.005f, 14.5f)
                    verticalLineTo(6.499f)
                    curveTo(3.005f, 5.671f, 3.676f, 4.999f, 4.505f, 4.999f)
                    horizontalLineTo(6.503f)
                    curveTo(6.692f, 4.999f, 6.865f, 4.893f, 6.949f, 4.724f)
                    lineTo(7.677f, 3.275f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.camera(
    color: Color
) = camera(
    SolidColor(color)
)