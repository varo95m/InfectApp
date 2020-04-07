package com.infectapp.domain.usecase

import com.carmabs.ema.core.usecase.EmaUseCase
import com.infectapp.domain.model.RequestNewsList
import com.infectapp.domain.repository.Repository

class GetNewsListUseCase(private val repository: Repository) : EmaUseCase<RequestNewsList, Unit>() {
    override suspend fun useCaseFunction(input: RequestNewsList) {
        return repository.getNewsList(input)
    }
}