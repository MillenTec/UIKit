package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.foundation.LayoutPosition.*
import com.millentec.compose.uikit.foundation.materials.AcrylicMaterialsState
import com.millentec.compose.uikit.foundation.materials.acrylicMaterial
import com.millentec.compose.uikit.getScreenCornerRadius
import com.millentec.compose.uikit.theme.getUIKitColors
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitMaterials
import com.millentec.compose.uikit.theme.getUIKitShapes

@Composable
@Preview
private fun Preview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenSideAdaptiveContainer(
            modifier = Modifier
                .fillMaxSize(),
            state = rememberScreenSideAdaptiveContainerState()
        ) {
            Text(text = "Hello World")
        }
    }
}

/**
 * 用于 ScreenSideAdaptiveContainer 的状态, 可通过 rememberScreenSideAdaptiveContainerState 计算得到一个
 * @param margins 容器各个方向上的边距
 * @param fillHeight 是否充满垂直高度
 * @param fillWidth 是否充满水平宽度
 * @param height 高度固定值, 当 fillHeight 为 true 时不生效
 * @param width 宽度固定值, 当 fillWidth 为 true 时不生效
 * @param cornerRadius 圆角半径固定值
 * @param alignment 容器的对齐状态
 */
data class ScreenSideAdaptiveContainerState(
    val margins: PaddingValues,
    val fillHeight: Boolean,
    val fillWidth: Boolean,
    val height: Dp,
    val width: Dp,
    val cornerRadius: Dp,
    val alignment: Alignment
)

/**
 * 基于一些信息计算得到一个 ScreenSideAdaptiveContainerState 实例
 * @param position 容器的位置
 * @param expectCornerRadius 所期望的最小圆角半径
 * @param fallbackCornerRadius 回退使用的圆角半径
 * @param expectHeight 所期望的最小高度
 * @param expectWidth 所期望的最小宽度
 * @param minMargin 各个方向的最小边距
 * @param fillWidth 是否充满水平宽度
 * @param fillHeight 是否充满垂直高度
 * @return 一个 ScreenSideAdaptiveContainerState 实例, 可直接传入 ScreenSideAdaptiveContainer
 */
@Composable
fun rememberScreenSideAdaptiveContainerState(
    position: LayoutPosition = Bottom,
    expectCornerRadius: Dp = getUIKitShapes().basicRounded,
    fallbackCornerRadius: Dp = getUIKitShapes().circular,
    expectHeight: Dp = getUIKitLayout().interactiveHotspot,
    expectWidth: Dp = getUIKitLayout().interactiveHotspot,
    minMargin: Dp = getUIKitLayout().mediumSpacing,
    maxMargin: Dp = getUIKitLayout().x4Spacing,
    fillWidth: Boolean = true,
    fillHeight: Boolean = false,
    providedScreenCornerRadius: Dp = (getScreenCornerRadius() / LocalDensity.current.density).dp,
): ScreenSideAdaptiveContainerState {
    val safeDrawing = WindowInsets.safeDrawing
    val layoutDirection = LocalLayoutDirection.current
    val density = LocalDensity.current
    val densityDpi = LocalDensity.current.density

    // 取所需的几个侧边边距的最大值作为统一边距以达到等距效果
    var unifiedMargin: Dp? = maxOf(
        // 在这五种位置布局下会需要底部边距
        if (position == Bottom || position == BottomLeft || position == BottomRight || position == Left || position == Right)
        // 若底部安全边距小于期望最小边距则取期望最小边距, 在无需用到底部边距时底部边距取 0
            maxOf(safeDrawing.getBottom(density).toFloat() / densityDpi, minMargin.value) else 0f,

        if (position == Top || position == TopLeft || position == TopRight || position == Left || position == Right)
            maxOf(safeDrawing.getTop(density).toFloat() / densityDpi, minMargin.value) else 0f,

        if (position == Left || position == BottomLeft || position == TopLeft || position == Bottom || position == Top)
            maxOf(safeDrawing.getLeft(density, layoutDirection).toFloat() / densityDpi, minMargin.value) else 0f,

        if (position == Right || position == BottomRight || position == TopRight || position == Top || position == Bottom)
            maxOf(safeDrawing.getRight(density, layoutDirection).toFloat() / densityDpi, minMargin.value) else 0f,
    ).dp

    // 若最大边距超过一定阈值则标记为 null 表示不使用统一边距 (回退为不等距)
    unifiedMargin?.let { if (it > maxMargin) unifiedMargin = null }

    // 若无法统一出一个边距, 那么则没有必要适应圆角
    val cornerRadius: Dp = if (position == Center) fallbackCornerRadius else
        if (unifiedMargin != null) {
            if (providedScreenCornerRadius - unifiedMargin >= expectCornerRadius)
                providedScreenCornerRadius - unifiedMargin
            else fallbackCornerRadius
        } else {
            fallbackCornerRadius
        }

    val height: Dp
    val width: Dp
    if (cornerRadius != fallbackCornerRadius) {
        height = if (cornerRadius * 2 >= expectHeight) cornerRadius * 2 else expectHeight
        width = if (cornerRadius * 2 >= expectWidth) cornerRadius * 2 else expectWidth
    } else {
        height = expectHeight
        width = expectWidth
    }

    val margins = PaddingValues(
        // 如果不涉及这个边距则设置为 0, 否则若有统一边距则取统一边距 (此时若有统一边距, 统一边距一定大于每一个安全边距), 否则取安全边距或期望最小边距的最大值
        top = if (position == Top || position == TopLeft || position == TopRight || position == Left || position == Right)
            unifiedMargin ?: maxOf(safeDrawing.getTop(density).toFloat() / densityDpi, minMargin.value).dp
        else 0.dp,
        bottom = if (position == Bottom || position == BottomLeft || position == BottomRight || position == Left || position == Right)
            unifiedMargin ?: maxOf(safeDrawing.getBottom(density).toFloat() / densityDpi, minMargin.value).dp
        else 0.dp,
        start = if (position == Left || position == BottomLeft || position == TopLeft || position == Bottom || position == Top)
            unifiedMargin ?: maxOf(safeDrawing.getLeft(density, layoutDirection).toFloat() / densityDpi, minMargin.value).dp
        else 0.dp,
        end = if (position == Right || position == BottomRight || position == TopRight || position == Top || position == Bottom)
            unifiedMargin ?: maxOf(safeDrawing.getRight(density, layoutDirection).toFloat() / densityDpi, minMargin.value).dp
        else 0.dp,
    )

    return ScreenSideAdaptiveContainerState(
        margins = margins,
        fillHeight = fillHeight,
        fillWidth = fillWidth,
        height = height,
        width = width,
        cornerRadius = cornerRadius,
        alignment = when(position){
            Top -> Alignment.TopCenter
            Bottom -> Alignment.BottomCenter
            Left -> Alignment.CenterStart
            Right -> Alignment.CenterEnd
            TopLeft -> Alignment.TopStart
            TopRight -> Alignment.TopEnd
            BottomLeft -> Alignment.BottomStart
            BottomRight -> Alignment.BottomEnd
            Center -> Alignment.Center
        }
    )
}

@Composable
fun ScreenSideAdaptiveContainer(
    modifier: Modifier = Modifier,
    state: ScreenSideAdaptiveContainerState,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    acrylicEffectEnabled: Boolean = true,
    acrylicState: AcrylicMaterialsState? = null,
    shadowEnable: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = state.alignment
    ) {
        Column(
            modifier = Modifier
                .padding(state.margins)
                .then(if (shadowEnable && getUIKitMaterials().ambientShadowMaterial.shadowEnable)
                    Modifier.shadow(
                        elevation = getUIKitMaterials().ambientShadowMaterial.elevation,
                        shape = RoundedCornerShape(state.cornerRadius),
                        ambientColor = getUIKitMaterials().ambientShadowMaterial.ambientColor,
                        spotColor = getUIKitMaterials().ambientShadowMaterial.spotColor,
                    ) else Modifier)
                .clip(RoundedCornerShape(state.cornerRadius))
                .background(if (acrylicEffectEnabled && acrylicState != null)
                    Color.Transparent else background)
                .then(if (state.fillWidth) Modifier.fillMaxWidth() else Modifier.width(state.width))
                .then(if (state.fillHeight) Modifier.fillMaxHeight() else Modifier.height(state.height))
                .then(if (acrylicEffectEnabled && acrylicState != null) Modifier.acrylicMaterial(
                    state = acrylicState
                ) else Modifier)
                .then(if (acrylicEffectEnabled && getUIKitMaterials().acrylicMaterial.lightingEffectsEnabled) {
                    Modifier.border(
                        width = getUIKitMaterials().acrylicMaterial.edgeHighlightThickness,
                        brush = getUIKitMaterials().acrylicMaterial.edgeHighlightColor,
                        shape = RoundedCornerShape(getUIKitShapes().circular)
                    )
                } else Modifier),
            content = content
        )
    }
}