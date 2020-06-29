package non.shahad.today.di

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleCoroutineScope
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineScope
import non.shahad.core.di.component.CoreComponent
import non.shahad.today.domain.exts.RefreshPolicy
import non.shahad.today.presentation.fragment.TodayFragment

@TodayScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [TodayModule::class,DataModule::class]
)
interface TodayComponent {
    fun inject(todayFragment: TodayFragment)
}