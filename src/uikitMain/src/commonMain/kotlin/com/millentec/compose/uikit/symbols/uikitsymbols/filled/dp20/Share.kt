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

fun UIKitFilledSymbols.share(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Share",
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
                name = "Share",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(9.5f, 3f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    horizontalLineToRelative(-3.5f)
                    curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
                    verticalLineToRelative(8f)
                    curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
                    horizontalLineToRelative(8f)
                    curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                    verticalLineToRelative(-1.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(1.5f)
                    curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f)
                    horizontalLineTo(6f)
                    curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f)
                    verticalLineToRelative(-8f)
                    curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f)
                    horizontalLineToRelative(3.5f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(13.3f, 2.04f)
                    curveToRelative(0.18f, -0.08f, 0.39f, -0.05f, 0.54f, 0.08f)
                    lineToRelative(5f, 4.5f)
                    curveToRelative(0.11f, 0.09f, 0.16f, 0.23f, 0.17f, 0.37f)
                    curveToRelative(0f, 0.14f, -0.06f, 0.28f, -0.17f, 0.37f)
                    lineToRelative(-5f, 4.5f)
                    curveToRelative(-0.15f, 0.13f, -0.36f, 0.17f, -0.54f, 0.09f)
                    curveToRelative(-0.18f, -0.08f, -0.3f, -0.26f, -0.3f, -0.46f)
                    verticalLineToRelative(-2.16f)
                    curveToRelative(-1.4f, 0.13f, -2.67f, 0.78f, -3.7f, 1.61f)
                    curveToRelative(-1.01f, 0.81f, -1.77f, 1.77f, -2.19f, 2.48f)
                    lineToRelative(-0.16f, 0.29f)
                    curveToRelative(-0.1f, 0.21f, -0.34f, 0.32f, -0.56f, 0.26f)
                    curveToRelative(-0.23f, -0.05f, -0.38f, -0.25f, -0.38f, -0.49f)
                    curveToRelative(0f, -2.05f, 0.38f, -4.28f, 1.52f, -6.02f)
                    curveToRelative(1.09f, -1.67f, 2.85f, -2.83f, 5.48f, -2.96f)
                    verticalLineToRelative(-2.09f)
                    curveToRelative(0.03f, -0.17f, 0.14f, -0.31f, 0.3f, -0.38f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.share(
    color: Color,
    layered: Boolean = false
) = share(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)