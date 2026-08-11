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

fun UIKitFilledSymbols.exit(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Exit",
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
                name = "Exit",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(12.25f, 17.5f)
                    curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f)
                    horizontalLineToRelative(-6.25f)
                    curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f)
                    verticalLineTo(6f)
                    curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                    horizontalLineToRelative(6.25f)
                    curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(-0.34f, -0.75f, -0.75f, -0.75f)
                    horizontalLineToRelative(-6.25f)
                    curveToRelative(-1.93f, 0f, -3.5f, 1.57f, -3.5f, 3.5f)
                    verticalLineToRelative(8f)
                    curveToRelative(0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f)
                    horizontalLineToRelative(6.25f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.74f, 6.2f)
                    curveToRelative(0.3f, -0.28f, 0.78f, -0.26f, 1.06f, 0.04f)
                    lineToRelative(3f, 3.25f)
                    curveToRelative(0.27f, 0.29f, 0.27f, 0.73f, 0f, 1.02f)
                    lineToRelative(-3f, 3.25f)
                    curveToRelative(-0.28f, 0.3f, -0.76f, 0.32f, -1.06f, 0.04f)
                    curveToRelative(-0.3f, -0.28f, -0.32f, -0.76f, -0.04f, -1.06f)
                    lineToRelative(1.84f, -1.99f)
                    horizontalLineToRelative(-7.79f)
                    curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
                    reflectiveCurveToRelative(0.34f, -0.75f, 0.75f, -0.75f)
                    horizontalLineToRelative(7.79f)
                    lineToRelative(-1.84f, -1.99f)
                    curveToRelative(-0.28f, -0.3f, -0.26f, -0.78f, 0.04f, -1.06f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.exit(
    color: Color,
    layered: Boolean = false
) = exit(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)