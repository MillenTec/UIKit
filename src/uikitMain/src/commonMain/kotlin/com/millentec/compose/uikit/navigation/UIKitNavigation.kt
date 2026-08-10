package com.millentec.compose.uikit.navigation

import com.millentec.compose.uikit.foundation.UIKitNavigationType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UIKitNavigation<S>(
    val initialPage: S,
    val homePage: S
) {
    private val _historyPages: MutableList<S> = if (initialPage == homePage)
        mutableListOf(initialPage)
    else mutableListOf(homePage, initialPage)
    private var _pageDepth: Int = 0

    private val _page = MutableStateFlow(initialPage)
    val page: StateFlow<S> = _page.asStateFlow()

    private val _hasHistoryPages = MutableStateFlow(initialPage != homePage)
    val hasHistoryPages: StateFlow<Boolean> = _hasHistoryPages.asStateFlow()

    private val _pageSwitchAnimate = MutableStateFlow(UIKitNavigationAnimate().jump)
    val pageSwitchAnimate = _pageSwitchAnimate.asStateFlow()

    fun switchPage(page: S, isAddInHistory: Boolean = true, type: UIKitNavigationType = UIKitNavigationType.Jump){
        // 若仅是设置下面的targetContentZIndex为负数的话, 其深度会一直保留, 导致下一次切换是的目标页面于原页面在同一深度(-1)
        // 故使深度递增, 保证每一次切换时目标页面的深度都低于任何一个页面
        if (type == UIKitNavigationType.Backward){
            if (_pageDepth == Int.MAX_VALUE) _pageDepth = 0
            _pageDepth++
        } else{
            _pageDepth = 0
        }

        _pageSwitchAnimate.value = when(type){
            UIKitNavigationType.Forward -> UIKitNavigationAnimate().forward
            UIKitNavigationType.Backward -> UIKitNavigationAnimate().backward(_pageDepth.toFloat())
            else -> UIKitNavigationAnimate().jump
        }

        _page.value = page
        if (isAddInHistory) {
            _historyPages.add(page)
            _hasHistoryPages.value = page != homePage
        }
    }

    fun goBack(){
        fun reset(){
            // 重设历史记录
            _historyPages.clear()
            _historyPages.add(homePage)
            _hasHistoryPages.value = false
        }

        if (_historyPages.isEmpty()) {
            reset()
            return
        }
        if (_historyPages.last() == homePage) {
            _hasHistoryPages.value = false
            return
        }
        _historyPages.removeAt(_historyPages.size-1)
        if (_historyPages.isEmpty()) {
            reset()
            return
        }
        val last = _historyPages.last()
        if (last == homePage) {
            reset()
        }
        switchPage(last, false, UIKitNavigationType.Backward)
    }
}