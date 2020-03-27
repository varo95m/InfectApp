package com.infectapp.presentation.ui.main.home

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseFragment
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import org.kodein.di.generic.instance


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class HomeViewFragment: BaseToolbarsFragment<HomeState, HomeViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: HomeViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: HomeViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_home

    override fun onNormal(data: HomeState) {
    }

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }

    override fun onInitializedWithToolbarsManagement(viewModel: HomeViewModel, mainToolbarViewModel: MainToolbarsViewModel) {

    }

}
