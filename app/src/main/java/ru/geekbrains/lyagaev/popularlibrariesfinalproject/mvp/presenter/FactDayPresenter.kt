package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.FactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayView
import ru.terrakok.cicerone.Router

class FactDayPresenter(val router: Router, val usersRepo: FactDayRepo) : MvpPresenter<FactDayView>() {

    /*override fun onFirstViewAttach() {
        viewState.showUser(getCurrentUser())
    }*/

    fun buttonOneClick() {
        val nextValue = usersRepo.getUsers()
        viewState.setTextView(nextValue[0].toString())
    }



    fun backClick(): Boolean {
        router.exit()
        return true
    }
}
