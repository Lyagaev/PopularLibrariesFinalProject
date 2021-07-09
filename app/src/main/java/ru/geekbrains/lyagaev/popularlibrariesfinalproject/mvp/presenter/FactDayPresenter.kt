package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.IFactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.IRoomFactDayCache
import java.sql.Date
import java.util.*


class FactDayPresenter(
    val mainThreadScheduler: Scheduler,
    val factDayRepoRetrofit: IFactDayRepo,
    val router: Router,
    val cache: IRoomFactDayCache
)
    : MvpPresenter<FactDayView>() {

    var usersListPresenter = ""

    override fun onFirstViewAttach() {
        viewState.init()
        loadData()
    }


    fun buttonOneClick() {
        loadData()
    }

    fun saveInDB() {
        val sqlDate = Date(Calendar.getInstance().timeInMillis)
        cache.putFactDay(usersListPresenter, sqlDate).toSingleDefault(usersListPresenter)
    }

    private fun loadData() {
        factDayRepoRetrofit.getDateFact()
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->
                usersListPresenter=repos.text
                viewState.setTextView(repos.text)
            }, {
                println("Error: ${it.message}")
            })
    }


    fun backClick(): Boolean {
        router.exit()
        return true
    }
}
