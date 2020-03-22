package com.infectapp.presentation.ui.main.news

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseFragment
import com.infectapp.presentation.navigation.MainNavigator
import org.kodein.di.generic.instance

class NewsViewFragment : BaseFragment<NewsState, NewsViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: NewsViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: NewsViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_news


    override fun onInitialized(viewModel: NewsViewModel) {
        vm = viewModel
    }


    override fun onNormal(data: NewsState) {
    }


    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }

    companion object{
        fun newInstance(): NewsViewFragment = NewsViewFragment()
    }

}
