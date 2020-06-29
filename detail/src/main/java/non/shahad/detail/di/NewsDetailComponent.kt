package non.shahad.detail.di

import dagger.Component
import non.shahad.core.di.component.CoreComponent
import non.shahad.detail.presentation.NewsDetailActivity

@NewsDetailScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [NewsDetailModule::class,DataModule::class,ViewModelModule::class]
)
interface NewsDetailComponent {
    fun inject(detailActivity: NewsDetailActivity)
}