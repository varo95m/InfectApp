package com.infectapp.presentation.dialog.loading

import android.view.View
import com.carmabs.ema.android.ui.dialog.EmaBaseDialog
import com.infectapp.R
import kotlinx.android.synthetic.main.dialog_loading.view.*

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */
class LoadingDialog : EmaBaseDialog<LoadingDialogData>() {

    override val layoutId: Int = R.layout.dialog_loading
    
    override fun setupData(data: LoadingDialogData, view: View) {
    }
}