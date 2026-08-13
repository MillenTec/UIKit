package com.millentec.compose.uikit.symbols.animate

import androidx.compose.animation.core.AnimationSpec

class UIKitSymbolAnimTree {
    private val _tree: MutableList<MutableList<UIKitSymbolAnimNode>> = mutableListOf()
    val tree: List<List<UIKitSymbolAnimNode>>
        get() = _tree.toList()

    fun addParallel(other: UIKitSymbolAnimNode): UIKitSymbolAnimTree {
        if (_tree.isEmpty())
            addSequential(other)
        else
            _tree[_tree.size - 1].add(other)

        return this
    }

    fun addSequential(then: UIKitSymbolAnimNode): UIKitSymbolAnimTree {
        _tree.add(mutableListOf(then))
        return this
    }
}

data class UIKitSymbolAnimNode(
    val type: UIKitAnimSelector,
    val groupSelector: Int,
    val initialValue: Float,
    val targetValue: Float,
    val animateSpec: AnimationSpec<Float>
) {
    companion object {
        fun scaleIn(
            layerSelector: Int,
            initialValue: Float = 0f,
            animateSpec: AnimationSpec<Float>
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Scale,
                groupSelector = layerSelector,
                initialValue = initialValue,
                targetValue = 1f,
                animateSpec = animateSpec
            )
        }

        fun scaleOut(
            layerSelector: Int,
            targetValue: Float = 0f,
            animateSpec: AnimationSpec<Float>
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Scale,
                groupSelector = layerSelector,
                initialValue = 1f,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun fadeIn(
            layerSelector: Int,
            initialValue: Float = 0f,
            animateSpec: AnimationSpec<Float>
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Alpha,
                groupSelector = layerSelector,
                initialValue = initialValue,
                targetValue = 1f,
                animateSpec = animateSpec
            )
        }

        fun fadeOut(
            layerSelector: Int,
            targetValue: Float = 0f,
            animateSpec: AnimationSpec<Float>
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Alpha,
                groupSelector = layerSelector,
                initialValue = 1f,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }
    }
}