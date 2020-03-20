package com.infectapp.presentation.model

import com.infectapp.domain.STRING_EMPTY

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

data class ToolbarModel(
    val backClickListener: (() -> Unit)? = null,
    val backVisibility: Boolean = false,
    val backDrawableCross: Boolean = false,
    val closeSessionVisibility: Boolean = true,
    val title: String = STRING_EMPTY,
    val visibility: Boolean = true,
    val elevation: Boolean = false,
    val gone: Boolean = true
) {
    data class ExitButton(
        val text: String = STRING_EMPTY,
        val onClickListener: (() -> Unit)
    )
}