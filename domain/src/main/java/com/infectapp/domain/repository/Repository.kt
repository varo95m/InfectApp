package com.infectapp.domain.repository

import com.infectapp.domain.model.RequestCreateAccountModel
import com.infectapp.domain.model.RequestLoginModel

interface Repository {

    suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel)

    suspend fun login(requestLoginModel: RequestLoginModel)

    suspend fun getInfectedList(): List<InfectedUserModel>
}