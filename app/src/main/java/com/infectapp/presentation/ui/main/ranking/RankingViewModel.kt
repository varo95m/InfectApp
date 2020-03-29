package com.infectapp.presentation.ui.main.ranking

import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


class RankingViewModel(
//    private val getTotalUserListUseCase: GetTotalUserListUseCase,//todos los usuarios pal ranking
//    private val getOtherUserDataUseCase: GetOtherUserDataUseCase,//un usuario concreto
//    private val getUserLoggedUseCase: GetUserLoggedUseCase//el usuario logueado el cual alokme deberíamos obtener desde la home
) : BaseViewModel<RankingState, MainNavigator.Navigation>() {

    override val initialViewState: RankingState = RankingState()

    private var totalUsersListSorted = listOf<InfectedUserModel>()
    private var podiumList = listOf<InfectedUserModel>()
    private var otherUsersListSorted = mutableListOf<InfectedUserModel>()

    private var position = INT_NEGATIVE

    override fun onStartFirstTime(statePreloaded: Boolean) {
        if (!statePreloaded) {
            getInfectedRankingData()
        }
    }

    private fun getInfectedRankingData() {
        executeUseCaseWithException({
//            totalUsersListSorted =
//                getTotalUserListUseCase.execute(Unit).sortedByDescending { it.totalInfectedByUser }
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
        }, { error -> updateToErrorState(error) })
        updateToNormalState {
            copy(
                totalUsersList = totalUsersListSorted,
                podiumUsersList = podiumList,
                otherUsersList = otherUsersListSorted
//                userLogged = getUserLoggedUseCase.execute(Unit)
            )
        }
    }

    private fun removePodiumUsers() {
        otherUsersListSorted.removeAt(0)
        otherUsersListSorted.removeAt(1)
        otherUsersListSorted.removeAt(2)
    }


    override fun onResume(firstTime: Boolean) {

    }

    fun onActionRefresh() {
        getInfectedRankingData()
    }

    fun onActionUserClick(user: InfectedUserModel) {
        executeUseCaseWithException({
//            val otherUser = getOtherUserDataUseCase.execute(user)
            updateToNormalState {
                copy(
//                    otherUserData = otherUser
                )
            }
        }, { error -> updateToErrorState(error) })
    }
}