package non.shahad.core.di.module

import dagger.Module
import dagger.Provides
import non.shahad.core.Network
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class CoreModule {
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Network.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}