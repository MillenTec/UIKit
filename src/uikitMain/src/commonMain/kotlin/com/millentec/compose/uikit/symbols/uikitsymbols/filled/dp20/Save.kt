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

fun UIKitFilledSymbols.save(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Save",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Save",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(3f, 5f)
                    curveTo(3f, 3.895f, 3.895f, 3f, 5f, 3f)
                    horizontalLineTo(6f)
                    lineTo(6f, 6.5f)
                    curveTo(6f, 7.328f, 6.672f, 8f, 7.5f, 8f)
                    lineTo(11.5f, 8f)
                    curveTo(12.328f, 8f, 13f, 7.328f, 13f, 6.5f)
                    verticalLineTo(3f)
                    horizontalLineTo(13.379f)
                    curveTo(13.909f, 3f, 14.418f, 3.211f, 14.793f, 3.586f)
                    lineTo(16.414f, 5.207f)
                    curveTo(16.789f, 5.582f, 17f, 6.091f, 17f, 6.621f)
                    verticalLineTo(15f)
                    curveTo(17f, 16.105f, 16.105f, 17f, 15f, 17f)
                    verticalLineTo(11.5f)
                    curveTo(15f, 10.672f, 14.328f, 10f, 13.5f, 10f)
                    horizontalLineTo(6.5f)
                    curveTo(5.672f, 10f, 5f, 10.672f, 5f, 11.5f)
                    lineTo(5f, 17f)
                    curveTo(3.895f, 17f, 3f, 16.105f, 3f, 15f)
                    verticalLineTo(5f)
                    close()
                    moveTo(12f, 3f)
                    horizontalLineTo(7f)
                    lineTo(7f, 6.5f)
                    curveTo(7f, 6.776f, 7.224f, 7f, 7.5f, 7f)
                    lineTo(11.5f, 7f)
                    curveTo(11.776f, 7f, 12f, 6.776f, 12f, 6.5f)
                    verticalLineTo(3f)
                    close()
                    moveTo(14f, 11.5f)
                    verticalLineTo(17f)
                    horizontalLineTo(6f)
                    verticalLineTo(11.5f)
                    curveTo(6f, 11.224f, 6.224f, 11f, 6.5f, 11f)
                    horizontalLineTo(13.5f)
                    curveTo(13.776f, 11f, 14f, 11.224f, 14f, 11.5f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.save(
    color: Color
) = save(
    SolidColor(color)
)