package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.numbersApi

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.entity.FactDay

interface IDataSource {
    @GET("/7/6/date?json")
    fun getDateFact(): Single<FactDay>
}