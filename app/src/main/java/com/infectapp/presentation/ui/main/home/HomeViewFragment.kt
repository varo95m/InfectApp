package com.infectapp.presentation.ui.main.home

import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.KODEIN_TAG_DIALOG_LOADING
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.generic.instance


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class HomeViewFragment : BaseToolbarsFragment<HomeState, HomeViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: HomeViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: HomeViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_home

    private val loadingDialog: EmaDialogProvider by instance(tag = KODEIN_TAG_DIALOG_LOADING)

    override fun onInitializedWithToolbarsManagement(viewModel: HomeViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        refreshHome.setOnRefreshListener { viewModel.onActionRefresh() }
        ivHomeLinkToInfect.setOnClickListener { viewModel.onActionLinkClick() }
    }

    override fun onNormal(data: HomeState) {
        tv_home_total_infected.text = data.totalInfected.toString()
        tv_home_has_infected.text = String.format(getString(R.string.home_has_infected_users), 1, data.totalInfected)
        tv_home_percentage.text = data.percetangeByUser.toString()
        ivHomeLinkToInfect.text = data.link
        loadingDialog.hide()
    }

    override fun onAlternative(data: EmaExtraData) {
        loadingDialog.show()
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }
}
