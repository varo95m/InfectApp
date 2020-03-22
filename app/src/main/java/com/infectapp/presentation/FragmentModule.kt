package com.infectapp.presentation

import androidx.fragment.app.Fragment
import com.carmabs.ema.core.concurrency.AsyncManager
import com.carmabs.ema.core.concurrency.DefaultAsyncManager
import com.infectapp.presentation.ui.main.MainViewModel
import com.infectapp.presentation.ui.main.home.HomeViewModel
import com.infectapp.presentation.ui.main.login.LoginViewModel
import com.infectapp.presentation.ui.main.news.NewsViewModel
import com.infectapp.presentation.ui.main.ranking.RankingViewModel
import com.infectapp.presentation.ui.splash.SplashViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
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

    bind<MainViewModel>() with provider { MainViewModel() }

    bind<HomeViewModel>() with provider { HomeViewModel() }

    bind<NewsViewModel>() with provider { NewsViewModel() }

    bind<RankingViewModel>() with provider { RankingViewModel() }

    //USE CASE//

}