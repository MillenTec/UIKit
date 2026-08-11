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

fun UIKitFilledSymbols.globe(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Globe",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.3f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Globe",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14f, 10f)
                    curveToRelative(0f, -0.87f, -0.05f, -1.71f, -0.15f, -2.5f)
                    horizontalLineToRelative(3.75f)
                    curveToRelative(-0.11f, -0.35f, -0.25f, -0.68f, -0.4f, -1f)
                    horizontalLineToRelative(-3.5f)
                    curveToRelative(-0.18f, -1.01f, -0.44f, -1.92f, -0.76f, -2.7f)
                    curveToRelative(-0.24f, -0.58f, -0.52f, -1.09f, -0.83f, -1.52f)
                    curveToRelative(-0.67f, -0.18f, -1.38f, -0.28f, -2.11f, -0.28f)
                    curveToRelative(0.31f, 0f, 0.65f, 0.15f, 1f, 0.52f)
                    curveToRelative(0.36f, 0.37f, 0.71f, 0.93f, 1.01f, 1.66f)
                    curveToRelative(0.28f, 0.66f, 0.5f, 1.45f, 0.67f, 2.32f)
                    horizontalLineToRelative(-5.36f)
                    curveToRelative(0.17f, -0.87f, 0.39f, -1.66f, 0.67f, -2.32f)
                    curveToRelative(0.3f, -0.73f, 0.65f, -1.29f, 1.01f, -1.66f)
                    curveToRelative(0.35f, -0.37f, 0.69f, -0.52f, 1f, -0.52f)
                    curveToRelative(-0.73f, 0f, -1.44f, 0.1f, -2.11f, 0.28f)
                    curveToRelative(-0.31f, 0.43f, -0.59f, 0.94f, -0.83f, 1.52f)
                    curveToRelative(-0.32f, 0.78f, -0.58f, 1.69f, -0.76f, 2.7f)
                    horizontalLineToRelative(-3.5f)
                    curveToRelative(-0.15f, 0.32f, -0.29f, 0.65f, -0.4f, 1f)
                    horizontalLineToRelative(3.75f)
                    curveToRelative(-0.1f, 0.79f, -0.15f, 1.63f, -0.15f, 2.5f)
                    reflectiveCurveToRelative(0.05f, 1.71f, 0.15f, 2.5f)
                    horizontalLineToRelative(-3.75f)
                    curveToRelative(0.11f, 0.35f, 0.25f, 0.68f, 0.4f, 1f)
                    horizontalLineToRelative(3.5f)
                    curveToRelative(0.18f, 1.01f, 0.44f, 1.92f, 0.76f, 2.7f)
                    curveToRelative(0.24f, 0.58f, 0.52f, 1.09f, 0.83f, 1.52f)
                    curveToRelative(0.67f, 0.18f, 1.38f, 0.28f, 2.11f, 0.28f)
                    curveToRelative(-0.31f, 0f, -0.65f, -0.15f, -1f, -0.52f)
                    curveToRelative(-0.36f, -0.37f, -0.71f, -0.93f, -1.01f, -1.66f)
                    curveToRelative(-0.28f, -0.66f, -0.5f, -1.45f, -0.67f, -2.32f)
                    horizontalLineToRelative(5.36f)
                    curveToRelative(-0.17f, 0.87f, -0.39f, 1.66f, -0.67f, 2.32f)
                    curveToRelative(-0.3f, 0.73f, -0.65f, 1.29f, -1.01f, 1.66f)
                    curveToRelative(-0.35f, 0.37f, -0.69f, 0.52f, -1f, 0.52f)
                    curveToRelative(0.73f, 0f, 1.44f, -0.1f, 2.11f, -0.28f)
                    curveToRelative(0.31f, -0.43f, 0.59f, -0.94f, 0.83f, -1.52f)
                    curveToRelative(0.32f, -0.78f, 0.58f, -1.69f, 0.76f, -2.7f)
                    horizontalLineToRelative(3.5f)
                    curveToRelative(0.15f, -0.32f, 0.29f, -0.65f, 0.4f, -1f)
                    horizontalLineToRelative(-3.75f)
                    curveToRelative(0.1f, -0.79f, 0.15f, -1.63f, 0.15f, -2.5f)
                    close()
                    moveTo(12.84f, 12.5f)
                    horizontalLineToRelative(-5.68f)
                    curveToRelative(-0.1f, -0.79f, -0.16f, -1.63f, -0.16f, -2.5f)
                    reflectiveCurveToRelative(0.06f, -1.71f, 0.16f, -2.5f)
                    horizontalLineToRelative(5.68f)
                    curveToRelative(0.1f, 0.79f, 0.16f, 1.63f, 0.16f, 2.5f)
                    reflectiveCurveToRelative(-0.06f, 1.71f, -0.16f, 2.5f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(12.84f, 7.5f)
                    horizontalLineToRelative(-5.68f)
                    curveToRelative(-0.1f, 0.79f, -0.16f, 1.63f, -0.16f, 2.5f)
                    reflectiveCurveToRelative(0.06f, 1.71f, 0.16f, 2.5f)
                    horizontalLineToRelative(5.68f)
                    curveToRelative(0.1f, -0.79f, 0.16f, -1.63f, 0.16f, -2.5f)
                    reflectiveCurveToRelative(-0.06f, -1.71f, -0.16f, -2.5f)
                    close()
                    moveTo(6.15f, 7.5f)
                    horizontalLineToRelative(-3.75f)
                    reflectiveCurveToRelative(-0.03f, 0.08f, -0.04f, 0.12f)
                    curveToRelative(-0.05f, 0.16f, -0.09f, 0.32f, -0.13f, 0.48f)
                    curveToRelative(-0.05f, 0.2f, -0.09f, 0.39f, -0.12f, 0.59f)
                    curveToRelative(-0.01f, 0.03f, -0.01f, 0.06f, -0.02f, 0.09f)
                    curveToRelative(-0.03f, 0.19f, -0.05f, 0.38f, -0.06f, 0.57f)
                    curveToRelative(-0.02f, 0.22f, -0.03f, 0.43f, -0.03f, 0.65f)
                    reflectiveCurveToRelative(0.01f, 0.43f, 0.03f, 0.65f)
                    curveToRelative(0f, 0.19f, 0.03f, 0.38f, 0.06f, 0.57f)
                    curveToRelative(0f, 0.03f, 0f, 0.06f, 0.02f, 0.09f)
                    curveToRelative(0.03f, 0.2f, 0.07f, 0.39f, 0.12f, 0.59f)
                    curveToRelative(0.04f, 0.16f, 0.08f, 0.32f, 0.13f, 0.48f)
                    curveToRelative(0.01f, 0.04f, 0.03f, 0.08f, 0.04f, 0.12f)
                    horizontalLineToRelative(3.75f)
                    curveToRelative(-0.1f, -0.79f, -0.15f, -1.63f, -0.15f, -2.5f)
                    reflectiveCurveToRelative(0.05f, -1.71f, 0.15f, -2.5f)
                    close()
                    moveTo(7.06f, 16.2f)
                    curveToRelative(-0.32f, -0.78f, -0.58f, -1.69f, -0.76f, -2.7f)
                    horizontalLineToRelative(-3.5f)
                    curveToRelative(0.04f, 0.08f, 0.08f, 0.16f, 0.13f, 0.24f)
                    curveToRelative(0.07f, 0.14f, 0.14f, 0.28f, 0.23f, 0.41f)
                    curveToRelative(0.06f, 0.1f, 0.13f, 0.2f, 0.2f, 0.3f)
                    curveToRelative(0.08f, 0.13f, 0.17f, 0.27f, 0.27f, 0.39f)
                    curveToRelative(0.06f, 0.08f, 0.12f, 0.16f, 0.19f, 0.23f)
                    curveToRelative(0.4f, 0.5f, 0.87f, 0.95f, 1.39f, 1.34f)
                    curveToRelative(0.19f, 0.14f, 0.38f, 0.27f, 0.58f, 0.39f)
                    curveToRelative(0.35f, 0.22f, 0.72f, 0.42f, 1.11f, 0.58f)
                    curveToRelative(0.24f, 0.1f, 0.48f, 0.18f, 0.72f, 0.26f)
                    curveToRelative(0.09f, 0.03f, 0.18f, 0.06f, 0.27f, 0.08f)
                    curveToRelative(-0.31f, -0.43f, -0.59f, -0.94f, -0.83f, -1.52f)
                    close()
                    moveTo(7.32f, 13.5f)
                    curveToRelative(0.17f, 0.87f, 0.39f, 1.66f, 0.67f, 2.32f)
                    curveToRelative(0.3f, 0.73f, 0.65f, 1.29f, 1.01f, 1.66f)
                    curveToRelative(0.35f, 0.37f, 0.69f, 0.52f, 1f, 0.52f)
                    reflectiveCurveToRelative(0.65f, -0.15f, 1f, -0.52f)
                    curveToRelative(0.36f, -0.37f, 0.71f, -0.93f, 1.01f, -1.66f)
                    curveToRelative(0.28f, -0.66f, 0.5f, -1.45f, 0.67f, -2.32f)
                    horizontalLineToRelative(-5.36f)
                    close()
                    moveTo(13.7f, 13.5f)
                    curveToRelative(-0.18f, 1.01f, -0.44f, 1.92f, -0.76f, 2.7f)
                    curveToRelative(-0.24f, 0.58f, -0.52f, 1.09f, -0.83f, 1.52f)
                    curveToRelative(0.09f, -0.02f, 0.18f, -0.05f, 0.27f, -0.08f)
                    curveToRelative(0.24f, -0.08f, 0.48f, -0.16f, 0.72f, -0.26f)
                    curveToRelative(0.39f, -0.16f, 0.76f, -0.36f, 1.11f, -0.58f)
                    curveToRelative(0.2f, -0.12f, 0.39f, -0.25f, 0.58f, -0.39f)
                    curveToRelative(0.52f, -0.39f, 0.99f, -0.84f, 1.39f, -1.34f)
                    curveToRelative(0.07f, -0.07f, 0.13f, -0.15f, 0.19f, -0.23f)
                    curveToRelative(0.1f, -0.12f, 0.19f, -0.26f, 0.28f, -0.39f)
                    curveToRelative(0.06f, -0.1f, 0.13f, -0.2f, 0.19f, -0.3f)
                    curveToRelative(0.09f, -0.13f, 0.16f, -0.27f, 0.23f, -0.41f)
                    curveToRelative(0.05f, -0.08f, 0.09f, -0.16f, 0.13f, -0.24f)
                    horizontalLineToRelative(-3.5f)
                    close()
                    moveTo(17.97f, 9.35f)
                    curveToRelative(0f, -0.19f, -0.03f, -0.38f, -0.06f, -0.57f)
                    curveToRelative(0f, -0.03f, 0f, -0.06f, -0.02f, -0.09f)
                    curveToRelative(-0.03f, -0.2f, -0.07f, -0.39f, -0.12f, -0.59f)
                    curveToRelative(-0.04f, -0.16f, -0.08f, -0.32f, -0.13f, -0.48f)
                    curveToRelative(-0.01f, -0.04f, -0.03f, -0.08f, -0.04f, -0.12f)
                    horizontalLineToRelative(-3.75f)
                    curveToRelative(0.1f, 0.79f, 0.15f, 1.63f, 0.15f, 2.5f)
                    reflectiveCurveToRelative(-0.05f, 1.71f, -0.15f, 2.5f)
                    horizontalLineToRelative(3.75f)
                    reflectiveCurveToRelative(0.03f, -0.08f, 0.04f, -0.12f)
                    curveToRelative(0.05f, -0.16f, 0.09f, -0.32f, 0.13f, -0.48f)
                    curveToRelative(0.05f, -0.2f, 0.09f, -0.39f, 0.12f, -0.59f)
                    curveToRelative(0.01f, -0.03f, 0.01f, -0.06f, 0.02f, -0.09f)
                    curveToRelative(0.03f, -0.19f, 0.05f, -0.38f, 0.06f, -0.57f)
                    curveToRelative(0.02f, -0.22f, 0.03f, -0.43f, 0.03f, -0.65f)
                    reflectiveCurveToRelative(-0.01f, -0.43f, -0.03f, -0.65f)
                    close()
                    moveTo(17.07f, 6.26f)
                    curveToRelative(-0.07f, -0.14f, -0.14f, -0.28f, -0.23f, -0.41f)
                    curveToRelative(-0.06f, -0.1f, -0.13f, -0.2f, -0.19f, -0.3f)
                    curveToRelative(-0.09f, -0.13f, -0.18f, -0.27f, -0.28f, -0.39f)
                    curveToRelative(-0.06f, -0.08f, -0.12f, -0.16f, -0.19f, -0.23f)
                    curveToRelative(-0.48f, -0.6f, -1.06f, -1.13f, -1.71f, -1.56f)
                    curveToRelative(-0.08f, -0.06f, -0.17f, -0.12f, -0.26f, -0.17f)
                    curveToRelative(-0.35f, -0.22f, -0.72f, -0.42f, -1.11f, -0.58f)
                    curveToRelative(-0.24f, -0.1f, -0.48f, -0.18f, -0.72f, -0.26f)
                    curveToRelative(-0.09f, -0.03f, -0.18f, -0.06f, -0.27f, -0.08f)
                    curveToRelative(0.31f, 0.43f, 0.59f, 0.94f, 0.83f, 1.52f)
                    curveToRelative(0.32f, 0.78f, 0.58f, 1.69f, 0.76f, 2.7f)
                    horizontalLineToRelative(3.5f)
                    curveToRelative(-0.04f, -0.08f, -0.08f, -0.16f, -0.13f, -0.24f)
                    close()
                    moveTo(7.62f, 2.36f)
                    curveToRelative(-0.24f, 0.08f, -0.48f, 0.16f, -0.72f, 0.26f)
                    curveToRelative(-0.39f, 0.16f, -0.76f, 0.36f, -1.11f, 0.58f)
                    curveToRelative(-0.09f, 0.05f, -0.18f, 0.11f, -0.26f, 0.17f)
                    curveToRelative(-0.65f, 0.43f, -1.23f, 0.96f, -1.71f, 1.56f)
                    curveToRelative(-0.07f, 0.07f, -0.13f, 0.15f, -0.19f, 0.23f)
                    curveToRelative(-0.1f, 0.12f, -0.19f, 0.26f, -0.27f, 0.39f)
                    curveToRelative(-0.07f, 0.1f, -0.14f, 0.2f, -0.2f, 0.3f)
                    curveToRelative(-0.09f, 0.13f, -0.16f, 0.27f, -0.23f, 0.41f)
                    curveToRelative(-0.05f, 0.08f, -0.09f, 0.16f, -0.13f, 0.24f)
                    horizontalLineToRelative(3.5f)
                    curveToRelative(0.18f, -1.01f, 0.44f, -1.92f, 0.76f, -2.7f)
                    curveToRelative(0.24f, -0.58f, 0.52f, -1.09f, 0.83f, -1.52f)
                    curveToRelative(-0.09f, 0.02f, -0.18f, 0.05f, -0.27f, 0.08f)
                    close()
                    moveTo(12.01f, 4.18f)
                    curveToRelative(-0.3f, -0.73f, -0.65f, -1.29f, -1.01f, -1.66f)
                    curveToRelative(-0.35f, -0.37f, -0.69f, -0.52f, -1f, -0.52f)
                    reflectiveCurveToRelative(-0.65f, 0.15f, -1f, 0.52f)
                    curveToRelative(-0.36f, 0.37f, -0.71f, 0.93f, -1.01f, 1.66f)
                    curveToRelative(-0.28f, 0.66f, -0.5f, 1.45f, -0.67f, 2.32f)
                    horizontalLineToRelative(5.36f)
                    curveToRelative(-0.17f, -0.87f, -0.39f, -1.66f, -0.67f, -2.32f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.globe(
    color: Color,
    layered: Boolean = false
) = globe(
    listOf(
        if (layered) SolidColor(color) else SolidColor(color.copy(0f)),
        if (layered) SolidColor(color.copy(0.3f)) else SolidColor(color)
    )
)