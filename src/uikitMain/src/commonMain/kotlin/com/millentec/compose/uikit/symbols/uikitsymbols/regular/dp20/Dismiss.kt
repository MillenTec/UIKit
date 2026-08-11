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

fun UIKitRegularSymbols.dismiss(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Dismiss",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush),
        layers = listOf(
            UIKitSymbolLayerInfo(
                description = "Primary",
                expectAlpha = 1f
            )
        )
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Dismiss",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(4.089f, 4.216f)
                    lineTo(4.146f, 4.146f)
                    curveTo(4.32f, 3.973f, 4.589f, 3.954f, 4.784f, 4.089f)
                    lineTo(4.854f, 4.146f)
                    lineTo(10f, 9.293f)
                    lineTo(15.146f, 4.146f)
                    curveTo(15.32f, 3.973f, 15.589f, 3.954f, 15.784f, 4.089f)
                    lineTo(15.854f, 4.146f)
                    curveTo(16.027f, 4.32f, 16.046f, 4.589f, 15.911f, 4.784f)
                    lineTo(15.854f, 4.854f)
                    lineTo(10.707f, 10f)
                    lineTo(15.854f, 15.146f)
                    curveTo(16.027f, 15.32f, 16.046f, 15.589f, 15.911f, 15.784f)
                    lineTo(15.854f, 15.854f)
                    curveTo(15.68f, 16.027f, 15.411f, 16.046f, 15.216f, 15.911f)
                    lineTo(15.146f, 15.854f)
                    lineTo(10f, 10.707f)
                    lineTo(4.854f, 15.854f)
                    curveTo(4.68f, 16.027f, 4.411f, 16.046f, 4.216f, 15.911f)
                    lineTo(4.146f, 15.854f)
                    curveTo(3.973f, 15.68f, 3.954f, 15.411f, 4.089f, 15.216f)
                    lineTo(4.146f, 15.146f)
                    lineTo(9.293f, 10f)
                    lineTo(4.146f, 4.854f)
                    curveTo(3.973f, 4.68f, 3.954f, 4.411f, 4.089f, 4.216f)
                    lineTo(4.146f, 4.146f)
                    lineTo(4.089f, 4.216f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.dismiss(
    color: Color
) = dismiss(
    SolidColor(color)
)