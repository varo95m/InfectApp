package com.infectapp.presentation.dialog.simple

import android.text.method.ScrollingMovementMethod
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.carmabs.ema.android.ui.dialog.EmaBaseDialog
import com.infectapp.R
import kotlinx.android.synthetic.main.dialog_simple.*
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

            (dialogListener as? SimpleDialogListener)?.let { listener ->
            }

            (dialogListener as? SimpleDialogListener)?.let { listener ->
            }
        }
    }

    private fun assignGravity(gravity: SimpleDialogData.Gravity): Int {
        return when (gravity) {
            SimpleDialogData.Gravity.LEFT -> Gravity.START
            SimpleDialogData.Gravity.CENTER -> Gravity.CENTER
            SimpleDialogData.Gravity.RIGHT -> Gravity.END
            SimpleDialogData.Gravity.JUSTIFIED -> Gravity.FILL
        }
    }

    override val layoutId: Int = R.layout.dialog_simple
}