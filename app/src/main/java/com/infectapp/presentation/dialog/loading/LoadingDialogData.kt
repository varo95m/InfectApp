package com.infectapp.presentation.dialog.loading

import com.carmabs.ema.core.dialog.EmaDialogData
import com.infectapp.presentation.PROPORTION_DIALOG_WIDTH_DEFAULT
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

data class LoadingDialogData(
    val title: String = STRING_EMPTY,
    val message: String = STRING_EMPTY,
    override val proportionWidth: Float = PROPORTION_DIALOG_WIDTH_DEFAULT,
    override val proportionHeight: Float? = null) : EmaDialogData