package non.shahad.mmtimes.presentation

import android.os.Bundle
import androidx.navigation.Navigation
import non.shahad.core.activity.InjectionActivity
import non.shahad.mmtimes.R

class NavHostActivity : InjectionActivity() {

    override val layoutRes: Int
        get() = R.layout.activity_nav_host

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        wantToMakeStatusBarWhite(true)

        Navigation.findNavController(findViewById(R.id.appNavHost)).navigate(R.id.mainFragment)
    }
}