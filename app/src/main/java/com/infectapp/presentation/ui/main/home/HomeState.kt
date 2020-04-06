package com.infectapp.presentation.ui.main.home

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.INT_ZERO
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.domain.model.InfectedUserModel


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

data class HomeState(
        val currentUser: InfectedUserModel? = null,
        val totalInfected: String = STRING_EMPTY,
        val percetangeByUser: Int = INT_ZERO,
        val infectedAtDat: String = STRING_EMPTY,
        val userList: MutableList<InfectedUserModel> = mutableListOf(),
        val userPosition: String = STRING_EMPTY
 var link: String = STRING_EMPTY
) : EmaBaseState {


}