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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.additionsymbols.GitHubSymbol
import com.millentec.compose.uikit.component.input.UIKitSlider
import com.millentec.compose.uikit.component.layout.UIKitGroupedCard
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
            val value = remember { mutableStateOf(0f) }
            UIKitSlider(
                modifier = Modifier
                    .height(150.dp)
                    .width(40.dp),
                value = value.value,
                isVertical = true,
                adsorbedOntoTick = true,
                onValueChange = {
                    value.value = it
                }
            )
        }
    }
}