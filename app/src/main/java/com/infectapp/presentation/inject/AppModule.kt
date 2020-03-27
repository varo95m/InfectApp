package com.infectapp.presentation.inject

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.provider.UserDictionary.Words.APP_ID
import com.infectapp.data.repository.MockRepository
import com.infectapp.domain.repository.Repository
import com.infectapp.domain.usecase.GetInfectedListUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
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


fun generateAppModule(app: Application) = Kodein.Module(name = "AppModule") {

    bind<Application>() with singleton { app }

    bind<Resources>() with singleton { app.resources }

    bind<SharedPreferences>() with singleton { app.getSharedPreferences(APP_ID, Context.MODE_PRIVATE) }

    bind<GetInfectedListUseCase>() with singleton { GetInfectedListUseCase(instance()) }


}
