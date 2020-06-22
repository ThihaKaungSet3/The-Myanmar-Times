package non.shahad.foryou.presentation

import non.shahad.core.extensions.coreComponent
import non.shahad.core.fragment.InjectionFragment
import non.shahad.foryou.R
import non.shahad.foryou.di.DaggerForYouComponent

class ForYouFragment : InjectionFragment<ForYouViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_foryou

    override fun onInitDI() {
        DaggerForYouComponent
            .builder()
            .coreComponent(activity!!.coreComponent())
            .build()
            .inject(this)
    }
}