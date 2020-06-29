package non.shahad.today.data.retrofit.service

import non.shahad.today.data.retrofit.response.NewsByCategoryResponse
import non.shahad.today.data.retrofit.response.TodayResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Should be internal
 */
internal interface TodayService {

    companion object {
        const val NEWS_CATEGORY_PARAM = "page"

        const val LATEST_NEWS = "latest"
        const val NEWS_BY_CATEGORY = "category/{$NEWS_CATEGORY_PARAM}"
    }

    @GET(LATEST_NEWS)
    suspend fun fetchLatestNews() : TodayResponse


    @GET(NEWS_BY_CATEGORY)
    suspend fun fetchNewsByCategory(
        @Path(NEWS_CATEGORY_PARAM)page: Int
    ) : NewsByCategoryResponse
}