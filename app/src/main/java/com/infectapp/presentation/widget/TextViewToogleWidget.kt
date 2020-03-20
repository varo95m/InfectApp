package com.infectapp.presentation.widget

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.RequiresApi
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

class TextViewToogleWidget : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val incompatibleTexts: MutableList<TextViewToogleWidget> = mutableListOf()
    private val defaultColor: Int = currentTextColor
    private var selectedColor = defaultColor
    @RequiresApi(Build.VERSION_CODES.M)
    var activeColor: Int = resources.getColor(R.color.colorAccent, context.theme)

    init {
        setOnClickListener {
            if (!hasBeenSelected) select()
        }
    }

    var hasBeenSelected: Boolean = false
        private set

    fun select(select: Boolean = true, executeAction: Boolean = true) {
        if (hasBeenSelected != select) {
            if (select) {
                deselectIncompatiblesViews()
                if (executeAction)
                    onTextClickListener?.invoke(select)
            }

        }
        selectedColor = if (select) activeColor else defaultColor
        applyColor()
        hasBeenSelected = select
    }

    fun applyColor() {
        for (drawable in compoundDrawables) {
            drawable?.mutate()?.colorFilter = PorterDuffColorFilter(selectedColor, PorterDuff.Mode.SRC_IN)
        }
        setTextColor(selectedColor)
    }

    private fun deselectIncompatiblesViews() {
        incompatibleTexts.forEach {
            it.hasBeenSelected = false

            for (drawable in it.compoundDrawables) {
                drawable?.mutate()?.colorFilter = PorterDuffColorFilter(it.defaultColor, PorterDuff.Mode.SRC_IN)
            }
            it.setTextColor(it.defaultColor)
        }
    }

    var onTextClickListener: ((Boolean) -> Unit)? = null

    fun addIncompatibleType(vararg incompatible: TextViewToogleWidget) {
        incompatibleTexts.addAll(incompatible)
    }


}