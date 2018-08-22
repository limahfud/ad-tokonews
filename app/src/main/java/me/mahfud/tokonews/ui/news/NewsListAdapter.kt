package me.mahfud.tokonews.ui.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.mahfud.tokonews.R
import me.mahfud.tokonews.model.Article

class NewsListAdapter(private val articles: List<Article>): RecyclerView.Adapter<NewsListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_article_item, parent, false)

        return NewsListHolder(view)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: NewsListHolder, position: Int) {
        holder.bind(articles[position])
    }
}