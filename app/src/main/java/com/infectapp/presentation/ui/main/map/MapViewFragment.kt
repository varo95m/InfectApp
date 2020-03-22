package com.infectapp.presentation.ui.main.map

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.presentation.base.BaseFragment
import com.infectapp.presentation.navigation.MainNavigator
import org.kodein.di.generic.instance

class MapViewFragment : BaseFragment<MapState, MapViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: MapViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: MapViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_news


    override fun onInitialized(viewModel: MapViewModel) {
        vm = viewModel
    }


    override fun onNormal(data: MapState) {
    }


    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }

    companion object{
        fun newInstance(): MapViewFragment = MapViewFragment()
    }

}
