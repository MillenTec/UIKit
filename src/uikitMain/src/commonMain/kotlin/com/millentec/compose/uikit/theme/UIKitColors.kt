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

    /**
     * 用于普通正文的颜色
     */
    val textFillColorPrimaryBrush: Color = Color(0xFF1D1D1F),

    /**
     * 可用于副标题, 脚注, 不可用控件的文本颜色
     */
    val textFillColorSubBrush: Color = Color(0xFF6E6E73),

    val lineFillColorPrimaryBrush: Color = Color(0xFFE9EAEE),

    val highlightColorBrush: Color = Color(0xFF0071E3)
) {

    /**
     * UIKitTheme 主题的颜色部分, 默认为亮色主题, 使用 getDark() 方法获取默认的暗色主题
     */
    companion object {
        /**
         * 获取默认的亮色主题
         * @return 包含默认亮色主题的 UIKitColors 实例
         */
        fun getLight(): UIKitColors {
            return UIKitColors()
        }

        /**
         * 获取默认的暗色主题
         * @return 包含默认暗色主题的 UIKitColors 实例
         */
        fun getDark(): UIKitColors {
            return UIKitColors(
                contentFillColorPrimaryBrush = Color(0xFF151517),
                contentFillColorSecondaryBrush = Color(0xFF1D1D1F),
                textFillColorPrimaryBrush = Color(0xFFF5F5F7),
                textFillColorSubBrush = Color(0xFF86868B),
                lineFillColorPrimaryBrush = Color(0xFF26282C),
                highlightColorBrush = Color(0xFF0071E3)
            )
        }
    }
}
