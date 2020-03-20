package com.infectapp.presentation.ui.splash

import android.os.Bundle
import com.infectapp.presentation.base.BaseActivity
import com.infectapp.R
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

class SplashViewActivity : BaseActivity() {

    override fun provideFixedToolbarTitle(): String? = null

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        super.onCreateActivity(savedInstanceState)
        hideToolbar()
    }

    override val navGraph: Int = R.navigation.navigation_splash
}