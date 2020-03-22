package com.infectapp.presentation.ui.main.search

import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


class SearchViewModel : BaseViewModel<SearchState, MainNavigator.Navigation>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override val initialViewState: SearchState = SearchState()

}