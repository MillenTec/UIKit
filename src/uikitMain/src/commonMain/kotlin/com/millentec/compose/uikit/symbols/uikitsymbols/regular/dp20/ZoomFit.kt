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

fun UIKitRegularSymbols.zoomFit(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "ZoomFit",
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
                name = "ZoomFit",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(3.86f, 7.847f)
                    curveTo(4.052f, 7.648f, 4.046f, 7.332f, 3.847f, 7.14f)
                    curveTo(3.648f, 6.948f, 3.332f, 6.954f, 3.14f, 7.153f)
                    lineTo(1.399f, 8.959f)
                    curveTo(0.839f, 9.54f, 0.839f, 10.46f, 1.398f, 11.041f)
                    lineTo(3.139f, 12.848f)
                    curveTo(3.33f, 13.047f, 3.647f, 13.053f, 3.846f, 12.861f)
                    curveTo(4.045f, 12.669f, 4.051f, 12.353f, 3.859f, 12.154f)
                    lineTo(2.119f, 10.347f)
                    curveTo(1.932f, 10.153f, 1.932f, 9.847f, 2.119f, 9.653f)
                    lineTo(3.86f, 7.847f)
                    close()
                    moveTo(7.152f, 3.141f)
                    curveTo(6.953f, 3.333f, 6.947f, 3.649f, 7.139f, 3.848f)
                    curveTo(7.331f, 4.047f, 7.647f, 4.052f, 7.846f, 3.861f)
                    lineTo(9.652f, 2.12f)
                    curveTo(9.846f, 1.933f, 10.153f, 1.933f, 10.346f, 2.12f)
                    lineTo(12.152f, 3.861f)
                    curveTo(12.351f, 4.052f, 12.667f, 4.047f, 12.859f, 3.848f)
                    curveTo(13.051f, 3.649f, 13.045f, 3.333f, 12.846f, 3.141f)
                    lineTo(11.04f, 1.4f)
                    curveTo(10.46f, 0.839f, 9.539f, 0.839f, 8.958f, 1.4f)
                    lineTo(7.152f, 3.141f)
                    close()
                    moveTo(16.859f, 7.153f)
                    curveTo(16.667f, 6.954f, 16.351f, 6.948f, 16.152f, 7.14f)
                    curveTo(15.953f, 7.332f, 15.947f, 7.648f, 16.139f, 7.847f)
                    lineTo(17.885f, 9.658f)
                    curveTo(18.072f, 9.852f, 18.072f, 10.16f, 17.884f, 10.353f)
                    lineTo(16.14f, 12.153f)
                    curveTo(15.948f, 12.351f, 15.953f, 12.668f, 16.151f, 12.86f)
                    curveTo(16.349f, 13.052f, 16.666f, 13.047f, 16.858f, 12.849f)
                    lineTo(18.602f, 11.049f)
                    curveTo(19.165f, 10.468f, 19.166f, 9.546f, 18.605f, 8.964f)
                    lineTo(16.859f, 7.153f)
                    close()
                    moveTo(7.846f, 16.141f)
                    curveTo(7.647f, 15.949f, 7.331f, 15.955f, 7.139f, 16.154f)
                    curveTo(6.947f, 16.353f, 6.953f, 16.669f, 7.152f, 16.861f)
                    lineTo(8.964f, 18.606f)
                    curveTo(9.546f, 19.167f, 10.468f, 19.166f, 11.048f, 18.603f)
                    lineTo(12.847f, 16.86f)
                    curveTo(13.045f, 16.668f, 13.05f, 16.351f, 12.858f, 16.153f)
                    curveTo(12.666f, 15.955f, 12.349f, 15.95f, 12.151f, 16.142f)
                    lineTo(10.352f, 17.885f)
                    curveTo(10.159f, 18.072f, 9.852f, 18.073f, 9.658f, 17.886f)
                    lineTo(7.846f, 16.141f)
                    close()
                    moveTo(8f, 6f)
                    curveTo(6.895f, 6f, 6f, 6.895f, 6f, 8f)
                    verticalLineTo(12f)
                    curveTo(6f, 13.104f, 6.895f, 14f, 8f, 14f)
                    horizontalLineTo(12f)
                    curveTo(13.105f, 14f, 14f, 13.104f, 14f, 12f)
                    verticalLineTo(8f)
                    curveTo(14f, 6.895f, 13.105f, 6f, 12f, 6f)
                    horizontalLineTo(8f)
                    close()
                    moveTo(7f, 8f)
                    curveTo(7f, 7.448f, 7.448f, 7f, 8f, 7f)
                    horizontalLineTo(12f)
                    curveTo(12.552f, 7f, 13f, 7.448f, 13f, 8f)
                    verticalLineTo(12f)
                    curveTo(13f, 12.552f, 12.552f, 13f, 12f, 13f)
                    horizontalLineTo(8f)
                    curveTo(7.448f, 13f, 7f, 12.552f, 7f, 12f)
                    verticalLineTo(8f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.zoomFit(
    color: Color
) = zoomFit(
    SolidColor(color)
)