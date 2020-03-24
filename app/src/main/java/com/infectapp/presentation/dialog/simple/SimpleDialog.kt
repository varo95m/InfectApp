package com.infectapp.presentation.dialog.simple

import android.view.Gravity
import android.view.View
import com.carmabs.ema.android.ui.dialog.EmaBaseDialog
import com.infectapp.R
import kotlinx.android.synthetic.main.dialog_simple.view.*

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class SimpleDialog : EmaBaseDialog<SimpleDialogData>() {

    override fun setupData(data: SimpleDialogData, view: View) {
        with(data) {
            view.apply {
                (dialogListener as? SimpleDialogListener)?.let { listener ->
                    view.bDialogSimpleButton.setOnClickListener { listener.onConfirmClicked() }
                }
                tvDialogSimpleTitle.text = data.title
                tvDialogSimpleMessage.text = data.message
                imDialogSimple.setImageDrawable(data.image)
            }
        }
    }

    override val layoutId: Int = R.layout.dialog_simple
}