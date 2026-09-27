package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.additionsymbols.GitHubSymbol
import com.millentec.compose.uikit.component.input.UIKitTextField
import com.millentec.compose.uikit.component.input.UIKitTextFieldOptions
import com.millentec.compose.uikit.component.layout.UIKitGroupedCard
import com.millentec.compose.uikit.component.layout.UIKitHActionButtons
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.symbols.UIKitSymbols
import com.millentec.compose.uikit.symbols.builtin.systemui.Home
import com.millentec.compose.uikit.symbols.builtin.systemui.Search
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
            Text(
                text = LocalStrings.current.home.description,
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().sectionSpacing))
        }
        
        item {
            val uriHandler = LocalUriHandler.current
            UIKitGroupedCard {
                SettingCard(
                    title = LocalStrings.current.home.viewOnGitHub,
                    icon = GitHubSymbol.toComposeVector(getUIKitColors().textFillColorPrimaryBrush),
                    description = LocalStrings.current.home.viewOnGitHubDescription,
                    onClick = {
                        uriHandler.openUri("https://github.com/MillenTec/UIKit")
                    }
                )
            }
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().sectionSpacing))

            val value = remember { mutableStateOf("") }
            val enter = remember { mutableStateOf("") }
            val isFocused = remember { mutableStateOf(false) }
            UIKitTextField(
                watermark = "Enter Text...",
                symbol = UIKitSymbols.systemUI.Search,
                value = value.value,
                isFocus = isFocused.value,
                onFocusChange = { isFocused.value = it },
                onDismissRequest = { isFocused.value = false },
                onValueChange = {
                    value.value = it
                },
                options = UIKitTextFieldOptions(
                    clear = true
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = if (isDesktopOS()) KeyboardActions(
                    onAny = {
                        enter.value = value.value
                    }
                ) else KeyboardActions(
                    onSearch = {
                        enter.value = value.value
                    }
                )
            )

            Spacer(Modifier.height(getUIKitLayout().itemSpacing))
            Text(
                text = "Value: ${value.value}",
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush
            )

            Text(
                text = "Enter: ${enter.value}",
                style = getUIKitTypography().body,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            UIKitHActionButtons {
                Button(
                    UIKitSymbols.systemUI.Home,
                    "Home"
                ) {}
                Button(
                    UIKitSymbols.systemUI.Search,
                    "Search"
                ) {}
            }
        }
    }
}