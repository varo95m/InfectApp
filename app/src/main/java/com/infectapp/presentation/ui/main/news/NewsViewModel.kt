package com.infectapp.presentation.ui.main.news

import com.infectapp.domain.model.NewModel
import com.infectapp.domain.model.RequestNewsList
import com.infectapp.domain.usecase.GetNewsListUseCase
import com.infectapp.presentation.base.BaseToolbarsViewModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.presentation.ui.MainToolbarsViewModel


class NewsViewModel(private val getNewsListUseCase: GetNewsListUseCase) : BaseToolbarsViewModel<NewsState, MainNavigator.Navigation>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {
        executeUseCase {
            getNewsListUseCase.execute(RequestNewsList(listener = ::onResponseNewsList, errorListener = ::onError))
        }
    }

    private fun onResponseNewsList(result: List<NewModel>) {
        updateToNormalState {
            copy(
                    listNews = result
            )
        }
    }

    private fun onError(result: Unit) {

    }

    override val initialViewState: NewsState = NewsState()

    fun onActionRefresh() {

    }

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {

    }

}