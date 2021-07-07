package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.entity.FactDay

interface IFactDayRepo {
    fun getDateFact(): Single<FactDay>
}