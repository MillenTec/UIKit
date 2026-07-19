package com.millentec.compose.uikit.viewmodels

import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.navigation.UIKitNavigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object MainViewModel {
    val navigation = UIKitNavigation(
        initialPage = Pages.Home,
        homePage = Pages.Home,
    )

    private val _navigationDockVisible = MutableStateFlow(true)
    val navigationDockVisible = _navigationDockVisible.asStateFlow()

    fun navigationDockVisible(
        visible: Boolean,
    ) {
        _navigationDockVisible.value = visible
    }
}