package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.RequestUserList
import com.infectapp.domain.repository.Repository

class GetInfectedListUseCase(private val repository: Repository) : EmaUseCase<RequestUserList, Unit>() {
    override suspend fun useCaseFunction(input: RequestUserList) =
            repository.getInfectedList(input)

}