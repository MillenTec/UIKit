package com.millentec.compose.uikit.theme.colors

import androidx.compose.ui.graphics.Color

/**
 * 控件通值组: 不做特化的控件直接使用该组色值
 */
data class UIKitControlColors(
    val background: Color,
    val text: Color,
    val border: Color,
    val disabledBackground: Color,
    val disabledText: Color,
    val disabledBorder: Color,
    val checkedItemBackground: Color,
    val checkedBorder: Color,
    val checkedItemText: Color,
)

/**
 * 指针交互反馈色组
 */
data class UIKitInteractionColors(
    val pointer: Color = Color(0xFF000000),
    val hover: Color = pointer.copy(0.05f),
    val tap: Color = pointer.copy(0.1f),
)

/**
 * 菜单组: VerticalMenu / DropdownMenu / MenuScope 共用
 */
data class UIKitMenuColors(
    val background: Color,
    val content: Color,
    val border: Color,
    val divider: Color,
    val itemText: Color,
    val itemIcon: Color,
)

/**
 * 导航栏组
 */
data class UIKitNavigationBarColors(
    val background: Color,
    val indicator: Color,
    val text: Color,
    val textActive: Color,
)

/**
 * 分段控件组
 */
data class UIKitSegmentedColors(
    val background: Color,
    val indicator: Color,
    val text: Color,
    val textActive: Color,
    val border: Color,
)

/**
 * UIKit Symbols 组
 */
data class UIKitSymbolColors(
    val stroke: Color,
    val disabledStroke: Color,
    val accentStroke: Color,
    val tipBadge: Color,
    val errorBadge: Color,
    val negativeBadge: Color,
    val positiveBadge: Color,
    val layerPrimaryAlpha: Float,
    val layerSecondaryAlpha: Float,
    val backgroundLayerAlpha: Float,
    val stackLayer0Alpha: Float,
    val stackLayer1Alpha: Float,
    val stackLayer2Alpha: Float,
    val stackLayer3Alpha: Float,
    val stackLayer4Alpha: Float,
)
