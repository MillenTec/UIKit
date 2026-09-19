package com.millentec.compose.uikit.additionsymbols

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val GitHubSymbol: UIKitSymbol
    get() {
        if (_GitHubSymbol != null)
            return _GitHubSymbol!!
        _GitHubSymbol = object : UIKitSymbol(
            name = "GitHubSymbol",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("github").apply {
                    group(
                        id = "github",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(8.77f, 13.39f)
                        curveToRelative(-2.06f, -0.25f, -3.52f, -1.73f, -3.52f, -3.66f)
                        curveToRelative(0f, -0.78f, 0.28f, -1.62f, 0.75f, -2.19f)
                        curveToRelative(-0.2f, -0.52f, -0.17f, -1.61f, 0.06f, -2.06f)
                        curveToRelative(0.62f, -0.08f, 1.47f, 0.25f, 1.97f, 0.7f)
                        curveToRelative(0.59f, -0.19f, 1.22f, -0.28f, 1.98f, -0.28f)
                        reflectiveCurveToRelative(1.39f, 0.09f, 1.95f, 0.27f)
                        curveToRelative(0.48f, -0.44f, 1.34f, -0.77f, 1.97f, -0.69f)
                        curveToRelative(0.22f, 0.42f, 0.25f, 1.52f, 0.05f, 2.05f)
                        curveToRelative(0.5f, 0.59f, 0.77f, 1.39f, 0.77f, 2.2f)
                        curveToRelative(0f, 1.92f, -1.45f, 3.38f, -3.55f, 3.64f)
                        curveToRelative(0.53f, 0.34f, 0.89f, 1.09f, 0.89f, 1.95f)
                        verticalLineToRelative(1.62f)
                        curveToRelative(0f, 0.47f, 0.39f, 0.73f, 0.86f, 0.55f)
                        curveToRelative(2.83f, -1.08f, 5.05f, -3.91f, 5.05f, -7.41f)
                        curveToRelative(0f, -4.42f, -3.59f, -8.03f, -8.02f, -8.03f)
                        reflectiveCurveTo(2f, 5.67f, 2f, 10.09f)
                        curveToRelative(0f, 3.47f, 2.2f, 6.34f, 5.17f, 7.42f)
                        curveToRelative(0.42f, 0.16f, 0.83f, -0.12f, 0.83f, -0.55f)
                        verticalLineToRelative(-1.25f)
                        curveToRelative(-0.22f, 0.09f, -0.5f, 0.16f, -0.75f, 0.16f)
                        curveToRelative(-1.03f, 0f, -1.64f, -0.56f, -2.08f, -1.61f)
                        curveToRelative(-0.17f, -0.42f, -0.36f, -0.67f, -0.72f, -0.72f)
                        curveToRelative(-0.19f, -0.02f, -0.25f, -0.09f, -0.25f, -0.19f)
                        curveToRelative(0f, -0.19f, 0.31f, -0.33f, 0.63f, -0.33f)
                        curveToRelative(0.45f, 0f, 0.84f, 0.28f, 1.25f, 0.86f)
                        curveToRelative(0.31f, 0.45f, 0.64f, 0.66f, 1.03f, 0.66f)
                        reflectiveCurveToRelative(0.64f, -0.14f, 1f, -0.5f)
                        curveToRelative(0.27f, -0.27f, 0.47f, -0.5f, 0.66f, -0.66f)
                        close()
                    }
                }
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf()

            override val tags: List<String> = listOf()

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when (style) {
                    is UIKitSymbolStyle.Hierarchical -> layers.map { layer ->
                        UIKitSymbolColor(
                            selector = layer.id,
                            brush = style.brush,
                            alpha = 1f
                        )
                    }
                    is UIKitSymbolStyle.Monochrome -> layers.map { layer ->
                        UIKitSymbolColor(
                            layer.id,
                            brush = style.brush,
                            1f
                        )
                    }
                    UIKitSymbolStyle.MultiColor -> layers.map { layer ->
                        UIKitSymbolColor(
                            layer.id,
                            brush = UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush),
                            1f
                        )
                    }
                    is UIKitSymbolStyle.Palette -> layers.mapIndexed { index, layer ->
                        UIKitSymbolColor(
                            selector = layer.id,
                            brush = style.brushes.getOrElse(index) { UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush) },
                            alpha = 1f
                        )
                    }
                    is UIKitSymbolStyle.PaletteWithId -> layers.map { layer ->
                        UIKitSymbolColor(
                            selector = layer.id,
                            brush = style.brushes.firstOrNull { it.first == layer.id }?.second ?: UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush),
                            alpha = 1f
                        )
                    }
                }
            }
        }

        return _GitHubSymbol!!
    }

@Suppress("ObjectPropertyName")
private var _GitHubSymbol: UIKitSymbol? = null