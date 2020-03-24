package com.infectapp.presentation.ui.main.register.email

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.model.RegisterModel

data class RegisterEmailState(
        val buttonNextEnable: Boolean = true,
        val registerModel: RegisterModel = RegisterModel(),
        val emailError:Boolean = false
) : EmaBaseState