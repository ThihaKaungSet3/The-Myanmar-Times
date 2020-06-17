package non.shahad.today.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import non.shahad.core.fragment.InjectionFragment
import non.shahad.today.R


class TodayFragment : InjectionFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_today

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes,container,false)
    }
}