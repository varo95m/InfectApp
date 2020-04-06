package com.infectapp.presentation.ui.main.ranking.search

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import org.kodein.di.generic.instance

class SearchViewFragment :
        BaseToolbarsFragment<SearchState, SearchViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: SearchViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: SearchViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_search

    override fun onInitializedWithToolbarsManagement(viewModel: SearchViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        etSearchUserSearch.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                keyEvent?.action == KeyEvent.ACTION_DOWN && keyEvent.keyCode == KeyEvent.KEYCODE_ENTER) {
                viewModel.onActionSearch(etSearchUserSearch.text)
            }
            false
        }
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



}
