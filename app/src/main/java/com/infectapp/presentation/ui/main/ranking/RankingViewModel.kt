package com.infectapp.presentation.ui.main.ranking

import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.RequestUserList
import com.infectapp.domain.usecase.GetInfectedListUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


class RankingViewModel(private val getInfectedListUseCase: GetInfectedListUseCase) : BaseToolbarsViewModel<RankingState, MainNavigator.Navigation>() {

    override val initialViewState: RankingState = RankingState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
        executeUseCase {
            getInfectedListUseCase.execute(RequestUserList(listener = ::onResponseInfectedList, errorListener = ::onError))
        }
    }

    override fun onResume(firstTime: Boolean) {

    }

    private fun onResponseInfectedList(result: List<InfectedUserModel>) {
        updateToNormalState {
            copy(
                    usersList = result
            )
        }
    }

    private fun onError(result: Unit) {
    }

    fun onActionRefresh() {

    }

    fun onActionUserClick(user: InfectedUserModel) {
    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }
}