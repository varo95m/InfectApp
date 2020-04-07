package com.infectapp.presentation.ui.main.news

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_ranking.*
import org.kodein.di.generic.instance

class NewsViewFragment : BaseToolbarsFragment<NewsState, NewsViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: NewsViewModel by instance()

    override val navigator: MainNavigator by instance()

    private lateinit var vm: NewsViewModel

    override val layoutId: Int get() = R.layout.fragment_news

    override fun onNormal(data: NewsState) {
        rvNews.adapter = NewsAdapter(data.listNews.toMutableList())
    }

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }

    override fun onInitializedWithToolbarsManagement(viewModel: NewsViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        refreshNews.setOnRefreshListener { viewModel.onActionRefresh() }
        setupRecycler()
    }

    private fun setupRecycler() {
        rvNews.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }

}
