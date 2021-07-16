package ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui

import android.app.Application
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.AppComponent
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.DaggerAppComponent
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.modules.AppModule
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.db.Database

class App : Application() {


   /* {
        companion object {
        lateinit var instance: App
    }

        lateinit var appComponent: AppComponent

        override fun onCreate() {
            super.onCreate()
            instance = this

            appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        }
        */

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.create(this)

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }



/*    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder
        get() = cicerone.getNavigatorHolder()

    val router
        get() = cicerone.router*/



   /* companion object {
        lateinit var instance: App
    }

    //Временно до даггера положим это тут
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder get() = cicerone.navigatorHolder
    val router get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
    }*/

}