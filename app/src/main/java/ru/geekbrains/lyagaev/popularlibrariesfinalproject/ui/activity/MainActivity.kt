package ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.activity

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.R
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.databinding.ActivityMainBinding
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter.MainPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.MainView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.App
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.BackButtonListener
import ru.geekbrains.poplib.navigation.AndroidScreens

class MainActivity : MvpAppCompatActivity(), MainView {
    private var vb: ActivityMainBinding? = null

    val navigatorHolder = App.instance.navigatorHolder
    val navigator = AppNavigator(this, R.id.container)

    val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
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
/*

private val navigator = AppNavigator(this, R.id.container)

private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }
private var vb: ActivityMainBinding? = null

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    vb = ActivityMainBinding.inflate(layoutInflater)
    setContentView(vb?.root)
}

override fun onResumeFragments() {
    super.onResumeFragments()
    App.instance.navigatorHolder.setNavigator(navigator)
}

override fun onPause() {
    super.onPause()
    App.instance.navigatorHolder.removeNavigator()
}

override fun onBackPressed() {
    supportFragmentManager.fragments.forEach {
        if(it is BackButtonListener && it.backPressed()){
            return
        }
    }
    presenter.backClicked()
}*/
