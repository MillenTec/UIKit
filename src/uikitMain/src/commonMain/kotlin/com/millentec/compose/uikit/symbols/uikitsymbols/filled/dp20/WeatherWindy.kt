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

fun UIKitFilledSymbols.weatherWindy(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "WeatherWindy",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "WeatherWindy",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(6.073f, 5.812f)
                    curveTo(6.4f, 4.177f, 7.835f, 3f, 9.502f, 3f)
                    curveTo(11.434f, 3f, 13f, 4.568f, 13f, 6.499f)
                    curveTo(13f, 8.431f, 11.433f, 10f, 9.5f, 10f)
                    horizontalLineTo(2.75f)
                    curveTo(2.336f, 10f, 2f, 9.664f, 2f, 9.25f)
                    curveTo(2f, 8.836f, 2.336f, 8.5f, 2.75f, 8.5f)
                    horizontalLineTo(9.5f)
                    curveTo(10.604f, 8.5f, 11.5f, 7.604f, 11.5f, 6.499f)
                    curveTo(11.5f, 5.395f, 10.605f, 4.5f, 9.502f, 4.5f)
                    curveTo(8.55f, 4.5f, 7.73f, 5.172f, 7.544f, 6.106f)
                    lineTo(7.485f, 6.397f)
                    curveTo(7.404f, 6.803f, 7.009f, 7.067f, 6.603f, 6.985f)
                    curveTo(6.197f, 6.904f, 5.933f, 6.509f, 6.015f, 6.103f)
                    lineTo(6.073f, 5.812f)
                    close()
                    moveTo(13.359f, 9.354f)
                    curveTo(13.774f, 8.524f, 14.623f, 8f, 15.55f, 8f)
                    curveTo(16.903f, 8f, 18f, 9.097f, 18f, 10.449f)
                    verticalLineTo(10.5f)
                    curveTo(18f, 11.881f, 16.88f, 13f, 15.5f, 13f)
                    horizontalLineTo(14.584f)
                    curveTo(14.691f, 13.271f, 14.75f, 13.566f, 14.75f, 13.875f)
                    curveTo(14.75f, 15.189f, 13.682f, 16.25f, 12.372f, 16.25f)
                    curveTo(11.579f, 16.25f, 10.835f, 15.855f, 10.393f, 15.194f)
                    lineTo(10.377f, 15.17f)
                    curveTo(10.146f, 14.826f, 10.238f, 14.361f, 10.583f, 14.13f)
                    curveTo(10.927f, 13.9f, 11.393f, 13.992f, 11.623f, 14.336f)
                    lineTo(11.639f, 14.36f)
                    curveTo(11.802f, 14.603f, 12.078f, 14.75f, 12.372f, 14.75f)
                    curveTo(12.857f, 14.75f, 13.25f, 14.356f, 13.25f, 13.875f)
                    curveTo(13.25f, 13.392f, 12.858f, 13f, 12.375f, 13f)
                    horizontalLineTo(9f)
                    lineTo(8.996f, 13f)
                    horizontalLineTo(2.75f)
                    curveTo(2.336f, 13f, 2f, 12.664f, 2f, 12.25f)
                    curveTo(2f, 11.836f, 2.336f, 11.5f, 2.75f, 11.5f)
                    horizontalLineTo(15.5f)
                    curveTo(16.052f, 11.5f, 16.5f, 11.052f, 16.5f, 10.5f)
                    verticalLineTo(10.449f)
                    curveTo(16.5f, 9.925f, 16.075f, 9.5f, 15.55f, 9.5f)
                    curveTo(15.191f, 9.5f, 14.862f, 9.703f, 14.701f, 10.025f)
                    lineTo(14.671f, 10.085f)
                    curveTo(14.486f, 10.456f, 14.035f, 10.606f, 13.665f, 10.421f)
                    curveTo(13.294f, 10.236f, 13.144f, 9.785f, 13.329f, 9.415f)
                    lineTo(13.359f, 9.354f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.weatherWindy(
    color: Color
) = weatherWindy(
    SolidColor(color)
)