package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.MainView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.navigation.IScreens


class MainPresenter(val router: Router, private val screens: IScreens): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(screens.getFragment())
    }

    fun backClick() {
        router.exit()
    }

}

