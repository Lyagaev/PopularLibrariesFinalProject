package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo

import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.entity.FactDay

class FactDayRepo {

    private val repositories = listOf(
        FactDay("login1", "", ""),
        FactDay("login2", "", ""),
        FactDay("login3", "", ""),
        FactDay("login4", "", ""),
        FactDay("login5", "", ""),
        FactDay("login6", "", "")
    )

    fun getUsers(): List<FactDay> {
        return repositories
    }
}