package non.shahad.today.domain.usecase

import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.model.TodayDomainModel
import non.shahad.today.domain.repository.TodayRepository
import java.io.IOException
import javax.inject.Inject

/**
 * Should be internal class but I have problem while creating viewModels
 */
class TodayUseCase @Inject constructor(
    private val todayRepository: TodayRepository
) {

    suspend fun fetchLatestNews(page: Int): TodayDomainModel {
        return todayRepository.fetchLatestNews(page)
    }

    suspend fun fetchNewsByCategory(page: Int): List<NewsDomainModel>{
        return todayRepository.streamNewsByCategory(page)
    }
}