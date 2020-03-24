package com.infectapp.presentation.ui.main.register.username

import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.domain.model.RequestCreateAccountModel
import com.infectapp.domain.usecase.CreateAccountUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.ui.MainToolbarsViewModel

class RegisterUsernameViewModel(private val createAccountUseCase: CreateAccountUseCase) : BaseToolbarsViewModel<RegisterUsernameState, RegisterUsernameNavigator.Navigation>() {
    companion object {
        const val CREATE_ACCOUNT_SUCCESSFUL_DIALOG = 1
        const val CREATE_ACCOUNT_UNSUCCESSFUL_DIALOG = 2
    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

    fun onActionUsernameChange(string: String) {
        updateDataState {
            copy(
                    registerModel = this.registerModel?.copy(
                            username = string),
                    buttonNextEnable = checkButtonNext(string)
            )
        }
    }

    private fun checkButtonNext(username: String): Boolean {
        return username.isNotEmpty()
    }

    fun onActionCreateAccount() {
        updateToAlternativeState()
        checkDataState {
            executeUseCaseWithException({
                it.registerModel?.apply {
                    createAccountUseCase.execute(RequestCreateAccountModel(password = password, email = email, listener = ::onCreateAccountResponse, registerModel = it.registerModel))
                }
            }, { error -> updateToErrorState(error) })
        }
    }

    private fun onCreateAccountResponse(result: Boolean) {
        if (result) {
            updateToAlternativeState(EmaExtraData(CREATE_ACCOUNT_SUCCESSFUL_DIALOG))
        } else {
            updateToAlternativeState(EmaExtraData(CREATE_ACCOUNT_UNSUCCESSFUL_DIALOG))
        }
    }

    override val initialViewState: RegisterUsernameState = RegisterUsernameState()

}