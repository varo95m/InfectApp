package com.infectapp.domain

import com.infectapp.domain.utils.RegexUtils

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-18
 */

fun String.isEmail(): Boolean = RegexUtils.isEmail(this)