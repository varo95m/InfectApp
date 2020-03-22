package com.infectapp.presentation.ui.main

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.model.InfectedUserModel


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

data class MainState(
    var totalUsersList: List<InfectedUserModel>? = null,
    var podiumUsersList: List<InfectedUserModel>? = null,
    var otherUsersList: List<InfectedUserModel>? = null,
    var userLogged : InfectedUserModel? = null
) : EmaBaseState {

}