package com.infectapp.presentation.ui

import android.content.Context
import android.util.TypedValue

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

fun Int.toDp(context: Context):Int {
    return Math.round(TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,toFloat(),context.resources.displayMetrics))
}
