package com.infectapp.presentation.ui.main.login

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.domain.usecase.GetInfectedByUserUseCase
import com.infectapp.domain.usecase.LoginUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.ui.MainToolbarsViewModel

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val getInfectedByUserUseCase: GetInfectedByUserUseCase
) : BaseToolbarsViewModel<LoginState, LoginNavigator.Navigation>() {

    companion object {
        const val INVALID_FIELDS_DIALOG = 1
        const val FIELDS_EMPTY_DIALOG = 2
    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        executeUseCaseWithException({
            val x = getInfectedByUserUseCase.execute(Unit)
            updateToNormalState {
                copy(
                    infectedByUser = x
                )
            }
        }, { error ->
            updateToErrorState(error)
        })

    }


    fun onActionRegister() {
        navigate(LoginNavigator.Navigation.RegisterStartFromLogin)
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

    fun onActionLogin() {
        navigate(LoginNavigator.Navigation.FromLoginToHome)
//        updateToAlternativeState()
//        checkDataState {
//            if (it.user.isNotEmpty() && it.password.isNotEmpty()) {
//                executeUseCaseWithException({
//                    loginUseCase.execute(RequestLoginModel(it.user, it.password, listener = ::onLoginResponse))
//                }, { error ->
//                    updateToErrorState(error)
//                })
//            }else{
//                updateToAlternativeState(EmaExtraData(FIELDS_EMPTY_DIALOG))
//            }
//        }
    }

    fun onLoginResponse(result: Boolean) {
        if (result) {
            updateToNormalState()
            navigate(LoginNavigator.Navigation.FromLoginToHome)
        } else {
            updateToAlternativeState(EmaExtraData(INVALID_FIELDS_DIALOG))
        }
    }

    override val initialViewState: LoginState = LoginState()

}