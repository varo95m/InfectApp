package com.infectapp.presentation.widget

import com.infectapp.domain.FLOAT_ZERO
import com.infectapp.domain.INT_ZERO
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener

/**
 * <p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2020-01-30
 */

data class CustomGraphtWidgetModel(
        val axisXDataList: List<Float> = emptyList(),
        val axisYDataList: List<Float> = emptyList(),
        val viewPortCalculationEnabled: Boolean = false,
        val maxGraphY: Float = FLOAT_ZERO,
        val minGraphY: Float = FLOAT_ZERO,
        val lineColor: Int = INT_ZERO,
        val isCubic: Boolean = false,
        val columnIsStacked: Boolean = false,
        val axisYLeftHasLines: Boolean = false,
        val axisXBottomHasLines: Boolean = false,
        val maxGraphX: Float = FLOAT_ZERO,
        val minGraphX: Float = FLOAT_ZERO,
        val onTouchListener: LineChartOnValueSelectListener? = null,
        val axisYasNumberWithPoints: Boolean = false,
        val axisYInterval: Int = INT_ZERO
)
