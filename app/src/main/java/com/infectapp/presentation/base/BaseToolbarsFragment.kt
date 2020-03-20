package com.infectapp.presentation.base

import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.presentation.ui.MainToolbarsViewModel
import org.kodein.di.generic.instance

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

abstract class BaseToolbarsFragment<S : EmaBaseState, VM : BaseToolbarsViewModel<S, NS>, NS : EmaNavigationState> : BaseFragment<S, VM, NS>() {

    lateinit var mainToolbarsVm: MainToolbarsViewModel

    override fun onInitialized(viewModel: VM) {

        (viewModel as? BaseToolbarsViewModel<*, *>)?.also {
            it.mainToolbarsVm = mainToolbarsVm
            onInitializedWithToolbarsManagement(viewModel, mainToolbarsVm)
        } ?: throw RuntimeException("The view model must be inherited from BaseToolbarsViewModel")
    }

    abstract fun onInitializedWithToolbarsManagement(viewModel: VM, mainToolbarViewModel: MainToolbarsViewModel)
}