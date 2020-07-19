package non.shahad.today.domain.repository

import com.dropbox.android.external.store4.StoreResponse
import kotlinx.coroutines.flow.Flow
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.model.TodayDomainModel

interface TodayRepository {
    suspend fun fetchLatestNews() : List<NewsDomainModel>
    fun streamLatestNews(): Flow<StoreResponse<List<NewsDomainModel>>>

    suspend fun fetchNewsByCategoryPage(page: Int): List<NewsDomainModel>
    fun streamNewsByCategoryPage(page: Int): Flow<StoreResponse<List<NewsDomainModel>>>

}