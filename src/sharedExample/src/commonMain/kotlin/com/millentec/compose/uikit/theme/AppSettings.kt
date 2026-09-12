package com.millentec.compose.uikit.theme

import androidx.compose.runtime.compositionLocalOf
import com.millentec.compose.uikit.i18n.SupportedLanguages
import com.millentec.compose.uikit.i18n.strings.Strings
import com.millentec.compose.uikit.i18n.strings.UnitedStatesEnglish
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

val LocalStrings = compositionLocalOf<Strings> { UnitedStatesEnglish() }

object AppSettings {
    private val _languages = MutableStateFlow(SupportedLanguages.EnUS)
    val languages = _languages.asStateFlow()

    fun switchLanguage(language: SupportedLanguages) {
        _languages.value = language
    }
}