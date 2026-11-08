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
        predicate: (Pair<String, UIKitSymbol>) -> Boolean
    ): Boolean {
        return suppliers.entries.any { predicate(Pair(it.key, it.value.invoke(pool))) }
    }

    fun all(
        pool: UIKitSymbolPool,
        predicate: (Pair<String, UIKitSymbol>) -> Boolean
    ): Boolean {
        return suppliers.entries.all { predicate(Pair(it.key, it.value.invoke(pool))) }
    }

    fun contains(key: String): Boolean {
        return suppliers.containsKey(key)
    }

    fun forEach(
        pool: UIKitSymbolPool,
        action: (Pair<String, UIKitSymbol>) -> Unit
    ) {
        suppliers.entries.forEach { action(Pair(it.key, it.value.invoke(pool))) }
    }

    fun filter(
        pool: UIKitSymbolPool,
        predicate: (Pair<String, UIKitSymbol>) -> Boolean
    ): Map<String, UIKitSymbol> {
        return suppliers.entries
            .filter { predicate(Pair(it.key, it.value.invoke(pool))) }
            .associate { Pair(it.key, it.value.invoke(pool)) }
    }

    fun <T> map(
        pool: UIKitSymbolPool,
        transform: (Pair<String, UIKitSymbol>) -> T
    ): List<T> {
        return suppliers.entries
            .map { transform(Pair(it.key, it.value.invoke(pool))) }
    }
}