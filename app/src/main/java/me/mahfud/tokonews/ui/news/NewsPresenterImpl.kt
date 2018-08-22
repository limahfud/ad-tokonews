package me.mahfud.tokonews.ui.news

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import me.mahfud.tokonews.network.ApiClient
import me.mahfud.tokonews.network.ApiService
import me.mahfud.tokonews.network.response.ArticlesResponse

class NewsPresenterImpl(private val view: NewsListView): NewsPresenter {

    override fun getListNews(sourceId: String) {
        val apiService = ApiClient.getClient()?.create(ApiService::class.java) ?: return

        Thread().run {
            apiService.getArticles(sourceId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object: DisposableSingleObserver<ArticlesResponse>() {
                        override fun onSuccess(t: ArticlesResponse) {
                            view.onArticlesReady(t.articles)
                        }

                        override fun onError(e: Throwable) {
                            Log.d("ALI", e.message)
                        }

                    })
        }
    }

}