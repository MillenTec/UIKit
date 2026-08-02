package com.millentec.compose.uikit.component.flyout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf

internal class UIKitFlyoutManager {
    val flyouts = mutableStateListOf<Pair<Int, @Composable () -> Unit>>()

    private var flyoutId = -1

    fun clear() {
        flyouts.clear()
    }

    fun add(content: @Composable () -> Unit): Int {
        flyoutId++
        flyouts.add(Pair(flyoutId, content))
        return flyoutId
    }

    fun remove(id: Int): Boolean {
        val item = flyouts.firstOrNull {
            it.first == id
        }
        return flyouts.remove(item ?: return false)
    }

    fun raiseOnVisualTree(id: Int): Boolean {
        val item = flyouts.firstOrNull {
            it.first == id
        } ?: return false
        val result = flyouts.remove(item)
        if (result) {
            flyouts.add(Pair(item.first, item.second))
        }
        return result
    }
}