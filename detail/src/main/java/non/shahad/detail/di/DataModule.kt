package non.shahad.detail.di

import dagger.Binds
import dagger.Module
import non.shahad.detail.data.repository.DetailRepositoryImpl
import non.shahad.detail.domain.repository.DetailRepository

@Module
internal abstract class DataModule {

    @NewsDetailScope
    @Binds
    abstract fun bindDetailRepository(
        detailRepositoryImpl: DetailRepositoryImpl
    ) : DetailRepository


}