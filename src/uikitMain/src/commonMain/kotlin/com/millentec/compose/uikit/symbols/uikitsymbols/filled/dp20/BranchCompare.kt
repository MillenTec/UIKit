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

fun UIKitFilledSymbols.branchCompare(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "BranchCompare",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "BranchCompare",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(11.146f, 6.854f)
                    curveTo(11.342f, 7.049f, 11.658f, 7.049f, 11.854f, 6.854f)
                    curveTo(12.049f, 6.658f, 12.049f, 6.342f, 11.854f, 6.146f)
                    lineTo(10.707f, 5f)
                    horizontalLineTo(12.5f)
                    curveTo(13.881f, 5f, 15f, 6.119f, 15f, 7.5f)
                    verticalLineTo(12f)
                    curveTo(13.343f, 12f, 12f, 13.343f, 12f, 15f)
                    curveTo(12f, 16.657f, 13.343f, 18f, 15f, 18f)
                    curveTo(16.657f, 18f, 18f, 16.657f, 18f, 15f)
                    curveTo(18f, 13.694f, 17.165f, 12.583f, 16f, 12.171f)
                    verticalLineTo(7.5f)
                    curveTo(16f, 5.567f, 14.433f, 4f, 12.5f, 4f)
                    horizontalLineTo(10.707f)
                    lineTo(11.854f, 2.854f)
                    curveTo(12.049f, 2.658f, 12.049f, 2.342f, 11.854f, 2.146f)
                    curveTo(11.658f, 1.951f, 11.342f, 1.951f, 11.146f, 2.146f)
                    lineTo(9.146f, 4.146f)
                    curveTo(8.951f, 4.342f, 8.951f, 4.658f, 9.146f, 4.854f)
                    lineTo(11.146f, 6.854f)
                    close()
                    moveTo(5f, 8f)
                    curveTo(6.657f, 8f, 8f, 6.657f, 8f, 5f)
                    curveTo(8f, 3.343f, 6.657f, 2f, 5f, 2f)
                    curveTo(3.343f, 2f, 2f, 3.343f, 2f, 5f)
                    curveTo(2f, 6.306f, 2.835f, 7.417f, 4f, 7.829f)
                    verticalLineTo(12.5f)
                    curveTo(4f, 14.433f, 5.567f, 16f, 7.5f, 16f)
                    horizontalLineTo(9.293f)
                    lineTo(8.146f, 17.146f)
                    curveTo(7.951f, 17.342f, 7.951f, 17.658f, 8.146f, 17.854f)
                    curveTo(8.342f, 18.049f, 8.658f, 18.049f, 8.854f, 17.854f)
                    lineTo(10.854f, 15.854f)
                    curveTo(10.901f, 15.806f, 10.938f, 15.75f, 10.962f, 15.691f)
                    curveTo(10.986f, 15.633f, 11f, 15.57f, 11f, 15.503f)
                    lineTo(11f, 15.5f)
                    lineTo(11f, 15.497f)
                    curveTo(11f, 15.43f, 10.986f, 15.367f, 10.962f, 15.309f)
                    curveTo(10.938f, 15.25f, 10.901f, 15.194f, 10.854f, 15.146f)
                    lineTo(8.854f, 13.146f)
                    curveTo(8.658f, 12.951f, 8.342f, 12.951f, 8.146f, 13.146f)
                    curveTo(7.951f, 13.342f, 7.951f, 13.658f, 8.146f, 13.854f)
                    lineTo(9.293f, 15f)
                    horizontalLineTo(7.5f)
                    curveTo(6.119f, 15f, 5f, 13.881f, 5f, 12.5f)
                    verticalLineTo(8f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.branchCompare(
    color: Color
) = branchCompare(
    SolidColor(color)
)