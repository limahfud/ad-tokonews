package me.mahfud.tokonews.ui.main

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import me.mahfud.tokonews.network.ApiClient
import me.mahfud.tokonews.network.ApiService
import me.mahfud.tokonews.network.response.SourceListResponse

class MainPresenterImpl(private val mainView: MainView): MainPresenter {
    override fun getSourceList() {
        val apiService = ApiClient.getClient()?.create(ApiService::class.java) ?: return

        Log.d("ALI ", "Check point A")
            Log.d("ALI ", "Check point B")

        Thread().run {
            apiService.getSources()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object: DisposableSingleObserver<SourceListResponse>() {
                        override fun onSuccess(t: SourceListResponse) {
                            Log.d("ALI", t.sources.toString())

                            mainView.onSourcesReady(t.sources)
//                            showList(t.sources)

//                            val layoutManager = LinearLayoutManager(this@MainActivity)

//                            val sourceListAdapter = SourceAdapter(t.sources)
//
//                            rvListSources.layoutManager = layoutManager
//                            rvListSources.adapter = sourceListAdapter
                        }

                        override fun onError(e: Throwable) {
                            Log.d("ALI", e.message)
                        }

                    })
        }


    }
}