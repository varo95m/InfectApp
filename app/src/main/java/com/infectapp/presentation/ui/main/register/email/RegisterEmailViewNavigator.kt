package com.infectapp.presentation.ui.main.register.email

import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.infectapp.R
import com.infectapp.presentation.base.BaseNavigator
import com.infectapp.presentation.ui.main.register.password.RegisterPasswordState
import com.infectapp.presentation.ui.main.register.username.RegisterUsernameState


class RegisterEmailViewNavigator(override val navController: NavController) : BaseNavigator<RegisterEmailViewNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        class FromRegisterEmailToRegisterPassword(private val state: RegisterPasswordState) : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as RegisterEmailViewNavigator
                nav.toRegisterPassword(state)
            }
        }

    }

    private fun toRegisterPassword(state: RegisterPasswordState) {
        navigateWithAction(R.id.action_registerEmailViewFragment_to_registerPasswordViewFragment, addInputState(state))
    }

}