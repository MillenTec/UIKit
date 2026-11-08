package com.millentec.compose.uikit.symbols

class UIKitSymbolSet internal constructor(
    private val suppliers: Map<String, (pool: UIKitSymbolPool) -> UIKitSymbol>
) {
    internal constructor(vararg suppliers: Pair<String, (pool: UIKitSymbolPool) -> UIKitSymbol>) : this(suppliers.toMap())

    fun get(
        key: String,
        pool: UIKitSymbolPool
    ): UIKitSymbol? {
        return suppliers[key]?.invoke(pool)
    }

    val size: Int
        get() = suppliers.size

    fun isEmpty(): Boolean {
        return suppliers.isEmpty()
    }

    fun any(): Boolean {
        return !isEmpty()
    }

    fun any(
        pool: UIKitSymbolPool,
        predicate: (String, UIKitSymbol) -> Boolean
    ): Boolean {
        return suppliers.entries.any { predicate(it.key, it.value.invoke(pool)) }
    }

    fun all(
        pool: UIKitSymbolPool,
        predicate: (key: String, symbol: UIKitSymbol) -> Boolean
    ): Boolean {
        return suppliers.entries.all { predicate(it.key, it.value.invoke(pool)) }
    }

    fun contains(key: String): Boolean {
        return suppliers.containsKey(key)
    }

    fun forEach(
        pool: UIKitSymbolPool,
        action: (key: String, symbol: UIKitSymbol) -> Unit
    ) {
        suppliers.entries.forEach { action(it.key, it.value.invoke(pool)) }
    }

    fun filter(
        pool: UIKitSymbolPool,
        predicate: (key: String, symbol: UIKitSymbol) -> Boolean
    ): Map<String, UIKitSymbol> {
        return suppliers.entries
            .filter { predicate(it.key, it.value.invoke(pool)) }
            .associate { Pair(it.key, it.value.invoke(pool)) }
    }

    fun firstOrNull(
        pool: UIKitSymbolPool,
        predicate: (key: String, symbol: UIKitSymbol) -> Boolean
    ): UIKitSymbol? {
        return suppliers.entries
            .firstOrNull { predicate(it.key, it.value.invoke(pool)) }
            ?.value
            ?.invoke(pool)
    }

    fun <T> map(
        pool: UIKitSymbolPool,
        transform: (key: String, symbol: UIKitSymbol) -> T
    ): List<T> {
        return suppliers.entries
            .map { transform(it.key, it.value.invoke(pool)) }
    }
}