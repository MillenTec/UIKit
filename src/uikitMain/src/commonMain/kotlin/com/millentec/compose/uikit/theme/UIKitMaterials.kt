package com.millentec.compose.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

data class UIKitAcrylicMaterial(
    val radius: Dp = 40.dp,
    val tint: Color = Color(0x4CF5F5F7),
    val secondaryTint: Color = Color(0x4C1D1D1F),
    val cpuComputationEnabled: Boolean = false,

    val lightingEffectsEnabled: Boolean = true,
    val edgeHighlightColor: Brush = Brush.linearGradient(
        listOf(
            Color(0xFFFFFFFF),
            Color(0x00FFFFFF),
            Color(0xFFFFFFFF)
        )
    ),
    val edgeHighlightThickness: Dp = 1.dp
)

data class UIKitShadowMaterial(
    val shadowEnable: Boolean = true,
    val radius: Dp = 10.dp,
    val spread: Dp = 1.dp,
    val offset: DpOffset = DpOffset.Zero,
    val color: Color = Color(0xFF000000),
    val alpha: Float = 0.05f,
    val blendMode: BlendMode = BlendMode.Darken
) {
    companion object {
        /**
         * Primary 阴影主要为装饰服务, 可用于卡片等控件上以实现层次感
         */
        @Composable
        fun getPrimary(): Shadow = Shadow(
            radius = getUIKitMaterials().shadowMaterial.radius,
            spread = getUIKitMaterials().shadowMaterial.spread,
            offset = getUIKitMaterials().shadowMaterial.offset,
            color = getUIKitMaterials().shadowMaterial.color,
            alpha = getUIKitMaterials().shadowMaterial.alpha,
            blendMode = getUIKitMaterials().shadowMaterial.blendMode
        )

        /**
         * Marginal 边缘阴影主要为 UI 可读性服务, 用于颜色与背景对比度不高的控件中以明确边缘
         */
        @Composable
        fun getMarginal(): Shadow = Shadow(
            radius = getUIKitMaterials().shadowMaterial.radius / 2,
            spread = getUIKitMaterials().shadowMaterial.spread,
            offset = getUIKitMaterials().shadowMaterial.offset,
            color = getUIKitMaterials().shadowMaterial.color,
            alpha = getUIKitMaterials().shadowMaterial.alpha * 2,
            blendMode = getUIKitMaterials().shadowMaterial.blendMode
        )
    }
}

data class UIKitMaterials(
    val acrylicMaterial: UIKitAcrylicMaterial = UIKitAcrylicMaterial(),
    val shadowMaterial: UIKitShadowMaterial = UIKitShadowMaterial(),
) {
    companion object {
        fun getLight(): UIKitMaterials = UIKitMaterials()

        fun getDark(): UIKitMaterials = UIKitMaterials(
            acrylicMaterial = UIKitAcrylicMaterial(
                tint = Color(0x4C151517),
                secondaryTint = Color(0x4CF5F5F7),
                edgeHighlightColor = Brush.linearGradient(
                    listOf(
                        Color(0x8DFFFFFF),
                        Color(0x00FFFFFF),
                        Color(0x8DFFFFFF)
                    )
                )
            )
        )
    }
}
