package com.millentec.compose.uikit.symbols.builtin.objects

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitObjectsSymbols
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitObjectsSymbols.Tag: UIKitSymbol
    get() {
        if (_Tag != null)
            return _Tag!!
        _Tag = object : UIKitSymbol(
            name = "Tag",
            uid = "ic.obj.tag",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("tag") {
                    addGroup(
                        id = "tag",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        moveTo(3.35f, 11.72f)
                        lineToRelative(4.95f, 4.95f)
                        curveToRelative(0.59f, 0.59f, 1.54f, 0.59f, 2.12f, 0f)
                        lineToRelative(6.63f, -6.63f)
                        curveToRelative(0.28f, -0.28f, 0.44f, -0.66f, 0.44f, -1.06f)
                        verticalLineToRelative(-4.98f)
                        curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f)
                        horizontalLineToRelative(-4.9f)
                        curveToRelative(-0.4f, 0f, -0.78f, 0.16f, -1.06f, 0.44f)
                        lineToRelative(-6.67f, 6.66f)
                        curveToRelative(-0.59f, 0.59f, -0.59f, 1.54f, 0f, 2.12f)
                        close()
                    }
                    addGroup(
                        id = "point",
                        drawType = UIKitPathDrawType.Stroke(2f),
                    ) {
                        moveTo(14f, 6f)
                        lineTo(14.0001f, 5.9999f)
                    }
                }
            }

            override val abilityStatement: List<UIKitSymbolAbility>
                get() = listOf(
                    UIKitSymbolAbility.Appear,
                    UIKitSymbolAbility.Disappear,
                    UIKitSymbolAbility.Bounce,
                    UIKitSymbolAbility.VariableWeight
                )

            override val tags: List<String>
                get() = listOf(
                    "Tag", "Name", "Sign", "Mark"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "tag", null), 1f)
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "tag", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Tag!!
    }

@Suppress("ObjectPropertyName")
private var _Tag: UIKitSymbol? = null