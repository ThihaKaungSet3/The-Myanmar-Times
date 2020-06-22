package non.shahad.core.di.component

import non.shahad.core.di.component.CoreComponent

interface CoreComponentProvider {
    fun provideCoreComponent(): CoreComponent
}