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

fun UIKitRegularSymbols.exit(
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
                    moveTo(12.5f, 17f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-6.5f)
                    curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f)
                    verticalLineTo(6f)
                    curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
                    horizontalLineToRelative(6.5f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-6.5f)
                    curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f)
                    verticalLineToRelative(8f)
                    curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f)
                    horizontalLineToRelative(6.5f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.65f, 6.15f)
                    curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f)
                    lineToRelative(3.5f, 3.5f)
                    curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f)
                    lineToRelative(-3.5f, 3.5f)
                    curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    lineToRelative(2.65f, -2.65f)
                    horizontalLineTo(7.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(8.79f)
                    lineToRelative(-2.65f, -2.65f)
                    curveToRelative(-0.2f, -0.2f, -0.2f, -0.51f, 0f, -0.71f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.exit(
    color: Color,
    layered: Boolean = false
) = exit(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)