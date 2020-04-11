package com.infectapp.presentation.ui.splash

import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.infectapp.presentation.base.BaseActivity
import com.infectapp.R
import com.infectapp.data.repository.RoomLocalStorageRepository
import com.infectapp.domain.STRING_EMPTY

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-05
 */

class SplashViewActivity : BaseActivity() {

    private val roomLocalStorageRepository = RoomLocalStorageRepository(this)

    override fun provideFixedToolbarTitle(): String? = null

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        super.onCreateActivity(savedInstanceState)
        hideToolbar()
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
                    val protocol: String = deepLink.scheme ?: STRING_EMPTY
                    val server: String = deepLink.authority ?: STRING_EMPTY
                    val path = deepLink.path.split("/usr/")
                    roomLocalStorageRepository.saveInfectedByUser(path[1])
                } else {
                    Log.e("DYNAMIC_LINK", "getDynamicLink: no link found")
                }
                // [END_EXCLUDE]
            }
            .addOnFailureListener(this) { e ->
                Log.e(
                    "DYNAMIC_LINK",
                    "getDynamicLink:onFailure",
                    e
                )
            }
    }

    override val navGraph: Int = R.navigation.navigation_splash
}