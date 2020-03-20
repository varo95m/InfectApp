package com.infectapp.presentation.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.carmabs.ema.android.ui.EmaBaseLayout
import com.infectapp.R

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class TabbarWidget : EmaBaseLayout {

    constructor(context: Context) : super(context)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr)

    override fun setupAttributes(ta: TypedArray) {

    }

    private fun adjustHeight() {
    }

    override fun getAttributes(): IntArray? = null

    override fun setup(mainLayout: View) {
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        adjustHeight()
        return false
    }

    override fun getLayoutId(): Int = R.layout.layout_tabbar

}
