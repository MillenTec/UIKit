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
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.foundation.NavigationType
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.LayoutDynamic
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.chatMultiple
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.layerDiagonal
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
fun Controls() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(getUIKitColors().contentFillColorPrimaryBrush),
        contentPadding = PaddingValues(
            start = getUIKitLayout().x4Spacing,
            top = getUIKitLayout().x4Spacing,
            end = getUIKitLayout().x4Spacing,
            bottom = getUIKitLayout().x6Spacing
        ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
    ) {
        val nav = MainViewModel.navigation

        item {
            Text(
                text = "Controls Gallery",
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().x2Spacing))
        }

        item {
            UIKitSettingCard(
                title = "Inputs",
                icon = FluentIcons.toggleMultiple(getUIKitColors().textFillColorPrimaryBrush, true),
                onClick = {
                    nav.switchPage(Pages.ControlsBasicInputs, type = NavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                title = "Status & Info",
                icon = FluentIcons.chatMultiple(getUIKitColors().textFillColorPrimaryBrush, true),
                onClick = {
                    nav.switchPage(Pages.ControlsStatusAndInfo, type = NavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                title = "Flyouts",
                icon = FluentIcons.layerDiagonal(getUIKitColors().textFillColorPrimaryBrush, true),
                onClick = {
                    nav.switchPage(Pages.ControlsFlyouts, type = NavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                title = "Layouts",
                icon = FluentIcons.LayoutDynamic,
                onClick = {
                    nav.switchPage(Pages.ControlsLayouts, type = NavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(
                maxOf(
                    LocalNavigationDockHeight.value + getUIKitLayout().mediumSpacing,
                    getUIKitLayout().x4Spacing
                )
            ))
        }
    }
}