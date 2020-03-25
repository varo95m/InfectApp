package com.infectapp.data.repository

import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.RequestCreateAccountModel
import com.infectapp.domain.model.RequestLoginModel
import com.infectapp.domain.repository.Repository

class MockRepository : Repository {
    override suspend fun createAccount(requestCreateAccountModel: RequestCreateAccountModel) {}

    override suspend fun login(requestLoginModel: RequestLoginModel) {}

    override suspend fun getInfectedList(): List<InfectedUserModel> {
        return listOf(
            InfectedUserModel(
                username = "prueba",
                totalInfected = 1234,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba1",
                totalInfected = 5432,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba2",
                totalInfected = 234,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba3",
                totalInfected = 1323,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba4",
                totalInfected = 3,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba5",
                totalInfected = 43,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba6",
                totalInfected = 2,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba7",
                totalInfected = 2,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba8",
                totalInfected = 234,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba9",
                totalInfected = 43,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba10",
                totalInfected = 234,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba11",
                totalInfected = 54,
                country = "España"
            ),
            InfectedUserModel(
                username = "prueba12",
                totalInfected = 23,
                country = "España"
            )
        )
    }

}