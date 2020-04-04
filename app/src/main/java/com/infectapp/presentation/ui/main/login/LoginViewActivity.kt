package com.infectapp.presentation.ui.main.login

/**
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-04
 */

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.infectapp.R
import com.infectapp.domain.STRING_EMPTY
import com.infectapp.presentation.base.BaseActivity


class LoginViewActivity : BaseActivity() {

    override val navGraph: Int = R.navigation.navigation_login

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        super.onCreateActivity(savedInstanceState)

        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                // Get deep link from result (may be null if no link is found)
                var deepLink: Uri? = null
                if (pendingDynamicLinkData != null) {
                    deepLink = pendingDynamicLinkData.link
                }

                // [START_EXCLUDE]
                // Display deep link in the UI
                if (deepLink != null) {
                    val link = deepLink.toString()
                } else {
                    Log.d("DYNAMIC_LINK", "getDynamicLink: no link found")
                }
                // [END_EXCLUDE]
            }
            .addOnFailureListener(this) { e ->
                Log.w(
                    "DYNAMIC_LINK",
                    "getDynamicLink:onFailure",
                    e
                )
            }
    }

    override fun provideFixedToolbarTitle(): String? = STRING_EMPTY
}