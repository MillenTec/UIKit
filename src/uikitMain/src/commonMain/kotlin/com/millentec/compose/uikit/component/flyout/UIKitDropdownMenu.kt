package com.millentec.compose.uikit.component.flyout

import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.layout.VerticalItemLayout
import com.millentec.compose.uikit.foundation.layout.UIKitMenuItem
import com.millentec.compose.uikit.foundation.materials.AcrylicMaterialsState
import com.millentec.compose.uikit.foundation.materials.acrylicMaterial
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Accessibility
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Text
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitFlyouter {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            UIKitDropdownMenu(
                expanded = true,
                items = listOf(
                    UIKitMenuItem.textWithIcon(FluentIcons.Accessibility, "Option 1", onClick = {}),
                    UIKitMenuItem.text("Option 2", onClick = {}, background = getUIKitColors().successGreenColorFourthBrush),
                    UIKitMenuItem.icon(FluentIcons.Text, onClick = {}),
                ),
                onDismissRequest = {}
            )
        }
    }
}

@Composable
fun UIKitDropdownMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    maxLength: Dp = (-1).dp,
    minWidth: Dp = 200.dp,
    items: List<UIKitMenuItem>,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().smallSpacing),
    alignment: Alignment = Alignment.Center,
    offset: (IntSize, IntSize) -> DpOffset = { rootSize, contentSize -> DpOffset.Zero },
    onDismissRequest: (() -> Unit)? = null,
    appearPosition: Alignment = Alignment.BottomEnd,
    acrylicEffectEnabled: Boolean = true,
    acrylicMaterialsState: AcrylicMaterialsState? = null,
    acrylicMaterial: UIKitAcrylicMaterial = getUIKitMaterials().acrylicMaterial,
    shadowEnabled: Boolean = true,
) {
    val positionOnRoot = remember { mutableStateOf(Offset.Zero) }

    LaunchedEffect(positionOnRoot.value) {
        acrylicMaterialsState?.invalidate()
    }

    UIKitPopup(
        modifier = Modifier
            .then(if (shadowEnabled) {
                Modifier.dropShadow(
                    shape = RoundedCornerShape(cornerRadius),
                    shadow = UIKitShadowMaterial.getMarginal()
                )
            } else Modifier)
            .clip(RoundedCornerShape(cornerRadius))
            .onGloballyPositioned {
                if (it.isAttached)
                    positionOnRoot.value = it.positionInRoot()
            },
        alignment = alignment,
        offset = offset,
        animateAlignment = appearPosition,
        visible = expanded,
        enter = expandIn(
            expandFrom = appearPosition,
            animationSpec = spring(
                stiffness = getUIKitAnimate().standardSpringStiffness * 2,
                visibilityThreshold = IntSize.VisibilityThreshold
            ),
            initialSize = {
                when (appearPosition) {
                    Alignment.TopCenter, Alignment.BottomCenter -> {
                        IntSize(width = it.width, height = 0)
                    }

                    Alignment.CenterStart, Alignment.CenterEnd -> {
                        IntSize(width = 0, height = it.height)
                    }

                    else -> IntSize.Zero
                }
            }
        ),
        exit = shrinkOut(
            shrinkTowards = appearPosition,
            animationSpec = spring(
                stiffness = getUIKitAnimate().standardSpringStiffness * 2,
                visibilityThreshold = IntSize.VisibilityThreshold
            ),
            targetSize = {
                when (appearPosition) {
                    Alignment.TopCenter, Alignment.BottomCenter -> {
                        IntSize(width = it.width, height = 0)
                    }

                    Alignment.CenterStart, Alignment.CenterEnd -> {
                        IntSize(width = 0, height = it.height)
                    }

                    else -> IntSize.Zero
                }
            }
        ),
        onDismissRequest = onDismissRequest,
        dismissOnClickOutside = expanded,
    ) {
        VerticalItemLayout(
            modifier = modifier
                .then(
                    if (acrylicEffectEnabled && acrylicMaterialsState != null) {
                        Modifier.acrylicMaterial(
                            state = acrylicMaterialsState,
                            shape = RoundedCornerShape(cornerRadius),
                            acrylicMaterial = acrylicMaterial
                        )
                    } else Modifier
                ),
            maxLength = maxLength,
            minWidth = minWidth,
            items = items,
            background = if (acrylicEffectEnabled && acrylicMaterialsState != null) background.copy(0f) else background,
            cornerRadius = cornerRadius,
            contentPadding = contentPadding,
        )
    }
}