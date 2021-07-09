package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.IItemView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayItemView

interface IListPresenter<V : IItemView> {
    fun bindView(view: V)
    fun getCount(): Int
}

interface IFactDayListPresenter : IListPresenter<FactDayItemView>
