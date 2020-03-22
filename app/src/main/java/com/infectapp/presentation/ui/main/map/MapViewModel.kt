package com.infectapp.presentation.ui.main.map

import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.MainNavigator


class MapViewModel : BaseViewModel<MapState, MainNavigator.Navigation>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override fun onResume(firstTime: Boolean) {

    }

    override val initialViewState: MapState = MapState()

}