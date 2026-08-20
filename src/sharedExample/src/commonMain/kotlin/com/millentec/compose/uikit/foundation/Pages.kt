package com.millentec.compose.uikit.foundation

@Suppress("EnumEntryName")
enum class Pages(
    val parent: Pages? = null
) {
    Home,
    Controls,

    Designs,
    Designs_Icons(Designs),
    Designs_UIKitSymbols(Designs),

    Designs_UIKitSymbols_SystemUI(Designs),

    License,
    ThirdParty,
    Settings,
    Settings_Language(Settings),

    Controls_BasicInputs(Controls),
    Controls_StatusAndInfo(Controls),
    Controls_Flyouts(Controls),
    Controls_Layouts(Controls),

    Controls_BasicInputs_Button(Controls),
    Controls_BasicInputs_ToggleButton(Controls),
    Controls_BasicInputs_ToggleSwitch(Controls)
}