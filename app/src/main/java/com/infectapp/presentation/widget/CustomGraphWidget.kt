package com.infectapp.presentation.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import com.carmabs.ema.android.ui.EmaBaseLayout
import com.infectapp.R
import kotlinx.android.synthetic.main.layout_custom_graph_widget.view.*
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener
import lecho.lib.hellocharts.model.*
import kotlin.math.truncate

/**
 * <p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2020-01-30
 */

class CustomGraphWidget : EmaBaseLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var data: CustomGraphtWidgetModel = CustomGraphtWidgetModel()
        set(value) {
            field = value
            if (viewsSetup)
                setupData(value)
        }


    private fun setupData(data: CustomGraphtWidgetModel?) {
        val dataLine = LineChartData()
        val column = ColumnChartData()
        val values = ArrayList<PointValue>()
        val lines = ArrayList<Line>()
        val axisX = ArrayList<AxisValue>()
        val axisY = ArrayList<AxisValue>()
        data?.apply {
            //Dont forget to truncate the number if u want to start in a +X position
            if (axisXDataList.isNotEmpty() && axisYDataList.isNotEmpty()) {
                axisXDataList.forEach {
                    val salary = axisYDataList[axisXDataList.indexOf(it)]
                    values.add(PointValue(it, salary))
                }
            }
            lcCustomGraph.isViewportCalculationEnabled = viewPortCalculationEnabled
            var min = minGraphY
            if (axisYDataList.isNotEmpty()) {
                if (data.axisYasNumberWithPoints) {
                    while (min <= axisYDataList.last() + axisYInterval) {
                        //axisY.add(AxisValue(min, min.toString().fromStringDoubleToIntWithPoint().toCharArray()))
                        min += axisYInterval
                    }
                } else {
                    if (axisYInterval != 0) {
                        while (min <= axisYDataList.last() + axisYInterval) {
                            if (min <= axisYDataList.last() + axisYInterval) axisY.add(AxisValue(min))
                            min += axisYInterval
                        }
                    }
                }
                //to set the interval for start-end, bottom-top
                val viewPort = Viewport(
                        minGraphX, min - axisYInterval,
                        maxGraphX, minGraphY
                )
                if (axisY.isNotEmpty()) {
                    lcCustomGraph.maximumViewport = viewPort
                    lcCustomGraph.currentViewport = viewPort
                }
            }
            //to set the color - cubic (to shoe the lines with a curve or not)
            val line = Line(values).setColor(lineColor).setCubic(isCubic)
            lines.add(line)
            column.isStacked = columnIsStacked
            dataLine.lines = lines
            if (axisXDataList.isNotEmpty()) {
                axisXDataList.forEach {
                    axisX.add(AxisValue(truncate(it)))
                }
            }
            dataLine.axisYLeft = Axis(axisY)
            dataLine.axisXBottom = Axis(axisX)
            //to set the grid lines
            dataLine.axisYLeft.setHasLines(axisYLeftHasLines)
            dataLine.axisXBottom.setHasLines(axisXBottomHasLines)
            lcCustomGraph.onValueTouchListener = onTouchListener
            lcCustomGraph.lineChartData = dataLine
        }
    }

    override fun setup(mainLayout: View) {
        setupData(data)
    }

    override fun setupAttributes(ta: TypedArray) {
    }

    override fun getAttributes(): IntArray? = null

    override fun getLayoutId(): Int = R.layout.layout_custom_graph_widget

    fun setAxisXDataList(axisXDataList: MutableList<Float>) {
        data = data.copy(axisXDataList = axisXDataList)
    }

    fun setAxisYDataList(axisYDataList: MutableList<Float>) {
        data = data.copy(axisYDataList = axisYDataList)
    }

    fun viewPortCalculationEnabled(viewPortCalculationEnabled: Boolean) {
        data = data.copy(viewPortCalculationEnabled = viewPortCalculationEnabled)
    }

    fun setMaxGraphY(maxGraphY: Float) {
        data = data.copy(maxGraphY = maxGraphY)
    }

    fun setMinGraphY(minGraphY: Float) {
        data = data.copy(minGraphY = minGraphY)
    }

    fun lineColor(lineColor: Int) {
        data = data.copy(lineColor = lineColor)
    }

    fun isCubic(isCubic: Boolean) {
        data = data.copy(isCubic = isCubic)
    }

    fun columnIsStacked(columnIsStacked: Boolean) {
        data = data.copy(columnIsStacked = columnIsStacked)
    }

    fun axisYLeftHasLines(axisYLeftHasLines: Boolean) {
        data = data.copy(axisYLeftHasLines = axisYLeftHasLines)
    }

    fun axisXBottomHasLines(axisXBottomHasLines: Boolean) {
        data = data.copy(axisXBottomHasLines = axisXBottomHasLines)
    }

    fun setFinalYear(maxGraphX: Float) {
        data = data.copy(maxGraphX = maxGraphX)
    }

    fun setFirstYear(minGraphX: Float) {
        data = data.copy(minGraphX = minGraphX)
    }

    fun setOnTouchListener(onTouchListener: LineChartOnValueSelectListener) {
        data = data.copy(onTouchListener = onTouchListener)
    }

    fun setAxisYasNumberWithPoints(axisYasNumberWithPoints: Boolean) {
        data = data.copy(axisYasNumberWithPoints = axisYasNumberWithPoints)
    }

    fun setAxisYInterval(axisYInterval: Int) {
        data = data.copy(axisYInterval = axisYInterval)
    }
}