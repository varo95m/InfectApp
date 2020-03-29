package com.infectapp.presentation.ui.main.ranking

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.model.InfectedUserModel

data class RankingState(
    var totalUsersList: List<InfectedUserModel>? = null,
    var podiumUsersList: List<InfectedUserModel>? = null,
    var otherUsersList: List<InfectedUserModel>? = null,
    var userLogged : InfectedUserModel? = null,
    var otherUserData : InfectedUserModel? = null
) : EmaBaseState
