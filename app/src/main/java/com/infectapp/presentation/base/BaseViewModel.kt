package com.infectapp.presentation.base

import com.carmabs.ema.android.viewmodel.EmaViewModel
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.state.EmaState


/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

abstract class BaseViewModel<T, NS : EmaNavigationState> : EmaViewModel<T, NS>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {
        // Override when is needed to launch first time options
    }

    override fun onResume(firstTime: Boolean) {
        onStartAnalytic()
    }

    abstract fun onStartAnalytic()
}