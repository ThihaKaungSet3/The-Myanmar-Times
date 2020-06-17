package non.shahad.mmtimes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_main.*
import non.shahad.core.fragment.InjectionFragment
import non.shahad.mmtimes.R

class MainFragment : InjectionFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_main

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpNavigation(view)
    }

    private fun setUpNavigation(view: View){
        val mainNavController = view.findViewById<View>(R.id.mainNav).findNavController()

        with(bottomNavigationView){
            setupWithNavController(mainNavController)
            // To avoid fragment recreation when navigation item is reselected
            setOnNavigationItemReselectedListener{

            }
        }

    }
}