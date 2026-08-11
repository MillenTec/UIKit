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

fun UIKitFilledSymbols.write(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Write",
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
                name = "Write",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10.25f, 4f)
                    curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    horizontalLineToRelative(-4f)
                    curveToRelative(-0.97f, 0f, -1.75f, 0.78f, -1.75f, 1.75f)
                    verticalLineToRelative(6.5f)
                    curveToRelative(0f, 0.97f, 0.78f, 1.75f, 1.75f, 1.75f)
                    horizontalLineToRelative(6.5f)
                    curveToRelative(0.97f, 0f, 1.75f, -0.78f, 1.75f, -1.75f)
                    verticalLineToRelative(-4f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    reflectiveCurveToRelative(0.75f, 0.34f, 0.75f, 0.75f)
                    verticalLineToRelative(4f)
                    curveToRelative(0f, 1.79f, -1.46f, 3.25f, -3.25f, 3.25f)
                    horizontalLineToRelative(-6.5f)
                    curveToRelative(-1.79f, 0f, -3.25f, -1.46f, -3.25f, -3.25f)
                    verticalLineToRelative(-6.5f)
                    curveToRelative(0f, -1.79f, 1.46f, -3.25f, 3.25f, -3.25f)
                    horizontalLineToRelative(4f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(15.72f, 3.22f)
                    curveToRelative(0.29f, -0.29f, 0.77f, -0.29f, 1.06f, 0f)
                    curveToRelative(0.29f, 0.29f, 0.29f, 0.77f, 0f, 1.06f)
                    lineToRelative(-7.19f, 7.19f)
                    lineToRelative(-1.59f, 0.53f)
                    lineToRelative(0.53f, -1.59f)
                    lineToRelative(7.19f, -7.19f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.write(
    color: Color,
    layered: Boolean = false
) = write(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)