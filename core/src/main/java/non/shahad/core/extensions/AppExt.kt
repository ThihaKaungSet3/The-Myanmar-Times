package non.shahad.core.extensions

import android.app.Activity
import non.shahad.core.di.component.CoreComponentProvider
import timber.log.Timber

fun timber(tag: String,msg: String){
    Timber.tag(tag).d(msg)
}


fun Activity.coreComponent() = (applicationContext as? CoreComponentProvider)?.provideCoreComponent()
    ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")