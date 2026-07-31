package com.millentec.compose.uikit.theme

import androidx.compose.ui.graphics.Color

/**
 * UIKitTheme 主题的颜色部分, 默认为亮色主题, 使用 getDark() 方法获取默认的暗色主题
 */
data class UIKitColors(
    /**
     * 一般可用于应用程序的窗口背景颜色
     */
    val contentFillColorPrimaryBrush: Color = Color(0xFFF5F5F7),

    /**
     * 一般用于卡片等容器背景颜色
     */
    val contentFillColorSecondaryBrush: Color = Color(0xFFFFFFFF),

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

    val highlightColorSecondaryBrush: Color = highlightColorPrimaryBrush.copy(0.6f),

    val highlightColorTertiaryBrush: Color = highlightColorPrimaryBrush.copy(0.3f),

    val highlightColorFourthBrush: Color = highlightColorPrimaryBrush.copy(0.15f),

    val successGreenColorPrimaryBrush: Color = Color(0xFF34C759),

    val successGreenColorSecondaryBrush: Color = successGreenColorPrimaryBrush.copy(0.6f),

    val successGreenColorTertiaryBrush: Color = successGreenColorPrimaryBrush.copy(0.3f),

    val successGreenColorFourthBrush: Color = successGreenColorPrimaryBrush.copy(0.15f),

    val warningYellowColorPrimaryBrush: Color = Color(0xFFFFCC00),

    val warningYellowColorSecondaryBrush: Color = warningYellowColorPrimaryBrush.copy(0.6f),

    val warningYellowColorTertiaryBrush: Color = warningYellowColorPrimaryBrush.copy(0.3f),

    val warningYellowColorFourthBrush: Color = warningYellowColorPrimaryBrush.copy(0.15f),

    val errorRedColorPrimaryBrush: Color = Color(0xFFFF383C),

    val errorRedColorSecondaryBrush: Color = errorRedColorPrimaryBrush.copy(0.6f),

    val errorRedColorTertiaryBrush: Color = errorRedColorPrimaryBrush.copy(0.3f),

    val errorRedColorFourthBrush: Color = errorRedColorPrimaryBrush.copy(0.15f),

    val pointerHoverInteractionColor: Color = Color(0x0F000000),

    val pointerTapInteractionColor: Color = Color(0x1F000000)
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
            successGreenColorPrimaryBrush = Color(0xFF30D158),
            warningYellowColorPrimaryBrush = Color(0xFFFFD600),
            errorRedColorPrimaryBrush = Color(0xFFFF4245),
            pointerHoverInteractionColor = Color(0x0FFFFFFF),
            pointerTapInteractionColor = Color(0x1FFFFFFF),
        )

        val White = Color(0xFFF5F5F7)
        val Black = Color(0xFF151517)
        val Blue = Color(0xFF0071E3)
        val Green = Color(0xFF34C759)
        val Yellow = Color(0xFFFFCC00)
        val Red = Color(0xFFFF383C)
    }
}
