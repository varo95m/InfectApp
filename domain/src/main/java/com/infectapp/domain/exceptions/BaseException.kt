package com.infectapp.domain.exceptions

import com.infectapp.domain.INT_ZERO
import java.io.IOException

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

abstract class BaseException(val code: Int = INT_ZERO, val title: String, val description: String) : IOException(description)