package non.shahad.foryou.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import non.shahad.core.fragment.InjectionFragment
import non.shahad.foryou.R

class ForYouFragment : InjectionFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_foryou

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes,container,false)
    }
}