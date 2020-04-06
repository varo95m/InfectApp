package com.infectapp.presentation.ui.main.ranking

import android.graphics.Typeface
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.presentation.KODEIN_TAG_DIALOG_LOADING
import com.infectapp.presentation.base.BaseFragment
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

    private val loadingDialog: EmaDialogProvider by instance(tag = KODEIN_TAG_DIALOG_LOADING)

    override fun onInitializedWithToolbarsManagement(viewModel: RankingViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        refreshRanking.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                viewModel.onActionRefresh()
            }
        })
        setupRecycler()
        ivRankingSearch.setOnClickListener { viewModel.onSearchAction() }
    }

    private fun setupRecycler() {
        rvRankingOtherUsers.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }


    override fun onNormal(data: RankingState) {
        data.otherUsersList?.let { otherUserList ->
            rvRankingOtherUsers.adapter?.notifyDataSetChanged() ?: run {
                rvRankingOtherUsers.adapter =
                    RankingOtherUserAdapter(
                                otherUserList.toMutableList(),
                                ::onActionUserClick
                        )
            }
        }
        data.podiumUsersList?.let { podium ->
            podium[0].apply {
                tvItemRankingItemOneUsername.text = username
                tvItemRankingItemOnePosition.text = userPosition.toString()
                tvItemRankingItemOneInfected.text = totalInfectedByUser.toString()
                if (isUserLogged)
                    tvItemRankingItemOneUsername.typeface = Typeface.DEFAULT_BOLD
            }
            podium[1].apply {
                tvItemRankingItemTwoUsername.text = username
                tvItemRankingItemTwoPosition.text = userPosition.toString()
                tvItemRankingItemTwoInfected.text = totalInfectedByUser.toString()
                if (isUserLogged)
                    tvItemRankingItemTwoUsername.typeface = Typeface.DEFAULT_BOLD
            }
            podium[2].apply {
                tvItemRankingItemThreeUsername.text = username
                tvItemRankingItemThreePosition.text = userPosition.toString()
                tvItemRankingItemThreeInfected.text = totalInfectedByUser.toString()
                if (isUserLogged)
                    tvItemRankingItemThreeUsername.typeface = Typeface.DEFAULT_BOLD
            }
        }

        data.userLogged?.let {
            if (it.userPosition > 5) {
                constraintLayoutOwnUser.visibility = View.VISIBLE
                tvItemRankingOwnUserPosition.text = it.userPosition.toString()
                tvItemRankingOwnUserUsername.text = it.username
//                tv_ranking_item_own_user_infected.text = it.totalInfectedByUser.toString()
            } else {
                constraintLayoutOwnUser.visibility = View.GONE
            }
        }
        refreshRanking.isRefreshing = false
        loadingDialog.hide()
    }

    private fun onActionUserClick(user: InfectedUserModel) {
        vm?.onActionUserClick(user)
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
