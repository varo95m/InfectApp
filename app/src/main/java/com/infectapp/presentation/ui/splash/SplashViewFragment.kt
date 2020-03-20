package com.infectapp.presentation.ui.splash

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.presentation.base.BaseFragment
import com.infectapp.presentation.navigation.SplashNavigator
import com.infectapp.R
import org.kodein.di.generic.instance

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class SplashViewFragment : BaseFragment<SplashState, SplashViewModel, SplashNavigator.Navigation>() {

    override val viewModelSeed: SplashViewModel by instance()

    override val navigator: SplashNavigator by instance()

    override val layoutId: Int = R.layout.fragment_splash

    override fun onInitialized(viewModel: SplashViewModel) {

    }

    override fun onNormal(data: SplashState) {
    }

    override fun onLoading(data: EmaExtraData) {
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onError(error: Throwable): Boolean {
        return false
    }

    override fun onStateAlternative(data: EmaExtraData) {
    }

}