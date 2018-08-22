package me.mahfud.tokonews.ui.main

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import me.mahfud.tokonews.R
import me.mahfud.tokonews.model.Source
import me.mahfud.tokonews.network.ApiClient
import me.mahfud.tokonews.network.ApiService
import me.mahfud.tokonews.network.response.SourceListResponse
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {

    companion object {
        private const val MY_REQUEST_INTERNET_CODE = 80
    }

    private val presenter by lazy {
        MainPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {



            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.INTERNET), MY_REQUEST_INTERNET_CODE)
        } else {
            presenter.getSourceList()
        }

    }

    override fun onSourcesReady(sources: List<Source>) {
        val layoutManager = LinearLayoutManager(this)

        val sourceListAdapter = SourceAdapter(sources)

        rvListSources.layoutManager = layoutManager
        rvListSources.adapter = sourceListAdapter
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            MY_REQUEST_INTERNET_CODE -> {
                presenter.getSourceList()
            }
        }
    }
}
