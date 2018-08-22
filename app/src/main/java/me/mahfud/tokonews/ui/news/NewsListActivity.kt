package me.mahfud.tokonews.ui.news

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news.*
import me.mahfud.tokonews.R
import me.mahfud.tokonews.model.Article

class NewsListActivity : AppCompatActivity(), NewsListView {

    companion object {
        const val INTENT_SOURCE_ID = "NewsListActivity:sourceId"
    }

    private val presenter: NewsPresenter by lazy {
        NewsPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        presenter.getListNews(intent.getStringExtra(INTENT_SOURCE_ID))
    }

    override fun onArticlesReady(articles: List<Article>) {
        rvArticles.layoutManager = LinearLayoutManager(this)
        rvArticles.adapter = NewsListAdapter(articles)
    }
}
