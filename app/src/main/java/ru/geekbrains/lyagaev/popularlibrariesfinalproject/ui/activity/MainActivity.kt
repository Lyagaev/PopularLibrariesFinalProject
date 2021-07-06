package ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.activity

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.R
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter.MainPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.MainView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.App
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.BackButtonListener
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val navigatorHolder = App.instance.navigatorHolder
    val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    val presenter by moxyPresenter {
        MainPresenter(App.instance.router)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }


    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClick()
    }
}