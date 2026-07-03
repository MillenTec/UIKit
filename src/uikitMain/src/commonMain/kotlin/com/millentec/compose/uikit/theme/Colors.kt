package com.millentec.compose.uikit.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val contentFillColorPrimaryBrush: Color = Color(0xFFFFFFFF),
    val textFillColorPrimaryBrush: Color = Color(0xFF1D1D1F),
    val textFillColorSubBrush: Color = Color(0xFF6E6E73)
) {
    companion object {
        fun getLight(): Colors {
            return Colors()
        }

        fun getDark(): Colors {
            return Colors(
                contentFillColorPrimaryBrush = Color(0xFF151517),
                textFillColorPrimaryBrush = Color(0xFFF5F5F7),
                textFillColorSubBrush = Color(0xFF86868B)
            )
        }
    }
}
