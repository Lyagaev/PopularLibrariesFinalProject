package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.dao.FactDayDao
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.RoomFactDay

@androidx.room.Database(entities = [RoomFactDay::class], version = 1)
    abstract class Database : RoomDatabase() {
    abstract val factDayDao: FactDayDao

    companion object {
        private const val DB_NAME = "database.db"
        private var instance: Database? = null
        fun getInstance() = instance
            ?: throw RuntimeException("Database has not been created. Please call create(context)")

        fun create(context: Context?) {
            if (instance == null) {
                instance = Room.databaseBuilder(context!!, Database::class.java, DB_NAME)
                    .build()
            }
        }
    }
}