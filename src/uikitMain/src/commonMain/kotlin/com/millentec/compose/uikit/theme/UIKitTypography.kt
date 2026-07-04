package com.millentec.compose.uikit.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * UIKitTheme 的文本排版部分
 */
data class UIKitTypography(

    /**
     * 大型显示文本, 用于需突出强调的文本
     */
    val display: TextStyle = TextStyle(
        fontSize = 55.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 66.sp
    ),

    /**
     * 大标题, 常用于页面顶部的标题
     */
    val largeTitle: TextStyle = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 41.sp
    ),

    /**
     * 标题, 于正文搭配, 常作为一段正文的标题文字
     */
    val title: TextStyle = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 34.sp
    ),

    /**
     * 副标题, 一般于大标题搭配做补充陈述
     */
    val subtitle: TextStyle = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 28.sp
    ),

    /**
     * 正文, 常规文本使用
     */
    val body: TextStyle = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp
    ),

    /**
     * 脚注, 用于说明补充或视觉优先级低的文本
     */
    val footnote: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 19.sp
    )
)
