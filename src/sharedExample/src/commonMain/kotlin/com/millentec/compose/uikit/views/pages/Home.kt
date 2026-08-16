package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.UIKitButton
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.UIKitIcon
import com.millentec.compose.uikit.foundation.CommonPage
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.animate.*
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
                val enabled0 = remember { mutableStateOf(true) }
                val enabled1 = remember { mutableStateOf(true) }
                val style = remember { mutableStateOf(false) }
                val state = remember { mutableStateOf(false) }
                val bounceTrigger = remember { mutableStateOf(0) }

                Row {
                    UIKitIcon(
                        modifier = Modifier
                            .size(100.dp),
                        symbol = UIKitSymbols.regular.Speaker,
                        contentDescription = "Speaker",
                        symbolStyle = if (style.value) UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush)
                        else UIKitSymbolStyle.Hierarchical(getUIKitColors().highlightColorPrimaryBrush),
                        symbolEffect = UIKitSymbolEffect()
                            .visibleEffect(visible0.value)
                            .disableEffect(enabled0.value)
                            .bounceEffect(bounceTrigger.value)
                    )

                    UIKitIcon(
                        modifier = Modifier
                            .size(100.dp),
                        symbol = UIKitSymbols.regular.AddCircle,
                        contentDescription = null,
                        symbolStyle = if (style.value) UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush)
                        else UIKitSymbolStyle.MultiColor,
                        symbolEffect = UIKitSymbolEffect()
                            .visibleEffect(visible1.value)
                            .disableEffect(enabled1.value)
                            .stateEffect(if (state.value) "checkmark" else "add")
                            .bounceEffect(bounceTrigger.value)
                    )
                }

                Row {
                    Column {
                        UIKitToggleSwitch(
                            checked = visible0.value,
                            onCheckedChange = { visible0.value = it }
                        )

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                        UIKitToggleSwitch(
                            checked = enabled0.value,
                            onCheckedChange = { enabled0.value = it }
                        )
                    }

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    Column {
                        UIKitToggleSwitch(
                            checked = visible1.value,
                            onCheckedChange = { visible1.value = it }
                        )

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                        UIKitToggleSwitch(
                            checked = enabled1.value,
                            onCheckedChange = { enabled1.value = it }
                        )

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                        UIKitToggleSwitch(
                            checked = state.value,
                            onCheckedChange = { state.value = it }
                        )
                    }

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    UIKitToggleSwitch(
                        checked = style.value,
                        onCheckedChange = { style.value = it }
                    )

                    Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                    UIKitButton(
                        text = "Bounce",
                        onClick = {
                            bounceTrigger.value++
                        }
                    )
                }
            }
        }
    }
}