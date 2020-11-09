package non.shahad.today.data.repository


import io.reactivex.Single
import non.shahad.today.data.usecase.TodayUseCase
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.repository.TodayRepository
import javax.inject.Inject

/**
 * Inspired
 * https://github.com/ReactiveCircus/streamlined/blob/main/data/src/main/java/io/github/reactivecircus/streamlined/data/repository/StoryRepositoryImpl.kt
 */
internal class TodayRepositoryImpl @Inject constructor(
//    private val latestStore: LatestStore,
//    private val newsByCategoryStore: NewsByCategoryStore,
//    private val refreshPolicy: RefreshPolicy
        private val useCase: TodayUseCase
) : TodayRepository {

    override fun freshHeadlines(): Single<List<NewsDomainModel>> {
        return useCase.freshHeadline()
    }

    override fun cacheOrFreshHeadlines(): Single<List<NewsDomainModel>> {
        return useCase.streamedHeadline()
    }


    override fun considerNewsByCategory(category: String, page: String): List<NewsDomainModel> {
        TODO("Not yet implemented")
    }


}