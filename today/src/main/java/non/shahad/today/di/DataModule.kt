package non.shahad.today.di

import com.dropbox.android.external.store4.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import non.shahad.today.data.db.daos.TodayNewsDao
import non.shahad.today.data.db.entities.NewsEntity
import non.shahad.today.data.model.NewsDataModel
import non.shahad.today.data.model.toEntity
import non.shahad.today.domain.repository.TodayRepository
import non.shahad.today.data.repository.TodayRepositoryImpl
import non.shahad.today.data.retrofit.response.NewsByCategoryResponse
import non.shahad.today.data.retrofit.response.TodayResponse
import non.shahad.today.data.retrofit.service.TodayService
import non.shahad.today.data.store.NewsByCategoryStore
import non.shahad.today.data.store.TodayStore
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
            todayService: TodayService
        ) : NewsByCategoryStore {
            return StoreBuilder.from(
                fetcher = nonFlowValueFetcher <Int,NewsByCategoryResponse> {
                    todayService.fetchNewsByCategory(it)
                }
            ).cachePolicy(
                MemoryPolicy.builder()
                    .setExpireAfterAccess(10.minutes)
                    .build()
            )
                .build()

        }

    }

}