package com.infectapp.presentation.ui.main.login

import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.infectapp.R
import com.infectapp.presentation.base.BaseNavigator


class LoginNavigator(override val navController: NavController) : BaseNavigator<LoginNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        object RegisterStartFromLogin : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as LoginNavigator
                nav.toRegisterStart()
            }
        }

        object FromLoginToHome : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as LoginNavigator
                nav.toHome()
            }
        }

    }

    private fun toRegisterStart() {
        navigateWithAction(R.id.action_loginViewFragment_to_registerStartViewFragment)
    }

    private fun toHome() {
        navigateWithAction(R.id.action_loginViewFragment_to_mainToolbarsViewActivity)
    }
}
