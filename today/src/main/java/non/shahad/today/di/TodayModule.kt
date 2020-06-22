package non.shahad.today.di

import dagger.Module
import dagger.Provides
import non.shahad.core.extensions.createViewModel
import non.shahad.today.data.repository.TodayRepository
import non.shahad.today.data.retrofit.service.TodayService
import non.shahad.today.presentation.fragment.TodayFragment
import non.shahad.today.presentation.fragment.TodayViewModel
import retrofit2.Retrofit

@Module
internal class TodayModule(
    val fragment: TodayFragment
) {

        @TodayScope
        @Provides
        fun provideTodayService(retrofit: Retrofit) : TodayService {
            return retrofit.create(TodayService::class.java)
        }

        @TodayScope
        @Provides
        fun provideViewModel(
            todayRepository: TodayRepository
        ) : TodayViewModel = fragment.createViewModel {
            TodayViewModel(todayRepository)
        }


}