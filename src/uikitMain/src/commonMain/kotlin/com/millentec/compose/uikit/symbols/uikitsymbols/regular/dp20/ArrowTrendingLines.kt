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

fun UIKitRegularSymbols.arrowTrendingLines(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowTrendingLines",
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
                name = "ArrowTrendingLines",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14.5f, 2f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(1.79f)
                    lineToRelative(-4.79f, 4.79f)
                    lineToRelative(-2.65f, -2.65f)
                    curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f)
                    lineToRelative(-5f, 5f)
                    curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f)
                    curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f)
                    lineToRelative(4.65f, -4.65f)
                    lineToRelative(2.65f, 2.65f)
                    curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f)
                    lineToRelative(5.15f, -5.15f)
                    verticalLineToRelative(1.79f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-3f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-3f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(15.5f, 9f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    verticalLineToRelative(8f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-8f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    close()
                    moveTo(7.5f, 11f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    verticalLineToRelative(6f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-6f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    close()
                    moveTo(11f, 13.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(4f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-4f)
                    close()
                    moveTo(3f, 14.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(3f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-3f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.arrowTrendingLines(
    color: Color,
    layered: Boolean = false
) = arrowTrendingLines(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)