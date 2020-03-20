package com.infectapp.presentation.base

import android.app.Activity
import android.content.Intent
import com.carmabs.ema.android.ui.EmaToolbarFragmentActivity
import com.infectapp.presentation.inject.injectionActivityModule
import com.infectapp.presentation.model.ActivityResultHandlerModel
import org.kodein.di.Kodein

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

abstract class BaseActivity : EmaToolbarFragmentActivity() {

    private val resultHandler: HashMap<Int, ActivityResultHandlerModel> = HashMap()

    override val overrideTheme: Boolean = true

    override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module = injectionActivityModule(this)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val remove = resultHandler[requestCode]?.implementation?.invoke(requestCode, parseResultCode(resultCode), data)
                ?: false
        if (remove) removeActivityResultHandler(requestCode)
    }

    fun addActivityResultHandler(activityResultHandlerModel: ActivityResultHandlerModel) {
        resultHandler[activityResultHandlerModel.id] = activityResultHandlerModel
    }

    fun removeActivityResultHandler(id: Int) {
        resultHandler.remove(id)
    }

    private fun parseResultCode(code: Int): ActivityResultHandlerModel.Result {
        return when (code) {
            Activity.RESULT_OK -> ActivityResultHandlerModel.Result.Success
            Activity.RESULT_CANCELED -> ActivityResultHandlerModel.Result.Fail
            else -> ActivityResultHandlerModel.Result.Other(code)
        }
    }
}