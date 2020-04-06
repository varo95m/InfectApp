package com.infectapp.presentation.ui.main.home

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.model.InfectedUserModel


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

data class HomeState(
        val userLogged: InfectedUserModel? = null,
        val totalInfected: Int = INT_ZERO,
        val percetangeByUser: Int = INT_ZERO,
        val userList: MutableList<InfectedUserModel> = mutableListOf()
 var link: String = STRING_EMPTY
) : EmaBaseState {


}