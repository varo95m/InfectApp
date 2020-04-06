package com.infectapp.presentation.ui.main.ranking

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.model.InfectedUserModel

data class RankingState(
        val usersList: List<InfectedUserModel> = emptyList()
) : EmaBaseState
