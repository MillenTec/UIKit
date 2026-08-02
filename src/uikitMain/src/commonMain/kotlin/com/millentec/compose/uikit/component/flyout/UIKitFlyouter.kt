package com.millentec.compose.uikit.component.flyout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

internal val LocalFlyouts = compositionLocalOf<UIKitFlyoutManager> { error("Not UIKitFlyoutManager provided.") }

@Composable
fun UIKitFlyouter(
    content: @Composable () -> Unit
) {
    val flyoutManager = remember { UIKitFlyoutManager() }

    CompositionLocalProvider(LocalFlyouts provides flyoutManager) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            content()

            LocalFlyouts.current.flyouts.forEach {
                key(it.first) {
                    it.second()
                }
            }
        }
    }
}