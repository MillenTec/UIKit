package com.millentec.compose.uikit.symbols.draw

data class UIKitSymbolPathGroup(
    val id: Int,
    val drawType: UIKitPathDrawType,
    val path: UIKitPath
)

class UIKitSymbolLayer(
    val description: String? = null
) {
    private val _groups = mutableListOf<UIKitSymbolPathGroup>()
    val groups: List<UIKitSymbolPathGroup>
        get() = _groups.toList()

    /**
     * 创建一个组, 组是图标动画中的最小单位
     * @param id 组 ID, 在动画节点的组选择器中需使用 ID 来选择操作的组, 组 ID 应该具备唯一性(即使在多层中), 否则会使用找到的第一个符合的组 ID; 你应当使用正整数作为你的自定义组 ID, 部分负数可能作为内部预留 ID
     * @param drawType 该组以什么形式绘制 (描边, 填充, 或者裁切)
     * @param path 该组的路径信息
     */
    fun group(
        id: Int,
        drawType: UIKitPathDrawType,
        path: UIKitPath.() -> Unit
    ) {
        _groups.add(UIKitSymbolPathGroup(
            id = id,
            drawType = drawType,
            path = UIKitPath().apply(path)
        ))
    }
}