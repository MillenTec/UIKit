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

fun UIKitFilledSymbols.warning(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Warning",
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
                name = "Warning",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(18.13f, 13.56f)
                    lineTo(12.63f, 3.56f)
                    curveToRelative(-1.14f, -2.07f, -4.12f, -2.07f, -5.26f, 0f)
                    lineTo(1.88f, 13.56f)
                    curveToRelative(-1.1f, 2f, 0.35f, 4.44f, 2.63f, 4.44f)
                    horizontalLineToRelative(10.99f)
                    curveToRelative(2.28f, 0f, 3.73f, -2.45f, 2.63f, -4.44f)
                    close()
                    moveTo(9.5f, 7f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(4f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-4f)
                    close()
                    moveTo(10f, 14.25f)
                    curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 12.75f)
                    curveToRelative(-0.41f, 0f, -0.75f, 0.34f, -0.75f, 0.75f)
                    curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f)
                    curveToRelative(0.41f, 0f, 0.75f, -0.34f, 0.75f, -0.75f)
                    curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f)
                    close()
                    moveTo(10f, 6.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    verticalLineToRelative(4f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-4f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.warning(
    color: Color,
    layered: Boolean = false
) = warning(
    listOf(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
)