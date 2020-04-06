package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.RequestInfectedAtDay
import com.infectapp.domain.repository.Repository

class GetInfectedAtDayUseCase(private val repository: Repository) : EmaUseCase<RequestInfectedAtDay, Unit>() {
    override suspend fun useCaseFunction(input: RequestInfectedAtDay) {
        return repository.getInfectedAtDay(input)
    }
}