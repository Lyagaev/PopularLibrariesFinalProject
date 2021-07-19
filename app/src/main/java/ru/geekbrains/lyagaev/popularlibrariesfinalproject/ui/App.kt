package ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui

import android.app.Application
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.AppComponent
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.DaggerAppComponent
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.modules.AppModule
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.db.Database

class App : Application() {

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

}