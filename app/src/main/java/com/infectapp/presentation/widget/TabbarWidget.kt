package com.infectapp.presentation.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.carmabs.ema.android.ui.EmaBaseLayout
import com.infectapp.R
import kotlinx.android.synthetic.main.layout_tabbar.view.*

/**
 * <p>
 * Copyright (c) 2019, Musketeers Inc. All rights reserved.
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

    private val lateralButtons: List<TextViewToogleWidget> by lazy {
        listOf(
                tvTabbarHome,
                tvTabbarNews,
                tvTabbarRanking
        )
    }

    override fun setupAttributes(ta: TypedArray) {

    }

    private fun adjustHeight() {
    }

    override fun getAttributes(): IntArray? = null

    override fun setup(mainLayout: View) {
        lateralButtons.apply {
            forEach {
                val otherViews = lateralButtons.filterNot { view -> view == it }.toTypedArray()
                it.addIncompatibleType(*otherViews)
            }
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        adjustHeight()
        return false
    }

    override fun getLayoutId(): Int = R.layout.layout_tabbar

}
