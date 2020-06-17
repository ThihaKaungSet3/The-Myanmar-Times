package non.shahad.section.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import non.shahad.core.fragment.InjectionFragment
import non.shahad.section.R

class SectionFragment : InjectionFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_section

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes,container,false)
    }
}