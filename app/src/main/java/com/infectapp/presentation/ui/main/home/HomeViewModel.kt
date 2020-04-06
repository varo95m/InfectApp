package com.infectapp.presentation.ui.main.home

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.RequestTotalInfectedModel
import com.infectapp.domain.model.RequestUserList
import com.infectapp.domain.INT_ONE
import com.infectapp.domain.model.*
import com.infectapp.domain.usecase.GetCurrentUserUseCase
import com.infectapp.domain.usecase.GetInfectedAtDayUseCase
import com.infectapp.domain.usecase.GetInfectedListUseCase
import com.infectapp.domain.usecase.GetTotalInfectedUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

class HomeViewModel(
    private val getTotalInfectedUseCase: GetTotalInfectedUseCase,
    private val getInfectedListUseCase: GetInfectedListUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val getInfectedAtDayUseCase: GetInfectedAtDayUseCase

) : BaseToolbarsViewModel<HomeState, MainNavigator.Navigation>() {

    override val initialViewState: HomeState = HomeState()

    private var userLoggedInfo = InfectedUserModel()

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
        }, { error -> updateToErrorState(error) })
    }

    private fun onResponseUserList(result: MutableList<InfectedUserModel>) {
        updateDataState {
            copy(userList = result)
        }
        checkDataState { state ->
            state.currentUser?.let {
                updateToNormalState {
                    copy(
                        userPosition = getUserPosition(state.userList, it)
                    )
                }
            }
        }
        executeUseCase {
            getInfectedAtDayUseCase.execute(
                RequestInfectedAtDay(
                    listener = ::onResponseInfectedAtDay,
                    errorListener = ::onError
                )
            )
        }
    }

    private fun getUserPosition(
        result: MutableList<InfectedUserModel>,
        currentUser: InfectedUserModel
    ): String {
        return (result.indexOf(currentUser) + INT_ONE).toString()
    }

    private fun onResponseCurrentUser(result: InfectedUserModel) {
        updateDataState {
            copy(
                currentUser = result
            )
        }
        executeUseCase {
            getInfectedListUseCase.execute(
                RequestUserList(
                    listener = ::onResponseUserList,
                    errorListener = ::onError
                )
            )
        }
    }

    private fun onError(result: Unit) {
    }

    private fun onResponseTotalInfected(result: Int) {
        updateDataState {
            copy(
                totalInfected = result.toString()
            )
        }
        executeUseCase {
            getCurrentUserUseCase.execute(
                RequestCurrentUser(
                    listener = ::onResponseCurrentUser,
                    errorListener = ::onError
                )
            )
        }
    }

    private fun onResponseInfectedAtDay(result: Int) {
        updateToNormalState {
            copy(
                infectedAtDat = result.toString()
            )
        }
    }


    private fun createDynamicLink(userLoggedInfo: InfectedUserModel): String {
        val dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
            .setLink(Uri.parse("https://infectapp.com/usr/" + userLoggedInfo.username))
            .setDomainUriPrefix("https://infectgame.com/usr/")
            // Open links with this app on Android
            .setAndroidParameters(DynamicLink.AndroidParameters.Builder().build())
            .buildDynamicLink()

        return dynamicLink.uri.toString()
    }

    fun onActionRefresh() {
        getInfectedHomeData()
    }

    fun onActionLinkClick() {
        link.let {

        }
    }

    fun onActionShare() {
        checkDataState {
            link?.let { linkUri ->
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, linkUri)
                    type = "text/plain"
                }
                navigate(MainNavigator.Navigation.ShareLink(sendIntent))
            }?: Log.d("DYNAMIC_LINK", "No se puede compartir porque no hay link")
        }
    }

}
