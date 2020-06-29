package non.shahad.today.data.retrofit.response

import com.squareup.moshi.Json
import non.shahad.today.data.model.NewsDataModel
import non.shahad.today.data.model.RegionalDataModel
import non.shahad.today.data.model.toDomainModel
import non.shahad.today.domain.enums.ViewTypes
import non.shahad.today.domain.model.TodayDomainModel

/**
 * Should make data enums on my own
 */
internal data class TodayResponse (
    @field:Json(name = "banner")
    val banner: List<NewsDataModel>?,
    @field:Json(name = "latest_news")
    val latestNews: List<NewsDataModel>?
)

internal fun TodayResponse.toDomainModel(): TodayDomainModel {
    return TodayDomainModel(
        bannerNews = this.banner?.map { it.toDomainModel() },
        latestNews = this.latestNews?.map { it.toDomainModel() }
    )
}


