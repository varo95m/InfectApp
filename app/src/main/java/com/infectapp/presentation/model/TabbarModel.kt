package com.infectapp.presentation.model

import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.STRING_EMPTY
import java.io.Serializable

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

data class TabbarModel(
        val visibility: Boolean = true,
        val buttons: List<TabbarButtonModel> = emptyList(), /*Buttons starting from left to right, no center button included*/
        val expandedTexts: List<TabbarTextExpandedModel> = emptyList(),
        val buttonColor: ButtonColor = ButtonColor.FIRST
) : Serializable

enum class ButtonColor {
    FIRST, SECOND, THIRD, FOURTH
}

data class TabbarButtonModel(
    val text: String = STRING_EMPTY,
    val icon: Int = INT_NEGATIVE,
    val clickListener: ((Boolean) -> Unit)? = null,
    val selected: Boolean = false
) : Serializable

data class TabbarTextExpandedModel(
    val text: String = STRING_EMPTY,
    val clickListener: (() -> Unit)? = null
) : Serializable