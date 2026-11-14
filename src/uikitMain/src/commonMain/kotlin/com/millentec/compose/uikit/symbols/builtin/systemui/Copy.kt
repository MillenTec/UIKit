package com.millentec.compose.uikit.symbols.builtin.systemui

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.graphics.UIKitBrush
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.UIKitSymbolAbility
import com.millentec.compose.uikit.symbols.UIKitSystemUISymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState
import com.millentec.compose.uikit.symbols.builtin.UIKitSymbolColorSet
import com.millentec.compose.uikit.symbols.draw.*
import com.millentec.compose.uikit.theme.getUIKitColors

val UIKitSystemUISymbols.Copy: UIKitSymbol
    get() {
        if (_Copy != null)
            return _Copy!!
        _Copy = object : UIKitSymbol(
            name = "Copy",
            uid = "ic.sys.copy",
            defaultSize = DpSize(20.dp, 20.dp),
            viewportSize = Size(20f, 20f)
        ) {
            override fun UIKitSymbolDrawer.onDraw() {
                addLayer("copy0", 0) {
                    addGroup(
                        id = "copy0",
                        drawType = UIKitPathDrawType.Stroke(1f),
                    ) {
                        moveTo(9.5f, 16.5f)
                        horizontalLineToRelative(-4f)
                        curveToRelative(-0.55f, 0f, -1.05f, -0.22f, -1.41f, -0.59f)
                        reflectiveCurveToRelative(-0.59f, -0.86f, -0.59f, -1.41f)
                        verticalLineToRelative(-6f)
                        curveToRelative(0f, -0.55f, 0.22f, -1.05f, 0.59f, -1.41f)
                        reflectiveCurveToRelative(0.86f, -0.59f, 1.41f, -0.59f)
                        horizontalLineToRelative(4f)
                        curveToRelative(0.55f, 0f, 1.05f, 0.22f, 1.41f, 0.59f)
                        reflectiveCurveToRelative(0.59f, 0.86f, 0.59f, 1.41f)
                        verticalLineToRelative(6f)
                        curveToRelative(0f, 0.55f, -0.22f, 1.05f, -0.59f, 1.41f)
                        reflectiveCurveToRelative(-0.86f, 0.59f, -1.41f, 0.59f)
                        close()
                    }
                }
                addLayer("copy1", 1) {
                    val copy1Vector: UIKitPath.() -> Unit = {
                        moveTo(14.5f, 13.5f)
                        horizontalLineToRelative(-4f)
                        curveToRelative(-0.55f, 0f, -1.05f, -0.22f, -1.41f, -0.59f)
                        reflectiveCurveToRelative(-0.59f, -0.86f, -0.59f, -1.41f)
                        verticalLineToRelative(-6f)
                        curveToRelative(0f, -0.55f, 0.22f, -1.05f, 0.59f, -1.41f)
                        reflectiveCurveToRelative(0.86f, -0.59f, 1.41f, -0.59f)
                        horizontalLineToRelative(4f)
                        curveToRelative(0.55f, 0f, 1.05f, 0.22f, 1.41f, 0.59f)
                        reflectiveCurveToRelative(0.59f, 0.86f, 0.59f, 1.41f)
                        verticalLineToRelative(6f)
                        curveToRelative(0f, 0.55f, -0.22f, 1.05f, -0.59f, 1.41f)
                        reflectiveCurveToRelative(-0.86f, 0.59f, -1.41f, 0.59f)
                        close()
                    }

                    addGroup(
                        id = "copy1_mask_stroke",
                        drawType = UIKitPathDrawType.MaskStroke(3f)
                    ) {
                        copy1Vector()
                    }
                    addGroup(
                        id = "copy1_mask",
                        drawType = UIKitPathDrawType.MaskFilled
                    ) {
                        copy1Vector()
                    }
                    addGroup(
                        id = "copy1",
                        drawType = UIKitPathDrawType.Stroke(1f)
                    ) {
                        copy1Vector()
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
                    "Copy"
                )

            @Composable
            override fun colorSet(
                style: UIKitSymbolStyle,
                states: Map<UIKitSymbolSelector, UIKitSymbolGroupState>
            ): Map<UIKitSymbolSelector, UIKitSymbolColor> {
                return UIKitSymbolColorSet(
                    style = style,
                    layerInfo = mapOf(
                        Pair(UIKitSymbolSelector(null, "copy0", null), 0.6f),
                        Pair(UIKitSymbolSelector(null, "copy1", null), 1f),
                    ),
                    multiColor = mapOf(
                        Pair(
                            UIKitSymbolSelector(null, "copy0", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        ),
                        Pair(
                            UIKitSymbolSelector(null, "copy1", null),
                            UIKitSymbolColor(UIKitBrush.solid(getUIKitColors().textFillColorPrimaryBrush), 1f)
                        )
                    )
                )
            }
        }

        return _Copy!!
    }

@Suppress("ObjectPropertyName")
private var _Copy: UIKitSymbol? = null