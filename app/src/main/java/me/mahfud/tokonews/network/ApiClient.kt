package me.mahfud.tokonews.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    companion object {
        private const val REQUEST_TIME_OUT = 60L

        private var retrofit: Retrofit? = null
        private var okHttpClient: OkHttpClient? = null

        fun getClient(): Retrofit? {
            if (okHttpClient == null) initOkHttp()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl("https://newsapi.org/")
                        .client(okHttpClient)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                return retrofit
            }

            return retrofit
        }

        private fun initOkHttp() {
            val httpClient = OkHttpClient().newBuilder().apply {
                connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                writeTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
            }

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(interceptor)

            httpClient.addInterceptor {
                val original = it.request()
                val builder = original.newBuilder().apply {
                    addHeader("Accept", "application/json")
                    addHeader("Content-Type", "application/json")
                    addHeader("Authorization", "daae72a67143418b9630670423845748");
                }

                val request = builder.build()

                return@addInterceptor it.proceed(request)
            }

            okHttpClient = httpClient.build()
        }
    }


}