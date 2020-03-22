package com.infectapp.presentation.ui.main.search

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseFragment
import com.infectapp.presentation.navigation.MainNavigator
import org.kodein.di.generic.instance

class SearchViewFragment : BaseFragment<SearchState, SearchViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: SearchViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: SearchViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_ranking


    override fun onInitialized(viewModel: SearchViewModel) {
        vm = viewModel
    }


    override fun onNormal(data: SearchState) {
    }


    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }

    companion object{
        fun newInstance(): SearchViewFragment = SearchViewFragment()
    }

}
