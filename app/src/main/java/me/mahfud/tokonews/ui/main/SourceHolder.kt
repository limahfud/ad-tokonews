package me.mahfud.tokonews.ui.main

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.layout_source_item.view.*
import me.mahfud.tokonews.model.Source
import me.mahfud.tokonews.ui.news.NewsListActivity

class SourceHolder(private val v: View): RecyclerView.ViewHolder(v) {

    private val intent = Intent(v.context, NewsListActivity::class.java)

    fun bind(source: Source) {
        v.tvSourceTitle.text = source.name
        v.tvSourceUrl.text = source.url
        v.tvSourceDescription.text = source.description

        v.setOnClickListener {
            intent.putExtra(NewsListActivity.INTENT_SOURCE_ID, source.id)
            v.context.startActivity(intent)
        }
    }
}