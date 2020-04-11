package com.infectapp.data

import com.infectapp.data.repository.ApiInfectAppRepository
import com.infectapp.data.repository.RoomLocalStorageRepository
import com.infectapp.domain.repository.LocalStorageRepository
import com.infectapp.domain.repository.Repository
import com.infectapp.domain.usecase.CreateAccountUseCase
import com.infectapp.domain.usecase.GetInfectedByUserUseCase
import com.infectapp.domain.usecase.GetTotalInfectedUseCase
import com.infectapp.domain.usecase.LoginUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "AppDataModule") {

    bind<Repository>() with singleton { ApiInfectAppRepository() }

    bind<LocalStorageRepository>() with singleton { RoomLocalStorageRepository(instance()) }

    bind<CreateAccountUseCase>() with singleton { CreateAccountUseCase(instance()) }

    bind<LoginUseCase>() with singleton { LoginUseCase(instance()) }

    bind<GetTotalInfectedUseCase>() with singleton { GetTotalInfectedUseCase(instance()) }

}