package non.shahad.today.domain.usecase

import com.dropbox.android.external.store4.StoreResponse
import kotlinx.coroutines.flow.Flow
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

    suspend fun fetchFreshLatestNews(): List<NewsDomainModel> {
        return todayRepository.fetchLatestNews()
    }

    fun streamLatestNews(): Flow<StoreResponse<List<NewsDomainModel>>>{
        return todayRepository.streamLatestNews()
    }

    fun streamNewsByCategory(page: Int): Flow<StoreResponse<List<NewsDomainModel>>>{
        return todayRepository.streamNewsByCategoryPage(page)
    }

    suspend fun fetchFreshNewsByCategory(page: Int): List<NewsDomainModel>{
        return todayRepository.fetchNewsByCategoryPage(page)
    }
}