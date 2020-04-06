package com.infectapp.presentation.ui.main.ranking

import android.graphics.Typeface
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.domain.model.InfectedUserModel
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

    private fun setupRecycler() {
        rvRankingOtherUsers.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }


    override fun onNormal(data: RankingState) {
        data.otherUsersList?.let { otherUserList ->
            rvRankingOtherUsers.adapter?.notifyDataSetChanged() ?: run {
                rvRankingOtherUsers.adapter =
                        OtherUserAdapter(
                                otherUserList.toMutableList(),
                                ::onActionUserClick
                        )
            }
        }
        data.podiumUsersList?.let { podium ->
            podium[0].apply {
                tv_ranking_item_one_name.text = username
//                tv_ranking_item_one_infected.text = totalInfectedByUser.toString()
                if (isUserLogged)
                    tv_ranking_item_one_name.typeface = Typeface.DEFAULT_BOLD
            }
            podium[1].apply {
                tv_ranking_item_two_name.text = username
//                tv_ranking_item_two_infected.text = totalInfectedByUser.toString()
                if (isUserLogged)
                    tv_ranking_item_two_name.typeface = Typeface.DEFAULT_BOLD
            }
            podium[2].apply {
                tv_ranking_item_three_name.text = username
//                tv_ranking_item_three_infected.text = totalInfectedByUser.toString()
                if (isUserLogged)
                    tv_ranking_item_three_name.typeface = Typeface.DEFAULT_BOLD
            }
        }

        data.userLogged?.let {
            if (it.userPosition > 5) {
                tv_ranking_item_own_user.visibility = View.VISIBLE
                tv_ranking_item_own_user_position.text = it.userPosition.toString()
                tv_ranking_item_own_user_name.text = it.username
//                tv_ranking_item_own_user_infected.text = it.totalInfectedByUser.toString()
            } else {
                tv_ranking_item_own_user.visibility = View.GONE
            }
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
