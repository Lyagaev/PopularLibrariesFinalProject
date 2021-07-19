package ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.modules

import dagger.Module
import dagger.Provides
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.numbersApi.IDataSource
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.IFactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.RetrofitFactDayRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun factDayRepo(api: IDataSource): IFactDayRepo = RetrofitFactDayRepo(api)

}