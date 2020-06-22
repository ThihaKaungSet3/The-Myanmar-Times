package non.shahad.foryou.di

import dagger.Component
import non.shahad.core.di.component.CoreComponent
import non.shahad.foryou.presentation.ForYouFragment

@ForYouScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [ForYouModule::class,RepositoryModule::class]
)
interface ForYouComponent {
    fun inject(forYouFragment: ForYouFragment)
}