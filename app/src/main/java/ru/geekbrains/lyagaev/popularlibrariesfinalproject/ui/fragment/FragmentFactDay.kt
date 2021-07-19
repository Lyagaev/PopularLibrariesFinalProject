package ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.R
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.adapter.FactDayRVAdapter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.databinding.FragmentFactDayBinding
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.numbersApi.ApiHolder
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.model.repo.RetrofitFactDayRepo
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter.FactDayPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.RoomFactDayCache
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.room.db.Database
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.App
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.BackButtonListener
import javax.inject.Inject


class FragmentFactDay : MvpAppCompatFragment(), FactDayView, BackButtonListener {

    @Inject
    lateinit var router: Router


    private var flag = true
    private var vb: FragmentFactDayBinding? = null
    private val presenter by moxyPresenter {
        FactDayPresenter(
            AndroidSchedulers.mainThread(),
            RetrofitFactDayRepo(ApiHolder.api),
            router,
            RoomFactDayCache(Database.getInstance())
        )
    }
    private var adapter: FactDayRVAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentFactDayBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun init() {
        vb?.rvSave?.layoutManager = LinearLayoutManager(context)
        adapter = FactDayRVAdapter(presenter.factDayListPresenter)
        vb?.rvSave?.adapter = adapter

        vb?.btnNewFact?.setOnClickListener {
            presenter.buttonOneClick()
        }
        vb?.btnStar?.setOnClickListener {
            if (flag){
                presenter.saveInDB()
                vb?.btnStar?.setImageResource(R.drawable.ic_baseline_star_24)
            }
            else
                vb?.btnStar?.setImageResource(R.drawable.ic_baseline_star_border_24);
            flag = !flag;
        }
    }

    override fun setTextView(text: String) {
        vb?.tvFactDay?.text = text
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }


    override fun backPressed() = presenter.backClick()

    companion object {
        fun newInstance() = FragmentFactDay()
    }


}