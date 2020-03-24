package com.infectapp.presentation.ui.main.register.username

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.domain.model.RegisterModel

data class RegisterUsernameState(
        val buttonNextEnable: Boolean = true,
        val registerModel: RegisterModel? = null
) : EmaBaseState