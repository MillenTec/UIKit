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
import com.millentec.compose.uikit.symbols.uikitsymbols.UIKitSymbolLayerInfo

fun UIKitFilledSymbols.arrowRepeat1(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ArrowRepeat1",
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
                name = "ArrowRepeat1",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(15.75f, 6.01f)
                    curveToRelative(0.18f, 0f, 0.34f, 0.06f, 0.47f, 0.17f)
                    curveToRelative(1.09f, 0.91f, 1.78f, 2.29f, 1.78f, 3.82f)
                    curveToRelative(0f, 0.2f, -0.01f, 0.39f, -0.03f, 0.59f)
                    curveToRelative(-0.46f, -0.23f, -0.95f, -0.4f, -1.47f, -0.49f)
                    verticalLineToRelative(-0.09f)
                    curveToRelative(0f, -1.08f, -0.49f, -2.05f, -1.26f, -2.69f)
                    curveToRelative(-0.15f, -0.13f, -0.24f, -0.33f, -0.24f, -0.55f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                    moveTo(10.37f, 13.5f)
                    curveToRelative(-0.18f, 0.47f, -0.31f, 0.98f, -0.35f, 1.5f)
                    horizontalLineToRelative(-1.46f)
                    lineToRelative(1.22f, 1.22f)
                    curveToRelative(0.27f, 0.27f, 0.29f, 0.68f, 0.07f, 0.98f)
                    lineToRelative(-0.07f, 0.08f)
                    curveToRelative(-0.27f, 0.27f, -0.68f, 0.29f, -0.98f, 0.07f)
                    lineToRelative(-0.08f, -0.07f)
                    lineToRelative(-2.5f, -2.5f)
                    curveToRelative(-0.27f, -0.27f, -0.29f, -0.68f, -0.07f, -0.98f)
                    lineToRelative(0.07f, -0.08f)
                    lineToRelative(2.5f, -2.5f)
                    curveToRelative(0.29f, -0.29f, 0.77f, -0.29f, 1.06f, 0f)
                    curveToRelative(0.27f, 0.27f, 0.29f, 0.68f, 0.07f, 0.98f)
                    lineToRelative(-0.07f, 0.08f)
                    lineToRelative(-1.22f, 1.22f)
                    horizontalLineToRelative(1.81f)
                    close()
                    moveTo(10.22f, 2.72f)
                    curveToRelative(0.27f, -0.27f, 0.68f, -0.29f, 0.98f, -0.07f)
                    lineToRelative(0.08f, 0.07f)
                    lineToRelative(2.5f, 2.5f)
                    lineToRelative(0.07f, 0.08f)
                    curveToRelative(0.19f, 0.26f, 0.2f, 0.62f, 0f, 0.88f)
                    lineToRelative(-0.08f, 0.09f)
                    lineToRelative(-2.5f, 2.5f)
                    lineToRelative(-0.08f, 0.07f)
                    curveToRelative(-0.26f, 0.19f, -0.62f, 0.2f, -0.88f, 0f)
                    lineToRelative(-0.09f, -0.08f)
                    lineToRelative(-0.07f, -0.08f)
                    curveToRelative(-0.19f, -0.26f, -0.2f, -0.62f, 0f, -0.88f)
                    lineToRelative(0.08f, -0.09f)
                    lineToRelative(1.22f, -1.22f)
                    horizontalLineToRelative(-4.44f)
                    curveToRelative(-1.87f, 0f, -3.4f, 1.46f, -3.49f, 3.31f)
                    verticalLineToRelative(0.19f)
                    curveToRelative(0f, 1.08f, 0.49f, 2.05f, 1.26f, 2.69f)
                    curveToRelative(0.15f, 0.14f, 0.24f, 0.33f, 0.24f, 0.55f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.19f, 0f, -0.37f, -0.07f, -0.5f, -0.19f)
                    curveToRelative(-1.07f, -0.91f, -1.75f, -2.28f, -1.75f, -3.8f)
                    curveToRelative(0f, -2.69f, 2.12f, -4.88f, 4.78f, -5f)
                    horizontalLineToRelative(0.22f)
                    reflectiveCurveToRelative(4.44f, 0f, 4.44f, 0f)
                    lineToRelative(-1.22f, -1.22f)
                    lineToRelative(-0.07f, -0.08f)
                    curveToRelative(-0.22f, -0.29f, -0.19f, -0.71f, 0.07f, -0.98f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(15.5f, 11f)
                    curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
                    reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
                    reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
                    reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
                    close()
                    moveTo(16.5f, 17.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-3.08f)
                    curveToRelative(-0.22f, 0.19f, -0.48f, 0.38f, -0.78f, 0.53f)
                    curveToRelative(-0.25f, 0.12f, -0.55f, 0.02f, -0.67f, -0.22f)
                    curveToRelative(-0.12f, -0.25f, -0.02f, -0.55f, 0.22f, -0.67f)
                    curveToRelative(0.51f, -0.26f, 0.88f, -0.68f, 1.09f, -0.98f)
                    curveToRelative(0.19f, -0.27f, 0.49f, -0.29f, 0.68f, -0.23f)
                    curveToRelative(0.18f, 0.05f, 0.45f, 0.24f, 0.45f, 0.58f)
                    verticalLineToRelative(4.08f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.arrowRepeat1(
    color: Color,
    layered: Boolean = false
) = arrowRepeat1(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)