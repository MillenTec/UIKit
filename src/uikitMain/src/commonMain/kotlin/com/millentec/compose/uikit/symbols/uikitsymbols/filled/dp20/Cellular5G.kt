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

fun UIKitFilledSymbols.cellular5G(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Cellular5G",
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
                name = "Cellular5G",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(4.75f, 13f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 2.5f, 0f, 2.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -2.5f, 0f, -2.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                    moveTo(7.75f, 11f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 4.5f, 0f, 4.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -4.5f, 0f, -4.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                    moveTo(10.75f, 9f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 6.5f, 0f, 6.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -6.5f, 0f, -6.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                    moveTo(13.75f, 7f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.28f, 0.74f, 0.64f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 8.5f, 0f, 8.5f)
                    curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f)
                    curveToRelative(-0.38f, 0f, -0.69f, -0.28f, -0.74f, -0.64f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -8.5f, 0f, -8.5f)
                    curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f)
                    close()
                    moveTo(16.75f, 5f)
                    curveToRelative(0.37f, 0f, 0.68f, 0.27f, 0.74f, 0.63f)
                    verticalLineToRelative(0.11f)
                    reflectiveCurveToRelative(0f, 10.52f, 0f, 10.52f)
                    curveToRelative(0f, 0.41f, -0.33f, 0.75f, -0.74f, 0.75f)
                    curveToRelative(-0.37f, 0f, -0.68f, -0.27f, -0.74f, -0.63f)
                    verticalLineToRelative(-0.11f)
                    reflectiveCurveToRelative(0f, -10.52f, 0f, -10.52f)
                    curveToRelative(0f, -0.41f, 0.33f, -0.75f, 0.74f, -0.75f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(9.5f, 3f)
                    horizontalLineToRelative(-0.25f)
                    curveToRelative(-0.69f, 0f, -1.25f, 0.56f, -1.25f, 1.25f)
                    verticalLineToRelative(1.5f)
                    curveToRelative(0f, 0.69f, 0.56f, 1.25f, 1.25f, 1.25f)
                    reflectiveCurveToRelative(1.25f, -0.56f, 1.25f, -1.25f)
                    horizontalLineToRelative(-1f)
                    curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                    reflectiveCurveToRelative(0.22f, -0.5f, 0.5f, -0.5f)
                    horizontalLineToRelative(1.5f)
                    curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(0.5f)
                    curveToRelative(0f, 1.24f, -1.01f, 2.25f, -2.25f, 2.25f)
                    reflectiveCurveToRelative(-2.25f, -1.01f, -2.25f, -2.25f)
                    verticalLineToRelative(-1.5f)
                    curveToRelative(0f, -1.24f, 1.01f, -2.25f, 2.25f, -2.25f)
                    horizontalLineToRelative(0.25f)
                    reflectiveCurveToRelative(1.12f, 0f, 1.65f, 1.02f)
                    curveToRelative(0.13f, 0.24f, 0.03f, 0.55f, -0.21f, 0.67f)
                    curveToRelative(-0.24f, 0.13f, -0.55f, 0.03f, -0.67f, -0.21f)
                    curveToRelative(-0.12f, -0.24f, -0.31f, -0.36f, -0.48f, -0.42f)
                    curveToRelative(-0.15f, -0.06f, -0.28f, -0.06f, -0.29f, -0.06f)
                    close()
                    moveTo(2.75f, 2f)
                    curveToRelative(-0.25f, 0f, -0.46f, 0.19f, -0.5f, 0.44f)
                    lineToRelative(-0.25f, 2f)
                    curveToRelative(-0.02f, 0.15f, 0.03f, 0.3f, 0.14f, 0.41f)
                    reflectiveCurveToRelative(0.25f, 0.16f, 0.4f, 0.15f)
                    horizontalLineToRelative(0.17f)
                    reflectiveCurveToRelative(1.37f, -0.13f, 1.37f, -0.13f)
                    curveToRelative(0.49f, -0.04f, 0.91f, 0.35f, 0.91f, 0.84f)
                    verticalLineToRelative(0.22f)
                    curveToRelative(0f, 0.59f, -0.48f, 1.07f, -1.07f, 1.07f)
                    curveToRelative(-0.36f, 0f, -0.6f, -0.16f, -0.75f, -0.32f)
                    curveToRelative(-0.08f, -0.08f, -0.13f, -0.17f, -0.17f, -0.23f)
                    curveToRelative(-0.02f, -0.03f, -0.03f, -0.06f, -0.04f, -0.07f)
                    curveToRelative(0f, 0f, 0f, -0.01f, 0f, -0.01f)
                    curveToRelative(-0.1f, -0.26f, -0.39f, -0.38f, -0.64f, -0.29f)
                    curveToRelative(-0.26f, 0.1f, -0.39f, 0.39f, -0.29f, 0.64f)
                    horizontalLineToRelative(0f)
                    reflectiveCurveToRelative(0f, 0f, 0f, 0f)
                    horizontalLineToRelative(0f)
                    reflectiveCurveToRelative(0f, 0f, 0f, 0f)
                    verticalLineToRelative(0.02f)
                    reflectiveCurveToRelative(0.02f, 0.03f, 0.03f, 0.05f)
                    curveToRelative(0.02f, 0.04f, 0.04f, 0.09f, 0.07f, 0.15f)
                    curveToRelative(0.07f, 0.12f, 0.17f, 0.27f, 0.31f, 0.43f)
                    curveToRelative(0.29f, 0.32f, 0.78f, 0.64f, 1.48f, 0.64f)
                    curveToRelative(1.14f, 0f, 2.07f, -0.93f, 2.07f, -2.07f)
                    verticalLineToRelative(-0.22f)
                    curveToRelative(0f, -1.08f, -0.92f, -1.93f, -2f, -1.84f)
                    lineToRelative(-0.93f, 0.08f)
                    lineToRelative(0.12f, -0.95f)
                    horizontalLineToRelative(2.31f)
                    curveToRelative(0.28f, 0f, 0.5f, -0.22f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(-0.22f, -0.5f, -0.5f, -0.5f)
                    horizontalLineToRelative(-2.75f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.cellular5G(
    color: Color,
    layered: Boolean = false
) = cellular5G(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)