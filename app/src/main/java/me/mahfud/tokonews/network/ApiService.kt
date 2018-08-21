package me.mahfud.tokonews.network
import io.reactivex.Single
import me.mahfud.tokonews.network.response.SourceListResponse
import retrofit2.http.GET

interface ApiService {

    @GET("v2/sources")
    fun getSources(): Single<SourceListResponse>
}