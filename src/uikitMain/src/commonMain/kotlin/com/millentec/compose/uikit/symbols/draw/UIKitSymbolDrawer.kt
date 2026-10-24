package com.millentec.compose.uikit.symbols.draw

import com.millentec.compose.uikit.symbols.UIKitSymbol
import com.millentec.compose.uikit.symbols.animate.UIKitSymbolGroupState

@DslMarker
annotation class UIKitSymbolDsl

/**
 * UIKitSymbol 绘制的最小单元
 * @param zIndex 第一个为 layer 上的次序, 第二个为该 group 在上层 layer 上的次序
 * @param drawType 路径的绘制方式
 * @param defaultState 路径的默认属性
 * @param path 路径元信息
 */
data class UIKitSymbolPathGroup(
    val zIndex: Pair<Int, Int>,
    val drawType: UIKitPathDrawType,
    val defaultState: UIKitSymbolGroupState,
    val path: UIKitPath
)
// UIKitSymbol 内的 onDraw 是这个接口的 Scope
// UIKitSymbol 的 groups getter 内创建 Impl 并在 Impl 内执行 onDraw 时是 Impl 的函数实现
/**
 * UIKitSymbol 绘制层
 */
@UIKitSymbolDsl
interface UIKitSymbolDrawer {
    /**
     * 添加一个层 (着色的最小分组单位)
     * @param id 层 ID, 在该 Symbol 内应当具备唯一性
     * @param zIndex 纵向深度, 决定层的排列顺序
     * @param drawScope 层内的绘制
     */
    fun addLayer(
        id: String,
        zIndex: Int = 0,
        drawScope: UIKitSymbolLayerDrawer.() -> Unit
    )
}

/**
 * UIKitSymbol 绘制层
 */
@UIKitSymbolDsl
interface UIKitSymbolLayerDrawer {
    /**
     * 添加一个组 (动画的最小单位)
     * @param id 组 ID, 在该 Layer 内应当具备唯一性
     * @param zIndex 纵向深度, 决定组在当前层内的排列顺序
     * @param drawType 路径的绘制方式
     * @param defaultState 路径的默认属性
     * @param drawScope 路径绘制
     */
    fun addGroup(
        id: String,
        zIndex: Int = 0,
        drawType: UIKitPathDrawType,
        defaultState: UIKitSymbolGroupState = UIKitSymbolGroupState(),
        drawScope: UIKitPath.() -> Unit
    )
}

internal class UIKitSymbolDrawerImpl(
    val symbolId: String
): UIKitSymbolDrawer {
    constructor(symbol: UIKitSymbol): this(symbol.uid)

    private val _groups: MutableMap<UIKitSymbolSelector, UIKitSymbolPathGroup> = mutableMapOf()
    val groups: Map<UIKitSymbolSelector, UIKitSymbolPathGroup>
        get() = _groups.toMap()

    override fun addLayer(
        id: String,
        zIndex: Int,
        drawScope: UIKitSymbolLayerDrawer.() -> Unit
    ) {
        val scope = UIKitSymbolLayerDrawerImpl(symbolId, id, zIndex).apply(drawScope)
        _groups.putAll(scope.collectGroups())
    }
}

internal class UIKitSymbolLayerDrawerImpl(
    val symbolId: String,
    val layerId: String,
    val zIndex: Int,
): UIKitSymbolLayerDrawer {
    // 这里实际暂存 groups, 等待上层索取并扁平化存储
    private val _groups: MutableMap<UIKitSymbolSelector, UIKitSymbolPathGroup> = mutableMapOf()

    fun collectGroups(): Map<UIKitSymbolSelector, UIKitSymbolPathGroup> {
        return _groups.toMap()
    }

    override fun addGroup(
        id: String,
        zIndex: Int,
        drawType: UIKitPathDrawType,
        defaultState: UIKitSymbolGroupState,
        drawScope: UIKitPath.() -> Unit
    ) {
        _groups[UIKitSymbolSelector(symbolId, layerId, id)] = UIKitSymbolPathGroup(
            zIndex = Pair(this.zIndex, zIndex),
            drawType = drawType,
            defaultState = defaultState,
            path = UIKitPath().apply(drawScope)
        )
    }
}