package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FactDay(
    @Expose val text: String,
    @Expose val year: String,
    @Expose val number: String
) : Parcelable