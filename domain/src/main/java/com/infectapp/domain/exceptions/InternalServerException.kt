package com.infectapp.domain.exceptions

import com.infectapp.domain.EXCEPTION_CODE_INTERNAL_SERVER

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class InternalServerException(
    code: Int = EXCEPTION_CODE_INTERNAL_SERVER,
    title: String = "Error",
    description: String = "A unknown error has been produced"
) : BaseException(code, title, description)