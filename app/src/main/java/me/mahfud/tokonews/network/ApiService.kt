package me.mahfud.tokonews.network
import io.reactivex.Single
import me.mahfud.tokonews.network.response.ArticlesResponse
import me.mahfud.tokonews.network.response.SourceListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/sources")
    fun getSources(): Single<SourceListResponse>

    @GET("v2/everything")
    fun getArticles(@Query("sources") sources: String,
                    @Query("q") query: String = ""): Single<ArticlesResponse>
}