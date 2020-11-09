package non.shahad.today.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import non.shahad.core.extensions.createViewModel
import non.shahad.today.data.db.TodayDatabase
import non.shahad.today.data.db.daos.TodayNewsDao
import non.shahad.today.data.retrofit.service.TodayService
import non.shahad.today.domain.repository.TodayRepository
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
            return retrofit
                .create(TodayService::class.java)

        }

        @TodayScope
        @Provides
        fun provideRoomDB(context: Context): TodayDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TodayDatabase::class.java,
                "today-db"
            ).fallbackToDestructiveMigration()
                .build()
        }

        @TodayScope
        @Provides
        fun provideTodayDao(db: TodayDatabase): TodayNewsDao {
            return db.todayDao()
        }

        @TodayScope
        @Provides
        fun provideViewModel(
            repo: TodayRepository
        ) : TodayViewModel = fragment.createViewModel {
            TodayViewModel(repo)
        }


}