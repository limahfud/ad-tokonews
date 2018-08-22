package me.mahfud.tokonews.ui.news

import android.app.SearchManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news.*
import me.mahfud.tokonews.R
import me.mahfud.tokonews.model.Article
import org.jetbrains.anko.toast

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

        presenter.getListNews(intent.getStringExtra(INTENT_SOURCE_ID) ?: "abc-news", "")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)

        if (intent == null) return

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            presenter.getListNews("abc-news", query)
        }
    }

    override fun onArticlesReady(articles: List<Article>) {
        rvArticles.layoutManager = LinearLayoutManager(this)
        rvArticles.adapter = NewsListAdapter(articles)

        onSearchRequested()
    }
}
