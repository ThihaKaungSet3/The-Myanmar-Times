package non.shahad.today.domain.model

import non.shahad.today.data.model.News
import non.shahad.today.domain.enums.ViewTypes

data class TodayDataModel (
    val id: Int,
    val viewTypes: ViewTypes,
    val bannerNews: List<News>?,
    val latestNews: List<News>?,
    val regionalNews: List<News>?
)