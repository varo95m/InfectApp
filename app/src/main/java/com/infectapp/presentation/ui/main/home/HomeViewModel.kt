package com.infectapp.presentation.ui.main.home

import android.net.Uri
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.model.InfectedUserModel
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
//    private val getUserLoggedUseCase: GetUserLoggedUseCase,//el usuario logueado
//    private val getTotalInfectedUseCase: GetTotalInfectedUseCase//el numero total de infectados
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
            link = createDynamicLink(userLoggedInfo)
        }
    }

    private fun getInfectedHomeData() {
        executeUseCaseWithException({
            checkDataState { state ->
//                userLoggedInfo = getUserLoggedUseCase.execute(state.userLogged?.username)
//                totalInfectedInfo = getTotalInfectedUseCase.execute(Unit)
            }
        }, { error -> updateToErrorState(error) })

        updateToNormalState {
            copy(
//                userLogged = userLoggedInfo,
//                totalInfected = totalInfectedInfo,
//                percetangeByUser = calculatePercentage().roundToInt()
            )
        }
    }


    private fun createDynamicLink(userLoggedInfo: InfectedUserModel): Uri {
        val dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
            .setLink(Uri.parse("https://infectapp.com/usr/"))
            .setDomainUriPrefix("https://example.page.link")
            // Open links with this app on Android
            .setAndroidParameters(DynamicLink.AndroidParameters.Builder().build())
            // Open links with com.example.ios on iOS
            .setIosParameters(DynamicLink.IosParameters.Builder("com.example.ios").build())
            .buildDynamicLink()

        return dynamicLink.uri
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
