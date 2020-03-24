package com.infectapp.presentation.ui.main.register.email

import com.infectapp.domain.isValidEmail
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.ui.MainToolbarsViewModel
import com.infectapp.presentation.ui.main.register.password.RegisterPasswordState

class RegisterEmailViewModel : BaseToolbarsViewModel<RegisterEmailState, RegisterEmailViewNavigator.Navigation>() {
    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

    override val initialViewState: RegisterEmailState = RegisterEmailState()

    fun onActionNext() {
        checkDataState {
            navigate(RegisterEmailViewNavigator.Navigation.FromRegisterEmailToRegisterPassword(RegisterPasswordState(registerModel = it.registerModel)))
        }
    }

    fun onActionEmailChange(string: String) {
        checkDataState {
            updateDataState {
                copy(
                        registerModel = this.registerModel.copy(
                                email = string
                        )
                )
            }
            updateToNormalState {
                copy(
                        emailError = !checkEmailError(registerModel.email)
                )
            }
        }
    }

    private fun checkEmailError(string: String): Boolean {
        val regex = "^[A-Za-z0-9](.*)([@]{1})(.{1,})(\\.)(.{2,})"
        return regex.toRegex().matches(string)
    }
}