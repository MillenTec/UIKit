package com.millentec.compose.uikit.symbols.animate

import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.animate.UIKitAnimSelector.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

private suspend fun standardExecute(
    tree: UIKitSymbolAnimTree,
    states: List<UIKitSymbolAnimState>,
    snapTo: Boolean = false
) {
    tree.tree.forEach { sequential ->
        coroutineScope {
            sequential.forEach { parallel ->
                launch {
                    val state = states.firstOrNull {
                        it.id == parallel.groupSelector
                    } ?: return@launch

                    val animatableState = when (parallel.type) {
                        Empty -> return@launch
                        Scale -> state.scaleState
                        Alpha -> state.alphaState
                        PathTrimStart -> state.pathTrimStartState
                        PathTrimEnd -> state.pathTrimEndState
                    }

                    if (snapTo || parallel.animateSpec == null) {
                        animatableState.snapTo(parallel.targetValue)
                    } else {
                        animatableState.animateTo(
                            targetValue = parallel.targetValue,
                            animationSpec = parallel.animateSpec
                        )
                    }
                }
            }
        }
    }
}

open class UIKitSymbolEffect {
    private val _effects = mutableListOf<UIKitSymbolEffect>()
    val effects: List<UIKitSymbolEffect>
        get() = _effects.toList()

    fun addEffect(effect: UIKitSymbolEffect) {
        _effects.add(effect)
    }

    open val triggerCurrent: Any? = null
    open val initializable: Boolean = false

    open suspend fun execute(
        symbol: UIKitSymbol,
        states: List<UIKitSymbolAnimState>
    ) {}

    open suspend fun initialize(
        symbol: UIKitSymbol,
        states: List<UIKitSymbolAnimState>
    ) {}
}

object UIKitEmptyEffect: UIKitSymbolEffect()

fun UIKitSymbolEffect.customEffect(
    trigger: Any,
    tree: UIKitSymbolAnimTree,
): UIKitSymbolEffect {
    this.addEffect(object: UIKitSymbolEffect() {
        override val triggerCurrent = trigger
        override val initializable: Boolean = false

        override suspend fun execute(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            standardExecute(tree, states)
        }
    })

    return this
}

fun UIKitSymbolEffect.customEffect(
    trigger: Any,
    tree: UIKitSymbolAnimTree,
    initialize: suspend (
        symbol: UIKitSymbol,
        states: List<UIKitSymbolAnimState>
    ) -> Unit
): UIKitSymbolEffect {
    this.addEffect(object: UIKitSymbolEffect() {
        override val triggerCurrent = trigger
        override val initializable: Boolean = true

        override suspend fun execute(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            standardExecute(tree, states)
        }

        override suspend fun initialize(symbol: UIKitSymbol, states: List<UIKitSymbolAnimState>) {
            initialize(symbol, states)
        }
    })

    return this
}

fun UIKitSymbolEffect.visibleEffect(visible: Boolean): UIKitSymbolEffect {
    this.addEffect(object: UIKitSymbolEffect() {
        override val triggerCurrent = visible
        override val initializable: Boolean = true

        override suspend fun execute(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            val appearTree = symbol.appearEffect()
            val disappearTree = symbol.disappearEffect()

            if (triggerCurrent && appearTree != null) {
                standardExecute(appearTree, states)
            } else if (!triggerCurrent && disappearTree != null) {
                standardExecute(disappearTree, states)
            }
        }

        override suspend fun initialize(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            val appearTree = symbol.appearEffect()
            val disappearTree = symbol.disappearEffect()

            if (triggerCurrent && appearTree != null) {
                standardExecute(appearTree, states, true)
            } else if (!triggerCurrent && disappearTree != null) {
                standardExecute(disappearTree, states, true)
            }
        }
    })

    return this
}

fun UIKitSymbolEffect.disableEffect(enabled: Boolean): UIKitSymbolEffect {
    this.addEffect(object: UIKitSymbolEffect() {
        override val triggerCurrent = enabled
        override val initializable: Boolean = true

        override suspend fun execute(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            val enableTree = symbol.enableEffect()
            val disableTree = symbol.disableEffect()

            if (triggerCurrent && enableTree != null) {
                standardExecute(enableTree, states)
            } else if (!triggerCurrent && disableTree != null) {
                standardExecute(disableTree, states)
            }
        }

        override suspend fun initialize(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            val enableTree = symbol.enableEffect()
            val disableTree = symbol.disableEffect()

            if (triggerCurrent && enableTree != null) {
                standardExecute(enableTree, states, true)
            } else if (!triggerCurrent && disableTree != null) {
                standardExecute(disableTree, states, true)
            }
        }
    })

    return this
}

fun UIKitSymbolEffect.then(effect: UIKitSymbolEffect): UIKitSymbolEffect {
    if (effect is UIKitEmptyEffect) return this

    this.addEffect(effect)
    return this
}