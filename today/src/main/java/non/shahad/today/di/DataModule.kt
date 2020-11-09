package non.shahad.today.di

import dagger.Binds
import dagger.Module
import non.shahad.today.domain.repository.TodayRepository
import non.shahad.today.data.repository.TodayRepositoryImpl

@Module
internal abstract class DataModule {

    @TodayScope
    @Binds
    abstract fun todayRepository(impl: TodayRepositoryImpl): TodayRepository

    companion object {

    }

}