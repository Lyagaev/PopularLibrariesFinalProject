package ru.geekbrains.lyagaev.popularlibrariesfinalproject.di.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.IRoomFactDayCache
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.RoomFactDayCache
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.db.Database
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.App
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App): Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()


    @Singleton
    @Provides
    fun usersCache(database: Database): IRoomFactDayCache = RoomFactDayCache(database)
}