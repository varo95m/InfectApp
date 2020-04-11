package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.repository.LocalStorageRepository


/**
 *
 * <p>
 * Copyright (C) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:jorge.valino@babel.es">Jorge Valiño Guerra</a>
 */
class GetInfectedByUserUseCase (private val localStorageRepository: LocalStorageRepository) : EmaUseCase<Unit, String>() {
    override suspend fun useCaseFunction(input: Unit) : String {
        return localStorageRepository.getInfectedByUser()
    }
}