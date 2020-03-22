package com.infectapp.presentation.ui.main.login

import com.infectapp.domain.usecase.CreateAccountUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.ui.MainToolbarsViewModel
import com.musketeers.richsnet.presentation.ui.login.LoginState

class LoginViewModel(private val createAccountUseCase: CreateAccountUseCase) : BaseToolbarsViewModel<LoginState, LoginNavigator.Navigation>() {

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
    }

    fun onActionRegister() {
        navigate(LoginNavigator.Navigation.RegisterStartFromLogin)
    }

    private fun onRegisterFinish(result: Boolean) {

    }

    fun onActionUserChange(string: String) {
        updateDataState {
            copy(
                    user = string
            )
        }
    }

    fun onActionPasswordChange(string: String) {
        updateDataState {
            copy(
                    password = string
            )
        }
    }

    override val initialViewState: LoginState = LoginState()

}