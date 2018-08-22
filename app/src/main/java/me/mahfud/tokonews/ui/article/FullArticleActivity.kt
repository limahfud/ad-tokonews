package me.mahfud.tokonews.ui.article

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_full_article.*
import me.mahfud.tokonews.R

class FullArticleActivity : AppCompatActivity() {

    companion object {
        const val INTENT_ARTICLE_URL = "FullArticleActivity:ArticleUrl"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_article)

        val url = intent.getStringExtra(INTENT_ARTICLE_URL)
        wvArticle.loadUrl(url)
    }
}
