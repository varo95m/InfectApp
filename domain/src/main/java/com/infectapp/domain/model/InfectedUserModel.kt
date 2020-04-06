package com.infectapp.domain.model

import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.STRING_EMPTY


/**
 *
 * <p>
 * Copyright (C) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:jorge.valino@babel.es">Jorge Valiño Guerra</a>
 */
data class InfectedUserModel(
        val username: String = STRING_EMPTY,
        val totalInfectedByUser: Int = INT_ZERO,
        val country: String = STRING_EMPTY,
        val userPosition: Int = INT_ZERO,
        val usersInfected: List<InfectedByUserModel> = emptyList(),
        var isUserLogged: Boolean = false
)