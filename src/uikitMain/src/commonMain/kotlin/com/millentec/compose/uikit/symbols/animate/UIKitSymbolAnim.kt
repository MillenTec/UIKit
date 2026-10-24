package com.millentec.compose.uikit.symbols.animate

import androidx.compose.animation.core.AnimationSpec
import com.millentec.compose.uikit.symbols.draw.UIKitSymbolSelector

class UIKitSymbolAnimTree {
    private val _tree: MutableList<MutableList<UIKitSymbolAnimNode>> = mutableListOf()
    val tree: List<List<UIKitSymbolAnimNode>>
        get() = _tree.toList()

    fun addParallel(other: UIKitSymbolAnimNode?): UIKitSymbolAnimTree {
        if (other == null) return this

        if (_tree.isEmpty())
            addSequential(other)
        else
            _tree[_tree.size - 1].add(other)

        return this
    }

    fun addSequential(then: UIKitSymbolAnimNode?): UIKitSymbolAnimTree {
        if (then == null) {
            _tree.add(mutableListOf())
            return this
        }

        _tree.add(mutableListOf(then))
        return this
    }
}

data class UIKitSymbolAnimNode(
    val type: UIKitAnimSelector,
    val selector: UIKitSymbolSelector,
    val targetValue: Float,
    val animateSpec: AnimationSpec<Float>?
) {
    companion object {
        fun scaleTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Scale,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun scaleAdditionTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.ScaleAddition,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun scaleAdditionCenterXTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.ScaleAdditionCenterX,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun scaleAdditionCenterYTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.ScaleAdditionCenterY,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun scaleCenterXTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.ScaleCenterX,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun scaleCenterYTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.ScaleCenterY,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        // Alpha 作为最常用的可叠加属性且常在 visible 中使用, 单个可控制 Alpha 属性不便于操作, 故新增一个可选的叠加层
        fun alphaAdditionTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.AlphaAddition,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun alphaTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Alpha,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun pathTrimStartTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.PathTrimStart,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun pathTrimEndTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.PathTrimEnd,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun rotateTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.Rotate,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun rotateCenterXTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.RotateCenterX,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun rotateCenterYTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.RotateCenterY,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun translateXTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.TranslateX,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }

        fun translateYTo(
            selector: UIKitSymbolSelector,
            targetValue: Float,
            animateSpec: AnimationSpec<Float>?
        ): UIKitSymbolAnimNode {
            return UIKitSymbolAnimNode(
                type = UIKitAnimSelector.TranslateY,
                selector = selector,
                targetValue = targetValue,
                animateSpec = animateSpec
            )
        }
    }
}

data class UIKitSymbolInfiniteAnimTree(
    val start: UIKitSymbolAnimTree,
    val body: UIKitSymbolAnimTree,
    val end: UIKitSymbolAnimTree,
)