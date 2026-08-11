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

fun UIKitRegularSymbols.wifi(
    brushes: List<Brush>
): UIKitStaticSymbol {
    return object : UIKitStaticSymbol(
        name = "Wifi",
        defaultSize = DpSize(20.dp, 20.dp),
        brushes = brushes
    ) {
        override fun builder(): ImageVector {
            val brushes = this.brushes
            return ImageVector.Builder(
                name = "Wifi",
                defaultWidth = 20.dp,
                defaultHeight = 20.dp,
                viewportWidth = 20f,
                viewportHeight = 20f
            ).apply {
                path(fill = brushes.getOrNull(3)) {
                    moveTo(16.832f, 7.384f)
                    curveTo(17.241f, 7.793f, 17.628f, 8.261f, 17.965f, 8.749f)
                    curveTo(18.122f, 8.976f, 18.065f, 9.288f, 17.838f, 9.444f)
                    curveTo(17.61f, 9.601f, 17.299f, 9.544f, 17.142f, 9.317f)
                    curveTo(16.839f, 8.878f, 16.491f, 8.456f, 16.125f, 8.091f)
                    curveTo(12.762f, 4.728f, 7.309f, 4.728f, 3.946f, 8.091f)
                    curveTo(3.598f, 8.439f, 3.253f, 8.86f, 2.939f, 9.313f)
                    curveTo(2.782f, 9.54f, 2.47f, 9.596f, 2.243f, 9.439f)
                    curveTo(2.016f, 9.282f, 1.96f, 8.97f, 2.118f, 8.743f)
                    curveTo(2.464f, 8.244f, 2.846f, 7.777f, 3.239f, 7.384f)
                    curveTo(6.993f, 3.63f, 13.078f, 3.63f, 16.832f, 7.384f)
                    close()
                }
                path(fill = brushes.getOrNull(2)) {
                    moveTo(14.596f, 9.357f)
                    curveTo(15.069f, 9.829f, 15.478f, 10.403f, 15.79f, 11.013f)
                    curveTo(15.916f, 11.259f, 15.819f, 11.56f, 15.573f, 11.686f)
                    curveTo(15.327f, 11.812f, 15.026f, 11.714f, 14.9f, 11.468f)
                    curveTo(14.634f, 10.949f, 14.285f, 10.46f, 13.889f, 10.064f)
                    curveTo(11.761f, 7.936f, 8.31f, 7.936f, 6.182f, 10.064f)
                    curveTo(5.768f, 10.477f, 5.433f, 10.943f, 5.174f, 11.454f)
                    curveTo(5.049f, 11.7f, 4.748f, 11.799f, 4.502f, 11.674f)
                    curveTo(4.256f, 11.55f, 4.157f, 11.249f, 4.282f, 11.002f)
                    curveTo(4.588f, 10.397f, 4.986f, 9.846f, 5.475f, 9.357f)
                    curveTo(7.994f, 6.838f, 12.078f, 6.838f, 14.596f, 9.357f)
                    close()
                }
                path(fill = brushes.getOrNull(1)) {
                    moveTo(12.887f, 11.854f)
                    curveTo(13.242f, 12.208f, 13.534f, 12.644f, 13.737f, 13.108f)
                    curveTo(13.848f, 13.361f, 13.732f, 13.656f, 13.479f, 13.767f)
                    curveTo(13.226f, 13.877f, 12.932f, 13.762f, 12.821f, 13.509f)
                    curveTo(12.667f, 13.157f, 12.444f, 12.825f, 12.18f, 12.561f)
                    curveTo(10.996f, 11.377f, 9.075f, 11.377f, 7.891f, 12.561f)
                    curveTo(7.628f, 12.824f, 7.415f, 13.143f, 7.26f, 13.499f)
                    curveTo(7.149f, 13.752f, 6.854f, 13.867f, 6.601f, 13.756f)
                    curveTo(6.348f, 13.646f, 6.233f, 13.351f, 6.344f, 13.098f)
                    curveTo(6.548f, 12.631f, 6.83f, 12.208f, 7.184f, 11.854f)
                    curveTo(8.759f, 10.279f, 11.312f, 10.279f, 12.887f, 11.854f)
                    close()
                }
                path(fill = brushes.getOrNull(0)) {
                    moveTo(10.963f, 13.787f)
                    curveTo(11.47f, 14.294f, 11.47f, 15.116f, 10.963f, 15.623f)
                    curveTo(10.456f, 16.13f, 9.634f, 16.13f, 9.126f, 15.623f)
                    curveTo(8.619f, 15.116f, 8.619f, 14.294f, 9.126f, 13.787f)
                    curveTo(9.634f, 13.28f, 10.456f, 13.28f, 10.963f, 13.787f)
                    close()
                }
            }.build()
        }
    }
}

fun UIKitRegularSymbols.wifi(
    color: Color,
    layered: Boolean = false
) = wifi(
    listOf(
        SolidColor(color),
        if (layered) SolidColor(color.copy(0.75f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.6f)) else SolidColor(color),
        if (layered) SolidColor(color.copy(0.45f)) else SolidColor(color)
        )
)