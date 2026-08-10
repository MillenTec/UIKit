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

fun UIKitRegularSymbols.weatherSnow(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "WeatherSnow",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "WeatherSnow",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(8.5f, 15f)
                    curveTo(8.776f, 15f, 9f, 15.224f, 9f, 15.5f)
                    curveTo(9f, 15.776f, 8.776f, 16f, 8.5f, 16f)
                    curveTo(8.224f, 16f, 8f, 15.776f, 8f, 15.5f)
                    curveTo(8f, 15.224f, 8.224f, 15f, 8.5f, 15f)
                    close()
                    moveTo(11.5f, 15f)
                    curveTo(11.776f, 15f, 12f, 15.224f, 12f, 15.5f)
                    curveTo(12f, 15.776f, 11.776f, 16f, 11.5f, 16f)
                    curveTo(11.224f, 16f, 11f, 15.776f, 11f, 15.5f)
                    curveTo(11f, 15.224f, 11.224f, 15f, 11.5f, 15f)
                    close()
                    moveTo(7f, 14f)
                    curveTo(7.276f, 14f, 7.5f, 14.224f, 7.5f, 14.5f)
                    curveTo(7.5f, 14.776f, 7.276f, 15f, 7f, 15f)
                    curveTo(6.724f, 15f, 6.5f, 14.776f, 6.5f, 14.5f)
                    curveTo(6.5f, 14.224f, 6.724f, 14f, 7f, 14f)
                    close()
                    moveTo(10f, 14f)
                    curveTo(10.276f, 14f, 10.5f, 14.224f, 10.5f, 14.5f)
                    curveTo(10.5f, 14.776f, 10.276f, 15f, 10f, 15f)
                    curveTo(9.724f, 15f, 9.5f, 14.776f, 9.5f, 14.5f)
                    curveTo(9.5f, 14.224f, 9.724f, 14f, 10f, 14f)
                    close()
                    moveTo(13f, 14f)
                    curveTo(13.276f, 14f, 13.5f, 14.224f, 13.5f, 14.5f)
                    curveTo(13.5f, 14.776f, 13.276f, 15f, 13f, 15f)
                    curveTo(12.724f, 15f, 12.5f, 14.776f, 12.5f, 14.5f)
                    curveTo(12.5f, 14.224f, 12.724f, 14f, 13f, 14f)
                    close()
                    moveTo(10f, 4f)
                    curveTo(12.465f, 4f, 13.863f, 5.574f, 14.066f, 7.474f)
                    lineTo(14.128f, 7.474f)
                    curveTo(15.714f, 7.474f, 17f, 8.711f, 17f, 10.237f)
                    curveTo(17f, 11.763f, 15.714f, 13f, 14.128f, 13f)
                    horizontalLineTo(5.872f)
                    curveTo(4.286f, 13f, 3f, 11.763f, 3f, 10.237f)
                    curveTo(3f, 8.768f, 4.192f, 7.566f, 5.697f, 7.479f)
                    lineTo(5.934f, 7.474f)
                    curveTo(6.139f, 5.561f, 7.535f, 4f, 10f, 4f)
                    close()
                    moveTo(10f, 5f)
                    curveTo(8.351f, 5f, 6.913f, 6.27f, 6.913f, 8.025f)
                    curveTo(6.913f, 8.303f, 6.659f, 8.521f, 6.368f, 8.521f)
                    lineTo(5.818f, 8.521f)
                    curveTo(4.814f, 8.521f, 4f, 9.3f, 4f, 10.261f)
                    curveTo(4f, 11.221f, 4.814f, 12f, 5.818f, 12f)
                    horizontalLineTo(14.182f)
                    curveTo(15.186f, 12f, 16f, 11.221f, 16f, 10.261f)
                    curveTo(16f, 9.3f, 15.186f, 8.521f, 14.182f, 8.521f)
                    lineTo(13.632f, 8.521f)
                    curveTo(13.341f, 8.521f, 13.087f, 8.303f, 13.087f, 8.025f)
                    curveTo(13.087f, 6.248f, 11.649f, 5f, 10f, 5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.weatherSnow(
    color: Color
) = weatherSnow(
    SolidColor(color)
)