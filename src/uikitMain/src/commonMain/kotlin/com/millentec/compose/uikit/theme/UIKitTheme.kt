package com.millentec.compose.uikit.theme

import androidx.compose.runtime.compositionLocalOf

/**
 * UIKitTheme 主题内容
 * @param typography 字体排版相关属性
 * @param colors 颜色主题
 */
data class UIKitTheme(
    val typography: UIKitTypography = UIKitTypography(),
    val colors: UIKitColors = UIKitColors.getLight(),
    val shapes: UIKitShapes = UIKitShapes(),
    val layout: UIKitLayout = UIKitLayout(),
    val animate: UIKitAnimate = UIKitAnimate(),
    val materials: UIKitMaterials = UIKitMaterials.getLight()
) {

    /**
     * UIKitTheme 主题管理
     */
    companion object {
        /**
         * 当前的主题实例
         */
        val themeCurrent = compositionLocalOf { UIKitTheme() }
    }
}