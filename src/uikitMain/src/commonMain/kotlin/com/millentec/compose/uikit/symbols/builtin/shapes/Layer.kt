package com.millentec.compose.uikit.symbols.builtin.shapes

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitShapesSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.draw.UIKitPathDrawType
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolColor
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolLayer
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitShapesSymbols.Layer: UIKitSymbol
    get() {
        if (_Layer != null)
            return _Layer!!
        _Layer = object : UIKitSymbol(
            name = "Layer",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override val layers: List<UIKitSymbolLayer> = listOf(
                UIKitSymbolLayer("layer0", 2).apply {
                    group(
                        id = "layer0",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(10.505f, 3.117f)
                        curveTo(10.192f, 2.934f, 9.806f, 2.934f, 9.494f, 3.117f)
                        lineTo(3.485f, 6.636f)
                        curveTo(2.825f, 7.023f, 2.826f, 7.978f, 3.487f, 8.363f)
                        lineTo(9.496f, 11.865f)
                        curveTo(9.807f, 12.047f, 10.191f, 12.047f, 10.503f, 11.865f)
                        lineTo(16.512f, 8.363f)
                        curveTo(17.173f, 7.978f, 17.174f, 7.023f, 16.513f, 6.636f)
                        lineTo(10.505f, 3.117f)
                        close()
                        moveTo(9.494f, 4.276f)
                        curveTo(9.806f, 4.093f, 10.192f, 4.093f, 10.505f, 4.276f)
                        lineTo(16.008f, 7.499f)
                        lineTo(10.503f, 10.708f)
                        curveTo(10.191f, 10.889f, 9.807f, 10.889f, 9.496f, 10.708f)
                        lineTo(3.99f, 7.499f)
                        lineTo(9.494f, 4.276f)
                        close()
                    }
                },
                UIKitSymbolLayer("layer1", 1).apply {
                    group(
                        id = "layer1",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(3.071f, 9.65f)
                        lineTo(9.509f, 13.273f)
                        curveTo(9.813f, 13.444f, 10.185f, 13.444f, 10.49f, 13.273f)
                        lineTo(16.927f, 9.65f)
                        curveTo(17.115f, 10.088f, 16.976f, 10.639f, 16.512f, 10.91f)
                        lineTo(10.503f, 14.412f)
                        curveTo(10.191f, 14.594f, 9.807f, 14.594f, 9.496f, 14.412f)
                        lineTo(3.487f, 10.91f)
                        curveTo(3.023f, 10.639f, 2.884f, 10.088f, 3.071f, 9.65f)
                        close()
                    }
                },
                UIKitSymbolLayer("layer2", 0).apply {
                    group(
                        id = "layer2",
                        drawType = UIKitPathDrawType.Fill
                    ) {
                        moveTo(3.071f, 12.103f)
                        lineTo(9.509f, 15.725f)
                        curveTo(9.813f, 15.897f, 10.185f, 15.897f, 10.49f, 15.725f)
                        lineTo(16.927f, 12.103f)
                        curveTo(17.115f, 12.541f, 16.976f, 13.092f, 16.512f, 13.363f)
                        lineTo(10.503f, 16.865f)
                        curveTo(10.191f, 17.047f, 9.807f, 17.047f, 9.496f, 16.865f)
                        lineTo(3.487f, 13.363f)
                        curveTo(3.023f, 13.092f, 2.884f, 12.541f, 3.071f, 12.103f)
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
                "Layer", "Layers", "Papers"
            )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: List<Pair<String, UIKitSymbolGroupState>>
            ): List<UIKitSymbolColor> {
                return when (style) {
                    is UIKitSymbolStyle.Hierarchical -> {
                        listOf(
                            UIKitSymbolColor("layer0", style.brush, 1f),
                            UIKitSymbolColor("layer1", style.brush, 0.75f),
                            UIKitSymbolColor("layer2", style.brush, 0.6f),
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

        return _Layer!!
    }

@Suppress("ObjectPropertyName")
private var _Layer: UIKitSymbol? = null
