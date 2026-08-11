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

fun UIKitFilledSymbols.checkmarkCircle(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "CheckmarkCircle",
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
                name = "CheckmarkCircle",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 2f)
                    curveTo(5.58f, 2f, 2f, 5.58f, 2f, 10f)
                    reflectiveCurveToRelative(3.58f, 8f, 8f, 8f)
                    reflectiveCurveToRelative(8f, -3.58f, 8f, -8f)
                    reflectiveCurveTo(14.42f, 2f, 10f, 2f)
                    close()
                    moveTo(13.42f, 8.28f)
                    lineToRelative(-0.06f, 0.07f)
                    lineToRelative(-4f, 4f)
                    lineToRelative(-0.07f, 0.06f)
                    curveToRelative(-0.17f, 0.12f, -0.4f, 0.12f, -0.57f, 0f)
                    lineToRelative(-0.07f, -0.06f)
                    lineToRelative(-2f, -2f)
                    lineToRelative(-0.06f, -0.07f)
                    curveToRelative(-0.13f, -0.19f, -0.12f, -0.46f, 0.06f, -0.64f)
                    curveToRelative(0.17f, -0.17f, 0.44f, -0.19f, 0.64f, -0.06f)
                    lineToRelative(0.07f, 0.06f)
                    lineToRelative(1.65f, 1.65f)
                    lineToRelative(3.65f, -3.65f)
                    lineToRelative(0.07f, -0.06f)
                    curveToRelative(0.19f, -0.13f, 0.46f, -0.12f, 0.64f, 0.06f)
                    reflectiveCurveToRelative(0.19f, 0.44f, 0.06f, 0.64f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.36f, 7.65f)
                    curveToRelative(-0.17f, -0.17f, -0.44f, -0.19f, -0.64f, -0.06f)
                    lineToRelative(-0.07f, 0.06f)
                    lineToRelative(-3.65f, 3.65f)
                    lineToRelative(-1.65f, -1.65f)
                    lineToRelative(-0.07f, -0.06f)
                    curveToRelative(-0.19f, -0.14f, -0.46f, -0.12f, -0.64f, 0.06f)
                    curveToRelative(-0.17f, 0.17f, -0.19f, 0.44f, -0.06f, 0.64f)
                    lineToRelative(0.06f, 0.07f)
                    lineToRelative(2f, 2f)
                    lineToRelative(0.07f, 0.06f)
                    curveToRelative(0.17f, 0.12f, 0.4f, 0.12f, 0.57f, 0f)
                    lineToRelative(0.07f, -0.06f)
                    lineToRelative(4f, -4f)
                    lineToRelative(0.06f, -0.07f)
                    curveToRelative(0.14f, -0.19f, 0.12f, -0.46f, -0.06f, -0.64f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.checkmarkCircle(
    color: Color,
    layered: Boolean = false
) = checkmarkCircle(
    listOf(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
)