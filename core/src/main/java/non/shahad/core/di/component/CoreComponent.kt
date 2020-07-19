package non.shahad.core.di.component

import android.app.Application
import android.content.Context
import dagger.Component
import kotlinx.coroutines.CoroutineScope
import non.shahad.core.di.module.ContextModule
import non.shahad.core.di.module.CoreModule
import non.shahad.core.di.module.RepositoryModule
import non.shahad.core.di.module.ViewModelModule
import non.shahad.core.store.RefreshPolicy
import retrofit2.Retrofit
import javax.inject.Singleton
import kotlin.time.ExperimentalTime


@Singleton
@Component(modules = [CoreModule::class, ContextModule::class,ViewModelModule::class,RepositoryModule::class])
interface CoreComponent {

    fun inject(app: Application)

    fun getRetrofit() : Retrofit
    fun context(): Context
    fun refreshPolicy(): RefreshPolicy
    fun provideLongLifeTimeScope(): CoroutineScope

}