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

fun UIKitRegularSymbols.wand(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Wand",
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
            return ImageVector.Builder(
                name = "Wand",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(16.5f, 2f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(0.5f)
                    horizontalLineToRelative(0.5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.22f, 0.5f, -0.5f, 0.5f)
                    horizontalLineToRelative(-0.5f)
                    verticalLineToRelative(0.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-0.5f)
                    horizontalLineToRelative(-0.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(0.5f)
                    verticalLineToRelative(-0.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    close()
                    moveTo(6.5f, 6f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-0.5f)
                    verticalLineToRelative(-0.5f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f)
                    verticalLineToRelative(0.5f)
                    horizontalLineToRelative(-0.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(0.5f)
                    verticalLineToRelative(0.5f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-0.5f)
                    horizontalLineToRelative(0.5f)
                    close()
                    moveTo(15.5f, 15f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-0.5f)
                    verticalLineToRelative(-0.5f)
                    curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f)
                    verticalLineToRelative(0.5f)
                    horizontalLineToRelative(-0.5f)
                    curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(0.22f, 0.5f, 0.5f, 0.5f)
                    horizontalLineToRelative(0.5f)
                    verticalLineToRelative(0.5f)
                    curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f)
                    reflectiveCurveToRelative(0.5f, -0.22f, 0.5f, -0.5f)
                    verticalLineToRelative(-0.5f)
                    horizontalLineToRelative(0.5f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.43f, 6.57f)
                    curveToRelative(-0.75f, -0.75f, -1.96f, -0.75f, -2.71f, 0f)
                    lineTo(2.56f, 14.73f)
                    curveToRelative(-0.75f, 0.75f, -0.75f, 1.96f, 0f, 2.71f)
                    curveToRelative(0.75f, 0.75f, 1.96f, 0.75f, 2.71f, 0f)
                    lineToRelative(8.17f, -8.17f)
                    curveToRelative(0.75f, -0.75f, 0.75f, -1.96f, 0f, -2.71f)
                    close()
                    moveTo(4.56f, 16.73f)
                    curveToRelative(-0.36f, 0.36f, -0.94f, 0.36f, -1.29f, 0f)
                    curveToRelative(-0.36f, -0.36f, -0.36f, -0.94f, 0f, -1.29f)
                    lineToRelative(6.98f, -6.98f)
                    lineToRelative(1.29f, 1.29f)
                    lineToRelative(-6.98f, 6.98f)
                    close()
                    moveTo(12.73f, 8.57f)
                    lineToRelative(-0.48f, 0.48f)
                    lineToRelative(-1.29f, -1.29f)
                    lineToRelative(0.48f, -0.48f)
                    curveToRelative(0.36f, -0.36f, 0.94f, -0.36f, 1.29f, 0f)
                    curveToRelative(0.36f, 0.36f, 0.36f, 0.94f, 0f, 1.29f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.wand(
    color: Color,
    layered: Boolean = false
) = wand(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)