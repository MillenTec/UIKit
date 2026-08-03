package com.millentec.compose.uikit.component.flyout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.layout.VerticalItemLayout
import com.millentec.compose.uikit.foundation.materials.AcrylicMaterialsState
import com.millentec.compose.uikit.foundation.materials.acrylicMaterial
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Accessibility
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Settings
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
                    Pair("Item 1", FluentIcons.Accessibility),
                    Pair("Item 2", FluentIcons.Text),
                    Pair("Item 3", FluentIcons.Settings),
                ),
                onClick = {},
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
    items: List<@Composable BoxScope.() -> Unit>,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().smallSpacing),
    itemSpacing: Dp = getUIKitLayout().smallSpacing,
    hasDividers: Boolean = true,
    dividerColor: Color = getUIKitColors().lineFillColorPrimaryBrush,
    onClick: (Int) -> Unit,
    alignment: Alignment = Alignment.Center,
    offset: (IntSize, IntSize) -> DpOffset = { rootSize, contentSize -> DpOffset.Zero },
    onDismissRequest: (() -> Unit)? = null,
    appearPosition: Alignment = Alignment.BottomEnd,
    acrylicEffectEnabled: Boolean = true,
    acrylicMaterialsState: AcrylicMaterialsState? = null,
    shadowEnabled: Boolean = true,
) {
    val contentSize = remember { mutableStateOf(IntSize.Zero) }
    val expandedWithoutAnimate = remember { mutableStateOf(expanded) }

    LaunchedEffect(expanded) {
        if (expanded)
            expandedWithoutAnimate.value = true
    }

    UIKitPopup(
        alignment = alignment,
        offset = { root, content ->
            offset(root, contentSize.value)
        },
        onDismissRequest = onDismissRequest,
        dismissOnClickOutside = expanded,
    ) {
        Box(
            modifier = Modifier
                .then(
                    if (contentSize.value != IntSize.Zero && expandedWithoutAnimate.value) {
                        println("contentSize: ${contentSize.value}")
                        Modifier.size(
                            width = (contentSize.value.width / LocalDensity.current.density).dp,
                            height = (contentSize.value.height / LocalDensity.current.density).dp
                        )
                    } else Modifier
                ),
            contentAlignment = appearPosition
        ) {
            val transition = updateTransition(expanded, label = "Dropdown Menu Animation")

            LaunchedEffect(transition.isRunning) {
                if (!transition.isRunning && !expanded) {
                    expandedWithoutAnimate.value
                }
            }

            transition.AnimatedVisibility(
                visible = {
                    it
                },
                modifier = modifier
                    .background(background, RoundedCornerShape(cornerRadius))
                    .then(
                        if (shadowEnabled) {
                            Modifier.dropShadow(
                                shape = RoundedCornerShape(cornerRadius),
                                shadow = UIKitShadowMaterial.getMarginal()
                            )
                        } else Modifier
                    )
                    .then(
                        if (acrylicEffectEnabled && acrylicMaterialsState != null && getUIKitMaterials().acrylicMaterial.lightingEffectsEnabled) {
                            Modifier.border(
                                width = getUIKitMaterials().acrylicMaterial.edgeHighlightThickness,
                                brush = getUIKitMaterials().acrylicMaterial.edgeHighlightColor,
                                shape = RoundedCornerShape(cornerRadius)
                            )
                        } else Modifier
                    )
                    .clip(RoundedCornerShape(cornerRadius)),
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
                )
            ) {
                VerticalItemLayout(
                    modifier = Modifier
                        .then(
                            if (acrylicEffectEnabled && acrylicMaterialsState != null) {
                                Modifier.acrylicMaterial(
                                    state = acrylicMaterialsState,
                                    shape = RoundedCornerShape(cornerRadius),
                                    highlightEnabled = false
                                )
                            } else Modifier
                        )
                        .onGloballyPositioned {
                            if (contentSize.value != it.size && it.isAttached)
                                contentSize.value = it.size
                        },
                    maxLength = maxLength,
                    minWidth = minWidth,
                    items = items,
                    background = if (acrylicEffectEnabled && acrylicMaterialsState != null) background.copy(0f) else background,
                    cornerRadius = cornerRadius,
                    contentPadding = contentPadding,
                    itemSpacing = itemSpacing,
                    hasDividers = hasDividers,
                    dividerColor = dividerColor,
                    onClick = onClick
                )
            }
        }
    }
}

@Composable
fun UIKitDropdownMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    maxLength: Dp = (-1).dp,
    minWidth: Dp = 200.dp,
    items: List<Pair<String, ImageVector?>>,
    iconTint: Color = getUIKitColors().textFillColorPrimaryBrush,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    cornerRadius: Dp = getUIKitShapes().regularRounded,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().smallSpacing),
    itemSpacing: Dp = getUIKitLayout().smallSpacing,
    hasDividers: Boolean = true,
    dividerColor: Color = getUIKitColors().lineFillColorPrimaryBrush,
    onClick: (Int) -> Unit,
    alignment: Alignment = Alignment.Center,
    offset: (IntSize, IntSize) -> DpOffset = { rootSize, contentSize -> DpOffset.Zero },
    onDismissRequest: (() -> Unit)? = null,
    appearPosition: Alignment = Alignment.BottomEnd,
    acrylicEffectEnabled: Boolean = true,
    acrylicMaterialsState: AcrylicMaterialsState? = null
) {
    val itemList = remember { mutableStateListOf<@Composable BoxScope.() -> Unit>() }

    LaunchedEffect(items) {
        itemList.clear()
        items.forEach {
            itemList.add @Composable {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    it.second?.let { icon ->
                        Icon(
                            modifier = Modifier
                                .size(getUIKitTypography().body.lineHeight.value.dp),
                            imageVector = icon,
                            contentDescription = null,
                            tint = iconTint,
                        )

                        Spacer(Modifier.width(getUIKitLayout().basicSpacing))
                    }

                    Text(
                        text = it.first,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush,
                    )
                }
            }
        }
    }

    UIKitDropdownMenu(
        modifier = modifier,
        expanded = expanded,
        maxLength = maxLength,
        minWidth = minWidth,
        items = itemList,
        background = background,
        cornerRadius = cornerRadius,
        contentPadding = contentPadding,
        itemSpacing = itemSpacing,
        hasDividers = hasDividers,
        dividerColor = dividerColor,
        onClick = onClick,
        alignment = alignment,
        offset = offset,
        onDismissRequest = onDismissRequest,
        appearPosition = appearPosition,
        acrylicEffectEnabled = acrylicEffectEnabled,
        acrylicMaterialsState = acrylicMaterialsState
    )
}