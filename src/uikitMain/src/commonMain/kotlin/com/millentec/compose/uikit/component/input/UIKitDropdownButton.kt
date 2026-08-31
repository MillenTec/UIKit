package com.millentec.compose.uikit.component.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.flyout.UIKitDropdownMenu
import com.millentec.compose.uikit.component.flyout.UIKitFlyouter
import com.millentec.compose.uikit.foundation.graphics.AcrylicMaterialState
import com.millentec.compose.uikit.foundation.layout.UIKitMenuScope
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitFlyouter {

    }
}

data class UIKitDropdownButtonColors(
    val background: Color,
    val backgroundDisabled: Color,
    val content: Color,
    val contentDisabled: Color,
    val border: Color,
    val borderDisabled: Color,
    val menuBackground: Color,
    val menuDivider: Color,
    val menuContent: Color,
    val menuBorder: Color
) {
    companion object {
        @Composable
        fun default(
            background: Color = getUIKitColors().contentFillColorTertiaryBrush,
            backgroundDisabled: Color = getUIKitColors().contentFillColorBrushDisabled,
            content: Color = getUIKitColors().textFillColorPrimaryBrush,
            contentDisabled: Color = getUIKitColors().textFillColorDisabled,
            border: Color = getUIKitColors().lineFillColorPrimaryBrush,
            borderDisabled: Color = getUIKitColors().lineFillColorPrimaryBrush,
            menuBackground: Color = getUIKitColors().contentFillColorSecondaryBrush,
            menuDivider: Color = getUIKitColors().lineFillColorPrimaryBrush,
            menuContent: Color = getUIKitColors().textFillColorPrimaryBrush,
            menuBorder: Color = getUIKitColors().lineFillColorPrimaryBrush,
        ): UIKitDropdownButtonColors {
            return UIKitDropdownButtonColors(
                background = background,
                backgroundDisabled = backgroundDisabled,
                content = content,
                contentDisabled = contentDisabled,
                border = border,
                borderDisabled = borderDisabled,
                menuBackground = menuBackground,
                menuDivider = menuDivider,
                menuContent = menuContent,
                menuBorder = menuBorder,
            )
        }
    }
}

@Composable
fun UIKitDropdownButton(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    maxLength: Dp = 360.dp,
    minWidth: Dp = 200.dp,
    offset: DpOffset = DpOffset.Zero,
    onDismissRequest: (() -> Unit)? = null,
    colors: UIKitDropdownButtonColors = UIKitDropdownButtonColors.default(),
    hasBorder: Boolean = true,
    borderWidth: Dp = 1.dp,
    appearPosition: Alignment? = null,
    acrylicEffectEnabled: Boolean = true,
    acrylicMaterialState: AcrylicMaterialState? = null,
    acrylicMaterial: UIKitAcrylicMaterial = getUIKitMaterials().acrylicMaterial.copy(
        tint = getUIKitMaterials().acrylicMaterial.tint.copy(0.6f),
        lightingEffectsEnabled = false
    ),
    content: @Composable UIKitMenuScope.() -> Unit,
    clickableContent: @Composable BoxScope.() -> Unit
) {
    val uiKitTheme = getUIKitTheme()

    val position = remember { mutableStateOf(Offset.Zero) }
    val buttonSize = remember { mutableStateOf(IntSize.Zero) }
    val contentSize = remember { mutableStateOf(IntSize.Zero) }
    val densityDpi = LocalDensity.current.density
    val rootSize = remember { mutableStateOf(IntSize.Zero) }

    Box(
        modifier = modifier
            .onGloballyPositioned {
                if (it.isAttached) {
                    position.value = it.positionInRoot()
                    buttonSize.value = it.size
                }
            },
        content = clickableContent
    )

    UIKitDropdownMenu(
        modifier = Modifier
            .then(if (hasBorder) {
                Modifier.border(
                    width = borderWidth,
                    color = colors.menuBorder,
                    shape = RoundedCornerShape(cornerRadius)
                )
            } else Modifier),
        expanded = expanded,
        acrylicEffectEnabled = acrylicEffectEnabled,
        acrylicMaterialState = acrylicMaterialState,
        acrylicMaterial = acrylicMaterial,
        cornerRadius = cornerRadius,
        maxLength = maxLength,
        minWidth = minWidth,
        alignment = Alignment.TopStart,
        appearPosition = appearPosition ?: (if (rootSize.value.height -(position.value.y + buttonSize.value.height + (uiKitTheme.layout.mediumSpacing * densityDpi).value) >= contentSize.value.height)
            Alignment.TopCenter
        else Alignment.BottomCenter),
        offset = { root, content ->
            rootSize.value = root
            contentSize.value = content
            DpOffset(
                x = (position.value.x / densityDpi).dp - (if (rootSize.value.width - position.value.x >= contentSize.value.width) 0.dp
                else ((contentSize.value.width - buttonSize.value.width) / densityDpi).dp),
                y = (position.value.y / densityDpi).dp + (
                        if (rootSize.value.height -(position.value.y + buttonSize.value.height + (uiKitTheme.layout.mediumSpacing * densityDpi).value) >= contentSize.value.height)
                            ((buttonSize.value.height / densityDpi).dp + uiKitTheme.layout.mediumSpacing)
                            else (-(contentSize.value.height / densityDpi).dp - uiKitTheme.layout.mediumSpacing)
                )
            ) + offset
        },
        onDismissRequest = onDismissRequest,
        content = content
    )
}