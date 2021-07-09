package ru.geekbrains.lyagaev.popularlibrariesfinalproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.databinding.RvItemBinding
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.presenter.IFactDayListPresenter
import ru.geekbrains.lyagaev.popularlibrariesfinalproject.mvp.view.FactDayItemView

class FactDayRVAdapter(private val presenter: IFactDayListPresenter) : RecyclerView.Adapter<FactDayRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            //itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(private val vb: RvItemBinding) : RecyclerView.ViewHolder(vb.root),
        FactDayItemView {
        override fun setText(text: String) = with(vb) {
            tvSaveFactDay.text = text
        }

        override var pos = -1
    }
}