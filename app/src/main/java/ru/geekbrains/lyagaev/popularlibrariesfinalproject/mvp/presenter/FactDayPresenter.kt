package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.FactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.RetrofitFactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayView


class FactDayPresenter(
    val mainThreadScheduler: Scheduler,
    val factDayRepoRetrofit: RetrofitFactDayRepo,
    val router: Router,
    val factDayRepo: FactDayRepo)
    : MvpPresenter<FactDayView>() {


    override fun onFirstViewAttach() {
        viewState.init()
        loadData()
    }


    fun buttonOneClick() {
        val nextValue = factDayRepo.getUsers()
        viewState.setTextView(nextValue[0].text)
    }

    fun loadData() {
        factDayRepoRetrofit.getDateFact()
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->

                viewState.setTextView(text = repos.number)
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}
