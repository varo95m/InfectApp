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

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.infectapp.R
import com.infectapp.data.repository.RoomLocalStorageRepository
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.presentation.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginViewActivity : BaseActivity() {

    override val navGraph: Int = R.navigation.navigation_login

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        super.onCreateActivity(savedInstanceState)
    }

    override fun provideFixedToolbarTitle(): String? = STRING_EMPTY
}