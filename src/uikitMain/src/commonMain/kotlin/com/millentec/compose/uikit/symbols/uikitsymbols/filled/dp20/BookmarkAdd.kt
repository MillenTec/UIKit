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

fun UIKitFilledSymbols.bookmarkAdd(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "BookmarkAdd",
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
                name = "BookmarkAdd",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14.5f, 1f)
                    curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
                    reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
                    reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
                    reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
                    close()
                    moveTo(16.5f, 6f)
                    horizontalLineToRelative(-1.5f)
                    verticalLineToRelative(1.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-1.5f)
                    horizontalLineToRelative(-1.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(1.5f)
                    verticalLineToRelative(-1.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(1.5f)
                    horizontalLineToRelative(1.5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(14.5f, 11f)
                    curveToRelative(0.52f, 0f, 1.02f, -0.07f, 1.5f, -0.21f)
                    verticalLineToRelative(6.71f)
                    curveToRelative(0f, 0.19f, -0.11f, 0.36f, -0.27f, 0.45f)
                    curveToRelative(-0.17f, 0.09f, -0.37f, 0.07f, -0.52f, -0.04f)
                    lineToRelative(-5.21f, -3.79f)
                    lineToRelative(-5.21f, 3.79f)
                    curveToRelative(-0.15f, 0.11f, -0.35f, 0.13f, -0.52f, 0.04f)
                    curveToRelative(-0.17f, -0.09f, -0.27f, -0.26f, -0.27f, -0.45f)
                    verticalLineTo(4.5f)
                    curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f)
                    horizontalLineToRelative(3.76f)
                    curveToRelative(-0.79f, 0.95f, -1.26f, 2.17f, -1.26f, 3.5f)
                    curveToRelative(0f, 3.04f, 2.46f, 5.5f, 5.5f, 5.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.bookmarkAdd(
    color: Color,
    layered: Boolean = false
) = bookmarkAdd(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)