package com.infectapp.presentation.ui.main.ranking.search

import android.text.Editable
import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


class SearchViewModel(
   // private val getTotalUserListUseCase: GetTotalUserListUseCase//todos los usuarios pal ranking
   // private val getOtherUserDataUseCase: GetOtherUserDataUseCase,//un usuario concreto
    //private val getUserLoggedUseCase: GetUserLoggedUseCase//el usuario logueado el cual alokme deberíamos obtener desde la home
) : BaseToolbarsViewModel<SearchState, MainNavigator.Navigation>() {

    override val initialViewState: SearchState = SearchState()

    private var totalUsersListSorted = listOf<InfectedUserModel>()
    private var podiumList = listOf<InfectedUserModel>()
    private var otherUsersListSorted = mutableListOf<InfectedUserModel>()

    private var position = INT_NEGATIVE

    override fun onStartFirstTime(statePreloaded: Boolean) {
        if (!statePreloaded) {

        }
    }

    override fun onResume(firstTime: Boolean) {

    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

    fun onActionSearch(text: Editable) {
//        executeUseCaseWithException({
//            getOtherUserDataUseCase.execute(text)
//        }, { error -> updateToErrorState(error) })
    }
}