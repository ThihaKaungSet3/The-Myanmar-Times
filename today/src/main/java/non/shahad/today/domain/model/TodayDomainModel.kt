package non.shahad.today.domain.model

import non.shahad.today.domain.enums.ViewTypes

data class TodayDomainModel (
    val latestNews: List<NewsDomainModel>? = null,
    val id: Int = -1
)
