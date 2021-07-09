package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view

interface IItemView {
    var pos: Int
}

interface FactDayItemView: IItemView {
    fun setText(text: String)

}