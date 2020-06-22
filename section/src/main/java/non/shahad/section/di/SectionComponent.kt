package non.shahad.section.di

import dagger.Component
import non.shahad.core.di.component.CoreComponent
import non.shahad.section.presentation.SectionFragment

@SectionScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [SectionModule::class]
)
interface SectionComponent {
    fun inject(sectionFragment: SectionFragment)
}