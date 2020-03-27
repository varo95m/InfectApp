package com.infectapp.presentation.ui.main.home

import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class HomeViewModel : BaseToolbarsViewModel<HomeState, MainNavigator.Navigation>() {


    override fun onStartFirstTime(statePreloaded: Boolean) {
    }

    override val initialViewState: HomeState = HomeState()

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        mainToolbarsVm.onActionUpdateToolbar {
            it.copy(
                    visibility = false
            )
        }
    }


}
