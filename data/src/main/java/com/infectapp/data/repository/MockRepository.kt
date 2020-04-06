package com.infectapp.data.repository

import com.infectapp.domain.model.RequestCreateAccountModel
import com.infectapp.domain.model.RequestLoginModel
import com.infectapp.domain.model.RequestTotalInfectedModel
import com.infectapp.domain.model.RequestUserList
import com.infectapp.domain.repository.Repository

class MockRepository : Repository {
    override suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel) {}

    override suspend fun login(requestLoginModel: RequestLoginModel) {}

    override suspend fun getInfectedList(requestUserList: RequestUserList) {}

    override suspend fun getTotalInfected(requestTotalInfectedModel: RequestTotalInfectedModel) {
        requestTotalInfectedModel.listener.invoke(10)
    }

}