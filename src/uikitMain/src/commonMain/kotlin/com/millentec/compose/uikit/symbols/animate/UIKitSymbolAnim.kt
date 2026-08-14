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
    val groupSelector: String,
    val targetValue: Float,
    val animateSpec: AnimationSpec<Float>?
) {
    companion object {
        fun scaleTo(
            groupSelector: String,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Scale,
                groupSelector = groupSelector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun alphaTo(
            groupSelector: String,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Alpha,
                groupSelector = groupSelector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun pathTrimStartTo(
            groupSelector: String,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.PathTrimStart,
                groupSelector = groupSelector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun pathTrimEndTo(
            groupSelector: String,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.PathTrimEnd,
                groupSelector = groupSelector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }
    }
}