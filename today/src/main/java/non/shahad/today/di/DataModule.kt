package non.shahad.today.di

import com.dropbox.android.external.store4.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import non.shahad.today.data.db.daos.TodayNewsDao
import non.shahad.today.data.db.entities.NewsEntity
import non.shahad.today.data.db.entities.toDomainModel
import non.shahad.today.data.model.NewsDataModel
import non.shahad.today.data.model.toDomainModel
import non.shahad.today.data.model.toEntity
import non.shahad.today.domain.repository.TodayRepository
import non.shahad.today.data.repository.TodayRepositoryImpl
import non.shahad.today.data.retrofit.response.NewsByCategoryResponse
import non.shahad.today.data.retrofit.response.TodayResponse
import non.shahad.today.data.retrofit.service.TodayService
import non.shahad.today.data.store.LatestStore
import non.shahad.today.data.store.NewsByCategoryStore
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.usecase.TodayUseCase
import kotlin.time.ExperimentalTime
import kotlin.time.minutes

@Module
internal abstract class DataModule {

    @TodayScope
    @Binds
    abstract fun todayRepository(impl: TodayRepositoryImpl): TodayRepository

    companion object {

        @ExperimentalTime
        @ExperimentalCoroutinesApi
        @FlowPreview
        @Provides
        @TodayScope
        fun provideCategoryNewsStore(
            todayService: TodayService,
            dao: TodayNewsDao,
            longLifeTimeScope: CoroutineScope
        ) : NewsByCategoryStore {
            return StoreBuilder.from(
                fetcher = nonFlowValueFetcher <Int,List<NewsDataModel>> {
                    todayService.fetchNewsByCategory(it).data
                },
                sourceOfTruth = SourceOfTruth.from<Int,List<NewsDataModel>,List<NewsDomainModel>>(
                    reader = {dao.getNewsByPage(it).map {flow -> flow.map { newsEntity ->  newsEntity.toDomainModel() } }},
                    writer = {page,news -> dao.insertMappedNews(page,news.map { it.toEntity() })},
                    deleteAll = dao::deleteAll
                )
            ).cachePolicy(
                MemoryPolicy.builder()
                    .setExpireAfterAccess(10.minutes)
                    .build()
            )
                .scope(longLifeTimeScope)
                .build()

        }

        @ExperimentalCoroutinesApi
        @FlowPreview
        @Provides
        @TodayScope
        @ExperimentalTime
        fun provideLatestNewsStore(
            todayService: TodayService,
            dao: TodayNewsDao,
            longLifeTimeScope: CoroutineScope
        ) : LatestStore {
            return StoreBuilder.from(
                fetcher = nonFlowValueFetcher <Unit,List<NewsDataModel>> {
                    todayService.fetchLatestNews().latestNews
                },
                sourceOfTruth = SourceOfTruth.from<Unit,List<NewsDataModel>,List<NewsDomainModel>>(
                    reader = {dao.getLatestNews("latest").map {flow -> flow.map { newsEntity ->  newsEntity.toDomainModel() } }},
                    writer = {_,news -> dao.insertLatestNews(news.map { it.toEntity() })},
                    deleteAll = dao::deleteAll
                )
            ).cachePolicy(
                MemoryPolicy.builder()
                    .setExpireAfterAccess(10.minutes)
                    .build()
            )
                .scope(longLifeTimeScope)
                .build()
        }

    }

}