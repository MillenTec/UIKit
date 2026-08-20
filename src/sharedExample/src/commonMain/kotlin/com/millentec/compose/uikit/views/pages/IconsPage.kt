package com.millentec.compose.uikit.views.pages

import androidx.compose.animation.*
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.IconGalleryList
import com.millentec.compose.uikit.component.flyout.UIKitSwipeableFlyoutState
import com.millentec.compose.uikit.component.input.UIKitHSVColorPicker
import com.millentec.compose.uikit.component.input.UIKitSlider
import com.millentec.compose.uikit.component.input.UIKitSliderChangeType
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.layout.*
import com.millentec.compose.uikit.foundation.UIKitHSVColor
import com.millentec.compose.uikit.foundation.helper.UIKitInteraction
import com.millentec.compose.uikit.foundation.helper.mapTo
import com.millentec.compose.uikit.foundation.helper.toHsv
import com.millentec.compose.uikit.foundation.helper.uikitClickable
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.layout.UIKitAlignment
import com.millentec.compose.uikit.foundation.layout.UIKitCardItem
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialState
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.animatable.*
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.icons.fluenticons.resizeable.shapes
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.views.LocalNavigationDockHeight
import kotlin.math.ceil
import kotlin.math.floor

private data class IconInfo(
    val iconName: String,
    val iconSize: String,
)

private class OptionState(
    initialTint: UIKitHSVColor,
    initialBackground: UIKitHSVColor,
    initialLayered: Boolean = false
) {
    val tintColor = mutableStateOf(initialTint)
    val backgroundColor = mutableStateOf(initialBackground)
    val isLayered = mutableStateOf(initialLayered)
    val iconPreview = mutableStateOf<(@Composable BoxScope.() -> Unit)?>(null)
    val extendedOptions = mutableStateOf<(@Composable ColumnScope.() -> Unit)?>(null)
    val iconInfo = mutableStateOf<IconInfo?>(null)
}

@Composable
@Preview
private fun OptionsWindowPreview() {
    val optionState = OptionState(
        initialTint = getUIKitColors().textFillColorPrimaryBrush.toHsv(),
        initialBackground = getUIKitColors().contentFillColorSecondaryBrush.toHsv()
    )

    optionState.iconPreview.value = {
        BoxWithConstraints {
            Icon(
                modifier = Modifier
                    .size(maxWidth * 0.6f),
                imageVector = FluentIcons.Symbols,
                contentDescription = null,
                tint = optionState.tintColor.value.getColor(),
            )
        }
    }

    optionState.iconInfo.value = IconInfo(
        iconName = "Symbols",
        iconSize = "20 x 20"
    )

    OptionsWindow(
        optionState
    )
}

data class OptionalColorInfo(
    val color: Color,
    val name: String,
    val contentColor: Color
)

@Composable
private fun OptionsWindow(
    state: OptionState,
) {
    val tintColorPickerExpanded = remember { mutableStateOf(false) }
    val backgroundColorPickerExpanded = remember { mutableStateOf(false) }
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(getUIKitLayout().x2Spacing)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.iconPreview.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                .fillMaxWidth()
                                .background(getUIKitColors().contentFillColorSecondaryBrush)
                                .padding(getUIKitLayout().mediumSpacing),
                            contentAlignment = Alignment.Center,
                            content = state.iconPreview.value ?: {}
                        )

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.iconPreview.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = LocalStrings.current.designs.fluentIcons.options.info,
                                style = getUIKitTypography().body,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                            HorizontalDivider(
                                thickness = 1.dp,
                                color = getUIKitColors().lineFillColorPrimaryBrush
                            )
                        }

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.iconPreview.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    UIKitGroupedCard(
                        items = listOf(
                            UIKitCardItem.settingCard(
                                icon = FluentIcons.Tag,
                                title = LocalStrings.current.designs.fluentIcons.options.name,
                                onClick = {}
                            ) {
                                Text(
                                    text = state.iconInfo.value?.iconName ?: "Unknown",
                                    style = getUIKitTypography().body,
                                    color = getUIKitColors().textFillColorSecondaryBrush
                                )
                            },
                            UIKitCardItem.divider(),
                            UIKitCardItem.settingCard(
                                icon = FluentIcons.Resize,
                                title = LocalStrings.current.designs.fluentIcons.options.size,
                                onClick = {}
                            ) {
                                Text(
                                    text = state.iconInfo.value?.iconSize ?: "Unknown",
                                    style = getUIKitTypography().body,
                                    color = getUIKitColors().textFillColorSecondaryBrush
                                )
                            }
                        )
                    )

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.extendedOptions.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = LocalStrings.current.designs.fluentIcons.options.extension,
                            style = getUIKitTypography().body,
                            color = getUIKitColors().textFillColorSecondaryBrush
                        )

                        Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                        HorizontalDivider(
                            thickness = 1.dp,
                            color = getUIKitColors().lineFillColorPrimaryBrush
                        )
                    }

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis
                        )
                    )
            ) {
                AnimatedVisibility(
                    visible = state.extendedOptions.value != null,
                    enter = fadeIn(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis)),
                    exit = fadeOut(animationSpec = tween(getUIKitAnimate().transformRegularDurationMillis))
                ) {
                    Column {
                        Column(
                            content = state.extendedOptions.value ?: {}
                        )

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    }
                }
            }
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = LocalStrings.current.designs.fluentIcons.options.general,
                    style = getUIKitTypography().body,
                    color = getUIKitColors().textFillColorSecondaryBrush
                )

                Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = getUIKitColors().lineFillColorPrimaryBrush
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingCard(
                icon = FluentIcons.layerDiagonal(getUIKitColors().textFillColorPrimaryBrush, true),
                title = LocalStrings.current.designs.fluentIcons.options.layeredIcon,
                onClick = {
                    state.isLayered.value = !state.isLayered.value
                }
            ) {
                UIKitToggleSwitch(
                    checked = state.isLayered.value,
                    onCheckedChange = {
                        state.isLayered.value = it
                    }
                )
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }
        
        item {
            UIKitSettingsExpander(
                expanded = tintColorPickerExpanded.value,
                onClick = {
                    tintColorPickerExpanded.value = !tintColorPickerExpanded.value
                },
                title = LocalStrings.current.designs.fluentIcons.options.tintColor,
                icon = FluentIcons.PaintBrush
            ) {
                UIKitHSVColorPicker(
                    color = state.tintColor.value,
                    onColorChange = {
                        state.tintColor.value = it
                    }
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                val itemHeight = 48.dp

                val optionalColor = listOf(
                    OptionalColorInfo(getUIKitColors().textFillColorPrimaryBrush, "Primary", getUIKitColors().contentFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().textFillColorPrimaryBrushReversed, "Reversed", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().highlightColorPrimaryBrush, "Highlight", UIKitColors.getDark().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().successGreenColorPrimaryBrush, "Success", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().warningYellowColorPrimaryBrush, "Warning", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().errorRedColorPrimaryBrush, "Error", UIKitColors.getDark().textFillColorPrimaryBrush),
                )

                BoxWithConstraints {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .height(
                                (ceil(optionalColor.size / floor(maxWidth / 128.dp)) * itemHeight) + getUIKitLayout().smallSpacing * ceil(optionalColor.size / floor(maxWidth / 128.dp)) * 2
                            ),
                        columns = GridCells.Adaptive(128.dp),
                        userScrollEnabled = false
                    ) {
                        items(optionalColor.size) {
                            Box(
                                modifier = Modifier
                                    .padding(getUIKitLayout().smallSpacing)
                                    .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                    .height(itemHeight)
                                    .background(optionalColor[it].color)
                                    .uikitClickable(
                                        onClick = {
                                            state.tintColor.value = optionalColor[it].color.toHsv()
                                        },
                                        indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                                    ),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = optionalColor[it].name,
                                    style = getUIKitTypography().body,
                                    color = optionalColor[it].contentColor,
                                )
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }

        item {
            UIKitSettingsExpander(
                expanded = backgroundColorPickerExpanded.value,
                onClick = {
                    backgroundColorPickerExpanded.value = !backgroundColorPickerExpanded.value
                },
                title = LocalStrings.current.designs.fluentIcons.options.backgroundColor,
                icon = FluentIcons.PaintBucket
            ) {
                UIKitHSVColorPicker(
                    color = state.backgroundColor.value,
                    onColorChange = {
                        state.backgroundColor.value = it
                    }
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                val itemHeight = 48.dp

                val optionalColor = listOf(
                    OptionalColorInfo(getUIKitColors().contentFillColorPrimaryBrush, "Primary", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().contentFillColorSecondaryBrush, "Secondary", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().highlightColorFourthBrush, "Highlight", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().successGreenColorFourthBrush, "Success", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().warningYellowColorFourthBrush, "Warning", getUIKitColors().textFillColorPrimaryBrush),
                    OptionalColorInfo(getUIKitColors().errorRedColorFourthBrush, "Error", getUIKitColors().textFillColorPrimaryBrush),
                )

                BoxWithConstraints {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .height(
                                (ceil(optionalColor.size / floor(maxWidth / 128.dp)) * itemHeight) + getUIKitLayout().smallSpacing * ceil(optionalColor.size / floor(maxWidth / 128.dp)) * 2
                            ),
                        columns = GridCells.Adaptive(128.dp),
                        userScrollEnabled = false
                    ) {
                        items(optionalColor.size) {
                            Box(
                                modifier = Modifier
                                    .padding(getUIKitLayout().smallSpacing)
                                    .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                    .height(itemHeight)
                                    .background(optionalColor[it].color)
                                    .uikitClickable(
                                        onClick = {
                                            state.backgroundColor.value = optionalColor[it].color.toHsv()
                                        },
                                        indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                                    ),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = optionalColor[it].name,
                                    style = getUIKitTypography().body,
                                    color = optionalColor[it].contentColor,
                                )
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
        }
    }
}

@Composable
@Preview
private fun IconItemPreview() {
    Box(
        modifier = Modifier
            .size(128.dp)
    ) {
        IconItem(
            title = "Icon",
            onClick = {},
            background = getUIKitColors().contentFillColorSecondaryBrush,
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(),
                imageVector = FluentIcons.Tag,
                contentDescription = null,
                tint = getUIKitColors().textFillColorPrimaryBrush
            )
        }
    }
}

@Composable
private fun IconItem(
    title: String,
    onClick: () -> Unit,
    background: Color,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(getUIKitLayout().smallSpacing)
            .clip(RoundedCornerShape(getUIKitShapes().mediumRounded))
            .background(background)
            .uikitClickable(
                onClick = onClick,
                indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
            )
            .padding(getUIKitLayout().mediumSpacing),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            content()
        }

        Spacer(Modifier.height(getUIKitLayout().smallSpacing))

        Text(
            text = title,
            style = getUIKitTypography().body,
            color = getUIKitColors().textFillColorPrimaryBrush,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview
fun IconGalleryPage() {
    val uikitTheme = getUIKitTheme()
    val acrylicMaterialsState = rememberAcrylicMaterialState()
    val optionsState = remember { OptionState(
        initialTint = uikitTheme.colors.highlightColorPrimaryBrush.toHsv(),
        initialBackground = uikitTheme.colors.contentFillColorSecondaryBrush.toHsv()
    ) }
    val iconLists = remember { mutableStateOf(IconGalleryList(
        optionsState.tintColor.value.getColor(),
        optionsState.isLayered.value
    )) }
    val checkedIconIndex = remember { mutableStateOf<Int?>(null) }
    val bottomSheetState = remember { UIKitSwipeableFlyoutState() }
    val animatableIconList = remember { makeAnimatableIconList(optionsState) }
    val bottomSheetExpanded = remember { mutableStateOf(false) }

    LaunchedEffect(optionsState.isLayered.value, optionsState.tintColor.value) {
        iconLists.value = IconGalleryList(
            optionsState.tintColor.value.getColor(),
            optionsState.isLayered.value
        )
    }

    LaunchedEffect(checkedIconIndex.value) {
        optionsState.extendedOptions.value = null
        optionsState.iconPreview.value = if (checkedIconIndex.value == null) null else {
            val icon = if ((checkedIconIndex.value ?: return@LaunchedEffect) < iconLists.value.regularIconsList.size) {
                iconLists.value.regularIconsList.getOrNull(checkedIconIndex.value ?: return@LaunchedEffect) ?: return@LaunchedEffect
            } else {
                iconLists.value.filledIconsList.getOrNull((checkedIconIndex.value ?: return@LaunchedEffect) - iconLists.value.regularIconsList.size) ?: return@LaunchedEffect
            }
            optionsState.iconInfo.value = IconInfo(
                iconName = icon.name,
                iconSize = "${icon.defaultWidth.value.toString().removeSuffix(".0")} x ${icon.defaultHeight.value.toString().removeSuffix(".0")}",
            );
            {
                BoxWithConstraints {
                    Icon(
                        modifier = Modifier
                            .size(maxWidth * 0.6f),
                        // 为保证能够被重组故需如此
                        imageVector = if ((checkedIconIndex.value ?: return@BoxWithConstraints) < iconLists.value.regularIconsList.size) {
                            iconLists.value.regularIconsList.getOrNull(checkedIconIndex.value ?: return@BoxWithConstraints) ?: return@BoxWithConstraints
                        } else {
                            iconLists.value.filledIconsList.getOrNull((checkedIconIndex.value ?: return@BoxWithConstraints) - iconLists.value.regularIconsList.size) ?: return@BoxWithConstraints
                        },
                        contentDescription = null,
                        tint = optionsState.tintColor.value.getColor(),
                    )
                }
            }
        }
    }

    BoxWithConstraints {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(getUIKitColors().contentFillColorPrimaryBrush)
                .uikitBottomSheetCollaborativeAnimation(
                    state = bottomSheetState,
                    blurEffectEnabled = AppTheme.useAcrylic.collectAsState().value
                )
        ) {
            Row {
                LazyVerticalGrid(
                    modifier = Modifier
                        .weight(1f)
                        .acrylicMaterialSource(acrylicMaterialsState),
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    contentPadding = PaddingValues(
                        start = getUIKitLayout().screenSideSpacing,
                        top = getUIKitLayout().screenSideSpacing,
                        end = getUIKitLayout().screenSideSpacing,
                        bottom = maxOf(
                            LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                            getUIKitLayout().screenSideSpacing
                        )
                    ) + WindowInsets.safeDrawing.asPaddingValues(LocalDensity.current)
                ) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Text(
                            text = LocalStrings.current.designs.fluentIcons.title,
                            style = getUIKitTypography().largeTitle,
                            color = getUIKitColors().textFillColorPrimaryBrush
                        )

                        Spacer(Modifier.height(getUIKitLayout().titleSpacing))
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Text(
                                text = LocalStrings.current.designs.fluentIcons.regularIcons,
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().subheadSpacing))
                        }
                    }

                    items(iconLists.value.regularIconsList.size) {
                        val icon = iconLists.value.regularIconsList.getOrNull(it)

                        IconItem(
                            title = icon?.name ?: "Unknown",
                            onClick = {
                                checkedIconIndex.value = it
                                if (this@BoxWithConstraints.maxWidth <= 1024.dp) bottomSheetExpanded.value = true
                            },
                            background = optionsState.backgroundColor.value.getColor()
                        ) {
                            if (icon != null) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                    tint = optionsState.tintColor.value.getColor()
                                )
                            }
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Spacer(Modifier.height(getUIKitLayout().sectionSpacing))

                            Text(
                                text = LocalStrings.current.designs.fluentIcons.filledIcons,
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().subheadSpacing))
                        }
                    }

                    items(iconLists.value.filledIconsList.size) {
                        val icon = iconLists.value.filledIconsList.getOrNull(it)

                        IconItem(
                            title = icon?.name ?: "Unknown",
                            onClick = {
                                checkedIconIndex.value = it + iconLists.value.regularIconsList.size
                                if (this@BoxWithConstraints.maxWidth <= 1024.dp) bottomSheetExpanded.value = true
                            },
                            background = optionsState.backgroundColor.value.getColor()
                        ) {
                            if (icon != null) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                    tint = optionsState.tintColor.value.getColor()
                                )
                            }
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Spacer(Modifier.height(getUIKitLayout().sectionSpacing))

                            Text(
                                text = LocalStrings.current.designs.fluentIcons.animatableIcons,
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().subheadSpacing))
                        }
                    }

                    items(animatableIconList.size) {
                        val item = animatableIconList.getOrNull(it)

                        IconItem(
                            title = item?.name ?: "Unknown",
                            onClick = {
                                optionsState.iconPreview.value = {
                                    BoxWithConstraints {
                                        item?.IconContent(
                                            modifier = Modifier
                                                .size(maxWidth * 0.6f)
                                        )
                                    }
                                }
                                optionsState.extendedOptions.value = {
                                    item?.ExtendedOptions()
                                }
                                optionsState.iconInfo.value = IconInfo(
                                    iconName = item?.name ?: "Unknown",
                                    iconSize = item?.size ?: "Unknown",
                                )
                                if (this@BoxWithConstraints.maxWidth <= 1024.dp) bottomSheetExpanded.value = true
                            },
                            background = optionsState.backgroundColor.value.getColor()
                        ) {
                            item?.IconContent(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .aspectRatio(1f)
                            )
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Spacer(Modifier.height(
                            maxOf(
                                LocalNavigationDockHeight.value + getUIKitLayout().screenSideSpacing,
                                getUIKitLayout().x4Spacing
                            )
                        ))
                    }
                }

                AnimatedVisibility(
                    visible = this@BoxWithConstraints.maxWidth >= 1024.dp,
                    enter = slideInHorizontally(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ) {
                        it
                    },
                    exit = slideOutHorizontally(
                        animationSpec = tween(
                            getUIKitAnimate().motionRegularDurationMillis,
                            easing = FastOutSlowInEasing
                        )
                    ) {
                        it
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .width(420.dp)
                            .fillMaxHeight()
                    ) {
                        Spacer(Modifier.height(getUIKitLayout().screenSideSpacing + (WindowInsets.safeDrawing.getTop(LocalDensity.current) / LocalDensity.current.density).dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(getUIKitTypography().largeTitle.lineHeight.value.dp),
                                imageVector = FluentIcons.options(getUIKitColors().textFillColorPrimaryBrush, true),
                                contentDescription = "Options",
                                tint = getUIKitColors().textFillColorPrimaryBrush
                            )

                            Spacer(Modifier.width(getUIKitLayout().mediumSpacing))

                            Text(
                                text = LocalStrings.current.designs.fluentIcons.options.title,
                                style = getUIKitTypography().largeTitle,
                                color = getUIKitColors().textFillColorPrimaryBrush
                            )
                        }

                        OptionsWindow(
                            optionsState
                        )
                    }
                }
            }

            if (this@BoxWithConstraints.maxWidth <= 1024.dp) {
                UIKitAdaptiveCornerContainer(
                    modifier = Modifier
                        .fillMaxSize(),
                    state = rememberUIKitAdaptiveCornerContainerState(
                        position = UIKitAlignment.TopEnd,
                        expectHeight = getUIKitLayout().interactiveHotspot,
                        expectWidth = getUIKitLayout().interactiveHotspot,
                        fillWidth = false,
                        fillHeight = false,
                    ),
                    acrylicEffectEnabled = AppTheme.useAcrylic.collectAsState().value,
                    acrylicState = acrylicMaterialsState,
                    onClick = {
                        bottomSheetExpanded.value = true
                    }
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize(0.6f),
                        imageVector = FluentIcons.options(getUIKitColors().textFillColorPrimaryBrush, true),
                        contentDescription = "Options",
                        tint = getUIKitColors().textFillColorPrimaryBrush
                    )
                }
            }
        }

        UIKitBottomSheet(
            expanded = bottomSheetExpanded.value,
            state = bottomSheetState,
            maxHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            minHeight = this@BoxWithConstraints.maxHeight * 0.8f,
            title = LocalStrings.current.designs.fluentIcons.options.title,
            onDismissRequest = {
                bottomSheetExpanded.value = false
            }
        ) {
            OptionsWindow(
                optionsState
            )
        }

        BackHandler(bottomSheetExpanded.value) {
            bottomSheetExpanded.value = false
        }
    }
}

private open class AnimatableIconItem(
    val name: String,
    val size: String,
    initialProgress: Float = 0f,
    initialLineWidth: Dp = 1.dp,
    initialState: Int = 0,
    initialGeneralOptionsState: OptionState,
) {
    // 几个属性, 故在基类中定义使用
    val progressProperty = mutableStateOf(initialProgress)
    val lineWidthProperty = mutableStateOf(initialLineWidth)
    val stateProperty = mutableStateOf(initialState)
    val generalOptionsStateProperty = initialGeneralOptionsState

    @Composable
    open fun IconContent(modifier: Modifier = Modifier) {}

    @Composable
    open fun ExtendedOptions() {}

    @Composable
    open fun CommonSlider(
        state: MutableState<Float>,
        iconStart: @Composable BoxScope.() -> Unit = {},
        iconEnd: @Composable BoxScope.() -> Unit = {},
        maxValue: Float = 1f,
    ) {
        val uikitTheme = getUIKitTheme()
        val isAnimatedChange = remember { mutableStateOf(false) }
        val value = remember { mutableStateOf(state.value) }
        val valueAnimated = remember { Animatable(
            initialValue = value.value,
            typeConverter = Float.VectorConverter,
        ) }

        LaunchedEffect(value.value) {
            if (isAnimatedChange.value) {
                valueAnimated.animateTo(
                    targetValue = value.value,
                    animationSpec = tween(
                        uikitTheme.animate.motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
            } else {
                valueAnimated.snapTo(value.value)
            }
        }

        LaunchedEffect(valueAnimated.value) {
            state.value = valueAnimated.value
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .background(getUIKitColors().contentFillColorSecondaryBrush)
                .padding(getUIKitLayout().basicSpacing)
        ) {
            Box(
                modifier = Modifier
                    .size(getUIKitTypography().body.lineHeight.value.dp),
                contentAlignment = Alignment.Center,
                content = iconStart
            )
            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            UIKitSlider(
                modifier = Modifier
                    .weight(1f),
                value = value.value,
                maxValue = maxValue,
                onValueChange = { v, type ->
                    isAnimatedChange.value = type != UIKitSliderChangeType.ThumbDrag
                    value.value = v
                },
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            Box(
                modifier = Modifier
                    .size(getUIKitTypography().body.lineHeight.value.dp),
                contentAlignment = Alignment.Center,
                content = iconEnd
            )
        }
    }

    @Composable
    open fun ProgressSlider() {
        val uikitTheme = getUIKitTheme()
        val isAnimatedChange = remember { mutableStateOf(false) }
        val progress = remember { mutableStateOf(progressProperty.value) }
        val progressAnimated = remember { Animatable(
            initialValue = progress.value,
            typeConverter = Float.VectorConverter,
        ) }

        LaunchedEffect(progress.value) {
            if (isAnimatedChange.value) {
                progressAnimated.animateTo(
                    targetValue = progress.value,
                    animationSpec = tween(
                        uikitTheme.animate.motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
            } else {
                progressAnimated.snapTo(progress.value)
            }
        }

        LaunchedEffect(progressAnimated.value) {
            progressProperty.value = progressAnimated.value
        }

        @Composable
        fun arc(progress: Float) {
            Canvas(
                modifier = Modifier
                    .size(getUIKitTypography().body.lineHeight.value.dp)
                    .aspectRatio(1f)
            ) {
                scale(
                    scale = size.width / 20.dp.toPx()
                ) {
                    translate(
                        top = size.height / 2 - 15.dp.toPx() / 2,
                        left = size.width / 2 - 15.dp.toPx() / 2
                    ) {
                        drawArc(
                            color = uikitTheme.colors.textFillColorPrimaryBrush.copy(0.3f),
                            startAngle = -90f,
                            sweepAngle = 360f,
                            useCenter = false,
                            size = Size(
                                width = 15.dp.toPx(),
                                height = 15.dp.toPx()
                            ),
                            style = Stroke(
                                width = 1.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )

                        drawArc(
                            color = uikitTheme.colors.textFillColorPrimaryBrush,
                            startAngle = -90f,
                            sweepAngle = progress.coerceIn(0f..1f) * 360f,
                            useCenter = false,
                            size = Size(
                                width = 15.dp.toPx(),
                                height = 15.dp.toPx()
                            ),
                            style = Stroke(
                                width = 1.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .background(getUIKitColors().contentFillColorSecondaryBrush)
                .padding(getUIKitLayout().basicSpacing)
        ) {
            arc(0.2f)
            
            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            UIKitSlider(
                modifier = Modifier
                    .weight(1f),
                value = progress.value,
                onValueChange = { value, type ->
                    isAnimatedChange.value = type != UIKitSliderChangeType.ThumbDrag
                    progress.value = value
                },
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            arc(0.8f)
        }
    }

    @Composable
    open fun LineWidthSlider() {
        val uikitTheme = getUIKitTheme()
        val isAnimatedChange = remember { mutableStateOf(false) }
        val lineWidth = remember { mutableStateOf(lineWidthProperty.value) }
        val lineWidthAnimated = remember { Animatable(
            initialValue = lineWidth.value,
            typeConverter = Dp.VectorConverter,
        ) }

        LaunchedEffect(lineWidth.value) {
            if (isAnimatedChange.value) {
                lineWidthAnimated.animateTo(
                    targetValue = lineWidth.value,
                    animationSpec = tween(
                        uikitTheme.animate.motionRegularDurationMillis,
                        easing = FastOutSlowInEasing
                    )
                )
            } else {
                lineWidthAnimated.snapTo(lineWidth.value)
            }
        }

        LaunchedEffect(lineWidthAnimated.value) {
            lineWidthProperty.value = lineWidthAnimated.value
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .background(getUIKitColors().contentFillColorSecondaryBrush)
                .padding(getUIKitLayout().basicSpacing)
        ) {
            Icon(
                modifier = Modifier
                    .size(getUIKitTypography().body.lineHeight.value.dp),
                imageVector = FluentIcons.ResizableIcons.shapes(getUIKitColors().textFillColorPrimaryBrush, true, 0.5f),
                contentDescription = "Thin",
                tint = getUIKitColors().textFillColorPrimaryBrush,
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            UIKitSlider(
                modifier = Modifier
                    .weight(1f),
                value = lineWidth.value.value.mapTo(
                    from = 0.5f..3f,
                    to = 0f..1f
                ).toFloat(),
                hasTick = true,
                tickStep = 0.2f,
                adsorbedOntoTick = false,
                maxValue = 1f,
                onValueChange = { value, type ->
                    val valueDp = value.mapTo(
                        from = 0f..1f,
                        to = 0.5f..3f
                    ).dp

                    isAnimatedChange.value = type != UIKitSliderChangeType.ThumbDrag
                    lineWidth.value = valueDp
                },
            )

            Spacer(Modifier.width(getUIKitLayout().smallSpacing))

            Icon(
                modifier = Modifier
                    .size(getUIKitTypography().body.lineHeight.value.dp),
                imageVector = FluentIcons.ResizableIcons.shapes(getUIKitColors().textFillColorPrimaryBrush, true, 1.5f),
                contentDescription = "Thin",
                tint = getUIKitColors().textFillColorPrimaryBrush,
            )
        }
    }

    @Composable
    open fun StateSelector(
        states: List<StateSelectorItem>,
        itemWidth: Dp = 148.dp
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            states.forEachIndexed { index, item ->
                Column(
                    modifier = Modifier
                        .padding(
                            top = getUIKitLayout().basicSpacing,
                            bottom = getUIKitLayout().basicSpacing,
                            end = if (index == states.size - 1) 0.dp else getUIKitLayout().basicSpacing,
                        )
                        .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                        .width(itemWidth)
                        .background(getUIKitColors().contentFillColorSecondaryBrush)
                        .uikitClickable(
                            onClick = {
                                stateProperty.value = index
                            },
                            indication = if (isDesktopOS()) null else UIKitInteraction.ripple()
                        )
                        .padding(getUIKitLayout().mediumSpacing),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentAlignment = Alignment.Center,
                        content = item.statePreview
                    )

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                    Text(
                        text = item.state,
                        style = getUIKitTypography().body,
                        color = getUIKitColors().textFillColorPrimaryBrush,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

data class StateSelectorItem(
    val state: String,
    val statePreview: @Composable BoxScope.() -> Unit
)

private fun makeAnimatableIconList(
    providedOptionsState: OptionState
) = listOf<AnimatableIconItem>(
    object : AnimatableIconItem(
        name = "ArrowCircle",
        size = "20 x 20",
        initialGeneralOptionsState = providedOptionsState
    ) {
        val resetProgressOnError = mutableStateOf(true)
        val angle = mutableStateOf(0f)
        val autoTint = mutableStateOf(true)

        @Composable
        override fun ExtendedOptions() {
            Column {
                StateSelector(
                    states = listOf(
                        StateSelectorItem("Running") {
                            FluentIcons.AnimatableIcons.ArrowCircle(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Running,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value,
                                rotate = angle.value
                            )
                        },
                        StateSelectorItem("Stopped") {
                            FluentIcons.AnimatableIcons.ArrowCircle(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Stopped,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value,
                                rotate = angle.value
                            )
                        },
                        StateSelectorItem("Error") {
                            FluentIcons.AnimatableIcons.ArrowCircle(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = if (resetProgressOnError.value) 0f else progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Error,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value,
                                rotate = angle.value
                            )
                        },
                        StateSelectorItem("Success") {
                            FluentIcons.AnimatableIcons.ArrowCircle(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Success,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value,
                                rotate = angle.value
                            )
                        },
                    )
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                CommonSlider(
                    state = angle,
                    iconStart = {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize()
                                .rotate(0f),
                            imageVector = FluentIcons.arrowCircleDown(getUIKitColors().textFillColorPrimaryBrush, true),
                            contentDescription = "Angle",
                            tint = getUIKitColors().textFillColorPrimaryBrush,
                        )
                    },
                    iconEnd = {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize()
                                .rotate(225f),
                            imageVector = FluentIcons.arrowCircleDown(getUIKitColors().textFillColorPrimaryBrush, true),
                            contentDescription = "Angle",
                            tint = getUIKitColors().textFillColorPrimaryBrush,
                        )
                    },
                    maxValue = 360f,
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                ProgressSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                LineWidthSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitGroupedCard(
                    items = listOf(
                        UIKitCardItem.settingCard(
                            title = LocalStrings.current.designs.fluentIcons.options.resetProgressOnError,
                            onClick = {
                                resetProgressOnError.value = !resetProgressOnError.value
                            },
                            icon = FluentIcons.dismissCircle(getUIKitColors().textFillColorPrimaryBrush, true)
                        ) {
                            UIKitToggleSwitch(
                                checked = resetProgressOnError.value,
                                onCheckedChange = { resetProgressOnError.value = it },
                            )
                        },
                        UIKitCardItem.divider(),
                        UIKitCardItem.settingCard(
                            title = LocalStrings.current.designs.fluentIcons.options.autoTint,
                            onClick = {
                                autoTint.value = !autoTint.value
                            },
                            icon = FluentIcons.PaintBrush
                        ) {
                            UIKitToggleSwitch(
                                checked = autoTint.value,
                                onCheckedChange = { autoTint.value = it },
                            )
                        }
                    )
                )
            }
        }

        @Composable
        override fun IconContent(modifier: Modifier) {
            FluentIcons.AnimatableIcons.ArrowCircle(
                modifier = modifier,
                progress = progressProperty.value,
                state = UIKitArrowCircleAnimateState.entries[stateProperty.value],
                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                autoTint = autoTint.value,
                resetProgressOnError = resetProgressOnError.value,
                lineWidth = lineWidthProperty.value,
                rotate = angle.value
            )
        }
    },
    object: AnimatableIconItem(
        name = "Download",
        size = "20 x 20",
        initialGeneralOptionsState = providedOptionsState
    ) {
        val resetProgressOnError = mutableStateOf(true)
        val autoTint = mutableStateOf(true)

        @Composable
        override fun ExtendedOptions() {
            Column {
                StateSelector(
                    states = listOf(
                        StateSelectorItem("Running") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Running,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Stopped") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Stopped,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Error") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = if (resetProgressOnError.value) 0f else progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Error,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Success") {
                            FluentIcons.AnimatableIcons.Download(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Success,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                    )
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                ProgressSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                LineWidthSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitGroupedCard(
                    items = listOf(
                        UIKitCardItem.settingCard(
                            title = LocalStrings.current.designs.fluentIcons.options.resetProgressOnError,
                            onClick = {
                                resetProgressOnError.value = !resetProgressOnError.value
                            },
                            icon = FluentIcons.dismissCircle(getUIKitColors().textFillColorPrimaryBrush, true)
                        ) {
                            UIKitToggleSwitch(
                                checked = resetProgressOnError.value,
                                onCheckedChange = { resetProgressOnError.value = it },
                            )
                        },
                        UIKitCardItem.divider(),
                        UIKitCardItem.settingCard(
                            title = LocalStrings.current.designs.fluentIcons.options.autoTint,
                            onClick = {
                                autoTint.value = !autoTint.value
                            },
                            icon = FluentIcons.PaintBrush
                        ) {
                            UIKitToggleSwitch(
                                checked = autoTint.value,
                                onCheckedChange = { autoTint.value = it },
                            )
                        }
                    )
                )
            }
        }

        @Composable
        override fun IconContent(modifier: Modifier) {
            FluentIcons.AnimatableIcons.Download(
                modifier = modifier,
                progress = progressProperty.value,
                state = UIKitArrowCircleAnimateState.entries[stateProperty.value],
                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                autoTint = autoTint.value,
                resetProgressOnError = resetProgressOnError.value,
                lineWidth = lineWidthProperty.value,
            )
        }
    },
    object : AnimatableIconItem(
        name = "Upload",
        size = "20 x 20",
        initialGeneralOptionsState = providedOptionsState
    ) {
        val resetProgressOnError = mutableStateOf(true)
        val autoTint = mutableStateOf(true)

        @Composable
        override fun ExtendedOptions() {
            Column {
                StateSelector(
                    states = listOf(
                        StateSelectorItem("Running") {
                            FluentIcons.AnimatableIcons.Upload(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Running,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Stopped") {
                            FluentIcons.AnimatableIcons.Upload(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Stopped,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Error") {
                            FluentIcons.AnimatableIcons.Upload(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = if (resetProgressOnError.value) 0f else progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Error,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Success") {
                            FluentIcons.AnimatableIcons.Upload(
                                modifier = Modifier
                                    .fillMaxSize(),
                                progress = progressProperty.value,
                                state = UIKitArrowCircleAnimateState.Success,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                resetProgressOnError = resetProgressOnError.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                    )
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                ProgressSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                LineWidthSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitGroupedCard(
                    items = listOf(
                        UIKitCardItem.settingCard(
                            title = LocalStrings.current.designs.fluentIcons.options.resetProgressOnError,
                            onClick = {
                                resetProgressOnError.value = !resetProgressOnError.value
                            },
                            icon = FluentIcons.dismissCircle(getUIKitColors().textFillColorPrimaryBrush, true)
                        ) {
                            UIKitToggleSwitch(
                                checked = resetProgressOnError.value,
                                onCheckedChange = { resetProgressOnError.value = it },
                            )
                        },
                        UIKitCardItem.divider(),
                        UIKitCardItem.settingCard(
                            title = LocalStrings.current.designs.fluentIcons.options.autoTint,
                            onClick = {
                                autoTint.value = !autoTint.value
                            },
                            icon = FluentIcons.PaintBrush
                        ) {
                            UIKitToggleSwitch(
                                checked = autoTint.value,
                                onCheckedChange = { autoTint.value = it },
                            )
                        }
                    )
                )
            }
        }

        @Composable
        override fun IconContent(modifier: Modifier) {
            FluentIcons.AnimatableIcons.Upload(
                modifier = modifier,
                progress = progressProperty.value,
                state = UIKitArrowCircleAnimateState.entries[stateProperty.value],
                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                autoTint = autoTint.value,
                resetProgressOnError = resetProgressOnError.value,
                lineWidth = lineWidthProperty.value,
            )
        }
    },
    object : AnimatableIconItem(
        name = "AddCircleFilled",
        size = "20 x 20",
        initialGeneralOptionsState = providedOptionsState
    ) {
        val autoTint = mutableStateOf(true)

        @Composable
        override fun ExtendedOptions() {
            Column {
                StateSelector(
                    states = listOf(
                        StateSelectorItem("Add") {
                            FluentIcons.AnimatableIcons.AddCircleFilled(
                                modifier = Modifier
                                    .fillMaxSize(),
                                state = UIKitAddCircleAnimateState.Add,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Error") {
                            FluentIcons.AnimatableIcons.AddCircleFilled(
                                modifier = Modifier
                                    .fillMaxSize(),
                                state = UIKitAddCircleAnimateState.Error,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                        StateSelectorItem("Success") {
                            FluentIcons.AnimatableIcons.AddCircleFilled(
                                modifier = Modifier
                                    .fillMaxSize(),
                                state = UIKitAddCircleAnimateState.Success,
                                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                                autoTint = autoTint.value,
                                lineWidth = lineWidthProperty.value
                            )
                        },
                    )
                )

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                LineWidthSlider()

                Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                UIKitSettingCard(
                    title = LocalStrings.current.designs.fluentIcons.options.autoTint,
                    onClick = {
                        autoTint.value = !autoTint.value
                    },
                    icon = FluentIcons.PaintBrush
                ) {
                    UIKitToggleSwitch(
                        checked = autoTint.value,
                        onCheckedChange = { autoTint.value = it },
                    )
                }
            }
        }

        @Composable
        override fun IconContent(modifier: Modifier) {
            FluentIcons.AnimatableIcons.AddCircleFilled(
                modifier = modifier,
                state = UIKitAddCircleAnimateState.entries[stateProperty.value],
                primaryTint = generalOptionsStateProperty.tintColor.value.getColor(),
                autoTint = autoTint.value,
                lineWidth = lineWidthProperty.value
            )
        }
    }
)

@Composable
@Preview
private fun DownloadIconExtendedOptionsPreview() {
    makeAnimatableIconList(OptionState(Color.Unspecified.toHsv(), Color.Unspecified.toHsv()))[0].ExtendedOptions()
}