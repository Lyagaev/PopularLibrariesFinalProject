package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FactDay(
    val textFactDay: String
) : Parcelable