package non.shahad.core.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import non.shahad.core.store.RefreshPolicy
import non.shahad.core.store.TimeBasedRefreshPolicy
import kotlin.time.ExperimentalTime


@Module
class RepositoryModule {

    @ExperimentalTime
    @Provides
    @Reusable
    fun refreshPolicy(): RefreshPolicy{
        return TimeBasedRefreshPolicy()
    }

    @Provides
    @Reusable
    fun provideLongLifeTimeScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }
}