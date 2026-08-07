package com.millentec.compose.uikit.data

enum class Pages(val parent: Int? = null) {
    Home,
    Controls,
    Design,
    Settings,

    Icons(2),
    License,
    ThirdParty,

    ControlsBasicInputs(1),
    ControlsStatusAndInfo(1),
    ControlsFlyouts(1),
    ControlsLayouts(1),
}