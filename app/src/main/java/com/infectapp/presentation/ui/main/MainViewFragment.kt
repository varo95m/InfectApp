package com.infectapp.presentation.ui.main

import androidx.fragment.app.Fragment
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseFragment
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.main.home.HomeViewFragment
import com.infectapp.presentation.ui.main.map.MapViewFragment
import com.infectapp.presentation.ui.main.search.SearchViewFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class MainViewFragment : BaseFragment<MainState, MainViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: MainViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: MainViewModel? = null

    override val layoutId: Int get() = R.layout.activity_main


    override fun onInitialized(viewModel: MainViewModel) {
        vm = viewModel
        bottomNavigationListener()
    }

    override fun onSingleEvent(data: EmaExtraData) {

    }

    private fun bottomNavigationListener() {
        btv_main.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.action_home ->{
                    val fragment = HomeViewFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.action_ranking ->{
                    val fragment = MapViewFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.action_news ->{
                    val fragment = SearchViewFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    override fun onNormal(data: MainState) {
        btv_main.selectedItemId = R.id.action_home
    }
    override fun onError(error: Throwable): Boolean {
        return false
    }


    override fun onAlternative(data: EmaExtraData) {

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fl_main_fragment, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }


}