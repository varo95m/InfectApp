package com.infectapp.presentation.ui.main

import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.UserModel
import com.infectapp.domain.usecase.GetInfectedListUseCase
import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.main.ranking.RankingState
import com.infectapp.presentation.ui.main.ranking.RankingViewModel


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class MainViewModel(
    private val getInfectedListUseCase: GetInfectedListUseCase
) : BaseViewModel<MainState, MainNavigator.Navigation>() {


    private var totalUsersListSorted = listOf<InfectedUserModel>()
    private var podiumList = listOf<InfectedUserModel>()
    private var otherUsersListSorted = mutableListOf<InfectedUserModel>()
    private var userLoggedInfo = InfectedUserModel()
    private var position: Int = INT_ZERO

    private val userModel = UserModel()


    override fun onStartFirstTime(statePreloaded: Boolean) {
        executeUseCase {
            totalUsersListSorted =
                getInfectedListUseCase.execute(Unit).sortedByDescending { it.totalInfected }
            totalUsersListSorted.forEach {
                it.userPosition = position
                position += 1
            }
            userLoggedInfo = findUserLogged()
            podiumList = listOf(
                totalUsersListSorted[0],
                totalUsersListSorted[1],
                totalUsersListSorted[2]
            )
            otherUsersListSorted = totalUsersListSorted.toMutableList()
            removePodiumUsers()
        }
    }

    private fun findUserLogged(): InfectedUserModel {
        return totalUsersListSorted.find {
            it.username == "prueba5" //TODO userModel.username
        }?.let {userLogged ->
            totalUsersListSorted[totalUsersListSorted.indexOf(userLogged)].isUserLogged = true
            userLogged.copy(isUserLogged = true)
        } ?: InfectedUserModel()
    }

    private fun removePodiumUsers() {
        otherUsersListSorted.removeAt(0)
        otherUsersListSorted.removeAt(1)
        otherUsersListSorted.removeAt(2)
    }

    fun onActionHome() {

    }

    fun onActionRanking() {
        RankingViewModel.totalUsersListSorted = totalUsersListSorted
        RankingViewModel.podiumList = podiumList
        RankingViewModel.otherUsersListSorted = otherUsersListSorted
        RankingViewModel.userLoggedInfo = userLoggedInfo
    }

    fun onActionNews() {

    }

    override val initialViewState: MainState = MainState()


}