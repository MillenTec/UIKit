package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.component.layout.UIKitGroupedCard
import com.millentec.compose.uikit.foundation.Pages
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.foundation.layout.UIKitCardItem
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.LayoutDynamic
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.chatMultiple
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.layerDiagonal
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.LocalStrings
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
fun ControlsPage() {
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
                text = LocalStrings.current.controls.title,
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().titleSpacing))
        }

        item {
            UIKitGroupedCard(
                items = listOf(
                    UIKitCardItem.settingCard(
                        title = LocalStrings.current.controls.inputsEntrance,
                        icon = FluentIcons.toggleMultiple(getUIKitColors().textFillColorPrimaryBrush, true),
                        onClick = {
                            MainViewModel.navigation.switchPage(Pages.Controls_BasicInputs, type = UIKitNavigationType.Forward)
                        }
                    ),
                    UIKitCardItem.divider(),
                    UIKitCardItem.settingCard(
                        title = LocalStrings.current.controls.statusAndInfosEntrance,
                        icon = FluentIcons.chatMultiple(getUIKitColors().textFillColorPrimaryBrush, true),
                        onClick = {
                            MainViewModel.navigation.switchPage(Pages.Controls_StatusAndInfo, type = UIKitNavigationType.Forward)
                        }
                    ),
                    UIKitCardItem.divider(),
                    UIKitCardItem.settingCard(
                        title = LocalStrings.current.controls.flyoutsEntrance,
                        icon = FluentIcons.layerDiagonal(getUIKitColors().textFillColorPrimaryBrush, true),
                        onClick = {
                            MainViewModel.navigation.switchPage(Pages.Controls_Flyouts, type = UIKitNavigationType.Forward)
                        }
                    ),
                    UIKitCardItem.divider(),
                    UIKitCardItem.settingCard(
                        title = LocalStrings.current.controls.layoutsEntrance,
                        icon = FluentIcons.LayoutDynamic,
                        onClick = {
                            MainViewModel.navigation.switchPage(Pages.Controls_Layouts, type = UIKitNavigationType.Forward)
                        }
                    )
                )
            )
        }
    }
}