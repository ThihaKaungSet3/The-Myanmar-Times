package non.shahad.today.domain.repository

import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.model.TodayDomainModel

interface TodayRepository {
    suspend fun fetchLatestNews(page: Int) : TodayDomainModel
    suspend fun streamNewsByCategory(page: Int): List<NewsDomainModel>

}