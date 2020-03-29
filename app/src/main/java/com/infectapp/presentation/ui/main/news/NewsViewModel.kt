package com.infectapp.presentation.ui.main.news

import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


class NewsViewModel : BaseViewModel<NewsState, MainNavigator.Navigation>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override val initialViewState: NewsState = NewsState()

    private fun onActionRefresh(){

    }

}