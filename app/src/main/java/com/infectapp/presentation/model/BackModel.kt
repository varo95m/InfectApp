package com.infectapp.presentation.model

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */
data class BackModel(
        val disabled: Boolean = false,
        val implementation: (() -> Unit)? = null
)