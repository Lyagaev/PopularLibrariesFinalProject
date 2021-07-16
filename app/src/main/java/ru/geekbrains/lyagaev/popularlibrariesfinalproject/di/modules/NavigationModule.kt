package ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.navigation.IScreens
import ru.geekbrains.poplib.navigation.AndroidScreens
import javax.inject.Singleton

@Module
class NavigationModule {

    /*private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    @Provides
    fun navigationHolder() = cicerone.navigatorHolder

    @Provides
    fun router() = cicerone.router*/


    var cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    @Singleton
    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun router(): Router = cicerone.router

    @Singleton
    @Provides
    fun screens(): IScreens = AndroidScreens()





/*
    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder
        get() = cicerone.getNavigatorHolder()

    val router
        get() = cicerone.router
*/



}