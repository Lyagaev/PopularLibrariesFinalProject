package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.IFactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayItemView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.IRoomFactDayCache


class FactDayPresenter(
    val mainThreadScheduler: Scheduler,
    val factDayRepoRetrofit: IFactDayRepo,
    val router: Router,
    val cache: IRoomFactDayCache
)
    : MvpPresenter<FactDayView>() {

    class UsersListPresenter : IFactDayListPresenter {
        val factDay = mutableListOf<String>()

        override fun getCount() = factDay.size

        override fun bindView(view: FactDayItemView) {
            val factDatItem = factDay[view.pos]
            factDatItem?.let { view.setText(it) }
        }
    }

    var factDayListPresenter = UsersListPresenter()
    var factDayPresenter = ""

    override fun onFirstViewAttach() {
        viewState.init()
        loadDataCache()
        loadData()
    }

    private fun loadDataCache() {
        //disposable =
            cache
                .getFactDay().subscribeOn(Schedulers.io())
                .observeOn(mainThreadScheduler)
                .subscribe( { users -> subscribeUsers(users) },
                    {
                        it.printStackTrace()
                    })
    }

    private fun subscribeUsers(factDay: List<String>) {
        factDayListPresenter.factDay.clear()
        factDayListPresenter.factDay.addAll(factDay)
        viewState.updateList()
    }


    fun buttonOneClick() {
        loadData()
    }

    fun saveInDB() {
       cache.putFactDay(0, factDayPresenter).toSingleDefault(factDayPresenter)
    }

    private fun loadData() {
        factDayRepoRetrofit.getDateFact()
            .observeOn(mainThreadScheduler)
            .subscribe({ repos ->
                factDayPresenter=repos.text
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
