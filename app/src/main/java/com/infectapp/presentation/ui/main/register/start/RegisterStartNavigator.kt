package com.infectapp.presentation.ui.main.register.start

import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.infectapp.R
import com.infectapp.presentation.base.BaseNavigator


class RegisterStartNavigator(override val navController: NavController) : BaseNavigator<RegisterStartNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        object FromRegisterStartToRegisterEmail : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as RegisterStartNavigator
                nav.toRegisterEmail()
            }
        }

    }

    private fun toRegisterEmail() {
        navigateWithAction(R.id.action_registerStartViewFragment_to_registerEmailViewFragment)
    }

}