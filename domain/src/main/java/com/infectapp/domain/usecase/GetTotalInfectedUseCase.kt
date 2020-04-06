package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.RequestTotalInfectedModel
import com.infectapp.domain.repository.Repository

class GetTotalInfectedUseCase(private val repository: Repository) : EmaUseCase<RequestTotalInfectedModel, Unit>() {
    override suspend fun useCaseFunction(input: RequestTotalInfectedModel) {
        return repository.getTotalInfected(input)
    }
}