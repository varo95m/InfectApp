package com.infectapp.presentation.ui.main.register.password

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.domain.model.RegisterModel

data class RegisterPasswordState(
        val registerModel: RegisterModel? = null,
        val repeatPassword:String = STRING_EMPTY,
        val minLength: Boolean = false,
        val passwordNotEqual: Boolean =false
) : EmaBaseState