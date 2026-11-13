package com.millentec.compose.uikit.foundation.helper

import com.millentec.compose.uikit.symbols.draw.UIKitSymbolSelector

fun <V> Map<UIKitSymbolSelector, V>.matchSelector(selector: UIKitSymbolSelector): Map.Entry<UIKitSymbolSelector, V>? {
    return this.entries.firstOrNull {
        (it.key.symbol == selector.symbol || it.key.symbol == null)
                && (it.key.layer == selector.layer || it.key.layer == null)
                && (it.key.group == selector.group || it.key.group == null)
    }
}