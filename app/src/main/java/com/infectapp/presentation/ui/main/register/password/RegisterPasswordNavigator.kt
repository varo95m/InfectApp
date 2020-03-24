package com.infectapp.presentation.ui.main.register.password

import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.infectapp.R
import com.infectapp.presentation.base.BaseNavigator
import com.infectapp.presentation.ui.main.register.username.RegisterUsernameState


class RegisterPasswordNavigator(override val navController: NavController) : BaseNavigator<RegisterPasswordNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
        class FromRegisterPasswordToRegisterUsername(val state: RegisterUsernameState) : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as RegisterPasswordNavigator
                nav.toRegisterUserName(state)
            }
        }

    }

    private fun toRegisterUserName(state: RegisterUsernameState) {
        navigateWithAction(R.id.action_registerPasswordViewFragment_to_registerUsernameViewFragment, addInputState(state))
    }

}