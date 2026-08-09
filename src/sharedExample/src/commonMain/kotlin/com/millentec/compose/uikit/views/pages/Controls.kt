package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.foundation.CommonPage
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.LayoutDynamic
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.chatMultiple
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.layerDiagonal
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.toggleMultiple
import com.millentec.compose.uikit.theme.LocalStrings
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.viewmodels.MainViewModel

class Controls: CommonPage("controls") {
    override fun LazyListScope.lazyContent() {
        item {
            UIKitSettingCard(
                title = LocalStrings.current.controls.inputsEntrance,
                icon = FluentIcons.toggleMultiple(getUIKitColors().textFillColorPrimaryBrush, true),
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.ControlsBasicInputs.ordinal, type = UIKitNavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                title = LocalStrings.current.controls.statusAndInfosEntrance,
                icon = FluentIcons.chatMultiple(getUIKitColors().textFillColorPrimaryBrush, true),
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.ControlsStatusAndInfo.ordinal, type = UIKitNavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                title = LocalStrings.current.controls.flyoutsEntrance,
                icon = FluentIcons.layerDiagonal(getUIKitColors().textFillColorPrimaryBrush, true),
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.ControlsFlyouts.ordinal, type = UIKitNavigationType.Forward)
                }
            )
        }

        item {
            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                title = LocalStrings.current.controls.flyoutsEntrance,
                icon = FluentIcons.LayoutDynamic,
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.ControlsLayouts.ordinal, type = UIKitNavigationType.Forward)
                }
            )
        }
    }
}