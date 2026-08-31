package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.input.UIKitButton
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.UIKitIcon
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.animate.*
import com.millentec.compose.uikit.symbols.builtin.systemui.AddCircle
import com.millentec.compose.uikit.symbols.builtin.systemui.Wifi
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolStyle
import com.millentec.compose.uikit.theme.LocalStrings
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
fun HomePage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush),
        contentPadding = PaddingValues(
            start = getUIKitLayout().screenSideSpacing,
            top = getUIKitLayout().screenSideSpacing,
            end = getUIKitLayout().screenSideSpacing,
            bottom = maxOf(
                LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                getUIKitLayout().screenSideSpacing
            )
        ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
    ) {
        val nav = MainViewModel.navigation

        item {
            Text(
                text = LocalStrings.current.home.title,
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().titleSpacing))
        }

        item {
            Column {
                val visible0 = remember { mutableStateOf(true) }
                val visible1 = remember { mutableStateOf(false) }
                val enabled0 = remember { mutableStateOf(true) }
                val style = remember { mutableStateOf(false) }
                val state = remember { mutableStateOf(false) }
                val bounceTrigger = remember { mutableStateOf(0) }
                val isActive = remember { mutableStateOf(false) }

                Row {
                    UIKitIcon(
                        modifier = Modifier
                            .size(100.dp),
                        symbol = UIKitSymbols.systemUI.Wifi,
                        contentDescription = "Speaker",
                        symbolStyle = if (style.value) UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush)
                        else UIKitSymbolStyle.Hierarchical(getUIKitColors().highlightColorPrimaryBrush),
                        symbolEffect = UIKitSymbolEffect()
                            .visibleEffect(visible0.value)
                            .stateEffect(if (enabled0.value) "default" else "disabled")
                            .bounceEffect(bounceTrigger.value, -1f)
                            .variableColorEffect(isActive.value, initialValue = 0f)
                    )

                    UIKitIcon(
                        modifier = Modifier
                            .size(100.dp),
                        symbol = UIKitSymbols.systemUI.AddCircle,
                        contentDescription = null,
                        symbolStyle = if (style.value) UIKitSymbolStyle.Monochrome(getUIKitColors().textFillColorPrimaryBrush)
                        else UIKitSymbolStyle.MultiColor,
                        symbolEffect = UIKitSymbolEffect()
                            .visibleEffect(visible1.value)
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

                        Spacer(Modifier.height(getUIKitLayout().itemSpacing))

                        UIKitToggleSwitch(
                            checked = enabled0.value,
                            onCheckedChange = { enabled0.value = it }
                        )
                    }

                    Spacer(Modifier.width(getUIKitLayout().itemSpacing))

                    Column {
                        UIKitToggleSwitch(
                            checked = visible1.value,
                            onCheckedChange = { visible1.value = it }
                        )

                        Spacer(Modifier.height(getUIKitLayout().itemSpacing))

                        UIKitToggleSwitch(
                            checked = state.value,
                            onCheckedChange = { state.value = it }
                        )
                    }

                    Spacer(Modifier.width(getUIKitLayout().itemSpacing))

                    UIKitToggleSwitch(
                        checked = style.value,
                        onCheckedChange = { style.value = it }
                    )

                    Spacer(Modifier.width(getUIKitLayout().itemSpacing))

                    UIKitButton(
                        text = "Bounce",
                        onClick = {
                            bounceTrigger.value++
                        }
                    )

                    Spacer(Modifier.width(getUIKitLayout().itemSpacing))

                    UIKitToggleSwitch(
                        checked = isActive.value,
                        onCheckedChange = { isActive.value = it }
                    )
                }
            }
        }
    }
}