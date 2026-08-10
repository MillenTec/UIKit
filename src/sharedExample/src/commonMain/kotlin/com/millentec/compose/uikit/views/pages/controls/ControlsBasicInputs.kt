package com.millentec.compose.uikit.views.pages.controls

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import com.millentec.compose.uikit.component.layout.UIKitSettingCard
import com.millentec.compose.uikit.foundation.CommonPage
import com.millentec.compose.uikit.foundation.UIKitNavigationType
import com.millentec.compose.uikit.foundation.getTitleById
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.viewmodels.MainViewModel
import com.millentec.compose.uikit.viewmodels.pageIndex

class ControlsBasicInputs: CommonPage(
    title = "controls_inputs",
    parent = 1
) {
    override fun LazyListScope.lazyContent() {
        items(BasicInputControls.size) { index ->
            UIKitSettingCard(
                title = getTitleById(BasicInputControls[index].id.value),
                onClick = {
                    MainViewModel.navigation.switchPage(pageIndex.withIndex().find {
                        it.value == BasicInputControls[index]
                    }?.index!!, type = UIKitNavigationType.Forward)
                }
            )

            if (index != BasicInputControls.size - 1) {
                Spacer(Modifier.height(getUIKitLayout().basicSpacing))
            }
        }
    }
}