package com.infectapp.domain.exceptions

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */
interface ErrorHandler {

    fun getException(code:Int):Throwable
    fun getVerificationLoginException(code: String): Throwable?
}