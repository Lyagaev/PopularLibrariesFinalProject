package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo


import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.numbersApi.IDataSource

class RetrofitFactDayRepo(private val api: IDataSource) : IFactDayRepo {

    override fun getDateFact() = api.getDateFact().subscribeOn(Schedulers.io())

}