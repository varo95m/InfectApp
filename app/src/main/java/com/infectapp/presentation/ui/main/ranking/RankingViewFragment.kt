package com.infectapp.presentation.ui.main.ranking

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_ranking.*
import org.kodein.di.generic.instance

class RankingViewFragment :
        BaseToolbarsFragment<RankingState, RankingViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: RankingViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: RankingViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_ranking

    private fun setupRecycler() {
        rvRankingUsers.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }


    override fun onNormal(data: RankingState) {
        if (data.usersList.isNotEmpty()) {
            val adapter = RankingUserAdapter(data.usersList as MutableList<InfectedUserModel>, userListener = ::onActionUserClick)
            rvRankingUsers.adapter = adapter
        }
    }

    private fun onActionUserClick(user: InfectedUserModel) {
        vm?.onActionUserClick(user)
    }


    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }

    override fun onInitializedWithToolbarsManagement(viewModel: RankingViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        refreshRanking.setOnRefreshListener { viewModel.onActionRefresh() }
        setupRecycler()
    }


}
