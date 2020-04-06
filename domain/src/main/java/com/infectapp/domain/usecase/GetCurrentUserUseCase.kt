package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.RequestCurrentUser
import com.infectapp.domain.repository.Repository

class GetCurrentUserUseCase(private val repository: Repository) : EmaUseCase<RequestCurrentUser, Unit>() {
    override suspend fun useCaseFunction(input: RequestCurrentUser) {
        return repository.getCurrentUser(input)
    }
}