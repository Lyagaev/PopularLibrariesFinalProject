package ru.geekbrains.poplib.navigation

import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.fragment.FragmentFactDay
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class FactDayScreen() : SupportAppScreen() {
        override fun getFragment() = FragmentFactDay.newInstance()
    }

}