package com.infectapp.domain.model

import com.infectapp.domain.STRING_EMPTY

/**
 * <p>
 * Copyright (c) 2020, Musketeers Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2020-01-07
 */

data class RequestCurrentUser(
    val listener: (InfectedUserModel) -> Unit,
    val errorListener: (Unit) -> Unit
)
