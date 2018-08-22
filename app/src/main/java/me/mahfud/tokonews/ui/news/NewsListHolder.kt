package me.mahfud.tokonews.ui.news

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_article_item.view.*
import me.mahfud.tokonews.model.Article
import me.mahfud.tokonews.ui.article.FullArticleActivity

class NewsListHolder(val view: View): RecyclerView.ViewHolder(view) {
    private val intent = Intent(view.context, FullArticleActivity::class.java)

    fun bind(article: Article) {
        view.tvArticleListTitle.text = article.title
        view.tvArticleListAuthor.text = "By ${article.author}"

        Glide.with(view.context).load(article.urlToImage)
                .apply(RequestOptions().centerCrop())
                .into(view.ivArticleListImage)

        view.setOnClickListener {
            intent.putExtra(FullArticleActivity.INTENT_ARTICLE_URL, article.url)
            view.context.startActivity(intent)
        }
    }
}