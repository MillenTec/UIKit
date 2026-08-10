package com.millentec.compose.uikit.foundation

import androidx.compose.runtime.Composable
import com.millentec.compose.uikit.theme.LocalStrings

@Composable
fun getTitleById(id: String): String {
    val strings = LocalStrings.current
    return when (id) {
        "home" -> strings.home.title
        "controls" -> strings.controls.title
        "designs" -> strings.designs.title
        "license" -> strings.license.title
        "third-party" -> strings.thirdPartyLicenses.title
        "settings" -> strings.settings.title

        "settings_language" -> strings.settings.language.title

        "controls_inputs" -> strings.controls.inputs.title
        "controls_flyouts" -> strings.controls.flyouts.title
        "controls_status-and-infos" -> strings.controls.statusAndInfos.title
        "controls_layouts" -> strings.controls.layouts.title

        "controls_inputs_button" -> strings.controls.inputs.button.title
        "controls_inputs_toggle-button" -> strings.controls.inputs.toggleButton.title
        "controls_inputs_toggle-switch" -> strings.controls.inputs.toggleSwitch.title
        else -> "id:$id"
    }
}