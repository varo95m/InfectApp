package com.infectapp.presentation.ui.main.home

import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */
 
class HomeViewModel : BaseViewModel<HomeState, MainNavigator.Navigation>() {


    override fun onStartFirstTime(statePreloaded: Boolean) {
    }

    override val initialViewState: HomeState = HomeState()


}
