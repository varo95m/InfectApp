package com.infectapp.presentation.ui.main.home

import android.net.Uri
import android.util.Log
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.ShortDynamicLink
import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.RequestTotalInfectedModel
import com.infectapp.domain.model.RequestUserList
import com.infectapp.domain.usecase.GetInfectedListUseCase
import com.infectapp.domain.usecase.GetTotalInfectedUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel
import kotlin.math.roundToInt


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class HomeViewModel(
        //private val getUserLoggedUseCase: GetUserLoggedUseCase,//el usuario logueado
        private val getTotalInfectedUseCase: GetTotalInfectedUseCase,
        private val getInfectedListUseCase: GetInfectedListUseCase

) : BaseToolbarsViewModel<HomeState, MainNavigator.Navigation>() {

    override val initialViewState: HomeState = HomeState()

    private var userLoggedInfo = InfectedUserModel()
    private var totalInfectedInfo: Int = INT_NEGATIVE

    private var link: Uri? = null

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        mainToolbarsVm.onActionUpdateToolbar {
            it.copy(
                    visibility = false
            )
        }
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        if (!statePreloaded) {
            updateToAlternativeState()
            getInfectedHomeData()
            updateToNormalState {
                copy(
                    link = createDynamicLink(userLoggedInfo).toString()
                )
            }
        }
        getInfectedHomeData()
    }

    private fun getInfectedHomeData() {
        executeUseCaseWithException({
            getTotalInfectedUseCase.execute(RequestTotalInfectedModel(listener = ::onResponseTotalInfected))
            getInfectedListUseCase.execute(RequestUserList(listener = ::onResponseUserList))
        }, { error -> updateToErrorState(error) })

        updateToNormalState {
            copy(
                    userLogged = userLoggedInfo,
                    totalInfected = totalInfectedInfo,
                    percetangeByUser = calculatePercentage().roundToInt()
            )
        }
    }

    private fun onResponseUserList(result: MutableList<InfectedUserModel>) {
        updateToNormalState {
            copy(
                    userList = result
            )
        }
    }

    private fun onResponseTotalInfected(result: Int) {
        updateToNormalState {
            copy(
                    totalInfected = result
            )
        }
    }


    private fun createDynamicLink(userLoggedInfo: InfectedUserModel): String {
        val dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
            .setLink(Uri.parse("https://infectapp.com/usr/userprueba"))
            .setDomainUriPrefix("https://infectgame.com/usr/")
            // Open links with this app on Android
            .setAndroidParameters(DynamicLink.AndroidParameters.Builder().build())
            .buildDynamicLink()

        return dynamicLink.uri.toString()
    }

//    private fun calculatePercentage(): Double {
//        return if (totalInfectedInfo != 0)
//            ((userLoggedInfo.totalInfectedByUser.toDouble() / totalInfectedInfo.toDouble()) * 100)
//        else
//            DOUBLE_NEGATIVE
//    }

    fun onActionRefresh() {
        getInfectedHomeData()
    }

    fun onActionLinkClick() {
        link.let {

        }
    }

}
