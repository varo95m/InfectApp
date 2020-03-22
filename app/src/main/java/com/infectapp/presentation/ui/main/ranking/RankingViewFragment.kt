package com.infectapp.presentation.ui.main.ranking

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseFragment
import com.infectapp.presentation.navigation.MainNavigator
import org.kodein.di.generic.instance

class RankingViewFragment : BaseFragment<RankingState, RankingViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: RankingViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: RankingViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_ranking


    override fun onInitialized(viewModel: RankingViewModel) {
        vm = viewModel
    }


    override fun onNormal(data: RankingState) {
    }


    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }

    companion object{
        fun newInstance(): RankingViewFragment = RankingViewFragment()
    }

}
