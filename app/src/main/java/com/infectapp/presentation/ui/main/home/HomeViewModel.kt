package com.infectapp.presentation.ui.main.home

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.infectapp.domain.model.InfectedUserModel
import com.infectapp.domain.model.RequestTotalInfectedModel
import com.infectapp.domain.model.RequestUserList
import com.infectapp.domain.INT_ONE
import com.infectapp.domain.STRING_EMPTY
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

    private val descriptionLiveData = MutableLiveData<String>()
    fun getDescriptionLiveData(): LiveData<String> = descriptionLiveData

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
            createDynamicLink(userLoggedInfo)
        }
        getInfectedHomeData()
    }

    fun updateLink(createLink: String) {
        if (createLink.isNotEmpty()) {
            updateToAlternativeState()
            updateToNormalState {
                copy(
                    link = createLink
                )
            }
        }
    }

    private fun getInfectedHomeData() {
        executeUseCaseWithException({
            getTotalInfectedUseCase.execute(RequestTotalInfectedModel(listener = ::onResponseTotalInfected))
        }, { error -> updateToErrorState(error) })
    }

    private fun onResponseUserList(result: MutableList<InfectedUserModel>) {
        updateToNormalState {
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


    private fun createDynamicLink(userLoggedInfo: InfectedUserModel) {
//        val dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
////            .setLink(Uri.parse("https://infectapp.com/usr/" + userLoggedInfo.username)) // TODO change in pro
//            .setLink(Uri.parse("https://infectapp.com/usr/" + "prueba")) // TODO eliminate in pro
//            .setDomainUriPrefix("https://infectgame.com/usr/")
//            // Open links with this app on Android
//            .setAndroidParameters(DynamicLink.AndroidParameters.Builder().build())
//            .buildDynamicLink()
//        descriptionLiveData.postValue(dynamicLink.uri.toString())
//        https://infectgame.com/usr/?apn=com.infectapp&link=https%3A%2F%2Finfectapp.com%2Fusr%2Fprueba

        FirebaseDynamicLinks.getInstance().createDynamicLink()
//            .setLongLink(Uri.parse("https://infectgame.com/usr/?apn=com.infectapp&link=https%3A%2F%2Finfectapp.com%2Fusr%2F" + userLoggedInfo.userName)) //TODO change in pre/pro
            .setLongLink(Uri.parse("https://infectgame.com/usr/?apn=com.infectapp&link=https%3A%2F%2Finfectapp.com%2Fusr%2Fprueba2")) //TODO eliminate in pre/pro
            .setDomainUriPrefix("https://infectgame.com/usr/")
            .buildShortDynamicLink()
            .addOnSuccessListener { result ->
                // Short link created
                descriptionLiveData.postValue(result.shortLink.toString())
//                https://infectgame.com/usr/ge3K5RactdyJjZDg7
                val previewLink = result.previewLink.toString()
            }
            .addOnFailureListener {
                Log.e("DYNAMIC_LINK", "No se ha creado")
            }

    }

    fun onActionRefresh() {
        getInfectedHomeData()
    }

    fun onActionShare() {
        checkDataState {
            it.link?.let { linkUri ->
                val textToShare =
                    "Atrévete con este nuevo juego y ponte primero en el ranking mundial !! \n\n$linkUri"
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, textToShare)
                    type = "text/plain"
                }
                navigate(MainNavigator.Navigation.ShareLink(sendIntent))
            } ?: Log.d("DYNAMIC_LINK", "No se puede compartir porque no hay link")
        }
    }

}
