package non.shahad.core.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import non.shahad.core.fragment.InjectionFragment

abstract class MVIFragment<STATE,EFFECT,EVENT,viewBinding: ViewDataBinding,ViewModel: MVIViewModel<STATE,EFFECT,EVENT>> :
        InjectionFragment<ViewModel,viewBinding>(){


    private val viewStateObserver = Observer<STATE> {
        renderViewState(it)
    }

    private val viewEffectObserver = Observer<EFFECT> {
        renderViewEffect(it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Registering observers
        viewModel.viewStates().observe(viewLifecycleOwner, viewStateObserver)
        viewModel.viewEffects().observe(viewLifecycleOwner, viewEffectObserver)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun renderViewState(viewState: STATE)

    abstract fun renderViewEffect(viewEffect: EFFECT)
}