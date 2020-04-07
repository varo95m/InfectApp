package com.infectapp.presentation.ui.main.news

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.domain.model.NewModel

data class NewsState(
        val listNews: List<NewModel> = emptyList()
) : EmaBaseState
