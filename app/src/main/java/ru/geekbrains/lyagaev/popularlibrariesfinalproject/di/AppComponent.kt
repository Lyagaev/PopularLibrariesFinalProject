package ru.geekbrains.lyagaev.popularlibrariesfinalproject.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.modules.*
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter.FactDayPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter.MainPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.activity.MainActivity
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        NavigationModule::class,
        RepoModule::class,
        CacheModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(factDayPresenter: FactDayPresenter)
    fun inject(mainPresenter: MainPresenter)

    //fun inject(usersFragment: UsersFragment)
    //fun inject(userFragment: UserFragment)
    //fun inject(mainActivity: MainActivity)
    //fun inject(repositoryFragment: RepositoryFragment)

}

