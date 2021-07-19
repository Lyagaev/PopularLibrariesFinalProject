package ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.App

@Module
class AppModule(private val app: App) {

    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    fun app(): App {
       return app
    }

}