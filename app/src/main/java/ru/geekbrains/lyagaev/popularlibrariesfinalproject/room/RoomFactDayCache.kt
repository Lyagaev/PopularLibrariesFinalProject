package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.db.Database
import java.sql.Date


class RoomFactDayCache(val db: Database) : IRoomFactDayCache {

    override fun putFactDay(text: String, date: Date): Completable = Completable.fromAction {
        val roomFactDay = text.map { factDay -> RoomFactDay(text, date) }
        db.factDayDao.insert(roomFactDay)
    }.subscribeOn(Schedulers.io())
}