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

fun UIKitRegularSymbols.weatherSunny(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "WeatherSunny",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.6f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "WeatherSunny",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 6f)
                    curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f)
                    reflectiveCurveToRelative(1.79f, 4f, 4f, 4f)
                    reflectiveCurveToRelative(4f, -1.79f, 4f, -4f)
                    reflectiveCurveToRelative(-1.79f, -4f, -4f, -4f)
                    close()
                    moveTo(10f, 13f)
                    curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f)
                    reflectiveCurveToRelative(1.34f, -3f, 3f, -3f)
                    reflectiveCurveToRelative(3f, 1.34f, 3f, 3f)
                    reflectiveCurveToRelative(-1.34f, 3f, -3f, 3f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 2f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(1f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-1f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                    moveTo(17.5f, 10.5f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-1f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(1f)
                    close()
                    moveTo(10f, 16f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(1f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-1f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                    moveTo(3.5f, 10.5f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-1.04f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(1.04f)
                    close()
                    moveTo(4.15f, 4.15f)
                    curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
                    lineToRelative(1f, 1f)
                    curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
                    curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
                    lineToRelative(-1f, -1f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    close()
                    moveTo(4.85f, 15.85f)
                    curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    lineToRelative(1f, -1f)
                    curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
                    curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
                    lineToRelative(-1f, 1f)
                    close()
                    moveTo(15.85f, 4.15f)
                    curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f)
                    lineToRelative(-1f, 1f)
                    curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f)
                    curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f)
                    lineToRelative(1f, -1f)
                    curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f)
                    close()
                    moveTo(15.15f, 15.85f)
                    curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f)
                    curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f)
                    lineToRelative(-1f, -1f)
                    curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f)
                    curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f)
                    lineToRelative(1f, 1f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.weatherSunny(
    color: Color,
    layered: Boolean = false
) = weatherSunny(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)