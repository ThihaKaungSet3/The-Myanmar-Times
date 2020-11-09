package non.shahad.today.di

import non.shahad.core.extensions.coreComponent
import non.shahad.today.presentation.fragment.TodayFragment

fun TodayFragment.inject(){
    DaggerTodayComponent
            .builder()
            .coreComponent(requireActivity().coreComponent())
            .todayModule(TodayModule(this))
            .build()
            .inject(this)
}