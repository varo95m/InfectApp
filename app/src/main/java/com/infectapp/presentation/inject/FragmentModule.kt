package com.infectapp.presentation.inject

import androidx.fragment.app.Fragment
import com.carmabs.ema.core.concurrency.AsyncManager
import com.carmabs.ema.core.concurrency.DefaultAsyncManager
import com.infectapp.presentation.ui.main.home.HomeViewModel
import com.infectapp.presentation.ui.main.login.LoginViewModel
import com.infectapp.presentation.ui.main.news.NewsViewModel
import com.infectapp.presentation.ui.main.ranking.RankingViewModel
import com.infectapp.presentation.ui.main.register.email.RegisterEmailViewModel
import com.infectapp.presentation.ui.main.register.password.RegisterPasswordViewModel
import com.infectapp.presentation.ui.main.register.start.RegisterStartViewModel
import com.infectapp.presentation.ui.main.register.username.RegisterUsernameViewModel
import com.infectapp.presentation.ui.splash.SplashViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


fun generateFragmentModule(fragment: Fragment) = Kodein.Module(name = "FragmentModule") {

    //FRAGMENT//

    bind<Fragment>() with provider { fragment }

    bind<AsyncManager>() with singleton { DefaultAsyncManager() }

    //FRAGMENT MANAGER//


    //VIEW MODEL//

    bind<SplashViewModel>() with provider { SplashViewModel() }

    bind<LoginViewModel>() with provider { LoginViewModel(instance()) }

    bind<HomeViewModel>() with provider { HomeViewModel(instance()) }

    bind<NewsViewModel>() with provider { NewsViewModel() }

    bind<RankingViewModel>() with provider { RankingViewModel(
        instance(), instance(),
        instance()
    ) }

    bind<RegisterStartViewModel>() with provider { RegisterStartViewModel() }

    bind<RegisterEmailViewModel>() with provider { RegisterEmailViewModel() }

    bind<RegisterUsernameViewModel>() with provider { RegisterUsernameViewModel(instance()) }

    bind<RegisterPasswordViewModel>() with provider { RegisterPasswordViewModel() }

    //USE CASE//

}