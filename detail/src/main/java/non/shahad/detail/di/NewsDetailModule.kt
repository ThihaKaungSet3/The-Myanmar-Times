package non.shahad.detail.di

import dagger.Module
import dagger.Provides
import non.shahad.detail.data.retrofit.DetailService
import retrofit2.Retrofit

@Module
internal class NewsDetailModule {

    @NewsDetailScope
    @Provides
    fun provideDetailService(retrofit: Retrofit) : DetailService {
        return retrofit.create(DetailService::class.java)
    }

}