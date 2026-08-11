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

fun UIKitRegularSymbols.copy(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Copy",
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
                name = "Copy",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14f, 2f)
                    horizontalLineToRelative(-6f)
                    curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
                    verticalLineToRelative(10f)
                    curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
                    horizontalLineToRelative(6f)
                    curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                    verticalLineTo(4f)
                    curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
                    close()
                    moveTo(15f, 14f)
                    curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                    horizontalLineToRelative(-6f)
                    curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                    verticalLineTo(4f)
                    curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
                    horizontalLineToRelative(6f)
                    curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
                    verticalLineToRelative(10f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(4f, 6f)
                    curveToRelative(0f, -0.74f, 0.4f, -1.39f, 1f, -1.73f)
                    verticalLineToRelative(10.23f)
                    curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f)
                    horizontalLineToRelative(6.23f)
                    curveToRelative(-0.35f, 0.6f, -0.99f, 1f, -1.73f, 1f)
                    horizontalLineToRelative(-4.5f)
                    curveToRelative(-1.93f, 0f, -3.5f, -1.57f, -3.5f, -3.5f)
                    verticalLineTo(6f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.copy(
    color: Color,
    layered: Boolean = false
) = copy(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)