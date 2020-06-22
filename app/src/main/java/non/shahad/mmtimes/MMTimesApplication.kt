package non.shahad.mmtimes

import android.app.Application
import non.shahad.core.di.module.ContextModule
import non.shahad.core.di.component.CoreComponent
import non.shahad.core.di.component.CoreComponentProvider
import non.shahad.core.di.component.DaggerCoreComponent
import timber.log.Timber


class MMTimesApplication : Application(),
    CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
}