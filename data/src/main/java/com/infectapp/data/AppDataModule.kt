package com.infectapp.data

import com.infectapp.data.repository.ApiMrRepository
import com.infectapp.domain.repository.Repository
import com.infectapp.domain.usecase.CreateAccountUseCase
import com.infectapp.domain.usecase.LoginUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun generateDataModule() = Kodein.Module(name = "AppDataModule") {

   bind<Repository>() with singleton { ApiMrRepository() }

   bind<CreateAccountUseCase>() with singleton { CreateAccountUseCase(instance()) }

   bind<LoginUseCase>() with singleton { LoginUseCase(instance()) }

}