package non.shahad.today.presentation.fragment

import android.os.Bundle
import android.view.View
import non.shahad.core.extensions.coreComponent
import non.shahad.core.fragment.InjectionFragment
import non.shahad.core.mvi.MVIFragment
import non.shahad.today.R
import non.shahad.today.databinding.FragmentTodayBinding
import non.shahad.today.di.DaggerTodayComponent
import non.shahad.today.di.TodayModule
import non.shahad.today.di.inject
import non.shahad.today.presentation.fragment.viewstates.TodayViewEffect
import non.shahad.today.presentation.fragment.viewstates.TodayViewEvent
import non.shahad.today.presentation.fragment.viewstates.TodayViewState
import non.shahad.today.presentation.fragment.viewstates.TodayViewStatus

class TodayFragment :
MVIFragment<TodayViewState,TodayViewEffect,TodayViewEvent,FragmentTodayBinding,TodayViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_today


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onInitDI() {
        inject()
    }

    override fun renderViewState(viewState: TodayViewState) {
        TODO("Not yet implemented")
    }

    override fun renderViewEffect(viewEffect: TodayViewEffect) {
        TODO("Not yet implemented")
    }

}