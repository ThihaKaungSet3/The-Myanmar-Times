package non.shahad.today.data.repository

import com.dropbox.android.external.store4.StoreResponse
import com.dropbox.android.external.store4.fresh
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import non.shahad.today.data.store.LatestStore
import non.shahad.today.data.store.NewsByCategoryStore
import non.shahad.core.store.RefreshPolicy
import non.shahad.core.store.streamWithRefreshPolicy
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.repository.TodayRepository
import javax.inject.Inject

/**
 * Inspired
 * https://github.com/ReactiveCircus/streamlined/blob/main/data/src/main/java/io/github/reactivecircus/streamlined/data/repository/StoryRepositoryImpl.kt
 */
@FlowPreview
internal class TodayRepositoryImpl @Inject constructor(
    private val latestStore: LatestStore,
    private val newsByCategoryStore: NewsByCategoryStore,
    private val refreshPolicy: RefreshPolicy
) : TodayRepository {

    override suspend fun fetchLatestNews(): List<NewsDomainModel> {
        return latestStore.fresh(Unit)
    }

    override fun streamLatestNews(): Flow<StoreResponse<List<NewsDomainModel>>> {
        return latestStore.streamWithRefreshPolicy(Unit,refreshPolicy)
    }

    override suspend fun fetchNewsByCategoryPage(page: Int): List<NewsDomainModel> {
        return newsByCategoryStore.fresh(page)
    }

    override fun streamNewsByCategoryPage(page: Int): Flow<StoreResponse<List<NewsDomainModel>>> {
        return newsByCategoryStore.streamWithRefreshPolicy(page,refreshPolicy)
    }


}