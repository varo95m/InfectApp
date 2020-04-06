package com.infectapp.presentation.ui.main.ranking

import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


class RankingViewModel : BaseToolbarsViewModel<RankingState, MainNavigator.Navigation>() {

    override val initialViewState: RankingState = RankingState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
    }

    override fun onResume(firstTime: Boolean) {

    }

    fun onActionRefresh() {

    }

    fun onActionUserClick(user: InfectedUserModel) {
    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }
}