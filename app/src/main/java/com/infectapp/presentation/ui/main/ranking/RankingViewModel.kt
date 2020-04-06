package com.infectapp.presentation.ui.main.ranking

import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.INT_ONE
import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.RequestUserList
import com.infectapp.domain.usecase.GetInfectedListUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


class RankingViewModel(
    private val getInfectedListUseCase: GetInfectedListUseCase//todos los usuarios pal ranking
    // private val getOtherUserDataUseCase: GetOtherUserDataUseCase,//un usuario concreto
    //private val getUserLoggedUseCase: GetUserLoggedUseCase//el usuario logueado el cual alokme deberíamos obtener desde la home
) : BaseToolbarsViewModel<RankingState, MainNavigator.Navigation>() {

    override val initialViewState: RankingState = RankingState()

    private var totalUsersListSorted = listOf<InfectedUserModel>()
    private var podiumList = listOf<InfectedUserModel>()
    private var otherUsersListSorted = mutableListOf<InfectedUserModel>()

    private var position = INT_ONE

    override fun onStartFirstTime(statePreloaded: Boolean) {
        if (!statePreloaded) {
            getInfectedRankingData()
        }
    }

    private fun getInfectedRankingData() {
        updateToAlternativeState()
        executeUseCaseWithException({
            getInfectedListUseCase.execute(
                RequestUserList(
                    listener = ::onResponseInfectedList,
                    errorListener = ::onError
                )
            )
        }, { error -> updateToErrorState(error) })
    }

    private fun onResponseInfectedList(result: List<InfectedUserModel>) {
        totalUsersListSorted = result
        totalUsersListSorted.forEach {
            it.userPosition = position
            position += 1
        }
        podiumList = listOf(
            totalUsersListSorted[0],
            totalUsersListSorted[1],
            totalUsersListSorted[2]
        )
        otherUsersListSorted = totalUsersListSorted.toMutableList()
        removePodiumUsers()

        updateToNormalState {
            copy(
                totalUsersList = totalUsersListSorted,
                podiumUsersList = podiumList,
                otherUsersList = otherUsersListSorted
                //userLogged = getUserLoggedUseCase.execute(Unit)
            )
        }
    }

    private fun onError(result: Unit) {

    }

    private fun removePodiumUsers() {
        otherUsersListSorted.removeAt(2)
        otherUsersListSorted.removeAt(1)
        otherUsersListSorted.removeAt(0)
    }


    override fun onResume(firstTime: Boolean) {

    }

    fun onSearchAction(){
        navigate(MainNavigator.Navigation.SearchFromRanking)
    }

    fun onActionRefresh() {
        totalUsersListSorted = listOf()
        podiumList = listOf()
        otherUsersListSorted = mutableListOf()
        position = INT_ONE
        getInfectedRankingData()
    }

    fun onActionUserClick(user: InfectedUserModel) {
        executeUseCaseWithException({
            //val otherUser = getOtherUserDataUseCase.execute(user)
            updateToNormalState {
                copy(
                    //otherUserData = otherUser
                )
            }
        }, { error -> updateToErrorState(error) })
    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }
}