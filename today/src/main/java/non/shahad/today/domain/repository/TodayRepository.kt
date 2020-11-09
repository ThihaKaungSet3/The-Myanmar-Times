package non.shahad.today.domain.repository

import io.reactivex.Single
import non.shahad.today.domain.model.NewsDomainModel

interface TodayRepository {

    fun freshHeadlines(): Single<List<NewsDomainModel>>

    fun cacheOrFreshHeadlines(): Single<List<NewsDomainModel>>

    fun considerNewsByCategory(
            category: String,
            page: String
    ): List<NewsDomainModel>

}