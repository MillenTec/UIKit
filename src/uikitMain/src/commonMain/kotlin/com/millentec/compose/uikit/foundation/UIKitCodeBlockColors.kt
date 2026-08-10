package com.millentec.compose.uikit.foundation

import androidx.compose.ui.graphics.Color

data class UIKitCodeBlockColors(
    val primaryText: Color = Color(0xFFF5F5F7),
    val primaryBackground: Color = Color(0xFF191A1C),
    val noteText: Color = Color(0xFF7A7E85),
    val keywordText: Color = Color(0xFFCF8E6D),
    val functionDeclarationText: Color = Color(0xFF56A8F5),
    val functionCallText: Color = Color(0xFF56A8F5),
    val stringText: Color = Color(0xFF6AAB73),
    val numberText: Color = Color(0xFF2AACB8),
    val propertyText: Color = Color(0xFFC77DBB),
    val docNoteText: Color = Color(0xFF5F826B),
    val docTagText: Color = Color(0xFF68A67E),
    val metadataText: Color = Color(0xFFB3AE60),
) {
    companion object {
        val IntelliJ = UIKitCodeBlockColors()
        val IntelliJLight = UIKitCodeBlockColors(
            primaryText = Color(0xFF1D1D1F),
            primaryBackground = Color(0xFFFFFFFF),
            noteText = Color(0xFF8C8C8C),
            keywordText = Color(0xFF0033B3),
            functionDeclarationText = Color(0xFF00627A),
            functionCallText = Color(0xFF00627A),
            stringText = Color(0xFF067D17),
            numberText = Color(0xFF1750EB),
            propertyText = Color(0xFF871094),
            docNoteText = Color(0xFF8C8C8C),
            docTagText = Color(0xFF999999),
            metadataText = Color(0xFF9E880D),
        )
    }
}