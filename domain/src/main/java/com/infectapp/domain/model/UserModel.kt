package com.infectapp.domain.model

import com.infectapp.domain.STRING_EMPTY
import java.io.Serializable

data class UserModel(
        val country: String = STRING_EMPTY,
        val creationDate: String = STRING_EMPTY,
        val email: String = STRING_EMPTY,
        val infectedBy: String = STRING_EMPTY,
        val password: String = STRING_EMPTY,
        val userLink: String = STRING_EMPTY,
        val username: String = STRING_EMPTY
) : Serializable