package com.millentec.compose.uikit.foundation.helper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.positionInRoot

val LocalUIKitClientAreaHelper = compositionLocalOf { UIKitClientAreaHelper() }

class UIKitClientAreaHelper {
    private var _titleBarOffset: Offset? = null
    var titleBarOffset: Offset
        internal set(value) {
            _titleBarOffset = value
        }
        get() = _titleBarOffset ?: Offset.Zero
}

/**
 * 在使用 borderless-titlebar 添加了标题栏后, [positionInRoot] 会出现坐标系不统一的问题
 *
 * [positionInRoot] 返回的是坐标系包括标题栏区域, 而 [androidx.compose.foundation.layout.offset] 的坐标系不包含标题栏等非客户区, 会导致使用绝对定位的元素位置下移一个标题栏高度
 *
 * [positionInClient] 将 [positionInRoot] 的结果减去了此类偏移以纠正位置
 */
@Composable
fun LayoutCoordinates.positionInClient(): Offset {
    return this.positionInClient(LocalUIKitClientAreaHelper.current)
}

/**
 * 在使用 borderless-titlebar 添加了标题栏后, [positionInRoot] 会出现坐标系不统一的问题
 *
 * [positionInRoot] 返回的是坐标系包括标题栏区域, 而 [androidx.compose.foundation.layout.offset] 的坐标系不包含标题栏等非客户区, 会导致使用绝对定位的元素位置下移一个标题栏高度
 *
 * [positionInClient] 将 [positionInRoot] 的结果减去了此类偏移以纠正位置
 */
fun LayoutCoordinates.positionInClient(helper: UIKitClientAreaHelper): Offset {
    return this.positionInRoot() - helper.titleBarOffset
}