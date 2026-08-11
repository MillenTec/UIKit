package com.millentec.compose.uikit

import androidx.compose.runtime.Composable
import com.millentec.compose.uikit.foundation.OperatingSystem
import org.jetbrains.skiko.hostOs

@Composable
actual fun getScreenCornerRadius(): Float {
    return 0f
}

actual fun getOperatingSystem(): OperatingSystem {
    return if (hostOs.isWindows) OperatingSystem.Windows
    else if (hostOs.isLinux) OperatingSystem.Linux
    else if (hostOs.isMacOS) OperatingSystem.macOS
    else OperatingSystem.Unknown
}