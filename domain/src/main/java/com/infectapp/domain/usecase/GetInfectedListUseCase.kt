package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.repository.Repository

class GetInfectedListUseCase (private val repository: Repository) : EmaUseCase<Unit, List<InfectedUserModel>>() {
    override suspend fun useCaseFunction(input: Unit) =
        repository.getInfectedList()

}