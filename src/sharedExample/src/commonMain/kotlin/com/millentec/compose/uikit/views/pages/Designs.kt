package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.foundation.NavigationType
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Symbols
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel

@Composable
@Preview
fun Designs() {

    LaunchedEffect(Unit) {
        MainViewModel.navigationDockVisible(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(getUIKitLayout().x4Spacing, getUIKitLayout().x6Spacing)
        ) {
            Text(
                text = "Designs",
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )

            Spacer(Modifier.size(getUIKitLayout().mediumSpacing))

            UIKitSettingCard(
                icon = FluentIcons.Symbols,
                title = "Fluent Icons",
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.Icons, type = NavigationType.Forward)
                }
            )
        }
    }
}