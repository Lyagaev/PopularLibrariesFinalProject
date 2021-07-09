package ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FactDayView: MvpView {
    fun init()
    fun setTextView(text: String)

}
