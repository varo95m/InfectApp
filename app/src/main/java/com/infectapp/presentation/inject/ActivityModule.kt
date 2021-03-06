package com.infectapp.presentation.inject

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.infectapp.presentation.KODEIN_TAG_DIALOG_LOADING
import com.infectapp.presentation.KODEIN_TAG_DIALOG_SIMPLE
import com.infectapp.presentation.base.BaseActivity
import com.infectapp.presentation.dialog.loading.LoadingDialogProvider
import com.infectapp.presentation.dialog.simple.SimpleDialogProvider
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.navigation.SplashNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */


fun injectionActivityModule(activity: BaseActivity) = Kodein.Module(name = "ActivityModule") {

    //NAVIGATOR//

    bind<SplashNavigator>() with singleton { SplashNavigator(instance(), instance()) }

    bind<MainNavigator>() with singleton { MainNavigator(instance()) }

    bind<FragmentManager>() with provider { activity.supportFragmentManager }

    bind<MainToolbarsViewModel>() with provider { MainToolbarsViewModel() }

    //ACTIVITY//

    bind<BaseActivity>() with singleton { activity }

    //NAV CONTROLLER//

    bind<NavController>() with singleton { activity.navController }

    //HANDLERS

    //DIALOGS

    bind<EmaDialogProvider>(tag = KODEIN_TAG_DIALOG_LOADING) with provider { LoadingDialogProvider(instance()) }

    bind<EmaDialogProvider>(tag = KODEIN_TAG_DIALOG_SIMPLE) with provider { SimpleDialogProvider(instance()) }

}
