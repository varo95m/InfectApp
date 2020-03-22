package com.infectapp.presentation.base

import android.content.Context
import android.os.SystemClock
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.carmabs.ema.android.ui.EmaFragment
import com.carmabs.ema.core.dialog.EmaDialogProvider
import com.carmabs.ema.core.navigator.EmaNavigationState
import com.carmabs.ema.core.state.EmaBaseState
import com.carmabs.ema.core.state.EmaExtraData
import com.infectapp.presentation.DEFAULT_CLICK_LISTENER_THRESHOLD
import com.infectapp.presentation.KODEIN_TAG_DIALOG_SIMPLE
import com.infectapp.presentation.dialog.simple.SimpleDialogData
import com.infectapp.presentation.dialog.simple.SimpleDialogListener
import com.infectapp.presentation.generateFragmentModule
import com.infectapp.domain.exceptions.InternalServerException
import com.infectapp.domain.exceptions.NoInternetException
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import java.util.concurrent.TimeoutException

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

    override fun injectFragmentModule(kodein: Kodein.MainBuilder): Kodein.Module = generateFragmentModule(this)

    override val fragmentViewModelScope: Boolean
        get() = true

    private var lastTimeClicked: Long = 0

    private val dialogProvider: EmaDialogProvider by instance(KODEIN_TAG_DIALOG_SIMPLE)

    override fun onStateError(error: Throwable) {
        when (error) {
            is NoInternetException -> onNoInternetException(error)
            is TimeoutException -> onTimeoutException(error)
            is InternalServerException -> onInternalServerException(error)
            is IllegalArgumentException -> onInternalServerException(error)
            else -> {
                if (!onError(error))
                    onInternalServerException(error)
            }
        }
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

    protected open fun onNoInternetException(error: NoInternetException, onAcceptListener: ((EmaDialogProvider) -> Unit)? = null) {
        dialogProvider.show(SimpleDialogData(
                showCross = false
        ))

        dialogProvider.dialogListener = object : SimpleDialogListener {
            override fun onCancelClicked() {
                dialogProvider.hide()
            }

            override fun onConfirmClicked(string: String) {
                onAcceptListener?.invoke(dialogProvider)
                        ?: dialogProvider.hide()
            }

            override fun onBackPressed() {
                dialogProvider.hide()
            }

        }
    }

    protected open fun onInternalServerException(error: Throwable, onAcceptListener: ((EmaDialogProvider) -> Unit)? = null) {
        dialogProvider.show(SimpleDialogData(
                showCross = false
        ))

        dialogProvider.dialogListener = object : SimpleDialogListener {
            override fun onCancelClicked() {
                dialogProvider.hide()
            }

            override fun onBackPressed() {
                dialogProvider.hide()
            }

            override fun onConfirmClicked(string: String) {
                onAcceptListener?.invoke(dialogProvider)
                        ?: dialogProvider.hide()
            }

        }
    }

    protected open fun onTimeoutException(error: TimeoutException, onAcceptListener: ((EmaDialogProvider) -> Unit)? = null) {
        dialogProvider.show(SimpleDialogData(
                showCross = true
        ))

        dialogProvider.dialogListener = object : SimpleDialogListener {
            override fun onCancelClicked() {
                dialogProvider.hide()
            }

            override fun onBackPressed() {
                dialogProvider.hide()
            }

            override fun onConfirmClicked(string: String) {
                onAcceptListener?.invoke(dialogProvider)
                        ?: dialogProvider.hide()
            }

        }
    }

}

