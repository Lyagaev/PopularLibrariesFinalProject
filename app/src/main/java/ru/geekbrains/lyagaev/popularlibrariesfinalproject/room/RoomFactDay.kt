package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
class RoomFactDay(
    @PrimaryKey (autoGenerate = true)
    var id : Long,
    var text: String
)