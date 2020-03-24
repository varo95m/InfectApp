package com.infectapp.presentation.ui.main.register.username

import androidx.navigation.NavController
import com.carmabs.ema.core.navigator.EmaBaseNavigator
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.infectapp.R
import com.infectapp.presentation.base.BaseNavigator
import com.infectapp.presentation.ui.main.register.password.RegisterPasswordState

class RegisterUsernameNavigator(override val navController: NavController) : BaseNavigator<RegisterUsernameNavigator.Navigation>() {

    sealed class Navigation : EmaNavigationState {
    }

}