package com.infectapp.presentation.model

import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.INT_ZERO

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */
data class ActivityResultHandlerModel(
        val id: Int,
        val implementation: ((Int, Result, Any?) -> Boolean) //RETURN TRUE IF IT IS REMOVE AFTER CONSUMED
) {
    sealed class Result(val code: Int) {

        object Success : Result(INT_NEGATIVE)

        object Fail : Result(INT_ZERO)

        class Other(code: Int) : Result(code)
    }
}