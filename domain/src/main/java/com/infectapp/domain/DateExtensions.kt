package com.infectapp.domain

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

const val DDMMYYYY = "dd/MM/yyyy"

fun Date.fromDateToddMMYY(): String = try {
    val formatter = SimpleDateFormat(DDMMYYYY, Locale.getDefault())
    formatter.format(this)
} catch (e: Exception) {
    STRING_EMPTY
}