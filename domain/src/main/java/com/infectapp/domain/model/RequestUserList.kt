package com.infectapp.domain.model

/**
 * <p>
 * Copyright (c) 2020, Musketeers Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2020-01-07
 */

data class RequestUserList(
        val listener: (MutableList<InfectedUserModel>) -> Unit
)
