package ru.geekbrains.lyagaev.popularlibrariesfinalproject.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
class RoomFactDay(
    var text: String,
    var date: Date
)