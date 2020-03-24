package com.infectapp.domain

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-18
 */

fun String.isValidEmail(): Boolean {
    val regex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return regex.toRegex().matches(this)
}
