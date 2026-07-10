package com.millentec.compose.uikit.component.input

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.millentec.compose.uikit.component.layout.ScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.component.layout.rememberScreenSideAdaptiveContainerState
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.foundation.materials.AcrylicMaterialsState
import com.millentec.compose.uikit.foundation.materials.acrylicMaterial
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Add
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.Home
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.designIdeas
import com.millentec.compose.uikit.theme.*

@Composable
@Preview
private fun Preview() {
    UIKitIslandButton(
        modifier = Modifier
            .fillMaxSize(),
        onClicked = {},
        items = listOf(
            {
                Icon(
                    imageVector = FluentIcons.Home,
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            },
            {
                Icon(
                    imageVector = FluentIcons.Add,
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            },
            {
                Icon(
                    imageVector = FluentIcons.designIdeas(),
                    contentDescription = null,
                    tint = getUIKitColors().textFillColorPrimaryBrush
                )
            }
        ),
        state = rememberScreenSideAdaptiveContainerState(
            position = LayoutPosition.TopRight,
            fillWidth = false,
            fillHeight = false,
        )
    )
}

@Composable
fun UIKitIslandButton(
    modifier: Modifier = Modifier,
    itemSpace: Dp = getUIKitLayout().smallSpacing,
    onClicked: (Int) -> Unit,
    items: List<@Composable BoxScope.() -> Unit>,
    background: Color = getUIKitColors().contentFillColorSecondaryBrush,
    hasDivider: Boolean = true,
    dividerColor: Color = getUIKitColors().lineFillColorPrimaryBrush,
    dividerWidth: Dp = 1.dp,
    state: ScreenSideAdaptiveContainerState,
    acrylicEffectEnabled: Boolean = true,
    acrylicState: AcrylicMaterialsState? = null,
    shadowEnable: Boolean = true,
) {
    println(items.size)

    val containerPadding = getUIKitLayout().smallSpacing
    val containerLength = remember(state, itemSpace, items.size) { state.height * items.size + itemSpace * (items.size - 1) }

    val containerLengthAnimated by animateDpAsState(
        targetValue = containerLength,
        animationSpec = spring(
            dampingRatio = getUIKitAnimate().standardSpringDampingRatio,
            stiffness = getUIKitAnimate().standardSpringStiffness
        )
    )

    Box(
        modifier = modifier,
        contentAlignment = state.alignment
    ) {
        val pressed = remember { mutableStateOf(false) }
        val buttonScaleAnimated by animateFloatAsState(
            targetValue = if (pressed.value) 0.9f else 1f,
            animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = FastOutSlowInEasing)
        )

        Box(
            modifier = Modifier
                .padding(state.margins)
                .graphicsLayer(
                    scaleX = buttonScaleAnimated,
                    scaleY = buttonScaleAnimated,
                )
                .then(if (shadowEnable && getUIKitMaterials().ambientShadowMaterial.shadowEnable)
                    Modifier.shadow(
                        elevation = getUIKitMaterials().ambientShadowMaterial.elevation,
                        shape = RoundedCornerShape(state.cornerRadius),
                        ambientColor = getUIKitMaterials().ambientShadowMaterial.ambientColor,
                        spotColor = getUIKitMaterials().ambientShadowMaterial.spotColor,
                    ) else Modifier)
                .clip(RoundedCornerShape(state.cornerRadius))
                .height(state.height)
                .width(containerLengthAnimated)
                .then(if (items.size == 1)
                    Modifier.pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                pressed.value = true
                                tryAwaitRelease()
                                pressed.value = false
                            },
                            onTap = {
                                onClicked(0)
                            }
                        )
                    } else Modifier)
                .background(if (acrylicEffectEnabled && acrylicState != null) Color.Transparent else background)
                .then(if (acrylicEffectEnabled && acrylicState != null) Modifier.acrylicMaterial(acrylicState) else Modifier)
                .then(if (acrylicEffectEnabled && getUIKitMaterials().acrylicMaterial.lightingEffectsEnabled)
                    Modifier.border(
                        width = getUIKitMaterials().acrylicMaterial.edgeHighlightThickness,
                        brush = getUIKitMaterials().acrylicMaterial.edgeHighlightColor,
                        shape = RoundedCornerShape(getUIKitShapes().circular)
                    ) else Modifier)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEachIndexed { index, item ->
                    val pressed = remember { mutableStateOf(false) }
                    val contentScaleAnimated by animateFloatAsState(
                        targetValue = if (pressed.value) 0.90f else 1f,
                        animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis, easing = FastOutSlowInEasing)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                            .then(
                                if (items.size != 1)
                                    Modifier.pointerInput(Unit) {
                                        detectTapGestures(
                                            onPress = {
                                                pressed.value = true
                                                tryAwaitRelease()
                                                pressed.value = false
                                            },
                                            onTap = {
                                                onClicked(index)
                                            }
                                        )
                                    } else Modifier)
                            .padding(containerPadding)
                            .graphicsLayer(
                                scaleX = contentScaleAnimated,
                                scaleY = contentScaleAnimated,
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedContent(
                            targetState = item
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .graphicsLayer(
                                        scaleX = contentScaleAnimated,
                                        scaleY = contentScaleAnimated
                                    ),
                                contentAlignment = Alignment.Center,
                                content = it
                            )
                        }
                    }

                    if (index != items.size - 1 && itemSpace != 0.dp) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(itemSpace),
                            contentAlignment = Alignment.Center,
                        ) {
                            if (hasDivider) {
                                VerticalDivider(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(vertical = getUIKitLayout().basicSpacing),
                                    thickness = dividerWidth,
                                    color = dividerColor
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}