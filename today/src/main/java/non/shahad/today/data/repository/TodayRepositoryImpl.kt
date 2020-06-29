package non.shahad.today.data.repository

import com.dropbox.android.external.store4.fresh
import non.shahad.today.data.db.entities.toDomainModel
import non.shahad.today.data.model.toDomainModel
import non.shahad.today.data.retrofit.response.toDomainModel
import non.shahad.today.data.retrofit.service.TodayService
import non.shahad.today.data.store.NewsByCategoryStore
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.repository.TodayRepository
import javax.inject.Inject

internal class TodayRepositoryImpl @Inject constructor(
    private val service: TodayService,
    private val newsByCategoryStore: NewsByCategoryStore
) : TodayRepository {

    override suspend fun fetchLatestNews(page: Int) =
         service.fetchLatestNews().toDomainModel()

    override suspend fun streamNewsByCategory(page: Int): List<NewsDomainModel> {
        return newsByCategoryStore.fresh(page).posts.map { it.toDomainModel() }
    }

}