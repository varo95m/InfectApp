package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.RequestLoginModel
import com.infectapp.domain.repository.Repository

class LoginUseCase(private val repository: Repository) : EmaUseCase<RequestLoginModel, Unit>() {
    override suspend fun useCaseFunction(input: RequestLoginModel) {
        return repository.login(input)
    }
}