package ru.geekbrains.poplib.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.navigation.IScreens
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.ui.fragment.FragmentFactDay


class AndroidScreens: IScreens {

    override fun getFragment() = FragmentScreen { FragmentFactDay.newInstance() }

}