package com.infectapp.presentation.ui.main.home

import android.os.Bundle
import android.view.View
import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.R
import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.fromDateToddMMYY
import com.infectapp.domain.model.InfectedByUserModel
import com.infectapp.domain.toDate
import com.infectapp.presentation.KODEIN_TAG_DIALOG_LOADING
import com.infectapp.presentation.base.BaseToolbarsFragment
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.generic.instance
import androidx.lifecycle.Observer
import java.util.*


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class HomeViewFragment :
    BaseToolbarsFragment<HomeState, HomeViewModel, MainNavigator.Navigation>() {

    override val viewModelSeed: HomeViewModel by instance()

    override val navigator: MainNavigator by instance()

    private var vm: HomeViewModel? = null

    override val layoutId: Int get() = R.layout.fragment_home

    private val loadingDialog: EmaDialogProvider by instance(tag = KODEIN_TAG_DIALOG_LOADING)


    override fun onInitializedWithToolbarsManagement(
        viewModel: HomeViewModel,
        mainToolbarViewModel: MainToolbarsViewModel
    ) {
        vm = viewModel
        vm?.getDescriptionLiveData()?.observe(this, Observer {linkCreate ->
            vm?.updateLink(linkCreate)
        })
        refreshHome.setOnRefreshListener { viewModel.onActionRefresh() }
        ivHomeShare.setOnClickListener { viewModel.onActionShare() }
    }

    override fun onNormal(data: HomeState) {
        tvHomeTotalInfected.text = data.totalInfected
        tvHomePosition.text = data.userPosition
        data.currentUser?.apply {
            tvHomeInfectedByMe.text = usersInfected.size.toString()
            tvHomeInfectedByMeToday.text = getUsersInfectedToday(usersInfected)
            setGraph(usersInfected)
        }
        ivHomeShare.visibility =
            data.link.let {
                if (it != null) View.VISIBLE else View.GONE
            }
        tvHomeInfectedAtDay.text = getString(R.string.home_infected_at_day, data.infectedAtDat)
        loadingDialog.hide()
    }

    private fun setGraph(usersInfected: List<InfectedByUserModel>) {
        val usersNumber = getUsersInfectedByDay(usersInfected)
        val dateNumber = getTotalDays(usersInfected)
        cgwHomeGraph.setAxisYDataList(usersNumber)
        cgwHomeGraph.setAxisXDataList(dateNumber)
        cgwHomeGraph.setAxisYInterval(1)
        cgwHomeGraph.axisXBottomHasLines(true)
        cgwHomeGraph.axisYLeftHasLines(true)
        cgwHomeGraph.lineColor(requireContext().getColor(R.color.white))
        cgwHomeGraph.columnIsStacked(true)
        cgwHomeGraph.setFirstYear(dateNumber[0] - 1)
        cgwHomeGraph.setFinalYear(dateNumber.last() + 1)
        cgwHomeGraph.isCubic(true)
    }

    private fun getUsersInfectedByDay(usersInfected: List<InfectedByUserModel>): MutableList<Float> {
        val finalList = mutableListOf<Float>()
        var aux = INT_ZERO
        while (aux < usersInfected.size) {
            val tempList = usersInfected.count { it.date == usersInfected[aux].date }
            finalList.add(tempList.toFloat())
            aux += tempList
        }
        return finalList
    }

    private fun getTotalDays(usersInfected: List<InfectedByUserModel>): MutableList<Float> {
        val finalList = mutableListOf<Float>()
        var aux = INT_ZERO
        while (aux < usersInfected.size) {
            val tempList = usersInfected.count { it.date == usersInfected[aux].date }
            usersInfected[aux].date.toDate("MM/dd/yyyy")?.date?.toFloat()?.let {

                finalList.add(it)
            }
            aux += tempList
        }
        return finalList
    }

    private fun getUsersInfectedToday(usersInfected: List<InfectedByUserModel>): String {
        return usersInfected.filter { it.date == Date().fromDateToddMMYY() }.size.toString()
    }

    override fun onAlternative(data: EmaExtraData) {
        loadingDialog.show()
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }


    override fun onError(error: Throwable): Boolean {
        return false
    }
}
