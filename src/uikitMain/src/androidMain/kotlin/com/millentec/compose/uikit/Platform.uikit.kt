package com.millentec.compose.uikit

import android.os.Build
import android.view.RoundedCorner
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.millentec.compose.uikit.foundation.OperatingSystem

private var screenCornerRadius: Float? = null

@Composable
actual fun getScreenCornerRadius(): Float {
    val content = LocalContext.current
    var cornerRadius: Float

    // 默认假设屏幕圆角半径在应用运行期间永远不变
    screenCornerRadius?.let {
        return it
    }

    // 在 Android 12(API 31) 以上支持获取屏幕圆角的 API
    if (Build.VERSION.SDK_INT >= 31){
        val rootView = (content as? android.app.Activity)?.window?.decorView?.rootView
        val insets = rootView?.rootWindowInsets
        val topRightCorner = insets?.getRoundedCorner(RoundedCorner.POSITION_TOP_RIGHT)
        cornerRadius = topRightCorner?.radius?.toFloat() ?: 0f
        screenCornerRadius = cornerRadius
    }else{
        cornerRadius = 0f
    }

    return cornerRadius
}

actual fun getOperatingSystem(): OperatingSystem {
    return OperatingSystem.Android
}