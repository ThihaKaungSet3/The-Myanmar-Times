package non.shahad.today.domain.model

import non.shahad.today.domain.enums.ViewTypes

data class TodayDomainModel (
    val bannerNews: List<NewsDomainModel>? = null,
    val latestNews: List<NewsDomainModel>? = null,
    val id: Int = -1,
    val viewTypes: ViewTypes = ViewTypes.BANNER
)
