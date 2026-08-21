package com.millentec.compose.uikit.foundation.layout

import androidx.compose.runtime.Composable

abstract class UIKitItem {
    @Composable
    abstract fun Content()
}

open class UIKitItemScope<T> {
    private val _items = mutableListOf<T>()
    val items: List<T>
        get() = _items.toList()

    fun add(item: T): Boolean {
        return _items.add(item)
    }

    fun remove(item: T): Boolean {
        return _items.remove(item)
    }
}