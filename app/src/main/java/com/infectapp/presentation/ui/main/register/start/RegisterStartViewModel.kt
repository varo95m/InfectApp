package com.infectapp.presentation.ui.main.register.start

import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.ui.MainToolbarsViewModel

class RegisterStartViewModel : BaseToolbarsViewModel<RegisterStartState, RegisterStartNavigator.Navigation>() {
    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

    fun onActionStart() {
        navigate(RegisterStartNavigator.Navigation.FromRegisterStartToRegisterEmail)
    }

    override val initialViewState: RegisterStartState = RegisterStartState()

}