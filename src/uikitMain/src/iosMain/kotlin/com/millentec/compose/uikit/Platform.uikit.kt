package com.millentec.compose.uikit

import androidx.compose.runtime.Composable
import com.millentec.compose.uikit.foundation.OperatingSystem

@Composable
actual fun getScreenCornerRadius(): Float {
    return 0f
}

actual fun getOperatingSystem(): OperatingSystem {
    return OperatingSystem.iOS
}