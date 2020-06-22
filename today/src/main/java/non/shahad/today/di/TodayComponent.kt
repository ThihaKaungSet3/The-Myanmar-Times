package non.shahad.today.di

import dagger.Component
import non.shahad.core.di.component.CoreComponent
import non.shahad.today.presentation.fragment.TodayFragment

@TodayScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [TodayModule::class,RepositoryModule::class]
)
interface TodayComponent {

    fun inject(todayFragment: TodayFragment)
}