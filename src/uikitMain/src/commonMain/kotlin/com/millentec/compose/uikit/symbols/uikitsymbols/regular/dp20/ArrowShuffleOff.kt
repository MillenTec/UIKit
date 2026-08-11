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

fun UIKitRegularSymbols.arrowShuffleOff(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowShuffleOff",
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
                name = "ArrowShuffleOff",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.85f, 17.85f)
                    curveToRelative(-0.19f, 0.2f, -0.51f, 0.2f, -0.7f, 0f)
                    lineToRelative(-3.5f, -3.5f)
                    lineToRelative(-1.68f, -1.67f)
                    lineToRelative(-1.52f, -1.52f)
                    lineToRelative(-0.7f, -0.71f)
                    lineToRelative(-0.71f, -0.7f)
                    lineToRelative(-0.71f, -0.71f)
                    lineToRelative(-3.31f, -3.31f)
                    lineToRelative(-2.87f, -2.88f)
                    curveToRelative(-0.2f, -0.19f, -0.2f, -0.51f, 0f, -0.7f)
                    curveToRelative(0.19f, -0.2f, 0.51f, -0.2f, 0.7f, 0f)
                    lineToRelative(15f, 15f)
                    curveToRelative(0.2f, 0.19f, 0.2f, 0.51f, 0f, 0.7f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(8.33f, 9.04f)
                    curveToRelative(-0.1f, 0.1f, -0.21f, 0.19f, -0.31f, 0.29f)
                    curveToRelative(-1.5f, -1.31f, -3.1f, -2.33f, -5.52f, -2.33f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    curveToRelative(1.41f, 0f, 2.58f, 0.31f, 3.59f, 0.8f)
                    lineToRelative(2.24f, 2.24f)
                    close()
                    moveTo(9.04f, 9.75f)
                    curveToRelative(-1.84f, 1.71f, -3.57f, 3.25f, -6.54f, 3.25f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    curveToRelative(3.41f, 0f, 5.41f, -1.83f, 7.25f, -3.55f)
                    lineToRelative(-0.71f, -0.7f)
                    close()
                    moveTo(16.29f, 13f)
                    lineToRelative(-1.14f, -1.14f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
                    lineToRelative(2f, 2f)
                    curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
                    lineToRelative(-0.94f, 0.94f)
                    lineToRelative(-0.71f, -0.71f)
                    lineToRelative(0.09f, -0.09f)
                    curveToRelative(-0.06f, 0f, -0.12f, 0f, -0.18f, 0f)
                    lineToRelative(-1.14f, -1.14f)
                    curveToRelative(0.41f, 0.08f, 0.85f, 0.14f, 1.32f, 0.15f)
                    close()
                    moveTo(16.3f, 6f)
                    lineToRelative(-1.15f, -1.15f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
                    lineToRelative(2f, 2f)
                    curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
                    lineToRelative(-2f, 2f)
                    curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    lineToRelative(1.14f, -1.14f)
                    curveToRelative(-2.17f, 0.05f, -3.67f, 0.95f, -5.06f, 2.11f)
                    lineToRelative(-0.71f, -0.71f)
                    curveToRelative(1.49f, -1.26f, 3.24f, -2.34f, 5.77f, -2.4f)
                    close()
                    moveTo(10.45f, 11.16f)
                    lineToRelative(-0.21f, 0.2f)
                    curveToRelative(0.54f, 0.47f, 1.11f, 0.92f, 1.73f, 1.32f)
                    lineToRelative(-1.52f, -1.52f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.arrowShuffleOff(
    color: Color,
    layered: Boolean = false
) = arrowShuffleOff(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)