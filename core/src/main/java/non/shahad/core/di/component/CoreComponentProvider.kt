package non.shahad.core.di.component

import non.shahad.core.di.component.CoreComponent
import kotlin.time.ExperimentalTime

interface CoreComponentProvider {

    fun provideCoreComponent(): CoreComponent
}