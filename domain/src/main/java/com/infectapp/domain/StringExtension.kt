package com.infectapp.domain

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

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

fun String.toDate(format: String): Date? {
    val dateFormat = SimpleDateFormat(
            format,
            Locale.ENGLISH
    ) //"03/26/2012 11:49:00 AM"  "MM/dd/yyyy hh:mm:ss aa"
    return try {
        dateFormat.parse(this)
    } catch (e: ParseException) {
        null
    }
}
