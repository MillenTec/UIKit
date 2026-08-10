package com.millentec.compose.uikit

import androidx.compose.runtime.Composable
import com.millentec.compose.uikit.foundation.OperatingSystem

/**
 * 获取设备屏幕圆角的半径, 单位为 px, 仅 Android 端有效, 其余平台返回 0
 * @return 获取到的屏幕圆角半径, 单位为 px (物理像素)
 */
@Composable
expect fun getScreenCornerRadius(): Float

expect fun getOperatingSystem(): OperatingSystem