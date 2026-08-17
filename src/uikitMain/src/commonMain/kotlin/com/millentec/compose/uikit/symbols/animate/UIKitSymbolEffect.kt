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

/**
 * 你可以通过 UIKitSymbolEffect 为图标添加动态效果, 可以使用链式调用添加多个不同的效果
 */
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
        states: List<UIKitSymbolAnimState>,
    ) {}

    open suspend fun initialize(
        symbol: UIKitSymbol,
        states: List<UIKitSymbolAnimState>,
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

        override suspend fun initialize(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
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
            val appearTree = symbol.appearEffect(states)
            val disappearTree = symbol.disappearEffect(states)

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
            val appearTree = symbol.appearEffect(states)
            val disappearTree = symbol.disappearEffect(states)

            if (triggerCurrent && appearTree != null) {
                standardExecute(appearTree, states, true)
            } else if (!triggerCurrent && disappearTree != null) {
                standardExecute(disappearTree, states, true)
            }
        }
    })

    return this
}

fun UIKitSymbolEffect.stateEffect(
    state: String
): UIKitSymbolEffect {
    this.addEffect(object: UIKitSymbolEffect() {
        override val triggerCurrent = state
        override val initializable: Boolean = true

        override suspend fun initialize(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            val stateTree = symbol.stateEffect(state, states)
            stateTree?.let {
                standardExecute(it, states, true)
            }
        }

        override suspend fun execute(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            val stateTree = symbol.stateEffect(state, states)
            stateTree?.let {
                standardExecute(it, states)
            }
        }
    })

    return this
}

fun UIKitSymbolEffect.bounceEffect(trigger: Any): UIKitSymbolEffect {
    this.addEffect(object: UIKitSymbolEffect() {
        override val triggerCurrent = trigger
        override val initializable: Boolean = false

        override suspend fun execute(
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) {
            val bounceTree = symbol.bounceEffect(states)

            bounceTree?.let {
                standardExecute(it, states)
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