package com.millentec.compose.uikit.component.flyout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf

internal open class UIKitFlyoutSlot {
    @Composable
    open fun Content() {}
}

internal class UIKitFlyoutManager {
    val flyouts = mutableStateListOf<Pair<Int, UIKitFlyoutSlot>>()

    private var flyoutId = -1

    fun clear() {
        flyouts.clear()
    }

    fun add(content: UIKitFlyoutSlot): Int {
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