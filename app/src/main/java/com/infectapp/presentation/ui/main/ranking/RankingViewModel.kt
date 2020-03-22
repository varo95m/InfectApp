package com.infectapp.presentation.ui.main.ranking

import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.UserModel
import com.infectapp.domain.usecase.GetInfectedListUseCase
import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


class RankingViewModel() : BaseViewModel<RankingState, MainNavigator.Navigation>() {

    override val initialViewState: RankingState = RankingState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
        updateToNormalState {
            copy(
                totalUsersList = totalUsersListSorted,
                podiumUsersList = podiumList,
                otherUsersList = otherUsersListSorted,
                userLogged = userLoggedInfo
            )
        }
    }


    override fun onResume(firstTime: Boolean) {

    }

    companion object{
        var totalUsersListSorted = listOf<InfectedUserModel>()
        var podiumList = listOf<InfectedUserModel>()
        var otherUsersListSorted = mutableListOf<InfectedUserModel>()
        var userLoggedInfo = InfectedUserModel()
    }

}