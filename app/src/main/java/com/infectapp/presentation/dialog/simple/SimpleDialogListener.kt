package com.infectapp.presentation.dialog.simple

import com.carmabs.ema.core.dialog.EmaDialogListener

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */
interface SimpleDialogListener : EmaDialogListener {
    fun onCancelClicked()
    fun onConfirmClicked()
}