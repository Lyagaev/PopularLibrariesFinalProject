package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room

import android.util.Log
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.entity.FactDay
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.db.Database


class RoomFactDayCache(val db: Database) : IRoomFactDayCache {

    override fun getFactDay(): Single<List<String>> = Single.fromCallable{
        db.factDayDao.getAll().map { factDay ->
            factDay.text
        }
    }

    override fun putFactDay(id: Long, text: String): Completable = Completable.fromAction {
        Log.d("myTag", "This is my message");
        val roomFactDay = text.map { factDay -> RoomFactDay(id, text) }

        db.factDayDao.insert( RoomFactDay(id, text))
        Log.d("myTag", "This is my message");
    }.subscribeOn(Schedulers.io())


}