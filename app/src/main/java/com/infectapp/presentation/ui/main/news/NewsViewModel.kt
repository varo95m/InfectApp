package com.infectapp.presentation.ui.main.news

import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


class NewsViewModel : BaseToolbarsViewModel<NewsState, MainNavigator.Navigation>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override val initialViewState: NewsState = NewsState()

    fun onActionRefresh(){

    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

}