package me.mahfud.tokonews.ui.main

import android.content.res.AssetManager
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_source_item.view.*
import me.mahfud.tokonews.R
import me.mahfud.tokonews.model.Source

class SourceAdapter(private val sources: List<Source> = listOf()): RecyclerView.Adapter<SourceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_source_item, parent, false)

        return SourceHolder(view)
    }

    override fun getItemCount(): Int = sources.size

    override fun onBindViewHolder(holder: SourceHolder, position: Int) {
        holder.bind(sources[position])
    }


}