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

fun UIKitFilledSymbols.zoomFit(
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
                    moveTo(3.861f, 7.846f)
                    curveTo(4.053f, 7.647f, 4.047f, 7.331f, 3.848f, 7.139f)
                    curveTo(3.649f, 6.947f, 3.333f, 6.953f, 3.141f, 7.152f)
                    lineTo(1.4f, 8.958f)
                    curveTo(0.84f, 9.539f, 0.84f, 10.459f, 1.399f, 11.04f)
                    lineTo(3.14f, 12.847f)
                    curveTo(3.332f, 13.046f, 3.648f, 13.052f, 3.847f, 12.86f)
                    curveTo(4.046f, 12.668f, 4.052f, 12.352f, 3.86f, 12.153f)
                    lineTo(2.12f, 10.346f)
                    curveTo(1.933f, 10.152f, 1.933f, 9.846f, 2.12f, 9.652f)
                    lineTo(3.861f, 7.846f)
                    close()
                    moveTo(7.153f, 3.14f)
                    curveTo(6.954f, 3.332f, 6.948f, 3.648f, 7.14f, 3.847f)
                    curveTo(7.332f, 4.046f, 7.648f, 4.052f, 7.847f, 3.86f)
                    lineTo(9.653f, 2.119f)
                    curveTo(9.847f, 1.932f, 10.154f, 1.932f, 10.347f, 2.119f)
                    lineTo(12.153f, 3.86f)
                    curveTo(12.352f, 4.051f, 12.668f, 4.046f, 12.86f, 3.847f)
                    curveTo(13.052f, 3.648f, 13.046f, 3.332f, 12.847f, 3.14f)
                    lineTo(11.042f, 1.399f)
                    curveTo(10.461f, 0.838f, 9.54f, 0.838f, 8.959f, 1.399f)
                    lineTo(7.153f, 3.14f)
                    close()
                    moveTo(16.86f, 7.152f)
                    curveTo(16.668f, 6.953f, 16.352f, 6.947f, 16.153f, 7.139f)
                    curveTo(15.954f, 7.331f, 15.948f, 7.647f, 16.14f, 7.846f)
                    lineTo(17.886f, 9.657f)
                    curveTo(18.073f, 9.851f, 18.073f, 10.159f, 17.885f, 10.352f)
                    lineTo(16.141f, 12.152f)
                    curveTo(15.949f, 12.35f, 15.954f, 12.667f, 16.152f, 12.859f)
                    curveTo(16.35f, 13.051f, 16.667f, 13.046f, 16.859f, 12.848f)
                    lineTo(18.603f, 11.048f)
                    curveTo(19.166f, 10.467f, 19.167f, 9.545f, 18.606f, 8.963f)
                    lineTo(16.86f, 7.152f)
                    close()
                    moveTo(7.847f, 16.14f)
                    curveTo(7.648f, 15.948f, 7.332f, 15.954f, 7.14f, 16.153f)
                    curveTo(6.948f, 16.352f, 6.954f, 16.668f, 7.153f, 16.86f)
                    lineTo(8.965f, 18.605f)
                    curveTo(9.547f, 19.166f, 10.469f, 19.165f, 11.049f, 18.602f)
                    lineTo(12.848f, 16.859f)
                    curveTo(13.046f, 16.667f, 13.051f, 16.35f, 12.859f, 16.152f)
                    curveTo(12.667f, 15.954f, 12.35f, 15.949f, 12.152f, 16.141f)
                    lineTo(10.353f, 17.884f)
                    curveTo(10.16f, 18.071f, 9.853f, 18.072f, 9.659f, 17.885f)
                    lineTo(7.847f, 16.14f)
                    close()
                    moveTo(6f, 8f)
                    curveTo(6f, 6.895f, 6.895f, 6f, 8f, 6f)
                    horizontalLineTo(12f)
                    curveTo(13.105f, 6f, 14f, 6.895f, 14f, 8f)
                    verticalLineTo(12f)
                    curveTo(14f, 13.104f, 13.105f, 14f, 12f, 14f)
                    horizontalLineTo(8f)
                    curveTo(6.895f, 14f, 6f, 13.104f, 6f, 12f)
                    verticalLineTo(8f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.zoomFit(
    color: Color
) = zoomFit(
    SolidColor(color)
)