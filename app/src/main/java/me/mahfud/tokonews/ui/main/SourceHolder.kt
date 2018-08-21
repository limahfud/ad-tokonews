package me.mahfud.tokonews.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.layout_source_item.view.*
import me.mahfud.tokonews.model.Source

class SourceHolder(private val v: View): RecyclerView.ViewHolder(v) {

    fun bind(source: Source) {
        v.tvSourceTitle.text = source.name
        v.tvSourceUrl.text = source.url
        v.tvSourceDescription.text = source.description
    }
}