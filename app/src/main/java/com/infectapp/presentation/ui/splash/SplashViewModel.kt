package com.infectapp.presentation.ui.splash

import com.infectapp.presentation.SPLASH_DELAY
import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.navigation.SplashNavigator
import kotlinx.coroutines.delay

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class SplashViewModel : BaseViewModel<SplashState, SplashNavigator.Navigation>() {

    override val initialViewState: SplashState = SplashState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
        super.onStartFirstTime(statePreloaded)
        executeUseCase {
            delay(SPLASH_DELAY)
            navigate(SplashNavigator.Navigation.LoginFromSplash)
        }
    }


    fun showSplashAndNavigate() {
        executeUseCase {

            delay(5000)
            navigate(SplashNavigator.Navigation.LoginFromSplash)
        }
    }
}