package com.infectapp.presentation.ui

import com.infectapp.presentation.base.BaseViewModel
import com.infectapp.presentation.model.BackModel
import com.infectapp.presentation.model.TabbarModel
import com.infectapp.presentation.model.ToolbarModel
import com.infectapp.presentation.navigation.MainNavigator

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class MainToolbarsViewModel : BaseViewModel<HomeToolbarsState, MainNavigator.Navigation>() {


    fun onActionBackClicked() {
    }

    fun onActionShowTabbar(show: Boolean) {
        onActionUpdateTabbar {
            it.copy(visibility = show)
        }
    }

    fun onActionShowElevation(show: Boolean) {
        updateToNormalState {
            copy(toolbarModel = toolbarModel.copy(elevation = show))
        }
    }

    fun onActionHandleBack(update: (currentBackModel: BackModel) -> BackModel) {
        checkDataState {
            updateToNormalState {
                copy(backModel = update.invoke(backModel))
            }
        }
    }

    fun onActionShowToolbar(show: Boolean, gone: Boolean = true) {
        updateToNormalState {
            copy(toolbarModel = toolbarModel.copy(visibility = show, gone = gone))
        }
    }

    fun onActionUpdateToolbar(update: Boolean = true, updateToolbar: (ToolbarModel) -> ToolbarModel) {
        checkDataState {
            if(update)
                updateToNormalState {
                    copy(toolbarModel = updateToolbar.invoke(it.toolbarModel))
                }
            else
                updateDataState {
                    copy(toolbarModel = updateToolbar.invoke(it.toolbarModel))
                }
        }
    }

    fun onActionUpdateTabbar(updateTabbar: ((TabbarModel) -> TabbarModel)? = null) {

        updateTabbar?.also {
            updateToNormalState {
                val tabbarUpdated = it.invoke(tabbarModel)
                copy(
                        tabbarModel = tabbarUpdated,
                        toolbarModel = toolbarModel.copy(closeSessionVisibility = tabbarUpdated.visibility)
                )
            }
        } ?: updateToNormalState()
    }

    override val initialViewState: HomeToolbarsState = HomeToolbarsState()
}