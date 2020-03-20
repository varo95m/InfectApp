package com.infectapp.domain.exceptions

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

class NoInternetException(
        message: String = "No internet connection is available"
) : IOException(message)