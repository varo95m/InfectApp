package com.infectapp.presentation.ui.splash

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.STRING_EMPTY

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

data class SplashState(val version:String = STRING_EMPTY) : EmaBaseState {
}