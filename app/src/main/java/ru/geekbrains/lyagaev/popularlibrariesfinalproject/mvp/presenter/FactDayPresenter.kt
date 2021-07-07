package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.FactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayView


class FactDayPresenter(val router: Router, val usersRepo: FactDayRepo) : MvpPresenter<FactDayView>() {

    override fun onFirstViewAttach() {
        viewState.init()
            //viewState.showUser(getCurrentUser())
    }

    fun buttonOneClick() {
        val nextValue = usersRepo.getUsers()
        viewState.setTextView(nextValue[0].textFactDay)
    }



    fun backClick(): Boolean {
        router.exit()
        return true
    }
}
