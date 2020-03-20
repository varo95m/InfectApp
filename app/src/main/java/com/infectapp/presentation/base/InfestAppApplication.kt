package com.infectapp.presentation.base

import com.carmabs.ema.android.base.EmaApplication
import com.infectapp.presentation.inject.generateAppModule
import org.kodein.di.Kodein



/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class InfestAppApplication : EmaApplication() {

    override fun injectAppModule(kodein: Kodein.MainBuilder): Kodein.Module = generateAppModule(this)

    override val kodein: Kodein
        get() = super.kodein.apply { Kodein }


    override fun onCreate() {
        super.onCreate()
        //Stetho.initializeWithDefaults(this)
    }
}