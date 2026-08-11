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

fun UIKitRegularSymbols.gameControllerError(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "GameControllerError",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes,
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            ), UIKitSymbolLayerInfo(
                description = "Secondary",
                expectAlpha = 0.75f
            ), UIKitSymbolLayerInfo(
                description = "Tertiary",
                expectAlpha = 0.6f
            )
        )
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "GameControllerError",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(8.33f, 3.71f)
                    curveToRelative(-0.43f, -0.22f, -0.91f, -0.25f, -1.35f, -0.17f)
                    lineToRelative(-0.89f, 0.17f)
                    curveToRelative(-0.72f, 0.14f, -1.33f, 0.59f, -1.67f, 1.24f)
                    curveToRelative(-1.11f, 2.16f, -1.94f, 3.93f, -2.27f, 5.44f)
                    curveToRelative(-0.34f, 1.54f, -0.15f, 2.86f, 0.82f, 4.06f)
                    curveToRelative(0.65f, 0.81f, 1.8f, 0.65f, 2.4f, -0.03f)
                    curveToRelative(0.47f, -0.53f, 1f, -1.14f, 1.51f, -1.73f)
                    curveToRelative(0.38f, -0.44f, 0.94f, -0.7f, 1.52f, -0.7f)
                    horizontalLineToRelative(0.8f)
                    curveToRelative(0.1f, -0.35f, 0.23f, -0.68f, 0.39f, -1f)
                    horizontalLineToRelative(-1.2f)
                    curveToRelative(-0.87f, 0f, -1.7f, 0.38f, -2.28f, 1.04f)
                    curveToRelative(-0.51f, 0.59f, -1.04f, 1.2f, -1.51f, 1.72f)
                    curveToRelative(-0.28f, 0.32f, -0.69f, 0.29f, -0.87f, 0.06f)
                    curveToRelative(-0.74f, -0.91f, -0.91f, -1.9f, -0.62f, -3.22f)
                    curveToRelative(0.29f, -1.36f, 1.06f, -3.01f, 2.18f, -5.19f)
                    curveToRelative(0.19f, -0.37f, 0.55f, -0.64f, 0.96f, -0.72f)
                    lineToRelative(0.89f, -0.17f)
                    curveToRelative(0.26f, -0.05f, 0.51f, -0.02f, 0.72f, 0.08f)
                    lineToRelative(0.05f, 0.03f)
                    curveToRelative(0.44f, 0.23f, 0.94f, 0.37f, 1.47f, 0.37f)
                    horizontalLineToRelative(1.18f)
                    curveToRelative(0.52f, 0f, 1.02f, -0.14f, 1.47f, -0.37f)
                    lineToRelative(0.05f, -0.03f)
                    curveToRelative(0.2f, -0.1f, 0.45f, -0.13f, 0.72f, -0.08f)
                    lineToRelative(0.89f, 0.17f)
                    curveToRelative(0.41f, 0.08f, 0.77f, 0.34f, 0.96f, 0.72f)
                    curveToRelative(0.54f, 1.05f, 0.99f, 1.98f, 1.36f, 2.81f)
                    curveToRelative(0.47f, 0.14f, 0.91f, 0.33f, 1.32f, 0.58f)
                    curveToRelative(-0.43f, -1.13f, -1.04f, -2.4f, -1.78f, -3.84f)
                    curveToRelative(-0.33f, -0.65f, -0.95f, -1.11f, -1.67f, -1.24f)
                    lineToRelative(-0.89f, -0.17f)
                    curveToRelative(-0.44f, -0.08f, -0.92f, -0.05f, -1.35f, 0.17f)
                    lineToRelative(-0.06f, 0.03f)
                    curveToRelative(-0.33f, 0.17f, -0.67f, 0.26f, -1.01f, 0.26f)
                    horizontalLineToRelative(-1.18f)
                    curveToRelative(-0.34f, 0f, -0.69f, -0.09f, -1.01f, -0.26f)
                    lineToRelative(-0.06f, -0.03f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(10f, 6.75f)
                    moveToRelative(-0.75f, 0f)
                    arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, 1.5f, 0f)
                    arcToRelative(0.75f, 0.75f, 0f, isMoreThanHalf = true, isPositiveArc = true, -1.5f, 0f)
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(14.5f, 9f)
                    curveToRelative(-2.49f, 0f, -4.5f, 2.01f, -4.5f, 4.5f)
                    reflectiveCurveToRelative(2.01f, 4.5f, 4.5f, 4.5f)
                    reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f)
                    reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f)
                    close()
                    moveTo(14f, 11.5f)
                    curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                    reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f)
                    verticalLineToRelative(2f)
                    curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f)
                    reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f)
                    verticalLineToRelative(-2f)
                    close()
                    moveTo(14.5f, 16.12f)
                    curveToRelative(-0.35f, 0f, -0.62f, -0.28f, -0.62f, -0.62f)
                    reflectiveCurveToRelative(0.28f, -0.62f, 0.62f, -0.62f)
                    reflectiveCurveToRelative(0.62f, 0.28f, 0.62f, 0.62f)
                    reflectiveCurveToRelative(-0.28f, 0.62f, -0.62f, 0.62f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.gameControllerError(
    color: Color,
    layered: Boolean = false
) = gameControllerError(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)