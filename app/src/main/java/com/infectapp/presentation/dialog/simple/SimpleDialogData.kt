package com.infectapp.presentation.dialog.simple

import android.graphics.drawable.Drawable
import android.text.SpannableString
import com.carmabs.ema.core.dialog.EmaDialogData
import com.infectapp.presentation.PROPORTION_DIALOG_WIDTH_DEFAULT
import com.infectapp.domain.INT_ZERO
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

data class SimpleDialogData(
    val title: String = STRING_EMPTY,
    val image: Drawable? = null,
    val message: String = STRING_EMPTY,
    val accept: String = STRING_EMPTY,
    override val proportionWidth: Float = PROPORTION_DIALOG_WIDTH_DEFAULT,
    override val proportionHeight: Float? = null) : EmaDialogData {
}