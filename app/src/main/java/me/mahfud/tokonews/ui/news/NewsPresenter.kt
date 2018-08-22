package me.mahfud.tokonews.ui.news

interface NewsPresenter {
    fun getListNews(sourceId: String, query: String)
}