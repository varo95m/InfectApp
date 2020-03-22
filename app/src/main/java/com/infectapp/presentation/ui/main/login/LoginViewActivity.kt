package com.infectapp.presentation.ui.main.login

/**
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-04
 */

import com.infectapp.R
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.presentation.base.BaseActivity


class LoginViewActivity : BaseActivity() {

    override val navGraph: Int = R.navigation.navigation_login

    override fun provideFixedToolbarTitle(): String? = STRING_EMPTY
}