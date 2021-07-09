package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room

import io.reactivex.rxjava3.core.Completable
import java.sql.Date

interface IRoomFactDayCache {
    fun putFactDay(text: String, date: Date) : Completable

}