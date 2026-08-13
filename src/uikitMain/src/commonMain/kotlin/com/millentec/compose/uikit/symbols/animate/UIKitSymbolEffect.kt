package com.millentec.compose.uikit.symbols.animate

import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.animate.UIKitAnimSelector.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

private suspend fun standardExecute(
    tree: UIKitSymbolAnimTree,
    states: List<Pair<Int, UIKitSymbolAnimState>>
) {
    tree.tree.forEach { sequential ->
        coroutineScope {
            sequential.forEach { parallel ->
                launch {
                    val state = states.firstOrNull {
                        it.first == parallel.groupSelector
                    }?.second ?: return@launch

                    when (parallel.type) {
                        Empty -> return@launch
                        Scale -> {
                            state.scaleState.animateTo(
                                targetValue = parallel.targetValue,
                                animationSpec = parallel.animateSpec
                            )
                        }
                        Alpha -> {
                            state.alphaState.animateTo(
                                targetValue = parallel.targetValue,
                                animationSpec = parallel.animateSpec
                            )
                        }
                    }

                    println(state.alphaState.value)
                }
            }
        }
    }
}

interface UIKitSymbolEffect {
    suspend fun Execute(
        symbol: UIKitSymbol,
        states: List<Pair<Int, UIKitSymbolAnimState>>
    )

    companion object: UIKitSymbolEffect {
        override suspend fun Execute(
            symbol: UIKitSymbol,
            states: List<Pair<Int, UIKitSymbolAnimState>>
        ) {}
    }
}

private class CombinedEffect: UIKitSymbolEffect {
    private val _effects: MutableList<UIKitSymbolEffect> = mutableListOf()
    val effects: List<UIKitSymbolEffect> get() = _effects.toList()

    fun addEffect(effect: UIKitSymbolEffect) {
        _effects.add(effect)
    }

    override suspend fun Execute(symbol: UIKitSymbol, states: List<Pair<Int, UIKitSymbolAnimState>>) {
        _effects.forEach { effect ->
            effect.Execute(symbol, states)
        }
    }
}

private fun asCombinedEffect(effect: UIKitSymbolEffect): CombinedEffect {
    return effect as? CombinedEffect ?: CombinedEffect().also { it.addEffect(effect) }
}

fun UIKitSymbolEffect.visibleEffect(visible: Boolean): UIKitSymbolEffect {
    val combined = asCombinedEffect(this)

    combined.addEffect(object : UIKitSymbolEffect {
        override suspend fun Execute(
            symbol: UIKitSymbol,
            states: List<Pair<Int, UIKitSymbolAnimState>>
        ) {
            val appearTree = symbol.appearEffect()
            val disappearTree = symbol.disappearEffect()

            if (visible) {
                standardExecute(appearTree, states)
            } else {
                standardExecute(disappearTree, states)
            }
        }
    })

    return combined
}