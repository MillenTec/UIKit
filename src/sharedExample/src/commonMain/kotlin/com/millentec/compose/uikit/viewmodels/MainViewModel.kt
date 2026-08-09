package com.millentec.compose.uikit.viewmodels

import com.millentec.compose.uikit.navigation.UIKitNavigation
import com.millentec.compose.uikit.views.pages.*
import com.millentec.compose.uikit.views.pages.controls.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object MainViewModel {
    val navigation = UIKitNavigation(
        initialPage = 0,
        homePage = 0,
    )

    private val _navigationDockVisible = MutableStateFlow(true)
    val navigationDockVisible = _navigationDockVisible.asStateFlow()

    fun navigationDockVisible(
        visible: Boolean,
    ) {
        _navigationDockVisible.value = visible
    }
}

val pageIndex = listOf(
    Home(),
    Controls(),
    Designs(),
    Icons(),
    License(),
    ThirdParty(),
    Settings(),
    ControlsBasicInputs(),
    ControlsStatusAndInfo(),
    ControlsFlyouts(),
    ControlsLayouts()
) + BasicInputControls