package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.MainView
import ru.geekbrains.poplib.navigation.Screens
import ru.terrakok.cicerone.Router

class MainPresenter(val router: Router): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.FactDayScreen())
    }

    fun backClick() {
        router.exit()
    }

}