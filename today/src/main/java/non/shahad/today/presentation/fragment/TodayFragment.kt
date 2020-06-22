package non.shahad.today.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import non.shahad.core.extensions.coreComponent
import non.shahad.core.extensions.timber
import non.shahad.core.fragment.InjectionFragment
import non.shahad.today.R
import non.shahad.today.di.DaggerTodayComponent
import non.shahad.today.di.TodayModule

class TodayFragment : InjectionFragment<TodayViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_today


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timber("Today","$viewModel")
    }

    override fun onInitDI() {
        DaggerTodayComponent
            .builder()
            .coreComponent(requireActivity().coreComponent())
            .todayModule(TodayModule(this))
            .build()
            .inject(this)
    }

}