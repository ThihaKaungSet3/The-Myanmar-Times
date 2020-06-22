package non.shahad.core.di.component

import android.app.Application
import android.content.Context
import dagger.Component
import non.shahad.core.di.module.ContextModule
import non.shahad.core.di.module.CoreModule
import non.shahad.core.di.module.ViewModelModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, ContextModule::class,ViewModelModule::class])
interface CoreComponent {

    fun inject(app: Application)

    fun getRetrofit() : Retrofit
    fun context(): Context

}