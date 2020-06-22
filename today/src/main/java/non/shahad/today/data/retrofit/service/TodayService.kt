package non.shahad.today.data.retrofit.service

import non.shahad.today.data.retrofit.response.TodayResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Should be internal
 */
interface TodayService {

    @GET("latest/{page}")
    suspend fun fetchLatestNews(
        @Path("page")page: Int
    ) : TodayResponse
}