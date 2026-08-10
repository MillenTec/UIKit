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

fun UIKitRegularSymbols.person(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Person",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Person",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10f, 2f)
                    curveTo(7.791f, 2f, 6f, 3.791f, 6f, 6f)
                    curveTo(6f, 8.209f, 7.791f, 10f, 10f, 10f)
                    curveTo(12.209f, 10f, 14f, 8.209f, 14f, 6f)
                    curveTo(14f, 3.791f, 12.209f, 2f, 10f, 2f)
                    close()
                    moveTo(7f, 6f)
                    curveTo(7f, 4.343f, 8.343f, 3f, 10f, 3f)
                    curveTo(11.657f, 3f, 13f, 4.343f, 13f, 6f)
                    curveTo(13f, 7.657f, 11.657f, 9f, 10f, 9f)
                    curveTo(8.343f, 9f, 7f, 7.657f, 7f, 6f)
                    close()
                    moveTo(5.009f, 11f)
                    curveTo(3.903f, 11f, 3f, 11.887f, 3f, 13f)
                    curveTo(3f, 14.691f, 3.833f, 15.966f, 5.135f, 16.797f)
                    curveTo(6.417f, 17.614f, 8.145f, 18f, 10f, 18f)
                    curveTo(11.855f, 18f, 13.583f, 17.614f, 14.865f, 16.797f)
                    curveTo(16.167f, 15.966f, 17f, 14.691f, 17f, 13f)
                    curveTo(17f, 11.896f, 16.104f, 11f, 15f, 11f)
                    lineTo(5.009f, 11f)
                    close()
                    moveTo(4f, 13f)
                    curveTo(4f, 12.447f, 4.448f, 12f, 5.009f, 12f)
                    lineTo(15f, 12f)
                    curveTo(15.552f, 12f, 16f, 12.448f, 16f, 13f)
                    curveTo(16f, 14.309f, 15.378f, 15.284f, 14.327f, 15.953f)
                    curveTo(13.257f, 16.636f, 11.735f, 17f, 10f, 17f)
                    curveTo(8.265f, 17f, 6.743f, 16.636f, 5.673f, 15.953f)
                    curveTo(4.622f, 15.284f, 4f, 14.309f, 4f, 13f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.person(
    color: Color
) = person(
    SolidColor(color)
)