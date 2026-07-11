package com.millentec.compose.uikit.foundation

import com.millentec.compose.uikit.getOperatingSystem

enum class OperatingSystem {
    Android,
    iOS,
    Windows,
    macOS,
    Linux,
    Unknown,
}

fun isDesktopOS(): Boolean {
    return getOperatingSystem() == OperatingSystem.Windows || getOperatingSystem() == OperatingSystem.Linux
            || getOperatingSystem() == OperatingSystem.macOS || getOperatingSystem() == OperatingSystem.Unknown
}