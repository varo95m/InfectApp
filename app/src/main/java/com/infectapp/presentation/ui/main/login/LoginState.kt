package com.infectapp.presentation.ui.main.login

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.STRING_EMPTY

/**
 * Home view state
 *
 * <p>
 * Copyright (c) 2018, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

data class LoginState(
        val buttonLoginVisibility: Boolean = true,
        val buttonLoginEnable: Boolean = true,
        val user: String = STRING_EMPTY,
        val password: String = STRING_EMPTY,
        val infectedByUser : String = STRING_EMPTY
) : EmaBaseState