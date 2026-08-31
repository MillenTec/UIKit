package com.millentec.compose.uikit.symbols.builtin.shapes

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.DesignIdeas: UIKitSymbol
    get() {
        if (_DesignIdeas != null)
            return _DesignIdeas!!
        _DesignIdeas = object : UIKitSymbol(
            name = "DesignIdeas",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("paintbrush", 1).apply {
                    group(
                        id = "paintbrush",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(5.25f, 7.6f)
                        reflectiveCurveToRelative(-0.04f, -0.05f, -0.06f, -0.07f)
                        curveToRelative(0.49f, -0.45f, 0.81f, -1.17f, 0.81f, -2.03f)
                        curveToRelative(0f, -0.7f, -0.14f, -1.18f, -0.4f, -1.56f)
                        curveToRelative(-0.12f, -0.18f, -0.26f, -0.33f, -0.39f, -0.45f)
                        curveToRelative(-0.07f, -0.07f, -0.12f, -0.11f, -0.17f, -0.16f)
                        curveToRelative(-0.06f, -0.06f, -0.12f, -0.11f, -0.19f, -0.18f)
                        curveToRelative(-0.15f, -0.15f, -0.17f, -0.27f, -0.17f, -0.33f)
                        curveToRelative(0f, -0.04f, 0f, -0.07f, 0.01f, -0.09f)
                        curveToRelative(0f, 0f, 0f, -0.01f, 0f, -0.01f)
                        curveToRelative(0.09f, -0.2f, 0.04f, -0.44f, -0.12f, -0.58f)
                        curveToRelative(-0.17f, -0.15f, -0.42f, -0.17f, -0.61f, -0.04f)
                        horizontalLineToRelative(0f)
                        reflectiveCurveToRelative(0f, 0f, 0f, 0f)
                        horizontalLineToRelative(0f)
                        reflectiveCurveToRelative(-0.03f, 0.03f, -0.03f, 0.03f)
                        curveToRelative(-0.02f, 0.02f, -0.06f, 0.04f, -0.1f, 0.07f)
                        curveToRelative(-0.08f, 0.06f, -0.2f, 0.15f, -0.33f, 0.27f)
                        curveToRelative(-0.25f, 0.22f, -0.58f, 0.55f, -0.81f, 0.94f)
                        curveToRelative(-0.19f, 0.3f, -0.36f, 0.67f, -0.48f, 1.03f)
                        curveToRelative(-0.12f, 0.36f, -0.21f, 0.75f, -0.21f, 1.07f)
                        curveToRelative(0f, 0.85f, 0.32f, 1.58f, 0.81f, 2.03f)
                        curveToRelative(-0.02f, 0.02f, -0.04f, 0.05f, -0.06f, 0.07f)
                        curveToRelative(-0.28f, 0.34f, -0.44f, 0.79f, -0.54f, 1.23f)
                        curveToRelative(-0.2f, 0.87f, -0.2f, 1.92f, -0.2f, 2.64f)
                        verticalLineToRelative(0.03f)
                        curveToRelative(0f, 2.79f, 0.38f, 4.37f, 0.8f, 5.27f)
                        curveToRelative(0.21f, 0.46f, 0.43f, 0.74f, 0.63f, 0.93f)
                        curveToRelative(0.1f, 0.09f, 0.18f, 0.15f, 0.26f, 0.2f)
                        curveToRelative(0.04f, 0.02f, 0.07f, 0.04f, 0.1f, 0.05f)
                        curveToRelative(0.01f, 0f, 0.03f, 0.01f, 0.04f, 0.02f)
                        curveToRelative(0f, 0f, 0.11f, 0.04f, 0.19f, 0.04f)
                        reflectiveCurveToRelative(0.19f, -0.04f, 0.19f, -0.04f)
                        curveToRelative(0.01f, 0f, 0.02f, 0f, 0.04f, -0.02f)
                        curveToRelative(0.03f, -0.01f, 0.06f, -0.03f, 0.1f, -0.05f)
                        curveToRelative(0.07f, -0.04f, 0.16f, -0.11f, 0.26f, -0.2f)
                        curveToRelative(0.19f, -0.18f, 0.42f, -0.47f, 0.63f, -0.93f)
                        curveToRelative(0.42f, -0.9f, 0.8f, -2.48f, 0.8f, -5.27f)
                        verticalLineToRelative(-0.03f)
                        curveToRelative(0f, -0.73f, 0f, -1.77f, -0.2f, -2.64f)
                        curveToRelative(-0.1f, -0.44f, -0.26f, -0.89f, -0.54f, -1.23f)
                        close()
                        moveTo(4.3f, 16.35f)
                        curveToRelative(-0.11f, 0.24f, -0.21f, 0.4f, -0.3f, 0.5f)
                        curveToRelative(-0.08f, -0.1f, -0.19f, -0.26f, -0.3f, -0.5f)
                        curveToRelative(-0.33f, -0.72f, -0.7f, -2.14f, -0.7f, -4.85f)
                        curveToRelative(0f, -0.76f, 0f, -1.7f, 0.17f, -2.45f)
                        curveToRelative(0.09f, -0.37f, 0.2f, -0.65f, 0.35f, -0.82f)
                        curveToRelative(0.12f, -0.15f, 0.27f, -0.23f, 0.48f, -0.23f)
                        horizontalLineToRelative(0f)
                        curveToRelative(0.21f, 0f, 0.35f, 0.08f, 0.48f, 0.23f)
                        curveToRelative(0.14f, 0.17f, 0.26f, 0.45f, 0.35f, 0.82f)
                        curveToRelative(0.17f, 0.75f, 0.17f, 1.69f, 0.17f, 2.45f)
                        curveToRelative(0f, 2.71f, -0.37f, 4.13f, -0.7f, 4.85f)
                        close()
                        moveTo(4f, 7f)
                        horizontalLineToRelative(0f)
                        curveToRelative(-0.38f, 0f, -1f, -0.43f, -1f, -1.5f)
                        curveToRelative(0f, -0.17f, 0.05f, -0.45f, 0.16f, -0.76f)
                        curveToRelative(0.1f, -0.3f, 0.24f, -0.6f, 0.38f, -0.81f)
                        curveToRelative(0f, 0f, 0f, -0.01f, 0.01f, -0.02f)
                        curveToRelative(0.09f, -0.15f, 0.2f, -0.29f, 0.32f, -0.42f)
                        curveToRelative(0.07f, 0.12f, 0.16f, 0.25f, 0.28f, 0.37f)
                        curveToRelative(0.07f, 0.07f, 0.17f, 0.16f, 0.25f, 0.24f)
                        curveToRelative(0.05f, 0.05f, 0.09f, 0.09f, 0.12f, 0.12f)
                        curveToRelative(0.11f, 0.1f, 0.19f, 0.19f, 0.25f, 0.29f)
                        curveToRelative(0.12f, 0.18f, 0.23f, 0.45f, 0.23f, 1f)
                        curveToRelative(0f, 1.07f, -0.61f, 1.5f, -1f, 1.5f)
                        close()
                    }
                },
                UIKitSymbolLayer("shapes").apply {
                    group(
                        id = "shapes",
                        drawType = UIKitPathDrawType.Fill,
                    ) {
                        moveTo(16f, 8f)
                        horizontalLineToRelative(-2f)
                        curveToRelative(0f, -2.76f, -2.24f, -5f, -5f, -5f)
                        curveToRelative(-0.88f, 0f, -1.7f, 0.23f, -2.42f, 0.62f)
                        curveToRelative(0.16f, 0.29f, 0.27f, 0.61f, 0.34f, 0.96f)
                        curveToRelative(0.61f, -0.37f, 1.32f, -0.58f, 2.08f, -0.58f)
                        curveToRelative(2.21f, 0f, 4f, 1.79f, 4f, 4f)
                        horizontalLineToRelative(-2f)
                        curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
                        verticalLineToRelative(2f)
                        curveToRelative(-0.72f, 0f, -1.4f, -0.19f, -1.99f, -0.53f)
                        curveToRelative(0f, 0.38f, 0f, 0.75f, -0.02f, 1.11f)
                        curveToRelative(0.62f, 0.27f, 1.3f, 0.42f, 2.01f, 0.42f)
                        verticalLineToRelative(2f)
                        curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
                        horizontalLineToRelative(5f)
                        curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                        verticalLineToRelative(-5f)
                        curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
                        close()
                        moveTo(10f, 10f)
                        curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
                        horizontalLineToRelative(1.87f)
                        curveToRelative(-0.36f, 1.41f, -1.47f, 2.51f, -2.87f, 2.87f)
                        verticalLineToRelative(-1.87f)
                        close()
                        moveTo(17f, 15f)
                        curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f)
                        horizontalLineToRelative(-5f)
                        curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                        verticalLineToRelative(-2.1f)
                        curveToRelative(1.96f, -0.4f, 3.5f, -1.94f, 3.9f, -3.9f)
                        horizontalLineToRelative(2.1f)
                        curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
                        verticalLineToRelative(5f)
                        close()
                    }
                }
            )

            override val abilityStatement: List<UIKitSymbolAbility> = listOf(
                UIKitSymbolAbility.Appear,
                UIKitSymbolAbility.Disappear,
                UIKitSymbolAbility.Bounce
            )

            override val tags: List<String> = listOf(
                "Design", "Shape", "Draw"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when (style) {
                    is UIKitSymbolStyle.Hierarchical -> {
                        listOf(
                            UIKitSymbolColor("paintbrush", style.brush, 1f),
                            UIKitSymbolColor("shapes", style.brush, 0.6f),
                        )
                    }
                    is UIKitSymbolStyle.Monochrome -> layers.map { layer ->
                        UIKitSymbolColor(
                            layer.id,
                            style.brush,
                            1f
                        )
                    }
                    UIKitSymbolStyle.MultiColor -> layers.map { layer ->
                        UIKitSymbolColor(
                            layer.id,
                            UIKitBrush.solid(getUIKitColors().highlightColorPrimaryBrush),
                            1f
                        )
                    }
                    is UIKitSymbolStyle.Palette -> style.brushes.mapIndexed { index, brush ->
                        UIKitSymbolColor(
                            layers.getOrNull(index)?.id ?: "unknown",
                            brush,
                            1f
                        )
                    }
                }
            }
        }

        return _DesignIdeas!!
    }

@Suppress("ObjectPropertyName")
private var _DesignIdeas: UIKitSymbol? = null