package non.shahad.today.data.retrofit.service

import io.reactivex.Observable
import io.reactivex.Single
import non.shahad.today.data.retrofit.response.HeadlineResponse
import non.shahad.today.data.retrofit.response.NewsByCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Should be internal
 */
internal interface TodayService {

    companion object {
        const val NEWS_CATEGORY_PARAM = "page"
        const val CATEGORY_PARAM = "category"

        const val HEADLINE_NEWS = "news/headlines"
        const val NEWS_BY_CATEGORY = "news"
    }

    @GET(HEADLINE_NEWS)
    fun fetchHeadlinesNews() : Observable<HeadlineResponse>

    @GET(NEWS_BY_CATEGORY)
    suspend fun fetchNewsByCategory(
        @Query(NEWS_CATEGORY_PARAM)page: Int,
        @Query(CATEGORY_PARAM) category: String
    ) : Observable<NewsByCategoryResponse>
}