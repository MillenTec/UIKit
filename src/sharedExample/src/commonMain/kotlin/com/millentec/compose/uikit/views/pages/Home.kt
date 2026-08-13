package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.UIKitIcon
import com.millentec.compose.uikit.foundation.CommonPage
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolEffect
import com.millentec.compose.uikit.symbols.animate.visibleEffect
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.symbols.regular.AddCircle
import com.millentec.compose.uikit.symbols.regular.Speaker
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout

@Composable
@Preview
private fun Preview() {
    Home().Content()
}

class Home: CommonPage("home") {
    override fun LazyListScope.lazyContent() {
        item {
            Column {
                val visible0 = remember { mutableStateOf(true) }
                val visible1 = remember { mutableStateOf(false) }
                val style = remember { mutableStateOf(false) }

                Row {
                    UIKitIcon(
                        modifier = Modifier
                            .size(100.dp),
                        symbol = UIKitSymbols.regular.Speaker,
                        contentDescription = "Speaker",
                        symbolStyle = if (style.value) UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush)
                        else UIKitSymbolStyle.Hierarchical(getUIKitColors().highlightColorPrimaryBrush),
                        symbolEffect = UIKitSymbolEffect
                            .visibleEffect(visible0.value)
                    )

                    UIKitIcon(
                        modifier = Modifier
                            .size(100.dp),
                        symbol = UIKitSymbols.regular.AddCircle,
                        contentDescription = null,
                        symbolStyle = if (style.value) UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush)
                        else UIKitSymbolStyle.Hierarchical(getUIKitColors().highlightColorPrimaryBrush),
                        symbolEffect = UIKitSymbolEffect
                            .visibleEffect(visible1.value)
                    )
                }

                Row {
                    UIKitToggleSwitch(
                        checked = visible0.value,
                        onCheckedChange = { visible0.value = it }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    UIKitToggleSwitch(
                        checked = visible1.value,
                        onCheckedChange = { visible1.value = it }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    UIKitToggleSwitch(
                        checked = style.value,
                        onCheckedChange = { style.value = it }
                    )
                }
            }
        }
    }
}