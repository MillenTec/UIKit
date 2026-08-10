package com.millentec.compose.uikit.views.pages

import androidx.compose.foundation.lazy.LazyListScope
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.foundation.CommonPage
import com.millentec.compose.uikit.foundation.Pages
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Symbols
import com.millentec.compose.uikit.theme.LocalStrings
import com.millentec.compose.uikit.viewmodels.MainViewModel

class Designs: CommonPage("designs") {
    override fun LazyListScope.lazyContent() {
        item {
            UIKitSettingCard(
                icon = FluentIcons.Symbols,
                title = LocalStrings.current.designs.fluentIconsEntrance,
                onClick = {
                    MainViewModel.navigation.switchPage(Pages.Icons.ordinal, type = UIKitNavigationType.Forward)
                }
            )
        }
    }
}