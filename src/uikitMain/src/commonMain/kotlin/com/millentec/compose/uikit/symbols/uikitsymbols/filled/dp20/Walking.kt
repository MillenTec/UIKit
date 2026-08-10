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

fun UIKitFilledSymbols.walking(
    brush: Brush
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Walking",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = listOf(brush)
    ) {
        override fun builder(): ImageVector {
            return ImageVector.Builder(
                name = "Walking",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(0)) {
                    moveTo(11f, 6f)
                    curveTo(12.105f, 6f, 13f, 5.105f, 13f, 4f)
                    curveTo(13f, 2.895f, 12.105f, 2f, 11f, 2f)
                    curveTo(9.895f, 2f, 9f, 2.895f, 9f, 4f)
                    curveTo(9f, 5.105f, 9.895f, 6f, 11f, 6f)
                    close()
                    moveTo(8.483f, 6.184f)
                    curveTo(8.745f, 6.131f, 9f, 6.252f, 9.214f, 6.411f)
                    curveTo(9.713f, 6.781f, 10.331f, 7f, 11f, 7f)
                    curveTo(11.32f, 7f, 11.629f, 6.95f, 11.918f, 6.857f)
                    curveTo(12.083f, 6.804f, 12.257f, 6.771f, 12.425f, 6.811f)
                    curveTo(12.892f, 6.923f, 13.317f, 7.182f, 13.63f, 7.558f)
                    lineTo(14.89f, 9.066f)
                    curveTo(14.95f, 9.137f, 15.028f, 9.191f, 15.117f, 9.22f)
                    lineTo(16.143f, 9.56f)
                    curveTo(16.799f, 9.777f, 17.154f, 10.484f, 16.937f, 11.139f)
                    curveTo(16.72f, 11.795f, 16.013f, 12.15f, 15.358f, 11.933f)
                    lineTo(13.858f, 11.437f)
                    curveTo(13.637f, 11.363f, 13.441f, 11.23f, 13.291f, 11.051f)
                    lineTo(12.8f, 10.463f)
                    curveTo(12.549f, 10.163f, 12.066f, 10.254f, 11.942f, 10.626f)
                    lineTo(11.793f, 11.073f)
                    curveTo(11.744f, 11.218f, 11.766f, 11.378f, 11.85f, 11.507f)
                    lineTo(12.903f, 13.101f)
                    curveTo(13.108f, 13.411f, 13.233f, 13.767f, 13.267f, 14.137f)
                    lineTo(13.494f, 16.637f)
                    curveTo(13.557f, 17.324f, 13.05f, 17.932f, 12.363f, 17.995f)
                    curveTo(11.675f, 18.057f, 11.067f, 17.551f, 11.005f, 16.863f)
                    lineTo(10.794f, 14.552f)
                    curveTo(10.787f, 14.47f, 10.759f, 14.39f, 10.714f, 14.321f)
                    lineTo(9.99f, 13.227f)
                    curveTo(9.772f, 12.896f, 9.273f, 12.939f, 9.115f, 13.302f)
                    lineTo(7.396f, 17.249f)
                    curveTo(7.12f, 17.882f, 6.383f, 18.172f, 5.75f, 17.896f)
                    curveTo(5.117f, 17.62f, 4.828f, 16.884f, 5.104f, 16.251f)
                    lineTo(7.957f, 9.701f)
                    curveTo(8.121f, 9.323f, 7.783f, 8.919f, 7.382f, 9.015f)
                    lineTo(7.261f, 9.044f)
                    curveTo(7.186f, 9.062f, 7.122f, 9.114f, 7.091f, 9.186f)
                    lineTo(6.588f, 10.318f)
                    curveTo(6.584f, 10.327f, 6.58f, 10.337f, 6.575f, 10.346f)
                    lineTo(6.13f, 11.285f)
                    curveTo(5.834f, 11.909f, 5.089f, 12.175f, 4.465f, 11.88f)
                    curveTo(3.841f, 11.584f, 3.575f, 10.838f, 3.871f, 10.215f)
                    lineTo(4.309f, 9.289f)
                    lineTo(4.806f, 8.171f)
                    curveTo(5.154f, 7.387f, 5.848f, 6.811f, 6.682f, 6.612f)
                    lineTo(8.407f, 6.201f)
                    curveTo(8.432f, 6.195f, 8.458f, 6.189f, 8.483f, 6.184f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitFilledSymbols.walking(
    color: Color
) = walking(
    SolidColor(color)
)