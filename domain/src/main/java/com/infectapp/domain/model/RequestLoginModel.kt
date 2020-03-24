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

data class RequestLoginModel(
        val username: String = STRING_EMPTY,
        val password: String = STRING_EMPTY,
        val listener: (Boolean) -> Unit
)
