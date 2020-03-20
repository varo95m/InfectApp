package com.infectapp.presentation.ui

import com.carmabs.ema.core.state.EmaBaseState
import com.infectapp.presentation.model.BackModel
import com.infectapp.presentation.model.TabbarModel
import com.infectapp.presentation.model.ToolbarModel

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

data class HomeToolbarsState(
        val tabbarModel: TabbarModel = TabbarModel(),
        val toolbarModel: ToolbarModel = ToolbarModel(),
        val backModel: BackModel = BackModel()
) : EmaBaseState