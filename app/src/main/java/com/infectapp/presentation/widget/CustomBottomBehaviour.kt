package com.infectapp.presentation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior


/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class CustomBottomBehaviour<V : View> : BottomSheetBehavior<V> {

    constructor() : super()
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)

    var onNestedClickEvent : (()->Unit)?=null
}