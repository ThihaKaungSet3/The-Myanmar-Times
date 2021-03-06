package non.shahad.section.presentation

import non.shahad.core.extensions.coreComponent
import non.shahad.core.fragment.InjectionFragment
import non.shahad.section.R
import non.shahad.section.databinding.FragmentSectionBinding
import non.shahad.section.di.DaggerSectionComponent

class SectionFragment : InjectionFragment<SectionViewModel,FragmentSectionBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_section

    override fun onInitDI() {
        DaggerSectionComponent
            .builder()
            .coreComponent(requireActivity().coreComponent())
            .build()
            .inject(this)
    }
}