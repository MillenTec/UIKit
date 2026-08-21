package com.millentec.compose.uikit.views.pages.controls

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
import com.millentec.compose.uikit.theme.LocalStrings
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.views.LocalNavigationDockHeight

@Composable
@Preview
fun ControlsBasicInputsPage() {
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
                text = LocalStrings.current.controls.inputs.title,
                style = getUIKitTypography().largeTitle,
                color = getUIKitColors().textFillColorPrimaryBrush
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().titleSpacing))
        }

        item {
            UIKitGroupedCard {
                BasicInputControls.forEachIndexed { index, item ->
                    SettingCard(
                        title = when (item.page) {
                            Pages.Controls_BasicInputs_Button -> LocalStrings.current.controls.inputs.buttonEntrance
                            Pages.Controls_BasicInputs_ToggleButton -> LocalStrings.current.controls.inputs.toggleButtonEntrance
                            Pages.Controls_BasicInputs_ToggleSwitch -> LocalStrings.current.controls.inputs.toggleSwitchEntrance
                            else -> "Unknown"
                        },
                        onClick = {
                            MainViewModel.navigation.switchPage(item.page, type = UIKitNavigationType.Forward)
                        }
                    )

                    if (index != BasicInputControls.size - 1) {
                        Divider()
                    }
                }
            }
        }
    }
}