package com.infectapp.presentation.ui.main

import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */
 
class MainViewModel : BaseViewModel<MainState, MainNavigator.Navigation>() {


    override fun onStartFirstTime(statePreloaded: Boolean) {

    }


    override val initialViewState: MainState = MainState()



}