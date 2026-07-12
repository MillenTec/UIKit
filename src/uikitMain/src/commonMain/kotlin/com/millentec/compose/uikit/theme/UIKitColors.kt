package com.millentec.compose.uikit.theme

import androidx.compose.ui.graphics.Color

/**
 * UIKitTheme 主题的颜色部分, 默认为亮色主题, 使用 getDark() 方法获取默认的暗色主题
 */
data class UIKitColors(
    /**
     * 一般可用于应用程序的窗口背景颜色
     */
    val contentFillColorPrimaryBrush: Color = Color(0xFFFFFFFF),

    /**
     * 一般用于卡片等容器背景颜色
     */
    val contentFillColorSecondaryBrush: Color = Color(0xFFF5F5F7),

    val contentFillColorTertiaryBrush: Color = Color(0xFFE8E8ED),

    val contentFillColorFourthBrush: Color = Color(0xFF666668),

    val contentFillColorBrushDisabled: Color = Color(0xFFEFEFF2),

    /**
     * 用于普通正文的颜色
     */
    val textFillColorPrimaryBrush: Color = Color(0xFF1D1D1F),

    val textFillColorPrimaryBrushReversed: Color = Color(0xFFF5F5F7),

    /**
     * 可用于副标题, 脚注, 不可用控件的文本颜色
     */
    val textFillColorSecondaryBrush: Color = Color(0xFF6E6E73),

    val textFillColorDisabled: Color = Color(0xFFB9B9BB),

    val lineFillColorPrimaryBrush: Color = Color(0xFFE8E8ED),

    val lineFillColorDisabled: Color = Color(0xFFB9B9BB),

    val highlightColorPrimaryBrush: Color = Color(0xFF0071E3),

    val highlightColorSecondaryBrush: Color = Color(0xAA0071E3),

    val highlightColorTertiaryBrush: Color = Color(0x6C0071E3),

    val highlightColorLightBrush: Color = Color(0x4C0071E3),

    val pointerHoverInteractionColor: Color = Color(0x2CB9B9BB),

    val pointerTapInteractionColor: Color = Color(0x2C6E6E73)
) {

    /**
     * UIKitTheme 主题的颜色部分, 默认为亮色主题, 使用 getDark() 方法获取默认的暗色主题
     */
    companion object {
        /**
         * 获取默认的亮色主题
         * @return 包含默认亮色主题的 UIKitColors 实例
         */
        fun getLight(): UIKitColors = UIKitColors()

        /**
         * 获取默认的暗色主题
         * @return 包含默认暗色主题的 UIKitColors 实例
         */
        fun getDark(): UIKitColors = UIKitColors(
            contentFillColorPrimaryBrush = Color(0xFF151517),
            contentFillColorSecondaryBrush = Color(0xFF1D1D1F),
            contentFillColorTertiaryBrush = Color(0xFF353537),
            contentFillColorFourthBrush = Color(0xFF7D7D7F),
            contentFillColorBrushDisabled = Color(0xFF2A2A2C),
            textFillColorPrimaryBrush = Color(0xFFF5F5F7),
            textFillColorPrimaryBrushReversed = Color(0xFF1D1D1F),
            textFillColorSecondaryBrush = Color(0xFF86868B),
            textFillColorDisabled = Color(0xFF4D4D4F),
            lineFillColorPrimaryBrush = Color(0xFF303032),
            lineFillColorDisabled = Color(0xFF4D4D4F),
            highlightColorPrimaryBrush = Color(0xFF0071E3),
            highlightColorSecondaryBrush = Color(0xAA0071E3),
            highlightColorTertiaryBrush = Color(0x6C0071E3),
            highlightColorLightBrush = Color(0x4C0071E3)
        )
    }
}
