package com.millentec.compose.uikit.symbols.draw

data class UIKitSymbolPathGroup(
    val id: String,
    val drawType: UIKitPathDrawType,
    val zIndex: Int,
    val defaultState: UIKitSymbolGroupState,
    val path: UIKitPath
)

data class UIKitSymbolGroupState(
    val scale: Float = 1f,
    val alpha: Float = 1f,
    val pathTrimStart: Float = 0f,
    val pathTrimEnd: Float = 1f,
)

class UIKitSymbolLayer(
    val id: String
) {
    private val _groups = mutableListOf<UIKitSymbolPathGroup>()
    val groups: List<UIKitSymbolPathGroup>
        get() = _groups.toList()

    /**
     * 创建一个组, 组是图标动画中的最小单位
     * @param id 组 ID, 在动画节点的组选择器中需使用 ID 来选择操作的组, 组 ID 应该具备唯一性(即使在多层中), 否则会使用找到的第一个符合的组 ID;
     * 可能会有一些带 `sys.` 前缀的预留 ID, 你不应该使用它们, 同样也不应该使用 `unknown` 等字段作为你的 ID; 一般使用 `ext.` 前缀作为扩展层组的 ID
     * @param drawType 该组以什么形式绘制 (描边, 填充, 或者裁切)
     * @param path 该组的路径信息
     */
    fun group(
        id: String,
        drawType: UIKitPathDrawType,
        zIndex: Int = 0,
        defaultState: UIKitSymbolGroupState = UIKitSymbolGroupState(),
        path: UIKitPath.() -> Unit
    ) {
        _groups.add(UIKitSymbolPathGroup(
            id = id,
            drawType = drawType,
            zIndex = zIndex,
            defaultState = defaultState,
            path = UIKitPath().apply(path)
        ))
    }
}