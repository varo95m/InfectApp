package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.RequestCreateAccountModel
import com.infectapp.domain.repository.Repository

class CreateAccountUseCase(private val repository: Repository) : EmaUseCase<RequestCreateAccountModel, Unit>() {
    override suspend fun useCaseFunction(input: RequestCreateAccountModel) {
        return repository.createAccount(input)
    }
}