package com.millentec.compose.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

data class UIKitAcrylicMaterial(
    val radius: Dp = 40.dp,
    val tint: Color = Color(0x4CF5F5F7),
    val cpuComputationEnabled: Boolean = false,

    val lightingEffectsEnabled: Boolean = true,
    val edgeHighlightStops: List<Pair<Float, Color>> = listOf(
        Pair(0f, Color(255f, 255f, 255f, 1f)),
        Pair(0.02f, Color(255f, 255f, 255f, 0.95f)),
        Pair(0.12f, Color(255f, 255f, 255f, 0.67f)),
        Pair(0.22f, Color(255f, 255f, 255f, 0.43f)),
        Pair(0.31f, Color(255f, 255f, 255f, 0.24f)),
        Pair(0.39f, Color(255f, 255f, 255f, 0.11f)),
        Pair(0.46f, Color(255f, 255f, 255f, 0.03f)),
        Pair(0.5f, Color(255f, 255f, 255f, 0f)),
        Pair(0.54f, Color(255f, 255f, 255f, 0.03f)),
        Pair(0.61f, Color(255f, 255f, 255f, 0.11f)),
        Pair(0.69f, Color(255f, 255f, 255f, 0.24f)),
        Pair(0.78f, Color(255f, 255f, 255f, 0.43f)),
        Pair(0.88f, Color(255f, 255f, 255f, 0.67f)),
        Pair(0.98f, Color(255f, 255f, 255f, 0.95f)),
        Pair(1f, Color(255f, 255f, 255f, 1f))
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
        private const val HIGHLIGHT_ALPHA_COEFF = 0.5f

        fun getLight(): UIKitMaterials = UIKitMaterials()

        fun getDark(): UIKitMaterials = UIKitMaterials(
            acrylicMaterial = UIKitAcrylicMaterial(
                tint = Color(0x4C1D1D1F),
                edgeHighlightStops = listOf(
                    Pair(0f, Color(255f, 255f, 255f, 1f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.02f, Color(255f, 255f, 255f, 0.95f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.12f, Color(255f, 255f, 255f, 0.67f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.22f, Color(255f, 255f, 255f, 0.43f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.31f, Color(255f, 255f, 255f, 0.24f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.39f, Color(255f, 255f, 255f, 0.11f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.46f, Color(255f, 255f, 255f, 0.03f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.5f, Color(255f, 255f, 255f, 0f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.54f, Color(255f, 255f, 255f, 0.03f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.61f, Color(255f, 255f, 255f, 0.11f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.69f, Color(255f, 255f, 255f, 0.24f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.78f, Color(255f, 255f, 255f, 0.43f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.88f, Color(255f, 255f, 255f, 0.67f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(0.98f, Color(255f, 255f, 255f, 0.95f * HIGHLIGHT_ALPHA_COEFF)),
                    Pair(1f, Color(255f, 255f, 255f, 1f * HIGHLIGHT_ALPHA_COEFF))
                )
            )
        )
    }
}
