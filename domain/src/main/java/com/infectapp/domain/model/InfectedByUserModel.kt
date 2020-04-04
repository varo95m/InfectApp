package com.infectapp.domain.model

import com.infectapp.domain.STRING_EMPTY


/**
 *
 * <p>
 * Copyright (C) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href="mailto:jorge.valino@babel.es">Jorge Valiño Guerra</a>
 */
data class InfectedByUserModel(
        val username: String = STRING_EMPTY,
        val date: String = STRING_EMPTY
)