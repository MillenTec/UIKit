package com.millentec.compose.uikit.component.flyout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

internal val LocalFlyouts = compositionLocalOf { UIKitFlyoutManager() }

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
                val id = it.first
                val host = it.second

                key(id) {
                    host.Content()
                }
            }
        }
    }
}