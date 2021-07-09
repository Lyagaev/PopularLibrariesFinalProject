package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.dao

import androidx.room.*
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.RoomFactDay
import java.sql.Date

@Dao
interface FactDayDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(factDay: RoomFactDay)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg factDays: RoomFactDay)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(factDays: List<RoomFactDay>)

    @Update
    fun update(factDay: RoomFactDay)

    @Update
    fun update(vararg factDays: RoomFactDay)

    @Update
    fun update(factDays: List<RoomFactDay>)

    @Delete
    fun delete(factDay: RoomFactDay)

    @Delete
    fun delete(vararg factDays: RoomFactDay)

    @Delete
    fun delete(factDays: List<RoomFactDay>)

    @Query("SELECT * FROM RoomFactDay")
    fun getAll(): List<RoomFactDay>

    @Query("SELECT * FROM RoomFactDay WHERE date = :day LIMIT 1")
    fun findByDay(day: Date): List<RoomFactDay>
}

