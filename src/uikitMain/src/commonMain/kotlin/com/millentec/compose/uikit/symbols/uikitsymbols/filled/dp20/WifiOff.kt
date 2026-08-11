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

fun UIKitFilledSymbols.wifiOff(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "WifiOff",
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
                name = "WifiOff",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.78f, 17.78f)
                    curveToRelative(-0.29f, 0.29f, -0.77f, 0.29f, -1.06f, 0f)
                    lineToRelative(-3.66f, -3.65f)
                    lineToRelative(-1.53f, -1.53f)
                    lineToRelative(-1.95f, -1.95f)
                    lineToRelative(-1.27f, -1.28f)
                    lineToRelative(-3.91f, -3.91f)
                    lineToRelative(-2.18f, -2.18f)
                    curveToRelative(-0.29f, -0.29f, -0.29f, -0.77f, 0f, -1.06f)
                    curveToRelative(0.29f, -0.29f, 0.77f, -0.29f, 1.06f, 0f)
                    lineToRelative(14.5f, 14.5f)
                    curveToRelative(0.29f, 0.29f, 0.29f, 0.77f, 0f, 1.06f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(4.4f, 8.62f)
                    curveToRelative(-0.32f, 0.32f, -0.64f, 0.72f, -0.93f, 1.14f)
                    curveToRelative(-0.24f, 0.34f, -0.71f, 0.42f, -1.05f, 0.18f)
                    curveToRelative(-0.34f, -0.23f, -0.42f, -0.7f, -0.18f, -1.04f)
                    curveToRelative(0.34f, -0.49f, 0.71f, -0.95f, 1.1f, -1.34f)
                    curveToRelative(0.54f, -0.54f, 1.14f, -1.01f, 1.77f, -1.39f)
                    lineToRelative(1.1f, 1.1f)
                    curveToRelative(-0.65f, 0.35f, -1.26f, 0.8f, -1.81f, 1.35f)
                    close()
                    moveTo(8.31f, 9.37f)
                    lineToRelative(-1.14f, -1.14f)
                    curveToRelative(-0.61f, 0.31f, -1.18f, 0.71f, -1.69f, 1.22f)
                    reflectiveCurveToRelative(-0.89f, 1.04f, -1.19f, 1.65f)
                    curveToRelative(-0.19f, 0.36f, -0.04f, 0.82f, 0.33f, 1f)
                    curveToRelative(0.37f, 0.19f, 0.82f, 0.04f, 1.01f, -0.33f)
                    curveToRelative(0.23f, -0.46f, 0.53f, -0.88f, 0.91f, -1.26f)
                    curveToRelative(0.52f, -0.52f, 1.13f, -0.9f, 1.77f, -1.14f)
                    close()
                    moveTo(9.58f, 10.65f)
                    curveToRelative(-0.9f, 0.1f, -1.77f, 0.5f, -2.47f, 1.19f)
                    curveToRelative(-0.36f, 0.36f, -0.65f, 0.8f, -0.86f, 1.27f)
                    curveToRelative(-0.16f, 0.38f, 0.01f, 0.83f, 0.39f, 0.99f)
                    curveToRelative(0.38f, 0.17f, 0.82f, 0f, 0.99f, -0.39f)
                    curveToRelative(0.13f, -0.31f, 0.32f, -0.58f, 0.54f, -0.81f)
                    curveToRelative(0.91f, -0.91f, 2.33f, -1.01f, 3.36f, -0.3f)
                    lineToRelative(-1.95f, -1.95f)
                    close()
                    moveTo(9.69f, 7.57f)
                    curveToRelative(1.76f, -0.09f, 3.55f, 0.53f, 4.9f, 1.88f)
                    curveToRelative(0.47f, 0.47f, 0.88f, 1.04f, 1.19f, 1.65f)
                    curveToRelative(0.19f, 0.37f, 0.04f, 0.82f, -0.33f, 1.01f)
                    curveToRelative(-0.37f, 0.19f, -0.82f, 0.04f, -1.01f, -0.33f)
                    curveToRelative(-0.24f, -0.47f, -0.56f, -0.92f, -0.92f, -1.28f)
                    curveToRelative(-0.62f, -0.62f, -1.37f, -1.04f, -2.16f, -1.27f)
                    lineToRelative(-1.67f, -1.67f)
                    close()
                    moveTo(7.31f, 5.19f)
                    curveToRelative(3.23f, -0.97f, 6.87f, -0.18f, 9.42f, 2.37f)
                    curveToRelative(0.4f, 0.4f, 0.78f, 0.86f, 1.12f, 1.34f)
                    curveToRelative(0.24f, 0.34f, 0.15f, 0.81f, -0.19f, 1.04f)
                    curveToRelative(-0.34f, 0.24f, -0.81f, 0.15f, -1.04f, -0.19f)
                    curveToRelative(-0.28f, -0.41f, -0.6f, -0.8f, -0.94f, -1.14f)
                    curveToRelative(-1.94f, -1.94f, -4.62f, -2.67f, -7.12f, -2.19f)
                    lineToRelative(-1.24f, -1.24f)
                    close()
                    moveTo(9.16f, 15.64f)
                    curveToRelative(-0.49f, -0.49f, -0.49f, -1.27f, 0f, -1.76f)
                    curveToRelative(0.49f, -0.49f, 1.27f, -0.49f, 1.76f, 0f)
                    curveToRelative(0.49f, 0.49f, 0.49f, 1.27f, 0f, 1.76f)
                    curveToRelative(-0.49f, 0.49f, -1.27f, 0.49f, -1.76f, 0f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.wifiOff(
    color: Color,
    layered: Boolean = false
) = wifiOff(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)