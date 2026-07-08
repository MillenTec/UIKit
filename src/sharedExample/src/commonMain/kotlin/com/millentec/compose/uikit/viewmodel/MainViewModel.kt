package com.millentec.compose.uikit.viewmodel

import androidx.compose.animation.*
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import com.millentec.compose.uikit.data.PageSwitchWay
import com.millentec.compose.uikit.data.Pages
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel {

    // ------私有成员------ //
    private val _historyPages: MutableList<Pages> = mutableListOf(Pages.Home)
    private var _pageDepth: Int = 0

    // ------可绑定属性------ //
    private val _page = MutableStateFlow<Pages>(Pages.Home)
    val page: StateFlow<Pages> = _page.asStateFlow()

    private val _hasHistoryPages = MutableStateFlow<Boolean>(false)
    val hasHistoryPages: StateFlow<Boolean> = _hasHistoryPages.asStateFlow()

    private val _pageSwitchAnimate = MutableStateFlow<AnimatedContentTransitionScope<Pages>.() -> ContentTransform> {
        (fadeIn(animationSpec = tween(220, delayMillis = 160)) +
                scaleIn(initialScale = 0.96f, animationSpec = tween(220, delayMillis = 160)))
            .togetherWith(fadeOut(animationSpec = tween(160)))
    }
    val pageSwitchAnimate: StateFlow<AnimatedContentTransitionScope<Pages>.() -> ContentTransform> = _pageSwitchAnimate.asStateFlow()

    // ------公共方法------ //
    fun switchPage(page: Pages, isAddInHistory: Boolean = true, way: PageSwitchWay = PageSwitchWay.Jump){

        // 若仅是设置下面的targetContentZIndex为负数的话, 其深度会一直保留, 导致下一次切换是的目标页面于原页面在同一深度(-1)
        // 故使深度递增, 保证每一次切换时目标页面的深度都低于任何一个页面
        if (way == PageSwitchWay.Backward){
            if (_pageDepth == Int.MAX_VALUE) _pageDepth = 0
            _pageDepth++
        }else{
            _pageDepth = 0
        }
        _pageSwitchAnimate.value = {
            when(way){
                PageSwitchWay.Backward -> {
                    ContentTransform(
                        targetContentEnter = slideInHorizontally(
                            animationSpec = tween(300, easing = FastOutSlowInEasing)
                        ) {
                            -300
                        } + fadeIn(tween(350), initialAlpha = 0.2f),
                        initialContentExit = slideOutHorizontally(
                            animationSpec = tween(300, easing = FastOutSlowInEasing)
                        ) {
                            it
                        },
                        targetContentZIndex = -_pageDepth.toFloat()
                    )
                }

                PageSwitchWay.Jump -> {
                    (fadeIn(animationSpec = tween(220, delayMillis = 160)) +
                            scaleIn(initialScale = 0.96f, animationSpec = tween(220, delayMillis = 160)))
                        .togetherWith(fadeOut(animationSpec = tween(160)))
                }

                else -> {
                    slideInHorizontally(
                        animationSpec = tween(300, easing = FastOutSlowInEasing)
                    ) {
                        it
                    }.togetherWith(
                        slideOutHorizontally(
                            animationSpec = tween(300, easing = FastOutSlowInEasing)
                        ) {
                            -300
                        } + fadeOut(tween(300), targetAlpha = 0.2f)
                                + scaleOut(tween(300, easing = EaseInOut), targetScale = 0.96f)
                    )
                }
            }
        }
        _page.value = page
        if (isAddInHistory) {
            _historyPages.add(page)
            _hasHistoryPages.value = page != Pages.Home
        }
    }

    fun goBack(){
        fun reset(){
            // 重设历史记录
            _historyPages.clear()
            _historyPages.add(Pages.Home)
            _hasHistoryPages.value = false
        }

        if (_historyPages.isEmpty()) {
            reset()
            return
        }
        if (_historyPages.last() == Pages.Home) {
            _hasHistoryPages.value = false
            return
        }
        _historyPages.removeAt(_historyPages.size-1)
        if (_historyPages.isEmpty()) {
            reset()
            return
        }
        val last = _historyPages.last()
        if (last == Pages.Home) {
            reset()
        }
        switchPage(last, false, PageSwitchWay.Backward)
    }
}