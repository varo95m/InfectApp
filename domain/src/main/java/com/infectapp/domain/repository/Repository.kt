package com.infectapp.domain.repository

import com.infectapp.domain.model.*

interface Repository {

    suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel)

    suspend fun login(requestLoginModel: RequestLoginModel)

    suspend fun getInfectedList(requestUserList: RequestUserList)

    suspend fun getTotalInfected(requestTotalInfectedModel: RequestTotalInfectedModel)

    suspend fun getCurrentUser(requestCurrentUser: RequestCurrentUser)

    suspend fun getInfectedAtDay(requestInfectedAtDay: RequestInfectedAtDay)

    suspend fun getNewsList(requestNewsList: RequestNewsList)
}