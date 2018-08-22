package me.mahfud.tokonews.ui.news

import me.mahfud.tokonews.model.Article

interface NewsListView {
    fun onArticlesReady(articles: List<Article>)
}