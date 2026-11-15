package com.millentec.compose.uikit.theme.colors

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.millentec.compose.uikit.component.input.*
import com.millentec.compose.uikit.foundation.graphics.contrast
import com.millentec.compose.uikit.theme.getUIKitColors

/**
 * UIKitTheme 主题的颜色部分, 默认为亮色主题, 使用 getDark() 方法获取默认的暗色主题
 *
 * 扁平部分为基础/内容/文本/线条/语义/作用色; 各控件的主题化色值以对应控件 Colors 数据类的实例分组存储
 * (如 [button] / [textField] / [toggleSwitch]), 控件未特化的色值使用 [control] 控件通值组
 *
 * 注意: Android 平台存在方法参数 255 寄存器槽 (Color 占 2 槽) 的硬限制, 新增分组请优先扩展现有组而非扁平添加
 */
data class UIKitColors(

    // ------内容色------ //

    val contentFillColorPrimaryBrush: Color = Color(0xFFF5F5F7),
    val contentFillColorSecondaryBrush: Color = Color(0xFFFFFFFF),
    val contentFillColorTertiaryBrush: Color = Color(0xFFE8E8ED),
    val contentFillColorFourthBrush: Color = Color(0xFF666668),
    val contentFillColorDisabledBrush: Color = Color(0xFFEFEFF2),

    val textFillColorPrimaryBrush: Color = Color(0xFF1D1D1F),
    val textFillColorPrimaryBrushReversed: Color = Color(0xFFF5F5F7),
    val textFillColorSecondaryBrush: Color = Color(0xFF6E6E73),
    val textFillColorTertiaryBrush: Color = Color(0xFF969699),
    val textFillColorFourthBrush: Color = Color(0xFFD3D3D5),
    val textFillColorDisabledBrush: Color = Color(0xFFB9B9BB),

    val lineFillColorPrimaryBrush: Color = Color(0xFFE8E8ED),
    val lineFillColorSecondaryBrush: Color = Color(0xFFECECF0),
    val lineFillColorTertiaryBrush: Color = Color(0xFFEFEFF2),
    val lineFillColorFourthBrush: Color = Color(0xFFF3F3F6),
    val lineFillColorDisabledBrush: Color = Color(0xFFB9B9BB),

    // ------语义色------ //

    val accentColorPrimaryBrush: Color = Color(0xFF0071E3),
    val accentColorSecondaryBrush: Color = Color(0xFF5B99EC),
    val accentColorTertiaryBrush: Color = Color(0xFF8FB8F2),
    val accentColorFourthBrush: Color = Color(0xFFD7E3F6),

    val successColorPrimaryBrush: Color = Color(0xFF34C759),
    val successColorSecondaryBrush: Color = Color(0xFF7AD588),
    val successColorTertiaryBrush: Color = Color(0xFFA6E1AE),
    val successColorFourthBrush: Color = Color(0xFFDFEFE2),

    val warningColorPrimaryBrush: Color = Color(0xFFFFCC00),
    val warningColorSecondaryBrush: Color = Color(0xFFFCD974),
    val warningColorTertiaryBrush: Color = Color(0xFFFAE3A4),
    val warningColorFourthBrush: Color = Color(0xFFF7F0E0),

    val errorColorPrimaryBrush: Color = Color(0xFFFF383C),
    val errorColorSecondaryBrush: Color = Color(0xFFFF8077),
    val errorColorTertiaryBrush: Color = Color(0xFFFFAAA2),
    val errorColorFourthBrush: Color = Color(0xFFFCDFDD),

    // ------作用色------ //

    val textSelectionColorBrush: Color = accentColorPrimaryBrush.copy(0.3f),
    val textCursorColorBrush: Color = accentColorPrimaryBrush,

    val linkTextColorBrush: Color = accentColorPrimaryBrush,
    val placeholderTextColorBrush: Color = textFillColorSecondaryBrush,

    val applicationBackgroundFillColorBrush: Color = contentFillColorPrimaryBrush,
    val cardBackgroundFillColorBrush: Color = contentFillColorSecondaryBrush,

    // ------控件分组------ //

    val control: UIKitControlColors = UIKitControlColors(
        background = contentFillColorTertiaryBrush,
        text = textFillColorPrimaryBrush,
        border = lineFillColorPrimaryBrush,
        disabledBackground = contentFillColorDisabledBrush,
        disabledText = textFillColorDisabledBrush,
        disabledBorder = lineFillColorDisabledBrush,
        checkedItemBackground = contentFillColorTertiaryBrush,
        checkedBorder = accentColorPrimaryBrush,
        checkedItemText = accentColorPrimaryBrush,
    ),

    val interaction: UIKitInteractionColors = UIKitInteractionColors(),

    val menu: UIKitMenuColors = UIKitMenuColors(
        background = cardBackgroundFillColorBrush,
        content = textFillColorPrimaryBrush,
        border = lineFillColorPrimaryBrush,
        divider = lineFillColorPrimaryBrush,
        itemText = textFillColorPrimaryBrush,
        itemIcon = textFillColorPrimaryBrush,
    ),

    val navigationBar: UIKitNavigationBarColors = UIKitNavigationBarColors(
        background = cardBackgroundFillColorBrush,
        indicator = textFillColorPrimaryBrush.copy(0.2f),
        text = textFillColorPrimaryBrush,
        textActive = accentColorPrimaryBrush,
    ),

    val segmented: UIKitSegmentedColors = UIKitSegmentedColors(
        background = contentFillColorTertiaryBrush,
        indicator = cardBackgroundFillColorBrush,
        text = textFillColorPrimaryBrush,
        textActive = accentColorPrimaryBrush,
        border = lineFillColorPrimaryBrush,
    ),

    val symbol: UIKitSymbolColors = UIKitSymbolColors(
        stroke = textFillColorPrimaryBrush,
        disabledStroke = lineFillColorDisabledBrush,
        accentStroke = accentColorPrimaryBrush,
        tipBadge = accentColorPrimaryBrush,
        errorBadge = errorColorPrimaryBrush,
        negativeBadge = warningColorFourthBrush,
        positiveBadge = successColorPrimaryBrush,
        layerPrimaryAlpha = 1f,
        layerSecondaryAlpha = 0.6f,
        backgroundLayerAlpha = 0.3f,
        stackLayer0Alpha = 1f,
        stackLayer1Alpha = 0.75f,
        stackLayer2Alpha = 0.6f,
        stackLayer3Alpha = 0.45f,
        stackLayer4Alpha = 0.3f,
    ),

    /* Button (Button 形态的 DropdownButton 未实现, 届时与本组共用) */
    val button: UIKitButtonColors = UIKitButtonColors(
        background = control.background,
        backgroundDisabled = control.disabledBackground,
        content = control.text,
        contentDisabled = control.disabledText,
        border = control.border,
        borderDisabled = control.disabledBorder,
    ),

    val toggleButton: UIKitToggleButtonColors = UIKitToggleButtonColors(
        background = control.background,
        backgroundDisabled = control.disabledBackground,
        backgroundChecked = accentColorPrimaryBrush,
        content = control.text,
        contentDisabled = control.disabledText,
        contentChecked = White,
        border = control.border,
        borderDisabled = control.disabledBorder,
        borderChecked = accentColorPrimaryBrush,
    ),

    val toggleSwitch: UIKitToggleSwitchColors = UIKitToggleSwitchColors(
        background = contentFillColorSecondaryBrush,
        backgroundDisabled = control.disabledBackground,
        backgroundChecked = accentColorPrimaryBrush,
        border = control.border,
        borderDisabled = control.disabledBorder,
        borderChecked = accentColorPrimaryBrush,
        thumb = contentFillColorFourthBrush,
        thumbDisabled = lineFillColorDisabledBrush,
        thumbChecked = White,
    ),

    val radioButton: UIKitRadioButtonColors = UIKitRadioButtonColors(
        selected = control.checkedItemText,
        unselected = contentFillColorTertiaryBrush,
        selectedDisabled = control.disabledBorder,
        unselectedDisable = control.disabledBorder,
    ),

    val slider: UIKitSliderColors = UIKitSliderColors(
        thumb = White,
        thumbDisabled = contentFillColorDisabledBrush,
        activeTrack = accentColorPrimaryBrush,
        inactiveTrack = lineFillColorPrimaryBrush,
        activeTrackDisabled = lineFillColorDisabledBrush,
        inactiveTrackDisabled = lineFillColorPrimaryBrush,
        tick = lineFillColorPrimaryBrush,
        tickDisabled = lineFillColorDisabledBrush,
    ),

    val textField: UIKitTextFieldColors = UIKitTextFieldColors(
        background = control.background,
        backgroundDisabled = control.disabledBackground,
        backgroundActive = contentFillColorSecondaryBrush,
        border = control.border,
        borderActive = accentColorPrimaryBrush,
        borderDisabled = control.disabledBorder,
        watermark = placeholderTextColorBrush,
        watermarkActive = placeholderTextColorBrush,
        watermarkDisabled = control.disabledText,
        content = control.text,
        contentActive = control.disabledText,
        contentDisabled = control.disabledText,
        textSelectionColors = TextSelectionColors(
            handleColor = textCursorColorBrush,
            backgroundColor = textSelectionColorBrush
        )
    ),

    val dropdown: UIKitDropdownColors = UIKitDropdownColors(
        background = button.background,
        backgroundDisabled = button.backgroundDisabled,
        content = button.content,
        contentDisabled = button.contentDisabled,
        border = button.border,
        borderDisabled = button.borderDisabled,
        menuBackground = cardBackgroundFillColorBrush,
        menuDivider = control.border,
        menuContent = control.text,
        menuBorder = control.border,
    ),

    // ------基础色------ //

    val bluePrimaryBrush: Color = Color(0xFF0088FF),
    val blueSecondaryBrush: Color = Color(0xFF63A9FF),
    val blueTertiaryBrush: Color = Color(0xFF95C4FF),
    val blueFourthBrush: Color = Color(0xFFD9E7FA),

    val greenPrimaryBrush: Color = Color(0xFF34C759),
    val greenSecondaryBrush: Color = Color(0xFF7AD588),
    val greenTertiaryBrush: Color = Color(0xFFA6E1AE),
    val greenFourthBrush: Color = Color(0xFFDFEFE2),

    val yellowPrimaryBrush: Color = Color(0xFFFFCC00),
    val yellowSecondaryBrush: Color = Color(0xFFFCD974),
    val yellowTertiaryBrush: Color = Color(0xFFFAE3A4),
    val yellowFourthBrush: Color = Color(0xFFF7F0E0),

    val redPrimaryBrush: Color = Color(0xFFFF383C),
    val redSecondaryBrush: Color = Color(0xFFFF8077),
    val redTertiaryBrush: Color = Color(0xFFFFAAA2),
    val redFourthBrush: Color = Color(0xFFFCDFDD),

    val mintPrimaryBrush: Color = Color(0xFF00C8B3),
    val mintSecondaryBrush: Color = Color(0xFF73D5C6),
    val mintTertiaryBrush: Color = Color(0xFFA3E0D6),
    val mintFourthBrush: Color = Color(0xFFDEEFED),

    val tealPrimaryBrush: Color = Color(0xFF00C3D0),
    val tealSecondaryBrush: Color = Color(0xFF72D2DB),
    val tealTertiaryBrush: Color = Color(0xFFA2DEE4),
    val tealFourthBrush: Color = Color(0xFFDEEEF2),

    val cyanPrimaryBrush: Color = Color(0xFF00C0E8),
    val cyanSecondaryBrush: Color = Color(0xFF72D0ED),
    val cyanTertiaryBrush: Color = Color(0xFFA2DDF1),
    val cyanFourthBrush: Color = Color(0xFFDEEEF5),

    val indigoPrimaryBrush: Color = Color(0xFF6155F5),
    val indigoSecondaryBrush: Color = Color(0xFF8388FA),
    val indigoTertiaryBrush: Color = Color(0xFFA6AEFC),
    val indigoFourthBrush: Color = Color(0xFFDDE0FA),

    val purplePrimaryBrush: Color = Color(0xFFCB30E0),
    val purpleSecondaryBrush: Color = Color(0xFFDA76E9),
    val purpleTertiaryBrush: Color = Color(0xFFE5A3EF),
    val purpleFourthBrush: Color = Color(0xFFF1DDF5),

    val pinkPrimaryBrush: Color = Color(0xFFFF2D55),
    val pinkSecondaryBrush: Color = Color(0xFFFF7C85),
    val pinkTertiaryBrush: Color = Color(0xFFFFA7AB),
    val pinkFourthBrush: Color = Color(0xFFFCDEE0),

    val brownPrimaryBrush: Color = Color(0xFFAC7F5E),
    val brownSecondaryBrush: Color = Color(0xFFC19F88),
    val brownTertiaryBrush: Color = Color(0xFFD3BBAC),
    val brownFourthBrush: Color = Color(0xFFEBE4E1),

    val orangePrimaryBrush: Color = Color(0xFFFF8D28),
    val orangeSecondaryBrush: Color = Color(0xFFFFAD72),
    val orangeTertiaryBrush: Color = Color(0xFFFEC5A0),
    val orangeFourthBrush: Color = Color(0xFFF9E7DE),
) {

    /**
     * UIKitTheme 主题的颜色部分, 默认为亮色主题, 使用 getDark() 方法获取默认的暗色主题
     */
    companion object {
        val White = Color(0xFFF5F5F7)
        val Black = Color(0xFF1D1D1F)
        val Blue = Color(0xFF0088FF)
        val Green = Color(0xFF34C759)
        val Yellow = Color(0xFFFFCC00)
        val Red = Color(0xFFFF383C)
        val Mint = Color(0xFF00C8B3)
        val Teal = Color(0xFF00C3D0)
        val Cyan = Color(0xFF00C0E8)
        val Indigo = Color(0xFF6155F5)
        val Purple = Color(0xFFCB30E0)
        val Pink = Color(0xFFFF2D55)
        val Brown = Color(0xFFAC7F5E)
        val Orange = Color(0xFFFF8D28)

        @Composable
        fun contentColor(background: Color, minContrast: Float = 4.5f): Color {
            return if (Color.contrast(background, getUIKitColors().textFillColorPrimaryBrush) < minContrast) {
                getUIKitColors().textFillColorPrimaryBrushReversed
            } else getUIKitColors().textFillColorPrimaryBrush
        }

        fun contentColor(background: Color, colors: UIKitColors, minContrast: Float = 4.5f): Color {
            return if (Color.contrast(background, colors.textFillColorPrimaryBrush) < minContrast) {
                colors.textFillColorPrimaryBrushReversed
            } else colors.textFillColorPrimaryBrush
        }

        /**
         * 获取默认的亮色主题
         * @return 包含默认亮色主题的 UIKitColors 实例
         */
        @Deprecated("替换为 Light", ReplaceWith("Light"))
        fun getLight(): UIKitColors = Light

        /**
         * 获取默认的暗色主题
         * @return 包含默认暗色主题的 UIKitColors 实例
         */
        @Deprecated("替换为 Dark", ReplaceWith("Dark"))
        fun getDark(): UIKitColors = Dark
    }
}
