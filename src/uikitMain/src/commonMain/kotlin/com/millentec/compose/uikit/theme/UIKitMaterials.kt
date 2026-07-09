package com.millentec.compose.uikit.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class UIKitAcrylicMaterial(
    val radius: Int = 100,
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

data class UIKitMaterials(
    val acrylicMaterial: UIKitAcrylicMaterial = UIKitAcrylicMaterial()
) {
    companion object {
        fun getLight(): UIKitMaterials {
            return UIKitMaterials()
        }

        fun getDark(): UIKitMaterials {
            return UIKitMaterials(
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
}
