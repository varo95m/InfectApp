package com.infectapp.presentation.ui.main.home

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.INT_NEGATIVE
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.domain.model.InfectedUserModel


/**
 *
 *
 * @author <a href="mailto:jorgevguerra@hotmail.com">Jorge Valiño Guerra</a>
 */

data class HomeState(
 var userLogged: InfectedUserModel? = null,
 var totalInfected : Int = INT_NEGATIVE,
 var percetangeByUser : Int = INT_NEGATIVE,
 var link: String = STRING_EMPTY
) : EmaBaseState {


}