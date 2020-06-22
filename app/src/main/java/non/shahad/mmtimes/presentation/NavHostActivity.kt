package non.shahad.mmtimes.presentation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import non.shahad.core.activity.InjectionActivity
import non.shahad.core.extensions.timber
import non.shahad.mmtimes.R
import non.shahad.mmtimes.data.remote.MMTimesAPI
import javax.inject.Inject
import javax.inject.Provider

class NavHostActivity : InjectionActivity() {

    override val layoutRes: Int
        get() = R.layout.activity_nav_host

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        wantToMakeStatusBarWhite(true)

        Navigation.findNavController(findViewById(R.id.appNavHost)).navigate(R.id.mainFragment)
    }
}