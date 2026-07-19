package com.millentec.compose.uikit.views.pages

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.millentec.compose.uikit.BackHandler
import com.millentec.compose.uikit.IconGalleryList
import com.millentec.compose.uikit.component.input.UIKitHSVColorPicker
import com.millentec.compose.uikit.component.input.UIKitIslandButton
import com.millentec.compose.uikit.component.input.UIKitToggleSwitch
import com.millentec.compose.uikit.component.input.toHsv
import com.millentec.compose.uikit.component.layout.*
import com.millentec.compose.uikit.data.Pages
import com.millentec.compose.uikit.foundation.LayoutPosition
import com.millentec.compose.uikit.foundation.isDesktopOS
import com.millentec.compose.uikit.foundation.materials.acrylicMaterialSource
import com.millentec.compose.uikit.foundation.materials.rememberAcrylicMaterialsState
import com.millentec.compose.uikit.foundation.uikitClickable
import com.millentec.compose.uikit.icons.fluenticons.FluentIcons
import com.millentec.compose.uikit.icons.fluenticons.regular.dp20.*
import com.millentec.compose.uikit.theme.*
import com.millentec.compose.uikit.viewmodels.MainViewModel
import kotlin.math.ceil
import kotlin.math.floor

@Composable
@Preview
private fun OptionsWindow(
    onTintColorChange: (Color) -> Unit = {},
    onBackgroundColorChange: (Color) -> Unit = {},
    onLayeredChange: (Boolean) -> Unit = {},
    checkedIcon: ImageVector? = null,
    initialTintColor: Color = getUIKitColors().textFillColorPrimaryBrush,
    initialBackgroundColor: Color = getUIKitColors().contentFillColorSecondaryBrush,
    initialLayered: Boolean = false
) {
    val tintColor = remember { mutableStateOf(initialTintColor.toHsv()) }

    LaunchedEffect(tintColor.value) {
        onTintColorChange(tintColor.value.getColor())
    }

    val backgroundColor = remember { mutableStateOf(initialBackgroundColor.toHsv()) }

    LaunchedEffect(backgroundColor.value) {
        onBackgroundColorChange(backgroundColor.value.getColor())
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = getUIKitLayout().x2Spacing,
                vertical = if (isDesktopOS()) 0.dp else getUIKitLayout().x2Spacing
            )
    ) {
        val layered = remember { mutableStateOf(initialLayered) }

        LaunchedEffect(layered.value) {
            onLayeredChange(layered.value)
        }

        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = tween(getUIKitAnimate().motionRegularDurationMillis, easing = FastOutSlowInEasing),
                )
                .fillMaxWidth()
        ) {
            AnimatedVisibility(
                modifier = Modifier
                    .fillMaxWidth(),
                visible = checkedIcon != null,
            ) {
                Column {
                    if (checkedIcon == null) return@AnimatedVisibility

                    BoxWithConstraints(
                        modifier = Modifier
                            .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                            .fillMaxWidth()
                            .background(getUIKitColors().contentFillColorSecondaryBrush)
                            .padding(getUIKitLayout().mediumSpacing),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(maxWidth * 0.6f),
                            imageVector = checkedIcon,
                            contentDescription = null,
                            tint = tintColor.value.getColor()
                        )
                    }

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                    UIKitSettingCard(
                        onClick = {},
                        title = "Name",
                        icon = FluentIcons.Tag
                    ) {
                        Text(
                            text = checkedIcon.name,
                            style = getUIKitTypography().body,
                            color = getUIKitColors().textFillColorSecondaryBrush
                        )
                    }

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                    UIKitSettingCard(
                        onClick = {},
                        title = "Size",
                        icon = FluentIcons.Resize
                    ) {
                        Text(
                            text = "${
                                checkedIcon.defaultWidth.value.toString().removeSuffix(".0")
                            } x ${checkedIcon.defaultHeight.value.toString().removeSuffix(".0")}",
                            style = getUIKitTypography().body,
                            color = getUIKitColors().textFillColorSecondaryBrush
                        )
                    }

                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = getUIKitColors().lineFillColorPrimaryBrush
                    )
                    Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                }
            }
        }

        UIKitSettingCard(
            onClick = {
                layered.value = !layered.value
            },
            title = "Layered Icons",
            icon = FluentIcons.layerDiagonal(getUIKitColors().textFillColorPrimaryBrush, true),
            iconColor = Color.Unspecified
        ) {
            UIKitToggleSwitch(
                checked = layered.value,
                onCheckedChange = {
                    layered.value = it
                }
            )
        }

        Spacer(Modifier.height(getUIKitLayout().basicSpacing))

        val tintColorPickerExpanded = remember { mutableStateOf(false) }
        UIKitSettingsExpander(
            expanded = tintColorPickerExpanded.value,
            onClick = {
                tintColorPickerExpanded.value = !tintColorPickerExpanded.value
            },
            title = "Tint Color",
            icon = FluentIcons.wand(getUIKitColors().textFillColorSecondaryBrush, true),
        ) {
            UIKitHSVColorPicker(
                color = tintColor.value,
                onColorChange = {
                    tintColor.value = it
                }
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            val optionalColors = listOf(
                getUIKitColors().textFillColorPrimaryBrush,
                getUIKitColors().textFillColorPrimaryBrushReversed,
                getUIKitColors().highlightColorPrimaryBrush,
                getUIKitColors().successGreenColorPrimaryBrush,
                getUIKitColors().warningYellowColorPrimaryBrush,
                getUIKitColors().errorRedColorPrimaryBrush
            )

            BoxWithConstraints {
                val minSize = 128.dp
                val itemHeight = 48.dp
                val columnCount = floor(maxWidth / minSize)
                val rowCount = ceil(optionalColors.size / columnCount)
                val height = rowCount * itemHeight + getUIKitLayout().smallSpacing * rowCount * 2

                LazyVerticalGrid(
                    modifier = Modifier
                        .height(height),
                    columns = GridCells.Adaptive(minSize = minSize),
                    userScrollEnabled = false
                ) {
                    items(optionalColors.size) { index ->
                        Box(
                            modifier = Modifier
                                .padding(getUIKitLayout().smallSpacing)
                                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                .height(48.dp)
                                .background(optionalColors[index])
                                .uikitClickable(
                                    onClick = {
                                        tintColor.value = optionalColors[index].toHsv()
                                    },
                                    indication = if (isDesktopOS()) null else ripple()
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = when (index) {
                                    0 -> "Primary"
                                    1 -> "Reversed"
                                    2 -> "Highlight"
                                    3 -> "Success"
                                    4 -> "Warning"
                                    5 -> "Error"
                                    else -> "Unknown"
                                },
                                style = getUIKitTypography().body,
                                color = when (index) {
                                    0 -> getUIKitColors().textFillColorPrimaryBrushReversed
                                    2 -> getUIKitColors().textFillColorPrimaryBrushReversed
                                    5 -> getUIKitColors().textFillColorPrimaryBrushReversed
                                    else -> getUIKitColors().textFillColorPrimaryBrush
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(getUIKitLayout().basicSpacing))

        val backgroundColorPickerExpanded = remember { mutableStateOf(false) }
        UIKitSettingsExpander(
            expanded = backgroundColorPickerExpanded.value,
            onClick = {
                backgroundColorPickerExpanded.value = !backgroundColorPickerExpanded.value
            },
            title = "Background Color",
            icon = FluentIcons.wand(getUIKitColors().textFillColorSecondaryBrush, true),
        ) {
            UIKitHSVColorPicker(
                color = backgroundColor.value,
                onColorChange = {
                    backgroundColor.value = it
                }
            )

            Spacer(Modifier.height(getUIKitLayout().basicSpacing))

            val optionalColors = listOf(
                getUIKitColors().contentFillColorPrimaryBrush,
                getUIKitColors().contentFillColorSecondaryBrush,
                getUIKitColors().contentFillColorTertiaryBrush,
                getUIKitColors().contentFillColorFourthBrush,
                getUIKitColors().highlightColorPrimaryBrush,
                getUIKitColors().highlightColorSecondaryBrush,
                getUIKitColors().highlightColorTertiaryBrush,
                getUIKitColors().highlightColorFourthBrush,
                getUIKitColors().successGreenColorPrimaryBrush,
                getUIKitColors().successGreenColorSecondaryBrush,
                getUIKitColors().successGreenColorTertiaryBrush,
                getUIKitColors().successGreenColorFourthBrush,
                getUIKitColors().warningYellowColorPrimaryBrush,
                getUIKitColors().warningYellowColorSecondaryBrush,
                getUIKitColors().warningYellowColorTertiaryBrush,
                getUIKitColors().warningYellowColorFourthBrush,
                getUIKitColors().errorRedColorPrimaryBrush,
                getUIKitColors().errorRedColorSecondaryBrush,
                getUIKitColors().errorRedColorTertiaryBrush,
                getUIKitColors().errorRedColorFourthBrush,
            )

            BoxWithConstraints {
                val minSize = 128.dp
                val itemHeight = 48.dp
                val columnCount = floor(maxWidth / minSize)
                val rowCount = ceil(optionalColors.size / columnCount)
                val height = rowCount * itemHeight + getUIKitLayout().smallSpacing * rowCount * 2

                LazyVerticalGrid(
                    modifier = Modifier
                        .height(height),
                    columns = GridCells.Adaptive(minSize = minSize),
                    userScrollEnabled = false
                ) {
                    items(optionalColors.size) { index ->
                        Box(
                            modifier = Modifier
                                .padding(getUIKitLayout().smallSpacing)
                                .clip(RoundedCornerShape(getUIKitShapes().regularRounded))
                                .height(48.dp)
                                .background(optionalColors[index])
                                .uikitClickable(
                                    onClick = {
                                        backgroundColor.value = optionalColors[index].toHsv()
                                    },
                                    indication = if (isDesktopOS()) null else ripple()
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = when (index) {
                                    0 -> "Primary"
                                    1 -> "Secondary"
                                    2 -> "Tertiary"
                                    3 -> "Fourth"
                                    4 -> "Highlight P"
                                    5 -> "Highlight S"
                                    6 -> "Highlight T"
                                    7 -> "Highlight F"
                                    8 -> "Success P"
                                    9 -> "Success S"
                                    10 -> "Success T"
                                    11 -> "Success F"
                                    12 -> "Warning P"
                                    13 -> "Warning S"
                                    14 -> "Warning T"
                                    15 -> "Warning F"
                                    16 -> "Error P"
                                    17 -> "Error S"
                                    18 -> "Error T"
                                    19 -> "Error F"
                                    else -> "Unknown"
                                },
                                style = getUIKitTypography().body,
                                color = when (index) {
                                    3 -> getUIKitColors().textFillColorPrimaryBrushReversed
                                    4 -> getUIKitColors().textFillColorPrimaryBrushReversed
                                    16 -> getUIKitColors().textFillColorPrimaryBrushReversed
                                    else -> getUIKitColors().textFillColorPrimaryBrush
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(getUIKitLayout().mediumSpacing))
    }
}

@Composable
@Preview
fun IconsGallery() {
    BoxWithConstraints {
        LaunchedEffect(Unit) {
            MainViewModel.navigationDockVisible(false)
        }

        val uiKitColors = getUIKitColors()

        val primaryColor = remember { mutableStateOf(uiKitColors.textFillColorPrimaryBrush) }
        val layered = remember { mutableStateOf(false) }

        val iconGalleryList = remember {
            mutableStateOf(
                IconGalleryList(
                    primaryColor.value,
                    layered.value
                )
            )
        }

        LaunchedEffect(primaryColor.value, layered.value) {
            iconGalleryList.value = IconGalleryList(
                primaryColor.value,
                layered.value
            )
        }

        val backgroundColor = remember { mutableStateOf(uiKitColors.contentFillColorSecondaryBrush) }
        val acrylicMaterialsState = rememberAcrylicMaterialsState()
        val bottomSheetExpanded = remember { mutableStateOf(false) }
        val checkedIconIndex = remember { mutableStateOf<Int?>(null) }
        val checkedIcon = remember { mutableStateOf<ImageVector?>(null) }
        val bottomSheetState = remember {
            UIKitBottomSheetState(
                expanded = bottomSheetExpanded.value,
                onExpandedChange = {
                    bottomSheetExpanded.value = it
                }
            )
        }

        LaunchedEffect(checkedIconIndex.value, primaryColor.value, layered.value) {
            if ((checkedIconIndex.value ?: return@LaunchedEffect) < iconGalleryList.value.regularIconsList.size) {
                checkedIcon.value = IconGalleryList(
                    primaryColor.value,
                    layered.value
                ).regularIconsList.getOrNull(checkedIconIndex.value ?: return@LaunchedEffect)
            } else {
                checkedIcon.value = IconGalleryList(
                    primaryColor.value,
                    layered.value
                ).filledIconsList.getOrNull(
                    (checkedIconIndex.value ?: return@LaunchedEffect) - iconGalleryList.value.regularIconsList.size
                )
            }
        }

        Box(
            modifier = Modifier
                .uikitBottomSheetCollaborativeAnimation(
                    state = bottomSheetState,
                    onClick = {
                        bottomSheetExpanded.value = false
                    }
                )
        ) {
            val maxWith = remember { mutableStateOf(this@BoxWithConstraints.maxWidth) }
            val maxHeight = remember { mutableStateOf(this@BoxWithConstraints.maxHeight) }

            LaunchedEffect(this@BoxWithConstraints.maxWidth, this@BoxWithConstraints.maxHeight) {
                maxWith.value = this@BoxWithConstraints.maxWidth
                maxHeight.value = this@BoxWithConstraints.maxHeight
            }

            Row {
                LazyVerticalGrid(
                    modifier = Modifier
                        .weight(1f)
                        .background(getUIKitColors().contentFillColorPrimaryBrush)
                        .acrylicMaterialSource(acrylicMaterialsState),
                    columns = GridCells.Adaptive(128.dp),
                    contentPadding = PaddingValues(
                        top = getUIKitLayout().x6Spacing + (WindowInsets.safeDrawing.getTop(LocalDensity.current).dp / LocalDensity.current.density),
                        bottom = getUIKitLayout().x4Spacing,
                        start = getUIKitLayout().x4Spacing,
                        end = getUIKitLayout().x4Spacing
                    )
                ) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Text(
                            text = "Fluent Icons",
                            style = getUIKitTypography().largeTitle,
                            color = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Spacer(Modifier.height(getUIKitLayout().x4Spacing))

                            Text(
                                text = "Regular Icons",
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                        }
                    }

                    items(iconGalleryList.value.regularIconsList.size) { index ->
                        val icon = iconGalleryList.value.regularIconsList.getOrNull(index)

                        Column(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .padding(getUIKitLayout().smallSpacing)
                                .clip(RoundedCornerShape(getUIKitShapes().mediumRounded))
                                .background(backgroundColor.value)
                                .uikitClickable(
                                    onClick = {
                                        checkedIconIndex.value = index
                                        if (maxWith.value < 1024.dp) {
                                            bottomSheetExpanded.value = true
                                        }
                                    },
                                    indication = if (isDesktopOS()) null else ripple()
                                )
                                .padding(getUIKitLayout().mediumSpacing),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                if (icon != null) {
                                    Icon(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        imageVector = icon,
                                        contentDescription = null,
                                        tint = primaryColor.value
                                    )
                                }
                            }

                            Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                            Text(
                                text = icon?.name ?: "Unknown",
                                style = getUIKitTypography().body,
                                color = getUIKitColors().textFillColorPrimaryBrush,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Column {
                            Spacer(Modifier.height(getUIKitLayout().x4Spacing))

                            Text(
                                text = "Filled Icons",
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorSecondaryBrush
                            )

                            Spacer(Modifier.height(getUIKitLayout().basicSpacing))
                        }
                    }

                    items(iconGalleryList.value.filledIconsList.size) { index ->
                        val icon = iconGalleryList.value.filledIconsList.getOrNull(index)

                        Column(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .padding(getUIKitLayout().smallSpacing)
                                .clip(RoundedCornerShape(getUIKitShapes().mediumRounded))
                                .background(backgroundColor.value)
                                .uikitClickable(
                                    onClick = {
                                        checkedIconIndex.value = index + iconGalleryList.value.regularIconsList.size
                                        if (maxWith.value < 1024.dp) {
                                            bottomSheetExpanded.value = true
                                        }
                                    },
                                    indication = if (isDesktopOS()) null else ripple()
                                )
                                .padding(getUIKitLayout().mediumSpacing),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                if (icon != null) {
                                    Icon(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        imageVector = icon,
                                        contentDescription = null,
                                        tint = primaryColor.value
                                    )
                                }
                            }

                            Spacer(Modifier.height(getUIKitLayout().smallSpacing))

                            Text(
                                text = icon?.name ?: "Unknown",
                                style = getUIKitTypography().body,
                                color = getUIKitColors().textFillColorPrimaryBrush,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                AnimatedVisibility(
                    visible = maxWith.value >= 1024.dp,
                    enter = slideInHorizontally(
                        initialOffsetX = {
                            it
                        },
                        animationSpec = tween(getUIKitAnimate().motionFastDurationMillis, easing = FastOutSlowInEasing)
                    ),
                    exit = slideOutHorizontally(
                        targetOffsetX = {
                            it
                        },
                        animationSpec = tween(getUIKitAnimate().motionFastDurationMillis, easing = FastOutSlowInEasing)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .width(360.dp)
                            .fillMaxHeight()
                            .background(getUIKitColors().contentFillColorPrimaryBrush)
                    ) {
                        Spacer(
                            Modifier.height(
                                getUIKitLayout().x6Spacing + (WindowInsets.safeDrawing.getTop(
                                    LocalDensity.current
                                ).dp / LocalDensity.current.density)
                            )
                        )

                        Row(
                            modifier = Modifier
                                .padding(
                                    horizontal = getUIKitLayout().x2Spacing,
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(28.dp),
                                imageVector = FluentIcons.options(getUIKitColors().textFillColorPrimaryBrush, true),
                                contentDescription = null,
                                tint = getUIKitColors().textFillColorPrimaryBrush
                            )

                            Spacer(Modifier.width(getUIKitLayout().basicSpacing))

                            Text(
                                text = "Options",
                                style = getUIKitTypography().subtitle,
                                color = getUIKitColors().textFillColorPrimaryBrush
                            )
                        }

                        Spacer(Modifier.height(getUIKitLayout().basicSpacing))

                        OptionsWindow(
                            onTintColorChange = {
                                primaryColor.value = it
                            },
                            onLayeredChange = {
                                layered.value = it
                            },
                            onBackgroundColorChange = {
                                backgroundColor.value = it
                            },
                            checkedIcon = checkedIcon.value,
                            initialLayered = layered.value,
                            initialTintColor = primaryColor.value,
                            initialBackgroundColor = backgroundColor.value,
                        )
                    }
                }
            }

            UIKitIslandButton(
                modifier = Modifier
                    .fillMaxSize(),
                position = LayoutPosition.TopLeft,
                onClicked = {
                    when (it) {
                        0 -> {
                            MainViewModel.navigation.goBack()
                        }

                        1 -> {
                            MainViewModel.navigation.switchPage(Pages.Home)
                        }
                    }
                },
                items = listOf(
                    {
                        Icon(
                            imageVector = FluentIcons.ChevronArrowLeft,
                            contentDescription = null,
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    },
                    {
                        Icon(
                            imageVector = FluentIcons.Home,
                            contentDescription = null,
                            tint = getUIKitColors().textFillColorPrimaryBrush
                        )
                    }
                ),
                acrylicEffectEnabled = true,
                acrylicState = acrylicMaterialsState
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                AnimatedVisibility(
                    visible = maxWith.value < 1024.dp,
                    enter = scaleIn(
                        animationSpec = spring(
                            dampingRatio = getUIKitAnimate().standardSpringDampingRatio,
                            stiffness = getUIKitAnimate().standardSpringStiffness
                        )
                    ),
                    exit = scaleOut(
                        animationSpec = spring(
                            dampingRatio = getUIKitAnimate().standardSpringDampingRatio,
                            stiffness = getUIKitAnimate().standardSpringStiffness
                        )
                    )
                ) {
                    UIKitIslandButton(
                        position = LayoutPosition.TopRight,
                        onClicked = {
                            bottomSheetExpanded.value = true
                        },
                        items = listOf(
                            {
                                Icon(
                                    imageVector = FluentIcons.options(),
                                    contentDescription = null,
                                    tint = getUIKitColors().textFillColorPrimaryBrush
                                )
                            }
                        ),
                        acrylicEffectEnabled = true,
                        acrylicState = acrylicMaterialsState
                    )
                }
            }
        }

        BackHandler(bottomSheetState.expanded.value) {
            bottomSheetExpanded.value = false
        }

        LaunchedEffect(bottomSheetExpanded.value) {
            bottomSheetState.expanded.value = bottomSheetExpanded.value
        }

        UIKitBottomSheet(
            modifier = Modifier
                .fillMaxSize(),
            state = bottomSheetState,
            title = "Options",
            maxHeight = maxHeight * 0.8f,
            minHeight = maxHeight * 0.8f
        ) {
            OptionsWindow(
                onTintColorChange = {
                    primaryColor.value = it
                },
                onLayeredChange = {
                    layered.value = it
                },
                onBackgroundColorChange = {
                    backgroundColor.value = it
                },
                checkedIcon = checkedIcon.value,
                initialLayered = layered.value,
                initialTintColor = primaryColor.value,
                initialBackgroundColor = backgroundColor.value,
            )
        }
    }
}