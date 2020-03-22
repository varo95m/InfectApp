package com.infectapp.presentation.navigation

import android.app.Activity
import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.infectapp.R
import com.infectapp.presentation.base.BaseNavigator

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class SplashNavigator(override val navController: NavController,private val activity: Activity) : BaseNavigator<SplashNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {

        object LoginFromSplash : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as SplashNavigator
                nav.toLoginFromSplash()
            }
        }
    }

    private fun toLoginFromSplash() {
        navigateWithAction(R.id.action_splashViewFragment_to_graphMain)
    }
}