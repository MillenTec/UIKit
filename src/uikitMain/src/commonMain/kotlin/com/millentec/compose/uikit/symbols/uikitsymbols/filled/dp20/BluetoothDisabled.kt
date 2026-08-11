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

fun UIKitFilledSymbols.bluetoothDisabled(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "BluetoothDisabled",
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
                name = "BluetoothDisabled",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(1)) {
                    moveTo(14.22f, 7.33f)
                    lineToRelative(-2.63f, 2.14f)
                    lineToRelative(-1.07f, -1.07f)
                    lineToRelative(2.11f, -1.71f)
                    lineToRelative(-2.13f, -2.13f)
                    verticalLineToRelative(3.82f)
                    lineToRelative(-1.5f, -1.5f)
                    verticalLineTo(2.75f)
                    curveToRelative(0f, -0.3f, 0.18f, -0.58f, 0.46f, -0.69f)
                    curveToRelative(0.28f, -0.12f, 0.6f, -0.05f, 0.82f, 0.16f)
                    lineToRelative(4f, 4f)
                    curveToRelative(0.15f, 0.15f, 0.23f, 0.36f, 0.22f, 0.57f)
                    curveToRelative(-0.01f, 0.21f, -0.11f, 0.41f, -0.28f, 0.54f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(17.85f, 17.15f)
                    lineTo(2.85f, 2.15f)
                    curveToRelative(-0.19f, -0.2f, -0.51f, -0.2f, -0.7f, 0f)
                    curveToRelative(-0.2f, 0.19f, -0.2f, 0.51f, 0f, 0.7f)
                    lineToRelative(6.16f, 6.17f)
                    lineToRelative(0.65f, 0.65f)
                    lineToRelative(3.49f, 3.49f)
                    lineToRelative(0.17f, 0.16f)
                    lineToRelative(1.58f, 1.58f)
                    lineToRelative(2.95f, 2.95f)
                    curveToRelative(0.19f, 0.2f, 0.51f, 0.2f, 0.7f, 0f)
                    curveToRelative(0.2f, -0.19f, 0.2f, -0.51f, 0f, -0.7f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(13.68f, 14.38f)
                    lineToRelative(-3.4f, 3.4f)
                    curveToRelative(-0.21f, 0.21f, -0.54f, 0.28f, -0.82f, 0.16f)
                    curveToRelative(-0.28f, -0.11f, -0.46f, -0.39f, -0.46f, -0.69f)
                    verticalLineToRelative(-5.67f)
                    lineToRelative(-2.78f, 2.25f)
                    curveToRelative(-0.32f, 0.26f, -0.79f, 0.21f, -1.05f, -0.11f)
                    curveToRelative(-0.26f, -0.32f, -0.21f, -0.79f, 0.11f, -1.05f)
                    lineToRelative(3.68f, -3f)
                    lineToRelative(3.49f, 3.49f)
                    lineToRelative(-1.95f, -1.58f)
                    verticalLineToRelative(3.86f)
                    lineToRelative(2.12f, -2.12f)
                    lineToRelative(1.06f, 1.06f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.bluetoothDisabled(
    color: Color,
    layered: Boolean = false
) = bluetoothDisabled(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color)
    )
)