package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRoomFactDayCache {
    fun getFactDay(): Single<List<String>>

    fun putFactDay(id: Long, text: String) : Completable

}