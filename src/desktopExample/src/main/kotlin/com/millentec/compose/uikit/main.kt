package com.millentec.compose.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.millentec.compose.uikit.component.UIKitTitleBar
import com.millentec.compose.uikit.foundation.helper.LocalUIKitClientAreaHelper
import com.millentec.compose.uikit.foundation.helper.UIKitClientAreaHelper
import com.millentec.compose.uikit.theme.*

fun main() = application {
    val windowState = rememberWindowState()

    Window(
        onCloseRequest = ::exitApplication,
        title = "UIKit Gallery",
        state = windowState,
    ) {
        UIKitThemeHost(
            when (AppTheme.theme.collectAsState().value) {
                ThemeType.System -> if (isSystemInDarkTheme()) UIKitTheme.getDark() else UIKitTheme.getLight()
                ThemeType.Light -> UIKitTheme.getLight()
                ThemeType.Dark -> UIKitTheme.getDark()
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(getUIKitColors().contentFillColorPrimaryBrush)
            ) {
                val helper = remember { UIKitClientAreaHelper() }

                UIKitTitleBar(
                    title = "UIKit Gallery",
                    windowState = windowState,
                    areaHelper = helper,
                    onCloseRequest = ::exitApplication,
                )
                CompositionLocalProvider(LocalUIKitClientAreaHelper provides helper) {
                    App()
                }
            }
        }
    }
}