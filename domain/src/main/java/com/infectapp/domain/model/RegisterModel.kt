package com.infectapp.domain.model

import com.infectapp.domain.STRING_EMPTY

data class RegisterModel(
        val username: String = STRING_EMPTY,
        val email: String = STRING_EMPTY,
        val password: String = STRING_EMPTY,
        val creationDate: String = STRING_EMPTY,
        val userLink: String = STRING_EMPTY,
        val infectedBy: String = STRING_EMPTY,
        val country: String = STRING_EMPTY,
        val usersInfected: List<InfectedByUserModel> = emptyList()
)