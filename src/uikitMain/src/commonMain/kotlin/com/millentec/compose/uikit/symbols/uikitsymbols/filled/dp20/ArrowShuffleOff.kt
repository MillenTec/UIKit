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

fun UIKitFilledSymbols.arrowShuffleOff(
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
                    lineToRelative(-0.75f, -0.74f)
                    lineToRelative(-0.73f, -0.74f)
                    horizontalLineToRelative(-0.01f)
                    lineToRelative(-1.03f, -1.03f)
                    horizontalLineToRelative(0f)
                    reflectiveCurveToRelative(-1.43f, -1.44f, -1.43f, -1.44f)
                    curveToRelative(-0.01f, 0f, -0.01f, -0.01f, -0.02f, -0.01f)
                    lineToRelative(-2.54f, -2.54f)
                    lineToRelative(-0.71f, -0.71f)
                    lineToRelative(-1.77f, -1.77f)
                    lineToRelative(-3.01f, -3.01f)
                    lineToRelative(-0.82f, -0.82f)
                    lineToRelative(-2.18f, -2.19f)
                    curveToRelative(-0.2f, -0.19f, -0.2f, -0.51f, 0f, -0.7f)
                    curveToRelative(0.19f, -0.2f, 0.51f, -0.2f, 0.7f, 0f)
                    lineToRelative(15f, 15f)
                    curveToRelative(0.2f, 0.19f, 0.2f, 0.51f, 0f, 0.7f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(8.16f, 8.87f)
                    curveToRelative(-0.13f, 0.14f, -0.26f, 0.28f, -0.39f, 0.42f)
                    curveToRelative(-1.35f, -1.32f, -2.78f, -2.29f, -5.02f, -2.29f)
                    curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
                    reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f)
                    curveToRelative(0.89f, 0f, 1.69f, 0.13f, 2.4f, 0.36f)
                    lineToRelative(3.01f, 3.01f)
                    close()
                    moveTo(8.87f, 9.58f)
                    curveToRelative(-1.73f, 1.85f, -3.27f, 3.42f, -6.12f, 3.42f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    reflectiveCurveToRelative(0.34f, 0.75f, 0.75f, 0.75f)
                    curveToRelative(3.53f, 0f, 5.47f, -2.03f, 7.18f, -3.86f)
                    lineToRelative(-1.06f, -1.06f)
                    close()
                    moveTo(15.39f, 12.95f)
                    lineToRelative(-0.67f, -0.67f)
                    curveToRelative(-0.29f, -0.29f, -0.29f, -0.77f, 0f, -1.06f)
                    reflectiveCurveToRelative(0.77f, -0.29f, 1.06f, 0f)
                    lineToRelative(2f, 2f)
                    curveToRelative(0.29f, 0.29f, 0.29f, 0.77f, 0f, 1.06f)
                    lineToRelative(-0.69f, 0.69f)
                    lineToRelative(-2.08f, -2.08f)
                    curveToRelative(0.12f, 0.02f, 0.25f, 0.04f, 0.38f, 0.06f)
                    close()
                    moveTo(15.47f, 5.53f)
                    lineToRelative(-0.75f, -0.75f)
                    curveToRelative(-0.29f, -0.29f, -0.29f, -0.77f, 0f, -1.06f)
                    curveToRelative(0.29f, -0.29f, 0.77f, -0.29f, 1.06f, 0f)
                    lineToRelative(2f, 2f)
                    curveToRelative(0.29f, 0.29f, 0.29f, 0.77f, 0f, 1.06f)
                    lineToRelative(-2f, 2f)
                    curveToRelative(-0.29f, 0.29f, -0.77f, 0.29f, -1.06f, 0f)
                    curveToRelative(-0.29f, -0.29f, -0.29f, -0.77f, 0f, -1.06f)
                    lineToRelative(0.67f, -0.67f)
                    curveToRelative(-1.71f, 0.21f, -2.93f, 1.05f, -4.07f, 2.15f)
                    lineToRelative(-1.06f, -1.06f)
                    curveToRelative(1.32f, -1.27f, 2.9f, -2.4f, 5.22f, -2.6f)
                    close()
                    moveTo(10.64f, 11.35f)
                    curveToRelative(-0.14f, 0.15f, -0.29f, 0.3f, -0.44f, 0.46f)
                    curveToRelative(0.85f, 0.82f, 1.8f, 1.58f, 2.98f, 2.08f)
                    lineToRelative(-2.54f, -2.54f)
                    close()
                    moveTo(14.63f, 15.34f)
                    curveToRelative(-0.2f, 0.29f, -0.17f, 0.68f, 0.09f, 0.94f)
                    curveToRelative(0.26f, 0.26f, 0.65f, 0.29f, 0.94f, 0.09f)
                    lineToRelative(-1.03f, -1.03f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.arrowShuffleOff(
    color: Color,
    layered: Boolean = false
) = arrowShuffleOff(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)