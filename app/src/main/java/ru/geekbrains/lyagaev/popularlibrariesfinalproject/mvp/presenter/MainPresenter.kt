package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.MainView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.navigation.IScreens
import javax.inject.Inject


class MainPresenter(
        //private val router: Router,
        private val screens: IScreens)
    : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(screens.getFragment())
    }

    fun backClick() {
        router.exit()
    }

}

