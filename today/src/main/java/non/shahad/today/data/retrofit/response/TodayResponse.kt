package non.shahad.today.data.retrofit.response

import com.squareup.moshi.Json
import non.shahad.today.data.model.News

data class TodayResponse (
    @field:Json(name = "banner")
    val banner: List<News>?,
    @field:Json(name = "latest_news")
    val latestNews: List<News>?,
    @field:Json(name = "regional_news")
    val regionalNews: List<News>?
)