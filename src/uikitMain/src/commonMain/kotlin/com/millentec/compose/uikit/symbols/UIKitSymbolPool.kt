package com.millentec.compose.uikit.symbols

/**
 * 符号池, UIKit Symbols 内置符号采用懒加载, 当首次调用符号后会将符号创建缓存于 [UIKitSymbolPool]
 *
 * [UIKitSymbolPool.Default] 或 [UIKitSymbols] 是默认的全局符号池, 若你需要临时调用符号或遍历符号, 不希望符号被全局缓存, 可以创建一个新的符号池使它能在使用后被回收
 *
 * 请注意, 不要将除 [UIKitSymbolPool.Default] 之外的你创建的符号池或其中的符号赋值给`对象`, `全局单例`或其他**长生命周期作用域** , 否则符号可能无法被正确回收, 你应该在局部内调用你创建的符号池
 *
 * ## 泄漏影响范围:
 * - 若将整个 [UIKitSymbolPool] 实例或例如 [UIKitSymbolPool.media] 等子集 (其持有了 pool) 泄漏到外部, 会导致整个 pool 无法被回收
 * - 若将其下的某个特定符号泄漏到外部, 仅会导致该符号缓存无法被回收
 */
open class UIKitSymbolPool {
    val media = UIKitMediaSymbols()
    val systemUI = UIKitSystemUISymbols()
    val graphic = UIKitGraphicSymbols()
    val layout = UIKitLayoutSymbols()
    val language = UIKitLanguageSymbols()
    val arrow = UIKitArrowSymbols()
    val academic = UIKitAcademicSymbols()
    val objects = UIKitObjectsSymbols()

    companion object {
        val Default: UIKitSymbolPool
            get() = UIKitSymbols
    }
}