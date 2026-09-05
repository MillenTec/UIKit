package com.millentec.compose.uikit.symbols.animate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.animate.UIKitAnimSelector.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.uuid.Uuid

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
                        AlphaAddition -> state.alphaAdditionState
                        PathTrimStart -> state.pathTrimStartState
                        PathTrimEnd -> state.pathTrimEndState
                        ScaleCenterX -> state.scaleCenterXState
                        ScaleCenterY -> state.scaleCenterYState
                        Rotate -> state.rotateState
                        RotateCenterX -> state.scaleCenterXState
                        RotateCenterY -> state.scaleCenterYState
                        TranslateX -> state.translateXState
                        TranslateY -> state.translateYState
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
class UIKitSymbolEffect {
    private val _effects = mutableListOf<UIKitSymbolEffectNode>()
    internal val effects: List<UIKitSymbolEffectNode>
        get() = _effects.toList()

    internal fun addEffect(effect: UIKitSymbolEffectNode) {
        _effects.add(effect)
    }

    internal fun addEffects(symbolEffect: UIKitSymbolEffect) {
        _effects.addAll(symbolEffect.effects)
    }
}

internal sealed class UIKitSymbolEffectNode {
    /**
     * 离散效果, 当 trigger 变动时触发一次 execute
     * @param triggerCurrent 当前的触发器值
     * @param initializable 此效果是否能被初始化, 若为 true 则会在首次启动时触发 initialize Lambda, 若为 false 则不会在首次启动执行任何任务
     * @param initialize 初始化 Lambda
     * @param execute 单次动画执行的 Lambda
     */
    class UIKitDiscreteEffectNode<T>(
        val uuid: String,
        val triggerCurrent: T,
        val repeat: Int,
        val initializable: Boolean,
        val initialize: (suspend (
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) -> Unit)?,
        val execute: suspend (
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) -> Unit
    ): UIKitSymbolEffectNode()

    /**
     * 无限效果, 当 isActive 为 true 时会始终播放
     * @param isActive 效果是否激活
     * @param start 动画启动执行 Lambda
     * @param execute 单个动画周期的执行 Lambda
     * @param reset 当 isActive 为 false 时, 使图标动画属性回归默认的执行 Lambda
     */
    class UIKitInfiniteEffectNode(
        val uuid: String,
        val isActive: Boolean,
        val start: suspend (
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) -> Unit,
        val execute: suspend (
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) -> Unit,
        val reset: suspend (
            symbol: UIKitSymbol,
            states: List<UIKitSymbolAnimState>
        ) -> Unit
    ): UIKitSymbolEffectNode()

    object UIKitEmptyEffectNode: UIKitSymbolEffectNode()
}

fun UIKitSymbolEffect.emptyEffect(): UIKitSymbolEffect {
    this.addEffect(UIKitSymbolEffectNode.UIKitEmptyEffectNode)
    return this
}

@Composable
fun <T> UIKitSymbolEffect.customEffect(
    trigger: T,
    tree: UIKitSymbolAnimTree,
    repeat: Int = 1,
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        triggerCurrent = trigger,
        repeat = repeat,
        initializable = false,
        initialize = null,
        execute = { _, states ->
            standardExecute(tree, states)
        }
    ))

    return this
}

@Composable
fun <T> UIKitSymbolEffect.customEffect(
    trigger: T,
    tree: UIKitSymbolAnimTree,
    repeat: Int = 1,
    initializable: Boolean
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        repeat = repeat,
        triggerCurrent = trigger,
        initializable = initializable,
        initialize = { _, states ->
            standardExecute(tree, states, true)
        },
        execute = { _, states ->
            standardExecute(tree, states)
        }
    ))

    return this
}

@Composable
fun <T> UIKitSymbolEffect.customEffect(
    trigger: T,
    tree: UIKitSymbolAnimTree,
    repeat: Int = 1,
    initialize: suspend (
        symbol: UIKitSymbol,
        states: List<UIKitSymbolAnimState>
    ) -> Unit
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        repeat = repeat,
        triggerCurrent = trigger,
        initializable = true,
        initialize = initialize,
        execute = { _, states ->
            standardExecute(tree, states)
        }
    ))

    return this
}

@Composable
fun UIKitSymbolEffect.customInfiniteEffect(
    isActive: Boolean,
    tree: UIKitSymbolInfiniteAnimTree,
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitInfiniteEffectNode(
        uuid = uuid,
        isActive = isActive,
        start = { _, states ->
            standardExecute(tree.start, states)
        },
        execute = { _, states ->
            standardExecute(tree.body, states)
        },
        reset = { _, states ->
            standardExecute(tree.end, states)
        }
    ))

    return this
}

@Composable
fun UIKitSymbolEffect.visibleEffect(
    visible: Boolean
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        triggerCurrent = visible,
        repeat = 1,
        initializable = true,
        initialize = { symbol, states ->
            val appearTree = symbol.appearEffect(states)
            val disappearTree = symbol.disappearEffect(states)

            if (visible && appearTree != null) {
                standardExecute(appearTree, states, true)
            } else if (!visible && disappearTree != null) {
                standardExecute(disappearTree, states, true)
            }
        },
        execute = { symbol, states ->
            val appearTree = symbol.appearEffect(states)
            val disappearTree = symbol.disappearEffect(states)

            if (visible && appearTree != null) {
                standardExecute(appearTree, states)
            } else if (!visible && disappearTree != null) {
                standardExecute(disappearTree, states)
            }
        },
    ))

    return this
}

@Composable
fun UIKitSymbolEffect.stateEffect(
    state: String
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        triggerCurrent = state,
        repeat = 1,
        initializable = true,
        initialize = { symbol, states ->
            val stateTree = symbol.stateEffect(state, states)
            stateTree?.let {
                standardExecute(it, states, true)
            }
        },
        execute = { symbol, states ->
            val stateTree = symbol.stateEffect(state, states)
            stateTree?.let {
                standardExecute(it, states)
            }
        },
    ))

    return this
}

@Composable
fun UIKitSymbolEffect.bounceEffect(
    trigger: Any,
    coefficient: Float = 1f,
    repeat: Int = 1,
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        triggerCurrent = trigger,
        repeat = repeat,
        initializable = false,
        initialize = null,
        execute = { symbol, states ->
            val bounceTree = symbol.bounceEffect(states, coefficient)

            bounceTree?.let {
                standardExecute(it, states)
            }
        }
    ))

    return this
}

@Composable
fun UIKitSymbolEffect.progressibleEffect(
    progress: Float
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }
    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        triggerCurrent = progress,
        repeat = 1,
        initializable = true,
        initialize = { symbol, states ->
            val progressibleTree = symbol.progressibleEffect(progress, states)

            progressibleTree?.let {
                standardExecute(it, states, true)
            }
        },
        execute = { symbol, states ->
            val progressibleTree = symbol.progressibleEffect(progress, states)

            progressibleTree?.let {
                standardExecute(it, states)
            }
        }
    ))

    return this
}

@Composable
fun UIKitSymbolEffect.variableColorEffect(
    isActive: Boolean,
    initialValue: Float = 0.3f,
    targetValue: Float = 1f
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitInfiniteEffectNode(
        uuid = uuid,
        isActive = isActive,
        start = { symbol, states ->
            val tree = symbol.variableColorEffect(states, initialValue, targetValue)

            tree?.let {
                standardExecute(it.start, states)
            }
        },
        execute = { symbol, states ->
            val tree = symbol.variableColorEffect(states, initialValue, targetValue)

            tree?.let {
                standardExecute(it.body, states)
            }
        },
        reset = { symbol, states ->
            val tree = symbol.variableColorEffect(states, initialValue, targetValue)

            tree?.let {
                standardExecute(it.end, states)
            }
        }
    ))

    return this
}

@Composable
fun UIKitSymbolEffect.variableColorEffect(
    trigger: Any,
    repeat: Int = 1,
    initialValue: Float = 0.3f,
    targetValue: Float = 1f
): UIKitSymbolEffect {
    val uuid = remember { Uuid.random().toString() }

    this.addEffect(UIKitSymbolEffectNode.UIKitDiscreteEffectNode(
        uuid = uuid,
        triggerCurrent = trigger,
        repeat = repeat,
        initializable = false,
        initialize = null,
        execute = { symbol, states ->
            val tree = symbol.variableColorEffect(states, initialValue, targetValue)

            tree?.let {
                standardExecute(it.start, states)
                standardExecute(it.body, states)
                standardExecute(it.end, states)
            }
        }
    ))

    return this
}

fun UIKitSymbolEffect.then(effect: UIKitSymbolEffect): UIKitSymbolEffect {
    this.addEffects(effect)
    return this
}