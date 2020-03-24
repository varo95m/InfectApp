package com.infectapp.presentation.ui.main.register.password

import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.ui.MainToolbarsViewModel
import com.infectapp.presentation.ui.main.register.username.RegisterUsernameState

class RegisterPasswordViewModel : BaseToolbarsViewModel<RegisterPasswordState, RegisterPasswordNavigator.Navigation>() {

    override val initialViewState: RegisterPasswordState = RegisterPasswordState()

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

    fun onActionPasswordChange(string: String) {
        updateDataState {
            copy(
                    registerModel = this.registerModel?.copy(
                            password = string
                    )
            )
        }
        checkPassword()
    }

    fun onActionRepeatPasswordChange(string: String) {
        updateDataState {
            copy(
                    repeatPassword = string
            )
        }
        checkPassword()

    }

    fun onActionNext() {
        checkDataState {
                navigate(RegisterPasswordNavigator.Navigation.FromRegisterPasswordToRegisterUsername(RegisterUsernameState(registerModel = it.registerModel)))
        }
    }

    private fun checkPassword() {
        checkDataState { state ->
            state.registerModel?.password?.let {
                updateToNormalState {
                    copy(
                            passwordNotEqual = repeatPassword != it,
                            minLength = it.length < 6
                    )
                }
            }
        }
    }

}