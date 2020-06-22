package non.shahad.today.di

import dagger.Binds
import dagger.Module
import non.shahad.today.data.repository.TodayRepository
import non.shahad.today.data.repository.TodayRepositoryImpl

@Module
abstract class RepositoryModule {
    @TodayScope
    @Binds
    abstract fun todayRepository(impl: TodayRepositoryImpl): TodayRepository
}