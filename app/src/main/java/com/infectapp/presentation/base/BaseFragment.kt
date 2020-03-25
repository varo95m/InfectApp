package com.infectapp.presentation.base

import android.os.SystemClock
import android.view.View
import com.carmabs.ema.android.ui.EmaFragment
import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.state.EmaBaseState
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.presentation.DEFAULT_CLICK_LISTENER_THRESHOLD
import com.infectapp.presentation.KODEIN_TAG_DIALOG_SIMPLE
import com.infectapp.presentation.dialog.simple.SimpleDialogData
import com.infectapp.presentation.dialog.simple.SimpleDialogListener
import com.infectapp.presentation.inject.generateFragmentModule
import com.infectapp.domain.exceptions.InternalServerException
import com.infectapp.domain.exceptions.NoInternetException
import org.kodein.di.Kodein
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

abstract class BaseFragment<S : EmaBaseState, VM : BaseViewModel<S, NS>, NS : EmaNavigationState> : EmaFragment<S, VM, NS>() {

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module =
        generateFragmentModule(this)

    override val fragmentViewModelScope: Boolean
        get() = true

    private var lastTimeClicked: Long = 0

    private val dialogProvider: EmaDialogProvider by instance(KODEIN_TAG_DIALOG_SIMPLE)

    override fun onStateError(error: Throwable) {
    }

    override fun onStateNormal(data: S) {
        onNormal(data)
    }

    /**
     * We create this abstract function if we want to appy default behaviours in [onStateNormal],[onStateError],[onStateLoading]
     * @param data
     */
    abstract fun onAlternative(data: EmaExtraData)

    abstract fun onNormal(data: S)

    abstract fun onError(error: Throwable): Boolean

    override fun onStateAlternative(data: EmaExtraData) {
        onAlternative(data)
    }

    protected fun View.setOnClickListenerForNavigation(defaultClickIntervalMillis: Long = DEFAULT_CLICK_LISTENER_THRESHOLD, function: (View) -> Unit) {
        setOnClickListener {
            if (SystemClock.elapsedRealtime() - lastTimeClicked >= defaultClickIntervalMillis) {
                lastTimeClicked = SystemClock.elapsedRealtime()
                function.invoke(this)
            }
        }
    }
}

