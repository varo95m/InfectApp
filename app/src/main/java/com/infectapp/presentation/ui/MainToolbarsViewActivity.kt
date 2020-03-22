package com.infectapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.carmabs.ema.android.extra.EmaReceiverModel
import com.carmabs.ema.android.extra.EmaResultModel
import com.carmabs.ema.android.ui.EmaView
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.presentation.base.BaseActivity
import com.infectapp.presentation.model.BackModel
import com.infectapp.presentation.model.ButtonColor
import com.infectapp.presentation.model.ToolbarModel
import com.infectapp.presentation.navigation.MainNavigator
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.R
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_tabbar.*
import kotlinx.android.synthetic.main.toolbar.*
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

class MainToolbarsViewActivity : BaseActivity(), EmaView<HomeToolbarsState, MainToolbarsViewModel, MainNavigator.Navigation> {
    override fun onSingleEvent(data: EmaExtraData) {
    }

    override val viewModelSeed: MainToolbarsViewModel by instance()

    override val navigator: MainNavigator by instance()

    override val inputState: HomeToolbarsState? = null

    private var bottomViewMargin: Int = 0

    private var backModel: BackModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel(this)
        bottomViewMargin = (navHostFragment.view?.layoutParams as? ConstraintLayout.LayoutParams)?.bottomMargin
                ?: 0
    }

    private var vm: MainToolbarsViewModel? = null

    override fun onViewModelInitialized(viewModel: MainToolbarsViewModel) {
        vm = viewModel
        setupToolbar(viewModel)
    }

    private fun setupToolbar(viewModel: MainToolbarsViewModel) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val backVisibility = true
                    //destination.id != R.id.homeFragment
            //False to avoid screen update and change title effect flash
            viewModel.onActionUpdateToolbar(false) {
                it.copy(
                        backVisibility = backVisibility,
                        title = destination.label?.toString() ?: STRING_EMPTY
                )
            }
        }
        bToolbarSettings.setOnClickListener {
        }
        imToolbarBack.setOnClickListener {
        }
    }

    override val navGraph: Int =R.navigation.navigation_main

    override fun onBackPressed() {
        backModel?.let {
            if (!it.disabled) {
                checkBackImplementation()
            }
        } ?: onBackSystemPressed()

    }

    private fun checkBackImplementation() {
        backModel?.implementation?.invoke() ?: onBackSystemPressed()
    }

    override fun onStateNormal(data: HomeToolbarsState) {
        if (checkToolbarVisibility(data)) {
            updateToolbar(data.toolbarModel)
        }
        checkTabbarVisibility(data)
        updateTabbar(data)
        backModel = data.backModel
    }

    private fun updateTabbar(data: HomeToolbarsState) {
        //tabbar move
        setTabbarButtonColor(data)
    }

    private fun setTabbarButtonColor(data: HomeToolbarsState) {
    }

    private fun checkTabbarVisibility(data: HomeToolbarsState) {
//        if (data.tabbarModel.visibility)
//            showTabbar()
//        else
//            hideTabbar()
    }

    private fun checkToolbarVisibility(data: HomeToolbarsState): Boolean {
        val visibility = data.toolbarModel.visibility
        val gone = data.toolbarModel.gone
        if (visibility)
            showToolbar()
        else
            hideToolbar(gone)

        return visibility
    }

    private fun updateToolbar(data: ToolbarModel) {
        val title = data.title
        if (title.isEmpty()) {
            tvToolbarTitle.visibility = View.GONE
            ivToolbarLogo.visibility = View.VISIBLE

        } else {
            ivToolbarLogo.visibility = View.GONE
            tvToolbarTitle.visibility = View.VISIBLE
        }
        toolbarLayout.elevation = 0f
        tvToolbarTitle.text = title
        imToolbarBack.visibility = if (data.backVisibility) View.VISIBLE else View.GONE
    }

    override fun onStateError(error: Throwable) {

    }

    private fun onBackSystemPressed() {
        vm?.onActionBackClicked()
    }

    override fun provideFixedToolbarTitle(): String? = STRING_EMPTY

    override val layoutId = R.layout.activity_main
//
//    private fun showTabbar() {
//        (navHostFragment.view?.layoutParams as? ConstraintLayout.LayoutParams)?.bottomMargin = bottomViewMargin
//        clTabbar.visibility = View.VISIBLE
//    }
//
//    private fun hideTabbar() {
//        (navHostFragment.view?.layoutParams as? ConstraintLayout.LayoutParams)?.bottomMargin = 0
//        clTabbar.visibility = View.GONE
//    }

    override var previousState: HomeToolbarsState? = null

    override fun onResultReceiverInvokeEvent(emaReceiverModel: EmaReceiverModel) {
    }

    override fun onResultSetEvent(emaResultModel: EmaResultModel) {

    }


    override fun onStateAlternative(data: EmaExtraData) {

    }
}