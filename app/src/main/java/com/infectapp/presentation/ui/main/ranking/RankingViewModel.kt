package com.infectapp.presentation.ui.main.ranking

import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


class RankingViewModel : BaseViewModel<RankingState, MainNavigator.Navigation>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override fun onResume(firstTime: Boolean) {

    }

    override val initialViewState: RankingState = RankingState()

}