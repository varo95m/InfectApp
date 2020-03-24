package com.infectapp.data.repository

import com.infectapp.domain.model.RequestCreateAccountModel
import com.infectapp.domain.model.RequestLoginModel
import com.infectapp.domain.repository.Repository

class MockRepository : Repository {
    override suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel) {}

    override suspend fun login(requestLoginModel: RequestLoginModel) {}

}