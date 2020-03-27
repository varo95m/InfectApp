package com.infectapp.presentation.navigation

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

class MainNavigator(override val navController: NavController) : BaseNavigator<MainNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        object TabbarHomeButton : MainNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as MainNavigator
                nav.toHomeButton()
            }
        }

        object TabbarNewsButton : MainNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as MainNavigator
                nav.toNewsButton()
            }
        }

        object TabbarRankingButton : MainNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as MainNavigator
                nav.toRankingButton()
            }
        }

        object GoBack : MainNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as MainNavigator
                nav.toBack()
            }
        }
    }

    private fun toHomeButton() {
        navigateWithAction(R.id.action_global_homeViewFragment)
    }

    private fun toNewsButton() {
        navigateWithAction(R.id.action_global_newsViewFragment)
    }

    private fun toRankingButton() {
        navigateWithAction(R.id.action_global_rankingViewFragment)
    }

    private fun toBack() {
        navigateBack()
    }
}