package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.foundation.Pages
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Symbols
import com.millentec.compose.uikit.theme.LocalStrings
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
fun DesignsPage() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush),
        contentPadding = PaddingValues(
            start = getUIKitLayout().x4Spacing,
            top = getUIKitLayout().x4Spacing,
            end = getUIKitLayout().x4Spacing,
        ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
    ) {
        val nav = MainViewModel.navigation

        item {
            Text(
                text = LocalStrings.current.designs.title,
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().x2Spacing))
        }

        item {
            UIKitSettingCard(
                icon = FluentIcons.Symbols,
                title = LocalStrings.current.designs.fluentIconsEntrance,
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.Designs_Icons, type = UIKitNavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                icon = FluentIcons.Symbols,
                title = "UIKit Symbols",
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.Designs_UIKitSymbols, type = UIKitNavigationType.Forward)
                }
            )
        }

        item {
            Spacer(
                Modifier.height(
                    maxOf(
                        LocalNavigationDockHeight.value + getUIKitLayout().mediumSpacing,
                        getUIKitLayout().x4Spacing
                    )
                )
            )
        }
    }
}