package com.millentec.compose.uikit.symbols.regular

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.symbols.UIKitRegularSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitRegularSymbols.Speaker: UIKitSymbol
    get() {
        if (_Speaker != null)
            return _Speaker!!
        _Speaker = object: UIKitSymbol(
            name = "AddCircle",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f),
        ) {
            override val layers: List<UIKitSymbolLayer>
                get() = listOf(
                    UIKitSymbolLayer("Primary").apply {
                        group(
                            id = 0,
                            drawType = UIKitPathDrawType.Fill
                        ) {
                            moveTo(10.32f, 2.27f)
                            lineToRelative(-3.87f, 3.59f)
                            curveToRelative(-0.09f, 0.09f, -0.21f, 0.13f, -0.34f, 0.13f)
                            horizontalLineToRelative(-2.61f)
                            curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f)
                            verticalLineToRelative(5f)
                            curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f)
                            horizontalLineToRelative(2.61f)
                            curveToRelative(0.13f, 0f, 0.25f, 0.05f, 0.34f, 0.13f)
                            lineToRelative(3.87f, 3.59f)
                            curveToRelative(0.64f, 0.59f, 1.68f, 0.14f, 1.68f, -0.73f)
                            verticalLineTo(3.01f)
                            curveToRelative(0f, -0.87f, -1.04f, -1.33f, -1.68f, -0.73f)
                            close()
                            moveTo(11f, 16.99f)
                            lineToRelative(-3.87f, -3.59f)
                            curveToRelative(-0.28f, -0.26f, -0.64f, -0.4f, -1.02f, -0.4f)
                            horizontalLineToRelative(-2.61f)
                            curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f)
                            verticalLineToRelative(-5f)
                            curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f)
                            horizontalLineToRelative(2.61f)
                            curveToRelative(0.38f, 0f, 0.74f, -0.14f, 1.02f, -0.4f)
                            lineToRelative(3.87f, -3.59f)
                            verticalLineToRelative(13.99f)
                            close()
                        }
                    },
                    UIKitSymbolLayer("Wave0").apply {
                        group(
                            id = 1,
                            drawType = UIKitPathDrawType.Fill,
                        ) {
                            moveTo(14.08f, 12.93f)
                            curveToRelative(-0.24f, -0.14f, -0.32f, -0.44f, -0.18f, -0.68f)
                            curveToRelative(0.78f, -1.35f, 0.83f, -3.06f, 0f, -4.5f)
                            curveToRelative(-0.14f, -0.24f, -0.06f, -0.54f, 0.18f, -0.68f)
                            curveToRelative(0.24f, -0.14f, 0.54f, -0.06f, 0.68f, 0.18f)
                            curveToRelative(1.02f, 1.76f, 0.95f, 3.86f, 0f, 5.5f)
                            curveToRelative(-0.14f, 0.24f, -0.44f, 0.32f, -0.68f, 0.18f)
                            close()
                        }
                    },
                    UIKitSymbolLayer("Wave1").apply {
                        group(
                            id = 2,
                            drawType = UIKitPathDrawType.Fill,
                        ) {
                            moveTo(15.26f, 4.63f)
                            curveToRelative(0.21f, -0.18f, 0.52f, -0.17f, 0.71f, 0.04f)
                            curveToRelative(2.72f, 3.03f, 2.72f, 7.64f, 0f, 10.67f)
                            curveToRelative(-0.18f, 0.21f, -0.5f, 0.22f, -0.71f, 0.04f)
                            curveToRelative(-0.21f, -0.18f, -0.22f, -0.5f, -0.04f, -0.71f)
                            curveToRelative(2.38f, -2.65f, 2.38f, -6.68f, 0f, -9.33f)
                            curveToRelative(-0.18f, -0.21f, -0.17f, -0.52f, 0.04f, -0.71f)
                            close()
                        }
                    }
                )

            @Composable
            override fun colorSet(style: UIKitSymbolStyle): List<Pair<Brush, Float>> {
                return when(style) {
                    is UIKitSymbolStyle.Hierarchical -> listOf(
                        Pair(style.brush, 1f),
                        Pair(style.brush, 0.75f),
                        Pair(style.brush, 0.6f),
                    )
                    is UIKitSymbolStyle.Monochrome -> layers.map { Pair(style.brush, 1f) }
                    UIKitSymbolStyle.MultiColor -> layers.map {
                        Pair(SolidColor(getUIKitColors().highlightColorPrimaryBrush), 1f)
                    }
                    is UIKitSymbolStyle.Palette -> style.brushes.map { Pair(it, 1f) }
                }
            }
        }

        return _Speaker!!
    }

@Suppress("ObjectPropertyName")
private var _Speaker: UIKitSymbol? = null