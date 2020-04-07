package com.infectapp.data.repository

import com.infectapp.domain.model.*
import com.infectapp.domain.repository.Repository

class MockRepository : Repository {
    override suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel) {}

    override suspend fun login(requestLoginModel: RequestLoginModel) {}

    override suspend fun getInfectedList(requestUserList: RequestUserList) {}

    override suspend fun getTotalInfected(requestTotalInfectedModel: RequestTotalInfectedModel) {
        requestTotalInfectedModel.listener.invoke(10)
    }

    override suspend fun getCurrentUser(requestCurrentUser: RequestCurrentUser) {}

    override suspend fun getInfectedAtDay(requestInfectedAtDay: RequestInfectedAtDay) {}

    override suspend fun getNewsList(requestNewsList: RequestNewsList) {}

}