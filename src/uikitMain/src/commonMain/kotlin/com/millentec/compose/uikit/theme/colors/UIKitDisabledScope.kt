package com.millentec.compose.uikit.theme.colors

/**
 * 构建禁用态主题: 所有禁用色值均由 UIKitColors 统一构建, 控件分组色值同样映射到禁用通值
 * 控件可通过 UIKitAvailabilityScope 的 adjust 参数用自身 Colors 覆盖对应分组
 */
fun UIKitColors.disabledScope(): UIKitColors {
    return UIKitColors(
        contentFillColorPrimaryBrush = contentFillColorPrimaryBrush,
        contentFillColorSecondaryBrush = contentFillColorSecondaryBrush,
        contentFillColorTertiaryBrush = contentFillColorTertiaryBrush,
        contentFillColorFourthBrush = contentFillColorFourthBrush,
        contentFillColorDisabledBrush = contentFillColorDisabledBrush,

        textFillColorPrimaryBrush = textFillColorDisabledBrush,
        textFillColorPrimaryBrushReversed = contentFillColorDisabledBrush,
        textFillColorSecondaryBrush = textFillColorDisabledBrush,
        textFillColorTertiaryBrush = textFillColorFourthBrush,
        textFillColorFourthBrush = textFillColorFourthBrush,
        textFillColorDisabledBrush = textFillColorDisabledBrush,

        lineFillColorPrimaryBrush = lineFillColorDisabledBrush,
        lineFillColorSecondaryBrush = lineFillColorDisabledBrush,
        lineFillColorTertiaryBrush = lineFillColorFourthBrush,
        lineFillColorFourthBrush = lineFillColorFourthBrush,
        lineFillColorDisabledBrush = lineFillColorDisabledBrush,

        accentColorPrimaryBrush = textFillColorDisabledBrush,
        accentColorSecondaryBrush = textFillColorDisabledBrush,
        accentColorTertiaryBrush = contentFillColorDisabledBrush,
        accentColorFourthBrush = contentFillColorDisabledBrush,

        successColorPrimaryBrush = textFillColorDisabledBrush,
        successColorSecondaryBrush = textFillColorDisabledBrush,
        successColorTertiaryBrush = contentFillColorDisabledBrush,
        successColorFourthBrush = contentFillColorDisabledBrush,

        warningColorPrimaryBrush = textFillColorDisabledBrush,
        warningColorSecondaryBrush = textFillColorDisabledBrush,
        warningColorTertiaryBrush = contentFillColorDisabledBrush,
        warningColorFourthBrush = contentFillColorDisabledBrush,

        errorColorPrimaryBrush = textFillColorDisabledBrush,
        errorColorSecondaryBrush = textFillColorDisabledBrush,
        errorColorTertiaryBrush = contentFillColorDisabledBrush,
        errorColorFourthBrush = contentFillColorDisabledBrush,

        textSelectionColorBrush = textSelectionColorBrush,
        textCursorColorBrush = textCursorColorBrush,

        linkTextColorBrush = textFillColorDisabledBrush,
        placeholderTextColorBrush = textFillColorDisabledBrush,

        applicationBackgroundFillColorBrush = applicationBackgroundFillColorBrush,
        cardBackgroundFillColorBrush = cardBackgroundFillColorBrush,

        control = control.copy(
            background = control.disabledBackground,
            text = control.disabledText,
            border = control.disabledBorder,
            checkedItemBackground = control.disabledBackground,
            checkedBorder = control.disabledBorder,
            checkedItemText = control.disabledText,
        ),

        interaction = interaction,

        menu = menu.copy(
            content = control.disabledText,
            itemText = control.disabledText,
            itemIcon = control.disabledText,
        ),

        navigationBar = navigationBar.copy(
            background = control.disabledBackground,
            text = control.disabledText,
            textActive = control.disabledText,
        ),

        segmented = segmented.copy(
            background = control.disabledBackground,
            text = control.disabledText,
            textActive = control.disabledText,
            border = control.disabledBorder,
        ),

        symbol = symbol.copy(
            stroke = control.disabledText,
            accentStroke = control.disabledText,
            tipBadge = control.disabledText,
            errorBadge = control.disabledText,
            negativeBadge = control.disabledText,
            positiveBadge = control.disabledText,
        ),

        button = button.copy(
            background = control.disabledBackground,
            backgroundDisabled = control.disabledBackground,
            content = control.disabledText,
            contentDisabled = control.disabledText,
            border = control.disabledBorder,
            borderDisabled = control.disabledBorder,
        ),

        toggleButton = toggleButton.copy(
            background = control.disabledBackground,
            backgroundDisabled = control.disabledBackground,
            backgroundChecked = control.disabledBackground,
            content = control.disabledText,
            contentDisabled = control.disabledText,
            contentChecked = control.disabledText,
            border = control.disabledBorder,
            borderDisabled = control.disabledBorder,
            borderChecked = control.disabledBorder,
        ),

        toggleSwitch = toggleSwitch.copy(
            background = control.disabledBackground,
            backgroundDisabled = control.disabledBackground,
            backgroundChecked = control.disabledBackground,
            border = control.disabledBorder,
            borderDisabled = control.disabledBorder,
            borderChecked = control.disabledBorder,
            thumb = control.disabledBorder,
            thumbDisabled = control.disabledBorder,
            thumbChecked = control.disabledBorder,
        ),

        radioButton = radioButton.copy(
            selected = control.disabledBorder,
            unselected = control.disabledBorder,
            selectedDisabled = control.disabledBorder,
            unselectedDisable = control.disabledBorder,
        ),

        slider = slider.copy(
            thumb = control.disabledBackground,
            thumbDisabled = control.disabledBackground,
            activeTrack = control.disabledBorder,
            activeTrackDisabled = control.disabledBorder,
            inactiveTrack = control.border,
            inactiveTrackDisabled = control.border,
            tick = control.disabledBorder,
            tickDisabled = control.disabledBorder,
        ),

        textField = textField.copy(
            background = control.disabledBackground,
            backgroundDisabled = control.disabledBackground,
            backgroundActive = control.disabledBackground,
            border = control.disabledBorder,
            borderActive = control.disabledBorder,
            borderDisabled = control.disabledBorder,
            watermark = control.disabledText,
            watermarkActive = control.disabledText,
            watermarkDisabled = control.disabledText,
            content = control.disabledText,
            contentActive = control.disabledText,
            contentDisabled = control.disabledText,
        ),

        dropdown = dropdown.copy(
            background = control.disabledBackground,
            backgroundDisabled = control.disabledBackground,
            content = control.disabledText,
            contentDisabled = control.disabledText,
            border = control.disabledBorder,
            borderDisabled = control.disabledBorder,
        ),

        bluePrimaryBrush = textFillColorDisabledBrush,
        blueSecondaryBrush = textFillColorDisabledBrush,
        blueTertiaryBrush = contentFillColorDisabledBrush,
        blueFourthBrush = contentFillColorDisabledBrush,

        greenPrimaryBrush = textFillColorDisabledBrush,
        greenSecondaryBrush = textFillColorDisabledBrush,
        greenTertiaryBrush = contentFillColorDisabledBrush,
        greenFourthBrush = contentFillColorDisabledBrush,

        yellowPrimaryBrush = textFillColorDisabledBrush,
        yellowSecondaryBrush = textFillColorDisabledBrush,
        yellowTertiaryBrush = contentFillColorDisabledBrush,
        yellowFourthBrush = contentFillColorDisabledBrush,

        redPrimaryBrush = textFillColorDisabledBrush,
        redSecondaryBrush = textFillColorDisabledBrush,
        redTertiaryBrush = contentFillColorDisabledBrush,
        redFourthBrush = contentFillColorDisabledBrush,

        mintPrimaryBrush = textFillColorDisabledBrush,
        mintSecondaryBrush = textFillColorDisabledBrush,
        mintTertiaryBrush = contentFillColorDisabledBrush,
        mintFourthBrush = contentFillColorDisabledBrush,

        tealPrimaryBrush = textFillColorDisabledBrush,
        tealSecondaryBrush = textFillColorDisabledBrush,
        tealTertiaryBrush = contentFillColorDisabledBrush,
        tealFourthBrush = contentFillColorDisabledBrush,

        cyanPrimaryBrush = textFillColorDisabledBrush,
        cyanSecondaryBrush = textFillColorDisabledBrush,
        cyanTertiaryBrush = textFillColorDisabledBrush,
        cyanFourthBrush = contentFillColorDisabledBrush,

        indigoPrimaryBrush = textFillColorDisabledBrush,
        indigoSecondaryBrush = textFillColorDisabledBrush,
        indigoTertiaryBrush = contentFillColorDisabledBrush,
        indigoFourthBrush = contentFillColorDisabledBrush,

        purplePrimaryBrush = textFillColorDisabledBrush,
        purpleSecondaryBrush = textFillColorDisabledBrush,
        purpleTertiaryBrush = contentFillColorDisabledBrush,
        purpleFourthBrush = contentFillColorDisabledBrush,

        pinkPrimaryBrush = textFillColorDisabledBrush,
        pinkSecondaryBrush = textFillColorDisabledBrush,
        pinkTertiaryBrush = contentFillColorDisabledBrush,
        pinkFourthBrush = contentFillColorDisabledBrush,

        brownPrimaryBrush = textFillColorDisabledBrush,
        brownSecondaryBrush = textFillColorDisabledBrush,
        brownTertiaryBrush = contentFillColorDisabledBrush,
        brownFourthBrush = contentFillColorDisabledBrush,

        orangePrimaryBrush = textFillColorDisabledBrush,
        orangeSecondaryBrush = textFillColorDisabledBrush,
        orangeTertiaryBrush = contentFillColorDisabledBrush,
        orangeFourthBrush = contentFillColorDisabledBrush
    )
}

fun UIKitColors.Companion.disabledScope(basic: UIKitColors): UIKitColors {
    return basic.disabledScope()
}
